package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Sala;
import util.DbUtil;

public class SalaDao {

		private Connection connection;

		public SalaDao() {
		        connection = DbUtil.getConnection();   
		}
		
		public void addSala(Sala sala) {
			try {
				PreparedStatement preparedStatement = connection
	                    .prepareStatement("insert into sala(codsala,sala,data,horario,alocada,setor)"
	                    		+ "values (?, ?, ?, ?, ?, ?)");
	            // Parameters start with 1
				preparedStatement.setInt(1, sala.getCodSala());
	            preparedStatement.setString(2, sala.getSala());
	            preparedStatement.setString(3, sala.getData());
	            preparedStatement.setString(4, sala.getHorario());
	            preparedStatement.setString(5, sala.getAlocada());
	            preparedStatement.setString(6, sala.getSetor());
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteSala(int codSala) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("delete from sala where codsala=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1,codSala);
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void updateSala(Sala sala, int codSala) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("update sala set codsala=?,sala=?,data=?,horario=?,alocada=?,setor=? where codsala="+codSala);
	            // Parameters start with 1
				preparedStatement.setInt(1, sala.getCodSala());
	            preparedStatement.setString(2, sala.getSala());
	            preparedStatement.setString(3, sala.getData());
	            preparedStatement.setString(4, sala.getHorario());
	            preparedStatement.setString(5, sala.getAlocada());
	            preparedStatement.setString(6, sala.getSetor());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	    }
	        

	    public List<Sala> getAllSalas() {
	        List<Sala> salas = new ArrayList<Sala>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from sala order by codsala");
	            while (rs.next()) {
	            	Sala sala = new Sala();
	                sala.setCodSala(rs.getInt("codSala"));
	                sala.setSala(rs.getString("sala"));
	                sala.setData(rs.getString("data"));
	                sala.setHorario(rs.getString("horario"));
	                sala.setAlocada(rs.getString("alocada"));
	                sala.setSetor(rs.getString("setor"));	                
	                salas.add(sala);  
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return salas;
	    }

	    public Sala getSalaById(int codSala) {
	        Sala sala = new Sala();
	    	try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from sala where codsala=?");
	            preparedStatement.setInt(1, codSala);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	            	sala.setCodSala(rs.getInt("codSala"));
	                sala.setSala(rs.getString("sala"));
	                sala.setData(rs.getString("data"));
	                sala.setHorario(rs.getString("horario"));
	                sala.setAlocada(rs.getString("alocada"));
	                sala.setSetor(rs.getString("setor"));
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return sala;
	    }
	    
	    public boolean existe(Sala sala) {
			boolean existe = false;
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("Select * from sala where codsala=?");
				preparedStatement.setInt(1, sala.getCodSala());
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