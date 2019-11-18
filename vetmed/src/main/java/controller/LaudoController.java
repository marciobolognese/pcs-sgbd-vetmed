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

import dao.LaudoDao;
import model.Laudo;

@WebServlet("/LaudoController")
public class LaudoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/cadastrarLaudo.jsp";
    private static final String LIST = "/consultarLaudo.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private LaudoDao dao;

    public LaudoController() {
        super();
        dao = new LaudoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
    	
		List<Laudo> laudos = new ArrayList<Laudo>();

		Laudo laudo = new Laudo();
		try { 
			if (action.equalsIgnoreCase("insert")) {
				int idLaudo = Integer.parseInt(request.getParameter("idLaudo"));
				laudo.setIdLaudo(idLaudo);
				laudo.setNomePaciente(request.getParameter("nomePaciente"));
				laudo.setDiagnostico(request.getParameter("diagnostico"));
				laudo.setConduta(request.getParameter("conduta"));
				laudo.setRepouso(request.getParameter("repouso"));
				laudo.setDataExame(request.getParameter("dataExame")); 
	            
				if (!dao.existe(laudo)) {
					dao.addLaudo(laudo);
					String mensagem = "Laudo cadastrado com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(INSERT);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);	
				} else {
					String mensagem = "Este laudo já existe";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(INSERT);
					request.setAttribute("msgerro", mensagem);
					rd.forward(request, response);
				}
							
			}
			
			else if (action.equalsIgnoreCase("list")) {
					laudos = dao.getAllLaudos();			
					request.setAttribute("laudos", laudos);	
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
