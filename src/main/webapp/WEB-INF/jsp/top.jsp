<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 顶部 -->
<div class="top">
		<div class="top_center">
			<ul class="top_bars">
				<c:if test="${!empty sessionScope.customer}">
					<li>欢迎,${customer.name }  |<a href="logoutServlet">退出</a></li>
				</c:if>
				<c:if test="${empty sessionScope.customer}">
					<li><a href="toLoginServlet">请登录</a>|</li>
				</c:if>
				<li><a href="#">我的订单<span class="jt_down"></span></a>|</li>
				<li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
				<li><a href="#">网站导航<span class="jt_down"></span></a></li>
			</ul>
		</div>
	</div>
