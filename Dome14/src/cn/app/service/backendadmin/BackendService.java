package cn.app.service.backendadmin;


import cn.app.pojo.BackendUser;

/**
 * 后台管理者用户服务的接口
 * 
 * @author Administrator
 * 
 */

public interface BackendService {
	/**
	 * 根据用户的账号密码返回用户的对象
	 * 
	 * @param userCode
	 *            登陆名
	 * @param passWord
	 *            密码
	 * @return 用户对象
	 */
	BackendUser getBackendUserByPassWord(String userCode, String passWord);
}
