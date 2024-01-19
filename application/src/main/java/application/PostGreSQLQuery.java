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
            rs.next();
            c.close();
            return rs.getInt("id");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }
    static String[] select(String table, String[] fields, String[] conditions){
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost/sports", "postgres", "root");
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(String.format("SELECT %s FROM %s WHERE %s",String.join(",",fields),table,String.join(",",conditions)));
            StringBuilder res = new StringBuilder();
            while(rs.next()){
                for(String field:fields){
                    res.append(rs.getString(field)).append(" ");
                }
                res.append(";");
            }
            c.close();
            return res.toString().split(";");
        }catch(Exception e){
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }
    static void update(String table, String[] set_fields, String[] conditions){
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost/sports", "postgres", "root");
            Statement stm = c.createStatement();
            stm.execute(String.format("UPDATE %s SET %s WHERE %s",table,String.join(",",set_fields),String.join(" and ",conditions)));
            c.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    static void truncate(String table){
        Connection c;
        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost/sports", "postgres", "root");
            Statement stm = c.createStatement();
            stm.execute(String.format("TRUNCATE TABLE %s RESTART IDENTITY CASCADE",table));
            c.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
