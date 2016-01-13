package application.lab3.controller.UIActions;

import application.lab3.model.EmployeeDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 14.01.2016.
 */
public class newEmployee implements Action {
    public String execute(HttpServletRequest req) {
        EmployeeDataOperations.insertEmp(req);
        return "/jsp/edit.jsp";
    }
}
