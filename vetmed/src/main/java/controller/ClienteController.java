package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/cadastrarCliente.jsp";
    private static final String EDIT = "/atualizarCliente.jsp";
    private static final String LIST = "/consultarCliente.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private ClienteDao dao;

    public ClienteController() {
        super();
        dao = new ClienteDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
		List<Cliente> clientes = new ArrayList<Cliente>();

		Cliente cliente = new Cliente();
		
		try {			
			if (action.equalsIgnoreCase("insert")) {
				cliente.setNomeCliente(request.getParameter("nomeCliente"));
				int cpfCliente = Integer.parseInt(request.getParameter("cpfCliente"));
				cliente.setCpfCliente(cpfCliente);
				int rgCliente = Integer.parseInt(request.getParameter("rgCliente"));
				cliente.setRgCliente(rgCliente);
				cliente.setEndereco(request.getParameter("endereco"));
				int cep = Integer.parseInt(request.getParameter("cep"));
				cliente.setCep(cep);
				cliente.setEstado(request.getParameter("estado"));
				int telefone = Integer.parseInt(request.getParameter("telefone"));
				cliente.setTelefone(telefone);
				
				if (!dao.existe(cliente)) {
					dao.addCliente(cliente);
					String mensagem = "Cadastro realizado com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(INSERT);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);
				} else {
					String mensagem = "Este registro já existe";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(INSERT);
					request.setAttribute("msgerro", mensagem);
					rd.forward(request, response);
				}
					
			}
			
			else if (action.equalsIgnoreCase("atualiza")) {
					int cpfCliente = Integer.parseInt(request.getParameter("cpfCliente"));
					cliente = dao.getClienteByCpf(cpfCliente);
					request.setAttribute("cliente", cliente);
					request.getRequestDispatcher(EDIT).forward(request, response);	
			}
			
			else if (action.equalsIgnoreCase("edit")) {
				  cliente.setNomeCliente(request.getParameter("nomeCliente"));
				  int cpfCliente = Integer.parseInt(request.getParameter("cpfCliente"));
				  cliente.setCpfCliente(cpfCliente);
				  int rgCliente = Integer.parseInt(request.getParameter("rgCliente"));
				  cliente.setRgCliente(rgCliente);
				  cliente.setEndereco(request.getParameter("endereco"));
				  int cep = Integer.parseInt(request.getParameter("cep"));
				  cliente.setCep(cep);
				  cliente.setEstado(request.getParameter("estado"));
				  int telefone = Integer.parseInt(request.getParameter("telefone"));
					cliente.setTelefone(telefone);
				  
					dao.updateCliente(cliente, cpfCliente);
					String mensagem = "Alteração realizada com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);	
			}
			else if (action.equalsIgnoreCase("delete")) {
					int cpfCliente = Integer.parseInt(request.getParameter("cpfCliente"));
					dao.deleteCliente(cpfCliente);
					String mensagem = "Registro removido com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);
			}
			else if (action.equalsIgnoreCase("list")) {
					clientes = dao.getAllClientes();			
					request.setAttribute("clientes", clientes);	
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					rd.forward(request, response);
			}
			
		}  catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher(ERRO);
			request.setAttribute("msg", MSG);
			rd.forward(request, response);
		}		
   }
}