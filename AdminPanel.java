package employee.management.system;

import static COM.rsa.asn1.bb.o;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.sql.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AdminPanel extends JFrame {
    private JScrollPane scrollPane;
    private JTable employeeTable;

    @Override
    public void setResizable(boolean resizable) {
        super.setResizable(resizable);
    }

    private JLabel EmployeeLabel;
    private JPanel contentPanel;
    private JLabel profileLabel;
    private JLabel msg;
   
    private int xCoordinate = 120;

    public AdminPanel(String adminEmail, String adminPassword) {
        initialize(adminEmail, adminPassword);
    }

    public void initialize(String adminEmail, String adminPassword) {
        //this.setResizable(false);

        
        


        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        
EmployeeLabel = new JLabel("Employee Details");
EmployeeLabel.setFont(new Font("Arial", Font.BOLD, 20));
EmployeeLabel.setForeground(Color.BLACK);
EmployeeLabel.setBounds(140, 180, 250, 30);
EmployeeLabel.setVisible(false);
contentPanel.add(EmployeeLabel);

// Create an ImageIcon instance with the image file path
ImageIcon employeeIcon = new ImageIcon("/employee/management/system/project icons/payment-method (1).png");

// Set the icon to the EmployeeLabel
EmployeeLabel.setIcon(employeeIcon);

// Set bounds for the EmployeeLabel
EmployeeLabel.setBounds(10, 200, 300, 300); // Replace x, y, width, and height with appropriate values

// Add EmployeeLabel to contentPanel
contentPanel.add(EmployeeLabel);

        setTitle("Admin Portal");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(32, 152, 207));
        headerPanel.setPreferredSize(new Dimension(1000, 100));
        add(headerPanel, BorderLayout.NORTH);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(32, 152, 207));
        logoutButton.setForeground(Color.white);
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout(adminEmail, adminPassword);
            }
        });
        headerPanel.add(logoutButton, BorderLayout.EAST);

        JPanel profilePanel = new JPanel(null);
        profilePanel.setPreferredSize(new Dimension(100, 100));
        profilePanel.setBackground(new Color(32, 152, 207));
        headerPanel.add(profilePanel, BorderLayout.WEST);

        profileLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (getIcon() != null) {
                    int width = getWidth();
                    int height = getHeight();
                    Graphics2D g2 = (Graphics2D) g.create();
                    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setRenderingHints(hints);
                    Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, width, height);
                    g2.clip(ellipse);
                    g2.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, width, height, this);
                    g2.dispose();
                }
            }
        };

        String imagePath = fetchImagePath(adminEmail, adminPassword);
        String name = fetchName(adminEmail, adminPassword);

        if (imagePath != null) {
            try {
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    profileLabel.setIcon(new ImageIcon(image));
                    profileLabel.setBounds(0, 0, 100, 100);
                } else {
                    System.err.println("Image file not found: " + imagePath);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        profilePanel.add(profileLabel);

        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        add(contentPanel, BorderLayout.CENTER);

        JButton uploadButton = new JButton("Upload");
        uploadButton.setBounds(0, 0, 100, 30);
        uploadButton.setBackground(new Color(32, 152, 207));
        uploadButton.setForeground(Color.white);
        uploadButton.setFocusPainted(false);
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadImage();
            }
        });
        contentPanel.add(uploadButton);

        JButton homeButton = new JButton("Home");
        homeButton.setBounds(105, 0, 100, 30);
        homeButton.setBackground(new Color(32, 152, 207));
        homeButton.setForeground(Color.white);
        homeButton.setFocusPainted(false);
        homeButton.setVisible(true);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new loginform().setVisible(true);
            }
        });
        contentPanel.add(homeButton);

        JButton Disposebutton = new JButton("Dispose");
        Disposebutton.setBounds(160, 420, 100, 30);
        Disposebutton.setBackground(new Color(32, 152, 207));
        Disposebutton.setForeground(Color.white);
        Disposebutton.setFocusPainted(false);
        Disposebutton.setVisible(false);
        Disposebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dispose();
                Disposebutton.setVisible(false);
            }
        });
        contentPanel.add(Disposebutton);

        EmployeeLabel = new JLabel("Employee Details");
        EmployeeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        EmployeeLabel.setForeground(Color.BLACK);
        EmployeeLabel.setBounds(140, 180, 250, 30);
        EmployeeLabel.setVisible(false);
        contentPanel.add(EmployeeLabel);
        
        
                    
        
        

        msg = new JLabel();
        msg.setFont(new Font("Arial", Font.BOLD, 25));
        msg.setForeground(Color.BLACK);
        msg.setBounds(xCoordinate, 0, 500, 30);
        msg.setVisible(true);
        msg.setText("Hi " + name + " Welcome to Admin Portal");
        headerPanel.add(msg, BorderLayout.CENTER);

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xCoordinate += 2;
                msg.setBounds(xCoordinate, 0, 540, 30);
                if (xCoordinate >= contentPanel.getWidth()) {
                    xCoordinate = -msg.getWidth();
                }
            }
        });
        timer.start();

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/employee/management/system/project icons/payment-method (1).png"));
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/employee/management/system/project icons/open-book-top-view.png"));
        ImageIcon icon3 = new ImageIcon(getClass().getResource("/employee/management/system/project icons/file.png"));
        ImageIcon icon4 = new ImageIcon(getClass().getResource("/employee/management/system/project icons/multiple-users-silhouette.png"));

        Image scaledIcon1 = icon1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        Image scaledIcon2 = icon2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        Image scaledIcon3 = icon3.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        Image scaledIcon4 = icon4.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

        JLabel iconLabel1 = new JLabel(new ImageIcon(scaledIcon1));
        JLabel iconLabel2 = new JLabel(new ImageIcon(scaledIcon2));
        JLabel iconLabel3 = new JLabel(new ImageIcon(scaledIcon3));
        JLabel iconLabel4 = new JLabel(new ImageIcon(scaledIcon4));

        int iconWidth = 300;
        int iconHeight = 300;
        iconLabel1.setBounds(450, 110, iconWidth, iconHeight);
        iconLabel2.setBounds(730, 110, iconWidth, iconHeight);
        iconLabel3.setBounds(450, 300, iconWidth, iconHeight);
        iconLabel4.setBounds(730, 300, iconWidth, iconHeight);

        contentPanel.add(iconLabel1);
        contentPanel.add(iconLabel2);
        contentPanel.add(iconLabel3);
        contentPanel.add(iconLabel4);

        iconLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new AddEmployee().setVisible(true);
            }
        });

        iconLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EmployeeLabel.setVisible(true);
                fetchEmployeeDetails();
                Disposebutton.setVisible(true);
            }
        });

        iconLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new View().setVisible(true);
            }
        });

        iconLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(AdminPanel.this, "Icon 4 clicked");
            }
        });

        JLabel nameLabel1 = new JLabel("Add Record");
        JLabel nameLabel2 = new JLabel("Employee Details"); 
        JLabel nameLabel3 = new JLabel("View Records");
        JLabel nameLabel4 = new JLabel("Create Users");

        int nameWidth = 150;
        int nameHeight = 20;
        nameLabel1.setBounds(490, 335, nameWidth, nameHeight);
        nameLabel2.setBounds(800, 330, nameWidth, nameHeight);
        nameLabel3.setBounds(490, 525, nameWidth, nameHeight);
        nameLabel4.setBounds(800, 515, nameWidth, nameHeight);

        nameLabel1.setForeground(Color.BLACK);
        nameLabel2.setForeground(Color.BLACK);
        nameLabel3.setForeground(Color.BLACK);
        nameLabel4.setForeground(Color.BLACK);
        nameLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel4.setHorizontalAlignment(SwingConstants.CENTER);

        contentPanel.add(nameLabel1);
        contentPanel.add(nameLabel2);
        contentPanel.add(nameLabel3);
        contentPanel.add(nameLabel4);

        setVisible(true);
    }

    private void fetchEmployeeDetails() {
        String[] columnNames = {"Name", "Age", "Address", "Email ID", "Job Post", "Employee ID",
                "Father's Name", "Mobile Number", "Qualification", "Citizenship Number", "Hire Date"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345")) {
                String query = "SELECT * FROM EmployeeDetails";
                try (PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        Object[] row = {
                                rs.getString("eName"),
                                rs.getString("eAge"),
                                rs.getString("eAddress"),
                                rs.getString("eEmailId"),
                                rs.getString("eJobPost"),
                                rs.getString("eEmployeeId"),
                                rs.getString("eFathersName"),
                                rs.getString("eMobileNumber"),
                                rs.getString("eQualification"),
                                rs.getString("eCitizenshipNumber"),
                                rs.getString("hireDate")
                        };
                        tableModel.addRow(row);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching employee details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Create a new JScrollPane instance and assign it to the scrollPane variable
        scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBounds(0, 205, 515, 200);
        contentPanel.add(scrollPane);

        employeeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = employeeTable.getSelectedRow();
                    if (selectedRow != -1) {
                        String eEmployeeId = (String) employeeTable.getValueAt(selectedRow, 5);
                        performUpdateOperation(eEmployeeId);
                    }
                }
            }
        });
    }

    private void performUpdateOperation(String eEmployeeId) {
    System.out.println("Performing update operation for employee ID: " + eEmployeeId);

    // Retrieve the employee details based on the provided employee ID
    // Query the database to fetch the details of the employee with the given ID
    String query = "SELECT * FROM EmployeeDetails WHERE eEmployeeId = ?";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345");
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, eEmployeeId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Extract employee details from the result set
                    String name = rs.getString("eName");
                    int age = rs.getInt("eAge");
                    String address = rs.getString("eAddress");
                    String email = rs.getString("eEmailId");
                    String jobPost = rs.getString("eJobPost");
                    String fathersName = rs.getString("eFathersName");
                    String mobileNumber = rs.getString("eMobileNumber");
                    String qualification = rs.getString("eQualification");
                    String citizenshipNumber = rs.getString("eCitizenshipNumber");
                    String hireDate = rs.getString("hireDate");

                    // Display the employee details in a new window or dialog
                    // You can use JTextFields or other components to allow the user to modify the details
                    JTextField nameField = new JTextField(name);
                    JTextField ageField = new JTextField(String.valueOf(age));
                    // Add other fields as needed

                    JPanel panel = new JPanel(new GridLayout(0, 1));
                    panel.add(new JLabel("Name:"));
                    panel.add(nameField);
                    panel.add(new JLabel("Age:"));
                    panel.add(ageField);
                    // Add other fields to the panel

                    int result = JOptionPane.showConfirmDialog(null, panel, "Update Employee Details",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (result == JOptionPane.OK_OPTION) {
                        // Update the employee record in the database with the modified details
                        String updateQuery = "UPDATE EmployeeDetails SET eName=?, eAge=?, eAddress=?, eEmailId=?, eJobPost=?, eFathersName=?, eMobileNumber=?, eQualification=?, eCitizenshipNumber=?, hireDate=? WHERE eEmployeeId=?";
                        try (PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
                            updatePst.setString(1, nameField.getText());
                            updatePst.setInt(2, Integer.parseInt(ageField.getText()));
                            // Set other parameters for the update query
                            updatePst.setString(11, eEmployeeId);

                            int rowsUpdated = updatePst.executeUpdate();
                            if (rowsUpdated > 0) {
                                JOptionPane.showMessageDialog(null, "Employee details updated successfully.");
                                // Refresh the employee table or any other UI component displaying employee data
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to update employee details.");
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Employee not found.");
                }
            }
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating employee details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void logout(String admin_username, String admin_password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345")) {
                String query = "DELETE FROM admin_table WHERE admin_username=? AND admin_password=?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, admin_username);
                    pst.setString(2, admin_password);
                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Logout Successful. Admin data deleted.");
                        dispose();
                        new AdminPage().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to logout. Please try again.");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error during logout: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String fetchImagePath(String adminEmail, String adminPassword) {
        String imagePath = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345")) {
                String query = "SELECT image_path FROM registration_data WHERE email=? AND password=?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, adminEmail);
                    pst.setString(2, adminPassword);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            imagePath = rs.getString("image_path");
                            imagePath = imagePath.substring(imagePath.indexOf(":") + 2);
                            System.out.println("Image Path Fetched: " + imagePath);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching image path: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return imagePath;
    }

    private String fetchName(String adminEmail, String adminPassword) {
        String name = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "Aamir12345")) {
                String query = "SELECT name FROM registration_data WHERE email=? AND password=?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, adminEmail);
                    pst.setString(2, adminPassword);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            name = rs.getString("name");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching name: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return name;
    }

    private void setProfileImage(String imagePath) {
        try {
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                ImageIcon imageIcon = new ImageIcon(imagePath);
                Image image = imageIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                profileLabel.setIcon(new ImageIcon(image));
            } else {
                System.err.println("Image file not found: " + imagePath);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void uploadImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String selectedImagePath = selectedFile.getAbsolutePath();
            setProfileImage(selectedImagePath);
        }
    }

    private void Dispose() {
        EmployeeLabel.setVisible(false);
        if (scrollPane != null) {
            scrollPane.setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminPanel("admin@example.com", "adminpassword"));
    }
}
