<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<fmt:setBundle basename="lsj.spring.mvc.jdbc"/>
<fmt:message key="url" var="url"/>
<fmt:message key="drv" var="drv"/>
<fmt:message key="usr" var="usr"/>
<fmt:message key="pwd" var="pwd"/>
 
 <sql:setDataSource url="${url}" driver="${drv}" 
 user="${usr}" password="${pwd}" var="mariadb" />
 
<c:if test="${empty sessionScope.userid}">
<script>alert('로그인하세요');
 		location.href='/login';</script>
</c:if>
 
<sql:query var="rs" dataSource="${mariadb}">
	select userid from board
	where userid =?
	<sql:param value="${sessionScope.userid}"/>
</sql:query>

    		<h1>게시판 - 글쓰기</h1>
    		<form name="boardfrm" id="boardfrm">
    			<div>
    				<label>제목</label>
    				<input type="text" name="title" />
    			</div>
    			<div>
    				<label>작성자</label>
    				<input type="text" name="userid"
    				value="${sessionScope.userid}" 
    				readonly/>
    			</div>
    			<div>
    				<label class="dragup">본문</label>
    				<textarea id="contents" name="contents"></textarea>
    			</div>
    			<div><label></label>
    				<button type="button" id="writebtn">입력완료</button>
    				<button type="reset">다시입력</button>
    			</div>
    		</form>        
		<script>
		var writebtn = document.getElementById('writebtn');
        writebtn.addEventListener('click', checkwritefrm);
        
        function checkwritefrm() {
        	var frm = document.getElementById('boardfrm');
        	if (frm.title.value == '')
        		alert('제목을 입력하세요!');
        	else if (frm.contents.value == '')
        		alert('본문을 입력하세요!')
        	else {
        		frm.action ='writeok';
        		frm.submit();
        	}
        }
		</script>