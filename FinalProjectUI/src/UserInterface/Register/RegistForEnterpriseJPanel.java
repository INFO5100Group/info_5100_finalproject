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
import System.AccountRole.*;
import System.Configure.DB4OUtil;
import UserInterface.CardLayoutNavigator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class RegistForEnterpriseJPanel extends javax.swing.JPanel {

    private JPanel container;
    private EcoSystem system;
            
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
        ComboType.addItem("Logistice Enterprise");// 5
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboType = new javax.swing.JComboBox<>();
        jtxName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxEmail = new javax.swing.JTextField();
        jtxZipCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxUserName = new javax.swing.JTextField();
        jtxState = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxPWord = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxCity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxStreet = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnRegist = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        ComboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel7.setText("Admin Password:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel3.setText("Enterprise Email:");

        jLabel8.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel8.setText("Admin UserName:");

        jLabel4.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel4.setText("Enterprise Type:");

        jLabel9.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel9.setText("Zip Code:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel5.setText("City:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel6.setText("Street:");

        jLabel10.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel10.setText("State:");

        jLabel11.setFont(new java.awt.Font("Yu Gothic Light", 1, 15)); // NOI18N
        jLabel11.setText("Enterprise Name:");

        btnRegist.setIcon(new javax.swing.ImageIcon("C:\\Users\\Administrator\\Desktop\\东北大学\\INFO5100\\正课\\Final Project\\info_5100_finalproject\\FinalProjectUI\\image\\regist.png")); // NOI18N
        btnRegist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jLabel18.setText("Regist As Enterprise");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(957, 957, 957)
                .addComponent(btnRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(119, 119, 119)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jtxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtxName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtxCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jtxState, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtxStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jtxPWord, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(261, 261, 261))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtxState, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtxCity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxPWord, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(btnRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
            // create department for different types of enterprise
            if(ComboType.getSelectedIndex() == 1){
                newAccount.setRole(new RegAdminRole());
                newEnterprise.getDepartments().addOrganization(new Organization("Enviromental Regulatory Organization"));
            }else if(ComboType.getSelectedIndex() == 2){
                newAccount.setRole(new ForestAdminRole());
                newEnterprise.getDepartments().addOrganization(new Organization("Logging Department"));
                newEnterprise.getDepartments().addOrganization(new Organization("Sales Department"));
            }else if(ComboType.getSelectedIndex() == 3){
                newAccount.setRole(new ManuAdminRole());
                newEnterprise.getDepartments().addOrganization(new Organization("Purchasing Department"));
                newEnterprise.getDepartments().addOrganization(new Organization("Production Department"));
                newEnterprise.getDepartments().addOrganization(new Organization("Salse Department"));
            }else if(ComboType.getSelectedIndex() == 4){
                newAccount.setRole(new RetailAdminRole());
                newEnterprise.getDepartments().addOrganization(new Organization("Purchasing Department"));
                newEnterprise.getDepartments().addOrganization(new Organization("Salse Department"));
            }else if(ComboType.getSelectedIndex() == 4){
                newAccount.setRole(new LogisticAdminRole());
                newEnterprise.getDepartments().addOrganization(new Organization("Transportation Department"));
            }
            
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
                return;
            }
            JOptionPane.showMessageDialog(null, newEnterprise.getName() + " enterpirse repuest is send to system admin, plase wait for your enterpires appreoved");
            DB4OUtil.storeSystem(system);
            CardLayoutNavigator.goBack(container, this);
       }
    }//GEN-LAST:event_btnRegistActionPerformed

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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
