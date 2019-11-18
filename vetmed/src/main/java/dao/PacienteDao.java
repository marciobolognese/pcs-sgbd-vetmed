package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Paciente;
import util.DbUtil;


public class PacienteDao {

	private Connection connection;

	public PacienteDao() {
	        connection = DbUtil.getConnection();   
	}
	
	public void addPaciente(Paciente paciente) {
		try {
			PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into paciente(matricula,nomepaciente,cpfresponsavel,datanascpaciente)"
                    		+ " values (?, ?, ?, ?)");
            // Parameters start with 1
			preparedStatement.setInt(1, paciente.getMatricula());
            preparedStatement.setString(2, paciente.getNomePaciente());
            preparedStatement.setInt(3, paciente.getCpfResponsavel());
            preparedStatement.setString(4, paciente.getDataNascPaciente());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePaciente(int matricula) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from paciente where matricula=?");
            // Parameters start with 1
            preparedStatement.setInt(1,matricula);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePaciente(Paciente paciente, int matricula) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update paciente set matricula=?,nomepaciente=?," + 
                    		"cpfresponsavel=?,datanascpaciente=? where matricula="+matricula);
            // Parameters start with 1
            preparedStatement.setInt(1, paciente.getMatricula());
            preparedStatement.setString(2, paciente.getNomePaciente());
            preparedStatement.setInt(3, paciente.getCpfResponsavel());
            preparedStatement.setString(4, paciente.getDataNascPaciente());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
        

    public List<Paciente> getAllPacientes() {
        List<Paciente> pacientes = new ArrayList<Paciente>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from paciente order by matricula");
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setMatricula(rs.getInt("matricula"));
                paciente.setNomePaciente(rs.getString("nomePaciente"));
                paciente.setCpfResponsavel(rs.getInt("cpfResponsavel"));
                paciente.setDataNascPaciente(rs.getString("dataNascPaciente"));
                pacientes.add(paciente);  
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pacientes;
    }

    public Paciente getPacienteById(int matricula) {
        Paciente paciente = new Paciente();
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from paciente where matricula=?");
            preparedStatement.setInt(1, matricula);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
            	 paciente.setMatricula(rs.getInt("matricula"));
                 paciente.setNomePaciente(rs.getString("nomePaciente"));
                 paciente.setCpfResponsavel(rs.getInt("cpfResponsavel"));
                 paciente.setDataNascPaciente(rs.getString("dataNascPaciente"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }
    
    public boolean existe(Paciente paciente) {
		boolean existe = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from paciente where matricula=?");
			preparedStatement.setInt(1, paciente.getMatricula());
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
