package java_.lab3.model;

import java_.lab3.model.util.DataBase;
import java_.lab3.model.util.ResultSetHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mari on 19.12.2015.
 */
public class EmployeeDataOperations {

    private static final String QUERY_SELECT_EMP = "SELECT empno, ename, job,nvl(mgr,0),hiredate, nvl(sal,0), nvl(comm,0), nvl(deptno,0)  FROM  emp";
    private static final String QUERY_INSERT_EMP = "INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

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

    public static void insertEmp(HttpServletRequest req){
        DataBase.executeInsert(QUERY_INSERT_EMP,new ResultSetHandler(){
            public void onInsertSet(PreparedStatement prep) throws SQLException {
                prep.setInt(1, Integer.parseInt(req.getParameter("empno")));
                prep.setString(2, req.getParameter("ename"));
                prep.setString(3, req.getParameter("job"));
                prep.setInt(4, Integer.parseInt(req.getParameter("mgr")));
                prep.setDate(5, Date.valueOf(req.getParameter("date")));
                prep.setDouble(6, Double.parseDouble(req.getParameter("sal")));
                prep.setDouble(7, Double.parseDouble(req.getParameter("comm")));
                prep.setInt(8, Integer.parseInt(req.getParameter("deptno")));
                prep.execute();
            }
        });
    }

    public void updateEmp(){}
    public void deleteEmp(){}
}
