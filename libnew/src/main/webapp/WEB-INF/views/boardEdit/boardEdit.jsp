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
<title>자유게시판 글 수정</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/js.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/page2.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap"
	rel="stylesheet">
</head>
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
				<th height="33px"><a
					href="<c:url value='/board/freeBoardList'/>">자유 게시판</a></th>
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
						<div id="boxMap">
							<div id="title">자유게시판 글 수정</div>
							<div id="intro">
								<br>
								<table id="contentMap">
									<tr>
										<td>
											<div id="boardInfomation">
												<form:form
													action="${pageContext.request.contextPath}/boardEditDone"
													commandName="updateboard">													
															
																<table id="boardTable">
																	<tr height="50px">
																		<th>제목</th>
																		<td><input type="text" name="boardTitle"
																			id="boardWriteSize" value="${editBoard.boardTitle}"
																			readonly></td>
																	</tr>
																	<tr height="50px">
																		<th>작성자</th>
																		<td>${editBoard.boardWriter}</td>
																	</tr>
																	<tr height="50px">
																		<th>내용</th>
																		<td><input type="text" name="boardContents"
																			id="boardWriteInform"
																			value="${editBoard.boardContents}" min="1"></td>
																	</tr>

																	<tr height="50px">
																		<td width="200px"><br>
																		<br> <input type="submit" id="button"
																			value="수정 완료"><br></td>

																	</tr>
																</table>
													
												</form:form>
												<br>
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
</body>
</html>
