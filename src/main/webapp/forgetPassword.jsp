<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head><title>タピオカ掲示板</title></head>

<body>
	<h1>パスワードをお忘れの方</h1>
	<h2>登録情報の確認</h2>
	<form action="./ForgetPassword" method="post">
		メールアドレス：<input type="text" name="mail_address"><br>
		生年月日：<input type="date" name="birthday"><br>
		<input type="submit" name="OK">
	</form>
	<a href="/ReviewSystem/RegistUser">新規登録はこちら</a>
	<a href="./index.jsp">ログイン画面へ</a>
</body>
</html>