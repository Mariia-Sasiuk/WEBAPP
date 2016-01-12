package java_.lab3.controller;

import java_.lab3.model.DepartmentDataOperations;
import java_.lab3.model.EmployeeDataOperations;

import javax.servlet.http.HttpServletRequest;

abstract class Actions {
    abstract String executeAcion(HttpServletRequest req);
}

        class ViewEmployees extends Actions{


            @Override
            String executeAcion(HttpServletRequest req) {
                req.setAttribute("Emp",EmployeeDataOperations.selectAllEmp());
                return "/jsp/viewEmp.jsp";
            }
        }
        class ViewDepartments extends Actions {

            @Override
            String executeAcion(HttpServletRequest req) {
                req.setAttribute("Dept", DepartmentDataOperations.selectAllDept());
                return "/jsp/viewDept.jsp";
            }
        }
        class navigateMain extends Actions{

            @Override
            String executeAcion(HttpServletRequest req) {
                return "/jsp/Main.jsp";
            }

        }

        class navigateEdit extends Actions{

            @Override
            String executeAcion(HttpServletRequest req) {
                return "/jsp/edit.jsp";
            }

        }

        class newEmployee extends Actions{

            @Override
            String executeAcion(HttpServletRequest req) {
                EmployeeDataOperations.insertEmp(req);
                return "/jsp/edit.jsp";
            }
        }

        class newDepartment extends Actions{

            @Override
            String executeAcion(HttpServletRequest req) {
                DepartmentDataOperations.insertDept(req);
                return "/jsp/edit.jsp";
            }
        }

    class navigateHelp extends Actions{

            @Override
            String executeAcion(HttpServletRequest req) {
                return "/jsp/Help.jsp";
            }

        }
