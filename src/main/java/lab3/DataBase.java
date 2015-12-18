package main.java.lab3;

/**
 * Created by Mari on 13.12.2015.
 */
import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    public static ArrayList<Employe> employeesArrayList = new ArrayList<Employe>();

        public static void getTables(String table ) {
            String query = "SELECT empno, ename, job,nvl(mgr,0),hiredate, nvl(sal,0), nvl(comm,0), nvl(deptno,0)  FROM  emp";
            StringBuffer response = new StringBuffer();
            Connection connection = null;
            try {
                connection = DriverManager
                        .getConnection("jdbc:oracle:thin:student/student@localhost:1521:xe");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                // Columns index start with 1 not 0!!!!
                employeesArrayList.clear();
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
                    employeesArrayList.add(employe);
                }

                rs.close();
                statement.close();
            } catch (Exception e) {
                response = new StringBuffer(e.getMessage());
            } finally {
                try {
                    if (connection != null) {

                        connection.close();
                    }
                } catch (SQLException e) {
                    // connection close failed.
                    response = new StringBuffer(e.getMessage());
                }
            }
//            System.out.println(response.toString());
//            return response.toString();
        }
    }// calss
