package project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
   public class test
   {
       
       public static void main (String[] args)
       {
           System.out.println("\n\n***** MySQL JDBC Connection Testing *****");
		   Connection conn = null;
           try
           {
               String userName = "root";
               String password = "P@ssword2023";
               String url = "jdbc:mysql://127.0.0.1/quizeapplication";        
               conn = DriverManager.getConnection (url, userName, password);
               System.out.println ("\nDatabase Connection Established...");
               JOptionPane.showMessageDialog(null, "Database Connection Established...");
           }
          catch (Exception ex)
           {
              JOptionPane.showMessageDialog(null, "Cannot connect to database server");
		       System.err.println ("Cannot connect to database server");
			   ex.printStackTrace();
           }      
		   
		   finally
           {
               if (conn != null)
               {
                   try
                   {
                       System.out.println("\n***** Let terminate the Connection *****");
                       JOptionPane.showMessageDialog(null, "Let terminate the Connection...");
					   conn.close ();					   
                       System.out.println ("\nDatabase connection terminated...");
                   }
                   catch (Exception ex)

   {
				   System.out.println ("Error in connection termination!");
				   }
               }
           }
       }
   }
 