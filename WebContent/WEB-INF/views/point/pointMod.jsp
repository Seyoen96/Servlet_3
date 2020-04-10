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
	  <h1>Point Modify Form</h1>
	  <form class="form-horizontal" action="../point/pointMod" method="POST">
	  
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=name>Name:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control check" id="name" placeholder="Enter name" name="name" value="${dto.name}">
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="num">Num:</label>
	      <div class="col-sm-10">          
	        <input type="text" class="form-control check" id="num" placeholder="Enter num" name="num" value="${dto.num}" readonly="readonly">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=kor>Kor:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control check" id="kor" placeholder="Enter kor" name="kor" value="${dto.kor}">
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="eng">Eng:</label>
	      <div class="col-sm-10">          
	        <input type="text" class="form-control check" id="eng" placeholder="Enter eng" name="eng" value="${dto.eng}">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for=math>Math:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control check" id="math" placeholder="Enter math" name="math" value="${dto.math}">
	      </div>
	    </div>
	    
	    
	    
	    
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default" id="btnCheck">Submit</button>
	        <!-- <input type="submit" class="btn btn-default">Submit2 -->
	      </div>
	    </div>
	  </form>
	</div>
	
	
	
	<script type="text/javascript">
		var check = document.getElementsByClassName("check");
		var btnCheck = document.getElementById("btnCheck");
		
		btnCheck.addEventListener("click",function(e){		
			for(i=0; i<check.length;i++){
				if(check[i].value.length==0){
					alert("값을 입력하세요");
					e.preventDefault();
					break;
				}
			}	
		});
		
	
	
	</script>
	
	
</body>
</html>