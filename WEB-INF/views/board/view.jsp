<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="cr" value="
" scope="application" />
<c:set var="br" value="<br/>" scope="application" />

<fmt:setBundle basename="lsj.spring.mvc.jdbc"/>
<fmt:message key="url" var="url"/>
<fmt:message key="drv" var="drv"/>
<fmt:message key="usr" var="usr"/>
<fmt:message key="pwd" var="pwd"/>
 
 <sql:setDataSource url="${url}" driver="${drv}" 
 user="${usr}" password="${pwd}" var="mariadb" />
 
<sql:update dataSource="${mariadb}">
	update board set views = views + 1
	where bdno = ?
	<sql:param value="${param.bdno }" />
</sql:update>

 <sql:query var="rs" dataSource="${mariadb}">
	select title, userid, regdate, views, thumbup, contents from board
	where bdno = ?
	<sql:param value="${param.bdno}"/>
</sql:query>


<c:forEach var="r" items="${rs.rows}">
	<c:set var="title" value="${r.title}"/>
	<c:set var="userid" value="${r.userid}"/>
	<c:set var="regdate" value="${r.regdate}"/>
	<c:set var="views" value="${r.views}"/>
	<c:set var="thumbup" value="${r.thumbup}"/>
	<c:set var="contents" value="${r.contents}"/>
</c:forEach>
<div id="container">
			<div>
				<label>제목</label>
				<span>${title}</span>
			</div>
			<div>
				<label>작성글 정보</label>
				<span>${userid}/ ${regdate} / ${thumbup} / ${views} </span>
			</div>
			<div>
				<label class="dragup">본문</label>
				<span class="contents">${fn:replace(contents,cr,br)}</span>
			</div>
			<div>
				<label></label>
				<button type="button" id="listbtn">목록으로</button>
			</div>
</div>
        <script>
        	var listbtn = document.getElementById("listbtn");
        	listbtn.addEventListener('click', goListfn);
        	
        	function goListfn(){
        		location.href="/board/list";
        	}
        </script>