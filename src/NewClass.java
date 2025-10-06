
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
public class NewClass implements  TableModel {
     private final String [] columnname={"id","name","opt1","opt2","opt3","opt4","answer"};
    private final Class[] colTypes=new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class};
    private final ArrayList<ArrayList<String>>  students;
     
    public NewClass() {
        System.out.println("Creating questions array");
       students  = new ArrayList<ArrayList<String>>();
        System.out.println("Created.");
        try {
            System.out.println("Connecting...");
            Connection con = connectionprog.getCon();
            System.out.println("Creating statement...");
            Statement stmt = con.createStatement();
            System.out.println("Executing query...");
            ResultSet rs = stmt.executeQuery("SELECT * FROM question");
            System.out.println("Result Set fetched");
            
            while (rs.next()) {
                System.out.println("Getting a row.");
             String id = rs.getString(1);
             String name = rs.getString(2);
             String opt1= rs.getString(3);
             String opt2 = rs.getString(4);
             String opt3= rs.getString(5);
             String opt4= rs.getString(6);
             String answer= rs.getString(7);
             
             ArrayList<String> row = new ArrayList<>();
             row.add( id);
             row.add(name);
             row.add(opt1);
             row.add(opt2);
             row.add(opt3);
             row.add(opt4);
             row.add(answer);
             
                
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
      return 7;
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

    

