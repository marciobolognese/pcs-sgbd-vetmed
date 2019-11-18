package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Agendamento;
import model.Setor;
import util.DbUtil;

public class AgendamentoDao {

	private Connection connection;

	public AgendamentoDao() {
	        connection = DbUtil.getConnection();   
	}
	
	public void addAgendamento(Agendamento agendamento) {
		try {
			PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into agendamento(codagendamento,matriculapaciente,codsala,procedimento)"
                    		+ " values (?, ?, ?, ?)");
            // Parameters start with 1
			preparedStatement.setInt(1, agendamento.getCodAgendamento());
            preparedStatement.setInt(2, agendamento.getMatriculaPaciente());
            preparedStatement.setInt(3, agendamento.getCodSala());
            preparedStatement.setString(4, agendamento.getProcedimento());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAgendamento(int codAgendamento) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from agendamento where codagendamento=?");
            // Parameters start with 1
            preparedStatement.setInt(1,codAgendamento);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAgendamento(Agendamento agendamento, int codAgendamento) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update agendamento set codagendamento=?,matriculapaciente=?,codsala=?,"
                    		+ "procedimento=? where codagendamento="+codAgendamento);
            // Parameters start with 1
            preparedStatement.setInt(1, agendamento.getCodAgendamento());
            preparedStatement.setInt(2, agendamento.getMatriculaPaciente());
            preparedStatement.setInt(3, agendamento.getCodSala());
            preparedStatement.setString(4, agendamento.getProcedimento());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
        

    public List<Agendamento> getAllAgendamentos() {
        List<Agendamento> agendamentos = new ArrayList<Agendamento>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from agendamento order by codagendamento");
            while (rs.next()) {
            	Agendamento agendamento = new Agendamento();
                agendamento.setCodAgendamento(rs.getInt("codAgendamento"));
                agendamento.setMatriculaPaciente(rs.getInt("matriculaPaciente"));
            	agendamento.setCodSala(rs.getInt("codSala"));
            	agendamento.setProcedimento(rs.getString("procedimento"));
            	
                agendamentos.add(agendamento);  
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agendamentos;
    }

    public Agendamento getAgendamentoById(int codAgendamento) {
    	Agendamento agendamento = new Agendamento();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from agendamento where codagendamento=?");
            preparedStatement.setInt(1, codAgendamento);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	agendamento.setCodAgendamento(rs.getInt("codAgendamento"));
            	agendamento.setMatriculaPaciente(rs.getInt("matriculaPaciente"));
            	agendamento.setCodSala(rs.getInt("codSala"));
            	agendamento.setProcedimento(rs.getString("procedimento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agendamento;
    }
    
    public boolean existe(Agendamento agendamento) {
		boolean existe = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from agendamento where codagendamento=?");
			preparedStatement.setInt(1, agendamento.getCodAgendamento());
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
