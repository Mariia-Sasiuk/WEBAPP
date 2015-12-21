package main.java.lab3.model;

import java.sql.*;

/**
 * Created by Mari on 19.12.2015.
 */
public class DepartmentDataOperations {
    public static void selectAllDept(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
        DataBase.departaments.clear();
        while (rs.next()) {
            Department department = new Department();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                if (i==1) department.setDeptno(Integer.parseInt(rs.getString(i)));
                else if (i==2) department.setDname(rs.getString(i));
                else department.setLoc(rs.getString(i));
            }
            DataBase.departaments.add(department);
        }
    }
    public void incertDept(){}
    public void updateDept(){}
    public void deleteDept(){}
}
