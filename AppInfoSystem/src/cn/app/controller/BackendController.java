package cn.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.pojo.BackendUser;
import cn.app.service.backendadmin.BackendService;

/**
 * 后台管理者的控制器
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/backend")
public class BackendController {

	@Resource
	private BackendService backendService;

	/**
	 * 跳转到后台管理登陆平台
	 * @return
	 */
	@RequestMapping("/login")
	public String backEndLogin() {
		return "backend/userLogin";
	}

	/**
	 * 开发者用户进行登陆的操作
	 * 
	 * @return
	 */
	@RequestMapping("/backendLoginAction")
	public String findLoginUser(
			@RequestParam(value = "codeName", required = true) String userCode,
			@RequestParam(value = "userPassword", required = true) String passWord,
			HttpServletRequest request) {
		BackendUser backUser = backendService.getBackendUserByPassWord(
				userCode, passWord);
		if (null != backUser) {
			request.getSession().setAttribute("userSession", backUser);
			return "backend/main";
		} else {
			request.setAttribute("error", "用户或密码输入错误!");
			return "backend/userLogin";
		}
	}

	/**
	 * 用户注销的方法
	 * @param session
	 * @return
	 */
	@RequestMapping("/logOut")
	public String loginOut(HttpSession session) {
		session.setAttribute("userSession", null);
		return "backend/userLogin";
	}
}
