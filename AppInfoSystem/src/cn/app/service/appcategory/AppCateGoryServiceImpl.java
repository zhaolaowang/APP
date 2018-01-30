package cn.app.service.appcategory;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.app.dao.appcategory.AppCateGroyMapper;
import cn.app.pojo.AppCategory;

/**
 * 应用分类服务的实现类
 * 
 * @author Administrator
 * 
 */
@Service
public class AppCateGoryServiceImpl implements AppCateGoryService {

	@Resource
	private AppCateGroyMapper appCateGroyMapper;

	@Override
	public ArrayList<AppCategory> getAppCateGoryByParentId(Integer parentId) {
		return appCateGroyMapper.getAppCateGoryByParentId(parentId);
	}

}
