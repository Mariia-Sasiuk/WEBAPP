package main.java.lab3.model;



import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    private static Connection getConnection() {
        Connection connection = null;
        try {
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("studentDB");
            connection = dataSource.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(){
        if (getConnection()!=null)
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    private static final String SELECT_EMP = "SELECT empno, ename, job,nvl(mgr,0),hiredate, nvl(sal,0), nvl(comm,0), nvl(deptno,0)  FROM  emp";
    private static final String SELECT_DEPT = "SELECT * FROM dept";

    public static ArrayList<Employe> employees = new ArrayList<>();
    public static ArrayList<Department> departaments = new ArrayList<>();

        public static void executeSelect(String table) {

            try {
                Statement statement = getConnection().createStatement();
                ResultSet rs = null;

                if ("Emp".equals(table)){
                    rs = statement.executeQuery(SELECT_EMP);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    EmployeeDataOperations.selectAllEmp(rs, rsmd);
                }
                else if ("Dept".equals(table)){
                    rs = statement.executeQuery(SELECT_DEPT);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DepartmentDataOperations.selectAllDept(rs, rsmd);
                }

                rs.close();
                statement.close();
            } catch (Exception e) {
               // Do not forget to add LOGs
            } finally {
                closeConnection();
            }
        }

        public static void executeIncert(){}
        public static void executeUpdate(){}
        public static void executeDelete(){}

    }// calss
