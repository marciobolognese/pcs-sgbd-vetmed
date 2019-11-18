<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Consultar Agendamento</title>
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
	
	<%@page import="model.Agendamento"%>
	<%@page import="java.util.List"%>
	<%@page import="controller.AgendamentoController"%>

	<div id="espaco" class="col-sm-11"></div> 
	 
	<div id="containeragendamentoform" class=container-fluid>
			<div class="col-sm-2"></div>		
			<div class="col-sm-8">
      			<h2>Consulta de Agendamento</h2>
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
					<div class="form-group">        
					   <div class="col-sm-3">
					      <a href="${pageContext.request.contextPath}/AgendamentoController?action=list">Listar Agendamentos</a>
					   </div>
					</div>
					
					<div class="col-sm-10"> 	 
						 <div class="table-responsive">
						 	<br>
						 	<h4>Dados da Consulta</h4>          
						 	<table class="table" id="consultaagendamentotable">
								<thead>
									<tr>
								        <th>Codigo Agendamento</th>
								        <th>Matricula Paciente</th>
								        <th>Codigo da Sala</th>
								        <th>Procedimento</th>
								     </tr>
								 </thead>
								<tbody>						
								   <c:forEach items="${agendamentos}" var="agendamento">   
								      <tr>
								        <td>${agendamento.codAgendamento}</td>		   
										<td>${agendamento.matriculaPaciente}</td>		   
										<td>${agendamento.codSala}</td>
										<td>${agendamento.procedimento}</td>
										<td><a href="AgendamentoController?action=atualiza&codAgendamento=<c:out value="${agendamento.codAgendamento}"/>">
                    						<input type="button" class="btn btn-info" value="Editar"/></a></td>
                    					<td><a href="AgendamentoController?action=delete&codAgendamento=<c:out value="${agendamento.codAgendamento}"/>">
                    						<input type="button" class="btn btn-danger" value="Excluir"/></a></td>
								      </tr>
								   </c:forEach>
								</tbody>		
							</table>
						</div>
					</div>
				</div>
			</div>
	</div>
	
	<div id="espaco" class="col-sm-11"></div>
	<div id="espaco" class="col-sm-11"></div>
	
	<div class=container-fluid>
			<div class="col-sm-3"></div>
			<div class="col-sm-7">    
					  <div class="row">   
					      <div class="col-4 col-sm-offset-4">
					        <input id="btncadag" type="button" class="btn btn-default" onclick ="redirectcadastraagendamento()" value="Cadastrar Agendamento"/>
					      </div>			      
					  </div>   
				</div>
	</div>

				
	<div id="espaco" class="col-sm-11"></div>  

	<c:import url="rodape.jsp" />
	
</body>
</html>