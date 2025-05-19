package employee.management.system;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.toedter.calendar.JDateChooser;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEmployee extends JFrame {

    private JTextField txtName, txtAge, txtAddress, txtEmail, txtJobPost, txtMobileNumber, txtQualification, txtFathersName, txtCitizenshipNumber, txtEmployeeId;
    private JDateChooser dateChooser;
    private JLabel qrLabel;

    public AddEmployee() {
        setTitle("Add Employee");
        setLayout(null);
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Font labelFont = new Font("Times New Roman", Font.BOLD, 16);

        addLabel("Name:", 30, 30, labelFont);
        txtName = addTextField(150, 30);

        addLabel("Age:", 30, 70, labelFont);
        txtAge = addTextField(150, 70);

        addLabel("Address:", 30, 110, labelFont);
        txtAddress = addTextField(150, 110);

        addLabel("Email:", 30, 150, labelFont);
        txtEmail = addTextField(150, 150);

        addLabel("Job Post:", 30, 190, labelFont);
        txtJobPost = addTextField(150, 190);

        addLabel("Mobile Number:", 30, 230, labelFont);
        txtMobileNumber = addTextField(150, 230);

        addLabel("Qualification:", 400, 30, labelFont);
        txtQualification = addTextField(540, 30);

        addLabel("Father's Name:", 400, 70, labelFont);
        txtFathersName = addTextField(540, 70);

        addLabel("Citizenship No:", 400, 110, labelFont);
        txtCitizenshipNumber = addTextField(540, 110);

        addLabel("Employee ID:", 400, 150, labelFont);
        txtEmployeeId = addTextField(540, 150);

        addLabel("Hire Date:", 400, 190, labelFont);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(540, 190, 230, 25);
        add(dateChooser);

        JButton btnAdd = new JButton("Add Employee");
        btnAdd.setBounds(220, 280, 170, 40);
        add(btnAdd);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(410, 280, 170, 40);
        add(btnCancel);

        qrLabel = new JLabel();
        qrLabel.setBounds(300, 340, 200, 200);
        add(qrLabel);

        btnAdd.addActionListener(e -> addEmployee());
        btnCancel.addActionListener(e -> dispose()); // Closes the form

        setVisible(true);
    }

    private void addLabel(String text, int x, int y, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setBounds(x, y, 120, 25);
        add(label);
    }

    private JTextField addTextField(int x, int y) {
        JTextField field = new JTextField();
        field.setBounds(x, y, 200, 25);
        add(field);
        return field;
    }

    private void addEmployee() {
        String name = txtName.getText();
        String age = txtAge.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String jobPost = txtJobPost.getText();
        String mobile = txtMobileNumber.getText();
        String qualification = txtQualification.getText();
        String fathersName = txtFathersName.getText();
        String citizenship = txtCitizenshipNumber.getText();
        String employeeId = txtEmployeeId.getText();

        if (!validateForm(name, age, address, email, jobPost, mobile, qualification, fathersName, citizenship, employeeId)) {
            return; // Validation failed
        }

        if (dateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please select hire date");
            return;
        }

        String hireDate = new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform", "root", "Aamir12345");

            // Generate QR and save
            String qrData = "ID:" + employeeId;
            String qrPath = "qrcodes/" + employeeId + ".png";
            generateQR(qrData, qrPath);

            PreparedStatement pst = con.prepareStatement("INSERT INTO employeedetails (eName, eAge,eAddress, eEmailid, eJobPost, eEmployeeId, eFathersName, eMobileNumber, eQualification, eCitizenshipNumber, hiredate, qr_code_path) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
            pst.setString(1, name);
            pst.setString(2, age);
             pst.setString(3, address);
            pst.setString(4, email);
            pst.setString(5, jobPost);
            pst.setString(6, employeeId);
            pst.setString(7, fathersName);
            pst.setString(8, mobile);
            pst.setString(9, qualification);
            pst.setString(10, citizenship);
            pst.setString(11, hireDate);
            pst.setString(12, qrPath);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Employee Added Successfully");

            ImageIcon qrIcon = new ImageIcon(new ImageIcon(qrPath).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
            qrLabel.setIcon(qrIcon);

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private boolean validateForm(String name, String age, String address, String email, String jobPost, String mobile, String qualification, String fathersName, String citizenship, String employeeId) {
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty");
            return false;
        }
        if (!name.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Name must contain only letters and spaces");
            return false;
        }
        if (age.isEmpty() || !age.matches("[0-9]+") || Integer.parseInt(age) < 18 || Integer.parseInt(age) > 100) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number between 18 and 100");
            return false;
        }
        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address cannot be empty");
            return false;
        }
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format");
            return false;
        }
        if (jobPost.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Job post cannot be empty");
            return false;
        }
        if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mobile number cannot be empty");
            return false;
        }
        if (!mobile.matches("[0-9]{10}")) {
            JOptionPane.showMessageDialog(this, "Mobile number must be a 10-digit number");
            return false;
        }
        if (qualification.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Qualification cannot be empty");
            return false;
        }
        if (!qualification.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Qualification must contain only letters and spaces");
            return false;
        }
        if (fathersName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Father's Name cannot be empty");
            return false;
        }
        if (!fathersName.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Name must contain only letters and spaces");
            return false;
        }
        if (citizenship.isEmpty()) {
            JOptionPane.showMessageDialog(this, "citizenship cannot be empty");
            return false;
        }
        if (citizenship.isEmpty() || !citizenship.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Citizenship Number must be a valid number");
            return false;
        }
        
        if (employeeId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "employeeId Name cannot be empty");
            return false;
        }
        if (employeeId.isEmpty() || !employeeId.matches("[a-zA-Z0-9]+")) {
            JOptionPane.showMessageDialog(this, "Employee ID must be alphanumeric");
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void generateQR(String data, String path) throws Exception {
        int width = 300;
        int height = 300;
        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
        File dir = new File("qrcodes");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Path filePath = FileSystems.getDefault().getPath(path);
        MatrixToImageWriter.writeToPath(matrix, "PNG", filePath);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}


