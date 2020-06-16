<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>新規店舗登録</title></head>
<body>
	<form action="./RegistTapiocaInfo" method="post">
		<div class="tapoioca">
		お店の名前<input type="text" id="name" name="name"><br>
		住所<input type="text" name="address"><br>
		<button type="submit" id="submit" name="OK">送信</button>
		</div>
	</form>
	<%@ include file="/WEB-INF/common/footer.jsp" %>
	<script type="text/javascript" charset="UTF-8" src='/ReviewSystem/javascript/regist_tapioca.js'></script>
</body>
</html>