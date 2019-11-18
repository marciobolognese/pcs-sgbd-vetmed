package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pagamento;
import util.DbUtil;

public class PagamentoDao {

	private Connection connection;

	public PagamentoDao() {
	        connection = DbUtil.getConnection();   
	}
	
	public void addPagamento(Pagamento Pagamento) {
		try {
			PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into pagamento(idpagto,valor,paciente,pago,tipo,convenio,formapagto)"
                    		+ " values (?,?,?,?,?,?,?)");
            // Parameters start with 1
			preparedStatement.setInt(1, Pagamento.getIdPagto());
			preparedStatement.setString(2, Pagamento.getValor());
            preparedStatement.setString(3, Pagamento.getPaciente());
            preparedStatement.setString(4, Pagamento.isPago());
            preparedStatement.setString(5, Pagamento.getTipo());
            preparedStatement.setString(6, Pagamento.getConvenio());
            preparedStatement.setString(7, Pagamento.getFormaPagto());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    public Pagamento getPagamentoById(int idPagamento) {
    	Pagamento pagamento = new Pagamento();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from pagamento where idpagto=?");
            preparedStatement.setInt(1, idPagamento);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	pagamento.setIdPagto(rs.getInt("idPagto"));
            	pagamento.setValor(rs.getString("valor"));
            	pagamento.setPaciente(rs.getString("paciente"));
            	pagamento.setPago(rs.getString("pago"));
            	pagamento.setTipo(rs.getString("tipo"));
            	pagamento.setConvenio(rs.getString("convenio"));
            	pagamento.setFormaPagto(rs.getString("formaPagto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagamento;
    }
    
    
    public boolean existe(Pagamento Pagamento) {
		boolean existe = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from pagamento where idpagto=?");
			preparedStatement.setInt(1, Pagamento.getIdPagto());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				existe = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}
}
