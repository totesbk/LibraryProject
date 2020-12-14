<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>이용 안내</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/js.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
	<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
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
				<th height="33px"><a href="<c:url value='/library/board'/>">도서 목록</a></th>
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
		<div class="full4"
			style="background-image: url(${pageContext.request.contextPath}/resources/img/m23.jpg);">
			<table id="td">
				<tr>
					<td height="100px"></td>
				</tr>
				<tr>
					<td>
						<div id="boxGuide" data-aos="fade-down">
							<div id="title">이용 안내</div>
							<div id="intro">
								<table>
									<tr>
										<td colspan="2">
										<div id="introImg">	
											<img src="${pageContext.request.contextPath}/resources/img/intro44.jpg" width="1000px">
										</div>
										</td>
									</tr>
									<tr>
										<td>
											<table id="contentGuide">
												<tr height="50px">
													<td><img
														src="${pageContext.request.contextPath}/resources/img/dott.jpg">휴관일
													</td>
												</tr>
												<tr height="50px">
													<td>정기휴관일 매주 월요일 및 법정공휴일 (2020.7.7. ~ 감염병 위기대응 상황
														변동시까지)</td>
												</tr>
											</table>

											<table id="contentGuide">
												<tr height="50px">
													<td id="subtitle"><img
														src="${pageContext.request.contextPath}/resources/img/dott.jpg">홈페이지
														이용 안내</td>
												</tr>
												<tr height="50px">
													<td id="subtitle">수원시 도서관 홈페이지 정회원에게는 전자책 서비스,
														E-Learning서비스, 대출/반납 내역조회, 도서예약, 희망도서 신청 등 <br> 온라인
														서비스를 제공하고 있습니다.
													</td>
												</tr>
												<tr>
													<td id="subtitle">기타 문의 사항 : lige3@naver.com /
														031-243-2111</td>
												</tr>
											</table>
										</td>
										<td>
											<table id="contentGuide">
												<tr height="50px">
													<td id="subtitle"><img
														src="${pageContext.request.contextPath}/resources/img/dott.jpg">복사
													</td>
												</tr>
												<tr>
													<th id="tb1">위치</th>
													<td id="tb2">1층 복사코너</td>
												</tr>
												<tr>
													<th id="tb1">이용 시간</th>
													<td id="tb2">평일 09:00 ~ 22:00, 주말 09:00 ~ 17:00</td>
												</tr>
												<tr>
													<th id="tb1">운영방법</th>
													<td id="tb2">A4,B4 규격 복사 가능(40원)<br>카드 자율 복사제로 운영<br>카드
														구입: 1층 매점(3000원)
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<table id="contentGuide">
												<tr height="50px">
													<td><img
														src="${pageContext.request.contextPath}/resources/img/dott.jpg">이용
														시간</td>
												</tr>
												<tr>
													<th id="tb1" colspan="2" rowspan="2">실별</th>
													<th id="tb1" colspan="2">이용시간</th>
												</tr>
												<tr>
													<td id="tb2">평일</td>
													<td id="tb2">토,일요일</td>
												</tr>
												<tr>
													<th id="tb1" rowspan="2">문화공간</th>
													<th id="tb2">청소년 실습실</th>
													<td id="tb2">09:00 ~ 22:00</td>
													<td id="tb2" rowspan="2">09:00 ~ 17:00</td>
												</tr>
												<tr>
													<th id="tb2">어린이 자료실</th>
													<td id="tb2">09:00 ~ 18:00</td>
												</tr>
												<tr>
													<th id="tb1" colspan="2">일반 열람실</th>
													<td id="tb2" colspan="2">07:00 ~ 23:00</td>
												</tr>
											</table>
										</td>
										<td>
											<table id="contentGuide">
												<tr height="50px">
													<td id="subtitle"><img
														src="${pageContext.request.contextPath}/resources/img/dott.jpg">프린트
													</td>
												</tr>
												<tr>
													<th id="tb1">위치</th>
													<td id="tb2">1층 디지털 코너</td>
												</tr>
												<tr>
													<th id="tb1">이용 시간</th>
													<td id="tb2">평일 09:00 ~ 22:00, 주말 09:00 ~ 17:00</td>
												</tr>
												<tr>
													<th id="tb1">운영방법</th>
													<td id="tb2">A4,B4 규격 복사 가능(40원)<br>카드 자율 복사제로 운영<br>카드
														구입: 1층 매점(3000원)
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<br>
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




