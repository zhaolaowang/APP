package cn.app.dao.appinfo;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import cn.app.pojo.AppInfo;

/**
 * 手机信息持久化层的接口
 * 
 * @author Administrator
 * 
 */
public interface AppInfoMapper {

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
	ArrayList<AppInfo> getAppInfo(@Param("softWareName") String softWareName,
			@Param("status") Integer status,
			@Param("flatformId") Integer flatformId,
			@Param("cateGoryLevel1") Integer cateGoryLevel1,
			@Param("cateGoryLevel2") Integer cateGoryLevel2,
			@Param("cateGoryLevel3") Integer cateGoryLevel3,
			@Param("currpage") Integer currpage);

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
	int getAppInfoCount(@Param("softWareName") String softWareName,
			@Param("status") Integer status,
			@Param("flatformId") Integer flatformId,
			@Param("cateGoryLevel1") Integer cateGoryLevel1,
			@Param("cateGoryLevel2") Integer cateGoryLevel2,
			@Param("cateGoryLevel3") Integer cateGoryLevel3);

	/**
	 * 
	 * 返回应用的信息根据apk的
	 * 
	 * @return
	 */
	AppInfo getAppInfoByApkName(@Param("apkName") String apkName);

	/**
	 * 根据app的编号进行查找app的信息
	 * 
	 * @param appInfoId
	 * @return
	 */
	AppInfo getAppInfoById(@Param("appInfoId") Integer appInfoId);

	/**
	 * 根据app 的编号查询app的信息
	 * 
	 * @param appInfoId
	 * @return
	 */
	AppInfo getAppInfoJoinFromById(@Param("appInfoId") Integer appInfoId);

	/**
	 * 新增一个app信息
	 * 
	 * @param appInfo
	 * @return
	 */
	int addAppInfoSave(AppInfo appInfoBean);

	/**
	 * 修改一个app信息
	 * 
	 * @return
	 */
	int updateAppInfo(AppInfo appInfo);

	/**
	 * 清空一个app的logo地址
	 * 
	 * @param appInfoId
	 * @return
	 */
	int emptyAppInfoLogoPath(@Param("id") Integer appInfoId);

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
	 * 修改app 的状态
	 * 
	 * @param appInfoId
	 * @return
	 */
	int upAppInfo(@Param("appInfoId") Integer appInfoId,
			@Param("sale") Integer saleType);

	/**
	 * 根据appInfo编号删除app
	 * @param appInfoId
	 * @return
	 */
	int deleteAppInfo(@Param("appInfoId") Integer appInfoId);

}
