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
  
  <form action="../notice/noticeAdd" method="POST">
  
  <div class="row">
    <div class="form-group">
      <label for="sub">제목:</label>
      <input type="text" class="form-control" name="sub" placeholder="insert subject">
    </div>
    
	<div class="form-group">
	  <label for="contents">내용:</label>
	  <textarea class="form-control" rows="5" name="contents" placeholder="insert contents"></textarea>
	</div>    



	<div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default" id="btnCheck">Add</button>
	        <!-- <input type="submit" class="btn btn-default">Submit2 -->
	      </div>
	  </div>

	
	</div>
  </form>
</div>


</body>
</html>