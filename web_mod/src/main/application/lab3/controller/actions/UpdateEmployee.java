package application.lab3.controller.actions;

import application.lab3.model.EmployeeDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 21.02.2016.
 */
public class UpdateEmployee implements Action {
    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute("Emp", EmployeeDataOperations.selectOneEmp(req.getParameter("id")));
        return "/jsp/updateEmp.jsp";
    }
}
