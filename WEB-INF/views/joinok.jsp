<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> 
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
 
 
 <fmt:setBundle basename="lsj.jdbc"/>
 <fmt:message key="url" var="url"/>
 <fmt:message key="drv" var="drv"/>
 <fmt:message key="usr" var="usr"/>
 <fmt:message key="pwd" var="pwd"/>
 
 <sql:setDataSource url="${url}" driver="${drv}" 
 user="${usr}" password="${pwd}" var="mariadb" />
 
 <sql:update dataSource = "${mariadb}" var="cnt">
 	insert into member (userid, passwd, name, email)
 	values (?,?,?,?)
 	<sql:param value="${param.userid}"/>
 	<sql:param value="${param.passwd}"/>
 	<sql:param value="${param.name}"/>
 	<sql:param value="${param.email}"/>
 </sql:update>

<h1>회원가입 처리결과</h1>
<c:if test="${cnt gt 0}">
<h2 style="color:red">회원 가입 성공!!</h2>
</c:if>
<p><a href="login">로그인 하러가기</a></p>
