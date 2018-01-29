package cn.app.service.appinfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.app.dao.appinfo.AppInfoMapper;
import cn.app.pojo.AppInfo;
import cn.app.utils.Page;

@Service
public class AppInfoServiceImpl implements AppInfoService {

	@Resource
	private AppInfoMapper appInfoMapper;

	@Override
	public Page getAppInfo(String softWareName, Integer status,
			Integer flatformId, Integer cateGoryLevel1, Integer cateGoryLevel2,
			Integer cateGoryLevel3, Page page) {
		page.setAppInfoList(appInfoMapper.getAppInfo(softWareName, status,
				flatformId, cateGoryLevel1, cateGoryLevel2, cateGoryLevel3,
				(page.getCurrPageNo() - 1) * page.getPageSize()));
		return page;
	}

	@Override
	public int getAppInfoCount(String softWareName, Integer status,
			Integer flatformId, Integer cateGoryLevel1, Integer cateGoryLevel2,
			Integer cateGoryLevel3) {
		return appInfoMapper.getAppInfoCount(softWareName, status, flatformId,
				cateGoryLevel1, cateGoryLevel2, cateGoryLevel3);
	}

	@Override
	public AppInfo getAppInfoByApkName(String apkName) {
		return appInfoMapper.getAppInfoByApkName(apkName);
	}

	@Override
	public int addAppInfoSave(AppInfo appInfoBean) {
		return appInfoMapper.addAppInfoSave(appInfoBean);
	}

	@Override
	public AppInfo getAppInfoById(Integer appInfoId) {
		return appInfoMapper.getAppInfoById(appInfoId);
	}

	@Override
	public int updataAppInfoSave(AppInfo appInfo) {
		return appInfoMapper.updateAppInfo(appInfo);
	}

	@Override
	public int EmptyAppInfoLogoPath(Integer appInfoId) {
		return appInfoMapper.emptyAppInfoLogoPath(appInfoId);
	}

	@Override
	public AppInfo getAppInfoJoinFromById(Integer appInfoId) {
		return appInfoMapper.getAppInfoJoinFromById(appInfoId);
	}

	@Override
	public int modifyAppInfoVersion(Integer appInfoId, Integer appVersionId) {
		return appInfoMapper.modifyAppInfoVersion(appInfoId, appVersionId);
	}

	@Override
	public int upAppInfo(Integer appId, Integer scale) {
		return appInfoMapper.upAppInfo(appId, scale);
	}

	@Override
	public int deleteAppInfo(Integer appId) {
		return appInfoMapper.deleteAppInfo(appId);
	}

}
