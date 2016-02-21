package application.lab3.controller.actions;

import application.lab3.model.EmployeeDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 20.02.2016.
 */
public class ViewBosses implements Action {
    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute("Emp", EmployeeDataOperations.selectAllEmp(req.getParameter("id")));
        return "/jsp/hierarchy.jsp";
    }
}
