package model;

public class Laudo {

	private int idLaudo;
    private String nomePaciente;
	private String diagnostico;
    private String conduta;
    private String repouso;
    private String dataExame;
   
	public int getIdLaudo() {
		return idLaudo;
	}
	public void setIdLaudo(int idLaudo) {
		this.idLaudo = idLaudo;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}

	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getConduta() {
		return conduta;
	}
	public void setConduta(String conduta) {
		this.conduta = conduta;
	}
	public String getRepouso() {
		return repouso;
	}
	public void setRepouso(String repouso) {
		this.repouso = repouso;
	}
	public String getDataExame() {
		return dataExame;
	}
	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}
}

