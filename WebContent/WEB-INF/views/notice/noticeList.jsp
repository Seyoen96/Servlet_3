<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<div class="row">
		<h1>Notice List</h1>
			<table class="table table-hover">
			<thead>
				<tr>
					<td>No.</td>
					<td colspan="2">제목</td>
					<td>작성자</td>
					<td>Date</td>
				</tr>
			</thead>
			
			<c:forEach items="${noticeList}" var="noDto">
				<tr>
					<td>${noDto.no}</td>
					<td colspan="2"><a href="./noticeSelect?no=${noDto.no}">${noDto.sub}</a></td>
					<td>관리자</td>
					<td>${noDto.nodate}</td>
				</tr>
			</c:forEach>
				
			
			</table>
			
			<a href="./noticeAdd" class="btn btn-primary">Add Content</a>
			
			
		</div>
	
	</div>



</body>
</html>