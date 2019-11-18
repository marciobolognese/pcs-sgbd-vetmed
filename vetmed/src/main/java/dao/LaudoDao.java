package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Laudo;
import util.DbUtil;


public class LaudoDao {

	private Connection connection;

	public LaudoDao() {
	        connection = DbUtil.getConnection();   
	}
	
	public void addLaudo(Laudo laudo) {
		try {
			PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into laudo(idLaudo,nomepaciente,diagnostico,conduta,repouso,dataexame)"
                    		+ " values (?, ?, ?, ?, ?, ?)");
            // Parameters start with 1
			preparedStatement.setInt(1, laudo.getIdLaudo());
			preparedStatement.setString(2, laudo.getNomePaciente());
            preparedStatement.setString(3, laudo.getDiagnostico());
            preparedStatement.setString(4, laudo.getConduta());
            preparedStatement.setString(5, laudo.getRepouso());
            preparedStatement.setString(6, laudo.getDataExame());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }      

    public List<Laudo> getAllLaudos() {
        List<Laudo> laudos = new ArrayList<Laudo>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from laudo order by idlaudo");
            while (rs.next()) {
                Laudo laudo = new Laudo();
                laudo.setIdLaudo(rs.getInt("idLaudo"));
                laudo.setNomePaciente(rs.getString("nomePaciente"));
                laudo.setDiagnostico(rs.getString("diagnostico"));
                laudo.setConduta(rs.getString("conduta"));
                laudo.setRepouso(rs.getString("repouso"));
                laudo.setDataExame(rs.getString("dataExame"));
                laudos.add(laudo);  
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return laudos;
    }

    public Laudo getLaudoById(int idLaudo) {
        Laudo laudo = new Laudo();
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from laudo where idlaudo=?");
            preparedStatement.setInt(1, idLaudo);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
            	 laudo.setIdLaudo(rs.getInt("idLaudo"));
                 laudo.setNomePaciente(rs.getString("nomePaciente"));
                 laudo.setDiagnostico(rs.getString("diagnostico"));
                 laudo.setConduta(rs.getString("conduta"));
                 laudo.setRepouso(rs.getString("repouso"));
                 laudo.setDataExame(rs.getString("dataExame"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return laudo;
    }
    
    public boolean existe(Laudo laudo) {
		boolean existe = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from laudo where idlaudo=?");
			preparedStatement.setInt(1, laudo.getIdLaudo());
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

