package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Setor;
import util.DbUtil;

public class SetorDao {

	private Connection connection;

	public SetorDao() {
	        connection = DbUtil.getConnection();   
	}
	
	public void addSetor(Setor setor) {
		try {
			PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into setor(idsetor,nomesetor)"
                    		+ " values (?, ?)");
            // Parameters start with 1
			preparedStatement.setInt(1, setor.getIdSetor());
            preparedStatement.setString(2, setor.getNomeSetor());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSetor(int idSetor) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from setor where idsetor=?");
            // Parameters start with 1
            preparedStatement.setInt(1,idSetor);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSetor(Setor setor, int idSetor) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update setor set nomesetor=?"
                    		+ " where idsetor="+idSetor);
            // Parameters start with 1
            preparedStatement.setString(1, setor.getNomeSetor());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
        

    public List<Setor> getAllSetors() {
        List<Setor> setors = new ArrayList<Setor>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from setor order by idsetor");
            while (rs.next()) {
            	Setor setor = new Setor();
                setor.setIdSetor(rs.getInt("idSetor"));
            	setor.setNomeSetor(rs.getString("nomeSetor"));
            	
                setors.add(setor);  
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return setors;
    }

    public Setor getSetorById(int idSetor) {
    	Setor setor = new Setor();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from setor where idsetor=?");
            preparedStatement.setInt(1, idSetor);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	setor.setIdSetor(rs.getInt("idSetor"));
            	setor.setNomeSetor(rs.getString("nomeSetor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return setor;
    }
    
    public boolean existe(Setor setor) {
		boolean existe = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from setor where idsetor=?");
			preparedStatement.setInt(1, setor.getIdSetor());
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
