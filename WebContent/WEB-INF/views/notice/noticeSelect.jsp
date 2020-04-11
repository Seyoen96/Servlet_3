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

	 <!-- <input type="submit" class="btn btn-default">Submit2 -->
	<input class="btn btn-success btnHid" value="Update" onclick="location.href='./noticeMod?no=${noDto.no}'">
	<input class="btn btn-danger btnHid" value="Delete" onclick="location.href='./noticeDelete?no=${noDto.no}'">

  </form>
</div>

	<script type="text/javascript">
		$(".btnHid").prop("type","${type}")
	
	
	</script>


</body>
</html>