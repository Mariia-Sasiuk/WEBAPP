package java_.lab3.model.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;


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

        public static void executeSelect(String query, ResultSetHandler handler ){
            try {
                Statement statement = getConnection().createStatement();
                ResultSet rs = statement.executeQuery(query);
                handler.onResultSet(rs);

                rs.close();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                closeConnection();
            }
        }

        public static void executeInsert(String query, ResultSetHandler handler){
            try(PreparedStatement prep = getConnection().prepareStatement(query)) {
                handler.onInsertSet(prep);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                closeConnection();
            }
        }
        public static void executeUpdate(){}
        public static void executeDelete(){}

    }// calss
