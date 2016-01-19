package application.lab3.controller;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;



public class Main extends HttpServlet {

    public void init(ServletConfig var1) throws ServletException{
        try {
            Enumeration e = var1.getInitParameterNames();
            while (e.hasMoreElements()){
                String param =  e.nextElement().toString();
                ActionHandler.initProcStore(param, ActionHandler.getActionObj(var1.getInitParameter(param)));
            }

        } catch (   ClassNotFoundException |
                    InstantiationException |
                    IllegalAccessException e)
        {
            e.printStackTrace();
        }

    }

    protected void service(HttpServletRequest request, HttpServletResponse response)  {

        String resultURL = ActionHandler.getProcess(request).execute(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher( resultURL );

        try {dispatcher.forward(request, response);}
        catch (ServletException |IOException e) {e.printStackTrace();}
    }

}
