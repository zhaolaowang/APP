package cn.app.dao.appversion;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import cn.app.pojo.AppInfo;
import cn.app.pojo.AppVersion;

/**
 * 应用版本的映射接口
 * 
 * @author Administrator
 * 
 */
public interface AppVersionMapper {
	/**
	 * 根据app 的编号返回app 的版本信息
	 * 
	 * @param appId
	 * @return
	 */
	ArrayList<AppInfo> getAppVersionByAppId(@Param("appId") Integer appId);

	/**
	 * 根据app版本的编号查询APP版本信息
	 * 
	 * @param versionId
	 * @return
	 */
	AppVersion getAppVersionByVersionId(@Param("versionId") Integer versionId);

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
	 * 新增app版本信息
	 * 
	 * @param appVersion
	 * @return
	 */
	int addVersionSave(AppVersion appVersion);
	
	
	/**
	 * 根据app编号删除app的所有的版本
	 * @param appId
	 * @return
	 */
	int deleteAddVersion(@Param("appId")Integer appId);
}
