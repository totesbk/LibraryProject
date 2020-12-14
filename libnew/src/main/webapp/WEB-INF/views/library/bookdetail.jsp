<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 정보</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/js.js"></script>	
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/page.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap"
	rel="stylesheet">
</head>
<script>
	window.onload = function() {
		// 임의의 객체에 대해 이벤트 장착 가능
		document.getElementById("borrow").onclick = function() {
			document.getElementById("borrow").value = '대여 예약중';
			borrow.style.backgroundColor = "red";
			alert("정상적으로 대여 예약 되었습니다.");
		}
	}
</script>
<body>
	<div id="sidebox1">
		<table id="loginbox">
			<tr>
				<th colspan="2"><a href="<c:url value='/main'/>"><img
						src="${pageContext.request.contextPath}/resources/img/log.gif"
						width="200px"></a></th>
			</tr>
			<tr>
				<th>
					<div id="login" align="center">
						<form action="" method="POST">
							<c:if test="${empty authInfo}">
								<p>
									로그인 해 주세요.<br> <a href="<c:url value='/login'/>">[로그인]</a>
									<a href="<c:url value='/register/step1'/>">[회원 가입]</a>
								</p>
							</c:if>
							<c:if test="${!empty authInfo}">
								<p>${authInfo.name}님
									환영합니다.<br> <a href="<c:url value='/edit/changePassword'/>">[비밀번호
										변경]</a> <a href="<c:url value='/logout'/>">[로그아웃]</a>
								</p>
							</c:if>
						</form>
					</div>
				</th>
			</tr>
		</table>
	</div>

	<div id="sidebox2">
		<table id="menubox">
			<tr>
				<th colspan="2"></th>
			</tr>
			<tr>
				<th height="33px"><a href="<c:url value='/intro'/>">도서관 소개</a></th>
			</tr>
			<tr>
				<th height="33px"><a href="<c:url value='/guide'/>">이용 안내</a></th>
			</tr>
			<tr>
				<th height="33px"><a href="<c:url value='/library/board'/>">도서
						목록</a></th>
			</tr>
			<tr>
				<th height="33px"><a href="<c:url value='/board/freeBoardList'/>">자유 게시판</a></th>
			</tr>
			<tr>
				<th height="33px"><a href="<c:url value='/map'/>">오시는 길</a></th>
			</tr>
		</table>
	</div>
	<div id="sidebox3">
		<table id="clockbox">
			<tr>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="nowTimes"></span>
				</th>
			</tr>
		</table>
	</div>
	<div>
		<div>
			<table id="td">
				<tr>
					<td height="100px"></td>
				</tr>
				<tr>
					<td>
						<div id="boxMap" data-aos="flip-left">
							<div id="title">도서 상세 정보</div>
							<div id="intro">
								<br>
								<table id="contentMap">
									<tr>
										<td>
											<div id="bookInfomation">
												<table>
													<tr>
														<td width="300px">
															<div id="bookImage"></div>
														</td>
														<td>
															<table id="boardTable">
																<tr height="50px">
																	<th width="200px">도서명</th>
																	<td><div id="booktitle">${books.bookname}</div></td>
																</tr>
																<tr height="50px">
																	<th>장르</th>
																	<td>${books.bookgenre}</td>
																</tr>
																<tr height="50px">
																	<th>저자</th>
																	<td>${books.bookauthor}</td>
																</tr>
																<tr height="50px">
																	<th>등록일</th>
																	<td><fmt:formatDate value="${books.registerDate}"
																			pattern="yyyy-MM-dd HH:mm" /></td>
																</tr>
																<tr height="50px">
																	<th>대여 가능 여부</th>
																	<td><input type="button" value="대여 예약 가능"
																		id="borrow"></td>
																</tr>
																<tr height="50px">
																	<th>도서 정보</th>
																	<td width="500px">${books.bookcontents}</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
												<br> <a href="<c:url value='/library/board'/>">
													<div id="button">도서 목록</div>
												</a> <c:if test="${!empty authInfo.authority}">
														 <a href="<c:url value="/bookedit/bookdelete/${books.id}"/>"><div
															id="button">삭제</div></a> 
														<a href="<c:url value="/bookedit/bookedit/${books.id}"/>">
														<div id="button">수정</div>
														</a>
													</c:if> <br>
											</div>
								</table>
							</div>
							<br>
						</div>
			</table>
			<br> <br>
		</div>
		<br>

	</div>
<script>
  AOS.init();
</script>
</body>
</html>
