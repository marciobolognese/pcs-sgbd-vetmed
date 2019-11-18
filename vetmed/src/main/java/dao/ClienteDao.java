package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import util.DbUtil;

public class ClienteDao {

	private Connection connection;

	public ClienteDao() {
	        connection = DbUtil.getConnection();   
	}
	
	public void addCliente(Cliente cliente) {
		try {
			PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into cliente(nomecliente,cpfcliente,rgcliente,endereco,cep,estado,telefone)" 
			+ "values (?, ?, ?, ?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, cliente.getNomeCliente());
            preparedStatement.setInt(2, cliente.getCpfCliente());
            preparedStatement.setInt(3, cliente.getRgCliente());
            preparedStatement.setString(4, cliente.getEndereco());
            preparedStatement.setInt(5, cliente.getCep());
            preparedStatement.setString(6, cliente.getEstado());
            preparedStatement.setInt(7, cliente.getTelefone());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCliente(int cpfCliente) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from cliente where cpfcliente=?");
            // Parameters start with 1
            preparedStatement.setInt(1,cpfCliente);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCliente(Cliente cliente, int cpfCliente) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update cliente set nomeCliente=?,cpfCliente=?,rgCliente=?,endereco=?,"
                    		+ "cep=?,estado=?,telefone=? where cpfcliente="+cpfCliente);
            // Parameters start with 1
            preparedStatement.setString(1, cliente.getNomeCliente());
            preparedStatement.setInt(2, cliente.getCpfCliente());
            preparedStatement.setInt(3, cliente.getRgCliente());
            preparedStatement.setString(4, cliente.getEndereco());
            preparedStatement.setInt(5, cliente.getCep());
            preparedStatement.setString(6, cliente.getEstado());
            preparedStatement.setInt(7, cliente.getTelefone());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
        

    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cliente order by cpfcliente");
            while (rs.next()) {
            	Cliente cliente = new Cliente();
                cliente.setNomeCliente(rs.getString("nomeCliente"));
            	cliente.setCpfCliente(rs.getInt("cpfCliente"));
            	cliente.setRgCliente(rs.getInt("rgCliente"));
            	cliente.setEndereco(rs.getString("endereco"));  
            	cliente.setCep(rs.getInt("cep"));
            	cliente.setEstado(rs.getString("estado"));
            	cliente.setTelefone(rs.getInt("telefone"));
                clientes.add(cliente);  
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public Cliente getClienteByCpf(int cpfCliente) {
    	Cliente cliente = new Cliente();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cliente where cpfcliente=?");
            preparedStatement.setInt(1, cpfCliente);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                cliente.setNomeCliente(rs.getString("nomeCliente"));
            	cliente.setCpfCliente(rs.getInt("cpfCliente"));
            	cliente.setRgCliente(rs.getInt("rgCliente"));
            	cliente.setEndereco(rs.getString("endereco"));  
            	cliente.setCep(rs.getInt("cep"));
            	cliente.setEstado(rs.getString("estado"));
            	cliente.setTelefone(rs.getInt("telefone"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
    
    public boolean existe(Cliente cliente) {
		boolean existe = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from cliente where cpfcliente=?");
			preparedStatement.setInt(1, cliente.getCpfCliente());
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
