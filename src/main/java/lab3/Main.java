package main.java.lab3;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Created by Mari on 12.12.2015.
 */
public class Main extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//
//    }
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    String resultURL = performYourLogic(req);

    RequestDispatcher dispatcher = req.getRequestDispatcher( resultURL );
    dispatcher.forward(req, resp);
    //resp.sendRedirect(resultURL); // Forward vs Redirect. What? Why?
}

private static String performYourLogic(HttpServletRequest req) {
    String action = req.getParameter("action");

    if (!action.isEmpty()){
        switch (action){
            case "empView"           : return empURL("emp");
            case "navigation"         : return navigateURL();
            case "help"             : return indexURL();
            default                 : return indexURL();
        }
    }
    return indexURL();
}
    private static String indexURL(){
        return "/jsp/Help.jsp";
    }
    private static String empURL(String tableName){
        DataBase.getTables(tableName);
        return "/jsp/Emp.jsp";
    }
    private static String navigateURL(){
        return "/jsp/Main.jsp";
    }
}
