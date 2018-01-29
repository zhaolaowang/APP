package cn.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.pojo.DevUser;
import cn.app.service.devadmin.DevService;

/**
 * 开发者的控制器
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/dev")
public class DevController {

	@Resource
	private DevService devService;

	/**
	 * 跳转到开发者登陆平台
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String devLogin() {
		return "dev/devLogin";
	}

	/**
	 * 开发者用户进行登陆的操作
	 * 
	 * @return
	 */
	@RequestMapping("/devloginAction")
	public String findLoginUser(
			@RequestParam(value = "devName", required = true) String userCode,
			@RequestParam(value = "devPassword", required = true) String passWord,
			HttpServletRequest request) {
		DevUser devUser = devService.findDevUserByPassWord(userCode, passWord);
		if (null != devUser) {
			request.getSession().setAttribute("devUserSession", devUser);
			return "dev/main";
		} else {
			request.setAttribute("error", "用户或密码输入错误!");
			return "dev/devLogin";
		}
	}

	/**
	 * 用户注销的方法
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/logOut")
	public String loginOut(HttpSession session) {
		session.setAttribute("devUserSession", null);
		return "dev/devLogin";
	}
}
