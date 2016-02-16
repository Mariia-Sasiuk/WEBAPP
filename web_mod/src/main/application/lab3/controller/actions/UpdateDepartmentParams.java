package application.lab3.controller.actions;

import application.lab3.model.Department;
import application.lab3.model.DepartmentDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 11.02.2016.
 */
public class UpdateDepartmentParams implements Action{
    public String execute(HttpServletRequest req) {
        Department dept = new Department();
        dept.setDeptno(Integer.parseInt(req.getParameter("deptno")));
        dept.setDname(req.getParameter("dname"));
        dept.setLoc(req.getParameter("loc"));
        DepartmentDataOperations.updateDept(dept);
        req.setAttribute("Dept", DepartmentDataOperations.selectAllDept());
        return "/jsp/viewDept.jsp";
    }
}
