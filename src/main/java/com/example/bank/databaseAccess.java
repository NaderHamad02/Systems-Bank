package com.example.bank;
import java.sql.*;
import java.util.ArrayList;


public class databaseAccess {
    public ArrayList<String> getlogs() throws SQLException {
        ArrayList<String> res=null;

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/systems", "root", "Sillah1234@");
            Statement statement=conn.createStatement();
            ResultSet result=statement.executeQuery("select * from logs");
            while(result.next())
            {
                System.out.println(result.getString("id"));
                System.out.println(result.getString("acc_id"));
                System.out.println(result.getString("value"));
            }
        }

        catch(SQLException ex) {
            ex.printStackTrace();
        }
        return res;

    }
    public void setlogs(int acc,int key,String log)
    {
        // Open a connection
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/systems", "root", "Sillah1234@");

                Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            System.out.println(acc);
            System.out.println(key);
            System.out.println(log);
            stmt.executeUpdate("INSERT INTO `logs`(id,acc_id,value) VALUE ('"+key+"','"+acc+"','"+log+"')");

        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
