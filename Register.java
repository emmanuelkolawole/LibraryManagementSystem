
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
public class Register {
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/libmanagementsystem";
    
    public void add (String uname, String name, String pword, String conpword, String secquest, String ans) throws SQLException{
    //create connection
    Connection con = DriverManager.getConnection(DATABASE_URL,"root","emma");
    //create a prepared statement to insert record
    int constant = 0;
    int count = 0; 
    java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
    
    //check for duplicate
    // Create the query
     String query = "select * from login where username = '"+uname+"' ";
     
     Statement set= con.createStatement();
    
     ResultSet sett = set.executeQuery(query);
     
     //CREATE A WHILE LOOP TO COUNT RESULT
     while(sett.next())
        {
        count++;  
        }
     
    System.out.println(count);
    if (count == 0){
//    
     //SQL statement
     String sql= "insert into register(username,name,password,confirmpassword,securityquestion,answer,registrationdate) "
             + "values ('"+uname+"','"+name+"','"+pword+"','"+conpword+"','"+secquest+"','"+ans+"','"+date+"')";
    //prepare statement
     Statement s = con.prepareStatement(sql);
     
     s.execute(sql);
     JOptionPane.showMessageDialog(null, "DETAILS SUCCESSFULLY INSERTED INTO THE DATABASE");
 
      } // end of if statement
    else JOptionPane.showMessageDialog(null, "RECORD ALREADY EXISTS");
    }
    
//    public static void main(String [] args) throws SQLException{
//       Register test = new Register();
//       test.add("kolawole","corlexx","fatai","papa","corlexx@yahoo.com","none"); 
//    }
}
