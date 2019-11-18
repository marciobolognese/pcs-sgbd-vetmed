package model;

public class Prescricao {
	
	private int idPrescricao;
	private String medico;
	private String paciente;
	private String receita;
	private String data;
	private String local;
	
	public int getIdPrescricao() {
		return idPrescricao;
	}
	public void setIdPrescricao(int idPrescricao) {
		this.idPrescricao = idPrescricao;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getReceita() {
		return receita;
	}
	public void setReceita(String receita) {
		this.receita = receita;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	
}
