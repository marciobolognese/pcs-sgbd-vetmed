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

import dao.SalaDao;
import model.Sala;

@WebServlet("/SalaController")
public class SalaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/alocarSala.jsp";
    private static final String LIST = "/consultarSala.jsp";
    private static final String EDIT = "/atualizarSala.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private SalaDao dao;

    public SalaController() {
        super();
        dao = new SalaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
		
    	List<Sala> salas = new ArrayList<Sala>();
		
    	Sala sala = new Sala();
		try {
			if (action.equalsIgnoreCase("insert")) {
				int codSala = Integer.parseInt(request.getParameter("codSala"));
				sala.setCodSala(codSala);
				sala.setSala(request.getParameter("sala"));
	            sala.setData(request.getParameter("data"));
	            sala.setHorario(request.getParameter("horario"));
	            sala.setAlocada(request.getParameter("alocada"));
	            sala.setSetor(request.getParameter("setor"));
	            
				if (!dao.existe(sala)) {
					dao.addSala(sala);
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
			
			else if(action.equalsIgnoreCase("atualiza")) {
				int codSala = Integer.parseInt(request.getParameter("codSala"));
				sala = dao.getSalaById(codSala);
				request.setAttribute("sala", sala);
				request.getRequestDispatcher(EDIT).forward(request, response);
			}
			
			else if (action.equalsIgnoreCase("edit")) {
				int codSala = Integer.parseInt(request.getParameter("codSala"));
				sala.setCodSala(codSala);
				sala.setSala(request.getParameter("sala"));
	            sala.setData(request.getParameter("data"));
	            sala.setHorario(request.getParameter("horario"));
	            sala.setAlocada(request.getParameter("alocada"));
	            sala.setSetor(request.getParameter("setor"));

				dao.updateSala(sala, codSala);
				String mensagem = "Alteração realizada com sucesso";
				RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
				request.setAttribute("msg", mensagem);
				rd.forward(request, response);	
			}
			
			else if (action.equalsIgnoreCase("delete")) {
				int codSala = Integer.parseInt(request.getParameter("codSala"));
				dao.deleteSala(codSala);
				String mensagem = "Registro removido com sucesso";
				RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
				request.setAttribute("msg", mensagem);
				rd.forward(request, response);
			}

			else if (action.equalsIgnoreCase("list")) {
				salas = dao.getAllSalas();			
				request.setAttribute("salas", salas);	
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