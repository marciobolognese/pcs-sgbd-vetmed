<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<title>Atualizar Equipe</title>
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
	 
	<div id="containerequipeform" class=container-fluid>		
			<div class="col-sm-1"></div>
			<div class="col-sm-8">
      			<h2>Atualizar Equipe</h2>
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

					  <form action="${pageContext.request.contextPath}/EquipeController?action=edit"  class="form-horizontal" method="POST">
					    <div class="form-group">
					      <label for="idEquipe" class="control-label col-sm-2">Id Equipe:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="idEquipe" name="idEquipe" placeholder="Ex.: 999" readonly="true"
					        		value="<c:out value="${equipe.idEquipe}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="responsavel" class="control-label col-sm-2">Responsavel:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="responsavel" name="responsavel" placeholder="Ex.: 999"
					        		value="<c:out value="${equipe.responsavel}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="especialidade" class="control-label col-sm-2">Especialidade:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="especialidade" name="especialidade" placeholder="Ex.: aaa"
					        		value="<c:out value="${equipe.especialidade}" />"/>
					      </div>
					    </div>
					    
					     <div class="form-group">
					      <label for="participante1" class="control-label col-sm-2">Participante 1:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="participante1" name="participante1" placeholder="Ex.: 999"
					        		value="<c:out value="${equipe.participante1}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="participante2" class="control-label col-sm-2">Participante 2:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="participante2" name="participante2" placeholder="Ex.: 999"
					        		value="<c:out value="${equipe.participante2}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="participante3" class="control-label col-sm-2">Participante 3:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="participante3" name="participante3" placeholder="Ex.: 999"
					        		value="<c:out value="${equipe.participante3}" />"/>
					      </div>
					    </div>
					    
					    <div class="form-group">
					      <label for="participante4" class="control-label col-sm-2">Participante 4:</label>
					      <div class="col-sm-8">          
					        	<input type="text" class="form-control" id="participante4" name="participante4" placeholder="Ex.: 999"
					        		value="<c:out value="${equipe.participante4}" />"/>
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