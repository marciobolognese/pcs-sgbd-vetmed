package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/vt/*","/auth/alterarSenha.jsp"})
public class SessionFilter implements Filter {
	
	public void init(FilterConfig config) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
	        FilterChain filterChain) throws IOException, ServletException {
		
	    if ((request instanceof HttpServletRequest) && (response instanceof HttpServletResponse)) {

	        HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpSession session = ((HttpServletRequest) request).getSession();        
	        try {
	            if ((session.getAttribute("usuario") == null)&&!httpRequest.isRequestedSessionIdValid()) {
	                HttpServletResponse httpResponse = (HttpServletResponse)response;
	                httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
	            } else {
	                filterChain.doFilter(request, response);
	            }
	        } catch (Exception e) {
	            HttpServletResponse httpResponse = (HttpServletResponse)response;
	            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro.jsp");
	        }
	    }
	    
	}

	public void destroy() {
	}
	
}
