package cn.app.pojo;

import java.util.Date;

/**
 * 后台管理用户
 * 
 * @author Administrator
 * 
 */
public class BackendUser {
	/**
	 * 用户编号
	 */
	private int id;
	/**
	 * 用户编码
	 */
	private String userCode;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
	 */
	private int userType;
	/**
	 * 创建者（来源于backend_user用户表的用户id）
	 */
	private int createdBy;
	/**
	 * 创建时间
	 */
	private Date creationDate;
	/**
	 *更新者（来源于backend_user用户表的用户id）
	 */
	private int modifyBy;
	/**
	 * 最新更新时间
	 */
	private Date modifyDate;
	/**
	 * 用户密码
	 */
	private String userPassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}