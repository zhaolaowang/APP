package cn.app.service.appinfo;


import org.apache.ibatis.annotations.Param;

import cn.app.pojo.AppInfo;
import cn.app.utils.Page;

/**
 * 应用信息服务的接口
 * 
 * @author Administrator
 * 
 */
public interface AppInfoService {

	/**
	 * 根据应用信息来查询应用
	 * 
	 * @param softWareName
	 *            软件名称
	 * @param status
	 *            状态
	 * @param flatformId
	 *            所属平台
	 * @param cateGoryLevel1
	 *            分类1
	 * @param cateGoryLevel2
	 *            分类2
	 * @param cateGoryLevel3
	 *            分类3
	 * @return 应用对象
	 */
	Page getAppInfo(String softWareName, Integer status, Integer flatformId,
			Integer cateGoryLevel1, Integer cateGoryLevel2,
			Integer cateGoryLevel3, Page page);

	/**
	 * 根据应用信息来查询应用总数
	 * 
	 * @param softWareName
	 *            软件名称
	 * @param status
	 *            状态
	 * @param flatformId
	 *            所属平台
	 * @param cateGoryLevel1
	 *            分类1
	 * @param cateGoryLevel2
	 *            分类2
	 * @param cateGoryLevel3
	 *            分类3
	 * @return 应用总数
	 */
	int getAppInfoCount(String softWareName, Integer status,
			Integer flatformId, Integer cateGoryLevel1, Integer cateGoryLevel2,
			Integer cateGoryLevel3);

	/**
	 * 根据apkName查询app信息
	 * 
	 * @param apkName
	 * @return
	 */
	AppInfo getAppInfoByApkName(String apkName);

	/**
	 * 根据app的编号进行查找app的信息
	 * 
	 * @param appInfoId
	 * @return
	 */
	AppInfo getAppInfoById( Integer appInfoId);

	/**
	 * 根据app 的编号查询app的信息
	 * @param appInfoId
	 * @return
	 */
	AppInfo getAppInfoJoinFromById( Integer appInfoId);

	
	/**
	 * 新增一个app信息
	 * 
	 * @param appInfo
	 * @return
	 */
	int addAppInfoSave(AppInfo appInfo);

	/**
	 * 修改一个app信息
	 * 
	 * @param appInfo
	 * @return
	 */
	int updataAppInfoSave(AppInfo appInfo);

	/**
	 * 清空一个app的logo地址
	 * 
	 * @param appInfoId
	 * @return
	 */
	int EmptyAppInfoLogoPath(Integer appInfoId);
	
	/**
	 * 更新app 的版本信息
	 * 
	 * @param appInfoId
	 * @param appVersionId
	 * @return
	 */
	int modifyAppInfoVersion(@Param("appId") Integer appInfoId,
			@Param("appVersionId") Integer appVersionId);
	
	/**
	 * 上架app
	 * @param appId
	 * @return
	 */
	int upAppInfo(Integer appId,Integer scale);
	
	/**
	 * 删除app
	 * @param appId
	 * @return
	 */
	int deleteAppInfo(Integer appId);
}
