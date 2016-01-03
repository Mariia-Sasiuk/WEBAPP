package java_.lab3.model;

import java_.lab3.model.util.DataBase;
import java_.lab3.model.util.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mari on 19.12.2015.
 */
public class EmployeeDataOperations {

    private static final String QUERY_SELECT_EMP = "SELECT empno, ename, job,nvl(mgr,0),hiredate, nvl(sal,0), nvl(comm,0), nvl(deptno,0)  FROM  emp";

    public static Collection<Employee> selectAllEmp() {
        final Collection<Employee> emps = new ArrayList<Employee>();
        DataBase.executeSelect(QUERY_SELECT_EMP, new ResultSetHandler() {

            @Override
            public void onResultSet(ResultSet rs) throws SQLException {
                ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next()) {
                    Employee employee = new Employee();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        if (i == 1) employee.setEmpno(Integer.parseInt(rs.getString(i)));
                        else if (i == 2) employee.setEname(rs.getString(i));
                        else if (i == 3) employee.setJob(rs.getString(i));
                        else if (i == 4) employee.setMgr(Integer.parseInt(rs.getString(i)));
                        else if (i == 5) employee.setHiredate(rs.getString(i));
                        else if (i == 6) employee.setSal(Double.parseDouble(rs.getString(i)));
                        else if (i == 7) employee.setComm(Double.parseDouble(rs.getString(i)));
                        else employee.setDeptno(Integer.parseInt(rs.getString(i)));
                    }
                    emps.add(employee);
                }
            }
        });
        return emps;
    }

    public void incertEmp(){}
    public void updateEmp(){}
    public void deleteEmp(){}
}
