<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Index</title>
  	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
  	<link rel="stylesheet" type="text/css" href="assets/css/style.css">
  	<script type="text/javascript" src="assets/js/script.js"></script> 
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 </head>
 <body>
    
    <c:import url="menuInicio.jsp" />
	<c:import url="cabecalho.jsp" />
	
	<div class=container-fluid>
		<br>
	</div>
	
	<div class=container-fluid>
		<div id='content' class='row-fluid'>
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">

			  	<!-- Wrapper for slides -->
			  		<div class="carousel-inner">
			    	<div id="imagem" class="item active">	
			      		<img src="assets/img/pet2.jpg" alt="pet 2">
			    	</div>
			
			    	<div id="imagem" class="item">
			      		<img src="assets/img/pet1.png" alt="pet 1">
			    	</div>
			
			    	<div id="imagem" class="item">
			      		<img src="assets/img/pet3.jpg" alt="pet 3">
			     </div>
			 	 </div>

				  	<!-- Left and right controls -->
				  	<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				   		<span class="glyphicon glyphicon-chevron-left"></span>
				    	<span class="sr-only">Anterior</span>
				  	</a>
				  	<a class="right carousel-control" href="#myCarousel" data-slide="next">
				    	<span class="glyphicon glyphicon-chevron-right"></span>
				    	<span class="sr-only">Proximo</span>
				  	</a>
				  </div>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
	
	<c:import url="rodape.jsp" />
	
</body>
</html>
