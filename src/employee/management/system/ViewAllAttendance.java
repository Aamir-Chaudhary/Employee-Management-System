package employee.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.sql.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class ViewAllAttendance extends JFrame {

    private DefaultTableModel model;
    private JTable table;

    public ViewAllAttendance() {
        setTitle("All Employees Attendance Report");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] columns = {"Employee ID", "Name", "Date", "Check-in", "Check-out", "Status"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        fetchAttendanceData();

        // Add scrollable table
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Add Close and Export PDF buttons
        JPanel buttonPanel = new JPanel();
        JButton closeButton = new JButton("Close");
        JButton pdfButton = new JButton("Export to PDF");

        closeButton.addActionListener(e -> dispose());

        pdfButton.addActionListener(e -> exportToPDF());

        buttonPanel.add(pdfButton);
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void fetchAttendanceData() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform", "root", "Aamir12345");

            String query = "SELECT a.employee_id, e.eName, a.date, a.checkin_time, a.checkout_time, a.status " +
                    "FROM attendance_desktop a " +
                    "JOIN employeedetails e ON a.employee_id = e.eEmployeeId " +
                    "ORDER BY a.date DESC, a.employee_id";

            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;
                model.addRow(new Object[]{
                        rs.getString("employee_id"),
                        rs.getString("eName"),
                        rs.getDate("date"),
                        rs.getString("checkin_time"),
                        rs.getString("checkout_time"),
                        rs.getString("status")
                });
            }

            if (!hasData) {
                JOptionPane.showMessageDialog(this, "No attendance records found.");
                dispose();
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }
    }

    private void exportToPDF() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(new java.io.File("AttendanceReport.pdf"));
            int option = chooser.showSaveDialog(this);
            if (option != JFileChooser.APPROVE_OPTION) return;

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(chooser.getSelectedFile()));
            document.open();

            document.add(new Paragraph("All Employees Attendance Report", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            document.add(new Paragraph(" "));

            PdfPTable pdfTable = new PdfPTable(model.getColumnCount());
            pdfTable.setWidthPercentage(100);

            // Add table headers
            for (int i = 0; i < model.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(model.getColumnName(i)));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                pdfTable.addCell(cell);
            }

            // Add table rows
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col);
                    pdfTable.addCell(value != null ? value.toString() : "");
                }
            }

            document.add(pdfTable);
            document.close();

            JOptionPane.showMessageDialog(this, "PDF generated successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error generating PDF: " + e.getMessage());
        }
    }
}
