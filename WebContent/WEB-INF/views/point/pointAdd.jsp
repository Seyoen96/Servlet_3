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
	  <h2>Point Add Form</h2>
	  <form class="form-horizontal" action="../point/pointAdd" method="POST">
	  
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=name>Name:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="num">Num:</label>
	      <div class="col-sm-10">          
	        <input type="text" class="form-control" id="num" placeholder="Enter num" name="num">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=kor>Kor:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="kor" placeholder="Enter kor" name="kor">
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="eng">Eng:</label>
	      <div class="col-sm-10">          
	        <input type="text" class="form-control" id="eng" placeholder="Enter eng" name="eng">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=math>Math:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="math" placeholder="Enter math" name="math">
	      </div>
	    </div>
	    
	    
	    
	    
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default">Submit</button>
	        <!-- <input type="submit" class="btn btn-default">Submit2 -->
	      </div>
	    </div>
	  </form>
	</div>

	
	
	
		
	
</body>
</html>


