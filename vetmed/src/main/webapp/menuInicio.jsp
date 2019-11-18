<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Menu Inicio</title>
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

	<nav id="menu" class="navbar navbar-inverse">
    	<div class="container-fluid">
    		<div class="navbar-header">
     	 	<a class="navbar-brand" href="VetMed"></a>
    	</div>
   		 <ul class="nav navbar-nav">
      		<li class="active"><a href="home.jsp">Home</a></li>
      		<li><a href="consultarAgendamento.jsp">Agendamento</a></li>
      		<li><a href="consultarPaciente.jsp">Paciente</a></li>
      		<li><a href="consultarSala.jsp">Sala</a></li>
      		<li><a href="consultarFuncionario.jsp">Funcionario</a></li>
      		<li><a href="consultarSetor.jsp">Setor</a></li>
      		<li><a href="consultarEquipe.jsp">Equipe</a></li>
      		<li><a href="consultarConvenio.jsp">Convenio</a></li>
      		<li><a href="consultarCliente.jsp">Cliente</a></li>
      		<li><a href="criarPrescricao.jsp">Prescricao</a></li>
      		<li><a href="consultarLaudo.jsp">Laudo</a></li>
      		<li><a href="consultarProntuario.jsp">Prontuário</a></li>
      		<li><a href="registrarPagamento.jsp">Pagamento</a></li>
      		<li><a href="alterarSenha.jsp">Senha</a></li>
      		<li><a href="index.jsp">Sair</a></li>
    	</ul>
  		</div>
	</nav>

</body>
</html>