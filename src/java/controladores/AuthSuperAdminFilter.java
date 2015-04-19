package controladores;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */





import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metalblanco.map.com.Usuario;
import modelo.UserBean;

/**
 *
 * @author gavellan
 */
public class AuthSuperAdminFilter implements Filter {

    private FilterConfig configuration;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configuration = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (((HttpServletRequest) request).getSession().getAttribute(AuthBean.USER_KEY) == null || !((Usuario)((HttpServletRequest) request).getSession().getAttribute( AuthBean.USER_KEY)).getTIPODEUSUARIOidtipodeusuario().getCargo().equals("superadministrador") ) {
            ((HttpServletResponse) response).sendRedirect("../forbidden.faces");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        this.configuration = null;
    }

}
