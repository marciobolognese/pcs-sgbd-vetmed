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

import dao.PacienteDao;
import model.Paciente;

@WebServlet("/PacienteController")
public class PacienteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/cadastrarPaciente.jsp";
    private static final String EDIT = "/atualizarPaciente.jsp";
    private static final String LIST = "/consultarPaciente.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private PacienteDao dao;

    public PacienteController() {
        super();
        dao = new PacienteDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
		List<Paciente> pacientes = new ArrayList<Paciente>();

		Paciente paciente = new Paciente();
		try { 
			if (action.equalsIgnoreCase("insert")) {
				int matricula = Integer.parseInt(request.getParameter("matricula"));
				paciente.setMatricula(matricula);
				paciente.setNomePaciente(request.getParameter("nomePaciente"));
	            int cpfresponsavel = Integer.parseInt(request.getParameter("cpfResponsavel"));
	            paciente.setCpfResponsavel(cpfresponsavel);
	            paciente.setDataNascPaciente(request.getParameter("dataNascPaciente")); 
	            
				if (!dao.existe(paciente)) {
					dao.addPaciente(paciente);
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
					int matricula = Integer.parseInt(request.getParameter("matricula"));
					paciente = dao.getPacienteById(matricula);
					request.setAttribute("paciente", paciente);
					request.getRequestDispatcher(EDIT).forward(request, response);			
			}
			
			else if (action.equalsIgnoreCase("edit")) {
					int matricula = Integer.parseInt(request.getParameter("matricula"));
					paciente.setMatricula(matricula);
					paciente.setNomePaciente(request.getParameter("nomePaciente"));
		            int cpfresponsavel = Integer.parseInt(request.getParameter("cpfResponsavel"));
		            paciente.setCpfResponsavel(cpfresponsavel);
		            paciente.setDataNascPaciente(request.getParameter("dataNascPaciente")); 

					dao.updatePaciente(paciente, matricula);
					String mensagem = "Alteração realizada com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);			
			}
			
			else if (action.equalsIgnoreCase("delete")) {
					int matricula = Integer.parseInt(request.getParameter("matricula"));
					dao.deletePaciente(matricula);
					String mensagem = "Registro removido com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);						
			}
			else if (action.equalsIgnoreCase("list")) {
					pacientes = dao.getAllPacientes();			
					request.setAttribute("pacientes", pacientes);	
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


