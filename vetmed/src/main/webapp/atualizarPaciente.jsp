<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Atualiza Paciente</title>
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
      			<h2>Atualizar Dados de Paciente</h2>
        		<br>
        		
        		<c:if test="${msg!=null}">
					<div id="divalert" class="alert alert-success" role="alert">
	  					<strong><c:out value="${msg}"></c:out></strong>
					</div>
					<script >window.setTimeout(function setTimeoutMsgSucesso () {
	   					$(".alert").fadeTo(100, 0).slideUp(100, function () {
	        				$(this).remove();
	    					});
						}, 1000);
					</script>
				</c:if>
				
        		<div class="container">
					  <form action="${pageContext.request.contextPath}/PacienteController?action=edit" class="form-horizontal" method="POST">
					    
					    <div class="form-group">
					      <label for="matricula" class="control-label col-sm-2">Matricula:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="matricula" name="matricula" placeholder="Ex.: 999" readonly="true"
					        		required value="<c:out value="${paciente.matricula}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="nomepaciente" class="control-label col-sm-2">Paciente:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="nomePaciente" name="nomePaciente" placeholder="Ex.: aaa"
					        		value="<c:out value="${paciente.nomePaciente}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="cpfresponsavel" class="control-label col-sm-2" >CPF Responsavel:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="cpfResponsavel" name="cpfResponsavel" placeholder="Ex.: aaa"
					        		value="<c:out value="${paciente.cpfResponsavel}" />"/>
					      </div>
					    </div>

					    <div class="form-group">
					      <label for="datanasc" class="control-label col-sm-2" >Data Nasc Paciente:</label>
					      <div class="col-sm-8">
					        <input type="text" class="form-control" id="dataNascPaciente" name="dataNascPaciente" placeholder="Ex.: dd/mm/aaaa"
					        	data-mask="dd/MM/yyyy" value="<c:out value="${paciente.dataNascPaciente}" />"/>
					      </div>
					    </div>
				    			    
					    <div class="form-group">        
					      <div class="col-sm-offset-9 col-sm-8">
					        <input type="submit" class="btn btn-default" value="Atualizar"/>
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