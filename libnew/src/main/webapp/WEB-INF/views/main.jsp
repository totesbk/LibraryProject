<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수원그린도서관</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/js.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap"
	rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">  
</head>
<body>
	<div id="sidebox1">
		<table id="loginbox">
			<tr>
				<th colspan="2"><a href="<c:url value='/main'/>"> <img
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

	<div id="fullpage">

		<div class='quick'>
			<ul></ul>
		</div>
		<div class="fullsection full1" pageNum="1"
			style="background-image: url(${pageContext.request.contextPath}/resources/img/m3.jpg);">
			<table id="td" class="overlay">
				<tr>
					<td height="200px"></td>
				</tr>
				<tr>
					<td height="200px">
						<a href="<c:url value='/bookSearch'/>"><div id="sch" class="scale"></div></a>
					</td>
				</tr>
				<tr>
					<td>
						<div id="box1">
							<div id="mainfont1">수원 그린 도서관에 오신 것을 환영합니다!</div>
							<br>
							<div id="mainfont2">
								수원 그린 도서관은 국가 지식정보자원의 보고로서 2020년 개관한 이래, 국내에서 발행된 출판물과
								각종 지식정보를 망라적으로 수집 · 보존하고 이를 체계적으로 정리하여 수원 시민에게 제공하고
								있습니다.<br>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="fullsection full2" pageNum="2"
			style="background-image: url(${pageContext.request.contextPath}/resources/img/m6.jpg);">
			<table id="td">
				<tr>
					<td height="100px"></td>
				</tr>
				<tr>
					<td>
						<div id="box2">
							<div id="title">추천 도서</div>
							<div id="ex">
								<table>
									<tr>
										<td><img
											src="${pageContext.request.contextPath}/resources/img/ex7.jpg"
											width="150px" height="200px" class="scale"></td>
										<td>
											<div id="bookInfo">
												<b>《읽기만 하면 내 것이 되는 1페이지 미술 365》</b><br> <br> 《읽기만
												하면 내 것이 되는 1페이지 미술 365》는 매일 1페이지씩, 세계 명화 365점과 함께 미술의 모든 지식을
												단 한 권으로 만날 수 있는 책이다.<br> 월요일부터 일요일까지 명작, 미술사, 화가,
												장르·기법, 미술로 보는 세계사, 스캔들·미스터리, 신화·종교 총 일곱 분야의 지식을 다루고 있어 꼭 알아야
												할 미술 교양을 빠짐없이 쌓을 수 있다.
											</div>
										</td>
									</tr>
								</table>
							</div>
							<br>
							<div id="ex">
								<table>
									<tr>
										<td><img
											src="${pageContext.request.contextPath}/resources/img/ex2.jpg"
											width="150px" height="200px" class="scale"></td>
										<td>
											<div id="bookInfo">
												<b>《트렌드 코리아 21》</b><br> <br> 〈트렌드 코리아 21〉은 팬데믹
												속에서도 평정심을 유지하자는 뜻, 백신의 기원이 된 소의 해, 현실을 직시하되 희망을 잃지 말자는 의미에서
												COWBOY HERO를 2021의 10대 트렌드 키워드로 선정했다.<br> 날뛰는 소를 마침내
												길들이는 멋진 카우보이처럼, 시의적절한 전략으로 팬데믹의 위기를 헤쳐나가기를 기원하는 뜻을 담았다.
											</div>
										</td>
									</tr>
								</table>
							</div>
							<br>
							<div id="ex">
								<table>
									<tr>
										<td><img
											src="${pageContext.request.contextPath}/resources/img/ex3.jpg"
											width="150px" height="200px" class="scale"></td>
										<td>
											<div id="bookInfo">
												<b>《어떻게 말해줘야 할까》</b><br> <br> ‘국민 육아멘토’ ‘대한민국
												엄마·아빠들의 엄마’ 오은영 박사의 신간. 누구나 쉽게 따라 할 수 있는 ‘부모의 말 한마디’를 친절하게
												알려주는 책이다. <br> 아이에게 하는 부모의 말이 잔소리가 아니라 효과적인 훈육이 되는 방법을
												소개한다. <br> 차상미 작가의 그림을 여럿 더하여 따스함과 친근한 분위기도 느껴진다.
											</div>
										</td>
									</tr>
								</table>
							</div>
							<br>
						</div>
					</td>
					<td>
						<div id="box2">
							<div id="title">신규 도서</div>
							<div id="ex">
								<table>
									<tr>
										<td><img
											src="${pageContext.request.contextPath}/resources/img/ex4.jpg"
											width="150px" height="200px" class="scale"></td>
										<td>
											<div id="bookInfo">
												<b>《설민석의 한국사 대모험 15》</b><br> <br> 흥미진진한 스토리로 지식과
												재미, 감동과 교훈을 모두 담아낸 초등 학습만화. 블록버스터 액션 영화를 방불케 하는 설쌤과 온달, 로빈의
												태학 3인방 구출 작전이 펼쳐진다. <br> 긴박하게 펼쳐지는 설쌤 일행의 모험, 그리고 신라와
												백제의 찬란한 문화 이야기가 가득하다. <br>
												<설민석의한국사대모험15>는 어린이 독자들에게 신선한 재미와 유익한 지식을 선사할 것이다.
												
											</div>
										</td>
									</tr>
								</table>
							</div>
							<br>
							<div id="ex">
								<table>
									<tr>
										<td><img
											src="${pageContext.request.contextPath}/resources/img/ex5.jpg"
											width="150px" height="200px" class="scale"></td>
										<td>
											<div id="bookInfo">
												<b>《나의 하루는 4시 30분에 시작된다》</b><br> <br> 향긋한 차를 한잔하는
												여유로운 아침을 꿈꾸는가? 아침형 인간으로 다시 태어나겠다고 다짐하지만 ‘1분만 더 자고 싶다!’고 생각하다
												허겁지겁 하루를 시작하고 있지는 않은가? <br>그렇다면 이 책이 해답을 알려줄 것이다. <br>
												15만 팔로워를 가진 인기 유튜버이자 수년간 4시 30분에 하루를 시작해온 김유진 변호사가 아침 시간의 힘을
												이야기한다.
											</div>
										</td>
									</tr>
								</table>
							</div>
							<br>
							<div id="ex">
								<table>
									<tr>
										<td><img
											src="${pageContext.request.contextPath}/resources/img/ex6.jpg"
											width="150px" height="200px" class="scale"></td>
										<td>
											<div id="bookInfo">
												<b>《마음 챙김의 시》</b><br> <br> 사회적 거리두기와 삶에 대한 성찰이 어느
												때보다 필요한 지금, 손 대신 시를 건네는 것은 어떤가. <br> 멕시코의 복화술사, 영국 선원의
												선원장, 기원전 1세기의 랍비와 수피의 시인뿐 아니라 파블로 네루다와 비스와바 쉼보르스카 같은 노벨 문학상
												수상 시인, 페이스북과 인스타그램의 신세대 시인들, 그리고 라다크 사원 벽에 시를 적은 무명씨. 고대와
												중세와 현대의 시인들이 나와 타인에 대한 운율 깃든 성찰로 독자를 초대한다.
											</div>
										</td>
									</tr>
								</table>
							</div>
							<br>
					</td>
				</tr>
			</table>
		</div>
		<div class="fullsection full3" pageNum="3"
			style="background-image: url(${pageContext.request.contextPath}/resources/img/m7.jpg);">
			<table id="td">
				<tr>
					<td height="100px"></td>
				</tr>
				<tr>
					<td>
						<div id="box3">
							<div id="title">진행중인 행사</div>
							<div id="event">
								<table>
									<tr>
										<td><img
											src="${pageContext.request.contextPath}/resources/img/pen.jpg"
											width="600px" height="700px"></td>
										<td>
											<div id="bookInfo">
												<p id="p3title">
													<b><지역 작가 문학 특강></b>
												</p>
												<img
													src="${pageContext.request.contextPath}/resources/img/dott.jpg">
												<b>모집 안내</b><br> <br> - 수원시 거주 1년이상<br> <br>
												- 그린 도서관 1층 사무실에서 지원.<br> <br> - 전화량에 따라 통화지연이 생길
												수 있습니다.<br> <br> - 2020년 11월 05일 09:00시 <br>
												&nbsp; ~ 2020년 11월 25일 18:00시 까지 모집.<br> <br> -
												문의사항은 031)243 - 2111로 연락주세요.<br> <br> <br> <img
													src="${pageContext.request.contextPath}/resources/img/dott.jpg"><b>주의사항</b><br>
												<br> - 실내외 마스크 필수 착용<br> <br> - 입구에서 발열 체크, 손
												소독 필수<br> <br> - 방문일 기준 최근 14일 이내 해외방문자 입장불가<br>
												<br> - 사회적 거리두기 1~2m 준수<br> <br>
										</td>
									</tr>
								</table>
							</div>
							<br>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="fullsection full4" pageNum="4"
			style="background-image: url(${pageContext.request.contextPath}/resources/img/m12.jpg);">
			<table id="td">
				<tr>
					<td height="100px"></td>
				</tr>
				<tr>
					<td>
						<div id="box3">
							<div id="title">휴관일 및 행사 안내</div>
							<div id="event">
								<div id="calLocation">
									<iframe src="${pageContext.request.contextPath}/calendar"
										width="820" height="500" align="center" frameborder="0">
									</iframe>
									<br>
								</div>
								<div id="calLocation2">
									<b><p id="humu">&nbsp;&nbsp;&nbsp;※매주 월요일은 휴무 입니다.</p>
										<br> &nbsp;&nbsp;&nbsp;- 11월 25일 사이트 제작 완료.<br>
									<br> &nbsp;&nbsp;&nbsp;- 11월 27일 3조 발표. <br>
									<br>
								</div>
							</div>
							<br>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	 <script  src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</body>
</html>