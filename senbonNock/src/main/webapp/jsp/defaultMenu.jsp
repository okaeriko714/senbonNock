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
		<%-- <%
		String errorMessages = arrayList.toString();
		String  errorMessages1 = str.replaceAll("^\\[|\\]$", "");
		
		<p>
			出力：<%=errorMessages1%></p> --%>

		<c:forEach var="errorMessage" items="${requestScope.errorMessages}">
			<p>
				<c:out value="${errorMessages}" />
			</p>
		</c:forEach>

		<form action="<c:url value="/messageBoardList"/>" method="POST">
			<table>
				<tr>
					<td>タイトル(全角20字以内)</td>
					<td><input type="text" name="title"></td>
					<br>
				</tr>
				<tr>
					<td>投稿内容(100字以内)</td>
					<td><input type="text" name="content"></td>
				</tr>
			</table>
			</br> <input type="hidden" name="backAnchorName" value="2-1"> <input
				type="submit" value="送信">
		</form>


		<%--<fmt:formatDate value="${message.registerdate}" pattern="yyyy-MM-dd HH:mm:ss" />--%>
		</br> </br> <strong>過去の投稿</strong><br> <br>
		<c:forEach var="message" items="${requestScope.messages}">
			<div
				style="width: 800px; padding: 10px; margin-bottom: 10px; border: 1px solid #333333; border-radius: 10px;">
				<c:out value="${message.title}" />
				<br>
				<c:out value="${message.content}" />
				<br>

			</div>
		</c:forEach>


	</div>

</body>
</html>