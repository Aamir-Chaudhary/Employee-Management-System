package employee.management.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Reset extends JFrame {
   public Connection con = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
   public String user;
   private JButton btnReset;
   private JButton btncancel;
   private JPanel jPanel1;
   private JLabel lblConfirmPassword;
   private JLabel lblNewPassword;
   private JTextField txtConfirmpass;
   private JTextField txtNewpass;

   public Reset() {
      this.initComponents();
      this.setResizable(false);
   }

   public Reset(String username) {
      this.user = username;
      this.initComponents();
   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.lblNewPassword = new JLabel();
      this.lblConfirmPassword = new JLabel();
      this.txtNewpass = new JTextField();
      this.txtConfirmpass = new JTextField();
      this.btnReset = new JButton();
      this.btncancel = new JButton();
      this.setDefaultCloseOperation(3);
      this.setTitle("Reset");
      this.jPanel1.setBackground(new Color(255, 204, 255));
      this.lblNewPassword.setFont(new Font("Times New Roman", 0, 24));
      this.lblNewPassword.setText("New Password");
      this.lblConfirmPassword.setFont(new Font("Times New Roman", 0, 24));
      this.lblConfirmPassword.setText("Confirm Password");
      this.txtNewpass.setFont(new Font("Times New Roman", 0, 18));
      this.txtNewpass.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Reset.this.txtNewpassActionPerformed(evt);
         }
      });
      this.txtConfirmpass.setFont(new Font("Times New Roman", 0, 18));
      this.txtConfirmpass.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Reset.this.txtConfirmpassActionPerformed(evt);
         }
      });
      this.btnReset.setBackground(new Color(255, 204, 255));
      this.btnReset.setFont(new Font("Times New Roman", 0, 18));
      this.btnReset.setText("Reset");
      this.btnReset.setBorderPainted(false);
      this.btnReset.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            Reset.this.btnResetMouseMoved(evt);
         }
      });
      this.btnReset.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Reset.this.btnResetActionPerformed(evt);
         }
      });
      this.btncancel.setBackground(new Color(255, 204, 255));
      this.btncancel.setFont(new Font("Times New Roman", 0, 18));
      this.btncancel.setText("Cancel");
      this.btncancel.setBorderPainted(false);
      this.btncancel.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            Reset.this.btncancelMouseMoved(evt);
         }
      });
      this.btncancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Reset.this.btncancelActionPerformed(evt);
         }
      });
      GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
      this.jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.lblConfirmPassword).addComponent(this.lblNewPassword, -2, 177, -2)).addGap(37, 37, 37).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.txtNewpass).addComponent(this.txtConfirmpass, -1, 237, 32767)).addContainerGap(-1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.btnReset).addPreferredGap(ComponentPlacement.RELATED, 89, 32767).addComponent(this.btncancel).addContainerGap(41, 32767)))));
      jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(39, 39, 39).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.lblNewPassword, -2, 37, -2).addComponent(this.txtNewpass, -2, 37, -2)).addGap(69, 69, 69).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.lblConfirmPassword, -2, 30, -2).addComponent(this.txtConfirmpass, -2, 41, -2)).addGap(55, 55, 55).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.btnReset).addComponent(this.btncancel, -1, -1, 32767)).addContainerGap(133, 32767)));
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      this.pack();
   }

   private void btnResetActionPerformed(ActionEvent evt) {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
      } catch (SQLException | ClassNotFoundException var4) {
         JOptionPane.showMessageDialog((Component)null, "Error: " + var4.toString(), "Error", 0);
      }

      if (this.txtNewpass.getText().equals(this.txtConfirmpass.getText())) {
         try {
            String updateQuery = "UPDATE loginform.login SET `password` =? WHERE username ='" + this.user + "'";
            this.pst = this.con.prepareStatement(updateQuery);
            this.pst.setString(1, this.txtConfirmpass.getText());
            this.pst.executeUpdate();
            JOptionPane.showMessageDialog((Component)null, "Reset successfully");
            this.setVisible(false);
            (new loginform()).setVisible(true);
         } catch (SQLException | HeadlessException var3) {
            JOptionPane.showMessageDialog((Component)null, var3);
         }
      } else {
         JOptionPane.showMessageDialog((Component)null, "password do not match");
      }

   }

   private void txtConfirmpassActionPerformed(ActionEvent evt) {
   }

   private void txtNewpassActionPerformed(ActionEvent evt) {
   }

   private void btncancelActionPerformed(ActionEvent evt) {
      this.dispose();
      (new loginform()).setVisible(true);
   }

   private void btnResetMouseMoved(MouseEvent evt) {
      this.btnReset.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void btncancelMouseMoved(MouseEvent evt) {
      this.btncancel.setCursor(Cursor.getPredefinedCursor(12));
   }
}
