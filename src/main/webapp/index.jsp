<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head><title>タピオカ掲示板</title></head>

<body>
	<h1>全国のタピオカ掲示板</h1>
	<h2>ログイン</h2>
	<form action="./Login" method="post">
		メールアドレス：<input type="text" name="mail_address"><br>
		パスワード：<input type="text" name="password"><br>
		<input type="submit" name="OK">
	</form>
	<a href="/ReviewSystem/RegistUser">新規登録はこちら</a>
	<a href="/ReviewSystem/ForgetPassword">パスワードをお忘れの方はこちら</a>
</body>
</html>