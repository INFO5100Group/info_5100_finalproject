/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FurnitureAdmin;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Person.Person;
import EcoSystem.EcoSystem;

import System.AccountRole.*;
import System.Configure.DB4OUtil;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class FurnitureRegistJPanel extends javax.swing.JPanel {

    private Account account;
    private EcoSystem system;
    private Enterprise enterprise;
    /**
     * Creates new form RetailRegistJPanel1
     */
    public FurnitureRegistJPanel() {
        initComponents();
        setButtonImage();
    }

    public FurnitureRegistJPanel(Account account, EcoSystem system) {
        this();
        this.account = account;
        this.system = system;
        enterprise = system.getEnterprises().getEnterpriseByAccout(account);
        populateTable();
        populateCombo();
        setButtonImage();
    }
    
    public void populateCombo(){
        ComboRole.removeAllItems();
        ComboRole.addItem("");// 0
        ComboRole.addItem("Procurement Person"); // 1
        ComboRole.addItem("Designer"); // 2
        ComboRole.addItem("Producer"); // 3
        ComboRole.addItem("Sales Person"); // 4
    }
    private void setButtonImage(){
         ImageIcon delete=new ImageIcon("./image/delete.png");
         btnDelete.setIcon(delete);
         ImageIcon regist=new ImageIcon("./image/regist.png");
         btnRegist.setIcon(regist);
    }    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)this.tblEmployee.getModel();
        model.setRowCount(0);
        for(Organization o : enterprise.getDepartments()){
            for(Person p : o.getEmployee()){
                Object row[] = new Object[3];
                row[0] = system.getAccounts().getAccontByPerson(p);
                row[1] = ((Account)row[0]).getPassword();
                row[2] = ((Account)row[0]).getRole().rType;   
                model.addRow(row);
            }
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

        jtxUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComboRole = new javax.swing.JComboBox<>();
        jtxPassword = new javax.swing.JTextField();
        btnRegist = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel3.setText("Password:");

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "UserName", "Password", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel4.setText("UserName:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel5.setText("Role:");

        ComboRole.setBackground(new java.awt.Color(102, 102, 102));
        ComboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboRole.setBorder(null);

        btnRegist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistActionPerformed(evt);
            }
        });

        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(701, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxPassword)
                                    .addComponent(jtxUserName)
                                    .addComponent(ComboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(321, 321, 321))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(402, 402, 402))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistActionPerformed
        if(inputValidate()){
            Person p = new Person();
            Account a = new Account(jtxUserName.getText(), jtxPassword.getText(), p);
            int select = ComboRole.getSelectedIndex();
            switch(select){
                case 1:
                    a.setRole(new ManuProcurementPersonRole());
                    break;                   
                case 2:
                    a.setRole(new ManuDesignerRole());
                    break;                    
                case 3:
                    a.setRole(new ManuProducerRole());
                    break;                    
                case 4:
                    a.setRole(new ManuSalesPersonRole());
                    break;
            }
            
            boolean addAccountSuccess = system.getAccounts().addAccount(a);
            if(!addAccountSuccess){
                JOptionPane.showMessageDialog(null, a.getAccountName() + " cannot add account, please change to another user name");
                return;
            }
            
            enterprise.getDepartments()
                    .get(select == 1 ? 0 : select == 2 || select == 3 ? 1 : 3)
                    .getEmployee()
                    .addPerson(a.getPerson());
            JOptionPane.showMessageDialog(null, a.getAccountName() + " account add success!");
            DB4OUtil.storeSystem(system);
            populateTable();
        }
    }//GEN-LAST:event_btnRegistActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblEmployee.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // get selected enterprise
        Account a = (Account) tblEmployee.getValueAt(row, 0);
        
        enterprise.removeEmployee(a.getPerson());
        system.getAccounts().removeAccount(a);
        
        // store to database
        DB4OUtil.storeSystem(system);
        JOptionPane.showMessageDialog(null, "remove Account " + a + " success");
        populateTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    public boolean inputValidate(){
        boolean isEmpty = jtxPassword.getText().equals("")
                || jtxUserName.getText().equals("");
        if(isEmpty){
            JOptionPane.showMessageDialog(null, "Please fill all text fields");
            return false;
        }
        
        boolean isSelect = this.ComboRole.getSelectedIndex() != 0;
        
        if(!isSelect){
            JOptionPane.showMessageDialog(null, "Please Select a role type");
            return false;
        }
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboRole;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRegist;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtxPassword;
    private javax.swing.JTextField jtxUserName;
    private javax.swing.JTable tblEmployee;
    // End of variables declaration//GEN-END:variables
}
