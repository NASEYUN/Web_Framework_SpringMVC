<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청하기</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
		<table class="formtable">
			<tr>
				<td class="label">수강년도 :</td>
				<td><sf:input class="control" type="text" path="year" /><br />
					<sf:errors path="year" class="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">학기 :</td>
				<td><sf:input class="control" type="text" path="semester" /><br />
				<sf:errors path="semester" class="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">교과코드 :</td>
				<td><sf:input class="control" path="subjectcode" type="text" /><br />
				<sf:errors path="subjectcode" class="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">교과목명 :</td>
				<td><sf:input class="control" type="text" path="subject" /><br />
					<sf:errors path="subject" class="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">구분 :</td>
				<td><sf:input class="control" type="text" path="division" /><br />
				<sf:errors path="division" class="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">학점 :</td>
				<td><sf:input class="control" path="grade" type="text" /><br />
				<sf:errors path="grade" class="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="새 제안" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>