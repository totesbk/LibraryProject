<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<p>책 번호 : ${books.id}</p>
	<p>책 이름: ${books.bookname}</p>
	<p>책 장르 : ${books.bookgenre}</p>
	<p>책 작가 : ${books.bookauthor}</p>
	<p>책 대출 : ${books.bookable}</p>
	<p>가입일 : <fmt:formatDate value="${books.registerDate}"
				pattern="yyyy-MM-dd HH:mm"/></p>
	<br>
	<p>
			<a href="<c:url value='/library/search'/>">[도서 검색]</a>			
	</p>
</body>
</html>