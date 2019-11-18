<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Consultar Setor</title>
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
	
	<%@page import="model.Setor"%>
	<%@page import="java.util.List"%>
	<%@page import="controller.SetorController"%>

	<div id="espaco" class="col-sm-11"></div> 
	 
	<div id="containersetorform" class=container-fluid>
			<div class="col-sm-2"></div>		
			<div class="col-sm-8">
      			<h2>Consulta de Setor</h2>
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
					      <a href="${pageContext.request.contextPath}/SetorController?action=list">Listar Setores</a>
					   </div>
					</div>
					
					<div class="col-sm-10"> 	 
						 <div class="table-responsive">
						 	<br>
						 	<h4>Dados da Consulta</h4>          
						 	<table class="table" id="consultasetortable">
								<thead>
									<tr>
								        <th>Id Setor</th>
								        <th>Nome Setor</th>
								     </tr>
								 </thead>
								<tbody>
								   <c:forEach items="${setores}" var="setor">   
								      <tr>
								        <td>${setor.idSetor}</td>		   
										<td>${setor.nomeSetor}</td>
                    					<td><a href="SetorController?action=atualiza&idSetor=<c:out value="${setor.idSetor}"/>">
                    						<input type="button" class="btn btn-info" value="Editar"/></a></td>
                    					<td><a href="SetorController?action=delete&idSetor=<c:out value="${setor.idSetor}"/>">
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
					        <input id="btncadsetor" type="button" class="btn btn-default" onclick ="redirectcadastrasetor()" value="Cadastrar Setor"/>
					      </div>		      
					  </div>   
				</div>
	</div>

				
	<div id="espaco" class="col-sm-11"></div>  

	<c:import url="rodape.jsp" />
	
</body>
</html>