package application.lab3.controller.UIActions;

import application.lab3.model.EmployeeDataOperations;

import javax.servlet.http.HttpServletRequest;


public class NewEmployee implements Action {

    public String execute(HttpServletRequest req) {
        EmployeeDataOperations.insertEmp(req);
        return "/jsp/edit.jsp";
    }
}
