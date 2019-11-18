function redirectcadastraagendamento() {
	window.location.href = "/vetmed/cadastrarAgendamento.jsp";
}

function redirectcadastrarcliente() {
	window.location.href = "/vetmed/cadastrarCliente.jsp";
}

function redirectcadastrarcliente() {
	window.location.href = "/vetmed/cadastrarConvenio.jsp";
}

function redirectcadastraequipe() {
	window.location.href = "/vetmed/cadastrarEquipe.jsp";
}

function redirectcadastrafuncionario() {
	window.location.href = "/vetmed/cadastrarFuncionario.jsp";
}

function redirectcadastrapaciente() {
	window.location.href = "/vetmed/cadastrarPaciente.jsp";
}

function redirectalocacaosala() {
	window.location.href = "/vetmed/alocarSala.jsp";
}

function redirectcadastrasetor() {
	window.location.href = "/vetmed/cadastrarSetor.jsp";
}

function redirectgerarlaudo() {
	window.location.href = "/vetmed/gerarLaudo.jsp";
}

function redirectconsultarprontuario() {
	window.location.href = "/vetmed/consultarProntuario2.jsp";
}

function mascaraData(campoData) {
	var data = campoData.value;
	if (data.length == 2) {
		data = data + '/';
		document.forms[0].data.value = data;
		return true;
	}
	if (data.length == 5) {
		data = data + '/';
		document.forms[0].data.value = data;
		return true;
	}
}
