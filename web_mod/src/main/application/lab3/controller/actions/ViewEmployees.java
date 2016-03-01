package application.lab3.controller.actions;

import application.lab3.model.EmployeeDataOperations;

import javax.servlet.http.HttpServletRequest;

public class ViewEmployees implements Action {
    EmployeeDataOperations dataOperations = new EmployeeDataOperations();
    public String execute(HttpServletRequest req) {
        req.setAttribute("Emp", dataOperations.selectAllEmp(req.getParameter("column")));
        return "/jsp/viewEmp.jsp";
    }
}
