package application.lab3.controller.actions;

import application.lab3.model.EmployeeDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 21.02.2016.
 */
public class DeleteEmployee implements Action {
    @Override
    public String execute(HttpServletRequest req) {
        EmployeeDataOperations.deleteEmp(Integer.parseInt(req.getParameter("empno")));
        req.setAttribute("Emp", EmployeeDataOperations.selectAllEmp("1"));
        return "/jsp/viewEmp.jsp";
    }
}
