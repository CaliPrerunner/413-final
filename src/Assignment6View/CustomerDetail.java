/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Assignment6View;

import Assignment6Controller.BankAccountDTO;
import Assignment6Controller.CustomerDTO;
import Assignment6Model.BankAccount;
import Assignment6Model.BankCustomer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author karunmehta
 */
public class CustomerDetail extends javax.swing.JFrame {

    /**
     * Creates new form CustomerDetail
     */
    public CustomerDetail() {
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

        CustDetailLabel = new javax.swing.JLabel();
        FirstNameBox = new javax.swing.JTextField();
        LastNameBox = new javax.swing.JTextField();
        emailBox = new javax.swing.JTextField();
        phoneBox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bankAccList = new javax.swing.JList<>();
        firstNameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        accountLabel = new javax.swing.JLabel();
        actDetail = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        addressLabel = new javax.swing.JLabel();
        addressbox = new javax.swing.JTextField();
        updateAddress = new javax.swing.JButton();
        saveButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CustDetailLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        CustDetailLabel.setText("Customer Detail");

        //the core data that cannot be change by the customer is not changeable by the setEditable(false); method
        FirstNameBox.setText(selectedCust.getFirstName());
        FirstNameBox.setEditable(false);
        LastNameBox.setText(selectedCust.getLastName());
        LastNameBox.setEditable(false);
        emailBox.setText(selectedCust.getEmail());
        saveButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailandPhoneBoxAction(evt);
            }
        });
        phoneBox.setText(selectedCust.getPhone());

        addressbox.setText(selectedCust.getAddress().toString());
        addressbox.setEditable(false);

        bankAccList.setModel(new javax.swing.AbstractListModel<>() {
             ArrayList t = selectedCust.getAccounts();
            public int getSize() { return t.size(); }
            public String getElementAt(int i) { return t.get(i).toString(); }
        });
        jScrollPane1.setViewportView(bankAccList);

        firstNameLabel.setText("First Name:");

        LastNameLabel.setText("Last Name:");

        emailLabel.setText("Email:");

        phoneLabel.setText("Phone:");

        accountLabel.setText("Accounts:");

        actDetail.setText("Show Account");

        addressLabel.setText("Address: ");

        updateAddress.setText("Update Address");
        saveButt.setText("Update Customer Details");

        updateAddress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //opens address GUI to display the account details
                CustomerAddressView.setCustAddy(selectedCust.getAddress());
                new CustomerAddressView().setVisible(true);

            }
        });

        actDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actDetailActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        //resets the data in the text feild boxes
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emailBox.setText(selectedCust.getEmail());
                phoneBox.setText(selectedCust.getPhone());
            }
        });

        //gets the index of the bank account selected in the JList object
        //allows the user to select a cusomter from the list and open it
        bankAccList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    selectedAccIndex = bankAccList.getSelectedIndex();
                }
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(CustDetailLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(accountLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(firstNameLabel)
                                        .addComponent(addressLabel)
                                    .addComponent(emailLabel))

                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FirstNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addressbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(phoneLabel)
                                        .addGap(18, 18, 18)

                                        .addComponent(phoneBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LastNameLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LastNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                //.addGap(26, 26, 26)
                            ))))
                .addGap(30, 30, 30)
            )
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(actDetail)
                    //added
//                    .addGroup(layout.createSequentialGroup())
//                            .addComponent(addressLabel)
//                            .addComponent(addressbox, javax.swing.GroupLayout.PREFERRED_SIZE,
//                                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//
                    .addGap(73, 73, 73)
                .addComponent(cancel)
                    .addGap(73, 73, 73)
                    .addComponent(updateAddress)
                    .addGap(73, 73, 73)
                    .addComponent(saveButt)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

                layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(CustDetailLabel)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LastNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameLabel)
                                .addComponent(LastNameLabel))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLabel)
                                .addComponent(phoneLabel)))
                        .addGroup(layout.createSequentialGroup()
                        .addComponent(FirstNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(emailBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    //added
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel)
                            .addComponent(addressbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                    .addGap(9, 9, 9)
                .addComponent(accountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actDetail)
                    .addComponent(cancel)
                        .addComponent(updateAddress)
                        .addComponent(saveButt))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Account Detail button opens AccountList.java and passes the bankaccount list variable
    private void actDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actDetailActionPerformed
        // TODO add your handling code here:
        BankAccountDTO getter = new BankAccountDTO();
        ArrayList b = getter.BankAccountByCustID(selectedCust.getCustomerID());
        AccountDetail.setaccountSelected((BankAccount) (b.get(selectedAccIndex)));
        new AccountDetail().setVisible(true);
    }//GEN-LAST:event_actDetailActionPerformed

    //action when user presses enter into email box
    private void EmailandPhoneBoxAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:

        //if the strings in either of the email/phone text boxes do not match the data in the seleted customer,
        //then update them in the selectedCustomer object and update the mySQL database with it
        if((!selectedCust.getEmail().equals(emailBox.getText())) || (!selectedCust.getPhone().equals(phoneBox.getText()))) {
            selectedCust.setEmail(emailBox.getText());
            selectedCust.setPhone(phoneBox.getText());
            CustomerDTO setter = new CustomerDTO();
            int r = setter.performUpdate(selectedCust);
            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Customer update was Successful");
            }else{
                JOptionPane.showMessageDialog(null, "Customer update was Unsuccessful");
            }
        }



    }//GEN-LAST:event_jTextField2ActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerDetail().setVisible(true);
            }
        });
    }

    public static void setSelectedCust(BankCustomer c){
        selectedCust = c;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actDetail;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel CustDetailLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel accountLabel;
    private javax.swing.JList<String> bankAccList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField FirstNameBox;
    private javax.swing.JTextField LastNameBox;
    private javax.swing.JTextField emailBox;
    private javax.swing.JTextField phoneBox;

    //Personal Add-in's
    private javax.swing.JTextField addressbox;
    private javax.swing.JLabel addressLabel;
    public static BankCustomer selectedCust;
    public static ArrayList transList;
    public javax.swing.JButton updateAddress;
    public javax.swing.JButton saveButt;
    public static int selectedAccIndex;


    // End of variables declaration//GEN-END:variables
}
