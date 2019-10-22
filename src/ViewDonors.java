
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Himanshu
 */
public class ViewDonors extends javax.swing.JFrame {

    /**
     * Creates new form ViewDonors
     */
     Connection con;
    PreparedStatement ps;
    Statement stmt;
    DefaultTableModel model;
    public ViewDonors() {
        initComponents();
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            //JOptionPane.showMessageDialog(this,"Driver Loaded...");
            try
            {
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");
                //JOptionPane.showMessageDialog(null,"Connection Established...");
            }
            catch(SQLException ex)
            {
                System.out.println("Connection Not Established");
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Driver Not Loaded");
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        try
        {  
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            String name; 
            long phnum;
            String amount;
            String sql = "Select * from donation";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
           try{ 
            //JOptionPane.showMessageDialog(this,"working");
            while(rs.next()){
                //JOptionPane.showMessageDialog(this,"working1");
                name = rs.getString("Name");
                phnum = rs.getLong("phnum");
                amount = rs.getString("amount");
                
                //System.out.println(name+" "+quantity);
                model.insertRow(model.getRowCount(), new Object[]{name,phnum,amount});
            }
            
           }catch(Exception e){
               JOptionPane.showMessageDialog(this,"Not working\nerror: "+e.getMessage());
           }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Phone Number", "Donation Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//                try
//        {  
//            model = (DefaultTableModel) jTable1.getModel();
//            model.setRowCount(0);
//            String name; 
//            int phnum;
//            int amount;
//            String sql = "Select * from donation";
//            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = stmt.executeQuery(sql);
//           try{ 
//            //JOptionPane.showMessageDialog(this,"working");
//            while(rs.next()){
//               // JOptionPane.showMessageDialog(this,"working1");
//                name = rs.getString("Name");
//                phnum = rs.getInt("phnum");
//                amount = rs.getInt("amount");
//                
//                //System.out.println(name+" "+quantity);
//                model.insertRow(model.getRowCount(), new Object[]{name,phnum,amount});
//            }
//            
//           }catch(Exception e){
//               JOptionPane.showMessageDialog(this,"Not working");
//           }
//        }
//        catch(SQLException e)
//        {
//            JOptionPane.showMessageDialog(null,e.getMessage());
//        }

AdminForm a = new AdminForm();
dispose();
a.setVisible(true);

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
            java.util.logging.Logger.getLogger(ViewDonors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDonors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDonors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDonors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDonors().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
