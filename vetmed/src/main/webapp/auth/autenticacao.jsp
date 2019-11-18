<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Autenticacao</title>
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
    
    <nav id="menu" class="navbar navbar-inverse">
    	<div class="container-fluid">
    		<div class="navbar-header">
     	 	<a class="navbar-brand" href="VetMed"></a>
    	</div>
   		 <ul class="nav navbar-nav">
      		<li class="active"><a href="index.jsp">Login</a></li>
      		<li><a href="#">Contato</a></li>
    	</ul>
  		</div>
	</nav>
	
	
	<c:import url="mostraLogo.jsp" />
	
	<div id="containerloginform" class=container-fluid>		
			<div class="col-sm-1"></div>
			<div class="col-sm-8">
      			<h2>Login</h2>
        		<br>
        		
        		<c:if test="${msgerro!=null}">
					<div id="divalert" class="alert alert-danger" role="alert">
	  					<strong><c:out value="${msgerro}"></c:out></strong>
					</div>
					<script >window.setTimeout(function setTimeoutMsgSucesso () {
	   					$(".alert").fadeTo(100, 0).slideUp(100, function () {
	        				$(this).remove();
	    					});
						}, 1000);
					</script>
				</c:if>
				
        		<div class="container">

					  <form action="${pageContext.request.contextPath}/LoginController?action=insert"  class="form-horizontal" method="POST">
					    <div class="form-group">
					      <label for="usuario" class="control-label col-sm-3">Usuario:</label>
					      <div class="col-xs-5">          
					        	<input type="text" class="form-control" id="usuario" name="usuario" placeholder="Ex.: aaa"
					        		value="<c:out value="${setor.idUsuario}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="senha" class="control-label col-sm-3">Senha:</label>
					      <div class="col-xs-5">          
					        	<input type="password" class="form-control" id="senha" name="senha" placeholder="Ex.: aaa99"
					        		value="<c:out value="${setor.senha}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">        
					      <div class="col-sm-offset-7 col-sm-8">
					        <input type="submit" class="btn btn-default" value="Entrar"/>
					      </div>
					    </div>
					    
					  </form>
				</div>
        	</div>
        	<div class="col-sm-2"></div>
		</div>
	
	<c:import url="rodape.jsp" />
	
</body>
</html>
