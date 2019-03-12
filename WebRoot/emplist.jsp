<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%pageContext.setAttribute("path", request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
	  <script type="text/javascript">
	   $(function(){
		   /* ${"#del"}.click(function(){
			  var n = confirm("您确定要删除？");
			  if(n==true){
				var mid = ${"#em"}.val();
				$.ajax(function(){
				  url:'${pageContext.request.contextPath }/emp/delEmp.do',
				  data:'id='+mid,
				  dataType:'json',
				  success:function(result){},
				  error:function(result){}
				}); 
			  }
			   
		   });*/
		   
	   });
	  
	  </script>
	
	</head>
		
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<a href="${pageContext.request.contextPath }/user/out.do">离开</a>
						</p>
						<p>
							<%request.setAttribute("date",new java.util.Date());%>						
							<fmt:formatDate value="${date}" pattern="yyyy.MM.dd"/>
							<br />
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
						${emps[0].departments.name}
					</h1>
					<!-- name模糊查询 -->
					<form action="${pageContext.request.contextPath}/emp/querySomEmp.do" method="post">
					  <input type="text" name="str" value="${str}"/>
					  <input type="submit" value="搜索"/>
					</form>
					
					<!-- 批量删除 -->
					<form action="${pageContext.request.contextPath}/emp/delSomEmp.do" method="post">
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								deptName
							</td>
							<td>
								Operation
							</td>
						</tr>
						
					<c:forEach var="emps" items="${emps}">
						<tr class="row1">
							<td>
							<input type="checkbox" name="listIds" id="em" value="${emps.id}">${emps.id}
							</td>
							<td>
							   ${emps.name}
							</td>
							<td>
							 ${emps.salary}
							</td>
							<td>
							 ${emps.age}
							</td>
							<td>
							 ${emps.departments.name}
							</td>
							<td>
							  <a href="" id="del">删除</a>
								<%-- <a  href="${pageContext.request.contextPath }/emp/delEmp.do?id=${emps.id}">
								    delete</a> --%>&nbsp;
								<a href="${pageContext.request.contextPath }/emp/showEmpl.do?id=${emps.id}">update</a>
							</td>
						</tr>
				</c:forEach>	
				  <tr><td><input type="submit"  value="批量删除"></td></tr>
					</table>
				</form>
					
					 <p>&nbsp;</p>
   
   <!-- 分页 --> 
   <center>
   <c:if test="${pb.pageNo>1}">
      <a href="${pageContext.request.contextPath}/emp/showEmp.do?pageNo=${requestScope.pb.pageNo-1}">上一页</a>
   </c:if>
    &nbsp;
    这是第 <font color="red">${requestScope.pb.pageNo}</font> 页
    &nbsp;
    <c:if test="${pb.pageNo<pb.pageSum}">
       <a href="${pageContext.request.contextPath}/emp/showEmp.do?pageNo=${requestScope.pb.pageNo+1}">下一页</a>
    &nbsp;
    </c:if>
</center>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='${pageContext.request.contextPath}/emp/showDep.do'"/>
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
