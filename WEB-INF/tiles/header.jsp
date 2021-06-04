<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <h1>SemiProject V1</h1>
</header>
        <nav>
            <ul>
                <li><a href="/index">Home</a></li>
                <li><a href="/join">회원가입</a></li>
                
                <c:if test="${empty sessionScope.userid}">
                <li><a href="/login">로그인</a></li></c:if>
                
                <c:if test="${not empty sessionScope.userid }">
                <li><a href="/logout">로그아웃</a></li></c:if>
                
                <li><a href="/board/list">게시판</a></li>
                <li><a href="/myinfo">회원정보</a></li>
            </ul>
            <hr>
        </nav>