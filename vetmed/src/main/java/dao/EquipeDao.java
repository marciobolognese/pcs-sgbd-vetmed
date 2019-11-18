package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Equipe;
import util.DbUtil;

public class EquipeDao {

	private Connection connection;

	public EquipeDao() {
	        connection = DbUtil.getConnection();   
	}
	
	public void addEquipe(Equipe equipe) {
		try {
			PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into equipe(idequipe,responsavel,especialidade,participante1,participante2,participante3,"
                    		+ "participante4) values (?, ?, ?, ?, ?, ?, ?)");
            // Parameters start with 1
			preparedStatement.setInt(1, equipe.getIdEquipe());
            preparedStatement.setInt(2, equipe.getResponsavel());
            preparedStatement.setString(3, equipe.getEspecialidade());
            preparedStatement.setInt(4, equipe.getParticipante1());
            preparedStatement.setInt(5, equipe.getParticipante2());
            preparedStatement.setInt(6, equipe.getParticipante3());
            preparedStatement.setInt(7, equipe.getParticipante4());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEquipe(int idEquipe) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from equipe where idequipe=?");
            // Parameters start with 1
            preparedStatement.setInt(1,idEquipe);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEquipe(Equipe equipe, int idEquipe) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update equipe set idequipe=?,responsavel=?,especialidade=?,participante1=?,participante2=?,"
                    		+ "participante3=?,participante4=? where idequipe="+idEquipe);
            // Parameters start with 1
            preparedStatement.setInt(1, equipe.getIdEquipe());
            preparedStatement.setInt(2, equipe.getResponsavel());
            preparedStatement.setString(3, equipe.getEspecialidade());
            preparedStatement.setInt(4, equipe.getParticipante1());
            preparedStatement.setInt(5, equipe.getParticipante2());
            preparedStatement.setInt(6, equipe.getParticipante3());
            preparedStatement.setInt(7, equipe.getParticipante4());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
        

    public List<Equipe> getAllEquipes() {
        List<Equipe> equipes = new ArrayList<Equipe>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from equipe");
            while (rs.next()) {
            	Equipe equipe = new Equipe();
                equipe.setIdEquipe(rs.getInt("idEquipe"));
            	equipe.setResponsavel(rs.getInt("responsavel"));
            	equipe.setEspecialidade(rs.getString("especialidade"));
            	equipe.setParticipante1(rs.getInt("participante1"));
            	equipe.setParticipante2(rs.getInt("participante2"));
            	equipe.setParticipante3(rs.getInt("participante3"));
            	equipe.setParticipante4(rs.getInt("participante4"));
                equipes.add(equipe);  
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipes;
    }

    public Equipe getEquipeById(int idEquipe) {
    	Equipe equipe = new Equipe();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from equipe where idequipe=?");
            preparedStatement.setInt(1, idEquipe);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
            	equipe.setIdEquipe(rs.getInt("idEquipe"));
            	equipe.setResponsavel(rs.getInt("responsavel"));
            	equipe.setEspecialidade(rs.getString("especialidade"));
            	equipe.setParticipante1(rs.getInt("participante1"));
            	equipe.setParticipante2(rs.getInt("participante2"));
            	equipe.setParticipante3(rs.getInt("participante3"));
            	equipe.setParticipante4(rs.getInt("participante4"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipe;
    }
    
    public boolean existe(Equipe equipe) {
		boolean existe = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from equipe where idequipe=?");
			preparedStatement.setInt(1, equipe.getIdEquipe());
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
