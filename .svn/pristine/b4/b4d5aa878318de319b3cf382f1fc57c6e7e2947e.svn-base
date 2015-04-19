package controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.faces.context.FacesContext;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metalblanco.map.com.Usuario;
import modelo.UserBean;

/**
 *
 * @author Usuario
 */

public class AuthAdminFilter implements Filter {
    
    private FilterConfig configuration;
    
    public AuthAdminFilter() {
    }    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configuration = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      
       if (((HttpServletRequest) request).getSession().getAttribute(AuthBean.USER_KEY) == null  ) {
          
            ((HttpServletResponse) response).sendRedirect("../forbidden.faces");
        } else {
            chain.doFilter(request, response);
        } 
        
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
