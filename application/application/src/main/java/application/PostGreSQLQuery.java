package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class PostGreSQLQuery {
    static int insert(String table, String[] fields, String[]data){
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost/sports", "postgres", "root");
            System.out.println("Yupeee");
            Statement stm = c.createStatement();
            stm.execute(String.format("INSERT INTO %s(%s) VALUES (%s)",table,String.join(",",fields),String.join(",",data)));
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    static ResultSet select(String table, String[] fields, String[] conditions){
        return null;
        //will return the selected
    }
    static void delete(String table, String[] conditions){

    }
    static void update(String table, String[] set_fields, String[] conditions){

    }
    static void trunctate(String table){

    }
}
