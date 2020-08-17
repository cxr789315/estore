package com.briup.estore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author matingting
 * 编码过滤器
 */
@WebFilter(value="/*",initParams = {@WebInitParam(name = "encoding",value = "UTF-8")} )
public class EncodingFilter implements Filter{
	
	String encoding = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//接收初始化参数
		encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//去完成过滤器真正想要完成的功能 处理编码问题
		
		//进行判空操作
		if(encoding==null||encoding.equals("")) {
			encoding="UTF-8";
		}
		
		//处理请求和响应中的编码问题
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=UTF-8");
		
		//过滤器链放行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
