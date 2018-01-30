package cn.app.pojo;

import java.util.Date;

/**
 * 数据描述
 * 
 * @author Administrator
 * 
 */
public class DataDictionary {
	/**
	 * 描述的编号
	 */
	private int id;
	/**
	 * 类型编码
	 */
	private String typeCode;
	/**
	 * 类型名称
	 */
	private String typeName;
	/**
	 * 类型值ID
	 */
	private int valueId;
	/**
	 * 类型值Name
	 */
	private String valueName;
	/**
	 * 创建者（来源于backend_user用户表的用户id）
	 */
	private int createdBy;
	/**
	 * 创建时间
	 */
	private Date creationDate;
	/**
	 * 更新者（来源于backend_user用户表的用户id）
	 */
	private int modifyBy;
	/**
	 * 最新更新时间
	 */
	private Date modifyDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getValueId() {
		return valueId;
	}

	public void setValueId(int valueId) {
		this.valueId = valueId;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
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

}