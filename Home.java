
package Logining;
import javax.swing.*;// all classes with j
import java.awt.*;//color
import java.awt.event.*;//action listener
//import java.sql.*;//result set packagr
//import javax.swing.JOptionPane;
// jabel displays image and text
        
public class Home extends JFrame implements ActionListener
{ JMenuItem customerdetails;
  
public Home()
{ 
    setLayout(null);

        // Get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//this line helps to get the image width and height.//compilation error will show if i comment out this line

        // Load and scale the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Logining/icon/plane_intro.jpg"));//loads the image into i1
        Image i2 = i1.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);//takes the image from i1 and resizes to the screen width and height
        //image.scalesmooth gives better quality
        ImageIcon i3 = new ImageIcon(i2);//takes image from i2 and back to imageicon mae convert

        JLabel image = new JLabel(i3);//displays the image icon
        image.setBounds(0, 0, screenSize.width, screenSize.height);
        add(image);
        
        
        JLabel heading=new JLabel("AIR INDIGO WELCOMES YOU");
        heading.setBounds(320,15,1000,60);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Tahoma",Font.PLAIN,34));
        image.add(heading);
       
        
        JMenuBar menu=new JMenuBar();
        setJMenuBar(menu);
        
        JMenu details=new JMenu("details");
        menu.add(details);
        
        JMenu tickets=new JMenu("tickets");
        menu.add(tickets);
        
        JMenuItem boarding=new JMenuItem("boarding pass");
        tickets.add(boarding);
        boarding.addActionListener(this);
        
        
        
        JMenuItem flightdetails=new JMenuItem("Flight details");//
        details.add(flightdetails);
        flightdetails.addActionListener(this);
        
        
        customerdetails=new JMenuItem("Customer details");    //
        details.add(customerdetails);
        customerdetails.addActionListener(this);
      
      
        
        JMenuItem reservationdetails=new JMenuItem("reservation");
        details.add(reservationdetails);
        reservationdetails.addActionListener(this);
        
        JMenuItem journeydetails=new JMenuItem("journey");
        details.add(journeydetails);
        details.addActionListener(this);
        journeydetails.addActionListener(this);
        
        JMenuItem flightcancel=new JMenuItem("cancellation");
        details.add(flightcancel);
        flightcancel.addActionListener(this)
        ;
        

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ✅ Only closes the current window

        setVisible(true);
}

public void actionPerformed(ActionEvent ae) {
    String text=ae.getActionCommand();
        if(text.equals("Customer details"))//text should be equal what inside the bracket
        {
            new Customer();
        }
        else if(text.equals("Flight details"))
        { new Flightinfo();
    }
        else if(text.equals("reservation"))
        {
            new BookFlight();
        }
        else if(text.equals("journey"))
        {
             new JourneyDetails();
        }
        else if(text.equals("cancellation"))
        {
            new Cancellations();
        }
        else if((text.equals("boarding pass")))     {
            new Pass();
        }
}

public static void main(String args[])
{
    new Home();
}
}
