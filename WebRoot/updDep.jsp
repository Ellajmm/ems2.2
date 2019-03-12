<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>update dept</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/style.css" />
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
						update dept info:
					</h1>
					<form action="${pageContext.request.contextPath}/dep/updDep.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
								 <input type="text" class="inputgri" name="id" value="${dep.id}" readonly/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${dep.name}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									note:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="note" value="${dep.note}"/>
								</td>
								
							<%-- 	<td>
								<select name="dep.note">
									  <option value="${dep.note}">${dep.note}</option>
									<c:forEach var="deps" items="${deps}">
										<c:if test="${deps.id != dep.id}">
											<option value="${deps.note}">${deps.note }</option>
										</c:if>
									</c:forEach> 
								</select>
								</td> --%>
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
