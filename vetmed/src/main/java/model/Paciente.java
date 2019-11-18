package model;

public class Paciente {

    private int matricula;
	private String nomePaciente;
    private int cpfResponsavel;
    private String dataNascPaciente;
    
    public Paciente() {
  	}
    
    public Paciente(int matricula) {
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
	public int getCpfResponsavel() {
		return cpfResponsavel;
	}
	public void setCpfResponsavel(int cpfresponsavel) {
		this.cpfResponsavel = cpfresponsavel;
	}
	public String getDataNascPaciente() {
		return dataNascPaciente;
	}
	public void setDataNascPaciente(String datanascpaciente) {
		this.dataNascPaciente = datanascpaciente;
	}
}
