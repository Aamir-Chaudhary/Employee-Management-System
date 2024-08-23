package employee.management.system;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EmployeeDetail extends JFrame {
   private JButton jButton1;
   private JButton jButton2;
   private JButton jButton3;
   private JButton jButton4;
   private JButton jButton5;
   private JLabel jLabel1;
   private JLabel jLabel2;

   public EmployeeDetail() {
      this.initComponents();
      this.setResizable(false);
   }

   private void initComponents() {
      this.jButton4 = new JButton();
      this.jButton1 = new JButton();
      this.jButton2 = new JButton();
      this.jLabel2 = new JLabel();
      this.jButton5 = new JButton();
      this.jButton3 = new JButton();
      this.jLabel1 = new JLabel();
      this.setDefaultCloseOperation(3);
      this.setTitle("Employee Details");
      this.getContentPane().setLayout((LayoutManager)null);
      this.jButton4.setFont(new Font("Times New Roman", 1, 24));
      this.jButton4.setText("Update");
      this.jButton4.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            EmployeeDetail.this.jButton4MouseMoved(evt);
         }
      });
      this.jButton4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            EmployeeDetail.this.jButton4ActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.jButton4);
      this.jButton4.setBounds(620, 130, 120, 40);
      this.jButton1.setFont(new Font("Times New Roman", 1, 24));
      this.jButton1.setText("Add");
      this.jButton1.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            EmployeeDetail.this.jButton1MouseMoved(evt);
         }
      });
      this.jButton1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            EmployeeDetail.this.jButton1ActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.jButton1);
      this.jButton1.setBounds(480, 70, 120, 40);
      this.jButton2.setFont(new Font("Times New Roman", 1, 24));
      this.jButton2.setText("View");
      this.jButton2.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            EmployeeDetail.this.jButton2MouseMoved(evt);
         }
      });
      this.jButton2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            EmployeeDetail.this.jButton2ActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.jButton2);
      this.jButton2.setBounds(620, 70, 120, 40);
      this.jLabel2.setFont(new Font("Times New Roman", 1, 36));
      this.jLabel2.setText("Employee Details");
      this.getContentPane().add(this.jLabel2);
      this.jLabel2.setBounds(470, 10, 290, 50);
      this.jButton5.setFont(new Font("Times New Roman", 0, 12));
      this.jButton5.setText("Home");
      this.jButton5.setBorderPainted(false);
      this.jButton5.setContentAreaFilled(false);
      this.jButton5.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            EmployeeDetail.this.jButton5MouseMoved(evt);
         }
      });
      this.jButton5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            EmployeeDetail.this.jButton5ActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.jButton5);
      this.jButton5.setBounds(0, 0, 61, 20);
      this.jButton3.setFont(new Font("Times New Roman", 1, 24));
      this.jButton3.setText("Remove");
      this.jButton3.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            EmployeeDetail.this.jButton3MouseMoved(evt);
         }
      });
      this.jButton3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            EmployeeDetail.this.jButton3ActionPerformed(evt);
         }
      });
      this.getContentPane().add(this.jButton3);
      this.jButton3.setBounds(480, 130, 120, 40);
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/employee/management/system/project icons/ballpen-blur-close-up-461077-1.jpg")));
      this.getContentPane().add(this.jLabel1);
      this.jLabel1.setBounds(0, 0, 834, 531);
      this.setSize(new Dimension(848, 568));
      this.setLocationRelativeTo((Component)null);
   }

   private void jButton1ActionPerformed(ActionEvent evt) {
      (new AddEmployee()).setVisible(true);
   }

   private void jButton2ActionPerformed(ActionEvent evt) {
      (new View()).setVisible(true);
   }

   private void jButton3ActionPerformed(ActionEvent evt) {
      (new RemoveEmployee()).setVisible(true);
   }

   private void jButton5MouseMoved(MouseEvent evt) {
      this.jButton5.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void jButton1MouseMoved(MouseEvent evt) {
      this.jButton1.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void jButton2MouseMoved(MouseEvent evt) {
      this.jButton2.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void jButton3MouseMoved(MouseEvent evt) {
      this.jButton3.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void jButton4MouseMoved(MouseEvent evt) {
      this.jButton4.setCursor(Cursor.getPredefinedCursor(12));
   }

   private void jButton5ActionPerformed(ActionEvent evt) {
      this.dispose();
      (new loginform()).setVisible(true);
   }

   private void jButton4ActionPerformed(ActionEvent evt) {
      (new ViewUpdate()).setVisible(true);
   }
}
