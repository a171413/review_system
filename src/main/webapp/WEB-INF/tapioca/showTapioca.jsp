<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,beans.Tapioca"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    // Servletのデータ受け取り
    request.setCharacterEncoding("UTF-8");
    List<Tapioca> tl = (List<Tapioca>) request.getAttribute("tl");
%>
<!DOCTYPE html>
<html>
<head><title>タピオカ店舗一覧</title></head>
<body>

<c:forEach var="t" items="${ tl }">
	<a href="/ReviewSystem/ShowReview?id=${ t.getID() }"><c:out value="${ t.getName() }" />:
	   <c:out value="${ t.getAddress() }" /></a><br>
</c:forEach>


<%@ include file="/WEB-INF/common/footer.jsp" %>
</body>
</html>