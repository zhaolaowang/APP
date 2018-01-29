package cn.app.service.devadmin;

import cn.app.pojo.DevUser;

/**
 * 开发者用户服务的接口
 * 
 * @author Administrator
 * 
 */

public interface DevService {

	/**
	 * 根据用户的账号密码返回用户的对象
	 * 
	 * @param userCode
	 * @param passWord
	 * @return
	 */
	DevUser findDevUserByPassWord(String userCode, String passWord);
}
