
package Logining;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Flightinfo extends JFrame {
    public Flightinfo()
    {
       JTable table=new JTable();
       try
       {
           DbConnection c=new DbConnection();
           ResultSet rs=c.s.executeQuery("select * from  flight");
           table.setModel(DbUtils.resultSetToTableModel(rs)); 
          
       }
       catch(Exception e)
       {
       e.printStackTrace();
      
       }
    
     JScrollPane jp=new JScrollPane(table);
          jp.setBounds(0,0,1400,500);
       add(jp);
       
       getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800,200);
        setLocation(400,200);
        setVisible(true);
                        
    }   
     public static void main(String args[])
{
new Flightinfo();
}
}
