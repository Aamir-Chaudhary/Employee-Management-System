package employee.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewAttendance extends JFrame {

    public ViewAttendance(String empId) {
        setTitle("Attendance Report for Employee ID: " + empId);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {"Date", "Check-in", "Check-out", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        boolean hasData = false; // Flag to check if any data is found

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform", "root", "Aamir12345");

            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM attendance_desktop WHERE employee_id = ? AND MONTH(date) = MONTH(CURDATE()) AND YEAR(date) = YEAR(CURDATE()) ORDER BY date"
            );

            stmt.setString(1, empId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                hasData = true; // At least one row is found
                model.addRow(new Object[]{
                    rs.getDate("date"),
                    rs.getString("checkin_time"),
                    rs.getString("checkout_time"),
                    rs.getString("status")
                });
            }

            if (!hasData) {
                JOptionPane.showMessageDialog(this, "Employee has not checked in today or has no attendance records this month.");
                dispose(); // Close the window if no records
                return;
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }

        add(new JScrollPane(table), BorderLayout.CENTER);
        setVisible(true);
    }
}
