package employee.management.system;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RemoveEmployee extends JFrame {
   public Connection con = null;
   public ResultSet rs = null;
   public PreparedStatement pst = null;
   public String empid;
   private JButton btncancel;
   private JButton btncancel2;
   private JButton btnremove;
   private JButton btnsearch;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel lblNAME;
   private JLabel lblemailid;
   private JLabel lblempemailid;
   private JLabel lblempname;
   private JLabel lblemppost;
   private JLabel lblpost;
   private JTextField txtemployeeid;

   public RemoveEmployee() {
      this.initComponents();
      this.setResizable(false);
      this.btncancel2.setVisible(false);
      this.btnremove.setVisible(false);
      this.lblNAME.setVisible(false);
      this.lblemailid.setVisible(false);
      this.lblpost.setVisible(false);
   }

   private void initComponents() {
      this.jLabel2 = new JLabel();
      this.txtemployeeid = new JTextField();
      this.btnsearch = new JButton();
      this.lblNAME = new JLabel();
      this.lblemailid = new JLabel();
      this.lblempname = new JLabel();
      this.lblempemailid = new JLabel();
      this.lblemppost = new JLabel();
      this.btnremove = new JButton();
      this.btncancel2 = new JButton();
      this.lblpost = new JLabel();
      this.btncancel = new JButton();
      this.jLabel1 = new JLabel();
      this.setDefaultCloseOperation(3);
      this.getContentPane().setLayout((LayoutManager)null);
      this.jLabel2.setFont(new Font("Times New Roman", 1, 24));
      this.jLabel2.setText("Employee Id");
      this.getContentPane().add(this.jLabel2);
      this.jLabel2.setBounds(10, 90, 160, 30);
      this.txtemployeeid.setFont(new Font("Times New Roman", 1, 18));
      this.getContentPane().add(this.txtemployeeid);
      this.txtemployeeid.setBounds(180, 89, 220, 30);
      this.btnsearch.setFont(new Font("Times New Roman", 1, 18));
      this.btnsearch.setText("Search");
      this.btnsearch.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            RemoveEmployee.this.btnsearchMouseMoved(evt);
         }
      });
      this.btnsearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            RemoveEmployee.this.btnsearchActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.btnsearch);
      this.btnsearch.setBounds(180, 180, 90, 29);
      this.lblNAME.setFont(new Font("Times New Roman", 0, 18));
      this.lblNAME.setText("Name");
      this.getContentPane().add(this.lblNAME);
      this.lblNAME.setBounds(10, 270, 60, 30);
      this.lblemailid.setFont(new Font("Times New Roman", 0, 18));
      this.lblemailid.setText("Email Id");
      this.getContentPane().add(this.lblemailid);
      this.lblemailid.setBounds(10, 320, 70, 30);
      this.lblempname.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.lblempname);
      this.lblempname.setBounds(141, 273, 250, 30);
      this.lblempemailid.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.lblempemailid);
      this.lblempemailid.setBounds(140, 320, 290, 30);
      this.lblemppost.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.lblemppost);
      this.lblemppost.setBounds(140, 370, 180, 30);
      this.btnremove.setFont(new Font("Times New Roman", 1, 18));
      this.btnremove.setText("Remove");
      this.btnremove.setActionCommand("");
      this.btnremove.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            RemoveEmployee.this.btnremoveMouseMoved(evt);
         }
      });
      this.btnremove.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            RemoveEmployee.this.btnremoveActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.btnremove);
      this.btnremove.setBounds(180, 420, 100, 29);
      this.btncancel2.setFont(new Font("Times New Roman", 1, 18));
      this.btncancel2.setText("Cancel");
      this.btncancel2.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            RemoveEmployee.this.btncancel2MouseMoved(evt);
         }
      });
      this.btncancel2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            RemoveEmployee.this.btncancel2ActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.btncancel2);
      this.btncancel2.setBounds(310, 420, 100, 29);
      this.lblpost.setFont(new Font("Times New Roman", 0, 18));
      this.lblpost.setText("Post");
      this.getContentPane().add(this.lblpost);
      this.lblpost.setBounds(10, 370, 50, 30);
      this.btncancel.setFont(new Font("Times New Roman", 1, 18));
      this.btncancel.setText("Cancel");
      this.btncancel.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            RemoveEmployee.this.btncancelMouseMoved(evt);
         }
      });
      this.btncancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            RemoveEmployee.this.btncancelActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.btncancel);
      this.btncancel.setBounds(310, 180, 90, 29);
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/employee/management/system/project icons/pexels-photo.jpg")));
      this.getContentPane().add(this.jLabel1);
      this.jLabel1.setBounds(0, 0, 500, 460);
      this.setSize(new Dimension(518, 499));
      this.setLocationRelativeTo((Component)null);
   }

   private void btnsearchActionPerformed(ActionEvent evt) {
      this.btncancel2.setVisible(true);
      this.btnremove.setVisible(true);
      this.lblNAME.setVisible(true);
      this.lblemailid.setVisible(true);
      this.lblpost.setVisible(true);

      try {
         if (this.txtemployeeid.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Employee Id");
            this.txtemployeeid.grabFocus();
         }

         if (!Pattern.matches("^[0-9]+$", this.txtemployeeid.getText())) {
            JOptionPane.showMessageDialog(this, "Invalid Input , Accepts Number only", "Invalid Search Format", 1);
            this.txtemployeeid.setText((String)null);
            this.txtemployeeid.grabFocus();
            return;
         }

         Long empid = Long.parseLong(this.txtemployeeid.getText());
         Class.forName("com.mysql.cj.jdbc.Driver");
         this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
         String str = "select * from employeedetails where eEmployeeId = '" + empid + "'";
         this.pst = this.con.prepareStatement(str);
         this.rs = this.pst.executeQuery();
         if (this.rs.next()) {
            String name = this.rs.getString("eName");
            String age = this.rs.getString("eAge");
            String address = this.rs.getString("eAddress");
            String emailid = this.rs.getString("eEmailId");
            String jobpost = this.rs.getString("eJobPost");
            String employeeid = this.rs.getString("eEmployeeId");
            String fathersname = this.rs.getString("eFathersName");
            String mobilenumber = this.rs.getString("eMobileNumber");
            String qualification = this.rs.getString("eQualification");
            String citizenshipnumber = this.rs.getString("eCitizenshipNumber");
            this.lblempname.setText(name);
            this.lblempemailid.setText(emailid);
            this.lblemppost.setText(jobpost);
         } else {
            JOptionPane.showMessageDialog((Component)null, "Id not found..!!");
            this.txtemployeeid.setText((String)null);
            this.lblempname.setText((String)null);
            this.lblemppost.setText((String)null);
            this.lblempemailid.setText((String)null);
            this.txtemployeeid.requestFocus();
         }
      } catch (SQLException | ClassNotFoundException var14) {
         JOptionPane.showMessageDialog((Component)null, "Error: " + var14.toString(), "Error", 0);
      }

   }

   private void btnremoveActionPerformed(ActionEvent evt) {
      int p = JOptionPane.showConfirmDialog((Component)null, "Do you really want to delete this data..!!", "Delete", 0);
      if (p == 0) {
         try {
            Long empid = Long.parseLong(this.txtemployeeid.getText());
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
            String str = "delete from employeedetails where eEmployeeId = '" + empid + "'";
            this.pst = this.con.prepareStatement(str);
            this.pst.executeUpdate();
            JOptionPane.showMessageDialog((Component)null, "Deleted successfully");
         } catch (SQLException | ClassNotFoundException var5) {
            JOptionPane.showMessageDialog((Component)null, "Error: " + var5.toString(), "Error", 0);
         }

         this.txtemployeeid.setText((String)null);
         this.lblempname.setText((String)null);
         this.lblemppost.setText((String)null);
         this.lblempemailid.setText((String)null);
         this.txtemployeeid.requestFocus();
      }

   }

   private void btncancelActionPerformed(ActionEvent evt) {
      this.dispose();
   }

   private void btncancel2ActionPerformed(ActionEvent evt) {
      this.dispose();
   }

   private void btnsearchMouseMoved(MouseEvent evt) {
      this.btnsearch.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void btncancelMouseMoved(MouseEvent evt) {
      this.btncancel.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void btnremoveMouseMoved(MouseEvent evt) {
      this.btnremove.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void btncancel2MouseMoved(MouseEvent evt) {
      this.btncancel2.setCursor(Cursor.getPredefinedCursor(12));
   }
}
