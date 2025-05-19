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
    private JButton btnBack;
    private JLabel jLabel3;
    private JLayeredPane jLayeredPane1;
    private JPanel jPanel1;
    private JLabel lblCode;
    private JLabel lblEmail;
    private JTextField txtCode;
    private JTextField txtEmail;

    public Sendcode() {
        initComponents();
        setResizable(false);
    }

    private void initComponents() {
        jLayeredPane1 = new JLayeredPane();
        jPanel1 = new JPanel();
        lblEmail = new JLabel();
        txtEmail = new JTextField();
        btnSend = new JButton();
        lblCode = new JLabel();
        txtCode = new JTextField();
        btnVerify = new JButton();
        btnBack = new JButton();
        jLabel3 = new JLabel();

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sendcode");
        jPanel1.setBackground(new Color(255, 204, 255));

        lblEmail.setFont(new Font("Times New Roman", 0, 24));
        lblEmail.setText("Enter Email");

        txtEmail.setFont(new Font("Times New Roman", 0, 18));
        txtEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnSend.setBackground(new Color(255, 153, 255));
        btnSend.setFont(new Font("Times New Roman", 0, 18));
        btnSend.setText("Send Code");
        btnSend.setBorderPainted(false);
        btnSend.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                btnSend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        lblCode.setFont(new Font("Times New Roman", 0, 24));
        lblCode.setText("Enter Code");

        txtCode.setFont(new Font("Times New Roman", 0, 18));

        btnVerify.setBackground(new Color(255, 153, 255));
        btnVerify.setFont(new Font("Times New Roman", 0, 18));
        btnVerify.setText("Verify");
        btnVerify.setBorderPainted(false);
        btnVerify.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                btnVerify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
        btnVerify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });

        btnBack.setBackground(new Color(255, 153, 255)); // <- Updated color
        btnBack.setFont(new Font("Times New Roman", 0, 18));
        btnBack.setText("Back");
        btnBack.setBorderPainted(false);
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(40)
                    .addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
                        .addComponent(lblEmail)
                        .addComponent(lblCode))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCode, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(btnVerify, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(30)
                    .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGap(30)
                    .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCode, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGap(30)
                    .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVerify, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(30, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

        pack();
        setLocationRelativeTo(null);
    }

    private void txtEmailActionPerformed(ActionEvent evt) {}

    private void btnSendActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Wait, it may take a few seconds...");

        try {
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            String host = "smtp.gmail.com";
            String user = "codetosuccess786@gmail.com";
            String pass = "fveo sqos tcxm mbdr";
            String to = txtEmail.getText();
            String subject = "Resetting Code";
            String message = "Your reset code is " + randomCode;

            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.host", host);
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.auth", "true");
            pros.put("mail.smtp.starttls.required", "true");

            Security.addProvider(new Provider());
            Session mailSession = Session.getDefaultInstance(pros, null);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            InternetAddress[] address = { new InternetAddress(to) };
            msg.setRecipients(RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setText(message);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();

            JOptionPane.showMessageDialog(null, "Code has been sent to the email");
        } catch (MessagingException | HeadlessException e) {
            JOptionPane.showMessageDialog(this.rootPane, e);
        }
    }

    private void btnVerifyActionPerformed(ActionEvent evt) {
        try {
            if (Integer.valueOf(txtCode.getText()) == randomCode) {
                Reset rs = new Reset(txtEmail.getText());
                rs.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Code does not match");
            }
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(this.rootPane, e);
        }
    }

    private void btnBackActionPerformed(ActionEvent evt) {
        new loginform().setVisible(true);
        this.dispose();
    }
}
