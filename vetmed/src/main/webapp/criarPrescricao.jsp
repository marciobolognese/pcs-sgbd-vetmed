<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Criar Prescricao</title>
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
	 
	<div id="containerpacienteform" class=container-fluid>		
			<div class="col-sm-1"></div>
			<div class="col-sm-8">
      			<h2>Criar Prescricao</h2>
        		
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

					  <form action="${pageContext.request.contextPath}/PrescricaoController?action=insert" class="form-horizontal" method="POST">
					    
					    <div class="form-group">
					      <label for="idprescricao" class="control-label col-sm-2">No Prescricao</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="idprescricao" name="idprescricao" placeholder="Ex.: aaa"
					        		value="<c:out value="${prescricao.idPrescricao}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="data" class="control-label col-sm-2">Data:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="data" name="data" placeholder="Ex.: 99/99/99"
					        		value="<c:out value="${prescricao.data}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="local" class="control-label col-sm-2">Local:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="local" name="local" placeholder="Ex.: aaa"
					        		value="<c:out value="${prescricao.local}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="medico" class="control-label col-sm-2">Medico:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="medico" name="medico" placeholder="Ex.: 999"
					        		value="<c:out value="${prescricao.medico}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="paciente" class="control-label col-sm-2">Paciente:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="paciente" name="paciente" placeholder="Ex.: aaa"
					        	value="<c:out value="${prescricao.paciente}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="receita" class="control-label col-sm-2" >Receita:</label>
					      <div class="col-sm-8">
					        <textarea class="form-control" rows="5" id="receita">
					        <c:out value="${prescricao.receita}" /></textarea>
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