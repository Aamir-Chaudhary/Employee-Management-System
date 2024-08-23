package employee.management.system;

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

public class Sendcode extends JFrame {
   int randomCode;
   private JButton btnSend;
   private JButton btnVerify;
   private JLabel jLabel3;
   private JLayeredPane jLayeredPane1;
   private JPanel jPanel1;
   private JLabel lblCode;
   private JLabel lblEmail;
   private JTextField txtCode;
   private JTextField txtEmail;

   public Sendcode() {
      this.initComponents();
      this.setResizable(false);
   }

   private void initComponents() {
      this.jLayeredPane1 = new JLayeredPane();
      this.jPanel1 = new JPanel();
      this.lblEmail = new JLabel();
      this.txtEmail = new JTextField();
      this.btnSend = new JButton();
      this.lblCode = new JLabel();
      this.txtCode = new JTextField();
      this.btnVerify = new JButton();
      this.jLabel3 = new JLabel();
      GroupLayout jLayeredPane1Layout = new GroupLayout(this.jLayeredPane1);
      this.jLayeredPane1.setLayout(jLayeredPane1Layout);
      jLayeredPane1Layout.setHorizontalGroup(jLayeredPane1Layout.createParallelGroup(Alignment.LEADING).addGap(0, 100, 32767));
      jLayeredPane1Layout.setVerticalGroup(jLayeredPane1Layout.createParallelGroup(Alignment.LEADING).addGap(0, 100, 32767));
      this.setDefaultCloseOperation(3);
      this.setTitle("Sendcode");
      this.jPanel1.setBackground(new Color(255, 204, 255));
      this.lblEmail.setFont(new Font("Times New Roman", 0, 24));
      this.lblEmail.setText("Enter Email");
      this.txtEmail.setFont(new Font("Times New Roman", 0, 18));
      this.txtEmail.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Sendcode.this.txtEmailActionPerformed(evt);
         }
      });
      this.btnSend.setBackground(new Color(255, 153, 255));
      this.btnSend.setFont(new Font("Times New Roman", 0, 18));
      this.btnSend.setText("Send Code");
      this.btnSend.setBorderPainted(false);
      this.btnSend.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            Sendcode.this.btnSendMouseMoved(evt);
         }
      });
      this.btnSend.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Sendcode.this.btnSendActionPerformed(evt);
         }
      });
      this.lblCode.setFont(new Font("Times New Roman", 0, 24));
      this.lblCode.setText("Enter Code");
      this.txtCode.setFont(new Font("Times New Roman", 0, 18));
      this.btnVerify.setBackground(new Color(255, 153, 255));
      this.btnVerify.setFont(new Font("Times New Roman", 0, 18));
      this.btnVerify.setText("Verify");
      this.btnVerify.setBorderPainted(false);
      this.btnVerify.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            Sendcode.this.btnVerifyMouseMoved(evt);
         }
      });
      this.btnVerify.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Sendcode.this.btnVerifyActionPerformed(evt);
         }
      });
      GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
      this.jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.lblCode, -2, 128, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 203, 32767).addComponent(this.btnSend, -2, 96, -2)).addComponent(this.txtCode))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.lblEmail, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.txtEmail, -2, 300, -2)))).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3, -2, 206, -2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnVerify, -2, 97, -2))).addGap(63, 63, 63)));
      jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(27, 27, 27).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.lblEmail, -2, 32, -2).addComponent(this.txtEmail, -2, 32, -2)).addGap(28, 28, 28).addComponent(this.btnSend, -2, 30, -2).addGap(32, 32, 32).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.lblCode, -2, 41, -2).addComponent(this.txtCode, -2, 33, -2)).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.btnVerify).addContainerGap(118, 32767)).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel3, -1, -1, 32767)))));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 4, 32767)));
      this.pack();
      this.setLocationRelativeTo((Component)null);
   }

   private void txtEmailActionPerformed(ActionEvent evt) {
   }

   private void btnSendActionPerformed(ActionEvent evt) {
      JOptionPane.showMessageDialog((Component)null, "Wait it may take few seconds....");

      try {
         Random rand = new Random();
         this.randomCode = rand.nextInt(999999);
         String host = "smtp.gmail.com";
         String user = "codetosuccess786@gmail.com";
         //String pass = "Amir@78600";
         String pass = "fveo sqos tcxm mbdr";
         String to = this.txtEmail.getText();
         String subject = "Reseting Code";
         String message = "Your reset code is " + this.randomCode;
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

   private void btnVerifyActionPerformed(ActionEvent evt) {
      try {
         if (Integer.valueOf(this.txtCode.getText()) == this.randomCode) {
            Reset rs = new Reset(this.txtEmail.getText());
            rs.setVisible(true);
            this.setVisible(false);
         } else {
            JOptionPane.showMessageDialog((Component)null, "Code do not match");
         }
      } catch (NumberFormatException | HeadlessException var3) {
         JOptionPane.showMessageDialog(this.rootPane, var3);
      }

   }

   private void btnSendMouseMoved(MouseEvent evt) {
      this.btnSend.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void btnVerifyMouseMoved(MouseEvent evt) {
      this.btnVerify.setCursor(Cursor.getPredefinedCursor(12));
   }
}
