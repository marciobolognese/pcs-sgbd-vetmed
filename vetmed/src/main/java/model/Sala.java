package model;

public class Sala {

	private int codSala;
	private String sala;
	private String data;
    private String horario;
    private String alocada;
    private String setor;
    
	
    public Sala() {
		super();
	}

	public Sala(int codSala) {
		super();
		this.codSala = codSala;
	}

	public int getCodSala() {
		return codSala;
	}

	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getAlocada() {
		return alocada;
	}

	public void setAlocada(String alocada) {
		this.alocada = alocada;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
