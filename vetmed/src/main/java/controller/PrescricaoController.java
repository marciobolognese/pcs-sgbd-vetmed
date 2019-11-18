package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrescricaoDao;
import model.Prescricao;

@WebServlet("/PrescricaoController")
public class PrescricaoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/criarPrescricao.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private PrescricaoDao dao;

    public PrescricaoController() {
        super();
        dao = new PrescricaoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
		
    	Prescricao prescricao = new Prescricao();
		try {
			if (action.equalsIgnoreCase("insert")) {
				int idPrescricao = Integer.parseInt(request.getParameter("idPrescricao"));
				prescricao.setIdPrescricao(idPrescricao);
				prescricao.setMedico(request.getParameter("medico"));
	            prescricao.setPaciente(request.getParameter("paciente"));
	            prescricao.setReceita(request.getParameter("receita"));
	            prescricao.setData(request.getParameter("data"));
	            prescricao.setLocal(request.getParameter("local"));
	            
				if (!dao.existe(prescricao)) {
					dao.addPrescricao(prescricao);		
					String mensagem = "Registro criado com sucesso";
					request.getServletContext().getRequestDispatcher(INSERT);
					request.setAttribute("msg", mensagem);
					response.sendRedirect(INSERT);
	
				} else {
					String mensagem = "Este registro já existe";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(INSERT);
					request.setAttribute("msgerro", mensagem);
					rd.forward(request, response);
				}
			}
			
		}  catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher(ERRO);
			request.setAttribute("msg", MSG);
			rd.forward(request, response);
		}
	
   }
}