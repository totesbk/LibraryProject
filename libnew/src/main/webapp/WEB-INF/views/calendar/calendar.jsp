<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>달력</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" 
integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
crossorigin="anonymous" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/calendar.css"/>
<meta charset="utf-8" />
</head>
<body>
	<div class="world">
		<div class="conatiner">
			<div class="container_left">
				<div>
					<div id="pointDay"></div>
					<div id="pointDate"></div>
				</div>
				<div class="container_left_bot">
					<div class="todo-title">To do list :</div>
					<form class="js-toDoForm">
						<input type="text" placeholder="Write a to do!"
							class="add-event-day" /> <i id="deleteAll"
							class="fas fa-trash"></i>
					</form>
					<ul class="js-toDoList"></ul>
				</div>
			</div>
			<div class="container_right">
				<table id="calendar" align="center">
					<thead>
						<tr>
							<td><label onclick="prevCalendar();"><</label></td>
							<td align="center" id="monthAndYear" colspan="5"></td>
							<td><label onclick="nextCalendar()">> </label></td>
						</tr>
						<tr>
							<td align="center">일</td>
							<td align="center">월</td>
							<td align="center">화</td>
							<td align="center">수</td>
							<td align="center">목</td>
							<td align="center">금</td>
							<td align="center">토</td>
						</tr>
					</thead>
					<tbody id="calendar-body"></tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/calendar.js"></script>
</body>
</html>