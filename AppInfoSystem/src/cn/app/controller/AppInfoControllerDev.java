package cn.app.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.app.pojo.AppCategory;
import cn.app.pojo.AppInfo;
import cn.app.pojo.AppVersion;
import cn.app.pojo.DataDictionary;
import cn.app.pojo.DevUser;
import cn.app.service.appVersion.AppVersionService;
import cn.app.service.appcategory.AppCateGoryService;
import cn.app.service.appinfo.AppInfoService;
import cn.app.service.dataDictionary.DataDictionaryService;
import cn.app.utils.FileUtils;
import cn.app.utils.Page;

import com.alibaba.fastjson.JSON;

/**
 * 应用信息的控制层
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("sys/dev")
public class AppInfoControllerDev {

	/**
	 * app服务
	 */
	@Resource
	private AppInfoService appService;
	/**
	 * 数据字典服务
	 */
	@Resource
	private DataDictionaryService dataDictionaryService;
	/**
	 * app分类服务
	 */
	@Resource
	private AppCateGoryService appCateGoryService;
	/**
	 * app版本服务
	 */
	@Resource
	private AppVersionService appVersionService;

	/**
	 * 根据用户选择的条件进行精确查找应用信息
	 * 
	 * @param softWareName
	 *            软件名称
	 * @param status
	 *            状态
	 * @param flatformId
	 *            所属平台
	 * @param cateGoryLevel1
	 *            一级菜单
	 * @param cateGoryLevel2
	 *            二级菜单
	 * @param cateGoryLevel3
	 *            三级菜单
	 * @param currpage
	 *            当前页数
	 * @param model
	 * @return
	 */
	@RequestMapping("/loadAppInfoList")
	public String LoadAppInfoList(
			@RequestParam(value = "querysoftwareName", required = false) String softWareName,
			@RequestParam(value = "queryStatus", required = false) Integer status,
			@RequestParam(value = "queryFlatformId", required = false) Integer flatformId,
			@RequestParam(value = "queryCategoryLevel1", required = false) Integer cateGoryLevel1,
			@RequestParam(value = "queryCategoryLevel2", required = false) Integer cateGoryLevel2,
			@RequestParam(value = "queryCategoryLevel3", required = false) Integer cateGoryLevel3,
			@RequestParam(value = "pageIndex", required = false) Integer currpage,
			Model model) {
		Page page = new Page();

		page.setInfoCount(appService.getAppInfoCount(softWareName, status,
				flatformId, cateGoryLevel1, cateGoryLevel2, cateGoryLevel3));
		if (currpage == null) {
			currpage = 1;
		}
		page.setCurrPageNo(currpage);
		page = appService.getAppInfo(softWareName, status, flatformId,
				cateGoryLevel1, cateGoryLevel2, cateGoryLevel3, page);
		ArrayList<DataDictionary> statusList = dataDictionaryService
				.getDataDictionaryByTypeCode("APP_STATUS");
		page.setCurrPageNo(currpage);
		ArrayList<DataDictionary> flatfromList = dataDictionaryService
				.getDataDictionaryByTypeCode("APP_FLATFORM");
		ArrayList<AppCategory> cateGoryLevel1List = appCateGoryService
				.getAppCateGoryByParentId(0);
		model.addAttribute("pages", page);
		model.addAttribute("statusList", statusList);
		model.addAttribute("flatFormList", flatfromList);
		model.addAttribute("categoryLevel1List", cateGoryLevel1List);

		model.addAttribute("querysoftwareName", softWareName);
		model.addAttribute("queryStatus", status);
		model.addAttribute("queryFlatformId", flatformId);
		model.addAttribute("queryCategoryLevel1", cateGoryLevel1);
		model.addAttribute("queryCategoryLevel2", cateGoryLevel2);
		model.addAttribute("queryCategoryLevel3", cateGoryLevel3);

		return "dev/appinfolist";
	}

	/**
	 * 跳转到新增的页面
	 * 
	 * @param appinfo
	 * @return
	 */
	@RequestMapping("/add")
	public String addInfo(@ModelAttribute AppInfo appinfo) {
		return "dev/appinfoadd";
	}

	/**
	 * 检查用户输入的apk名称是否重复
	 * 
	 * @param apkName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/apkexist.json")
	public String checkApkNameIsExits(@RequestParam("APKName") String apkName) {
		AppInfo appInfo = appService.getAppInfoByApkName(apkName);
		if (appInfo == null) {
			return JSON.toJSONString("exist");
		}
		return JSON.toJSONString("noexist");
	}

	/**
	 * 新增app信息
	 * 
	 * @param appInfo
	 * @param request
	 * @param multipart
	 * @return
	 */
	@RequestMapping("/appInfoAddSave")
	public String addAppInfoSave(AppInfo appInfo, HttpServletRequest request,
			@RequestParam("a_logoPicPath") MultipartFile multipart) {
		int userId = ((DevUser) (request.getSession()
				.getAttribute("devUserSession"))).getId();
		appInfo = FileUtils.setAppFilePath(appInfo, multipart, request);
		if (appInfo == null) {
			return "dev/appinfoadd";
		}
		appInfo.setCreatedBy(userId);
		appInfo.setDevId(userId);
		appInfo.setCreationDate(new Date());
		if (appService.addAppInfoSave(appInfo) >= 1) {
			return "redirect:/sys/dev/loadAppInfoList";
		}
		return "dev/appinfoadd";
	}

	/**
	 * 修改前夕进行查询app的信息
	 * 
	 * @return
	 */
	@RequestMapping("/addSelect")
	public String updateSelectAppInfo(@RequestParam("id") Integer appInfoId,
			Model model) {
		AppInfo appInfo = appService.getAppInfoById(appInfoId);
		model.addAttribute(appInfo);
		return "dev/appinfomodify";
	}

	/**
	 * 清空applogo地址
	 * 
	 * @param appInfoId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delfile.json")
	public String emptyAppInfoLogoPath(@RequestParam("id") Integer appInfoId,
			@RequestParam("flag") String logoPath, HttpServletRequest request) {
		String message = "nulll";
		String[] newString = logoPath.split("/");
		logoPath = request
				.getSession()
				.getServletContext()
				.getRealPath(
						"statics/uploadfiles/"
								+ newString[newString.length - 1]);
		File logo = new File(logoPath);
		try {
			if (logo != null) {
				if (!logo.exists()) {
					message = "nulll";
				} else {
					if (appService.EmptyAppInfoLogoPath(appInfoId) >= 1) {
						logo.delete();
						message = "success";
					} else {
						message = "failed";
					}
				}
			}
		} catch (Exception e) {
			message = "failed";
			e.printStackTrace();
		}
		return JSON.toJSONString(message);
	}

	/**
	 * 修改app信息
	 * 
	 * @param appInfo
	 * @param request
	 * @return
	 */
	@RequestMapping("/appInfoModifySave")
	public String updateModfiyAppInfo(AppInfo appInfo,
			@RequestParam(value = "a_logoPicP") MultipartFile mult,
			@RequestParam(value = "status", required = false) Integer status,
			HttpServletRequest request) {
		int userId = ((DevUser) (request.getSession()
				.getAttribute("devUserSession"))).getId();
		if (null != mult && mult.getSize() > 0) {
			appInfo = FileUtils.setAppFilePath(appInfo, mult, request);
		}
		if (null != status && status == 1) {
			appInfo.setStatus(status);
		}
		appInfo.setModifyBy(userId);
		appInfo.setModifyDate(new Date());
		if (appService.updataAppInfoSave(appInfo) >= 1) {
			return "redirect:/sys/dev/loadAppInfoList";
		}
		return "dev/appinfomodify";
	}

	/**
	 * 查看app信息
	 * 
	 * @param appInfoId
	 * @param model
	 * @return
	 */
	@RequestMapping("/viewAppInfo/{id}")
	public String viewAppInfo(@PathVariable("id") Integer appInfoId, Model model) {
		AppInfo appInfoList = appService.getAppInfoJoinFromById(appInfoId);
		ArrayList<AppInfo> appVersionList = appVersionService
				.getAppVersionByAppId(appInfoId);
		model.addAttribute("appInfo", appInfoList);
		model.addAttribute("appVersionList", appVersionList);
		return "dev/appinfoview";
	}

	/**
	 * 根据编号删除app以及所有的历史版本信息
	 * 
	 * @param appId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delapp.json")
	public String deleteAppInfo(@RequestParam("id") Integer appId) {
		String message = "false";
		appVersionService.deleteAppVersion(appId);
		int num = appService.deleteAppInfo(appId);
		if (num == 0) {
			message = "notexist";
		} else if (num >= 1) {
			message = "true";
		}
		return JSON.toJSONString(message);
	}

	/**
	 * 操作上架下架
	 * 
	 * @param appId
	 * @param saleType
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/sale.json")
	public String updateAppInfoUpOrDown(@RequestParam("id") Integer appId,
			@RequestParam("sale") Integer saleType) {
		String message = "failed";
		if (appService.upAppInfo(appId, saleType) >= 1) {
			message = "success";
		}
		return JSON.toJSONString(message);
	}

	// ===============app分类列表的操作================
	// ===========================================
	/**
	 * 根据用户的选择的分类编号查找下级菜单
	 * 
	 * @param parentId
	 * @return
	 */
	@RequestMapping("categorylevellist.json")
	@ResponseBody
	public String findCateGoryByLevel(@RequestParam("pid") Integer parentId) {
		System.out.println("================================================================>"+parentId);
		if (null == parentId) {
			parentId = 0;
		}
		return JSON.toJSONString(appCateGoryService
				.getAppCateGoryByParentId(parentId));
	}


	// ===============app版本的操作================
	// ========================================
	/**
	 * 加载app版本列表
	 * 
	 * @return
	 */
	@RequestMapping("/appVersionAddSelect")
	public String loadAppVersionList(@RequestParam("id") Integer appId,
			Model model) {
		ArrayList<AppInfo> appVersionList = appVersionService
				.getAppVersionByAppId(appId);
		model.addAttribute("appVersionList", appVersionList);
		model.addAttribute("appId", appId);
		return "dev/appversionadd";
	}

	/**
	 * 进行新增app版本的操作
	 * 
	 * @param appVersion
	 * @param mult
	 * @param appId
	 * @param request
	 * @return
	 */
	@RequestMapping("/addVersionSave")
	public String addAppVersionSave(AppVersion appVersion,
			@RequestParam("a_downloadLink") MultipartFile mult,
			HttpServletRequest request) {
		int userId = ((DevUser) request.getSession().getAttribute(
				"devUserSession")).getId();
		int appId = appVersion.getAppId();
		appVersion = FileUtils.setAppVersionApkPath(appVersion, mult, request);
		if (null == appVersion) {
			return "redirect:/sys/dev/loadAppInfoList";
		}
		appVersion.setAppId(appId);
		appVersion.setCreatedBy(userId);
		appVersion.setCreationDate(new Date());
		if (appVersionService.AddAppVersionSave(appVersion) >= 1) {
			int id = appVersion.getId();
			if (appService.modifyAppInfoVersion(appId, id) >= 1) {
				return "redirect:/sys/dev/loadAppInfoList";
			}
		}
		return "redirect:/sys/dev/loadAppInfoList";
	}

	/**
	 * 查询app版本修改
	 * 
	 * @param appId
	 * @param model
	 * @return
	 */
	@RequestMapping("/appVersionUpdateSelect")
	public String updateAppInfoVersionSelect(
			@RequestParam("aid") Integer appId,
			@RequestParam("vid") Integer appVersionId, Model model) {
		ArrayList<AppInfo> appVersionList = appVersionService
				.getAppVersionByAppId(appId);
		AppVersion appVersion = appVersionService
				.getAppVersionByVersionId(appVersionId);
		model.addAttribute("appVersionList", appVersionList);
		model.addAttribute("appVersion", appVersion);
		return "dev/appversionmodify";
	}

	@ResponseBody
	@RequestMapping("/delAppVersionPath.json")
	public String emptyAppVersionPath(@RequestParam("id") Integer appVersionId,
			@RequestParam("flag") String logoPath, HttpServletRequest request) {
		String message = "nulll";
		String[] newString = logoPath.split("/");
		logoPath = request
				.getSession()
				.getServletContext()
				.getRealPath(
						"statics/uploadfiles/"
								+ newString[newString.length - 1]);
		File logo = new File(logoPath);
		try {
			if (logo != null) {
				if (!logo.exists()) {
					message = "nulll";
				} else {
					if (appVersionService.emptyAppVersionPath(appVersionId) >= 1) {
						logo.delete();
						message = "success";
					} else {
						message = "failed";
					}
				}
			}
		} catch (Exception e) {
			message = "failed";
			e.printStackTrace();
		}
		return JSON.toJSONString(message);
	}

	@RequestMapping("/appVersionUpdateSave")
	public String updateAppInfoVersionSave(AppVersion appVersion,
			@RequestParam("attach") MultipartFile mult,
			HttpServletRequest request) {
		int userId = ((DevUser) (request.getSession()
				.getAttribute("devUserSession"))).getId();
		appVersion = FileUtils.setAppVersionApkPath(appVersion, mult, request);
		if (null == appVersion) {
			return "redirect:/sys/dev/loadAppInfoList";
		}
		appVersion.setModifyBy(userId);
		appVersion.setModifyDate(new Date());
		appVersionService.updateAppVersion(appVersion);
		return "redirect:/sys/dev/loadAppInfoList";
	}
	
	

	// ===============字典的查询操作================
	// ========================================

	/**
	 * 根据词典的类型返回词典的数据
	 * 
	 * @param typeCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/datadictionarylist.json")
	public String getDataByDataCode(@RequestParam("tcode") String typeCode) {
		ArrayList<DataDictionary> dataDictionaryList = dataDictionaryService
				.getDataDictionaryByTypeCode(typeCode);
		String newString = JSON.toJSONString(dataDictionaryList); 
		return newString;
	}
}
