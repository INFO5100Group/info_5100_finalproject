/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Account.Account;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class NavgateableJPanel extends javax.swing.JPanel {

    public JPanel JPanelPos1, JPanelPos2, JPanelPos3, JPanelPos4;
    
    private JPanel contianer;
    private Account account;
    private EcoSystem system;
            
    public NavgateableJPanel(JPanel contianer, Account account, EcoSystem system) {
        initComponents();
        this.setSize(1600, 900);
        this.contianer = contianer;
        this.account = account;
        this.system = system;
        checkUser();
        setButtonImage();
    }
    
    public void checkUser(){
        RoleType currR = account.getRole().rType;
        this.jblUserType.setText(currR + "");
        
        switch(currR){
            case SysAdmin:
                
                break;
            case ForestAdmin:
                
                break;
            case RegulateAdmin:
                
                break;
            case LogisticAdmin:
                
                break;
            case ManuAdmin:
                
                break;
            case RetailAdmin:
                
                break;
            default:
                this.jScrollPane1.setVisible(false);
                
        }
    }
     private void setButtonImage(){
         ImageIcon imageIcon=new ImageIcon("./image/hongcha.png");
         ImageIcon main=new ImageIcon("./image/我的 (2).png");
         jLabel1.setIcon(main);
         btnOut.setIcon(imageIcon);
        if("SysAdmin".equals(account.getRole().rType.toString())                 
          ){
         ImageIcon bt1=new ImageIcon("./image/manageRequests.png");
         ImageIcon bt2=new ImageIcon("./image/manageInfo.png");
         btn1.setIcon(bt1);
         btn2.setIcon(bt2);
         }
        if("LogisticAdmin".equals(account.getRole().rType.toString())                     
                 ){
         ImageIcon bt1=new ImageIcon("./image/manageInfo.png");
         btn1.setIcon(bt1);
         ImageIcon bt2=new ImageIcon("./image/manageInfo.png");
         btn1.setIcon(bt2); 
         }
         if("ForestSalesPerson".equals(account.getRole().rType.toString())||
            "ManuSalsePerson".equals(account.getRole().rType.toString())||   
            "RetailSalsePerson".equals(account.getRole().rType.toString())     
                 ){
         ImageIcon bt1=new ImageIcon("./image/manageInfo.png");
         btn1.setIcon(bt1);
         ImageIcon bt2=new ImageIcon("./image/manageInfo.png");
         btn2.setIcon(bt2);  
         }
         if("ManuProcurementPerson".equals(account.getRole().rType.toString())||
            "RetailProcurementPerson".equals(account.getRole().rType.toString())){
         ImageIcon bt1=new ImageIcon("./image/manageInfo.png");
         btn1.setIcon(bt1);
         ImageIcon bt2=new ImageIcon("./image/manageInfo.png");
         btn2.setIcon(bt2);  
         }
         if("LogisticsPseron".equals(account.getRole().rType.toString())){
         ImageIcon bt1=new ImageIcon("./image/manageInfo.png");
         btn1.setIcon(bt1);
         ImageIcon bt2=new ImageIcon("./image/manageInfo.png");
         btn2.setIcon(bt2);  
         }
         if("Customer".equals(account.getRole().rType.toString())){
         ImageIcon bt1=new ImageIcon("./image/manageInfo.png");
         btn1.setIcon(bt1);
         ImageIcon bt2=new ImageIcon("./image/manageInfo.png");
         btn2.setIcon(bt2);
         ImageIcon bt3=new ImageIcon("./image/manageInfo.png");
         btn2.setIcon(bt3);  
         }
         if(
           "RetailAdmin".equals(account.getRole().rType.toString())||        
           "ManuAdmin".equals(account.getRole().rType.toString())||                
           "ForestAdmin".equals(account.getRole().rType.toString())||
           "RegulateAdmin".equals(account.getRole().rType.toString())||
           "RegulateScientist".equals(account.getRole().rType.toString())||
           "ForestLoggingManager".equals(account.getRole().rType.toString())||
           "ManuProducer".equals(account.getRole().rType.toString())||
           "ManuDesigner".equals(account.getRole().rType.toString())){
            this.btn1.setVisible(false);
            this.btn1.setEnabled(false);
         }         
    }   
    public void loadNavBtn(){
        CardLayoutNavigator.goNext(navContainer, JPanelPos1, this.account.getAccountName() + "pos1");
        if(JPanelPos1 == null){
            this.btn1.setVisible(false);
            this.btn1.setEnabled(false);
        }
        if(JPanelPos2 == null){
            this.btn2.setVisible(false);
            this.btn2.setEnabled(false);
        }
        if(JPanelPos3 == null){
            this.btn3.setVisible(false);
            this.btn3.setEnabled(false);
        }
        if(JPanelPos4 == null){
            this.btn4.setVisible(false);
            this.btn4.setEnabled(false);
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

        sideBar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        topBar = new javax.swing.JPanel();
        jblUserType = new javax.swing.JLabel();
        btnOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        navContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1600, 900));
        setPreferredSize(new java.awt.Dimension(1600, 900));

        sideBar.setBackground(new java.awt.Color(184, 75, 9));
        sideBar.setMinimumSize(new java.awt.Dimension(269, 737));
        sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(jTree1);

        sideBar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 229, -1));

        btn1.setBackground(new java.awt.Color(102, 51, 0));
        btn1.setForeground(new java.awt.Color(102, 51, 0));
        btn1.setBorder(null);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        sideBar.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 270, 40));

        btn2.setBackground(new java.awt.Color(102, 51, 0));
        btn2.setForeground(new java.awt.Color(102, 51, 0));
        btn2.setBorder(null);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        sideBar.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 270, 39));

        btn3.setBackground(new java.awt.Color(102, 51, 0));
        btn3.setForeground(new java.awt.Color(102, 51, 0));
        btn3.setBorder(null);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        sideBar.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 270, 39));

        btn4.setBackground(new java.awt.Color(102, 51, 0));
        btn4.setForeground(new java.awt.Color(102, 51, 0));
        btn4.setBorder(null);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        sideBar.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 270, 39));

        topBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblUserType.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jblUserType.setText("<User type>");
        topBar.add(jblUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, -1, 32));

        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });
        topBar.add(btnOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, 30, 30));
        topBar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 30, 30));

        navContainer.setBackground(new java.awt.Color(255, 255, 255));
        navContainer.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(navContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        
        CardLayoutNavigator.goNext(navContainer, JPanelPos1, this.account.getAccountName() + "pos1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if(JPanelPos2.getClass() == (new UserInterface.ForestryCompany.SalesRole.SalesOrderJPanel()).getClass()){
            ((UserInterface.ForestryCompany.SalesRole.SalesOrderJPanel) JPanelPos2).populateTable();
        }else if(JPanelPos2.getClass() == (new UserInterface.LogisticAdmin.LoggisticTaskJPanel()).getClass()){
            ((UserInterface.LogisticAdmin.LoggisticTaskJPanel) JPanelPos2).populateComboo();
        }
        CardLayoutNavigator.goNext(navContainer, JPanelPos2, this.account.getAccountName() + "pos2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        CardLayoutNavigator.goNext(navContainer, JPanelPos3, this.account.getAccountName() + "pos3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        CardLayoutNavigator.goNext(navContainer, JPanelPos4, this.account.getAccountName() + "pos4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        CardLayoutNavigator.logout(contianer, this);
    }//GEN-LAST:event_btnOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn1;
    public javax.swing.JButton btn2;
    public javax.swing.JButton btn3;
    public javax.swing.JButton btn4;
    private javax.swing.JButton btnOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel jblUserType;
    private javax.swing.JPanel navContainer;
    private javax.swing.JPanel sideBar;
    private javax.swing.JPanel topBar;
    // End of variables declaration//GEN-END:variables
}
