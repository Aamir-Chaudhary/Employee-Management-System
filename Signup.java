package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Random;
import com.sun.net.ssl.internal.ssl.Provider;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.security.Security;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;



public class Signup extends JFrame implements ActionListener {

    private Container c;
    private JLabel title, name, mno, gender, dob, add, res, emailLabel;
    private JTextField tname, tmno, emailField, verificationCodeField;
    private JTextArea tadd, tout, resadd;
    private JPasswordField passwordField;
    private JRadioButton male, female;
    private ButtonGroup gengp;
    private JComboBox<String> date, month, year;
    private JCheckBox term;
    private JButton sub, reset, verifyEmail, submitVerification, back;
    private String randomcode;
    private JLabel imageLabel;
    private JButton chooseImageButton;
    private JLabel imageDisplayLabel;



    private String dates[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String years[] = {"1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"};

    public Signup() {
        setTitle("Registration Form");
        setBounds(300, 90, 850, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(80, 30);
        back.setLocation(0, 0);
        back.addActionListener(this);
        c.add(back);
       
       
chooseImageButton = new JButton("Choose Image");
chooseImageButton.setFont(new Font("Arial", Font.PLAIN, 15));
chooseImageButton.setSize(150, 20);
chooseImageButton.setLocation(600, 170);
chooseImageButton.addActionListener(this);
c.add(chooseImageButton);


imageDisplayLabel = new JLabel();
imageDisplayLabel.setFont(new Font("Arial", Font.PLAIN, 20));
imageDisplayLabel.setSize(150, 150);
imageDisplayLabel.setLocation(600, 20);
imageDisplayLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Optional: Add a border around the image display area
c.add(imageDisplayLabel);
  
        
imageLabel = new JLabel("Passport-size Image");
imageLabel.setFont(new Font("Arial", Font.PLAIN, 20));
imageLabel.setSize(200, 25);
imageLabel.setLocation(580, 200);
c.add(imageLabel);



        
        
        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setSize(100, 20);
        passwordLabel.setLocation(100, 400);
        c.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setSize(200, 25);
        passwordField.setLocation(200, 400);
        c.add(passwordField);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 25);
        tname.setLocation(200, 100);
        c.add(tname);


        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(190, 25);
        tmno.setLocation(200, 150);
        c.add(tmno);


        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 200);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("DOB");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 250);
        c.add(dob);

        date = new JComboBox<>(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 25);
        date.setLocation(200, 250);
        c.add(date);

        month = new JComboBox<>(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 25);
        month.setLocation(250, 250);
        c.add(month);

        year = new JComboBox<>(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(70, 25);
        year.setLocation(320, 250);
        c.add(year);



        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(200, 450);
        sub.addActionListener(this);
        c.add(sub);

        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 300);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 55);
        tadd.setLocation(200, 300);
        tadd.setLineWrap(true);
        c.add(tadd);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(200, 425);
        c.add(term);

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        emailLabel.setSize(100, 20);
        emailLabel.setLocation(100, 370);
        c.add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailField.setSize(200, 25);
        emailField.setLocation(200, 370);
        c.add(emailField);

        verifyEmail = new JButton("Verify");
        verifyEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        verifyEmail.setSize(100, 20);
        verifyEmail.setLocation(400, 370);
        verifyEmail.addActionListener(this);
        c.add(verifyEmail);

        verificationCodeField = new JTextField();
        verificationCodeField.setFont(new Font("Arial", Font.PLAIN, 15));
        verificationCodeField.setSize(200, 25);
        verificationCodeField.setLocation(550, 370);
        verificationCodeField.setVisible(false);
        c.add(verificationCodeField);

        submitVerification = new JButton("Submit Verification Code");
        submitVerification.setFont(new Font("Arial", Font.PLAIN, 15));
        submitVerification.setSize(200, 20);
        submitVerification.setLocation(550, 450);
        submitVerification.setVisible(false);
        submitVerification.addActionListener(this);
        c.add(submitVerification);


        JLabel verificationCodeLabel = new JLabel("Verification Code");
        verificationCodeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        verificationCodeLabel.setSize(150, 20);
        verificationCodeLabel.setLocation(400, 400);
        verificationCodeLabel.setVisible(false);
        c.add(verificationCodeLabel);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(300, 450);
        reset.addActionListener(this);
        c.add(reset);

       // tout = new JTextArea();
        //tout.setFont(new Font("Arial", Font.PLAIN, 15));
        //tout.setSize(300, 200);
       ///tout.setLocation(500, 100);
       // tout.setLineWrap(true);
        //tout.setEditable(false);
       // c.add(tout);

        res = new JLabel(" ");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        //resadd = new JTextArea();
       // resadd.setFont(new Font("Arial", Font.PLAIN, 15));
       // resadd.setSize(500, 75);
       // resadd.setLocation(580, 175);
      //  resadd.setLineWrap(true);
      //  c.add(resadd);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String data1;
                String data = "Name : " + tname.getText() + "\n" + "Mobile : " + tmno.getText() + "\n";
                if (male.isSelected()) data1 = "Gender : Male" + "\n";
                else data1 = "Gender : Female" + "\n";
                String data2 = "DOB : " + (String) date.getSelectedItem() + "/" + (String) month.getSelectedItem() + "/" + (String) year.getSelectedItem() + "\n";
                String data3 = "Address : " + tadd.getText();
                String email = emailField.getText();
                char[] password = passwordField.getPassword();
                if (isValidEmail(email) && password.length > 0) {
                    saveToDatabase();
                    //randomcode = generateVerificationCode();
                    //sendVerificationEmail(email, randomcode);
                    //showVerificationComponents();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid email address or password.");
                }
            } else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the terms & conditions..");
            }
        } else if (e.getSource() == reset) {
            resetForm();
        } else if (e.getSource() == verifyEmail) {
            String userEmail = emailField.getText();
            if (isValidEmail(userEmail)) {
                randomcode = generateVerificationCode();
                sendVerificationEmail(userEmail, randomcode);
                showVerificationComponents();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email address.");
            }
        } else if (e.getSource() == submitVerification) {
            String enteredCode = verificationCodeField.getText();
            var Username = tname.getText();
            if (enteredCode.equals(randomcode)) {
                
                //saveToDatabase();
                hideVerificationComponents();
                JOptionPane.showMessageDialog(this, "Hi "+Username+" Congrats Your Email is verified Successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect verification code. Please try again.");
            }
        } else if (e.getSource() == back) {
            this.setVisible(false);
            new AdminPage().setVisible(true);
        }
        
        //else if (e.getSource() == chooseImageButton) {
    //JFileChooser fileChooser = new JFileChooser();
    //FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg");
    //fileChooser.setFileFilter(filter);

   // int result = fileChooser.showOpenDialog(this);
   /// if (result == JFileChooser.APPROVE_OPTION) {
      //  String imagePath = fileChooser.getSelectedFile().getPath();
        // You can now save or process the imagePath as needed

        // Update the image label
      //  imageLabel.setText("Image selected: " + imagePath);
    //}
//}
        
     else if (e.getSource() == chooseImageButton) {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        String imagePath = fileChooser.getSelectedFile().getPath();
        imageLabel.setText("Image selected: " + imagePath);
        // Set the selected image to the image display label
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(imageDisplayLabel.getWidth(), imageDisplayLabel.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        imageDisplayLabel.setIcon(icon);
    }
}



    }

    private boolean isValidEmail(String email) {
        return email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
    }

    private String generateVerificationCode() {
        return String.valueOf((int) (Math.random() * 9000) + 1000);
    }

    private void sendVerificationEmail(String email, String verificationCode) {
        JOptionPane.showMessageDialog((Component)null, "Wait it may take few seconds....");
        try {
         Random rand = new Random();
            int randomcode = rand.nextInt(999999);
         String host = "smtp.gmail.com";
         String user = "codetosuccess786@gmail.com";
         //String pass = "Amir@78600";
         String pass = "oodr jbpw dhde vyfl";
         String to = this.emailField.getText();
         String subject = "Verification Code";
         String message = "Your Email Verification code is " + this.randomcode;
         boolean sessionDebug = false;
         Properties pros = System.getProperties();
         pros.put("mail.smtp.starttls.enable", "true");
         pros.put("mail.smtp.host", "smtp.gmail.com");
         pros.put("mail.smtp.port", "587");
         pros.put("mail.smtp.auth", "true");
         pros.put("mail.smtp.starttls.required", "true");
         Security.addProvider(new Provider());
         Session mailSession = Session.getDefaultInstance(pros, (Authenticator)null);
         mailSession.setDebug(sessionDebug);
         Message msg = new MimeMessage(mailSession);
         msg.setFrom(new InternetAddress(user));
         InternetAddress[] address = new InternetAddress[]{new InternetAddress(to)};
         msg.setRecipients(RecipientType.TO, address);
         msg.setSubject(subject);
         msg.setText(message);
         Transport transport = mailSession.getTransport("smtp");
         transport.connect(host, user, pass);
         transport.sendMessage(msg, msg.getAllRecipients());
         transport.close();
         JOptionPane.showMessageDialog((Component)null, "Code has been send to the email");
      } catch (MessagingException | HeadlessException var15) {
         JOptionPane.showMessageDialog(this.rootPane, var15);
      }

   }
        
        
        
       //String host = "smtp.gmail.com";
        //String port = "587";
        //String senderEmail = "codetosuccess786@gmail.com";
       // String senderPassword = "oodr jbpw dhde vyfl";
       //String recipient = email;

       // Properties properties = System.getProperties();
        //properties.put("mail.smtp.host", host);
        //properties.put("mail.smtp.port", port);
        //properties.put("mail.smtp.ssl.enable", "true");
       // properties.put("mail.smtp.auth", "true");
        
        // Set mail properties

//Properties properties = System.getProperties();
//properties.put("mail.smtp.starttls.enable", "true");
//properties.put("mail.smtp.socketFactory.fallback", "false");

//properties.put("mail.smtp.host", host);
///properties.put("mail.smtp.port", port);
//properties.put("mail.smtp.starttls.enable", "true");
//properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
//properties.put("mail.smtp.ssl.enable", "true");
//properties.put("mail.smtp.auth", "true");

        //Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        //    protected PasswordAuthentication getPasswordAuthentication() {
       //         return new PasswordAuthentication(senderEmail, senderPassword);
       //     }
      //  });

      //  try {
         //   MimeMessage message = new MimeMessage(session);
         //   message.setFrom(new InternetAddress(senderEmail));
         //   message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
         //   message.setSubject("Email Verification Code");
         //   message.setText("Your verification code is: " + verificationCode);
        //    Transport.send(message);
        //    System.out.println("Verification code sent to " + email);
       // } catch (MessagingException mex) {
        //    mex.printStackTrace();
        //}
   // }

    private void showVerificationComponents() {
        verifyEmail.setVisible(false);
        emailField.setEditable(false);

        verificationCodeField.setVisible(true);
        submitVerification.setVisible(true);
    }

    private void hideVerificationComponents() {
        verifyEmail.setVisible(true);
        emailField.setEditable(true);

        verificationCodeField.setVisible(false);
        submitVerification.setVisible(false);
    }

    private void resetForm() {
        String def = "";
        tname.setText(def);
        tadd.setText(def);
        tmno.setText(def);
        res.setText(def);
        tout.setText(def);
        term.setSelected(false);
        date.setSelectedIndex(0);
        month.setSelectedIndex(0);
        year.setSelectedIndex(0);
        resadd.setText(def);
        emailField.setText("");

        hideVerificationComponents();
    }

    private void saveToDatabase() {
        String url = "jdbc:mysql://localhost:3306/loginform";
        String username = "root";
        String dbPassword = "Aamir12345";

        try (Connection con = DriverManager.getConnection(url, username, dbPassword)) {
            java.util.Date utilDate = new SimpleDateFormat("d/MMM/yyyy").parse((String) date.getSelectedItem() + "/" + (String) month.getSelectedItem() + "/" + (String) year.getSelectedItem());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            if (isEmailExists(con, emailField.getText())) {
                JOptionPane.showMessageDialog(this, "Email address already exists. Please use a different email.");
                res.setText("Registration Failed..");
                return;
            }

            String insertQuery = "INSERT INTO registration_data (name, mobile, gender, dob, address, email, password, terms, image_path) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
                pst.setString(1, tname.getText());
                pst.setString(2, tmno.getText());
                pst.setString(3, male.isSelected() ? "Male" : "Female");
                pst.setDate(4, sqlDate);
                pst.setString(5, tadd.getText());
                pst.setString(6, emailField.getText());
                pst.setString(7, new String(passwordField.getPassword()));
                pst.setBoolean(8, term.isSelected());
                pst.setString(9, imageLabel.getText());

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully into registration_data.");
                    res.setText("Registration Successfully..");
                    JOptionPane.showMessageDialog((Component) null, "Registration Successful");
                    this.setVisible(false);
                    new AdminPage().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog((Component) null, "Registration Failed");
                    System.out.println("Failed to insert data into registration_data.");
                }
            }
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isEmailExists(Connection con, String email) throws SQLException {
        String checkEmailQuery = "SELECT COUNT(*) FROM registration_data WHERE email = ?";

        try (PreparedStatement pst = con.prepareStatement(checkEmailQuery)) {
            pst.setString(1, email);
            try (ResultSet rs = pst.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        }
    }

    public static void main(String[] args) {
        Signup f = new Signup();
    }
}
