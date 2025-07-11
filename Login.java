package Logining;
import javax.swing.*;// all classes with j
import java.awt.*;//color
import java.awt.event.*;//action listener
import java.sql.*;//result set packagr
//import javax.swing.JOptionPane;

        
public class Login extends JFrame implements ActionListener {//actionlistener has abstract method so all actions shall be performed in thst method only
   JButton button1,button2,button3;
   JPasswordField textpass;
   JTextField text;  
    public  Login()
    {
        setLayout(null);//to get full control of the components.
       
       JLabel  javausername=new JLabel("username");
        javausername.setBounds(20,15,150,50);
        add(javausername);
        
        text=new JTextField();
        text.setBounds(100,20,150,30);
        add(text);
        
        JLabel pass=new JLabel("password");
        pass.setBounds(20, 20,150,130);
        add(pass);
        
        textpass=new  JPasswordField();
        textpass.setBounds(100,70,150,30);
        add(textpass);
        
        button1=new JButton("reset");
        button1.setBounds(40,130,100,20);
        button1.addActionListener(this);
        add(button1);
        
        button2=new JButton("submit");
        button2.setBounds(160,130,100,20);
        button2.addActionListener(this);
        add(button2);
        
        
        button3=new JButton("close");
        button3.setBounds(100,180,100,20);
        button3.addActionListener(this);
        add(button3);
        
        
        setLocation(500,150);
        getContentPane().setBackground(new Color(173,216,230));
        setSize(500,500);
          setVisible(true);
    }
   
   
   @Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == button1) { // Reset
        textpass.setText("");
        text.setText("");
    } else if (ae.getSource() == button3) { // Close
        setVisible(false);
    } else if (ae.getSource() == button2) { // Submit
        String username = text.getText();
        String password = textpass.getText();
        try {
            DbConnection c = new DbConnection();
            String query = "SELECT * FROM login WHERE username = '" + username + "' AND pass = '" + password + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                new Home();
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
                setVisible(false);
            }
            rs.close(); // Close ResultSet
            // You should also close the Statement and Connection in DbConnection
        } 
         catch (HeadlessException | SQLException e) {
        e.printStackTrace();
         }

        }
    }//else if of bu submit


             
public static void main(String args[])
    {
    new Login();
    }
}
 //Login login=new Login nhi kiya gya kyunki we wont be needing the use of login



