
package employee.management.system;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

// ... (imports remain unchanged)

public class ScanQRCodeAttendance extends JFrame {

    private Webcam webcam;
    private boolean running = true;

    public ScanQRCodeAttendance() {
        setTitle("QR Code Attendance Scanner");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            webcam = Webcam.getDefault();
            if (webcam == null) {
                throw new RuntimeException("No webcam detected. Please connect a webcam.");
            }

            WebcamPanel panel = new WebcamPanel(webcam);
            panel.setMirrored(true);
            add(panel);

            new Thread(this::scanLoop).start();
            setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Webcam initialization failed:\n" + e.getMessage());
            dispose();
        }
    }

    private void scanLoop() {
        while (running) {
            BufferedImage image = webcam.getImage();
            if (image != null) {
                try {
                    LuminanceSource source = new BufferedImageLuminanceSource(image);
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                    Result result = new MultiFormatReader().decode(bitmap);
                    if (result != null) {
                        handleAttendance(result.getText());
                        break;
                    }
                } catch (NotFoundException ignored) {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private void handleAttendance(String qrData) {
        try {
            String employeeId = null;

            if (qrData.contains("ID:")) {
                employeeId = qrData.split("ID:")[1].split(",")[0].trim();
            }

            if (employeeId == null) {
                JOptionPane.showMessageDialog(this, "Invalid QR Code!");
                return;
            }

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform", "root", "Aamir12345");
            String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            LocalTime now = LocalTime.now();
            LocalTime checkInStart = LocalTime.of(9, 0);
            LocalTime checkInEnd = LocalTime.of(12, 0);
            LocalTime lateMarkTime = LocalTime.of(9, 15);
            LocalTime halfDayTime = LocalTime.of(10, 0);
            LocalTime checkoutStart = LocalTime.of(12, 0);
            LocalTime checkoutEarlyLimit = LocalTime.of(14, 30);
            LocalTime checkoutEnd = LocalTime.of(16, 30);

            PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM attendance_desktop WHERE employee_id = ? AND date = ?");
            checkStmt.setString(1, employeeId);
            checkStmt.setString(2, today);
            ResultSet rs = checkStmt.executeQuery();

            if (now.isAfter(checkInStart) && now.isBefore(checkInEnd)) {
                // ✅ Check-In Logic
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Check-in already marked. Scanning again will mark checkout (if eligible).");
                } else {
                    String status;
                    String checkInNote;

                    if (now.isBefore(lateMarkTime)) {
                        status = "Present";
                        checkInNote = now.toString();
                    } else if (now.isBefore(halfDayTime)) {
                        status = "Present (Late Check-in)";
                        checkInNote = "Late - " + now.toString();
                    } else {
                        status = "Half Day Present";
                        checkInNote = "Late - " + now.toString();
                    }

                    PreparedStatement insertStmt = con.prepareStatement( "INSERT INTO attendance_desktop (employee_id, date, checkin_time, status) VALUES (?, ?, ?, ?)"
                    );
                    insertStmt.setString(1, employeeId);
                    insertStmt.setString(2, today);
                    insertStmt.setString(3, checkInNote);
                    insertStmt.setString(4, status);
                    insertStmt.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Hello " + employeeId + ", you are marked as: " + status);
                }

            } else if (now.isAfter(checkoutStart) && now.isBefore(checkoutEnd)) {
                // ✅ Checkout Logic
                if (rs.next()) {
                    String status = rs.getString("status");
                    Time checkoutTime = rs.getTime("checkout_time");

                    if (checkoutTime == null) {
                        // Mark checkout
                        PreparedStatement updateStmt = con.prepareStatement("UPDATE attendance_desktop SET checkout_time = ?, status = ? WHERE employee_id = ? AND date = ?"
                        );

                        String updatedStatus = status;
                        if (now.isBefore(checkoutEarlyLimit)) {
                            updatedStatus = "Half Day Present";
                        }

                        updateStmt.setTime(1, Time.valueOf(now));
                        updateStmt.setString(2, updatedStatus);
                        updateStmt.setString(3, employeeId);
                        updateStmt.setString(4, today);
                        updateStmt.executeUpdate();

                        JOptionPane.showMessageDialog(this, "Checkout successful for " + employeeId);
                    } else {
                        JOptionPane.showMessageDialog(this, "Checkout already marked.");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Please check-in first before checkout.");
                }

            } else if (now.isAfter(checkInEnd)) {
                JOptionPane.showMessageDialog(this, "Check-in not allowed after 12:00 PM.");
            } else {
                JOptionPane.showMessageDialog(this, "Attendance can only be marked between 9:00 AM and 4:30 PM.");
            }

            con.close();
            running = false;
            webcam.close();
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ScanQRCodeAttendance();
    }
}
