package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import model.Login;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String INSERT = "/index.jsp";
    private static final String EDIT = "/alterarSenha.jsp";
    private static final String HOME = "/home.jsp";
    private static final String ERRO = "/erro.jsp";
    private static final String MSG = "Dados informados incorretos.";
    private LoginDao dao;

    public LoginController() {
        super();
        dao = new LoginDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   	
    	String action = request.getParameter("action");
		Login login = new Login();
		HttpSession session = request.getSession();
		
		try {		
			if (action.equalsIgnoreCase("insert")) {			
					login.setUsuario(request.getParameter("usuario"));
					login.setSenha(request.getParameter("senha"));		
					if(dao.existe(login)) {
						String usuario = request.getParameter("usuario");
						String senha = request.getParameter("senha");
				        session.setAttribute("usuario", usuario);
				        session.setAttribute("senha",senha);
				        //session.setMaxInactiveInterval(800);
						response.sendRedirect(request.getContextPath()+HOME);
					} else {
						String mensagem = "Usuario ou senha incorretos";
						RequestDispatcher rd = request.getServletContext().getRequestDispatcher(INSERT);
						request.setAttribute("msgerro", mensagem);
						rd.forward(request, response);
					}			
			} else if (action.equalsIgnoreCase("edit")) {
					String usuario = (String) session.getAttribute("usuario");
					String senha = (String) session.getAttribute("senha");
					String senhaAtual = request.getParameter("senha");
					if(senha.equals(senhaAtual)) {
						String senhaNova = request.getParameter("senhaNova");
						if(!senhaNova.equals(null)) {
							dao.updateLogin(senhaNova, usuario);
							String mensagem = "Alteração realizada com sucesso";
							RequestDispatcher rd = request.getServletContext().getRequestDispatcher(EDIT);
							request.setAttribute("msg", mensagem);
							rd.forward(request, response);					
						}					
					} else {
						String mensagem = "Alteração não realizada. Senha incorreta";
						RequestDispatcher rd = request.getServletContext().getRequestDispatcher(EDIT);
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
