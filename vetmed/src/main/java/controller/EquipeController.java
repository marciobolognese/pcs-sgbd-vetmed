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

import dao.EquipeDao;
import model.Equipe;

@WebServlet("/EquipeController")
public class EquipeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/cadastrarEquipe.jsp";
    private static final String EDIT = "/atualizarEquipe.jsp";
    private static final String LIST = "/consultarEquipe.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private EquipeDao dao;

    public EquipeController() {
        super();
        dao = new EquipeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
		List<Equipe> equipes = new ArrayList<Equipe>();

		Equipe equipe = new Equipe();
		
		try {
			if (action.equalsIgnoreCase("insert")) {
				int idEquipe = Integer.parseInt(request.getParameter("idEquipe"));
				equipe.setIdEquipe(idEquipe);
				int responsavel = Integer.parseInt(request.getParameter("responsavel"));
				equipe.setResponsavel(responsavel);
				equipe.setEspecialidade(request.getParameter("especialidade"));
				int participante1 = Integer.parseInt(request.getParameter("participante1"));
				equipe.setParticipante1(participante1);
				int participante2 = Integer.parseInt(request.getParameter("participante2"));
				equipe.setParticipante2(participante2);
				int participante3 = Integer.parseInt(request.getParameter("participante3"));
				equipe.setParticipante3(participante3);
				int participante4 = Integer.parseInt(request.getParameter("participante4"));
				equipe.setParticipante4(participante4);
				
				if (!dao.existe(equipe)) {
					dao.addEquipe(equipe);
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
					int idEquipe = Integer.parseInt(request.getParameter("idEquipe"));
					equipe = dao.getEquipeById(idEquipe);
					request.setAttribute("equipe", equipe);
					request.getRequestDispatcher(EDIT).forward(request, response);	
			}
			
			else if (action.equalsIgnoreCase("edit")) {
					int idEquipe = Integer.parseInt(request.getParameter("idEquipe"));
					equipe.setIdEquipe(idEquipe);
					int responsavel = Integer.parseInt(request.getParameter("responsavel"));
					equipe.setResponsavel(responsavel);
					equipe.setEspecialidade(request.getParameter("especialidade"));
					int participante1 = Integer.parseInt(request.getParameter("participante1"));
					equipe.setParticipante1(participante1);
					int participante2 = Integer.parseInt(request.getParameter("participante2"));
					equipe.setParticipante2(participante2);
					int participante3 = Integer.parseInt(request.getParameter("participante3"));
					equipe.setParticipante3(participante3);
					int participante4 = Integer.parseInt(request.getParameter("participante4"));
					equipe.setParticipante4(participante4);
					
					dao.updateEquipe(equipe, idEquipe);
					String mensagem = "Alteração realizada com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);	
			}
			else if (action.equalsIgnoreCase("delete")) {
					int idEquipe = Integer.parseInt(request.getParameter("idEquipe"));
					dao.deleteEquipe(idEquipe);
					String mensagem = "Registro removido com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);
			}
			
			else if (action.equalsIgnoreCase("list")) {
					equipes = dao.getAllEquipes();			
					request.setAttribute("equipes", equipes);	
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