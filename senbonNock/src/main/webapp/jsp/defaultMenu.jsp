<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板一覧画面</title>
</head>
<body>
	<div align="center">
		<h1>掲示板一覧画面</h1>

		<c:forEach var="errorMessage" items="${requestScope.errorMessages}">
			<p>
				<c:out value="${errorMessage}" />
			</p>
		</c:forEach>

		<form action="<c:url value="/messageBoardList"/>" method="POST">
			<table>
				<tr>
					<th align="left">タイトル <br>(全角20字以内)
					</th>
					<td><input align="top" type="text" size="30" name="title"></td>
					<br>
				</tr>
				<%-- <tr>
					<th align="left">投稿内容 <br>(100字以内)
					</th>
					<td><input align="top" type="text" size="30" name="content"></td>

				</tr>--%>
				<tr>
					<th align="left">投稿内容 <br>(100字以内)
					</th>
					<td><textarea rows="4" cols="30" name="content"></textarea></td>
				</tr>
			</table>
			<input type="hidden" name="backAnchorName" value="2-1"> <input
				type="submit" value="投稿">
		</form>



		</br> </br> <strong>過去の投稿</strong><br> <br>
		<c:forEach var="message" items="${requestScope.messages}">
			<div
				style="width: 500px; padding: 10px; margin-bottom: 10px; border: 1px solid #333333; border-radius: 10px;">
				<c:out value="${message.title}" />
				<br>
				<c:out value="${message.content}" />
				<br>

			</div>
		</c:forEach>


	</div>

</body>
</html>