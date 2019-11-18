package model;


/*
 * Os tipos devem ser configurados como: {1- Administrador, 2-Funcionario Administrativo, 3- Funcionario Tecnico, 4-Funcionario Medico
 * 5 - Nao Identificado  
 */
public class Login {
	private String usuario;
	private String senha;
	private int tipo;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
