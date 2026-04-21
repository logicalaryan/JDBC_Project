
package Logining;
import javax.swing.*;// all classes with j
import java.awt.*;//color
import java.awt.event.*;//action listener
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.sql.*;//result set packagr
//import javax.swing.JOptionPane;
// jabel displays image and text
        
public class Home extends JFrame implements ActionListener
{ JMenuItem customerdetails;
  JLabel statusLabel;
  DateTimeFormatter statusTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy | hh:mm:ss a");
  
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
        
        JLabel subHeading = new JLabel("Choose an option to continue");
        subHeading.setBounds(470, 70, 400, 30);
        subHeading.setForeground(Color.WHITE);
        subHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
        image.add(subHeading);
        
        JPanel quickActionsPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        quickActionsPanel.setBounds(280, 140, 850, 220);
        quickActionsPanel.setOpaque(false);
        image.add(quickActionsPanel);
        
        quickActionsPanel.add(createQuickActionButton("Customer details"));
        quickActionsPanel.add(createQuickActionButton("Flight details"));
        quickActionsPanel.add(createQuickActionButton("reservation"));
        quickActionsPanel.add(createQuickActionButton("journey"));
        quickActionsPanel.add(createQuickActionButton("cancellation"));
        quickActionsPanel.add(createQuickActionButton("boarding pass"));
        
        statusLabel = new JLabel();
        statusLabel.setBounds(40, screenSize.height - 140, 420, 30);
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(statusLabel);
        updateStatusLabel();
        Timer statusTimer = new Timer(1000, e -> updateStatusLabel());
        statusTimer.start();
       
         
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

private JButton createQuickActionButton(String label) {
    JButton button = new JButton(label);
    button.setForeground(Color.WHITE);
    button.setBackground(new Color(0, 102, 204));
    button.setFocusPainted(false);
    button.setFont(new Font("Tahoma", Font.BOLD, 18));
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    button.addActionListener(this);
    button.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            button.setBackground(new Color(0, 153, 255));
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            button.setBackground(new Color(0, 102, 204));
        }
    });
    return button;
}

private void updateStatusLabel() {
    statusLabel.setText("Current time: " + LocalDateTime.now().format(statusTimeFormatter));
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
