package application.lab3.controller.actions;

import application.lab3.model.DepartmentDataOperations;

import javax.servlet.http.HttpServletRequest;

public class ViewDepartments implements Action {
    DepartmentDataOperations dataOperations = new DepartmentDataOperations();
    public String execute(HttpServletRequest req) {
            req.setAttribute("Dept", dataOperations.selectAllDept(req.getParameter("column")));
        return "/jsp/viewDept.jsp";
    }
}
