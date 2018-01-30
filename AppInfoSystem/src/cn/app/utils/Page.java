package cn.app.utils;

import java.util.ArrayList;

import cn.app.pojo.AppInfo;

/**
 * 分页的类
 * 
 * @author Administrator
 * 
 */
public class Page {

	/**
	 * 当前的页数
	 */
	private int currPageNo;

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		if (currPageNo >= this.pageCount) {
			this.currPageNo = this.pageCount;
		} else if (currPageNo <= 1) {
			this.currPageNo = 1;
		} else {
			this.currPageNo = currPageNo;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getInfoCount() {
		return infoCount;
	}

	public void setInfoCount(int infoCount) {
		if (infoCount <= 1) {
			this.infoCount = 0;
			this.pageCount = 1;
		} else {
			this.infoCount = infoCount;
			this.pageCount = (infoCount % pageSize == 0) ? (infoCount / pageSize)
					: (infoCount / pageSize + 1);
		}

	}

	/**
	 * 页容量
	 */
	private int pageSize = 5;
	/**
	 * 页数
	 */
	private int pageCount;
	/**
	 * 信息的总数
	 */
	private int infoCount;
	/**
	 * 应用信息的集合
	 */
	private ArrayList<AppInfo> appInfoList;

	public ArrayList<AppInfo> getAppInfoList() {
		return appInfoList;
	}

	public void setAppInfoList(ArrayList<AppInfo> appInfoList) {
		this.appInfoList = appInfoList;
	}
}