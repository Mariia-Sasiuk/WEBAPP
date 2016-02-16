package application.lab3.model.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;


public class DataBase {

private static DataSource lookupmyDB() throws NamingException {
    InitialContext context = new InitialContext();
    DataSource dataSource = (DataSource) context.lookup("studentDB");
    return dataSource;
}

    public static void executeSelect(String query, ResultSetHandler handler ){
        try(Connection connection = lookupmyDB().getConnection();
            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet rs = prep.executeQuery())
        {
            handler.onResultSet(rs);
        }
        catch (SQLException | NamingException e)
        {
            e.printStackTrace();
        }
    }



        public static void executeInsert(String query, ResultSetHandler handler){
            try(Connection connection = lookupmyDB().getConnection();
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
        public static void executeUpdate(String query, ResultSetHandler handler){
            try(Connection connection = lookupmyDB().getConnection();
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
        public static void executeDelete(String query, ResultSetHandler handler){
            try(Connection connection = lookupmyDB().getConnection();
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

    }
