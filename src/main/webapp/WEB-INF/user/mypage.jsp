<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head><title>タピオカ掲示板</title></head>

<body>
	<h1>全国のタピオカ掲示板</h1>
	<h2>${ sessionScope.lu.getName() }のマイページ</h2>
	<a href="/ReviewSystem/RegistTapiocaInfo">お店の登録はこちらから</a><br>
	<a href="/ReviewSystem/ShowTapioca">口コミ一覧</a><br>

	<h2>タイムライン</h2>
	なんかよさげに表示される
	<h3>ツイートする</h3>
	<form action="./RegistTweet" method="post">
		<div class="tweet1">
		<input type="text" id="tweet" name="tweet" autocomplete="off"><br>
		<button type="submit" id="submit" value="OK" disabled>ツイート</button>
		</div>
	</form>
	<%@ include file="/WEB-INF/common/footer.jsp" %>
	<script type="text/javascript" charset="UTF-8" src='/ReviewSystem/javascript/regist_tweet.js'></script>
</body>
</html>