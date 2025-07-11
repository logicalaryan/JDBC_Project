package Logining;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Customer extends JFrame implements ActionListener {
    JTextField name, nations, phonefield, addressField, aadhars;
    JRadioButton radF, radM;
    JButton save;

    public Customer() {
        setTitle("Customer Form");

        JLabel customer = new JLabel("Customer Details");
        customer.setBounds(160, 10, 150, 30);
        customer.setBackground(Color.WHITE);
        customer.setOpaque(true);
        customer.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(customer);

        JLabel user = new JLabel("Name:");
        user.setBounds(20, 20, 100, 100);
        add(user);

        JLabel nation = new JLabel("Nationality:");
        nation.setBounds(20, 50, 100, 100);
        add(nation);

        JLabel address = new JLabel("Address:");
        address.setBounds(20, 110, 100, 100);
        add(address);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setBounds(20, 80, 100, 100);
        add(aadhar);

        JLabel phone = new JLabel("Phone Number:");
        phone.setBounds(20, 200, 100, 20);
        add(phone);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(20, 140, 120, 100);
        add(genderLabel);

        radM = new JRadioButton("Male");
        radM.setBounds(121, 180, 70, 20);
        radM.setBackground(Color.WHITE);
        add(radM);

        radF = new JRadioButton("Female");
        radF.setBounds(202, 180, 90, 20);
        radF.setBackground(Color.WHITE);
        add(radF);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radM);
        genderGroup.add(radF);

        save = new JButton("SAVE");
        save.setBounds(125, 245, 100, 20);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        add(save);

        name = new JTextField();
        name.setBounds(125, 60, 100, 20);
        add(name);

        nations = new JTextField();
        nations.setBounds(125, 90, 100, 20);
        add(nations);

        aadhars = new JTextField();
        aadhars.setBounds(125, 121, 100, 20);
        add(aadhars);

        addressField = new JTextField();
        addressField.setBounds(125, 150, 100, 20);
        add(addressField);

        phonefield = new JTextField();
        phonefield.setBounds(125, 205, 100, 20);
        add(phonefield);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Logining/icon/customer.jpg"));
        JLabel i2 = new JLabel(i1);
        i2.setBounds(360, 50, 400, 380);
        add(i2);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLocation(300, 150);
        setSize(800, 500);
        setVisible(true);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ✅ correct

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String names = name.getText();
        String nationality = nations.getText();
        String phone = phonefield.getText();
        String address = addressField.getText();
        String aadhar = aadhars.getText();
        String gender = null;

        if (radM.isSelected()) {
            gender = "Male";
        } else if (radF.isSelected()) {
            gender = "Female";
        } else {
            gender = "Unspecified";
        }

        try {
            String query = "INSERT INTO passenger VALUES('" + names + "', '" + nationality + "', '" + phone + "', '" + address + "', '" + aadhar + "', '" + gender + "')";
            DbConnection c = new DbConnection();
                       c.s.executeUpdate(query);
                       setVisible(false);
           
           JOptionPane.showMessageDialog(null, "Customer details saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving customer details.");
        }
    }

    public static void main(String args[]) {
        new Customer();
    }
}


//******************************************************************************
//jab automatically set krna text and textield ho toh use gridlayout
/*JPanel panel=new JPanel();
    panel.setLayout(new GridLayout(10, 2, 10, 10)); // 3 rows, 2 columns

panel.add(new JLabel("Name:"));
panel.add(new JTextField());

panel.add(new JLabel("Nationality:"));
panel.add(new JTextField());

panel.add(new JLabel("Aadhar Number:"));
panel.add(new JTextField());

add(panel);
setVisible(true);*/



