/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Register;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import System.AccountRole.ForestAdminRole;
import System.AccountRole.LogisticAdminRole;
import System.AccountRole.ManuAdminRole;
import System.AccountRole.RegAdminRole;
import System.AccountRole.RetailAdminRole;
import System.Configure.DB4OUtil;
import UserInterface.CardLayoutNavigator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class RegistForRegulateDepartment extends javax.swing.JPanel {
    private JPanel container;
    private EcoSystem system;           
    /**
     * Creates new form RegistForRegulateDepartment
     */
    public RegistForRegulateDepartment(JPanel container, EcoSystem system) {
        initComponents();
        this.container = container;
        this.system = system;
        setButtonImage();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxState = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxPWord = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxStreet = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnRegist = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtxName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtxEmail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtxZipCode = new javax.swing.JTextField();
        jtxUserName = new javax.swing.JTextField();
        btnOut = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel9.setText("Zip Code:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel6.setText("Street:");

        jLabel10.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel10.setText("State:");

        jLabel11.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel11.setText("Department Name:");

        btnRegist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel7.setText("Admin Password:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel3.setText("Department Email:");

        jLabel8.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel8.setText("Admin UserName:");

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jLabel18.setText("Regist As Department");

        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(876, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtxPWord, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(119, 119, 119)
                                        .addComponent(jtxUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtxZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(161, 161, 161))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(119, 119, 119)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtxName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtxState, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtxStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)))))
                        .addGap(71, 71, 71)))
                .addGap(115, 115, 115)
                .addComponent(btnOut))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxState, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxPWord, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(64, 64, 64)
                .addComponent(btnRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void setButtonImage(){
         ImageIcon imageIcon=new ImageIcon("./image/regist.png");
         btnRegist.setIcon(imageIcon);
         ImageIcon out=new ImageIcon("./image/红叉 (2)_1.png");
         btnOut.setIcon(out);
    }
    private void btnRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistActionPerformed
      if(inputValidate()){
            // create admin for enterprise
            Person newPerson = new Person(jtxName.getText(), "Admin", "Other");
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
            // create department for different types of enterprise
            
             newAccount.setRole(new RegAdminRole());
             newEnterprise.getDepartments().addOrganization(new Organization("Enviromental Regulatory Organization"));
            
            
            // check enterprise name and account name unique
            boolean addAccountSuccess = system.getAccounts().addAccount(newAccount); 
            
            if(!addAccountSuccess){
                JOptionPane.showMessageDialog(null, newAccount.getAccountName() + " cannot add account, please change to another user name");
                return;
            }
            
            boolean addEnterpirseSuccess = system.getEnterprises().addEnterprise(newEnterprise);
            if(!addEnterpirseSuccess){
                JOptionPane.showMessageDialog(null, newEnterprise.getName() + " cannot add Enterprise, please change to another enterprise name");
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

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        CardLayoutNavigator.logout(container, this);
    }//GEN-LAST:event_btnOutActionPerformed
    private boolean inputValidate(){
        boolean isEmpty = this.jtxName.getText().equals("") ||
                          this.jtxEmail.getText().equals("") ||
                          this.jtxPWord.getText().equals("") ||
                          this.jtxState.getText().equals("") ||
                          this.jtxStreet.getText().equals("") ||
                          this.jtxZipCode.getText().equals("") ||
                          this.jtxEmail.getText().equals("");
        if(isEmpty){
            JOptionPane.showMessageDialog(null, "Please fill all text fields");
            return false;
        }
        

        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnRegist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jtxEmail;
    private javax.swing.JTextField jtxName;
    private javax.swing.JTextField jtxPWord;
    private javax.swing.JTextField jtxState;
    private javax.swing.JTextField jtxStreet;
    private javax.swing.JTextField jtxUserName;
    private javax.swing.JTextField jtxZipCode;
    // End of variables declaration//GEN-END:variables
}