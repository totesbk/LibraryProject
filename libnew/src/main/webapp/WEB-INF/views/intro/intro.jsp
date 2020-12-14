<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
			style="background-image: url(${pageContext.request.contextPath}/resources/img/m16.jpg);">
			<table id="td">
				<tr>
					<td height="100px"></td>
				</tr>
				<tr>
					<td>
						<div id="boxMap" data-aos="fade-up">
							<div id="title">도서관 소개</div>
							<div id="intro">
							<br>
								<table id="contentMap">
									<tr>
										<td width="550px"><img
											src="${pageContext.request.contextPath}/resources/img/intro.jpg"
											width="440px"> <img
											src="${pageContext.request.contextPath}/resources/img/intro2.jpg"
											width="440px"> <img
											src="${pageContext.request.contextPath}/resources/img/intro3.jpg"
											width="440px"></td>
										<td><b>수원시 중앙도서관 업무를 담당하는 직원은 친절한 봉사정신을 바탕으로 이용고객이 원하는 최신
											정보를 신속하게 제공하고 21세기 지식기반 사회에 필요한 역할을 수행함과 아울러 시민에게 신뢰받는 도서관이
											되고자 다음과 같이 실천 하겠습니다.</b> <br><br>
											<img
											src="${pageContext.request.contextPath}/resources/img/introcursor.jpg">우리는 모든 시민을 고객의 입장에서 생각하고 처리하며 결과에 만족을
											드리도록 최선을 다하겠습니다. <br><br>
											<img
											src="${pageContext.request.contextPath}/resources/img/introcursor.jpg">우리는 모든 시민을 위하여 신속·정확한 정보를 제공하겠습니다. <br><br>
											<img
											src="${pageContext.request.contextPath}/resources/img/introcursor.jpg">우리는 모든
											시민을 위하여 다양한 독서·문화프로그램을 내실 있게 운영하여 평생 교육의 장으로서 역할을 다하겠습니다. <br><br>
											<img
											src="${pageContext.request.contextPath}/resources/img/introcursor.jpg">우리는
											모든 시민이 늘 찾고 싶은 도서관이 될 수 있도록 쾌적한 도서관 환경 조성에 최선을 다하겠습니다.<br><br> 
											<img
											src="${pageContext.request.contextPath}/resources/img/introcursor.jpg">우리는 모든
											시민을 공정하고 정중하게 대하며 시민의 개인 정보보호에 최선을 다하겠습니다. <br><br>
											이와 같은 우리의 목표를 달성하기
											위하여 구체적인「서비스 이행표준」을 설정하고 이를 성실히 지킬 것을 약속합니다. <br> <br>
											<img
											src="${pageContext.request.contextPath}/resources/img/dott.jpg">
											연혁<br> <br> - 2020.10.21 3조 팀 프로젝트 시작<br> <br>
											- 2020.11.07 프론트 엔드 완성<br> <br> - 2020.11.18 백 엔드
											완성<br> <br> - 2020.11.25 도서관 홈페이지 완성 <br> <br>
											<br>
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




