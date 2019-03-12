<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath }/css/style.css" />
			
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/jquery-1.8.3.js">
		</script>
		
		
		<script type="text/javascript">
			$(function(){
				//验证码
	  			$("#imgVcode").click(function(){
	  				$(this).prop("src","${pageContext.request.contextPath}/cap/generateCaptcha.do?time="+new Date().getTime());
	  			});
			});
				
		</script>
			
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
							<%request.setAttribute("date", new java.util.Date());%>
							<fmt:formatDate value="${date}" pattern="yyyy/MM/dd"/><br/>
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						login
					</h1>
					<form action="${pageContext.request.contextPath }/user/login.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<!-- 验证码 -->
							 <tr>
								<td valign="middle" align="right">
									<img id="imgVcode" src="${pageContext.request.contextPath}/cap/generateCaptcha.do" />
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="clientCode" />
								</td>
							</tr>  
						</table>
						<p>
						<input type="submit" class="button" value="Submit &raquo;"/>
						<a href="${pageContext.request.contextPath }/regist.jsp">regist</a>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
