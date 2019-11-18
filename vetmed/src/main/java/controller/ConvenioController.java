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

import dao.ConvenioDao;
import model.Convenio;

@WebServlet("/ConvenioController")
public class ConvenioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/cadastrarConvenio.jsp";
    private static final String EDIT = "/atualizarConvenio.jsp";
    private static final String LIST = "/consultarConvenio.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private ConvenioDao dao;

    public ConvenioController() {
        super();
        dao = new ConvenioDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
		List<Convenio> convenios = new ArrayList<Convenio>();

		Convenio convenio = new Convenio();
		
		try {		
			if (action.equalsIgnoreCase("insert")) {	
				    int CNPJConvenio = Integer.parseInt(request.getParameter("CNPJConvenio"));
					convenio.setCNPJConvenio(CNPJConvenio);
					convenio.setNomeConvenio(request.getParameter("nomeConvenio"));
					if(!dao.existe(convenio)) {
						dao.addConvenio(convenio);
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
					int CNPJConvenio = Integer.parseInt(request.getParameter("CNPJConvenio"));
					convenio = dao.getConvenioByCNPJ(CNPJConvenio);
					request.setAttribute("convenio", convenio);
					request.getRequestDispatcher(EDIT).forward(request, response);				
			}
			
			else if (action.equalsIgnoreCase("edit")) {
					int CNPJConvenio = Integer.parseInt(request.getParameter("CNPJConvenio"));
					convenio.setCNPJConvenio(CNPJConvenio);
					convenio.setNomeConvenio(request.getParameter("nomeConvenio"));
				
					dao.updateConvenio(convenio, CNPJConvenio);
					String mensagem = "Alteração realizada com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);	
			}
			else if (action.equalsIgnoreCase("delete")) {
					int CNPJConvenio = Integer.parseInt(request.getParameter("CNPJConvenio"));
					dao.deleteConvenio(CNPJConvenio);
					String mensagem = "Registro removido com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(LIST);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);
			}
			else if (action.equalsIgnoreCase("list")) {
					convenios = dao.getAllConvenios();			
					request.setAttribute("convenios", convenios);	
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