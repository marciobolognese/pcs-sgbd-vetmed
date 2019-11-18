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
import dao.PagamentoDao;
import model.Convenio;
import model.Pagamento;

@WebServlet("/PagamentoController")
public class PagamentoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/registrarPagamento.jsp";
    private static final String INSERT_P = "/registrarPagamentoParticular.jsp";
    private static final String INSERT_C = "/registrarPagamentoConvenio.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private PagamentoDao dao;

    public PagamentoController() {
        super();
        dao = new PagamentoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
    	
    	ConvenioDao cdao = new ConvenioDao();
    	List<Convenio> convenios = new ArrayList<Convenio>();
    
		Pagamento pagamento = new Pagamento();
		try { 
			if (action.equalsIgnoreCase("insert")) {
				int idPagto = Integer.parseInt(request.getParameter("idPagto"));
				pagamento.setIdPagto(idPagto);			
				pagamento.setPaciente(request.getParameter("paciente"));
				String tipo = request.getParameter("tipo");			
				pagamento.setTipo(tipo);
	            
				if (!dao.existe(pagamento) && tipo.equals("convenio")) {
					convenios = cdao.getAllConvenios();			
					request.setAttribute("convenios", convenios);
					request.setAttribute("pagamento", pagamento);
					request.getRequestDispatcher(INSERT_C).forward(request, response);		
				} else if(!dao.existe(pagamento) && tipo.equals("particular")) {
					request.setAttribute("pagamento", pagamento);
					request.getRequestDispatcher(INSERT_P).forward(request, response);	
				} else {
					String mensagem = "Este pagamento já existe";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(INSERT);
					request.setAttribute("msgerro", mensagem);
					rd.forward(request, response);
				}			
			}
			if (action.equalsIgnoreCase("insert_p")) {
					int idPagto = Integer.parseInt(request.getParameter("idPagto"));
					pagamento.setIdPagto(idPagto);			
					pagamento.setPaciente(request.getParameter("paciente"));
					String tipo = request.getParameter("tipo");			
					pagamento.setTipo(tipo);	
					pagamento.setValor(request.getParameter("valor"));
					pagamento.setFormaPagto(request.getParameter("formaPagto")); 
					pagamento.setPago("true");
					dao.addPagamento(pagamento);
					String mensagem = "Pagamento cadastrado com sucesso";
					RequestDispatcher rd = request.getServletContext().getRequestDispatcher(INSERT);
					request.setAttribute("msg", mensagem);
					rd.forward(request, response);	
		
			}
			if (action.equalsIgnoreCase("insert_c")) {
				int idPagto = Integer.parseInt(request.getParameter("idPagto"));
				pagamento.setIdPagto(idPagto);			
				pagamento.setPaciente(request.getParameter("paciente"));
				String tipo = request.getParameter("tipo");			
				pagamento.setTipo(tipo);	
				pagamento.setValor(request.getParameter("valor"));
				pagamento.setConvenio(request.getParameter("convenio")); 
				pagamento.setPago("true");
				dao.addPagamento(pagamento);
				String mensagem = "Pagamento cadastrado com sucesso";
				RequestDispatcher rd = request.getServletContext().getRequestDispatcher(INSERT);
				request.setAttribute("msg", mensagem);
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
