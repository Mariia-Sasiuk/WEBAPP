package application.lab3.controller.actions;

import application.lab3.model.DepartmentDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 16.02.2016.
 */
public class DeleteDepartment implements Action {
    DepartmentDataOperations dataOperations = new DepartmentDataOperations();
    @Override
    public String execute(HttpServletRequest req) {
        dataOperations.deleteDept(Integer.parseInt(req.getParameter("deptno")));
        req.setAttribute("Dept", dataOperations.selectAllDept("1"));
        return "/jsp/viewDept.jsp";
    }
}
