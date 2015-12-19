package main.java.lab3;

/**
 * Created by Mari on 13.12.2015.
 */
import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    private static final String SELECT_EMP = "SELECT empno, ename, job,nvl(mgr,0),hiredate, nvl(sal,0), nvl(comm,0), nvl(deptno,0)  FROM  emp";
    private static final String SELECT_DEPT = "SELECT * FROM dept";

    public static ArrayList<Employe> employees = new ArrayList<>();
    public static ArrayList<Department> departaments = new ArrayList<>();

        public static void getTables(String table ) {

            StringBuffer response = new StringBuffer();
            Connection connection = null;
            try {
                connection = DriverManager
                        .getConnection("jdbc:oracle:thin:student/student@localhost:1521:xe");
                Statement statement = connection.createStatement();
                ResultSet rs = null;
                // Columns index start with 1 not 0!!!!

                if ("emp".equals(table)){
                    rs = statement.executeQuery(SELECT_EMP);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    EmployeeDataOperations.selectAllEmp(rs, rsmd);
                }
                else if ("dept".equals(table)){
                    rs = statement.executeQuery(SELECT_DEPT);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DepartmentDataOperations.selectAllDept(rs, rsmd);
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
        }
    }// calss
