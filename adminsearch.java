/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author TOSHIBA
 */
public class adminsearch extends javax.swing.JFrame {

    /**
     * Creates new form admkin
     */
Connection con;
dbhelper db=new dbhelper();
int i;
public static String e_id;
    public adminsearch() {
        initComponents();
        this.setLocationRelativeTo(null);
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        vu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lb2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        vu.setText("STUDENT INFO");
        vu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vuActionPerformed(evt);
            }
        });
        jPanel2.add(vu);
        vu.setBounds(20, 110, 105, 23);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SEARCH");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Age", "Mark"
            }
        ));
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab);

        jScrollPane1.setViewportView(jScrollPane2);

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel3.setText("CLICK  TABLE TO VIEW THE DETAILS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(541, 541, 541))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(140, 40, 690, 460);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SORT BY");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 170, 80, 14);

        r1.setText("ID");
        r1.setEnabled(false);
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });
        jPanel2.add(r1);
        r1.setBounds(20, 190, 70, 23);

        r2.setText("NAME");
        r2.setEnabled(false);
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });
        jPanel2.add(r2);
        r2.setBounds(20, 230, 80, 23);

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(20, 460, 80, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Technology-Powerpoint-Background-Desktop-Wallpaper-07323.jpg"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(-10, -30, 960, 650);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
     DefaultTableModel model=(DefaultTableModel) tab.getModel();
        
     while(i>0)
   {
    model.removeRow(0);
    i--;
   }    
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
      i=0;
      System.out.println(jTextField1.getText());
      String f=jTextField1.getText();
      DefaultTableModel model=(DefaultTableModel) tab.getModel();
  if(jTextField1.getText().isEmpty())
   {
    while(model.getRowCount()>0)
    {
        model.removeRow(0);
    }
   }
   else
  {
      try {
       String f1=f+"%";
        String stmt="select * from det where name like '"+f1+"' ";
        
        ResultSet rs=db.dbcallq(stmt,"anfis");
       
        while(rs.next())
        {  
        i++;
        
        System.out.println(rs.getString(1)+"**");
        String f2="select mark from evalmark where id like '"+rs.getString(1)+"'";
        ResultSet rs1=db.dbcallq(f2,"anfis");
        if(rs1.next())
        {
        Object[] row={rs.getString(1),rs.getString(3),rs.getString(4),rs1.getString(1)};
         model.addRow(row);
        }
        else
        {
         Object[] row={rs.getString(1),rs.getString(3),rs.getString(4),"No marks"};
         model.addRow(row); 
        }
        
      
        }
    } catch (Exception e) {
        System.out.println(e);
 
    }
   }
   
    }//GEN-LAST:event_jTextField1KeyReleased

    private void vuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vuActionPerformed
        // TODO add your handling code here:
       
       DefaultTableModel model1=(DefaultTableModel) tab.getModel();
       while(tab.getRowCount()>i)
       {
        model1.removeRow(0);   
       }
       
       jTextField1.setText(null);
        try
        {
        String stm1="select * from det";
        ResultSet rs=db.dbcallq(stm1,"anfis");
        while(rs.next())
        {  
        i++;
        
        System.out.println(rs.getString(1)+"**");
        String f2="select mark from evalmark where id like '"+rs.getString(1)+"'";
        ResultSet rs1=db.dbcallq(f2,"anfis");
        if(rs1.next())
        {
        Object[] row={rs.getString(1),rs.getString(3),rs.getString(4),rs1.getString(1)};
         model1.addRow(row);
        }
        else
        {
         Object[] row={rs.getString(1),rs.getString(3),rs.getString(4),"No marks"};
         model1.addRow(row); 
        }
        
      
        }
        
        }
        catch(Exception e)
        {
            
        }
        r1.setEnabled(true);
        r2.setEnabled(true);
       
        
    }//GEN-LAST:event_vuActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        // TODO add your handling code here:
        
        r2.setSelected(false);
        
        r1.setSelected(true);
        int i=0;
       DefaultTableModel model1=(DefaultTableModel) tab.getModel();
       while(tab.getRowCount()>i)
       {
        model1.removeRow(0);   
       }
       try
        {
        String stm1="select * from det order by id";
        ResultSet rs=db.dbcallq(stm1,"anfis");
        while(rs.next())
        {  
        i++;
        
        System.out.println(rs.getString(1)+"**");
        String f2="select mark from evalmark where id like '"+rs.getString(1)+"'";
        ResultSet rs1=db.dbcallq(f2,"anfis");
        if(rs1.next())
        {
        Object[] row={rs.getString(1),rs.getString(3),rs.getString(4),rs1.getString(1)};
         model1.addRow(row);
        }
        else
        {
         Object[] row={rs.getString(1),rs.getString(3),rs.getString(4),"No marks"};
         model1.addRow(row); 
        }
        
      
        }
        
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_r1ActionPerformed

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        // TODO add your handling code here:
        r1.setSelected(false);
        r2.setSelected(true);
        int i=0;
       DefaultTableModel model1=(DefaultTableModel) tab.getModel();
       while(tab.getRowCount()>i)
       {
        model1.removeRow(0);   
       }
       try
        {
        String stm1="select * from det order by name";
        ResultSet rs=db.dbcallq(stm1,"anfis");
        while(rs.next())
        {  
        i++;
        
        System.out.println(rs.getString(1)+"**");
        String f2="select mark from evalmark where id like '"+rs.getString(1)+"'";
        ResultSet rs1=db.dbcallq(f2,"anfis");
        if(rs1.next())
        {
        Object[] row={rs.getString(1),rs.getString(3),rs.getString(4),rs1.getString(1)};
         model1.addRow(row);
        }
        else
        {
         Object[] row={rs.getString(1),rs.getString(3),rs.getString(4),"No marks"};
         model1.addRow(row); 
        }
        
      
        }
        
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_r2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      this.setVisible(false);
      
      new admin().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        // TODO add your handling code here:
        int i;
        int j=0;
        i=tab.getSelectedRow();
        String id=tab.getValueAt(i, j).toString();
        user_view ob=new user_view(id);
        ob.setVisible(true);
        ob.fl=1;
                
        
    }//GEN-LAST:event_tabMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[],String usname) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminsearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new train(usname).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lb2;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JTable tab;
    private javax.swing.JButton vu;
    // End of variables declaration//GEN-END:variables
}
