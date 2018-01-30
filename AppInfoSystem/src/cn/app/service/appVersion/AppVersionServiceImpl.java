package cn.app.service.appVersion;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.app.dao.appversion.AppVersionMapper;
import cn.app.pojo.AppInfo;
import cn.app.pojo.AppVersion;

@Service
public class AppVersionServiceImpl implements AppVersionService {

	@Resource
	private AppVersionMapper appVersionMapper;

	@Override
	public ArrayList<AppInfo> getAppVersionByAppId(Integer appId) {
		return appVersionMapper.getAppVersionByAppId(appId);
	}

	@Override
	public int AddAppVersionSave(AppVersion appVersion) {
		return appVersionMapper.addVersionSave(appVersion);
	}

	@Override
	public AppVersion getAppVersionByVersionId(Integer appVersionId) {
		return appVersionMapper.getAppVersionByVersionId(appVersionId);
	}

	@Override
	public int emptyAppVersionPath(Integer appVersionId) {
		return appVersionMapper.emptyAppVersionPath(appVersionId);
	}

	@Override
	public int updateAppVersion(AppVersion appVersion) {
		return appVersionMapper.updateAppVersion(appVersion);
	}

	@Override
	public int deleteAppVersion(Integer appId) {
		return appVersionMapper.deleteAddVersion(appId);
	}

}
