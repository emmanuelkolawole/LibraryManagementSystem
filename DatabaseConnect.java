
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author de Prof
 */
public class DatabaseConnect {
     private int count;
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    
     // database URL
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/libmanagementsystem";
    
    
    //method to validate Login details
    public int DatabaseConnect (String uname , String pwrd) throws SQLException{
        // establish connection
        connection = DriverManager.getConnection(DATABASE_URL,"root" , "emma");
        
        // Create the query
        String query = "select * from register where username = '"+uname+"' and password ='"+pwrd+"'";
        //create Statement fo querying database
        statement = connection.createStatement();
        
        //execute query
        resultSet = statement.executeQuery(query);
        
        while(resultSet.next())
        {
            if (count == 1)
        {
            count = 0;
        }
          count ++;  
        }
        
        System.out.println(count);
        return count;
    }
    public static void main (String [] args) throws SQLException{
        DatabaseConnect test = new DatabaseConnect();
        test.DatabaseConnect("bolu", "bolu");
    }
  
}
