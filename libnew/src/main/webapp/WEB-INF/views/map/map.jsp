<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오시는 길</title>
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
			style="background-image: url(${pageContext.request.contextPath}/resources/img/m18.jpg);">
			<table id="td">
				<tr>
					<td height="100px"></td>
				</tr>
				<tr>
					<td>
						<div id="boxMap" data-aos="fade-left">
							<div id="title">오시는 길</div>
							<div id="intro">
								<br>
								<table id="contentMap">
									<tr>
										<td width="550px">
										<a href="${pageContext.request.contextPath}/resources/img/map3.jpg"><img src="${pageContext.request.contextPath}/resources/img/map3.jpg" width="450px"></a>
										</td>
										<td>
											<table>
												<tr height="50px">
													<td><b>버스 : </b><br>
													<br> <img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>5</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>5-2</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>7-1</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>7-2</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>13-1</b>,<br>
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>13-5</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>16</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>16-1</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>16-2</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>32-5</b>,<br>
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>60</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>66</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>66-4</b>,<br>
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>88</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>88-1</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>123D</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>151</b>,<br>
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>301</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>310</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>777</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>900</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>999</b>,<br>
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>110</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>707</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>707-1</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>909</b>,
														<img
														src="${pageContext.request.contextPath}/resources/img/bus.jpg"><b>마을
															6</b><br>
													<br><br> <b>지하철 : </b><br>
													<br> <img
														src="${pageContext.request.contextPath}/resources/img/subway.png"
														width="17px">수원역 지하상가 13번 출구에서 도보 3m <b>아이 메카 건물
															7층</b>
															<br><br>
															※이미지를 클릭하면 크게 볼 수 있습니다.
															</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										
										<td><a
											href="https://map.kakao.com/?urlX=500157&urlY=1046862&urlLevel=1&map_type=TYPE_SKYVIEW&map_hybrid=true"
											target="_blank"><img width="450" height="310"
												src="https://map2.daum.net/map/skyviewmapservice?FORMAT=PNG&RDR=HybridRender&SCALE=0.625&MX=500157&MY=1046862&S=0&IW=504&IH=310&LANG=0&COORDSTM=WCONGNAMUL&logo=kakao_logo"
												style="border: 1px solid #ccc"></a>
										<div class="hide"
												style="overflow: hidden; padding: 7px 11px; border: 1px solid #dfdfdf; border-color: rgba(0, 0, 0, .1); border-radius: 0 0 2px 2px; background-color: #f9f9f9; width: 430px;">
												<strong style="float: left;"><img
													src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/common/logo_kakaomap.png"
													width="72" height="16" alt="카카오맵"></strong>
												<div style="float: right; position: relative">
													<a
														style="font-size: 12px; text-decoration: none; float: left; height: 15px; padding-top: 1px; line-height: 15px; color: #000"
														target="_blank"
														href="https://map.kakao.com/?urlX=500157&urlY=1046862&urlLevel=1&map_type=TYPE_SKYVIEW&map_hybrid=true">지도
														크게 보기</a>
												</div>
											</div></td>
											<td></td>
									</tr>

								</table>
							</div>
							<br>
						</div>
					</td>
			</table>
			<br> <br>
		</div>

	</div>
	<script>
  AOS.init();
</script>
</body>
</html>