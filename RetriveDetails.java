package employee.management.system;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class RetriveDetails extends JFrame {

    public String empid;
    public Connection con = null;
    public ResultSet rs = null;
    public PreparedStatement pst = null;
    private JButton btnok;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel lblADDRESS;
    private JLabel lblAGE;
    private JLabel lblCITIZENSHIPNUMBER;
    private JLabel lblEMAILID;
    private JLabel lblEMPLOYEEID;
    private JLabel lblFATHERSNAME;
    private JLabel lblJOBPOST;
    private JLabel lblMOBILENUMBER;
    private JLabel lblempaddress;
    private JLabel lblempage;
    private JLabel lblempcitizenshipnumber;
    private JLabel lblempemailid;
    private JLabel lblempfathersname;
    private JLabel lblempid;
    private JLabel lblempjobpost;
    private JLabel lblempmobilenumber;
    private JLabel lblempname;
    private JLabel lblempqualification;
    private JLabel llblQUALIFICATION;

    public RetriveDetails() {
        this.initComponents();
        this.setResizable(false);
    }

    public RetriveDetails(String eEmployeeId) {
        this.empid = eEmployeeId;
        this.initComponents();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
            String str = "select * from employeedetails where eEmployeeId = '" + this.empid + "'";
            this.pst = this.con.prepareStatement(str);
            this.rs = this.pst.executeQuery();

            while (this.rs.next()) {
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
                this.lblempage.setText(age);
                this.lblempaddress.setText(address);
                this.lblempemailid.setText(emailid);
                this.lblempfathersname.setText(fathersname);
                this.lblempmobilenumber.setText(mobilenumber);
                this.lblempqualification.setText(qualification);
                this.lblempcitizenshipnumber.setText(citizenshipnumber);
                this.lblempjobpost.setText(jobpost);
                this.lblempid.setText(employeeid);
            }
        } catch (SQLException | ClassNotFoundException var13) {
            JOptionPane.showMessageDialog((Component) null, "Error: " + var13.toString(), "Error", 0);
        }

    }

    private void initComponents() {
        this.jLabel2 = new JLabel();
        this.jLabel11 = new JLabel();
        this.lblCITIZENSHIPNUMBER = new JLabel();
        this.lblADDRESS = new JLabel();
        this.lblAGE = new JLabel();
        this.lblempage = new JLabel();
        this.lblempid = new JLabel();
        this.lblempname = new JLabel();
        this.lblFATHERSNAME = new JLabel();
        this.lblMOBILENUMBER = new JLabel();
        this.lblEMAILID = new JLabel();
        this.lblempqualification = new JLabel();
        this.lblempfathersname = new JLabel();
        this.lblempjobpost = new JLabel();
        this.lblempaddress = new JLabel();
        this.btnok = new JButton();
        this.lblempmobilenumber = new JLabel();
        this.lblempcitizenshipnumber = new JLabel();
        this.lblempemailid = new JLabel();
        this.lblJOBPOST = new JLabel();
        this.jLabel4 = new JLabel();
        this.lblEMPLOYEEID = new JLabel();
        this.llblQUALIFICATION = new JLabel();
        this.setDefaultCloseOperation(3);
        this.getContentPane().setLayout((LayoutManager) null);
        this.jLabel2.setFont(new Font("Times New Roman", 2, 24));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("Employee Detail");
        this.getContentPane().add(this.jLabel2);
        this.jLabel2.setBounds(150, 0, 220, 40);
        this.jLabel11.setFont(new Font("Times New Roman", 1, 18));
        this.jLabel11.setHorizontalAlignment(0);
        this.jLabel11.setText("Qualification");
        this.getContentPane().add(this.jLabel11);
        this.jLabel11.setBounds(50, 400, 130, 30);
        this.lblCITIZENSHIPNUMBER.setFont(new Font("Times New Roman", 1, 18));
        this.lblCITIZENSHIPNUMBER.setHorizontalAlignment(0);
        this.lblCITIZENSHIPNUMBER.setText("Citizenship Number");
        this.getContentPane().add(this.lblCITIZENSHIPNUMBER);
        this.lblCITIZENSHIPNUMBER.setBounds(30, 440, 170, 30);
        this.lblADDRESS.setFont(new Font("Times New Roman", 1, 18));
        this.lblADDRESS.setHorizontalAlignment(0);
        this.lblADDRESS.setText("Address");
        this.getContentPane().add(this.lblADDRESS);
        this.lblADDRESS.setBounds(80, 180, 80, 30);
        this.lblAGE.setFont(new Font("Times New Roman", 1, 18));
        this.lblAGE.setHorizontalAlignment(0);
        this.lblAGE.setText("Age");
        this.getContentPane().add(this.lblAGE);
        this.lblAGE.setBounds(100, 130, 60, 30);
        this.lblempage.setFont(new Font("Times New Roman", 1, 18));
        this.lblempage.setHorizontalAlignment(0);
        this.getContentPane().add(this.lblempage);
        this.lblempage.setBounds(270, 130, 80, 30);
        this.lblempid.setFont(new Font("Times New Roman", 1, 18));
        this.lblempid.setHorizontalAlignment(0);
        this.getContentPane().add(this.lblempid);
        this.lblempid.setBounds(280, 50, 100, 30);
        this.lblempname.setFont(new Font("Times New Roman", 1, 18));
        this.lblempname.setHorizontalAlignment(0);
        this.getContentPane().add(this.lblempname);
        this.lblempname.setBounds(230, 90, 190, 30);
        this.lblFATHERSNAME.setFont(new Font("Times New Roman", 1, 18));
        this.lblFATHERSNAME.setHorizontalAlignment(0);
        this.lblFATHERSNAME.setText("Fathers Name");
        this.getContentPane().add(this.lblFATHERSNAME);
        this.lblFATHERSNAME.setBounds(50, 310, 140, 40);
        this.lblMOBILENUMBER.setFont(new Font("Times New Roman", 1, 18));
        this.lblMOBILENUMBER.setHorizontalAlignment(0);
        this.lblMOBILENUMBER.setText("Mobile Number");
        this.getContentPane().add(this.lblMOBILENUMBER);
        this.lblMOBILENUMBER.setBounds(50, 360, 140, 30);
        this.lblEMAILID.setFont(new Font("Times New Roman", 1, 18));
        this.lblEMAILID.setHorizontalAlignment(0);
        this.lblEMAILID.setText("Email Id");
        this.getContentPane().add(this.lblEMAILID);
        this.lblEMAILID.setBounds(80, 220, 80, 30);
        this.lblempqualification.setFont(new Font("Times New Roman", 1, 18));
        this.lblempqualification.setHorizontalAlignment(0);
        this.getContentPane().add(this.lblempqualification);
        this.lblempqualification.setBounds(260, 400, 120, 30);
        this.lblempfathersname.setFont(new Font("Times New Roman", 1, 18));
        this.lblempfathersname.setHorizontalAlignment(0);
        this.getContentPane().add(this.lblempfathersname);
        this.lblempfathersname.setBounds(230, 310, 240, 30);
        this.lblempjobpost.setFont(new Font("Times New Roman", 1, 18));
        this.lblempjobpost.setHorizontalAlignment(0);
        this.getContentPane().add(this.lblempjobpost);
        this.lblempjobpost.setBounds(230, 260, 220, 30);
        this.lblempaddress.setFont(new Font("Times New Roman", 1, 18));
        this.lblempaddress.setHorizontalAlignment(0);
        this.getContentPane().add(this.lblempaddress);
        this.lblempaddress.setBounds(170, 180, 300, 30);
        this.btnok.setFont(new Font("Times New Roman", 1, 18));
        this.btnok.setText("ok");
        this.btnok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RetriveDetails.this.btnokActionPerformed(evt);
            }
        });
        this.getContentPane().add(this.btnok);
        this.btnok.setBounds(240, 480, 80, 29);
        this.lblempmobilenumber.setFont(new Font("Times New Roman", 1, 18));
        this.lblempmobilenumber.setHorizontalAlignment(0);
        this.getContentPane().add(this.lblempmobilenumber);
        this.lblempmobilenumber.setBounds(240, 360, 170, 30);
        this.lblempcitizenshipnumber.setFont(new Font("Times New Roman", 1, 18));
        this.lblempcitizenshipnumber.setHorizontalAlignment(0);
        this.getContentPane().add(this.lblempcitizenshipnumber);
        this.lblempcitizenshipnumber.setBounds(210, 440, 220, 30);
        this.lblempemailid.setFont(new Font("Times New Roman", 1, 18));
        this.lblempemailid.setHorizontalAlignment(0);
        this.getContentPane().add(this.lblempemailid);
        this.lblempemailid.setBounds(180, 220, 310, 30);
        this.lblJOBPOST.setFont(new Font("Times New Roman", 1, 18));
        this.lblJOBPOST.setHorizontalAlignment(0);
        this.lblJOBPOST.setText("Job Post");
        this.getContentPane().add(this.lblJOBPOST);
        this.lblJOBPOST.setBounds(70, 260, 100, 40);
        this.jLabel4.setFont(new Font("Times New Roman", 1, 18));
        this.jLabel4.setHorizontalAlignment(4);
        this.jLabel4.setText("Name");
        this.getContentPane().add(this.jLabel4);
        this.jLabel4.setBounds(70, 90, 80, 30);
        this.lblEMPLOYEEID.setFont(new Font("Times New Roman", 1, 18));
        this.lblEMPLOYEEID.setHorizontalAlignment(0);
        this.lblEMPLOYEEID.setText("Employee Id");
        this.getContentPane().add(this.lblEMPLOYEEID);
        this.lblEMPLOYEEID.setBounds(40, 50, 130, 30);
        this.llblQUALIFICATION.setIcon(new ImageIcon(this.getClass().getResource("/employee/management/system/project icons/pexels-photo.jpg")));
        this.getContentPane().add(this.llblQUALIFICATION);
        this.llblQUALIFICATION.setBounds(0, 0, 550, 520);
        this.setSize(new Dimension(563, 553));
        this.setLocationRelativeTo((Component) null);
    }

    private void btnokActionPerformed(ActionEvent evt) {
        this.dispose();
    }
}
