<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
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
		
		$("input").blur(function a(){
			$(this).parent().find(".ok").remove();
			//判定用户名
			if($(this).is("#txtName")){
				if($(this).val()==""){
					$(this).parent().append("<span  class='erro ok'> 用户名不能为空 </span>");
					$(":submit").prop("disabled","disabled");
				}else{
					var inp = $(this);
					var name = $(this).val();
					$.ajax({
						url:'${pageContext.request.contextPath}/user/checkName.do',
						type:'post',
						data:'name='+name,
						contextType:'application/json',
						success:function(result){
							if(result==""){
								inp.parent().append("<span  class='success ok'> 用户名可用 </span>");
								$(":submit").prop("disabled",false);
							}else{
								inp.parent().append("<span  class='erro ok'> 用户名已存在 </span>");
								$(":submit").prop("disabled","disabled");
							}
						}
						
					});
				}
			}
			//判定真实姓名
			if($(this).is("#txtRealName")){
				if($(this).val()==""){
					$(this).parent().append("<span  class='erro ok'> 真实姓名不能为空 </span>");
					$(":submit").prop("disabled","disabled");
				}else{
					if($(this).val().length>=1&&$(this).val().length<=10){
						$(this).parent().append("<span  class='success ok'> 姓名格式正确 </span>");
						$(":submit").prop("disabled",false);
					}else{
						$(this).parent().append("<span  class='erro ok'> 姓名格式不正确 </span>");
						$(":submit").prop("disabled","disabled");
					}
				}
			}
			//判定密码
			if($(this).is("#txtPwd")){
				if($(this).val()==""){
					$(this).parent().append("<span  class='erro ok'> 密码不能为空 </span>");
					$(":submit").prop("disabled","disabled");
				}else{
					if($(this).val().length==6){
						$(this).parent().append("<span  class='success ok'> 密码格式正确</span>");
						$(":submit").prop("disabled",false);
					}else{
						$(this).parent().append("<span  class='erro ok'> 密码长度为6位 </span>");
						$(":submit").prop("disabled","disabled");
					}
				}
			}
			
		});
		
		$("form").submit(function(){
			$("input").trigger("blur");
			if($(".erro").length>0){return false;}
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
							<%request.setAttribute("date", new java.util.Date()); %>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="${pageContext.request.contextPath}/login.jsp">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="${pageContext.request.contextPath }/user/regist.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" id="txtName"/><span id="errorName"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="realName" id="txtRealName"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" id="txtPwd" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="1" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="0"/>
								</td>
							</tr>
							
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
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
