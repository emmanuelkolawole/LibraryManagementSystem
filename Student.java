
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
public class Student {
            private final String DATABASE_URL = "jdbc:mysql://localhost:3306/libmanagementsystem";
    
    public void add (String mat, String sur, String fname, String othername, String col, String dept,String lev, String sem) throws SQLException{
    //create connection
    Connection con = DriverManager.getConnection(DATABASE_URL,"root","emma");
    //create a prepared statement to insert record
    int constant = 0;
    int count = 0; 
    java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
    
    //check for duplicate
    // Create the query
     String query = "select * from student where Matric_Number = '"+mat+"' ";
     System.out.println(mat);
     Statement set= con.createStatement();
    
     ResultSet sett = set.executeQuery(query);
     
     //CREATE A WHILE LOOP TO COUNT RESULT
     while(sett.next())
        {
        count++;  
        }
     
	
//Matric_Number
    System.out.println(count);
    if (count == 0){
//    
     //SQL statement
     String sql= "insert into student(Matric_Number,Surname,First_Name,Other_Name,College,Department,Level,Semester,Registration_date) "
             + "values ('"+mat+"','"+sur+"','"+fname+"','"+othername+"','"+col+"','"+dept+"','"+lev+"','"+sem+"','"+date+"')";
    //prepare statement
     Statement s = con.prepareStatement(sql);
     
     s.execute(sql);
     JOptionPane.showMessageDialog(null, "STUDENT ADDED SUCCESSFULLY");
 
      } // end of if statement
    else JOptionPane.showMessageDialog(null, "RECORD ALREADY EXISTS");
    }
//       public static void main(String [] args) throws SQLException{
//       Student test = new Student();
//       test.add("4","corlexx","fatai","papa","cop","none","400","fhh"); 
//    }
}
