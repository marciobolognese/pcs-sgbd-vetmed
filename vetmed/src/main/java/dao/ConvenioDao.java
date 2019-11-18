package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Convenio;
import util.DbUtil;

public class ConvenioDao {

	private Connection connection;

	public ConvenioDao() {
	        connection = DbUtil.getConnection();   
	}
	
	public void addConvenio(Convenio convenio) {
		try {
			PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into convenio(cnpjconvenio,nomeconvenio)"
                    		+ " values (?, ?)");
            // Parameters start with 1
			preparedStatement.setInt(1, convenio.getCNPJConvenio());
            preparedStatement.setString(2, convenio.getNomeConvenio());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteConvenio(int CNPJConvenio) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from convenio where CNPJconvenio=?");
            // Parameters start with 1
            preparedStatement.setInt(1,CNPJConvenio);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateConvenio(Convenio convenio, int CPNJConvenio) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update convenio set nomeconvenio=?"
                    		+ " where CNPJconvenio=?");
            // Parameters start with 1
            preparedStatement.setString(1, convenio.getNomeConvenio());
            preparedStatement.setInt(2, convenio.getCNPJConvenio());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
        

    public List<Convenio> getAllConvenios() {
        List<Convenio> convenios = new ArrayList<Convenio>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from convenio order by CNPJconvenio");
            while (rs.next()) {
            	Convenio convenio = new Convenio();
                convenio.setCNPJConvenio(rs.getInt("CNPJConvenio"));
            	convenio.setNomeConvenio(rs.getString("nomeConvenio"));
            	
                convenios.add(convenio);  
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return convenios;
    }

    public Convenio getConvenioByCNPJ(int CNPJConvenio) {
    	Convenio convenio = new Convenio();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from convenio where cnpjconvenio=?");
            preparedStatement.setInt(1, CNPJConvenio);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	convenio.setCNPJConvenio(rs.getInt("CNPJConvenio"));
            	convenio.setNomeConvenio(rs.getString("nomeConvenio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return convenio;
    }
    
    public boolean existe(Convenio convenio) {
		boolean existe = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from convenio where cnpjconvenio=?");
			preparedStatement.setInt(1, convenio.getCNPJConvenio());
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
