<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Registrar Pagamento</title>
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
	
	<%@page import="model.Pagamento"%>
	<%@page import="java.util.List"%>
	<%@page import="controller.PagamentoController"%>

	<div id="espaco" class="col-sm-11"></div> 
	 
	<div id="containerprontuarioform" class=container-fluid>		
			<div class="col-sm-1"></div>
			<div class="col-sm-8">
      			<h2>Registrar Pagamento</h2>
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

					  <form action="${pageContext.request.contextPath}/PagamentoController?action=insert_p"  class="form-horizontal" method="POST">
					    
					    <div class="form-group">
					      <label for="idPagto" class="control-label col-sm-2">Cod Pagamento:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="idPagto" name="idPagto" readonly="true"
					        	value="<c:out value="${pagamento.idPagto}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="paciente" class="control-label col-sm-2">Paciente:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="paciente" name="paciente" readonly="true"
					        	value="<c:out value="${pagamento.paciente}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">				    
					    	<label for="tipo" class="control-label col-sm-2">Tipo Pagamento:</label>
					      		<div class="col-sm-8">          
					        		<input type="text" class="form-control" id="tipo" name="tipo" readonly="true"
					        		value="<c:out value="${pagamento.tipo}" />"/>
					     	 </div>
					    </div>
					    
					    <div class="form-group">				    
					    	<label for="formaPagto" class="control-label col-sm-2">Forma de Pagamento:</label>
					   		<div class="col-sm-8">
 							 	<select class="form-control" id="formaPagto" name="formaPagto">
 									<option>Selecione um valor</option>
    								<option>dinheiro</option>
    								<option>cartao</option>
  							 	</select>
  						 	</div>
					    </div>
					    
					    <div class="form-group">
					      <label for="valor" class="control-label col-sm-2">Valor:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="valor" name="valor" placeholder="Ex.: R$ 9999,99"
					        	value="<c:out value="${pagamento.valor}" />"/>
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