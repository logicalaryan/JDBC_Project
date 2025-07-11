package Logining;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {
    JTextField  aadhars;
     JLabel names, nations, phonefield, addressField, genderLabel,fcodes,fnames,fnamefield,fcodefield,genderfield; JLabel source,destination;
    
    JButton bookflight,fetchF,fetch;
    Choice sources,destinations;
    JDateChooser dc;

    public BookFlight() {
     //   setTitle(BOOK Form");

        JLabel customer = new JLabel("BOOK FLIGHTS");
        customer.setBounds(160, 10, 150, 30);
        customer.setBackground(Color.WHITE);
        customer.setOpaque(true);
        customer.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(customer);

         JLabel aadhar = new JLabel("aadhar number");
         aadhar.setBounds(20, 50, 100, 40);
         add(aadhar);
         
         aadhars = new JTextField();
        aadhars.setBounds(125, 60,89, 20);
        add(aadhars);
  
        
         fetch=new JButton("Fetch User");
        fetch.setBounds(240,60,100,20);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.addActionListener(this);
        add(fetch);
       
        JLabel user = new JLabel("Name:");
        user.setBounds(20, 80, 100, 100);
        add(user);

        JLabel nation = new JLabel("Nationality:");
        nation.setBounds(20, 50, 100, 100);
        add(nation);

        JLabel address = new JLabel("Address:");
        address.setBounds(20, 110, 100, 100);
        add(address);

      /*  JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setBounds(20, 80, 100, 100);
        add(aadhar);*/

       source = new JLabel("Source:");
        source.setBounds(20, 160, 100, 150);
        add(source);
        
         destination = new JLabel("Destination:");
        destination.setBounds(20, 250, 100, 20);
        add(destination);
        
        sources=new Choice();
        sources.setBounds(125, 225, 75, 20);
         add(sources);
        
        destinations=new Choice();
        destinations.setBounds(125, 250, 75, 20);
         add(destinations);
        
         
        JLabel phone = new JLabel("Phone Number:");
        phone.setBounds(20, 200, 100, 20);
        add(phone);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(20, 135, 120, 100);
        add(genderLabel);

        fetchF = new JButton("Fetch Flight");
        fetchF.setBounds(230, 250, 110, 20);
        fetchF.setBackground(Color.BLACK);
        fetchF.setForeground(Color.WHITE);
        fetchF.addActionListener(this);
        add(fetchF);
        
        
        
        JLabel dOT=new JLabel("Date Of Travel");
        dOT.setBounds(20,320,100,20);
        add(dOT);
        
        dc=new JDateChooser();
        dc.setBounds(120, 320,100, 20);
        add(dc);
        
        fcodes=new JLabel("Flight code:");
        fcodes.setBounds(20,240,150,100);
        add(fcodes);
       
         fnames=new JLabel("Flight names:");
        fnames.setBounds(20,298,100,20);
        add(fnames);
        
        fcodefield=new JLabel();
        fcodefield.setBounds(125,280,100,20);
        add(fcodefield);
        
        fnamefield=new JLabel();
        fnamefield.setBounds(125,295,100,20);
        add(fnamefield);
        
       
        
        genderfield=new JLabel();
        genderfield.setBounds(125,176,100,20);
        add(genderfield);
        
        names = new JLabel();//textfield
        names.setBounds(125, 120, 100, 20);
        add(names);

        nations = new JLabel();
        nations.setBounds(125, 90, 100, 20);
        add(nations);

       /* aadhars = new JTextField();
        aadhars.setBounds(125, 121, 100, 20);
        add(aadhars);*/

        addressField = new JLabel();
        addressField.setBounds(125, 150, 120, 20);
        add(addressField);

        phonefield = new JLabel(); 
        phonefield.setBounds(115, 100, 100, 20);
        add(phonefield);

        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("Logining/icon/flightbook.jpg"));
        Image img = originalIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon = new ImageIcon(img);//image object cant be directly pass into jlabel so we pass first through imageicon 
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(340, 100, 300, 200); 
        add(imageLabel);

        bookflight = new JButton("book flight");
        bookflight.setBounds(120, 350, 100, 20);
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.addActionListener(this);
        add(bookflight);
        
       try{
            DbConnection c=new DbConnection();
            String query="Select * from flight";
            ResultSet rs=c.s.executeQuery(query);//rs mae sab store hota hai
            while(rs.next())//line by line checks
            {
                sources.add(rs.getString("source"));//bracket ke andar wahi colum name hona chahiye jisse hum details extract kr rhe hai
                destinations.add(rs.getString("Destination"));
            }
        }
        catch(Exception e)
                {
                    e.printStackTrace();
     
                }
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLocation(300, 150);
        setSize(630, 500);
        setVisible(true);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ✅ correct
    }
    

   @Override
    public void actionPerformed(ActionEvent ae) {
        if(fetch==ae.getSource()){
            String aadharr=aadhars.getText();
        try
        {
            DbConnection c=new DbConnection();
            String query="select * from  passenger where aadhar='"+aadharr+"'";//here aadhar is column name 
            ResultSet rs=c.s.executeQuery(query);//query execute
        
        if(rs.next())
        {
            names.setText(rs.getString("name"));
            nations.setText(rs.getString("nationality"));
            addressField.setText(rs.getString("address"));
            genderfield.setText(rs.getString("gender"));
        }
        else
          {
           JOptionPane.showMessageDialog(null, "please enter valid aadhar number");
          }
        }
        
        catch(Exception e)
        {
         e.printStackTrace();
        }
        }
        else if(fetchF==ae.getSource()){
            String src=sources.getSelectedItem();
            String dest=destinations.getSelectedItem();
        try
        {
            DbConnection c=new DbConnection();
            String query="select * from  FLIGHT where Source='"+src+"' AND Destination='"+dest+"'";
            ResultSet rs=c.s.executeQuery(query);//query execute
        
        if(rs.next())
        {
            fcodefield.setText(rs.getString("f_code"));
            fnamefield.setText(rs.getString("f_name"));
            
        }
        else
          {
           JOptionPane.showMessageDialog(null, "invalid flight details");
          }
        }
        
        catch(Exception e)
        {
         e.printStackTrace();
         
        }
        }
        
        else
        {
              String aadhar=aadhars.getText();
              String name=names.getText();
              String nationality=nations.getText();   //remeember the variables after string should be same as the column name;
             // String phonefields=phonefield.getText();
              String address=addressField.getText();
              String flightname=fnamefield.getText();
              String flightcode=fcodefield.getText();
              String src=sources.getSelectedItem();
              String des=destinations.getSelectedItem();
              String ddate=((JTextField)dc.getDateEditor().getUiComponent()).getText();
              
      try
        {
            Random random=new Random();
            DbConnection c=new DbConnection();
            String query="insert into reservation values('PNR-"+random.nextInt(10000)+"','TIC-"+random.nextInt(10000)+"', '"+aadhar+"' , '"+name+"' , '"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"' ,'"+des+"','"+ddate+"')";     
         
            c.s.executeUpdate(query);//query execute   
           JOptionPane.showMessageDialog(null, "Book successfully");
         // setVisible(false);
        }
        
        catch(Exception e)
        {
         e.printStackTrace();
        }
   
        }
        
    }


    public static void main(String args[]) {
        new BookFlight();
    }

}


