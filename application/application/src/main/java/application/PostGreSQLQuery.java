package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class PostGreSQLQuery {

    static int insert(String table, String[] fields, String[]data){
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost/sports", "postgres", "root");
            Statement stm = c.createStatement();
            stm.execute(String.format("INSERT INTO %s(%s) VALUES (%s)",table,String.join(",",fields),String.join(",",data)));
            ResultSet rs = stm.executeQuery(String.format("SELECT id FROM %s ORDER BY id DESC LIMIT 1",table));
            int a =0;
            a++;
            c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    static String[] select(String table, String[] fields, String[] conditions){
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost/sports", "postgres", "root");
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(String.format("SELECT %s FROM %s WHERE %s",String.join(",",fields),table,String.join(",",conditions)));

            c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    static void delete(String table, String[] conditions){
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost/sports", "postgres", "root");
            Statement stm = c.createStatement();
            stm.execute(String.format("DELETE FROM %s WHERE %s",table,String.join(",",conditions)));
            c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void update(String table, String[] set_fields, String[] conditions){
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost/sports", "postgres", "root");
            Statement stm = c.createStatement();
            stm.execute(String.format("UPDATE %s SET %s WHERE %s",table,String.join(",",set_fields),String.join(",",conditions)));
            c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void truncate(String table){
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost/sports", "postgres", "root");
            Statement stm = c.createStatement();
            stm.execute(String.format("TRUNCATE TABLE %s",table));
            c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
