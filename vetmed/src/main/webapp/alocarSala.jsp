<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Alocar sala para procedimento</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<script type="text/javascript" src="assets/js/script.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<c:import url="menuInicio.jsp" />
	<c:import url="mostraLogo.jsp" />

	<div id="espaco" class="col-sm-11"></div>

	<div id="containeralocasalaform" class=container-fluid>
		<div class="col-sm-1"></div>
		<div class="col-sm-8">
			<h2>Alocar Sala para Procedimento</h2>
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
				<form action="${pageContext.request.contextPath}/SalaController?action=insert" class="form-horizontal" method="POST">
					<div class="row">
						<div class="form-group">
							<label for="codSala" class="control-label col-sm-2">Codigo Sala:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="codSala" name="codSala" placeholder="Ex.: 999"
									value="<c:out value="${sala.codSala}" />"/>
							</div>
						</div>
						<div class="form-group">
							<label for="sala" class="control-label col-sm-2">Sala:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="sala" name="sala" placeholder="Ex.: aaa99"
									value="<c:out value="${sala.sala}" />"/>
							</div>
						</div>

						<div class="form-group">
							<label for="data" class="control-label col-sm-2">Data:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="data" name="data" placeholder="Ex.: dd/mm/aaaa"
									value="<c:out value="${sala.data}" />"/>
							</div>
						</div>

						<div class="form-group">
							<label for="horario" class="control-label col-sm-2">Horario:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="horario" name="horario" placeholder="Ex.: hh:mm h"
									data-mask="dd/MM/yyyy" value="<c:out value="${sala.horario}" />"/>
							</div>
						</div>

						<div class="form-group">
							<label for="alocada" class="control-label col-sm-2">Alocada?:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="alocada" name="alocada" placeholder="Ex.: aaa"
									value="<c:out value="${sala.alocada}" />"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="setor" class="control-label col-sm-2">Setor:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="setor" name="setor" placeholder="Ex.: aaa99"
									value="<c:out value="${sala.setor}" />"/>
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-9 col-sm-8">
							<input type="submit" class="btn btn-default" value="Enviar" />
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