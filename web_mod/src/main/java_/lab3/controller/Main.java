package java_.lab3.controller;

import java_.lab3.model.DepartmentDataOperations;
import java_.lab3.model.EmployeeDataOperations;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Main extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//
//    }
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String resultURL = performAction(request);

    RequestDispatcher dispatcher = request.getRequestDispatcher( resultURL );
    dispatcher.forward(request, response);
    //resp.sendRedirect(resultURL); // Forward vs Redirect. What? Why?
}

private static String performAction(HttpServletRequest req) {
    String action = req.getParameter("action");

    if (!action.isEmpty()){
        switch (action){
            case "empView"           : return tableURL(req,"Emp");
            case "deptView"           : return tableURL(req,"Dept");
            case "navigation"         : return navigateURL();
            case "help"             : return indexURL();
            case "edit"             : return editURL();
            case "insEmp"           : return editURL(req,"Emp");
            case "insDept"           : return editURL(req,"Dept");
            default                 : return indexURL();
        }
    }

     return indexURL();
}
    private static String indexURL(){
        return "/jsp/Help.jsp";
    }
    private static String editURL(HttpServletRequest req, String tableFlag){
        if ("Dept".equals(tableFlag)){
            DepartmentDataOperations.insertDept(req);
        }
        else {
            String ename = req.getParameter("ename");
            System.out.println("ENAME="+ ename);
        }
        return "/jsp/edit.jsp"; }
    private static String editURL(){
        return "/jsp/edit.jsp"; }
    private static String navigateURL(){
        return "/jsp/Main.jsp";
    }
    private static String tableURL(HttpServletRequest req,String tableFlag){
        if ("Dept".equals(tableFlag))
            req.setAttribute(tableFlag, DepartmentDataOperations.selectAllDept());
        else
            req.setAttribute(tableFlag, EmployeeDataOperations.selectAllEmp());
        return "/jsp/view"+tableFlag+".jsp";
    }

}
