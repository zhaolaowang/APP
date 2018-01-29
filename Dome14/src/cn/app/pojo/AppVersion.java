package cn.app.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 应用版本的类
 * 
 * @author Administrator
 * 
 */
public class AppVersion {
	/**
	 * 版本编号
	 */
	private int id;
	/**
	 * appId（来源于：app_info表的主键id）
	 */
	private int appId;
	/**
	 * 版本号
	 */
	private String versionNo;
	/**
	 * 版本介绍
	 */
	private String versionInfo;
	/**
	 * 发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
	 */
	private int publishStatus;
	/**
	 * 发布状态名称
	 */
	private String publishStatusName;

	public String getPublishStatusName() {
		return publishStatusName;
	}

	public void setPublishStatusName(String publishStatusName) {
		this.publishStatusName = publishStatusName;
	}

	/**
	 * 下载链接
	 */
	private String downloadLink;
	/**
	 * 版本大小（单位：M）
	 */
	private BigDecimal versionSize;
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
	 * apk文件的服务器存储路径
	 */
	private String apkLocPath;
	/**
	 * 上传的apk文件名称
	 */
	private String apkFileName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}

	public int getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(int publishStatus) {
		this.publishStatus = publishStatus;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public BigDecimal getVersionSize() {
		return versionSize;
	}

	public void setVersionSize(BigDecimal versionSize) {
		this.versionSize = versionSize;
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

	public String getApkLocPath() {
		return apkLocPath;
	}

	public void setApkLocPath(String apkLocPath) {
		this.apkLocPath = apkLocPath;
	}

	public String getApkFileName() {
		return apkFileName;
	}

	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}

}