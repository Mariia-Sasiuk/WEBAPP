package application.lab3.controller;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import static java.util.Collections.list;


public class Main extends HttpServlet {
//    final Logger LOG = LoggerFactory.getLogger(Main.class);
    private ActionHandler actions = new ActionHandler();

    public void init(ServletConfig var1) throws ServletException{
//        LOG.info("Servlet started its work");
        try {
            Enumeration<String> e = var1.getInitParameterNames();
            for(String param : list(e) )
                actions.put(param, var1.getInitParameter(param));

        } catch (   ClassNotFoundException |
                    InstantiationException |
                    IllegalAccessException e)
        {
            e.printStackTrace();
        }

    }

    protected void service(HttpServletRequest request, HttpServletResponse response)  {

        String resultURL = actions.getProcess(request).execute(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher( resultURL );

        try {dispatcher.forward(request, response);}
        catch (ServletException |IOException e) {e.printStackTrace();}
    }

}
