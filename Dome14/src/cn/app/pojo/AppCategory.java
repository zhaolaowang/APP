package cn.app.pojo;

import java.util.Date;
/**
 * 应用分类的类
 * @author Administrator
 *
 */
public class AppCategory {
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
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

	/**
	 * 分类的编号
	 */
	private int id;
	/**
	 * 分类的编码
	 */
    private String categoryCode;

    /**
     * 分类的名称
     */
    private String categoryName;
    /**
     * 父节点
     */
    private int parentId;

    /**
     * 创建人
     */
    private int createdBy;

    /**
     * 创建时间
     */
    private Date creationTime;

    /**
     * 修改人
     */
    private int modifyBy;

    /**
     * 修改时间
     */
    private Date modifyDate;

	
}