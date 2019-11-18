package model;

public class Cliente {
	
	private String nomeCliente;
	private int cpfCliente;
	private int rgCliente;
	private String endereco;
	private int cep;
	private String estado;
	private int telefone;
	

	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public int getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(int cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public int getRgCliente() {
		return rgCliente;
	}
	public void setRgCliente(int rgCliente) {
		this.rgCliente = rgCliente;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estadoCliente) {
		this.estado = estadoCliente;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
}
