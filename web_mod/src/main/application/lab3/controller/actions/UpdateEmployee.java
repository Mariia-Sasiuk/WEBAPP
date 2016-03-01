package application.lab3.controller.actions;

import application.lab3.model.EmployeeDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 21.02.2016.
 */
public class UpdateEmployee implements Action {
    EmployeeDataOperations dataOperations = new EmployeeDataOperations();
    public String execute(HttpServletRequest req) {
        req.setAttribute("Emp", dataOperations.selectOneEmp(req.getParameter("id")));
        return "/jsp/updateEmp.jsp";
    }
}
