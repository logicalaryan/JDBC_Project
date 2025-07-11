package Logining;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

public class  Cancellations  extends JFrame implements ActionListener {
    JTextField  aadhars;
     JLabel names, canc, dOTF, fflight,fcodes,fcodefield; 
    JTextField PNRFI;
    JButton CANCELB,fetch;
   

    public  Cancellations() {
     
        Random random=new Random();
        
        JLabel heading = new JLabel("Cancellations");
        heading.setFont(new Font("Tahoma", Font.ITALIC, 20));
        heading.setOpaque(true); // Required for background color to show
        heading.setBackground(Color.BLACK);
        heading.setForeground(Color.WHITE);
        heading.setHorizontalAlignment(SwingConstants.CENTER); // 👈 Important!
        heading.setBounds(10, 10, 600, 40); // Increase width as needed
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Logining/icon/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 240, Image.SCALE_SMOOTH); // resize
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(360, 90, 280, 200);// adjust placement
        add(label);
        
          fetch=new JButton("Show Details");
        fetch.setBounds(240,60,120,20);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.addActionListener(this);
        add(fetch);
        

        
        
         JLabel PNRL = new JLabel("PNR NUMBER:");
         PNRL.setBounds(20, 50, 100, 40);
         add(PNRL);
         
         PNRFI = new JTextField();
        PNRFI.setBounds(125, 60,89, 20);
        add(PNRFI);
  
         JLabel user = new JLabel("Name:");
        user.setBounds(20, 80, 100, 100);
        add(user);
        
         names = new JLabel();//textfield
        names.setBounds(125, 120, 100, 20);
        add(names);
        
          JLabel cance = new JLabel("Cancellation no:");
        cance.setBounds(20, 50, 100, 100);
        add(cance);
        
        canc = new JLabel("" +random.nextInt((100000)));//correct
        canc.setBounds(125, 90, 100, 20);//textfieldd
        add(canc);
       
    
        
         fflight = new JLabel("Flight code:");
        fflight.setBounds(20, 110, 100, 100);
        add(fflight);
         
            fcodefield = new JLabel();//correct
        fcodefield.setBounds(125, 150, 100, 20);
        add(fcodefield);
        
       
         JLabel dOT=new JLabel("Date Of Travel:");
        dOT.setBounds(20,181,100,20);
        add(dOT);
        
         dOTF=new JLabel("");// CORRECT
        dOTF.setBounds(125,182,100,20);
        add(dOTF);
        
       
  
        CANCELB = new JButton("Cancel");
         CANCELB .setBounds(100, 210, 110, 20);
         CANCELB .setBackground(Color.BLACK);
         CANCELB .setForeground(Color.WHITE);
        CANCELB .addActionListener(this);
        add( CANCELB );
       
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLocation(300, 150);
        setSize(630, 450);
        setVisible(true);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ✅ correct
    }
    

   @Override
    public void actionPerformed(ActionEvent ae) {
        if(fetch==ae.getSource()){
            String PNRT=PNRFI.getText();
        try
        {
            DbConnection c=new DbConnection();
            String query="select * from  reservation where PNR='"+PNRT+"'";
            ResultSet rs=c.s.executeQuery(query);//query execute
        
        if(rs.next())
        {
            names.setText(rs.getString("name"));
             fcodefield .setText(rs.getString("flightcode"));
            dOTF.setText(rs.getString("ddate"));
        
        }
        else
          {
           JOptionPane.showMessageDialog(null, "please enter valid PNR Number");
          }
        }
        
        
        catch(Exception e)
        {
         e.printStackTrace();
        }
        } 
    
    
           else if(CANCELB==ae.getSource()){
            String name=names.getText();//string ke badd wla colum name in sql
            String cancelno=canc.getText();
            String fcode=fcodefield.getText();
            String ddate=dOTF.getText();
            String pnr=PNRFI.getText();
    try
        {
            DbConnection c=new DbConnection();
            String query="insert into  cancel values('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+ddate+"')";
            c.s.executeUpdate(query);//query execute
            c.s.executeUpdate("delete from reservation where PNR='"+pnr+"'");
            JOptionPane.showMessageDialog(null,"cancelled successfully" );
            setVisible(false);
        
      // JOptionPane.showMessageDialog(null,"please try again");
      
        }
        
        catch(Exception e)
        {
         e.printStackTrace();
         
        }
        }
    }
        
    
    public static void main(String args[]) {
        new Cancellations();
    }

}


