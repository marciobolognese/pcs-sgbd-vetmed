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

import dao.SetorDao;
import model.Setor;

@WebServlet("/SetorController")
public class SetorController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/cadastrarSetor.jsp";
    private static final String EDIT = "/atualizarSetor.jsp";
    private static final String LIST = "/consultarSetor.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private SetorDao dao;

    public SetorController() {
        super();
        dao = new SetorDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
		List<Setor> setores = new ArrayList<Setor>();

		Setor setor = new Setor();
		
		try {		
			if (action.equalsIgnoreCase("insert")) {			
					int idSetor = Integer.parseInt(request.getParameter("idSetor"));
					setor.setIdSetor(idSetor);
					setor.setNomeSetor(request.getParameter("nomeSetor"));
				
					if(!dao.existe(setor)) {
						dao.addSetor(setor);
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
					int idSetor = Integer.parseInt(request.getParameter("idSetor"));
					setor = dao.getSetorById(idSetor);
					request.setAttribute("setor", setor);
					request.getRequestDispatcher(EDIT).forward(request, response);				
			}
			
			else if (action.equalsIgnoreCase("edit")) {
					int idSetor = Integer.parseInt(request.getParameter("idSetor"));
					setor.setIdSetor(idSetor);
					setor.setNomeSetor(request.getParameter("nomeSetor"));
				
					dao.updateSetor(setor, idSetor);
					String mensagem = "Alteração realizada com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);	
			}
			else if (action.equalsIgnoreCase("delete")) {
					int idSetor = Integer.parseInt(request.getParameter("idSetor"));
					dao.deleteSetor(idSetor);
					String mensagem = "Registro removido com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);
			}
			else if (action.equalsIgnoreCase("list")) {
					setores = dao.getAllSetors();			
					request.setAttribute("setores", setores);	
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