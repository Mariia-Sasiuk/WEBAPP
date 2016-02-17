package application.lab3.controller.actions;

import application.lab3.model.DepartmentDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 16.02.2016.
 */
public class DeleteDepartment implements Action {
    @Override
    public String execute(HttpServletRequest req) {
        DepartmentDataOperations.deleteDept(Integer.parseInt(req.getParameter("deptno")));
        req.setAttribute("Dept", DepartmentDataOperations.selectAllDept("1"));
        return "/jsp/viewDept.jsp";
    }
}
