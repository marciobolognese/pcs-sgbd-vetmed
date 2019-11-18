<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Consulta Laudo</title>
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
	
	<%@page import="model.Laudo"%>
	<%@page import="java.util.List"%>
	<%@page import="controller.LaudoController"%>
	
	<div id="espaco" class="col-sm-11"></div> 
	 
	<div id="containerlaudoform" class=container-fluid>
			<div class="col-sm-2"></div>		
			<div class="col-sm-8">
      			<h2>Consulta de Laudo</h2>
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
					      <a href="${pageContext.request.contextPath}/LaudoController?action=list">Listar Laudos</a>
					   </div>
					</div>
					
					
					<div class="col-sm-10"> 	 
						 <div class="table-responsive">
						 	<br>
						 	<h4>Dados do Laudo</h4>          
						 	<table class="table" id="consultalaudotable">
								<thead>
									<tr>
										<th>Cod Laudo</th>
								        <th>Paciente</th>
								        <th>Diagnóstico</th>
								        <th>Conduta</th>
								        <th>Repouso</th>
								        <th>Data Exame</th>
								     </tr>
								 </thead>
								<tbody>
									<c:forEach var="laudo" items="${laudos}"> 
								      <tr>
										<td>${laudo.idLaudo}</td>								      
								        <td>${laudo.nomePaciente}</td>		   
										<td>${laudo.diagnostico}</td>		 
										<td>${laudo.conduta}</td>
										<td>${laudo.repouso}</td>
										<td>${laudo.dataExame}</td>
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
					        <input id="btncadlaudo" type="button" class="btn btn-default" onclick ="redirectgerarlaudo()" value="Gerar Laudo"/>
					      </div>			      
					  </div>   
				</div>
	</div>

				
	<div id="espaco" class="col-sm-11"></div>  

	<c:import url="rodape.jsp" />
	
</body>
</html>