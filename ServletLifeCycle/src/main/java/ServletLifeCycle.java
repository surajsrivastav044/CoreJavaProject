import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletLifeCycle extends GenericServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init() called ----> Initialization done....");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Service() called ---> handling request...");
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out=res.getWriter();
        out.println("<h2> Servlet LifeCycle.......</h2>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() called ----> data destroyed... ");
    }
}
