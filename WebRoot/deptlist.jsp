<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>department</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
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
							<a href="${pageContext.request.contextPath}/dep/showDep.do">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome~${sessionScope.user.name}猫的天空！
					</h1>
					
					<!-- name模糊查询 -->
					<form action="${pageContext.request.contextPath}/dep/showSome.do" method="post">
					  <input type="text" name="str" value="${str}"/>
					  <input type="submit" value="搜索"/>
					</form> 
					
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								note
							</td>
							<td>
								Operation
							</td>
						</tr>
			    	<c:forEach var="deps" items="${requestScope.deps}">
						<tr class="row1">
						  <td>
							 ${deps.id}
						  </td>
							<td>${deps.name}</td>
							<td>${deps.note}</td>
							<td>
								<a href="${pageContext.request.contextPath}/dep/detilDep.do?id=${deps.id}">详情</a>
								<a href="${pageContext.request.contextPath}/dep/showThis.do?id=${deps.id}">update</a>
							</td>
						</tr>
				</c:forEach>
					</table>
   <!-- 分页 --> 
   <center>
   <c:if test="${pb.pageNo>1}">
      <a href="${pageContext.request.contextPath}/dep/showDep.do?pageNo=${requestScope.pb.pageNo-1}">上一页</a>
   </c:if>
    &nbsp;
         这是第 <font color="red">${requestScope.pb.pageNo}</font> 页
    &nbsp;
    <c:if test="${pb.pageNo<pb.pageSum}">
      <a href="${pageContext.request.contextPath}/dep/showDep.do?pageNo=${requestScope.pb.pageNo+1}">下一页</a>
    &nbsp;
    </c:if>
</center>

		<p>
		 <input type="button" class="button" value="Add Department" onclick="location='${pageContext.request.contextPath}/addDep.jsp'"/>
		</p>
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
