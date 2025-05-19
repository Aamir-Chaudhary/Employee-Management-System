package employee.management.system;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewUpdate extends JFrame {
   private JButton btncancel;
   private JButton btnsearch;
   private JLabel jLabel1;
   private JLabel lblemployeeid;
   private JTextField txtemployeeid;

   public ViewUpdate() {
      this.initComponents();
      this.setResizable(false);
   }

   private void initComponents() {
      this.lblemployeeid = new JLabel();
      this.txtemployeeid = new JTextField();
      this.btnsearch = new JButton();
      this.btncancel = new JButton();
      this.jLabel1 = new JLabel();
      this.setDefaultCloseOperation(3);
      this.getContentPane().setLayout((LayoutManager)null);
      this.lblemployeeid.setFont(new Font("Times New Roman", 1, 24));
      this.lblemployeeid.setText("Employee Id");
      this.getContentPane().add(this.lblemployeeid);
      this.lblemployeeid.setBounds(10, 70, 150, 40);
      this.txtemployeeid.setFont(new Font("Times New Roman", 0, 18));
      this.txtemployeeid.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            ViewUpdate.this.txtemployeeidActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.txtemployeeid);
      this.txtemployeeid.setBounds(190, 70, 200, 30);
      this.btnsearch.setFont(new Font("Times New Roman", 1, 18));
      this.btnsearch.setText("Search");
      this.btnsearch.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            ViewUpdate.this.btnsearchMouseMoved(evt);
         }
      });
      this.btnsearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            ViewUpdate.this.btnsearchActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.btnsearch);
      this.btnsearch.setBounds(190, 200, 90, 29);
      this.btncancel.setFont(new Font("Times New Roman", 1, 18));
      this.btncancel.setText("Cancel");
      this.btncancel.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            ViewUpdate.this.btncancelMouseMoved(evt);
         }
      });
      this.btncancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            ViewUpdate.this.btncancelActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.btncancel);
      this.btncancel.setBounds(300, 200, 90, 29);
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/employee/management/system/project icons/pexels-photo.jpg")));
      this.getContentPane().add(this.jLabel1);
      this.jLabel1.setBounds(0, 0, 436, 276);
      this.setSize(new Dimension(450, 313));
      this.setLocationRelativeTo((Component)null);
   }

   private void txtemployeeidActionPerformed(ActionEvent evt) {
   }

   private void btnsearchActionPerformed(ActionEvent evt) {
      try {
         if (this.txtemployeeid.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Employee Id");
            this.txtemployeeid.grabFocus();
            return;
         }

         if (!Pattern.matches("^[0-9]+$", this.txtemployeeid.getText())) {
            JOptionPane.showMessageDialog(this, "Invalid Input, Accept numbers only ", "Invalid Employee Id", 1);
            this.txtemployeeid.setText((String)null);
            this.txtemployeeid.grabFocus();
            return;
         }

         Long eEmployeeId = Long.parseLong(this.txtemployeeid.getText());
         if (eEmployeeId > 0L) {
            this.setVisible(false);
            UpdateEmployeeDetails q = new UpdateEmployeeDetails(this.txtemployeeid.getText());
            q.setVisible(true);
         } else {
            JOptionPane.showMessageDialog((Component)null, "Enter a valid Id");
         }
      } catch (NumberFormatException | HeadlessException var4) {
         JOptionPane.showMessageDialog(this.rootPane, var4);
      }

   }

   private void btnsearchMouseMoved(MouseEvent evt) {
      this.btnsearch.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void btncancelMouseMoved(MouseEvent evt) {
      this.btncancel.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void btncancelActionPerformed(ActionEvent evt) {
      this.dispose();
   }
}
