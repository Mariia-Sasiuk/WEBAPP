package application.lab3.model.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

//TODO:remove static(!) and make lookup in initialization
public class DataBase {

private static DataSource lookupmyDB() throws NamingException {
    InitialContext context = new InitialContext();
//    DataSource dataSource = (DataSource) context.lookup("studentDB");
    return (DataSource) context.lookup("studentDB");
}

    public static void executeSelect(String query, ResultSetHandler handler ){
        try(Connection connection = lookupmyDB().getConnection();
            PreparedStatement prep = connection.prepareStatement(query)){
            handler.prepStmntBuilder(prep);
            try(ResultSet rsltSet = prep.executeQuery())
            {
                handler.onResultSet(rsltSet);
            }
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
                handler.prepStmntBuilder(prep);
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
                handler.prepStmntBuilder(prep);
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
                handler.prepStmntBuilder(prep);
                prep.execute();
            }
            catch (SQLException | NamingException e)
            {
                e.printStackTrace();
            }

        }

    }
