<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Consulta Prontuario</title>
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
	
	<%@page import="model.Prontuario"%>
	<%@page import="java.util.List"%>
	<%@page import="controller.ProntuarioController"%>
	
	<div id="espaco" class="col-sm-11"></div> 
	 
	<div id="containerprontuarioform" class=container-fluid>
			<div class="col-sm-2"></div>		
			<div class="col-sm-8">
      			<h2>Consulta de Prontuario</h2>
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
					      <a href="${pageContext.request.contextPath}/ProntuarioController?action=list">Listar Prontuario</a>
					   </div>
					</div>
					
					
					<div class="col-sm-10"> 	 
						 <div class="table-responsive">
						 	<br>
						 	<h4>Dados da Consulta</h4>          
						 	<table class="table" id="consultaprontuariotable">
								<thead>
									<tr>
								        <th>Matricula</th>
								        <th>Paciente</th>
								        <th>Laudos</th>
								        <th>Procedimentos</th>
								        <th>Exames</th>
								        <th>Receitas</th>
								     </tr>
								 </thead>
								<tbody>
									<c:forEach var="prontuario" items="${prontuarios}"> 
								      <tr>
								        <td>${paciente.matricula}</td>		   
										<td>${paciente.nomePaciente}</td>		 
										<td>${paciente.laudo}</td>
										<td>${paciente.procedimento}</td>
										<td>${paciente.exame}</td>
										<td>${paciente.receita}</td>
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
					      		<input id="btnconpront" type="button" class="btn btn-default" onclick ="redirectconsultarprontuario()" value="Salvar"/>
					      		<input id="btnconpront" type="button" class="btn btn-default" onclick ="()" value="Imprimir"/>
					      </div>			      
					  </div>   
				</div>
	</div>

				
	<div id="espaco" class="col-sm-11"></div>  

	<c:import url="rodape.jsp" />
	
</body>
</html>