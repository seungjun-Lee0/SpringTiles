<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>성적 리스트</h1>
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>등록일</th>
	</tr>
	<c:forEach var="gd" items="${gds}">
		<tr>
			<td>${gd.sjno}</td>
			<td>${gd.name}</td>
			<td>${gd.kor}</td>
			<td>${gd.eng}</td>
			<td>${gd.mat}</td>
			<td>${gd.regdate}</td>
		</tr>
	</c:forEach>
</table>

