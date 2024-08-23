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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public class View extends JFrame {
   private JButton btnCancel;
   private JButton btnSearch;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JPanel jPanel1;
   private JLabel lblEmployeeId;
   private JTextField txtEmployeeId;

   public View() {
      this.initComponents();
      this.setResizable(false);
   }

   private void initComponents() {
      this.jLabel1 = new JLabel();
      this.jPanel1 = new JPanel();
      this.btnSearch = new JButton();
      this.lblEmployeeId = new JLabel();
      this.txtEmployeeId = new JTextField();
      this.btnCancel = new JButton();
      this.jLabel2 = new JLabel();
      this.jLabel1.setText("jLabel1");
      this.setDefaultCloseOperation(3);
      this.setTitle("View");
      this.jPanel1.setLayout((LayoutManager)null);
      this.btnSearch.setFont(new Font("Times New Roman", 1, 18));
      this.btnSearch.setText("Search");
      this.btnSearch.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            View.this.btnSearchMouseMoved(evt);
         }
      });
      this.btnSearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            View.this.btnSearchActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.btnSearch);
      this.btnSearch.setBounds(190, 170, 90, 30);
      this.lblEmployeeId.setFont(new Font("Times New Roman", 1, 24));
      this.lblEmployeeId.setHorizontalAlignment(0);
      this.lblEmployeeId.setText("Employee Id");
      this.jPanel1.add(this.lblEmployeeId);
      this.lblEmployeeId.setBounds(0, 60, 170, 40);
      this.txtEmployeeId.setFont(new Font("Times New Roman", 0, 18));
      this.jPanel1.add(this.txtEmployeeId);
      this.txtEmployeeId.setBounds(190, 60, 220, 30);
      this.btnCancel.setFont(new Font("Times New Roman", 1, 18));
      this.btnCancel.setText("Cancel");
      this.btnCancel.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            View.this.btnCancelMouseMoved(evt);
         }
      });
      this.btnCancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            View.this.btnCancelActionPerformed(evt);
         }
      });
      this.jPanel1.add(this.btnCancel);
      this.btnCancel.setBounds(320, 170, 90, 29);
      this.jLabel2.setHorizontalAlignment(0);
      this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/employee/management/system/project icons/pexels-photo.jpg")));
      this.jPanel1.add(this.jLabel2);
      this.jLabel2.setBounds(0, 0, 440, 280);
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
      this.setSize(new Dimension(450, 313));
      this.setLocationRelativeTo((Component)null);
   }

   private void btnCancelActionPerformed(ActionEvent evt) {
      this.dispose();
   }

   private void btnSearchActionPerformed(ActionEvent evt) {
      try {
         if (this.txtEmployeeId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Employee Id");
            this.txtEmployeeId.grabFocus();
            return;
         }

         if (!Pattern.matches("^[0-9]+$", this.txtEmployeeId.getText())) {
            JOptionPane.showMessageDialog(this, "Invalid Input, Accept numbers only ", "Invalid Employee Id", 1);
            this.txtEmployeeId.setText((String)null);
            this.txtEmployeeId.grabFocus();
            return;
         }

         Long eEmployeeId = Long.parseLong(this.txtEmployeeId.getText());
         if (eEmployeeId > 0L) {
            this.setVisible(false);
            RetriveDetails rd = new RetriveDetails(this.txtEmployeeId.getText());
            rd.setVisible(true);
         } else {
            JOptionPane.showMessageDialog((Component)null, "Enter a valid Id");
         }
      } catch (NumberFormatException | HeadlessException var4) {
         JOptionPane.showMessageDialog(this.rootPane, var4);
      }

   }

   private void btnSearchMouseMoved(MouseEvent evt) {
      this.btnSearch.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void btnCancelMouseMoved(MouseEvent evt) {
      this.btnCancel.setCursor(Cursor.getPredefinedCursor(12));
   }
}
