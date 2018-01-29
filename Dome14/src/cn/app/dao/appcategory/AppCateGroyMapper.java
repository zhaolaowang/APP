package cn.app.dao.appcategory;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import cn.app.pojo.AppCategory;

/**
 * 手机分类持久化操作的接口
 * 
 * @author Administrator
 * 
 */
public interface AppCateGroyMapper {
	/**
	 * 根据分类父节点的编号返回手机分类
	 * 
	 * @param parentId
	 * @return
	 */
	ArrayList<AppCategory> getAppCateGoryByParentId(@Param("parentid") Integer parentId);
}
