package application.lab3.controller.actions;

import application.lab3.model.DepartmentDataOperations;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 14.01.2016.
 */
public class NewDepartment implements Action {
    public String execute(HttpServletRequest req) {
        DepartmentDataOperations.insertDept(req);
        return "/jsp/edit.jsp";
    }
}
