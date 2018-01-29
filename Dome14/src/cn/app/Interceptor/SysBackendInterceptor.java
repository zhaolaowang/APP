package cn.app.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.app.pojo.BackendUser;

/**
 * 拦截器
 * 
 * @author Administrator
 * 
 */
public class SysBackendInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 进行判断的方法 true 执行通过 false 跳转指定的页面
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		BackendUser user = ((BackendUser) session.getAttribute("userSession"));
		if (null == user) {
			response.sendRedirect(request.getContextPath()+"/backend/login");
				return false;
		}
		return true;
	}
}
