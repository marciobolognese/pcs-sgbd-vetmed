<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Atualiza Agendamento</title>
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
	 
	<div id="containeragendamentoform" class=container-fluid>		
			<div class="col-sm-1"></div>
			<div class="col-sm-8">
      			<h2>Atualizar Agendamento</h2>
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

					  <form action="${pageContext.request.contextPath}/AgendamentoController?action=edit" class="form-horizontal" method="POST">
					    <div class="form-group">
					      <label for="codAgendamento" class="control-label col-sm-2">Codigo Agendamento:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="codAgendamento" name="codAgendamento" placeholder="Ex.: 999"  readonly="true"
					        		value="<c:out value="${agendamento.codAgendamento}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="matriculaPaciente" class="control-label col-sm-2">Matricula Paciente:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="matriculaPaciente" name="matriculaPaciente" placeholder="Ex.: 999"
					        		value="<c:out value="${agendamento.matriculaPaciente}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="codSala" class="control-label col-sm-2" >Codigo Sala:</label>
					      <div class="col-sm-8">          
					        <input type="text" class="form-control" id="codSala" name="codSala" placeholder="Ex.: 999"
					        	value="<c:out value="${agendamento.codSala}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="procedimento" class="control-label col-sm-2" >Procedimento:</label>
					      <div class="col-sm-8">
					        <input type="text" class="form-control" id="procedimento" name="procedimento" placeholder="Ex.: aaa"
					        	value="<c:out value="${agendamento.procedimento}" />"/>
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