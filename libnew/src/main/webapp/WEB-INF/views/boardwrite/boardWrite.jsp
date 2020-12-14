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
<title>자유게시판 글 등록</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
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
						<div id="boxMap" data-aos="fade-right">
							<div id="title">자유게시판 글 등록</div>
							<div id="intro">
								<br>
								<table id="contentMap">
									<tr>
										<td>
											<div id="boardInfomation">
												<form:form action="boardWriteSuccess"
													commandName="boardData">
													<table id="boardTable">
														<tr height="50px">
															<th width="200px">제목</th>
															<td><form:input id="boardWriteSize"
																	path="boardTitle" /> <form:errors path="boardTitle" /></td>
														</tr>
														<tr height="50px">
															<th>작성자</th>
															<td><form:input id="bookWriteSize"
																				path="boardWriter" value="${authInfo.name}" readonly="true" /> <form:errors path="boardWriter" /></td>
														</tr>

														<tr height="50px">
															<th>내용</th>
															<td width="500px"><form:textarea
																	path="boardContents" id="boardWriteInform" /> <form:errors
																	path="boardContents" /></td>
														</tr>
														<tr height="50px">
															<td width="200px"><br> <br> <input
																type="button" id="button" value="게시글 등록" onclick="submitBoard()"><br></td>
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
	<script>
		AOS.init();
		
		function submitBoard() {
			var title = document.getElementById('boardWriteSize').value;
			var content = document.getElementById('boardWriteInform').value;
			
			if(!title){
				document.getElementById('boardWriteSize').focus();
				alert('제목을 입력해주세요')
			}else if(!content){
				document.getElementById('boardWriteInform').focus();
				alert('내용을 입력해주세요')
			}else{
				boardData.submit();
			}
		}
	</script>
</body>
</html>