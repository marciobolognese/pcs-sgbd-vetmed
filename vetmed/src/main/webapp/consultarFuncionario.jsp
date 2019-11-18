<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Consulta Funcionario</title>
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
	
	<%@page import="model.Funcionario"%>
	<%@page import="java.util.List"%>
	<%@page import="controller.FuncionarioController"%>

	<div id="espaco" class="col-sm-11"></div> 
	 
	<div id="containerfuncionarioform" class=container-fluid>
			<div class="col-sm-2"></div>		
			<div class="col-sm-8">
      			<h2>Consulta de Funcionarios</h2>
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
					      <a href="${pageContext.request.contextPath}/FuncionarioController?action=list">Listar Funcionarios</a>
					   </div>
					</div>
					
					<div class="col-sm-10"> 	 
						 <div class="table-responsive">
						 	<br>
						 	<h4>Dados da Consulta</h4>          
						 	<table class="table" id="consultafuncionariotable">
								<thead>
									<tr>
								        <th>Id Funcionario</th>
								        <th>Nome Funcionario</th>
								        <th>CPF Funcionario</th>
								        <th>Data Nasc Funcionario</th>
								        <th>Salario</th>
								        <th>Tipo</th>
								        <th>Cargo</th>
								        <th>CRM</th>
								     </tr>
								 </thead>
								<tbody>
								   <c:forEach items="${funcionarios}" var="funcionario">   
								      <tr>
								        <td>${funcionario.idFuncionario}</td>		   
										<td>${funcionario.nomeFuncionario}</td>		   
										<td>${funcionario.cpfFuncionario}</td>
										<td>${funcionario.dataNascFuncionario}</td>
										<td>${funcionario.salario}</td>
										<td>${funcionario.tipo}</td>
										<td>${funcionario.cargo}</td>
										<td>${funcionario.crm}</td>
										<td><a href="FuncionarioController?action=atualiza&idFuncionario=<c:out value="${funcionario.idFuncionario}"/>">
                    						<input type="button" class="btn btn-info" value="Editar"/></a></td>
                    					<td><a href="FuncionarioController?action=delete&idFuncionario=<c:out value="${funcionario.idFuncionario}"/>">
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
					        <input id="btncadfunc" type="button" class="btn btn-default" onclick ="redirectcadastrafuncionario()" value="Cadastrar Funcionario"/>
					      </div>		      
					  </div>   
				</div>
	</div>

				
	<div id="espaco" class="col-sm-11"></div>  

	<c:import url="rodape.jsp" />
	
</body>
</html>