package cn.app.service.appcategory;

import java.util.ArrayList;

import cn.app.pojo.AppCategory;

/**
 * 应用分类服务的接口
 * 
 * @author Administrator
 * 
 */
public interface AppCateGoryService {
	/**
	 * 根据分类父节点的编号返回手机分类
	 * 
	 * @param parentId
	 * @return
	 */
	ArrayList<AppCategory> getAppCateGoryByParentId(Integer parentId);
}
