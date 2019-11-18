package model;

public class Pagamento {

	private int idPagto;   
    private String valor;
    private String paciente;          
    private String pago;   
    private String tipo;
    private String convenio;
    private String formaPagto;
    
    
    public int getIdPagto() {
        return idPagto;
    }

    public void setIdPagto(int Id) {
        this.idPagto = Id;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
    
    public String isPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getFormaPagto() {
		return formaPagto;
	}

	public void setFormaPagto(String formaPagto) {
		this.formaPagto = formaPagto;
	}

	@Override
    public String toString() {
        return "Custo: R$" + getValor();
    }
}
