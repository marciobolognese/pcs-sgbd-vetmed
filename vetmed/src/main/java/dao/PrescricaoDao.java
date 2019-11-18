package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Prescricao;
import util.DbUtil;

public class PrescricaoDao {

		private Connection connection;

		public PrescricaoDao() {
		        connection = DbUtil.getConnection();   
		}	

	    public void addPrescricao(Prescricao prescricao) {
	    		try {
	    			PreparedStatement preparedStatement = connection
	                        .prepareStatement("insert into prescricao(idprescricao,medico,paciente,receita,data,local)"
	                        		+ " values (?, ?, ?, ?, ?, ?)");
	                // Parameters start with 1
	    			preparedStatement.setInt(1, prescricao.getIdPrescricao());
	                preparedStatement.setString(2, prescricao.getMedico());
	                preparedStatement.setString(3, prescricao.getPaciente());
	                preparedStatement.setString(4, prescricao.getReceita());
	                preparedStatement.setString(5, prescricao.getData());
	                preparedStatement.setString(6, prescricao.getLocal());
	                preparedStatement.executeUpdate();
	                
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	    }

	    public Prescricao getPrescricaoById(int idprescricao) {
	        Prescricao prescricao = new Prescricao();
	    	try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from prescricao where idprescricao=?");
	            preparedStatement.setInt(1, idprescricao);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	            	prescricao.setMedico(rs.getString("medico"));
	                prescricao.setPaciente(rs.getString("paciente"));
	                prescricao.setReceita(rs.getString("receita"));
	                prescricao.setData(rs.getString("data"));
	                prescricao.setLocal(rs.getString("local"));
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return prescricao;
	    }
	    
	    public boolean existe(Prescricao prescricao) {
	    	boolean existe = false;
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from prescricao where idprescricao=?");
				preparedStatement.setInt(1, prescricao.getIdPrescricao());
                preparedStatement.setString(2, prescricao.getMedico());
                preparedStatement.setString(3, prescricao.getPaciente());
                preparedStatement.setString(4, prescricao.getReceita());
                preparedStatement.setString(5, prescricao.getData());
                preparedStatement.setString(6, prescricao.getLocal());
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