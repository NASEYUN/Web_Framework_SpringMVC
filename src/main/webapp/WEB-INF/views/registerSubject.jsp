<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>링크</title>
</head>
<body>
	<table border="1" style="margin: auto">
		<thead>
			<tr>
				<td>수강년도</td>
				<td>학기</td>
				<td>교과코드</td>
				<td>교과목명</td>
				<td>구분</td>
				<td>학점</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="offer" items="${registerOffer}">
				<tr>
					<td><c:out value="${offer.year}"></c:out></td>
					<td><c:out value="${offer.semester}"></c:out></td>
					<td><c:out value="${offer.subjectcode}"></c:out></td>
					<td><c:out value="${offer.subject}"></c:out></td>
					<td><c:out value="${offer.division}"></c:out></td>
					<td><c:out value="${offer.grade}"></c:out></td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>