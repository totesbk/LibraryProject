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
<title>도서 목록</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/js.js"></script>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/page2.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap"
	rel="stylesheet">
<style>
#scroll {
	overflow: auto;
}
</style>
</head>
<body id="scroll">
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
						<div id="boxMap" data-aos="zoom-in">
							<div id="title">자유 게시판</div>
							<div id="intro">
								<br>
								<table id="contentMap">
									<tr>
										<td>
											<div id="bookList">
												<c:if test="${!empty boards}">
													<table id="boardTable">
														<tr>
															<th width="50px">번호</th>
															<th width="600px">제목</th>
															<th width="200px">작성자</th>
															<th width="120px">등록일</th>
															<th width="50px">조회수</th>
														</tr>
														<tr>
															<td colspan="5">
																<hr>
															</td>
														</tr>
														<c:forEach var="m" items="${boards}">
															<tr>
																<th height="25px">${m.boardNum}</th>
																<td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="<c:url value="/board/freeBoardDetail/${m.boardNum}"/>">${m.boardTitle}</a>	
																</td>
																<td>&nbsp;&nbsp;&nbsp;&nbsp;${m.boardWriter}</td>
																<td>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${m.regdate}" pattern="yyyy-MM-dd"/></td>
																<td>&nbsp;&nbsp;&nbsp;&nbsp;${m.boardCount}</td>
															</tr>
															<tr>
																<td colspan="5">
																	<hr color="whitesmoke">
																</td>
															</tr>
														</c:forEach>
													</table>
													<br>
												</c:if>												
												</a> 
												<c:if test="${!empty authInfo}">
												<a href="<c:url value="/boardwrite/boardWrite"/>">
													<div id="button">글 등록</div>
												</a>
												</c:if> <br>
											</div> <br>
										</td>
									</tr>
								</table>
							</div>
							<br>
						</div>
			</table>
			<br> <br>
		</div>

	</div>
	<script>
		AOS.init();
	</script>
</body>
</html>