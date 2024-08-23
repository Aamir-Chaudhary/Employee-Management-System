package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminPage extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox chkShowPassword;
    private JCheckBox chkRememberMe;
    private JButton btnLogin;
    private JButton btnBack; // Added back button
    private JButton btnRegister; 

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public AdminPage() {
        initComponents();
       // public AdminPanel(String adminEmail, String adminPassword) 

    }

    private void initComponents() {
        setTitle("Admin Page");

        JPanel jPanel1 = new JPanel();
        JLabel lblUsername = new JLabel();
        JLabel lblPassword = new JLabel();
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        chkShowPassword = new JCheckBox("Show Password");
        chkRememberMe = new JCheckBox("Remember Me");

        btnLogin = new JButton();
        btnBack = new JButton(); // Initialize back button

        chkRememberMe.setSelected(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setText("Admin Username");

        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setText("Admin Password");

        chkShowPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
        chkRememberMe.setFont(new Font("SansSerif", Font.PLAIN, 14));

        btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAdminLoginActionPerformed(evt);
            }
        });

        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnBack.setText("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        chkShowPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chkShowPasswordActionPerformed(evt);
            }
        });

        chkRememberMe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chkRememberMeActionPerformed(evt);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                if (chkRememberMe.isSelected()) {
                    retrieveRememberMeData();
                }
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15)))
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUsername)
                                .addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(chkShowPassword)
                                .addComponent(chkRememberMe)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(chkShowPassword)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(chkRememberMe)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(49, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        
        btnRegister = new JButton();
        btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister);
        btnRegister.setBounds(400, 210, 120, 30);
    }
    
    private void btnRegisterActionPerformed(ActionEvent evt) {
    // Logic to handle the register button action
    // You can open a new registration form or implement the registration logic here

    String adminPassword = JOptionPane.showInputDialog(this, "Enter Admin Password:");

    if (adminPassword != null && !adminPassword.isEmpty()) { // Check if adminPassword is not null or empty
        try {
            String query = "SELECT * FROM registration_data WHERE password=?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
            pst = con.prepareStatement(query);

            pst.setString(1, adminPassword);
            rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Password verified..");
                this.dispose();
                new Signup().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Password ");
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            e.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(null, "No password entered or canceled.");
    }
}

        
    

    private void chkRememberMeActionPerformed(ActionEvent evt) {
        if (chkRememberMe.isSelected()) {
            storeRememberMe(txtUsername.getText(), new String(txtPassword.getPassword()));
        } else {
            deleteRememberMe(txtUsername.getText());
            txtUsername.setText("");
            txtPassword.setText("");
        }
    }

    private void storeRememberMe(String admin_username, String admin_password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection rememberMeCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345")) {
                String checkQuery = "SELECT * FROM admin_table WHERE admin_username=?";
                try (PreparedStatement checkPst = rememberMeCon.prepareStatement(checkQuery)) {
                    checkPst.setString(1, admin_username);
                    try (ResultSet checkResult = checkPst.executeQuery()) {
                        if (checkResult.next()) {
                            String updateQuery = "UPDATE admin_table SET password=? WHERE admin_username=?";
                            try (PreparedStatement updatePst = rememberMeCon.prepareStatement(updateQuery)) {
                                updatePst.setString(1, admin_password);
                                updatePst.setString(2, admin_username);
                                updatePst.executeUpdate();
                            }
                        } else {
                            String storeQuery = "INSERT INTO admin_table(admin_username, admin_password) VALUES (?, ?)";
                            try (PreparedStatement storePst = rememberMeCon.prepareStatement(storeQuery)) {
                                storePst.setString(1, admin_username);
                                storePst.setString(2, admin_password);
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
                String retrieveQuery = "SELECT * FROM admin_table WHERE admin_username=?";
                try (PreparedStatement retrievePst = rememberMeCon.prepareStatement(retrieveQuery)) {
                    retrievePst.setString(1, getUsernameFromDatabase());
                    try (ResultSet rememberMeResult = retrievePst.executeQuery()) {
                        if (rememberMeResult.next()) {
                            String storedUsername = rememberMeResult.getString("admin_username");
                            String storedPassword = rememberMeResult.getString("admin_password");
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
        String query = "SELECT * FROM admin_table LIMIT 1";
        try (Connection rememberMeCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
             PreparedStatement pst = rememberMeCon.prepareStatement(query);
             ResultSet resultSet = pst.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getString("admin_username");
            }
        }
        return "";
    }

    private void deleteRememberMe(String admin_username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection rememberMeCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345")) {
                String deleteQuery = "DELETE FROM admin_table WHERE admin_username=?";
                try (PreparedStatement deletePst = rememberMeCon.prepareStatement(deleteQuery)) {
                    deletePst.setString(1, admin_username);
                    deletePst.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void btnAdminLoginActionPerformed(ActionEvent evt) {
        if (txtUsername.getText().trim().isEmpty() || txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Enter Admin Username and Password.");
            return;
        }

        String adminUser = txtUsername.getText();
        String adminPassword = new String(txtPassword.getPassword());

        try {
            String query = "SELECT * FROM registration_data WHERE email=? AND password=?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
            pst = con.prepareStatement(query);
            pst.setString(1, adminUser);
            pst.setString(2, adminPassword);
            rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Successful!");
                this.setVisible(false);

                // Open AdminPanel with email and password
                 //new AdminPanel(adminUser, adminPassword);
                 SwingUtilities.invokeLater(() -> new AdminPanel(adminUser, adminPassword));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Admin Username/Password or <You are not registered>");
                txtUsername.setText(null);
                txtPassword.setText(null);
                txtUsername.requestFocus();
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            e.printStackTrace();
        }
    }

    private void chkShowPasswordActionPerformed(ActionEvent evt) {
        if (chkShowPassword.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('\u2022');
        }
    }

    private void btnBackActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        new loginform().setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }
}
