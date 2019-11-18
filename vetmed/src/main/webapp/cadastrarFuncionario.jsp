<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Cadastro Funcionario</title>
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
	<c:import url="mostraLogo.jsp" />

	<div id="espaco" class="col-sm-11"></div> 
	 
	<div id="containerfuncionarioform" class=container-fluid>		
			<div class="col-sm-1"></div>
			<div class="col-sm-8">
      			<h2>Cadastrar Funcionario</h2>
        		<br>
        		
        		<c:choose>
    				<c:when test="${msg!=null}">	
						<div id="divalert" class="alert alert-success" role="alert">
		  					<strong><c:out value="${msg}"></c:out></strong>
						</div>
						<script >window.setTimeout(function setTimeoutMsgSucesso () {
	   					$(".alert").fadeTo(100, 0).slideUp(100, function () {
	        				$(this).remove();
	    					});
						}, 1000);
					</script>
					</c:when>
					<c:when test="${msgerro!=null}">
						<div id="divalert" class="alert alert-danger" role="alert">
			  				<strong><c:out value="${msgerro}"></c:out></strong>
						</div>
						<script >window.setTimeout(function setTimeoutMsgSucesso () {
	   						$(".alert").fadeTo(100, 0).slideUp(100, function () {
	        				$(this).remove();
	    					});
					}, 1000);
					</script>
					</c:when>
				</c:choose>
				
        		<div class="container">

					  <form action="${pageContext.request.contextPath}/FuncionarioController?action=insert"  class="form-horizontal" method="POST">
					    <div class="form-group">
					      <label for="idFuncionario" class="control-label col-sm-2">Id Funcionario:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="idFuncionario" name="idFuncionario" placeholder="Ex.: 999"
					        		value="<c:out value="${funcionario.idFuncionario}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="nomeFuncionario" class="control-label col-sm-2">Nome Funcionario:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="nomeFuncionario" name="nomeFuncionario" placeholder="Ex.: aaaa"
					        		value="<c:out value="${funcionario.nomeFuncionario}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="cpfFuncionario" class="control-label col-sm-2" >CPF Funcionario:</label>
					      <div class="col-sm-8">          
					        <input type="text" class="form-control" id="cpfFuncionario" name="cpfFuncionario" placeholder="Ex.: 999"
					        	value="<c:out value="${funcionario.cpfFuncionario}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="dataNascFuncionario" class="control-label col-sm-2" >Data Nasc Funcionario:</label>
					      <div class="col-sm-8">
					        <input type="text" class="form-control" id="dataNascFuncionario" name="dataNascFuncionario" placeholder="Ex.: dd/mm/aaaa" 
					        data-mask="dd/MM/yyyy" value="<c:out value="${funcionario.procedimento}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="salario" class="control-label col-sm-2">Salario:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="salario" name="salario" placeholder="Ex.: 999.99"
					        		value="<c:out value="${funcionario.salario}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="tipo" class="control-label col-sm-2">Tipo:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="tipo" name="tipo" placeholder="Ex.: aaaa"
					        		value="<c:out value="${funcionario.tipo}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="cargo" class="control-label col-sm-2">Cargo:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="cargo" name="cargo" placeholder="Ex.: aaaa"
					        		value="<c:out value="${funcionario.cargo}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="crm" class="control-label col-sm-2">CRM:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="crm" name="crm" placeholder="Ex.: aaaa"
					        		value="<c:out value="${funcionario.crm}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">        
					      <div class="col-sm-offset-9 col-sm-8">
					        <input type="submit" class="btn btn-default" value="Incluir"/>
					      </div>
					    </div>
					    
					  </form>
				</div>
        	</div>
        	<div class="col-sm-2"></div>
		</div>

<div id="espaco" class="col-sm-11"></div>  

<c:import url="rodape.jsp" />
	
</body>
</html>