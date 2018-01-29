package cn.app.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.app.pojo.AppCategory;
import cn.app.pojo.AppInfo;
import cn.app.pojo.AppVersion;
import cn.app.pojo.DataDictionary;
import cn.app.service.appVersion.AppVersionService;
import cn.app.service.appcategory.AppCateGoryService;
import cn.app.service.appinfo.AppInfoService;
import cn.app.service.dataDictionary.DataDictionaryService;
import cn.app.utils.Page;

@Controller
@RequestMapping("sys/backend")
public class AppInfoControllerBackend {

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

		model.addAttribute("querysoftwareName ", softWareName);
		model.addAttribute("queryStatus", status);
		model.addAttribute("queryFlatformId", flatformId);
		model.addAttribute("queryCategoryLevel1", cateGoryLevel1);
		model.addAttribute("queryCategoryLevel2", cateGoryLevel2);
		model.addAttribute("queryCategoryLevel3", cateGoryLevel3);

		return "backend/appinfolist";
	}

	/**
	 * 审核app 的查询操作
	 * 
	 * @return
	 */
	@RequestMapping("/check")
	public String checkAppInfo(@RequestParam("aid") Integer appId, Model model) {
		AppInfo appInfo = appService.getAppInfoJoinFromById(appId);
		AppVersion appVersion = appVersionService
				.getAppVersionByVersionId(appInfo.getVersionId());
		model.addAttribute("appVersion", appVersion);
		model.addAttribute("appInfo", appInfo);
		return "backend/appcheck";
	}

	@RequestMapping("/checkAppInfoSave")
	public String checkAppInfoSave(@RequestParam("id") Integer appId,
			@RequestParam("status") Integer status) {
		if (appService.upAppInfo(appId, status) >= 1) {
			return "redirect:loadAppInfoList";
		}
		return "backend/check?aid=" + appId;
	}

	// ===============app分类列表的操作================
	// ===========================================
	/**
	 * 根据用户的选择的分类编号查找下级菜单
	 * 
	 * @param parentId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/categorylevellist.json")
	public String findCateGoryByLevel(@RequestParam("pid") Integer parentId) {
		if (null == parentId) {
			parentId = 0;
		}
		return JSON.toJSONString(appCateGoryService
				.getAppCateGoryByParentId(parentId));
	}
	
}
