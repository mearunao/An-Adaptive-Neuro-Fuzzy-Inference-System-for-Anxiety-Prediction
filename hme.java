
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dilee
 */
public class hme extends javax.swing.JFrame {

    /**
     * Creates new form hme
     */
    public hme() {
        initComponents();
        this.setLocationRelativeTo(null);
        dbhelper db=new dbhelper();
db.createdb("anfis");
String tb1="create table log (id varchar(20) ,pass varchar(20),primary key(id))";

String tb2="create table dataset(datax int,datay int ,val int)";
String tb3="create table det(id varchar(20),pass varchar(20),name varchar(20),age varchar(20),gen varchar(20),addr varchar(50),email varchar(20),mob varchar(20))";
String tb4="create table evalmark (id varchar(20),mark int)";
String tb5="create table ques(no int,que varchar(100),value int,primary key(no))";
String d1="insert into dataset values(30,23,32)";
String d2="insert into dataset values(10,32,5)";
String d3="insert into dataset values(4,16,18)";
String d4="insert into dataset values(8,36,10)";
String d5="insert into dataset values(15,24,15)";
String d6="insert into dataset values(15,22,23)";
String d7="insert into dataset values(19,32,14)";
String d8="insert into dataset values(10,30,13)";
String d9="insert into dataset values(31,26,50)";

String d10="insert into dataset values(29,30,12)";
String d11="insert into dataset values(22,32,22)";
String d12="insert into dataset values(10,28,8)";
String d13="insert into dataset values(30,20,28)";
String d14="insert into dataset values(25,28,30)";
String d15="insert into dataset values(10,18,20)";
String d16="insert into dataset values(8,10,5)";
String d17="insert into dataset values(30,28,42)";
String d18="insert into dataset values(19,30,16)";

String d19="insert into dataset values(27,22,25)";
String d20="insert into dataset values(10,30,6)";
String d21="insert into dataset values(7,30,10)";
String d22="insert into dataset values(28,22,25)";
String d23="insert into dataset values(34,25,44)";
String d24="insert into dataset values(18,32,36)";
String d25="insert into dataset values(11,27,14)";
String d26="insert into dataset values(24,24,15)";
String d27="insert into dataset values(10,24,2)";

String d28="insert into dataset values(18,12,4)";
String d29="insert into dataset values(36,24,59)";
String d30="insert into dataset values(28,25,30)";
String d31="insert into dataset values(15,18,25)";
String d32="insert into dataset values(28,21,30)";
String d33="insert into dataset values(15,25,28)";
String d34="insert into dataset values(18,25,30)";
String d35="insert into dataset values(17,12,25)";
String d36="insert into dataset values(30,15,28)";




db.dbcallup(tb1,"anfis");
db.dbcallup(tb2,"anfis");
db.dbcallup(tb3,"anfis");
db.dbcallup(tb4,"anfis");
db.dbcallup(tb5,"anfis");
String chk="select * from dataset";
ResultSet rd=db.dbcallq(chk,"anfis");
try
{
if(rd.next())
{  
}
else
{
    
db.dbcallup(d1,"anfis");
db.dbcallup(d2,"anfis");
db.dbcallup(d3,"anfis");
db.dbcallup(d4,"anfis");
db.dbcallup(d5,"anfis");
db.dbcallup(d6,"anfis");
db.dbcallup(d7,"anfis");
db.dbcallup(d8,"anfis");
db.dbcallup(d9,"anfis");
db.dbcallup(d10,"anfis");
db.dbcallup(d11,"anfis");
db.dbcallup(d12,"anfis");
db.dbcallup(d13,"anfis");
db.dbcallup(d14,"anfis");
db.dbcallup(d15,"anfis");
db.dbcallup(d16,"anfis");
db.dbcallup(d17,"anfis");
db.dbcallup(d18,"anfis");
db.dbcallup(d19,"anfis");
db.dbcallup(d20,"anfis");
db.dbcallup(d21,"anfis");
db.dbcallup(d22,"anfis");
db.dbcallup(d23,"anfis");
db.dbcallup(d24,"anfis");
db.dbcallup(d25,"anfis");
db.dbcallup(d26,"anfis");
db.dbcallup(d27,"anfis");
db.dbcallup(d28,"anfis");
db.dbcallup(d29,"anfis");
db.dbcallup(d30,"anfis");
db.dbcallup(d31,"anfis");
db.dbcallup(d32,"anfis");
db.dbcallup(d33,"anfis");
db.dbcallup(d34,"anfis");
db.dbcallup(d35,"anfis");
db.dbcallup(d36,"anfis");
}

}
catch(Exception e)
{
    
}


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(null);

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setText("ENTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(110, 180, 110, 23);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("ANXIETY EVALUATOR");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 20, 290, 42);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abstract-geometric-shapes-background_23-2147489803.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 340, 300);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new hme2().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(hme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
