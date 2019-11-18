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

import dao.FuncionarioDao;
import model.Funcionario;

@WebServlet("/FuncionarioController")
public class FuncionarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/cadastrarFuncionario.jsp";
    private static final String EDIT = "/atualizarFuncionario.jsp";
    private static final String LIST = "/consultarFuncionario.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private FuncionarioDao dao;

    public FuncionarioController() {
        super();
        dao = new FuncionarioDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		Funcionario funcionario = new Funcionario();
		
		try {			
			if (action.equalsIgnoreCase("insert")) {
				int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
				funcionario.setIdFuncionario(idFuncionario);
				funcionario.setNomeFuncionario(request.getParameter("nomeFuncionario"));
				int cpfFuncionario = Integer.parseInt(request.getParameter("cpfFuncionario"));
				funcionario.setCpfFuncionario(cpfFuncionario);
				funcionario.setDataNascFuncionario(request.getParameter("dataNascFuncionario"));
				float salario = Float.parseFloat(request.getParameter("salario"));
				funcionario.setSalario(salario);
				funcionario.setTipo(request.getParameter("tipo"));
				funcionario.setCargo(request.getParameter("cargo"));
				funcionario.setCrm(request.getParameter("crm"));
				
				if (!dao.existe(funcionario)) {
					dao.addFuncionario(funcionario);
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
					int idFuncionario1 = Integer.parseInt(request.getParameter("idFuncionario"));
					funcionario = dao.getFuncionarioById(idFuncionario1);
					request.setAttribute("funcionario", funcionario);
					request.getRequestDispatcher(EDIT).forward(request, response);	
			}
			
			else if (action.equalsIgnoreCase("edit")) {
					int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
					funcionario.setIdFuncionario(idFuncionario);
					funcionario.setNomeFuncionario(request.getParameter("nomeFuncionario"));
					int cpfFuncionario = Integer.parseInt(request.getParameter("cpfFuncionario"));
					funcionario.setCpfFuncionario(cpfFuncionario);
					funcionario.setDataNascFuncionario(request.getParameter("dataNascFuncionario"));
					float salario = Float.parseFloat(request.getParameter("salario"));
					funcionario.setSalario(salario);
					funcionario.setTipo(request.getParameter("tipo"));
					funcionario.setCargo(request.getParameter("cargo"));
					funcionario.setCrm(request.getParameter("crm"));
				
					dao.updateFuncionario(funcionario, idFuncionario);
					String mensagem = "Alteração realizada com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);	
			}
			else if (action.equalsIgnoreCase("delete")) {
					int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
					dao.deleteFuncionario(idFuncionario);
					String mensagem = "Registro removido com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);
			}
			else if (action.equalsIgnoreCase("list")) {
					funcionarios = dao.getAllFuncionarios();			
					request.setAttribute("funcionarios", funcionarios);	
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