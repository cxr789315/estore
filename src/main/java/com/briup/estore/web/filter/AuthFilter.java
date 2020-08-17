package com.briup.estore.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;

public class AuthFilter implements Filter {

    public AuthFilter() {
    }
	public void destroy() {
	}	


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//判断用户是否登录,如果登录,就可以访问user下的资源,否则就跳转到登录界面login.jsp
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		if(customer!=null) {
			chain.doFilter(req, resp);
		}else {
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
