/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Assignment6View;

import Assignment6Model.BankAccount;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author karunmehta
 */
public class AccountList extends javax.swing.JFrame {

    /**
     * Creates new form AccountList
     */
    public AccountList() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        details = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        accListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bankAccList = new javax.swing.JList<>();
        TitleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(10, 5));

        TitleLabel.setText("List of Bank Accounts:");
        accListLabel.setText("Account List:");
        cancel.setText("cancel");
        details.setText("Show Account Details");
        //opens new accountdetails GUI
        details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              AccountDetail.setaccountSelected((BankAccount)
                      BankAccountList.get(selectedAccIndex));
              new AccountDetail().setVisible(true);
            }
        });

        //assigns the bankAccoutList arraylist to the jList frame
        bankAccList.setModel(new javax.swing.AbstractListModel<>() {
            ArrayList t = BankAccountList;
            public int getSize() { return t.size(); }
            public String getElementAt(int i) { return t.get(i).toString(); }
        });
        //assigns a value to selectedAccIndex so we can identiy which
        //obj in the list has been selected
        bankAccList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    selectedAccIndex = bankAccList.getSelectedIndex();
                }
            }
        });

        jScrollPane1.setViewportView(bankAccList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(89, 89, 89)
                                                .addComponent(details)
                                                .addGap(68, 68, 68)
                                                .addComponent(cancel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(accListLabel)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(17, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(TitleLabel)
                                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(TitleLabel)
                                .addGap(13, 13, 13)
                                .addComponent(accListLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(details)
                                        .addComponent(cancel))
                                .addGap(15, 15, 15))
        );

        pack();

    }

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
            java.util.logging.Logger.getLogger(AccountList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JList<String> bankAccList;
    private javax.swing.JButton details;
    private javax.swing.JLabel accListLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JScrollPane jScrollPane1;
    public static ArrayList BankAccountList = new ArrayList();
    public static void setBankAccountList(ArrayList l){
       BankAccountList = l;
    }
    public static int selectedAccIndex;

    // End of variables declaration//GEN-END:variables
}
