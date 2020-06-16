<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,beans.Review"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    // Servletのデータ受け取り
    request.setCharacterEncoding("UTF-8");
	List<Review> rl = (List<Review>) request.getAttribute("rl");
%>
<!DOCTYPE html>
<html>
<head><title>${ tapioca.getName() }一覧</title></head>
<body>

<c:forEach var="r" items="${ rl }">
	<h2>評価：<c:out value="${ r.getPoint() }" /></h2>
	<h4>投稿者：<c:out value="${ r.getUser().getName() }" />投稿日：<c:out value="${ r.getCreatedAt() }" /></h4>
	<h4><c:out value="${ r.getComment() }" /></h4><br>

</c:forEach>
<a href="/ReviewSystem/RegistReview?id=${ tapioca.getID() }">このお店の口コミの登録はこちら</a>

<%@ include file="/WEB-INF/common/footer.jsp" %>
</body>
</html>