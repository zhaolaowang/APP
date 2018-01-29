package cn.app.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 应用信息类
 * 
 * @author Administrator
 */
public class AppInfo {
	/**
	 * 应用信息编号
	 */
	private int id;
	/**
	 * 软件名称
	 */
	private String softwareName;
	/**
	 * apk名称（唯一）
	 */
	private String apkName;
	/**
	 * 支持rom
	 */
	private String supportRom;
	/**
	 * 界面语言
	 */
	private String interfaceLanguage;
	/**
	 * 软件大小（单位：M）
	 */
	private BigDecimal softwareSize;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * 开发者编号（来源于：dev_user的开发者编号）
	 */
	private int devId;
	/**
	 * 应用开发简介
	 */
	private String appInfo;
	/**
	 * 状态（来源于：data_dictionary 1.待审核 2.审核通过3.审核不通过4.已上架5.已下架）
	 */
	private int status;
	/**
	 * 状态名称
	 */
	private String statusName;

	/**
	 * 上架时间
	 */
	private Date onsaleDate;
	/**
	 * 下架时间
	 */
	private Date offsaleDate;
	/**
	 * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
	 */
	private int flatformId;

	/**
	 * 所属平台名称
	 */
	private String flatformName;

	public String getFlatformName() {
		return flatformName;
	}

	public void setFlatformName(String flatformName) {
		this.flatformName = flatformName;
	}

	/**
	 * 所属三级分类（来源于：data_dictionary）
	 */
	private int categoryLevel3;

	private String cateGoryLevelName1;

	public String getCateGoryLevelName1() {
		return cateGoryLevelName1;
	}

	public void setCateGoryLevelName1(String cateGoryLevelName1) {
		this.cateGoryLevelName1 = cateGoryLevelName1;
	}

	public String getCateGoryLevelName2() {
		return cateGoryLevelName2;
	}

	public void setCateGoryLevelName2(String cateGoryLevelName2) {
		this.cateGoryLevelName2 = cateGoryLevelName2;
	}

	public String getCateGoryLevelName3() {
		return cateGoryLevelName3;
	}

	public void setCateGoryLevelName3(String cateGoryLevelName3) {
		this.cateGoryLevelName3 = cateGoryLevelName3;
	}

	private String cateGoryLevelName2;
	private String cateGoryLevelName3;
	/**
	 * 下载量（单位：次）
	 */
	private int downloads;
	/**
	 * 创建者（来源于dev_user开发者信息表的用户id）
	 */
	private int createdBy;
	/**
	 * 创建时间
	 */
	private Date creationDate;
	/**
	 * 更新者（来源于dev_user开发者信息表的用户id）
	 */
	private int modifyBy;
	/**
	 * 最新更新时间
	 */
	private Date modifyDate;
	/**
	 * 所属一级分类（来源于：data_dictionary）
	 */
	private int categoryLevel1;
	/**
	 * 所属二级分类（来源于：data_dictionary）
	 */
	private int categoryLevel2;
	/**
	 * LOGO图片url路径
	 */
	private String logoPicPath;
	/**
	 * LOGO图片的服务器存储路径
	 */
	private String logoLocPath;
	/**
	 * 最新的版本id
	 */
	private int versionId;

	/**
	 * 版本名称
	 */
	private String versionNo;

	public String getversionNo() {
		return versionNo;
	}

	public void setversionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getApkName() {
		return apkName;
	}

	public void setApkName(String apkName) {
		this.apkName = apkName;
	}

	public String getSupportRom() {
		return supportRom;
	}

	public void setSupportRom(String supportRom) {
		this.supportRom = supportRom;
	}

	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}

	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}

	public BigDecimal getSoftwareSize() {
		return softwareSize;
	}

	public void setSoftwareSize(BigDecimal softwareSize) {
		this.softwareSize = softwareSize;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getDevId() {
		return devId;
	}

	public void setDevId(int devId) {
		this.devId = devId;
	}

	public String getAppInfo() {
		return appInfo;
	}

	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Date getOnsaleDate() {
		return onsaleDate;
	}

	public void setOnsaleDate(Date onsaleDate) {
		this.onsaleDate = onsaleDate;
	}

	public Date getOffsaleDate() {
		return offsaleDate;
	}

	public void setOffsaleDate(Date offsaleDate) {
		this.offsaleDate = offsaleDate;
	}

	public int getFlatformId() {
		return flatformId;
	}

	public void setFlatformId(int flatformId) {
		this.flatformId = flatformId;
	}

	public int getCategoryLevel3() {
		return categoryLevel3;
	}

	public void setCategoryLevel3(int categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}

	public int getDownloads() {
		return downloads;
	}

	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getCategoryLevel1() {
		return categoryLevel1;
	}

	public void setCategoryLevel1(int categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}

	public int getCategoryLevel2() {
		return categoryLevel2;
	}

	public void setCategoryLevel2(int categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}

	public String getLogoPicPath() {
		return logoPicPath;
	}

	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}

	public String getLogoLocPath() {
		return logoLocPath;
	}

	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	/**
	 * app信息的版本的类
	 */
	private AppVersion appVersion ;

	public AppVersion getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(AppVersion appVersion) {
		this.appVersion = appVersion;
	}
}