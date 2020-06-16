<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!-- beans.Userをimportする -->
<%@ page import= "beans.User" %>

<html>
<head><title>結果</title></head>

<body bgcolor="skyblue">
<br>

<table border="1" width="100%">
	<tr>
		<td width = "40%"> ID </td>
		<td width = "60%"> ${U.id}  </td>
	</tr>
	<tr>
		<td width = "40%"> メールアドレス </td>
		<td width = "60%"> ${U.mail_address}  </td>
	</tr>
	<tr>
		<td width = "40%"> 名前 </td>
		<td width = "60%"> ${U.name}  </td>
	</tr>
	<tr>
		<td width = "40%"> パスワード </td>
		<td width = "60%"> ${U.password}  </td>
	</tr>
	<tr>
		<td width = "40%"> 生年月日 </td>
		<td width = "60%"> ${U.birthday}  </td>
	</tr>
</table>
<br>
<a href="./index.jsp">ログイン画面へ</a>>
</body>
</html>