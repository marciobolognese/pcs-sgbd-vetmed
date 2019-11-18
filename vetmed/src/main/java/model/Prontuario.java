package model;

public class Prontuario {

    private int matricula;
	private String nomePaciente;
	private String laudo;
	private String procedimento;
	private String exame;
	private String receita;
    
    public Prontuario() {
  	}
    
    public Prontuario(int matricula) {
		super();
		this.matricula = matricula;
	}
    
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int getMatricula() {
		return matricula;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomepaciente) {
		this.nomePaciente = nomepaciente;
	}
	public String getLaudo() {
		return laudo;
	}
	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}
	public String getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}
	public String getExame() {
		return exame;
	}
	public void setExame(String exame) {
		this.exame = exame;
	}
	public String getReceita() {
		return receita;
	}
	public void setReceita(String receita) {
		this.receita = receita;
	}
}
