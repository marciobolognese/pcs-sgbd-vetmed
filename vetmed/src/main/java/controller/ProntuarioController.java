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

import dao.ProntuarioDao;
import model.Prontuario;

@WebServlet("/ProntuarioController")
public class ProntuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String LIST = "/consultarProntuario2.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private ProntuarioDao dao;

    public ProntuarioController() {
        super();
        dao = new ProntuarioDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
		List<Prontuario> prontuarios = new ArrayList<Prontuario>();

		try { 

				if (action.equalsIgnoreCase("list")) {
					prontuarios = dao.getAllProntuarios();			
					request.setAttribute("prontuarios", prontuarios);	
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


