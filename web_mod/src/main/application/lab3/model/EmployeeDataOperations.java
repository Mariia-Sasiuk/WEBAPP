package application.lab3.model;

import application.lab3.model.util.DataBase;
import application.lab3.model.util.ResultSetHandler;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mari on 19.12.2015.
 */
public class EmployeeDataOperations {

    private static final String QUERY_SELECT_EMP = "SELECT empno, ename, job,nvl(mgr,0) mgr,hiredate, nvl(sal,0) sal, nvl(comm,0) comm, nvl(deptno,0) deptno  FROM  emp order by ";
    private static final String QUERY_SELECT_ONE_EMP = "SELECT empno, ename, job,nvl(mgr,0) mgr,hiredate, nvl(sal,0) sal, nvl(comm,0) comm, nvl(deptno,0) deptno  FROM  emp WHERE empno = ?";
    private static final String QUERY_INSERT_EMP = "INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String QUERY_DELETE_EMP = "DELETE FROM emp WHERE empno = ?";
    private static final String QUERY_UPDATE_EMP = "UPDATE emp SET ename = ?, " +
                                                        "job = ?, " +
                                                        "mgr = ?, " +
                                                        "hiredate = ?, " +
                                                        "sal = ?, " +
                                                        "comm = ?, " +
                                                        "deptno = ? " +
                                                        "WHERE empno = ?";
    private static final String QUERY_SELECT_BOSS = "SELECT empno, ename, job,nvl(mgr,0) mgr,hiredate, nvl(sal,0) sal, nvl(comm,0) comm, nvl(deptno,0) deptno \n" +
                                                    "      FROM emp \n" +
                                                    "      CONNECT BY PRIOR mgr=empno\n" +
                                                    "      START WITH empno= ?";

    DataBase dbexecution = new DataBase();

    public  Collection<Employee> selectAllEmp(String column) {
        final Collection<Employee> emps = new ArrayList<Employee>();
        dbexecution.executeSelect(QUERY_SELECT_EMP + column, new ResultSetHandler() {

            @Override
            public void onResultSet(ResultSet rsltSet) throws SQLException {

                while (rsltSet.next()) {
                    Employee employee = new Employee();
                    employee.setEmpno(Integer.parseInt(rsltSet.getString("empno")));
                    employee.setEname(rsltSet.getString("ename"));
                    employee.setJob(rsltSet.getString("job"));
                    employee.setMgr(Integer.parseInt(rsltSet.getString("mgr")));
                    employee.setHiredate(rsltSet.getDate("hiredate"));
                    employee.setSal(Double.parseDouble(rsltSet.getString("sal")));
                    employee.setComm(Double.parseDouble(rsltSet.getString("comm")));
                    employee.setDeptno(Integer.parseInt(rsltSet.getString("deptno")));
                    emps.add(employee);
                }
            }
        });
        return emps;
    }

    public  Collection<Employee> selectOneEmp(String empno) {
        final Collection<Employee> emps = new ArrayList<Employee>();
        dbexecution.executeSelect(QUERY_SELECT_ONE_EMP, new ResultSetHandler() {

            @Override
            public void onResultSet(ResultSet rsltSet) throws SQLException {

                while (rsltSet.next()) {
                    Employee employee = new Employee();
                    employee.setEmpno(Integer.parseInt(rsltSet.getString("empno")));
                    employee.setEname(rsltSet.getString("ename"));
                    employee.setJob(rsltSet.getString("job"));
                    employee.setMgr(Integer.parseInt(rsltSet.getString("mgr")));
                    employee.setHiredate(rsltSet.getDate("hiredate"));
                    employee.setSal(Double.parseDouble(rsltSet.getString("sal")));
                    employee.setComm(Double.parseDouble(rsltSet.getString("comm")));
                    employee.setDeptno(Integer.parseInt(rsltSet.getString("deptno")));
                    emps.add(employee);
                }
            }
            @Override
            public void prepStmntBuilder(PreparedStatement prep) throws SQLException {
                prep.setInt(1, Integer.parseInt(empno));
            }

        });
        return emps;
    }

    public  Collection<Employee> selectBosses(String empno) {
        final Collection<Employee> emps = new ArrayList<Employee>();
        dbexecution.executeSelect(QUERY_SELECT_BOSS, new ResultSetHandler() {

            @Override
            public void onResultSet(ResultSet rsltSet) throws SQLException {

                while (rsltSet.next()) {
                    Employee employee = new Employee();
                    employee.setEmpno(Integer.parseInt(rsltSet.getString("empno")));
                    employee.setEname(rsltSet.getString("ename"));
                    employee.setJob(rsltSet.getString("job"));
                    employee.setMgr(Integer.parseInt(rsltSet.getString("mgr")));
                    employee.setHiredate(rsltSet.getDate("hiredate"));
                    employee.setSal(Double.parseDouble(rsltSet.getString("sal")));
                    employee.setComm(Double.parseDouble(rsltSet.getString("comm")));
                    employee.setDeptno(Integer.parseInt(rsltSet.getString("deptno")));
                    emps.add(employee);
                }
            }
            public void prepStmntBuilder(PreparedStatement prep) throws SQLException {
                prep.setInt(1, Integer.parseInt(empno));
            }
        });
        return emps;
    }

    public  void insertEmp(Employee emp){
        dbexecution.executeInsert(QUERY_INSERT_EMP,new ResultSetHandler(){
            public void prepStmntBuilder(PreparedStatement prep) throws SQLException {
                prep.setInt(1, emp.getEmpno());
                prep.setString(2, emp.getEname());
                prep.setString(3, emp.getJob());
                prep.setInt(4, emp.getMgr());
                prep.setDate(5, emp.getHiredate());
                prep.setDouble(6, emp.getSal());
                prep.setDouble(7, emp.getComm());
                prep.setInt(8, emp.getDeptno());
//                prep.execute();
            }
        });
    }

    public  void updateEmp(Employee emp){
        dbexecution.executeUpdate(QUERY_UPDATE_EMP, new ResultSetHandler() {
            public void prepStmntBuilder(PreparedStatement prep) throws SQLException {
                prep.setString(1, emp.getEname());
                prep.setString(2, emp.getJob());
                prep.setInt(3, emp.getMgr());
                prep.setDate(4, emp.getHiredate());
                prep.setDouble(5, emp.getSal());
                prep.setDouble(6, emp.getComm());
                prep.setInt(7, emp.getDeptno());
                prep.setInt(8, emp.getEmpno());
            }
        });
    }
    public  void deleteEmp(int empno){
        dbexecution.executeDelete(QUERY_DELETE_EMP,new ResultSetHandler() {
                public void prepStmntBuilder(PreparedStatement prep) throws SQLException {
                    prep.setString(1, String.valueOf(empno));
                }
            });
    }
}
