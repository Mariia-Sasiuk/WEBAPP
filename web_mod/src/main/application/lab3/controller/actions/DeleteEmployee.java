package application.lab3.controller.actions;

import application.lab3.model.EmployeeDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 21.02.2016.
 */
public class DeleteEmployee implements Action {
    EmployeeDataOperations dataOperations = new EmployeeDataOperations();
    public String execute(HttpServletRequest req) {
        dataOperations.deleteEmp(Integer.parseInt(req.getParameter("empno")));
        req.setAttribute("Emp", dataOperations.selectAllEmp("1"));
        return "/jsp/viewEmp.jsp";
    }
}
