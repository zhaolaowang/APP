package cn.app.service.appVersion;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import cn.app.pojo.AppInfo;
import cn.app.pojo.AppVersion;

/**
 * 信息版本服务接口
 * 
 * @author Administrator
 * 
 */
public interface AppVersionService {

	/**
	 * 根据app 的编号返回app 的版本信息
	 * 
	 * @param appId
	 * @return
	 */
	ArrayList<AppInfo> getAppVersionByAppId(Integer appId);

	/**
	 * 根据app版本编号返回版本对象
	 * 
	 * @param appVersionId
	 * @return
	 */
	AppVersion getAppVersionByVersionId(Integer appVersionId);

	/**
	 * 根据app版本清空app版本的地址
	 * 
	 * @param appVersionId
	 * @return
	 */
	int emptyAppVersionPath(@Param("id") Integer appVersionId);

	/**
	 * 修改app版本
	 * 
	 * @param appVersion
	 * @return
	 */
	int updateAppVersion(AppVersion appVersion);

	/**
	 * 新增一个app版本信息
	 * 
	 * @return
	 */
	int AddAppVersionSave(AppVersion appVersion);

	/**
	 * 根据app编号删除所有的历史版本
	 * 
	 * @param appVersionId
	 * @return
	 */
	int deleteAppVersion(Integer appId);
}
