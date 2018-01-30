package cn.app.dao.devadmin;

import org.apache.ibatis.annotations.Param;

import cn.app.pojo.DevUser;

/**
 * 开发者用户持久层
 * 
 * @author Administrator
 * 
 */
public interface DevMapper {

	/**
	 * 根据用户的账号密码进行查找用户的对象
	 * 
	 * @param userCode
	 *            用户名
	 * @param passWord
	 *            用户密码
	 * @return
	 */
	DevUser getDevUserByPassWord(@Param("userCode") String userCode,
			@Param("passWord") String passWord);
}
