<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기별 이수 학점 조회</title>
</head>
<body>
	<table border="1" style="margin: auto">
		<thead>
			<tr>
				<td>년도</td>
				<td>학기</td>
				<td>이수학점</td>
				<td>상세보기</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="offer" items="${semesterOffer}">
				<tr>
					<td><c:out value="${offer.year}"></c:out></td>
					<td><c:out value="${offer.semester}"></c:out></td>
					<td><c:out value="${offer.grade}"></c:out></td>
					<td><a href="${pageContext.request.contextPath}/registerSubject?year=${ offer.year}
					&semester=${offer.semester }">링크</a></td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>