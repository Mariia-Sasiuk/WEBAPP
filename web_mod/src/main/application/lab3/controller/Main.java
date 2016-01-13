package application.lab3.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Main extends HttpServlet {



    protected void service(HttpServletRequest request, HttpServletResponse response)  {

        String resultURL = UIActionController.getProcess(request).execute(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher( resultURL );

        try {dispatcher.forward(request, response);}
        catch (ServletException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }

}
