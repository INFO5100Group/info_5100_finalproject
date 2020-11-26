/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Register;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Person.Person;
import Business.Role.RoleType;
import Business.WorkQueue.WorkRequest;
import ConfigSystem.DB4OUtil;
import EcoSystem.DataValidater;
import javax.swing.JPanel;

import EcoSystem.EcoSystem;
import UserInterface.CardLayoutNavigator;
import UserRole.RegAdminRole;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class RegistForEnterpriseJPanel extends javax.swing.JPanel {

    private JPanel container;
    private EcoSystem system;
    /**
     * Creates new form RegisteForEnterpriseJPanel
     * @param system
     * @param container
     */
    public RegistForEnterpriseJPanel(JPanel container, EcoSystem system) {
        initComponents();
        this.container = container;
        this.system = system;
        populateCombo();
    }
    
    public void populateCombo(){
        ComboType.removeAllItems();
        ComboType.addItem("Select your Enterprise Type");// 0
        ComboType.addItem("Regulate Office");// 1
        ComboType.addItem("Forest Logging company");// 2
        ComboType.addItem("Furniture Manufacturer");// 3
        ComboType.addItem("Furniture Retailer");// 4
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegist = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtxName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxState = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxCity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxStreet = new javax.swing.JTextField();
        ComboType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxZipCode = new javax.swing.JTextField();
        jtxUserName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxPWord = new javax.swing.JTextField();

        btnRegist.setText("Regist");
        btnRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistActionPerformed(evt);
            }
        });

        jLabel1.setText("Enterprise Name:");

        jtxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Enterprise Shrot Name:");

        jLabel3.setText("Enterprise Type:");

        jLabel4.setText("City:");

        jLabel5.setText("Street:");

        jLabel6.setText("State:");

        ComboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Admin Password:");

        jLabel8.setText("Admin UserName:");

        jLabel9.setText("Zip Code:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(119, 119, 119)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxZipCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(119, 119, 119)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxStreet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtxState, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jtxPWord, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(btnRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxState, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxCity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxPWord, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistActionPerformed
        if(inputValidate()){
            // create admin for enterprise
            Person newPerson = new Person(jtxName.getText(), "Admin", "Other");
            newPerson.setCity(jtxCity.getText());
            newPerson.setEmail(jtxEmail.getText());
            newPerson.setState(jtxState.getText());
            newPerson.setStreet(jtxStreet.getText());
            newPerson.setZipCode(jtxZipCode.getText());
            // create admin account
            Account newAccount = new Account(jtxUserName.getText(), jtxPWord.getText(), newPerson);
            // create enterprise with admin
            Enterprise newEnterprise = new Enterprise(newAccount); 
            newEnterprise.setName(jtxName.getText());
            newEnterprise.setShortName(jtxEmail.getText());
            // set role for enterpirse admin
            if(ComboType.getSelectedIndex() == 1){
                // role for regulate office
                newAccount.setRole(new RegAdminRole());
            }else if(ComboType.getSelectedIndex() == 2){
                // TODO: foresty compamy    
            }else if(ComboType.getSelectedIndex() == 3){
                // TODO: Manufacturer
            }else if(ComboType.getSelectedIndex() == 4){
                // TODO: retailer
            }
            
            // check enterprise name and account name unique
            boolean addAccountSuccess = system.getAccounts().addAccount(newAccount); 
            
            if(!addAccountSuccess){
                JOptionPane.showMessageDialog(null, newAccount.getAccountName() + " cannot add account, pleanse change to another user name");
                return;
            }
            
            boolean addEnterpirseSuccess = system.getEnterprises().addEnterprise(newEnterprise);
            if(!addEnterpirseSuccess){
                JOptionPane.showMessageDialog(null, newEnterprise.getName() + " cannot add Enterprise, pleanse change to another enterprise name");
                return;
            }
            
            // create request for enterprise
            WorkRequest enterpriseRequest = new WorkRequest();
            enterpriseRequest.setMessage("enterprise regiset for " + jtxName.getText());
            enterpriseRequest.setSender(newAccount);
            enterpriseRequest.setStatus("Procesing");
            for(Account adminAccount : system.getAllAdmins()){ // 所有 sysadmin 设为receiver
                enterpriseRequest.getReceivers().put(adminAccount, false);
            }
            // add request to queue
            try {
                system.getWorkQueue().addRequest(enterpriseRequest);
            } catch (Exception ex) {
                Logger.getLogger(RegistForEnterpriseJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, newEnterprise.getName() + " enterpirse repuest is send to system admin, plase wait for your enterpires appreoved");
            DB4OUtil.storeSystem(system);
            CardLayoutNavigator.goBack(container, this);
            
       }
    }//GEN-LAST:event_btnRegistActionPerformed

    private void jtxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxNameActionPerformed
    private boolean inputValidate(){
        boolean isEmpty = this.jtxName.getText().equals("") ||
                          this.jtxEmail.getText().equals("") ||
                          this.jtxPWord.getText().equals("") ||
                          this.jtxState.getText().equals("") ||
                          this.jtxCity.getText().equals("") ||
                          this.jtxStreet.getText().equals("") ||
                          this.jtxZipCode.getText().equals("") ||
                          this.jtxEmail.getText().equals("");
        if(isEmpty){
            JOptionPane.showMessageDialog(null, "Please fill all text fields");
            return false;
        }
        
        boolean isSelect = this.ComboType.getSelectedIndex() != 0;
        
        if(!isSelect){
            JOptionPane.showMessageDialog(null, "Please Select a Etnerprise type");
            return false;
        }
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboType;
    private javax.swing.JButton btnRegist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jtxCity;
    private javax.swing.JTextField jtxEmail;
    private javax.swing.JTextField jtxName;
    private javax.swing.JTextField jtxPWord;
    private javax.swing.JTextField jtxState;
    private javax.swing.JTextField jtxStreet;
    private javax.swing.JTextField jtxUserName;
    private javax.swing.JTextField jtxZipCode;
    // End of variables declaration//GEN-END:variables

}
