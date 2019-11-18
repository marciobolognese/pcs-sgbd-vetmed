package model;

public class Agendamento {

	private int codAgendamento;
	private int matriculaPaciente;
	private int codSala;
	private String procedimento;
  
    public Agendamento() {
  	}
    
    public Agendamento(int codAgendamento) {
		super();
		this.codAgendamento = codAgendamento;
	}
    
    public void setCodAgendamento(int codAgendamento) {
		this.codAgendamento = codAgendamento;
	}
	public int getCodAgendamento() {
		return codAgendamento;
	}
	public int getMatriculaPaciente() {
		return matriculaPaciente;
	}
	public void setMatriculaPaciente(int matriculaPaciente) {
		this.matriculaPaciente = matriculaPaciente;
	}
	public int getCodSala() {
		return codSala;
	}
	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}

	public String getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}
	
}
