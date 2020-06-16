<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // Servletのデータ受け取り
    request.setCharacterEncoding("UTF-8");
    int tapi_id = (int) request.getAttribute("tapi_id");
%>
<!DOCTYPE html>
<html>
<body>
<head><title>レビュー登録</title></head>
<form action="./RegistReview" method="post">
	評価<input type="radio" id="point" name="point" value=1>1<input type="radio" id="point" name="point" value=2>2<input type="radio" id="point" name="point" value=3 autofocus>3<input type="radio" id="point" name="point" value=4>4<input type="radio" id="point" name="point" value=5>5<br>
	口コミ記述<input type="text" name="comment"><br>
	<input type="hidden" name="id" value=<%= tapi_id %>>
	<div><button type="submit" id="submit" name="OK">送信</button></div>
	<!-- <input type="submit" name="OK"> -->
</form>
<%@ include file="/WEB-INF/common/footer.jsp" %>
<script type="text/javascript" charset="UTF-8" src='/ReviewSystem/javascript/regist_review.js'></script>
</body>
</html>