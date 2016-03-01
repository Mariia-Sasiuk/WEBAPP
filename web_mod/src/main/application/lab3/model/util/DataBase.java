package application.lab3.model.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

//TODO:make lookup in initialization
public class DataBase {

//private final DataSource dataSourceLookup;
//
//    public DataBase() throws NamingException {
//        dataSourceLookup = lookupmyDB();
//    }

    private DataSource lookupmyDB() throws NamingException {
        InitialContext context = new InitialContext();
        return(DataSource) context.lookup("studentDB");
    }

    public void executeSelect(String query, ResultSetHandler handler ){
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



        public  void executeInsert(String query, ResultSetHandler handler){
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
        public  void executeUpdate(String query, ResultSetHandler handler){
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
        public  void executeDelete(String query, ResultSetHandler handler){
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
