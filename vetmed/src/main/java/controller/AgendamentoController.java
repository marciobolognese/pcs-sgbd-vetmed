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

import dao.AgendamentoDao;
import model.Agendamento;

@WebServlet("/AgendamentoController")
public class AgendamentoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/cadastrarAgendamento.jsp";
    private static final String EDIT = "/atualizarAgendamento.jsp";
    private static final String LIST = "/consultarAgendamento.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private AgendamentoDao dao;

    public AgendamentoController() {
        super();
        dao = new AgendamentoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
		List<Agendamento> agendamentos = new ArrayList<Agendamento>();

		Agendamento agendamento = new Agendamento();
		
		try {			
			if (action.equalsIgnoreCase("insert")) {
				int codAgendamento = Integer.parseInt(request.getParameter("codAgendamento"));
				agendamento.setCodAgendamento(codAgendamento);
				int matriculaPaciente = Integer.parseInt(request.getParameter("matriculaPaciente"));
				agendamento.setMatriculaPaciente(matriculaPaciente);
				int codSala = Integer.parseInt(request.getParameter("codSala"));
				agendamento.setCodSala(codSala);
				agendamento.setProcedimento(request.getParameter("procedimento"));
				
				if(!dao.existe(agendamento)) {
					dao.addAgendamento(agendamento);
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
					int codAgendamento = Integer.parseInt(request.getParameter("codAgendamento"));
					agendamento = dao.getAgendamentoById(codAgendamento);
					request.setAttribute("agendamento", agendamento);
					request.getRequestDispatcher(EDIT).forward(request, response);
						
			}
			
			else if (action.equalsIgnoreCase("edit")) {
					int codAgendamento = Integer.parseInt(request.getParameter("codAgendamento"));
					agendamento.setCodAgendamento(codAgendamento);
					int matriculaPaciente = Integer.parseInt(request.getParameter("matriculaPaciente"));
					agendamento.setMatriculaPaciente(matriculaPaciente);
					int codSala = Integer.parseInt(request.getParameter("codSala"));
					agendamento.setCodSala(codSala);
					agendamento.setProcedimento(request.getParameter("procedimento"));
	
					dao.updateAgendamento(agendamento, codAgendamento);
					String mensagem = "Alteração realizada com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);	
			}
			else if (action.equalsIgnoreCase("delete")) {
					int codAgendamento = Integer.parseInt(request.getParameter("codAgendamento"));
					dao.deleteAgendamento(codAgendamento);
					String mensagem = "Registro removido com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);
			}
			else if (action.equalsIgnoreCase("list")) {
					agendamentos = dao.getAllAgendamentos();
					request.setAttribute("agendamentos", agendamentos);	
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