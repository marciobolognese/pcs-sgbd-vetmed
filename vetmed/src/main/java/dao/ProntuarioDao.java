package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Prontuario;
import util.DbUtil;


public class ProntuarioDao {

	private Connection connection;

	public ProntuarioDao() {
	        connection = DbUtil.getConnection();   
	}
	
    public List<Prontuario> getAllProntuarios() {
        List<Prontuario> prontuarios = new ArrayList<Prontuario>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from prontuario order by matricula");
            while (rs.next()) {
                Prontuario prontuario = new Prontuario();
                prontuario.setMatricula(rs.getInt("matricula"));
                prontuario.setNomePaciente(rs.getString("nomePaciente"));
                prontuario.setLaudo(rs.getString("laudo"));
                prontuario.setProcedimento(rs.getString("procedimento"));
                prontuario.setExame(rs.getString("exame"));
                prontuario.setReceita(rs.getString("receita"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prontuarios;
    }
    
    public boolean existe(Prontuario prontuario) {
		boolean existe = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from prontuario where matricula=?");
			preparedStatement.setInt(1, prontuario.getMatricula());
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
