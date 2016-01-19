package application.lab3.controller.actions;

import application.lab3.model.EmployeeDataOperations;

import javax.servlet.http.HttpServletRequest;

public class ViewEmployees implements Action {
    public String execute(HttpServletRequest req) {
        req.setAttribute("Emp", EmployeeDataOperations.selectAllEmp());
        return "/jsp/viewEmp.jsp";
    }
}
