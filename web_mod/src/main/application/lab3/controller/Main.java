package application.lab3.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;



public class Main extends HttpServlet {

    public void init(ServletConfig var1) throws ServletException{
        try {
            while (var1.getInitParameterNames().hasMoreElements()){
                String param =  var1.getInitParameterNames().nextElement()+"";
                UIActionController.initProcStore(param, UIActionController.refl(var1.getInitParameter(param)));
            }

        } catch (   ClassNotFoundException |
                    InstantiationException |
                    IllegalAccessException e)
        {
            e.printStackTrace();
        }

    }

    protected void service(HttpServletRequest request, HttpServletResponse response)  {

        String resultURL = UIActionController.getProcess(request).execute(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher( resultURL );

        try {dispatcher.forward(request, response);}
        catch (ServletException |IOException e) {e.printStackTrace();}
    }

}
