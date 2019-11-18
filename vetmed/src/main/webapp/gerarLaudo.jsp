<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Gerar Laudo</title>
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
	 
	<div id="containerlaudoform" class=container-fluid>		
			<div class="col-sm-1"></div>
			<div class="col-sm-8">
      			<h2>Gerar Laudo</h2>
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

					  <form action="${pageContext.request.contextPath}/LaudoController?action=insert" class="form-horizontal" method="POST">
					    
					    <div class="form-group">
					      <label for="nomepaciente" class="control-label col-sm-2">Código Laudo:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="nomePaciente" name="nomePaciente" placeholder="Ex.: 999"
					        	value="<c:out value="${laudo.idLaudo}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="nomepaciente" class="control-label col-sm-2">Paciente:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="nomePaciente" name="nomePaciente" placeholder="Ex.: aaa"
					        	value="<c:out value="${laudo.nomePaciente}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="diagnostico" class="control-label col-sm-2" >Diagnóstico paciente:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="diagnostico" name="diagnostico" placeholder="Ex.: aaa"
					        		value="<c:out value="${laudo.diagnostico}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="conduta" class="control-label col-sm-2" >Conduta terapêutica:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="conduta" name="conduta" placeholder="Ex.: aaa"
					        		value="<c:out value="${laudo.conduta}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="repouso" class="control-label col-sm-2" >Tempo de Repouso:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="repouso" name="repouso" placeholder="Ex.: aaa99"
					        		value="<c:out value="${laudo.repouso}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="dataexame" class="control-label col-sm-2" >Data do Exame:</label>
					      <div class="col-sm-8">
					        <input type="text" class="form-control" id="dataexame" name="dataexame" placeholder="Ex.: dd/mm/aaaa" 
					        data-mask="dd/MM/yyyy" value="<c:out value="${laudo.dataExame}" />"/>
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