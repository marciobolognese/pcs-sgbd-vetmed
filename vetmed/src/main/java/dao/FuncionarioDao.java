package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import util.DbUtil;

public class FuncionarioDao {

	private Connection connection;

	public FuncionarioDao() {
	        connection = DbUtil.getConnection();   
	}
	
	public void addFuncionario(Funcionario funcionario) {
		try {
			PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into funcionario(idfuncionario,nomefuncionario,cpffuncionario,datanascfuncionario,"
                    		+ "salario,tipo,cargo,crm) values (?, ?, ?, ?, ?, ?, ?, ?)");
            // Parameters start with 1
			preparedStatement.setInt(1, funcionario.getIdFuncionario());
            preparedStatement.setString(2, funcionario.getNomeFuncionario());
            preparedStatement.setInt(3, funcionario.getCpfFuncionario());
            preparedStatement.setString(4, funcionario.getDataNascFuncionario());
            preparedStatement.setFloat(5, funcionario.getSalario());
            preparedStatement.setString(6, funcionario.getTipo());
            preparedStatement.setString(7, funcionario.getCargo());
            preparedStatement.setString(8, funcionario.getCrm());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFuncionario(int idFuncionario) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from funcionario where idfuncionario=?");
            // Parameters start with 1
            preparedStatement.setInt(1,idFuncionario);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFuncionario(Funcionario funcionario, int idFuncionario) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update funcionario set idfuncionario=?,nomefuncionario=?,cpffuncionario=?,datanascfuncionario=?,"
                    		+ "salario=?,tipo=?,cargo=?,crm=? where idfuncionario="+idFuncionario);
            // Parameters start with 1
            preparedStatement.setInt(1, funcionario.getIdFuncionario());
            preparedStatement.setString(2, funcionario.getNomeFuncionario());
            preparedStatement.setInt(3, funcionario.getCpfFuncionario());
            preparedStatement.setString(4, funcionario.getDataNascFuncionario());
            preparedStatement.setFloat(5, funcionario.getSalario());
            preparedStatement.setString(6, funcionario.getTipo());
            preparedStatement.setString(7, funcionario.getCargo());
            preparedStatement.setString(8, funcionario.getCrm());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
        

    public List<Funcionario> getAllFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from funcionario order by idfuncionario");
            while (rs.next()) {
            	Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNomeFuncionario(rs.getString("nomeFuncionario"));
            	funcionario.setCpfFuncionario(rs.getInt("cpfFuncionario"));
            	funcionario.setDataNascFuncionario(rs.getString("dataNascFuncionario"));
            	funcionario.setSalario(rs.getFloat("salario"));  
            	funcionario.setTipo(rs.getString("tipo"));
            	funcionario.setCargo(rs.getString("cargo"));
            	funcionario.setCrm(rs.getString("crm"));
                funcionarios.add(funcionario);  
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    public Funcionario getFuncionarioById(int idFuncionario) {
    	Funcionario funcionario = new Funcionario();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from funcionario where idfuncionario=?");
            preparedStatement.setInt(1, idFuncionario);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
            	funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNomeFuncionario(rs.getString("nomeFuncionario"));
             	funcionario.setCpfFuncionario(rs.getInt("cpfFuncionario"));
             	funcionario.setDataNascFuncionario(rs.getString("dataNascFuncionario"));
             	funcionario.setSalario(rs.getFloat("salario"));
             	funcionario.setTipo(rs.getString("tipo"));
            	funcionario.setCargo(rs.getString("cargo"));
            	funcionario.setCrm(rs.getString("crm"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }
    
    public boolean existe(Funcionario funcionario) {
		boolean existe = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from funcionario where idfuncionario=?");
			preparedStatement.setInt(1, funcionario.getIdFuncionario());
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
