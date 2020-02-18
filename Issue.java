
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
public class Issue {
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/libmanagementsystem";
    
    public void add (String bk, String nam, String edi, String pub, String pric, String pag,
            String mat, String sname, String surname, String col, String dept,String lev, String sem ) throws SQLException{
    //create connection
    Connection con = DriverManager.getConnection(DATABASE_URL,"root","emma");
    //create a prepared statement to insert record
    int constant = 0;
    int count = 0; 
    java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
    
//    check for duplicate
//     Create the query
     String query = "select * from issue where 	book_id = '"+bk+"' and matric_no ='"+mat+"'";
     
     Statement set= con.createStatement();
    
     ResultSet sett = set.executeQuery(query);
     
//     CREATE A WHILE LOOP TO COUNT RESULT
     while(sett.next())
        {
        count++;  
        }
     
    System.out.println(count);
    if (count == 0){
////    
     //SQL statement
     String sql= "insert into issue(book_id,name,edition,published,price,pages,matric_no,sname,surname,college,department,level,semester,date_issued) "
             + "values ('"+bk+"','"+nam+"','"+edi+"','"+pub+"','"+pric+"','"+pag+"','"+mat+"','"+sname+"','"+surname+"','"+col+"','"+dept+"','"+lev+"','"+sem+"','"+date+"')";
    //prepare statement
     Statement s = con.prepareStatement(sql);
     
     s.execute(sql);
     JOptionPane.showMessageDialog(null, "BOOK ISSUED SUCCESSFULLY");
 
      } // end of if statement
    else JOptionPane.showMessageDialog(null, "STUDENT ALREADY BORROWED BOOK");
    }

    
}
