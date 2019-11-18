<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Erro</title>
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

	<%@page import="model.Agendamento"%>
	<%@page import="java.util.List"%>
	<%@page import="controller.AgendamentoController"%>

	<div id="espaco" class="col-sm-11"></div>
	<div id="espaco" class="col-sm-11"></div>

	<div class="container">
		<div class="row">
			<div class="col-sm-7">
				<h2>
					<b>Erro!</b>
				</h2>
				<br>
				<h4>
					Ops! Desculpe, ocorreu um erro!&nbsp &nbsp
					<c:if test="${msg!=null}">
							<c:out value="${msg}"></c:out>
					</c:if>
				</h4>
				<br>

			</div>
		</div>
	</div>

	<div id="espaco" class="col-sm-11"></div>
	<div id="espaco" class="col-sm-11"></div>


</body>
</html>