<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>add Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/style.css" />
			
<style>
	.erro{
		color: red;
	     }
		.ok{}
		.success{
		color: green;
			}
</style>			
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/jquery-1.8.3.js">
		</script>
		<script type="text/javascript">
		 $(function(){
		   $("#txtName").blur(function(){
		    if($(this).val()==""){
				$(this).parent().append("<span  class='erro ok'> 部门名不能为空 </span>");
			}
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
								<a href="${pageContext.request.contextPath}/dep/showDep.do">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						add Department info:
					</h1>
					<form action="${pageContext.request.contextPath}/dep/addDep.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" id="txtName" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									note:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="note" id="txtNode" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Confirm" />
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
