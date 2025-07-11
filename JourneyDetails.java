/*
package Logining;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{
   JTable table;
   JLabel Pnr;
   JButton shows;
   JTextField pnrf;
    public JourneyDetails()
    {
       table=new JTable();
       
        setLayout(null);   getContentPane().setBackground(Color.WHITE);
     JScrollPane jp=new JScrollPane(table);
          jp.setBounds(0,0,1400,500);
       add(jp);
       
       
       Pnr=new JLabel("PNR");
       Pnr.setBounds(80,50,20,30);
       add(Pnr);
       Pnr.setFont(new Font("Tahoma",Font.PLAIN,20));
       
       pnrf=new JTextField();
       pnrf.setBounds(100,50,50,40);
       add(pnrf);
       
       shows=new JButton("Show Details");
       shows.setBounds(260, 250, 150, 30);
       shows.setForeground(Color.WHITE);
       shows.setBackground(Color.BLACK);
       shows.addActionListener(this); // ❗You need this to handle the click

       add(shows);
      
   
        setSize(800,200);
        setLocation(400,200);
        setVisible(true);
                        
    }   
     @Override
   public void actionPerformed(ActionEvent ae) 
   {
          try
       {
           DbConnection c=new DbConnection();
           ResultSet rs=c.s.executeQuery("select * from  reservation where PNR='"+pnrf.getText()+"'");
           if(!rs.isBeforeFirst())
           {
               JOptionPane.showMessageDialog(null, "invalid PNR number");
               return;
           }table.setModel(DbUtils.resultSetToTableModel(rs));
          
       }
       catch(Exception e)
       {
       e.printStackTrace();
      
       }
   }

    public static void main(String args[])
{
new JourneyDetails();
} 
}*/

/*package Logining;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {
    JTable table;
    JLabel Pnr;
    JButton shows;
    JTextField pnrf;

    public JourneyDetails() {
        setLayout(null);  
        getContentPane().setBackground(Color.WHITE);

        // Table setup
        table = new JTable();
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(20, 20, 750, 200);
        add(jp);

        // PNR Label
        Pnr = new JLabel("PNR:");
        Pnr.setBounds(30, 250, 50, 30);
        Pnr.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(Pnr);

        // PNR TextField
        pnrf = new JTextField();
        pnrf.setBounds(90, 250, 150, 30);
        add(pnrf);

        // Button
        shows = new JButton("Show Details");
        shows.setBounds(260, 250, 150, 30);
        shows.setForeground(Color.WHITE);
        shows.setBackground(Color.BLACK);
        shows.addActionListener(this);
        add(shows); // ✅ Important

        // Frame setup
        setSize(800, 400);
        setLocation(400, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // only closes this frame
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            DbConnection c = new DbConnection();
            ResultSet rs = c.s.executeQuery("select * from reservation where PNR='" + pnrf.getText() + "'");
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Invalid PNR number");
                return;
            }

            // Assuming table can be loaded from result set (needs proper model)
            table.setModel(DbUtils.resultSetToTableModel(rs)); // needs DbUtils library
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new JourneyDetails();
    }
}*/



package Logining;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {
    JTable table;
    JTextField pnrf;
    JButton showButton;

    public JourneyDetails() {
        setTitle("Journey Details Lookup");
        setSize(900, 500);
        setLocationRelativeTo(null); // Center screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel Title
        JLabel title = new JLabel("Journey Details Finder", JLabel.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setBackground(new Color(45, 62, 80));
        title.setBorder(new EmptyBorder(20, 0, 20, 0));
        add(title, BorderLayout.NORTH);

        // Center Panel for Table
        JPanel centerPanel = new JPanel(new BorderLayout());
        table = new JTable();
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(table);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel for PNR input
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(236, 240, 241));
        bottomPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));

        JLabel pnrLabel = new JLabel("Enter PNR:");
        pnrLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        pnrf = new JTextField(15);
        pnrf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pnrf.setBorder(new LineBorder(Color.GRAY, 1));
        pnrf.setToolTipText("Enter valid PNR number");

        showButton = new JButton("Show Details");
        showButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        showButton.setBackground(new Color(41, 128, 185));
        showButton.setForeground(Color.WHITE);
        showButton.setFocusPainted(false);
        showButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showButton.addActionListener(this);

        bottomPanel.add(pnrLabel);
        bottomPanel.add(pnrf);
        bottomPanel.add(showButton);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String pnr = pnrf.getText().trim();
        if (pnr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a PNR number.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            DbConnection c = new DbConnection();
            ResultSet rs = c.s.executeQuery("SELECT * FROM reservation WHERE PNR='" + pnr + "'");
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "No journey found for PNR: " + pnr, "No Result", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JourneyDetails());
    }
}
