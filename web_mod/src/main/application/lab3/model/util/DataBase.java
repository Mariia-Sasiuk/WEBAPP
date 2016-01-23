package application.lab3.model.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;


public class DataBase {

        public static void executeSelect(String query, ResultSetHandler handler ){
            try(Connection connection = ((DataSource) new InitialContext().lookup("studentDB")).getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query))
            {
                handler.onResultSet(rs);
            }
            catch (SQLException | NamingException e)
            {
                e.printStackTrace();
            }
        }

        public static void executeInsert(String query, ResultSetHandler handler){
            try(Connection connection = ((DataSource) new InitialContext().lookup("studentDB")).getConnection();
                PreparedStatement prep = connection.prepareStatement(query))
            {
                handler.onInsertSet(prep);
                prep.execute();
            }
            catch (SQLException | NamingException e)
            {
                e.printStackTrace();
            }
        }
        public static void executeUpdate(){}
        public static void executeDelete(){}

    }
