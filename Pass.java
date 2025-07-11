package Logining;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pass extends JFrame implements ActionListener {
    JLabel nameF, nationF, Fname, Fcodes, sourceF, desF, dateF;
    JTextField aadhars;
    JButton fetch;

    public Pass() {
        // 1. Set layout null FIRST
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        

        

        // Add other labels and fields AFTER setting layout null
        JLabel customer = new JLabel("BOOK FLIGHTS");
        customer.setBounds(220, 10, 150, 30);
        customer.setBackground(Color.WHITE);
        customer.setOpaque(true);
        customer.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(customer);

        JLabel customers = new JLabel("Boarding Pass");
        customers.setBounds(220, 50, 150, 30);
        customers.setBackground(Color.BLACK);
        customers.setOpaque(true);
        customers.setFont(new Font("Tahoma", Font.ITALIC, 20));
        customers.setForeground(Color.WHITE);
        customers.setHorizontalAlignment(SwingConstants.CENTER);
        add(customers);

        JLabel aadhar = new JLabel("PNR:");
        aadhar.setBounds(20, 100, 100, 40);
        add(aadhar);

        aadhars = new JTextField();
        aadhars.setBounds(100, 110, 100, 20);
        add(aadhars);

        JLabel user = new JLabel("Name:");
        user.setBounds(20, 140, 100, 20);
        add(user);

        nameF = new JLabel();
        nameF.setBounds(100, 140, 100, 20);
        add(nameF);

        JLabel nation = new JLabel("Nationality:");
        nation.setBounds(20, 170, 100, 20);
        add(nation);

        nationF = new JLabel();
        nationF.setBounds(100, 170, 100, 20);
        add(nationF);

        JLabel address = new JLabel("Flight Name:");
        address.setBounds(20, 200, 100, 20);
        add(address);

        Fname = new JLabel();
        Fname.setBounds(100, 200, 100, 20);
        add(Fname);

        JLabel Fcode = new JLabel("Flight code:");
        Fcode.setBounds(177, 200, 100, 20);
        add(Fcode);

        Fcodes = new JLabel();
        Fcodes.setBounds(250, 200, 100, 20);
        add(Fcodes);

        JLabel sources = new JLabel("Source:");
        sources.setBounds(20, 230, 100, 20);
        add(sources);

        sourceF = new JLabel();
        sourceF.setBounds(95, 230, 100, 20);
        add(sourceF);

        JLabel des = new JLabel("Destination:");
        des.setBounds(177, 230, 100, 20);
        add(des);

        desF = new JLabel();
        desF.setBounds(250, 230, 100, 20);
        add(desF);

        JLabel dates = new JLabel("Date:");
        dates.setBounds(20, 260, 100, 20);
        add(dates);

        dateF = new JLabel();
        dateF.setBounds(95, 260, 100, 20);
        add(dateF);

        fetch = new JButton("ENTER");
        fetch.setBounds(220, 110, 100, 20);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.addActionListener(this);
        add(fetch);
  
        setVisible(true);
        // Frame properties at the end
        setLocation(300, 150);
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       // setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      String pnr=aadhars.getText();
      try
      {
      DbConnection db=new DbConnection();
      String query="select * from reservation where PNR='"+pnr+"'";
      ResultSet rs=db.s.executeQuery(query);
      if(rs.next())
      {
      nameF.setText(rs.getString("name"));
       nationF.setText(rs.getString("nationality"));
        Fname.setText(rs.getString("flightname"));
         Fcodes.setText(rs.getString("flightcode"));
           sourceF.setText(rs.getString("src"));
            desF.setText(rs.getString("des"));
             dateF.setText(rs.getString("ddate"));
      }
      }
      catch(Exception e)
              {
                  
              }
    }

    public static void main(String args[]) {
        new Pass();
    }
}
