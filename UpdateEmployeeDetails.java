package employee.management.system;

import java.awt.Color;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateEmployeeDetails extends JFrame {
   public String empid;
   public Connection con = null;
   public ResultSet rs = null;
   public PreparedStatement pst = null;
   private JButton btncancel;
   public JButton btnupdate;
   private JLabel jLabel1;
   private JLabel lblADDRESS;
   private JLabel lblAGE;
   private JLabel lblCITIZENSHIPNUMBER;
   private JLabel lblEMAILID;
   private JLabel lblEMPLOYEEID;
   private JLabel lblFATHERSNAME;
   private JLabel lblJOBPOST;
   private JLabel lblMOBILENUMBER;
   private JLabel lblNAME;
   private JLabel lblQUALIFICATION;
   private JLabel lblUPDATEEMPLOYEEDETAILS;
   private JLabel lblmessage;
   private JTextField txtaddress;
   private JTextField txtage;
   private JTextField txtcitizenshipnumber;
   private JTextField txtemailid;
   private JTextField txtemployeeid;
   private JTextField txtfathersname;
   private JTextField txtjobpost;
   private JTextField txtmobilenumber;
   private JTextField txtname;
   private JTextField txtqualification;
   private JLabel lblHireDate;
   private JTextField txtHireDate;

   public UpdateEmployeeDetails() {
      this.initComponents();
      this.setResizable(false);
   }

   public UpdateEmployeeDetails(String eEmployeeId) {
      this.initComponents();
      this.setResizable(false);
      this.empid = eEmployeeId;

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
         String str = "select * from employeedetails where eEmployeeId = '" + this.empid + "'";
         this.pst = this.con.prepareStatement(str);
         this.rs = this.pst.executeQuery(str);
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
            String hiredate = this.rs.getString("hireDate");
            this.txtname.setText(name);
            this.txtage.setText(age);
            this.txtaddress.setText(address);
            this.txtemailid.setText(emailid);
            this.txtjobpost.setText(jobpost);
            this.txtemployeeid.setText(employeeid);
            this.txtfathersname.setText(fathersname);
            this.txtmobilenumber.setText(mobilenumber);
            this.txtqualification.setText(qualification);
            this.txtcitizenshipnumber.setText(citizenshipnumber);
            this.lblHireDate.setText(hiredate);
         } else {
            this.lblmessage.setText("ID NOT FOUND..!!");
         }
      } catch (SQLException | ClassNotFoundException var13) {
         JOptionPane.showMessageDialog((Component)null, "Error: " + var13.toString(), "Error", 0);
      }

   }

   private void initComponents() {
      this.lblNAME = new JLabel();
      this.lblUPDATEEMPLOYEEDETAILS = new JLabel();
      this.lblAGE = new JLabel();
      this.lblADDRESS = new JLabel();
      this.lblJOBPOST = new JLabel();
      this.lblEMAILID = new JLabel();
      this.lblEMPLOYEEID = new JLabel();
      this.txtage = new JTextField();
      this.txtname = new JTextField();
      this.txtjobpost = new JTextField();
      this.txtaddress = new JTextField();
      this.lblFATHERSNAME = new JLabel();
      this.lblMOBILENUMBER = new JLabel();
      this.txtemailid = new JTextField();
      this.txtemployeeid = new JTextField();
      this.lblCITIZENSHIPNUMBER = new JLabel();
      this.txtfathersname = new JTextField();
      this.txtmobilenumber = new JTextField();
      this.lblQUALIFICATION = new JLabel();
      this.txtqualification = new JTextField();
      this.btnupdate = new JButton();
      this.lblHireDate = new JLabel();
      this.txtHireDate = new JTextField();
      this.lblHireDate.setFont(new Font("Times New Roman", Font.BOLD, 18));
      this.lblHireDate.setText("Hire Date");
      this.getContentPane().add(this.lblHireDate);
      this.lblHireDate.setBounds(400, 360, 140, 30);

      this.txtHireDate.setFont(new Font("Times New Roman", 0, 14));
      this.getContentPane().add(this.txtHireDate);
      this.txtHireDate.setBounds(560, 360, 230, 30);
      this.txtcitizenshipnumber = new JTextField();
      this.btncancel = new JButton();
      this.lblmessage = new JLabel();
      this.jLabel1 = new JLabel();
      this.setDefaultCloseOperation(3);
      this.setTitle("Update Employee Details");
      this.getContentPane().setLayout((LayoutManager)null);
      this.lblNAME.setFont(new Font("Times New Roman", 1, 18));
      this.lblNAME.setText("Name");
      this.getContentPane().add(this.lblNAME);
      this.lblNAME.setBounds(20, 110, 60, 21);
      this.lblUPDATEEMPLOYEEDETAILS.setFont(new Font("Times New Roman", 1, 24));
      this.lblUPDATEEMPLOYEEDETAILS.setText("Update Employee Details");
      this.getContentPane().add(this.lblUPDATEEMPLOYEEDETAILS);
      this.lblUPDATEEMPLOYEEDETAILS.setBounds(270, 10, 300, 60);
      this.lblAGE.setFont(new Font("Times New Roman", 1, 18));
      this.lblAGE.setText("Age");
      this.getContentPane().add(this.lblAGE);
      this.lblAGE.setBounds(20, 160, 40, 30);
      this.lblADDRESS.setFont(new Font("Times New Roman", 1, 18));
      this.lblADDRESS.setText("Address");
      this.getContentPane().add(this.lblADDRESS);
      this.lblADDRESS.setBounds(20, 220, 80, 21);
      this.lblJOBPOST.setFont(new Font("Times New Roman", 1, 18));
      this.lblJOBPOST.setText("Job Post");
      this.getContentPane().add(this.lblJOBPOST);
      this.lblJOBPOST.setBounds(20, 330, 80, 30);
      this.lblEMAILID.setFont(new Font("Times New Roman", 1, 18));
      this.lblEMAILID.setText("Email Id");
      this.getContentPane().add(this.lblEMAILID);
      this.lblEMAILID.setBounds(20, 270, 80, 30);
      this.lblEMPLOYEEID.setFont(new Font("Times New Roman", 1, 18));
      this.lblEMPLOYEEID.setText("Employee Id");
      this.getContentPane().add(this.lblEMPLOYEEID);
      this.lblEMPLOYEEID.setBounds(20, 390, 130, 30);
      this.txtage.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.txtage);
      this.txtage.setBounds(150, 160, 210, 30);
      this.txtname.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.txtname);
      this.txtname.setBounds(150, 103, 210, 30);
      this.txtjobpost.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.txtjobpost);
      this.txtjobpost.setBounds(150, 330, 210, 30);
      this.txtaddress.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.txtaddress);
      this.txtaddress.setBounds(150, 210, 210, 30);
      this.lblFATHERSNAME.setFont(new Font("Times New Roman", 1, 18));
      this.lblFATHERSNAME.setText("Fathers Name");
      this.getContentPane().add(this.lblFATHERSNAME);
      this.lblFATHERSNAME.setBounds(400, 110, 120, 30);
      this.lblMOBILENUMBER.setFont(new Font("Times New Roman", 1, 18));
      this.lblMOBILENUMBER.setText("Mobile Number");
      this.getContentPane().add(this.lblMOBILENUMBER);
      this.lblMOBILENUMBER.setBounds(400, 161, 140, 30);
      this.txtemailid.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.txtemailid);
      this.txtemailid.setBounds(150, 270, 210, 30);
      this.txtemployeeid.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.txtemployeeid);
      this.txtemployeeid.setBounds(150, 387, 210, 30);
      this.lblCITIZENSHIPNUMBER.setFont(new Font("Times New Roman", 1, 18));
      this.lblCITIZENSHIPNUMBER.setText("Citizenship Number");
      this.getContentPane().add(this.lblCITIZENSHIPNUMBER);
      this.lblCITIZENSHIPNUMBER.setBounds(400, 270, 170, 30);
      this.txtfathersname.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.txtfathersname);
      this.txtfathersname.setBounds(580, 100, 220, 30);
      this.txtmobilenumber.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.txtmobilenumber);
      this.txtmobilenumber.setBounds(580, 157, 220, 30);
      this.lblQUALIFICATION.setFont(new Font("Times New Roman", 1, 18));
      this.lblQUALIFICATION.setText("Qualification");
      this.getContentPane().add(this.lblQUALIFICATION);
      this.lblQUALIFICATION.setBounds(400, 210, 120, 30);
      this.txtqualification.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.txtqualification);
      this.txtqualification.setBounds(580, 207, 220, 30);
      this.btnupdate.setFont(new Font("Times New Roman", 1, 18));
      this.btnupdate.setText("Update");
      this.btnupdate.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            UpdateEmployeeDetails.this.btnupdateMouseMoved(evt);
         }
      });
      this.btnupdate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            UpdateEmployeeDetails.this.btnupdateActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.btnupdate);
      this.btnupdate.setBounds(320, 490, 110, 40);
      this.txtcitizenshipnumber.setFont(new Font("Times New Roman", 0, 18));
      this.getContentPane().add(this.txtcitizenshipnumber);
      this.txtcitizenshipnumber.setBounds(580, 267, 220, 30);
      this.btncancel.setFont(new Font("Times New Roman", 1, 18));
      this.btncancel.setText("Cancel");
      this.btncancel.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            UpdateEmployeeDetails.this.btncancelMouseMoved(evt);
         }
      });
      this.btncancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            UpdateEmployeeDetails.this.btncancelActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.btncancel);
      this.btncancel.setBounds(470, 490, 100, 40);
      this.lblmessage.setFont(new Font("Times New Roman", 3, 36));
      this.lblmessage.setForeground(new Color(255, 0, 0));
      this.lblmessage.setHorizontalAlignment(0);
      this.getContentPane().add(this.lblmessage);
      this.lblmessage.setBounds(420, 370, 390, 90);
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/employee/management/system/project icons/pexels-photo.jpg")));
      this.getContentPane().add(this.jLabel1);
      this.jLabel1.setBounds(0, 0, 814, 538);
      this.setSize(new Dimension(828, 575));
      this.setLocationRelativeTo((Component)null);
   }

   private void btncancelActionPerformed(ActionEvent evt) {
      this.dispose();
   }

   private void btncancelMouseMoved(MouseEvent evt) {
      this.btncancel.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void btnupdateMouseMoved(MouseEvent evt) {
      this.btnupdate.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void btnupdateActionPerformed(ActionEvent evt) {
     int p = JOptionPane.showConfirmDialog((Component)null, "Do you really want to Update this data..!!", "Update", 0);
      if (p == 0) {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
            String str = "update employeedetails set eName='" + this.txtname.getText() + "',eAge='" + this.txtage.getText() + "',eAddress='" + this.txtaddress.getText() + "',eEmailId='" + this.txtemailid.getText() + "',eJobPost='" + this.txtjobpost.getText() + "',eEmployeeId='" + this.txtemployeeid.getText() + "',eFathersName='" + this.txtfathersname.getText() + "',eMobileNumber='" + this.txtmobilenumber.getText() + "',eQualification='" + this.txtqualification.getText() + "',eCitizenshipNumber='" + this.txtcitizenshipnumber.getText() + "',hireDate='" + this.txtHireDate.getText() + "' where eEmployeeId='" + this.empid + "'";
            this.pst = this.con.prepareStatement(str);
            this.pst.executeUpdate();
            this.lblmessage.setText("Updated successfully..!!");
         } catch (SQLException | ClassNotFoundException var4) {
            JOptionPane.showMessageDialog((Component)null, "Error: " + var4.toString(), "Error", 0);
         }
      }
   }  
}
