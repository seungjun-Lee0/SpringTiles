<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>성적처리 프로그램</h1>
<p> 
	<c:if test="${gd eq 1}">
		<a href="/grade2list">성적 리스트 조회</a>
	</c:if>
</p>

