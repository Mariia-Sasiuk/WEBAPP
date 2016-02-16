package application.lab3.controller.actions;

import application.lab3.model.DepartmentDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 10.02.2016.
 */
public class UpdateDepartment implements Action {
    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute("Dept", DepartmentDataOperations.selectOneDept(req.getParameter("id")));
        return "/jsp/update.jsp";
    }
}
