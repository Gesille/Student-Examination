
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import project.connectionprog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class resulttablemodel implements  TableModel {
    private final String [] columnname={"rollname","name","fathername","mothername","gender","contactno","email","graduationUniversityName","graduationPassoutYear","address","marks"};
    private final Class[] colTypes=new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class,String.class,String.class,String.class,String.class};
    private final ArrayList<ArrayList<String>>  students;
     
    public resulttablemodel() {
        System.out.println("Creating questions array");
       students  = new ArrayList<ArrayList<String>>();
        System.out.println("Created.");
        try {
            System.out.println("Connecting...");
            Connection con = connectionprog.getCon();
            System.out.println("Creating statement...");
            Statement stmt = con.createStatement();
            System.out.println("Executing query...");
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            System.out.println("Result Set fetched");
            
            while (rs.next()) {
                System.out.println("Getting a row.");
             String rollname = rs.getString(1);
             String name = rs.getString(2);
             String fathername= rs.getString(3);
             String mothername = rs.getString(4);
             String gender = rs.getString(5);
             String contactno= rs.getString(6);
             String email = rs.getString(7);
              String graduationUniversityName = rs.getString(8);
                
                String graduationPassoutYear= rs.getString(10);
                 String address = rs.getString(11);
                  String marks = rs.getString(12);
             ArrayList<String> row = new ArrayList<>();
             row.add( rollname);
             row.add(name);
             row.add(fathername);
             row.add(mothername);
             row.add(gender);
             row.add(contactno);
             row.add(address);
              row.add(marks);
                 row.add(email);
                  row.add(marks);
             students.add(row);
             }
            rs.close();
            stmt.close();
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
   
   
    @Override
    public int getRowCount() {
        return students.size();
    }


    @Override
    public int getColumnCount() {
      return 12;
    }

    @Override
    public String getColumnName(int i) {
         return columnname[i];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return colTypes[columnIndex];
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
      return false;
    }

    @Override
    public Object getValueAt(int row, int col) {
          return students.get(row).get(col);
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
      
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
       
    }
    
}
