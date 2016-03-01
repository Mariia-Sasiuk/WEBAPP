package application.lab3.controller.actions;

import application.lab3.model.Department;
import application.lab3.model.DepartmentDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 14.01.2016.
 */
public class NewDepartment implements Action {
    DepartmentDataOperations dataOperations = new DepartmentDataOperations();
    public String execute(HttpServletRequest req) {
        Department dept = new Department();
        dept.setDeptno(Integer.parseInt(req.getParameter("deptno")));
        dept.setDname(req.getParameter("dname"));
        dept.setLoc(req.getParameter("loc"));
        dataOperations.insertDept(dept);
        return "/jsp/edit.jsp";
    }
}
