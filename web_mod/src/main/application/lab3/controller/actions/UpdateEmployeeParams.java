package application.lab3.controller.actions;

import application.lab3.model.Employee;
import application.lab3.model.EmployeeDataOperations;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created by Mari on 21.02.2016.
 */
public class UpdateEmployeeParams implements Action {
    EmployeeDataOperations dataOperations = new EmployeeDataOperations();
    public String execute(HttpServletRequest req) {
        Employee emp = new Employee();
        emp.setEmpno(Integer.parseInt(req.getParameter("empno")));
        emp.setEname(req.getParameter("ename"));
        emp.setJob(req.getParameter("job"));
        emp.setMgr(Integer.parseInt(req.getParameter("mgr")));
        emp.setHiredate(Date.valueOf(req.getParameter("date")));
        emp.setSal(Double.parseDouble(req.getParameter("sal")));
        emp.setComm(Double.parseDouble(req.getParameter("comm")));
        emp.setDeptno(Integer.parseInt(req.getParameter("deptno")));
        dataOperations.updateEmp(emp);
        req.setAttribute("Emp", dataOperations.selectAllEmp("1"));
        return "/jsp/viewEmp.jsp";
    }
}
