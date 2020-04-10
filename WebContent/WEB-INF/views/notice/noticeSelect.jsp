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
  
  <form>
    <div class="form-group">
      <label for="sub">제목:</label>
      <input type="text" class="form-control" id="sub" disabled="disabled" value="${noDto.sub}">
    </div>
    
	<div class="form-group">
	  <label for="contents">내용:</label>
	  <textarea class="form-control" rows="5" id="comment" disabled="disabled">${noDto.contents}</textarea>
	</div>    

	<a href="./noticeMod?no=${noDto.no}" class="btn btn-success">Update</a>
	<a href="./noticeDelete?no=${noDto.no}" class="btn btn-danger" role="button">Delete</a>

  </form>
</div>


</body>
</html>