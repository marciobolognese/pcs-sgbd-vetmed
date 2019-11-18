<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Atualizar Sala</title>
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

	<div id="containeralocaloginform" class=container-fluid>
		<div class="col-sm-1"></div>
		<div class="col-sm-8">
			<h2>Alterar Senha</h2>
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
				<form action="${pageContext.request.contextPath}/LoginController?action=edit" class="form-horizontal" method="POST">
					<div class="row">
						<div class="form-group">
							<label for="senha" class="control-label col-sm-2">Senha Atual:</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="senha" name="senha" placeholder="Ex.: aaa99"
									value="<c:out value="${login.senha}" />"/>
							</div>
						</div>
						<div class="form-group">
							<label for="senhaNova" class="control-label col-sm-2">Senha Nova:</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="senhaNova" name="senhaNova" placeholder="Ex.: aaa99"
									value="<c:out value="${senhaNova}" />"/>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-9 col-sm-8">
								<input type="submit" class="btn btn-default" value="Atualizar" />
							</div>
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