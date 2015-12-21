package main.java.lab3.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by Mari on 19.12.2015.
 */
public class EmployeeDataOperations {
    public static void selectAllEmp(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
        DataBase.employees.clear();
        while (rs.next()) {
            Employe employe = new Employe();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                if (i==1) employe.setEmpno(Integer.parseInt(rs.getString(i)));
                else if (i==2) employe.setEname(rs.getString(i));
                else if (i==3) employe.setJob(rs.getString(i));
                else if (i==4) employe.setMgr(Integer.parseInt(rs.getString(i)));
                else if (i==5) employe.setHiredate(rs.getString(i));
                else if (i==6) employe.setSal(Double.parseDouble(rs.getString(i)));
                else if (i==7) employe.setComm(Double.parseDouble(rs.getString(i)));
                else employe.setDeptno(Integer.parseInt(rs.getString(i)));
            }
            DataBase.employees.add(employe);
        }
    }
    public void incertEmp(){}
    public void updateEmp(){}
    public void deleteEmp(){}
}
