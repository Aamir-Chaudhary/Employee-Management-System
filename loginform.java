package employee.management.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class loginform extends JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private JButton btnCancel;
    private JButton btnForgetPassword;
    private JButton btnLogin;
    private JButton btnReset;
    private JButton btnAdmin;
    private JLabel jLabel1;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JLabel lblPassword;
    private JLabel lblUsername;
    private JPasswordField txtPassword;
    private JTextField txtUsername;
    private JCheckBox chkShowPassword;
    private JCheckBox chkRememberMe;

    public loginform() {
        this.rs = null;
        this.pst = null;
        this.initComponents();
        this.setBackground(Color.white);
        this.setResizable(false);

    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.lblUsername = new JLabel();
        this.lblPassword = new JLabel();
        this.txtUsername = new JTextField();
        this.txtPassword = new JPasswordField();
        this.btnLogin = new JButton();
        this.btnReset = new JButton();
        this.btnAdmin = new JButton();
        this.btnCancel = new JButton();
        this.jLabel4 = new JLabel();
        this.btnForgetPassword = new JButton();
        this.jLabel1 = new JLabel();
        this.chkShowPassword = new JCheckBox("Show Password");
        this.chkRememberMe = new JCheckBox("Remember Me");

        this.setDefaultCloseOperation(3);
        this.setTitle("Login Page");
        this.jPanel1.setMaximumSize(new java.awt.Dimension(705, 491));
        this.jPanel1.setMinimumSize(new java.awt.Dimension(705, 491));
        this.jPanel1.setLayout((LayoutManager) null);

        this.lblUsername.setFont(new Font("Times New Roman", 1, 24));
        this.lblUsername.setHorizontalAlignment(0);
        this.lblUsername.setText("Username");
        this.jPanel1.add(this.lblUsername);
        this.lblUsername.setBounds(10, 20, 120, 50);

        this.lblPassword.setFont(new Font("Times New Roman", 1, 24));
        this.lblPassword.setHorizontalAlignment(0);
        this.lblPassword.setText("Password");
        this.lblPassword.setToolTipText("");
        this.jPanel1.add(this.lblPassword);
        this.lblPassword.setBounds(20, 100, 110, 30);

        this.txtUsername.setFont(new Font("SansSerif", 0, 14));
        this.jPanel1.add(this.txtUsername);
        this.txtUsername.setBounds(180, 30, 240, 30);

        this.txtPassword.setFont(new Font("SansSerif", 0, 18));
        this.jPanel1.add(this.txtPassword);
        this.txtPassword.setBounds(180, 100, 240, 30);

        this.chkShowPassword.setFont(new Font("SansSerif", 0, 14));
        this.jPanel1.add(chkShowPassword);
        chkShowPassword.setBounds(180, 140, 120, 30);
        chkShowPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chkShowPasswordActionPerformed(evt);
            }
        });

        this.chkRememberMe.setFont(new Font("SansSerif", 0, 14));
        this.jPanel1.add(chkRememberMe);
        chkRememberMe.setBounds(180, 170, 120, 30);
        chkRememberMe.setSelected(true);
        //if (chkRememberMe.isSelected()) {
        // retrieveRememberMeData();
        //}
        chkRememberMe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chkRememberMeActionPerformed(evt);
            }
        });

        // Add a window listener to retrieve remember me data when the form becomes visible
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                if (chkRememberMe.isSelected()) {
                    retrieveRememberMeData();
                }
            }
        });

        this.btnLogin.setFont(new Font("Times New Roman", 1, 18));
        this.btnLogin.setText("Login");
        this.btnLogin.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                btnLoginMouseMoved(evt);
            }
        });
        this.btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnLogin);
        this.btnLogin.setBounds(40, 230, 80, 30);

        this.btnReset.setFont(new Font("Times New Roman", 1, 18));
        this.btnReset.setText("Reset");
        this.btnReset.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                btnResetMouseMoved(evt);
            }
        });
        this.btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnReset);
        this.btnReset.setBounds(200, 230, 80, 30);

        this.btnAdmin.setFont(new Font("Times New Roman", 1, 15));
        this.btnAdmin.setText("Admin");

        try {
            ImageIcon adminIcon = new ImageIcon(getClass().getResource("/employee/management/system/project icons/icons8-admin-25.png"));
            btnAdmin.setIcon(adminIcon);
        } catch (NullPointerException e) {
            System.err.println("Error loading admin icon: " + e.getMessage());
        }

        btnAdmin.setBackground(new Color(0, 0, 0, 0));
        btnAdmin.setBorderPainted(true);
        btnAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //Border transparentBorder = BorderFactory.createLineBorder(new Color(0, 0, 0, 0), 1, true);
        btnAdmin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        //btnAdmin.setBorder(line);
        btnAdmin.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                btnResetMouseMoved(evt);
            }
        });

        btnAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        this.jPanel1.add(this.btnAdmin);
        this.btnAdmin.setBounds(0, 0, 95, 25);

        this.btnCancel.setFont(new Font("Times New Roman", 1, 18));
        this.btnCancel.setText("Cancel");
        this.btnCancel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                btnCancelMouseMoved(evt);
            }
        });
        this.btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnCancel);
        this.btnCancel.setBounds(370, 230, 90, 30);

        this.jLabel4.setIcon(new ImageIcon(this.getClass().getResource("/employee/management/system/project icons/Untitled4.png")));
        this.jPanel1.add(this.jLabel4);
        this.jLabel4.setBounds(0, 310, 250, 130);

        this.btnForgetPassword.setFont(new Font("Times New Roman", 1, 18));
        this.btnForgetPassword.setText("Forget Password/Reset ");
        this.btnForgetPassword.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                btnForgetPasswordMouseMoved(evt);
            }
        });
        this.btnForgetPassword.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                btnForgetPasswordMousePressed(evt);
            }
        });
        this.jPanel1.add(this.btnForgetPassword);
        this.btnForgetPassword.setBounds(1, 441, 250, 30);

        this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/employee/management/system/project icons/Untitled2.png")));
        this.jPanel1.add(this.jLabel1);
        this.jLabel1.setBounds(0, 0, 705, 491);

        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));

        this.pack();
        this.setLocationRelativeTo((Component) null);
    }

    private void chkRememberMeActionPerformed(ActionEvent evt) {
        if (chkRememberMe.isSelected()) {
            storeRememberMe(txtUsername.getText(), new String(txtPassword.getPassword()));
        } else {
            deleteRememberMe(txtUsername.getText());
            txtUsername.setText(""); // Clear the username field
            txtPassword.setText(""); // Clear the password field
        }
    }

    // Place these methods within your loginform class
    private void storeRememberMe(String username, String password) {
        try {
            // Establish connection to the database using try-with-resources
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection rememberMeCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345")) {

                // Check if the username already exists
                String checkQuery = "SELECT * FROM remember WHERE username=?";
                try (PreparedStatement checkPst = rememberMeCon.prepareStatement(checkQuery)) {
                    checkPst.setString(1, username);
                    try (ResultSet checkResult = checkPst.executeQuery()) {
                        if (checkResult.next()) {
                            // Username already exists, update the existing record
                            String updateQuery = "UPDATE remember SET password=? WHERE username=?";
                            try (PreparedStatement updatePst = rememberMeCon.prepareStatement(updateQuery)) {
                                updatePst.setString(1, password);
                                updatePst.setString(2, username);
                                updatePst.executeUpdate();
                            }
                        } else {
                            // Username doesn't exist, insert a new record
                            String storeQuery = "INSERT INTO remember(username, password) VALUES (?, ?)";
                            try (PreparedStatement storePst = rememberMeCon.prepareStatement(storeQuery)) {
                                storePst.setString(1, username);
                                storePst.setString(2, password);
                                storePst.executeUpdate();
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void retrieveRememberMeData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection rememberMeCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345")) {
                String retrieveQuery = "SELECT * FROM remember WHERE username=?";
                try (PreparedStatement retrievePst = rememberMeCon.prepareStatement(retrieveQuery)) {
                    retrievePst.setString(1, getUsernameFromDatabase()); // Use a method to get the username from the database
                    try (ResultSet rememberMeResult = retrievePst.executeQuery()) {
                        if (rememberMeResult.next()) {
                            String storedUsername = rememberMeResult.getString("username");
                            String storedPassword = rememberMeResult.getString("password");
                            txtUsername.setText(storedUsername);
                            txtPassword.setText(storedPassword);
                        } else {
                            chkRememberMe.setSelected(false);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private String getUsernameFromDatabase() throws SQLException {
        String query = "SELECT * FROM remember LIMIT 1"; // Use an appropriate query to get a single entry from the remember table
        try (Connection rememberMeCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
                PreparedStatement pst = rememberMeCon.prepareStatement(query);
                ResultSet resultSet = pst.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getString("username");
            }
        }
        return ""; // Return an appropriate default value if no username is found
    }

    private void deleteRememberMe(String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection rememberMeCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345")) {
                String deleteQuery = "DELETE FROM remember WHERE username=?";
                try (PreparedStatement deletePst = rememberMeCon.prepareStatement(deleteQuery)) {
                    deletePst.setString(1, username);
                    deletePst.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void btnResetActionPerformed(ActionEvent evt) {
        this.txtUsername.setText(null);
        this.txtPassword.setText(null);
        this.txtUsername.requestFocus();
    }

    private void btnAdminActionPerformed(ActionEvent evt) {
        this.dispose();
        (new AdminPage()).setVisible(true);

    }

    private void btnCancelActionPerformed(ActionEvent evt) {
        this.dispose();
        (new Frontpage()).setVisible(true);
    }

    private void btnLoginActionPerformed(ActionEvent evt) {
        if (this.txtUsername.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Username.");
            this.txtUsername.grabFocus();
        } else if (this.txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Enter Password.");
            this.txtPassword.grabFocus();
        } else {
            String user = this.txtUsername.getText();
            String password = new String(this.txtPassword.getPassword());

            try {
                String query = "select * from login where username=? and password=?";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException var6) {
                    Logger.getLogger(loginform.class.getName()).log(Level.SEVERE, null, var6);
                }

                this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
                this.pst = this.con.prepareStatement(query);
                this.pst.setString(1, this.txtUsername.getText());
                this.pst.setString(2, new String(this.txtPassword.getPassword()));
                this.rs = this.pst.executeQuery();

                if (this.rs.next()) {
                    (new EmployeeDetail()).setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog((Component) null, "Invalid Username or password");
                    this.txtUsername.setText(null);
                    this.txtPassword.setText(null);
                    this.txtUsername.requestFocus();
                }
            } catch (SQLException | HeadlessException var7) {
                var7.printStackTrace();
            }
        }
    }

    private void btnForgetPasswordMouseMoved(MouseEvent evt) {
        this.btnForgetPassword.setCursor(Cursor.getPredefinedCursor(12));
    }

    private void btnForgetPasswordMousePressed(MouseEvent evt) {
        Sendcode sc = new Sendcode();
        this.setVisible(false);
        sc.setVisible(true);
    }

    private void btnLoginMouseMoved(MouseEvent evt) {
        this.btnLogin.setCursor(Cursor.getPredefinedCursor(12));
    }

    private void btnResetMouseMoved(MouseEvent evt) {
        this.btnReset.setCursor(Cursor.getPredefinedCursor(12));
    }

    private void btnAdminMouseClicked(MouseEvent evt) {
        this.btnAdmin.setCursor(Cursor.getPredefinedCursor(12));
    }

    private void btnCancelMouseMoved(MouseEvent evt) {
        this.btnCancel.setCursor(Cursor.getPredefinedCursor(12));
    }

    private void chkShowPasswordActionPerformed(ActionEvent evt) {
        if (chkShowPassword.isSelected()) {
            txtPassword.setEchoChar((char) 0); // Show password
        } else {
            txtPassword.setEchoChar('\u2022'); // Hide password
        }
    }

}
