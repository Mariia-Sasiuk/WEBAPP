package main.java.lab3.model;

import main.java.lab3.model.util.DataBase;
import main.java.lab3.model.util.ResultSetHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mari on 19.12.2015.
 */
public class DepartmentDataOperations {

    private static final String QUERY_SELECT_DEPT = "SELECT * FROM Dept";

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

    public void incertDept(){}
    public void updateDept(){}
    public void deleteDept(){}
}
