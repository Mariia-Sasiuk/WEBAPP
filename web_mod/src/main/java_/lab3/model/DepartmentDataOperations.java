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
public class DepartmentDataOperations {

    private static final String QUERY_SELECT_DEPT = "SELECT * FROM Dept";
    private static final String QUERY_INSERT_DEPT = "INSERT INTO Dept (deptno, dname, loc) VALUES (?, ?, ?)";

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

    public static void insertDept(HttpServletRequest req){
        DataBase.executeInsert(QUERY_INSERT_DEPT,new ResultSetHandler(){
            public void onInsertSet(PreparedStatement prep) throws SQLException {
                prep.setInt(1, Integer.parseInt(req.getParameter("deptno")));
                prep.setString(2, req.getParameter("dname"));
                prep.setString(3, req.getParameter("loc"));
                prep.execute();
            }
        });
    }
    public void updateDept(){}
    public void deleteDept(){}
}
