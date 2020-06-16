<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>新規ユーザー登録</title>
</head>

<body>
<h1>新規登録情報</h1>
<form action="./RegistUser" method="post">
	<!-- <p>ID <input type="text" name="id"><span style="color:#f33"></span><br></p> -->
	<p>メールアドレス<input type="text" name="mail_address"><span style="color:#f33"></span><br></p>
	<p>名前<input type="text" name="name"><span style="color:#f33"></span><br></p>
	<p>パスワード<input type="text" name="password"><span style="color:#f33"></span><br></p>
	<p>生年月日<input type="date" name="birthday"><span style="color:#f33"></span><br></p>
	<input type="submit" name="OK">
</form>
<a href="/ReviewSystem">ログイン画面</a>
<a href="/ReviewSystem/ForgetPassword">パスワードをお忘れの方はこちら</a>
<script type="text/javascript" charset="UTF-8" src='/ReviewSystem/javascript/regist_user.js'></script>
</body>
</html>