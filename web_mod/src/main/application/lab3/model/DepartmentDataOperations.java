package application.lab3.model;

import application.lab3.model.util.DataBase;
import application.lab3.model.util.ResultSetHandler;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mari on 19.12.2015.
 */
public class DepartmentDataOperations {

    private static final String QUERY_SELECT_DEPT = "SELECT * FROM Dept order by ";
    private static final String QUERY_INSERT_DEPT = "INSERT INTO Dept (deptno, dname, loc) VALUES (?, ?, ?)";
    private static final String QUERY_UPDATE_DEPT = "UPDATE Dept set dname = ?, loc = ? where deptno = ?";
    private static final String QUERY_DELETE_DEPT = "DELETE from Dept where deptno = ?";
    private static final String QUERY_SELECT_ONE_DEPT = "SELECT * FROM Dept WHERE deptno = ?";

    DataBase dbexecutor = new DataBase();

    public  Collection<Department> selectAllDept(String column) {
        final Collection<Department> deps = new ArrayList<Department>();
        dbexecutor.executeSelect(QUERY_SELECT_DEPT + column, new ResultSetHandler() {

            @Override
            public void onResultSet(ResultSet rsltSet) throws SQLException {
                ResultSetMetaData rsmd = rsltSet.getMetaData();
                while (rsltSet.next()) {
                    Department department = new Department();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        if (i==1) department.setDeptno(Integer.parseInt(rsltSet.getString(i)));
                        else if (i==2) department.setDname(rsltSet.getString(i));
                        else department.setLoc(rsltSet.getString(i));
                    }

                    deps.add(department);
                }
            }

        });
        return deps;
    }

    public  Collection<Department> selectOneDept(String deptno) {
        final Collection<Department> deps = new ArrayList<Department>();
        dbexecutor.executeSelect(QUERY_SELECT_ONE_DEPT, new ResultSetHandler() {

            @Override
            public void onResultSet(ResultSet rsltSet) throws SQLException {
                ResultSetMetaData rsmd = rsltSet.getMetaData();
                while (rsltSet.next()) {
                    Department department = new Department();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        if (i==1) department.setDeptno(Integer.parseInt(rsltSet.getString(i)));
                        else if (i==2) department.setDname(rsltSet.getString(i));
                        else department.setLoc(rsltSet.getString(i));
                    }

                    deps.add(department);
                }
            }
            @Override
            public void prepStmntBuilder(PreparedStatement prep) throws SQLException {
                prep.setInt(1, Integer.parseInt(deptno));
            }
        });
        return deps;
    }

    public  void insertDept(Department dept){
        dbexecutor.executeInsert(QUERY_INSERT_DEPT,new ResultSetHandler(){
            public void prepStmntBuilder(PreparedStatement prep) throws SQLException {
                prep.setInt(1,dept.getDeptno());
                prep.setString(2,dept.getDname() );
                prep.setString(3,dept.getLoc() );
            }
        });
    }
    public  void updateDept(Department dept){
        dbexecutor.executeUpdate(QUERY_UPDATE_DEPT, new ResultSetHandler() {
            public void prepStmntBuilder(PreparedStatement prep) throws SQLException {
                prep.setString(1, dept.getDname());
                prep.setString(2, dept.getLoc());
                prep.setInt(3, dept.getDeptno());
            }
        });
    }
    public  void deleteDept(int deptno){
        dbexecutor.executeDelete(QUERY_DELETE_DEPT,new ResultSetHandler() {
            public void prepStmntBuilder(PreparedStatement prep) throws SQLException {
                prep.setString(1, String.valueOf(deptno));
            }
        });

    }
}
