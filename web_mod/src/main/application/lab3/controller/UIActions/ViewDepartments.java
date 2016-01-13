package application.lab3.controller.UIActions;

import application.lab3.model.DepartmentDataOperations;

import javax.servlet.http.HttpServletRequest;

public class ViewDepartments implements Action {

    public String execute(HttpServletRequest req) {
        req.setAttribute("Dept", DepartmentDataOperations.selectAllDept());
        return "/jsp/viewDept.jsp";
    }
}
