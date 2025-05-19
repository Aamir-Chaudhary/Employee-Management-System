package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttendanceMainUI extends JFrame {

    public AttendanceMainUI() {
        setTitle("Employee Attendance System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JButton markAttendanceButton = new JButton("Mark Attendance");
        JButton viewAttendanceButton = new JButton("View Attendance");
        JButton disposeButton = new JButton("Dispose"); // ✅ Added Dispose button

        markAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ScanQRCodeAttendance();
            }
        });

        viewAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String empId = JOptionPane.showInputDialog("Enter Employee ID:");
                if (empId != null && !empId.trim().isEmpty()) {
                    new ViewAttendance(empId.trim());
                }
            }
        });

        disposeButton.addActionListener(new ActionListener() { // ✅ Dispose button action
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(markAttendanceButton);
        add(viewAttendanceButton);
        add(disposeButton); // ✅ Added to layout

        setVisible(true);
    }

    public static void main(String[] args) {
        new AttendanceMainUI();
    }
}
