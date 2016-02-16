package application.lab3.model;

import application.lab3.model.util.DataBase;
import application.lab3.model.util.ResultSetHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mari on 19.12.2015.
 */
public class DepartmentDataOperations {

    private static final String QUERY_SELECT_DEPT = "SELECT * FROM Dept";
    private static final String QUERY_INSERT_DEPT = "INSERT INTO Dept (deptno, dname, loc) VALUES (?, ?, ?)";
    private static final String QUERY_UPDATE_DEPT = "UPDATE Dept set dname = ?, loc = ? where deptno = ?";
    private static final String QUERY_DELETE_DEPT = "DELETE from Dept where deptno = ?";
    private static String QUERY_SELECT_ONE_DEPT = "SELECT * FROM Dept WHERE deptno = ";

    public static Collection<Department> selectAllDept() {
        final Collection<Department> deps = new ArrayList<Department>();
        DataBase.executeSelect(QUERY_SELECT_DEPT, new ResultSetHandler() {

            @Override
            public void onResultSet(ResultSet rs) throws SQLException {
                ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next()) {
                    Department department = new Department();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        if (i==1) department.setDeptno(Integer.parseInt(rs.getString(i)));
                        else if (i==2) department.setDname(rs.getString(i));
                        else department.setLoc(rs.getString(i));
                    }

                    deps.add(department);
                }
            }
        });
        return deps;
    }

    public static Collection<Department> selectOneDept(String deptno) {
        final Collection<Department> deps = new ArrayList<Department>();
        DataBase.executeSelect(QUERY_SELECT_ONE_DEPT+deptno, new ResultSetHandler() {

            @Override
            public void onResultSet(ResultSet rs) throws SQLException {
                ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next()) {
                    Department department = new Department();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        if (i==1) department.setDeptno(Integer.parseInt(rs.getString(i)));
                        else if (i==2) department.setDname(rs.getString(i));
                        else department.setLoc(rs.getString(i));
                    }

                    deps.add(department);
                }
            }
        });
        return deps;
    }

    public static void insertDept(Department dept){
        DataBase.executeInsert(QUERY_INSERT_DEPT,new ResultSetHandler(){
            public void onInsertSet(PreparedStatement prep) throws SQLException {
                prep.setInt(1,dept.getDeptno());
                prep.setString(2,dept.getDname() );
                prep.setString(3,dept.getLoc() );
            }
        });
    }
    public static void updateDept(Department dept){
        DataBase.executeUpdate(QUERY_UPDATE_DEPT, new ResultSetHandler() {
            public void onInsertSet(PreparedStatement prep) throws SQLException {
                prep.setString(1, dept.getDname());
                prep.setString(2, dept.getLoc());
                prep.setInt(3, dept.getDeptno());
            }
        });
    }
    public static void deleteDept(int deptno){
        DataBase.executeDelete(QUERY_DELETE_DEPT,new ResultSetHandler() {
            public void onInsertSet(PreparedStatement prep) throws SQLException {
                prep.setString(1, String.valueOf(deptno));
            }
        });

    }
}
