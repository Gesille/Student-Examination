/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class connectionprog {
    public static Connection getCon(){
    
		   Connection con = null;
           try
           {
               String userName = "root";
               String password = "P@ssword2023";
               String url = "jdbc:mysql://localhost/quizeapplication";        
         try {
             con = DriverManager.getConnection (url, userName, password);
             return con;
         } catch (SQLException ex) {
             Logger.getLogger(connectionprog.class.getName()).log(Level.SEVERE, null, ex);
         }
               System.out.println ("\nDatabase Connection Established...");
               JOptionPane.showMessageDialog(null, "Database Connection Established...");
           }catch (Exception ex)
          
           {
              JOptionPane.showMessageDialog(null, "annot connect to database server");
		       System.err.println ("Cannot connect to database server");
			   ex.printStackTrace();
           }      
        return null;
    }
    }


		   
	
       


