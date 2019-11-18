package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import util.DbUtil;

public class LoginDao {

		private Connection connection;

		public LoginDao() {
		        connection = DbUtil.getConnection();   
		}	

	    public void updateLogin(String senha, String usuario) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("update login set senha=? where usuario=?");
	            // Parameters start with 1 
	            preparedStatement.setString(1, senha);
	            preparedStatement.setString(2, usuario);
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	    }

	    public Login getLoginById(int usuario) {
	        Login login = new Login();
	    	try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from login where usuario=?");
	            preparedStatement.setInt(1, usuario);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	            	login.setUsuario(rs.getString("usuario"));
	                login.setSenha(rs.getString("senha"));
	                login.setTipo(rs.getInt("tipo"));
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return login;
	    }
	    
	    public boolean existe(Login login) {
	    	boolean existe = false;
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from login where usuario=? and senha=?");
				preparedStatement.setString(1, login.getUsuario());
				preparedStatement.setString(2, login.getSenha());
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