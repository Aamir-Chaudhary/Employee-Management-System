package employee.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Frontpage extends JFrame {
   Timer tm;
   Timer tm1;
   Timer tm2;
   int a;
   int b;
   private JButton jButton1;
   private JLabel jLabel1;
   private JPanel jPanel1;
   private JProgressBar jProgressBar1;
   private JLabel lblMarquee;

   public Frontpage() {
      this.initComponents();
      this.a = this.lblMarquee.getX();
      this.b = this.lblMarquee.getY();
      this.tm = new Timer(100, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Frontpage.this.tm_Tick(e);
         }
      });
      this.tm1 = new Timer(500, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Frontpage.this.tm1_Tick(e);
         }
      });
      this.tm.start();
      this.setResizable(true);
      this.setAlwaysOnTop(true);
      Toolkit tk = Toolkit.getDefaultToolkit();
      int xsize = (int)tk.getScreenSize().getWidth();
      int ysize = (int)tk.getScreenSize().getHeight();
      Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
      int taskBarSize = scnMax.bottom;
      this.setSize(xsize, ysize - taskBarSize);
      this.jProgressBar1.setVisible(false);
   }

         protected void tm_Tick(ActionEvent e) {
    if (this.a > this.getWidth()) {
        this.a = -this.lblMarquee.getWidth();
    } else {
        this.a += 5;
    }

    this.lblMarquee.setLocation(this.a, this.b);
}




   protected void tm1_Tick(ActionEvent e) {
   }

   protected void tm2_Tick(ActionEvent e) {
      if (this.jProgressBar1.getValue() < this.jProgressBar1.getMaximum()) {
         this.jProgressBar1.setValue(this.jProgressBar1.getValue() + 5);
      } else {
         this.tm2.stop();
         this.setVisible(false);
         (new loginform()).setVisible(true);
      }

   }

   private void initComponents() {
      this.jPanel1 = new JPanel();
      this.lblMarquee = new JLabel();
      this.jButton1 = new JButton();
      this.jProgressBar1 = new JProgressBar();
      this.jLabel1 = new JLabel();
      this.setDefaultCloseOperation(3);
      this.setTitle("Employee Management System");
      this.setBounds(new Rectangle(0, 0, 0, 0));
      this.setCursor(new Cursor(0));
      this.setResizable(false);
      this.getContentPane().setLayout(new GridBagLayout());
      this.jPanel1.setOpaque(false);
      this.lblMarquee.setFont(new Font("Serif", 1, 48));
      this.lblMarquee.setForeground(new Color(255, 0, 0));
      this.lblMarquee.setHorizontalAlignment(4);
      this.lblMarquee.setText("        Employee  Management  System");
      this.lblMarquee.setVerticalAlignment(1);
      this.lblMarquee.setAlignmentX(0.5F);
      this.jButton1.setBackground(new Color(0, 0, 0));
      this.jButton1.setFont(new Font("Times New Roman", 1, 18));
      this.jButton1.setForeground(new Color(255, 255, 255));
      this.jButton1.setText("Click Here to Continue");
      this.jButton1.setToolTipText("");
      this.jButton1.setAlignmentX(0.5F);
      this.jButton1.setAutoscrolls(true);
      this.jButton1.setBorderPainted(false);
      this.jButton1.setFocusPainted(false);
      this.jButton1.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseMoved(MouseEvent evt) {
            Frontpage.this.jButton1MouseMoved(evt);
         }
      });
      this.jButton1.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            Frontpage.this.jButton1MouseClicked(evt);
         }
      });
      this.jButton1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Frontpage.this.jButton1ActionPerformed(evt);
         }
      });
      this.jProgressBar1.setBackground(SystemColor.desktop);
      this.jProgressBar1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 255)));
      GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
      this.jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
               .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                     .addGap(290, 290, 290)
                     .addComponent(this.lblMarquee))
                  .addGroup(jPanel1Layout.createSequentialGroup()
                     .addGap(646, 646, 646)
                     .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(this.jProgressBar1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
               .addContainerGap(353, 32767))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
               .addComponent(this.lblMarquee, -2, 72, -2)
               .addPreferredGap(ComponentPlacement.RELATED, 326, 32767)
               .addComponent(this.jButton1, -2, 37, -2)
               .addPreferredGap(ComponentPlacement.RELATED)
               .addComponent(this.jProgressBar1, -2, 20, -2)
               .addGap(256, 256, 256))
      );
      GridBagConstraints gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 1;
      gridBagConstraints.gridy = 1;
      gridBagConstraints.fill = 1;
      this.getContentPane().add(this.jPanel1, gridBagConstraints);
      this.jLabel1.setHorizontalAlignment(11);
      this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/employee/management/system/project icons/Untitled.png")));
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 1;
      gridBagConstraints.gridy = 1;
      gridBagConstraints.fill = 1;
      this.getContentPane().add(this.jLabel1, gridBagConstraints);
      this.setBounds(0, 0, 910, 503);
   }

   private void jButton1ActionPerformed(ActionEvent evt) {
      this.tm2 = new Timer(100, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Frontpage.this.tm2_Tick(e);
         }
      });
      if (this.jProgressBar1.getValue() < this.jProgressBar1.getMaximum()) {
         this.jProgressBar1.setValue(this.jProgressBar1.getValue() + 1);

      } else {
         this.tm2.stop();
         this.setVisible(false);
         (new loginform()).setVisible(true);
      }

      this.tm2.start();
   }

   private void jButton1MouseClicked(MouseEvent evt) {
      this.jProgressBar1.setVisible(true);
   }

   private void jButton1MouseMoved(MouseEvent evt) {
      this.jButton1.setCursor(Cursor.getPredefinedCursor(12));
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Frontpage().setVisible(true);
         }
      });
   }
}
