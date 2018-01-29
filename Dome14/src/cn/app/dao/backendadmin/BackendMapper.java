package cn.app.dao.backendadmin;

import org.apache.ibatis.annotations.Param;

import cn.app.pojo.BackendUser;

/**
 * 后台管理者用户持久层
 * 
 * @author Administrator
 * 
 */
public interface BackendMapper {

	/**
	 * 根据管理者用户的密码返回用户的对象
	 * 
	 * @param userCode
	 *            登录名
	 * @param passWord
	 *            登录密码
	 * @return 管理者对象
	 */
	BackendUser getBackendUserByPassWord(@Param("userCode") String userCode,
			@Param("passWord") String passWord);
}
