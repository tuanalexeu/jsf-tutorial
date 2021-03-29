package book.beans;

import java.io.IOException;
import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonard
 */
@WebFilter(filterName = "LogoutFilter", servletNames = {"Faces Servlet"})
public class LogoutFilter implements Filter {

    public LogoutFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest requestHTTP = (HttpServletRequest) request;
        HttpServletResponse responseHTTP = (HttpServletResponse) response;
        try {
            String resourceURI = requestHTTP.getContextPath() + requestHTTP.getServletPath() + ResourceHandler.RESOURCE_IDENTIFIER;
            String requestURI = requestHTTP.getRequestURI();
           
            System.out.println("requestURI="+requestURI);
            System.out.println("resourceURI="+resourceURI);            
            
            //don't clear cache for resoures like, JavaScript, images, CSS
            if (!requestURI.startsWith(resourceURI)) {                   
                responseHTTP.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                responseHTTP.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
                responseHTTP.addHeader("Cache-Control", "post-check=0, pre-check=0");
                responseHTTP.setHeader("Pragma", "no-cache");
            }
            chain.doFilter(request, response);
        } catch (IOException | ServletException t) {
        }
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig) {
    }
}
