<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">WebSiteName</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="#">Page 1-1</a></li>
	          <li><a href="#">Page 1-2</a></li>
	          <li><a href="#">Page 1-3</a></li>
	        </ul>
	      </li>
	      <li><a href="${pageContext.request.contextPath}/point/pointList">Point</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    </ul>
	  </div>
	</nav>
  
  
  
	<div class="container">
	  <div class="jumbotron">
	    <h1>Bootstrap Tutorial</h1>      
	    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on the web.</p>
	  </div>
	  <p>This is some text.</p>      
	  <p>This is another text.</p>      
	</div>
	
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