/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.sysadmin;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import System.Configure.DB4OUtil;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Administrator
 */
public class SysadminRequestJPanel extends javax.swing.JPanel {
    private JPanel navContainer;
    private Account account;
    private EcoSystem system;
    /**
     * Creates new form SysadminRequestJPanel
     */
    public SysadminRequestJPanel() {
        initComponents();
        setButtonImage();
    }

    public SysadminRequestJPanel(Account a, EcoSystem sys) {
        this();
        this.account = a;
        this.system = sys;
        populateTable();
        setTable();
    }
    private void setButtonImage(){
         ImageIcon approve=new ImageIcon("./image/Approve.png");
         btnApprove.setIcon(approve);
         ImageIcon disapprove=new ImageIcon("./image/disapprove.png");
         btnDisapprove.setIcon(disapprove);
    }    
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)this.SysadminJTable1.getModel();
        model.setRowCount(0);
        WorkQueue wq = system.getWorkQueue().getRequestsByRecevier(account);
        for(WorkRequest wr : wq){
            if(!wr.isIsCompleted()){
                Enterprise e = system.getEnterprises().getEnterpriseByAccout(wr.getSender());
                Object row[] = new Object[6];
                row[1] = e.getName();
                row[2] = e.getState() + " " + e.getCity();
                row[3] = e.getAdmin().getAccountName();
                row[4] = e.getAdmin().getPassword();
                row[5] = wr.getStatus();
                row[0] = wr;
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

        jScrollPane3 = new javax.swing.JScrollPane();
        SysadminJTable1 = new javax.swing.JTable();
        btnDisapprove = new javax.swing.JButton();
        btnApprove = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        SysadminJTable1.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        SysadminJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "EnterpriseName", "Localtion", "EntrepriseAdmin", "Password", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(SysadminJTable1);

        btnDisapprove.setBackground(new java.awt.Color(255, 255, 255));
        btnDisapprove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDisapprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisapproveActionPerformed(evt);
            }
        });

        btnApprove.setBackground(new java.awt.Color(255, 255, 255));
        btnApprove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(425, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(509, 509, 509)
                        .addComponent(btnDisapprove, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1075, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnApprove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDisapprove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(309, 309, 309))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        int selectedRow = this.SysadminJTable1.getSelectedRow();
        if(selectedRow >= 0){
            WorkRequest wr = (WorkRequest)(SysadminJTable1.getValueAt(selectedRow, 0));
            Enterprise e = system.getEnterprises().getEnterpriseByAccout(wr.getSender());
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "You Confirm to Approve Request for " + e.getName(), "Warning", dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){ 
                wr.setIsCompleted(true);
                wr.resolve();
                e.setApproved(true);
                DB4OUtil.storeSystem(system);
                populateTable();
            }
        }
    }//GEN-LAST:event_btnApproveActionPerformed
    private void setTable(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(149,19,19));
        cellRenderer.setForeground(Color.white);
        for(int i=0;i<6;i++){
            TableColumn column = SysadminJTable1.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
        }
    }
    private void btnDisapproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisapproveActionPerformed
        int selectedRow = this.SysadminJTable1.getSelectedRow();
        if(selectedRow >= 0){
            WorkRequest wr = (WorkRequest)(SysadminJTable1.getValueAt(selectedRow, 0));
            Enterprise e = system.getEnterprises().getEnterpriseByAccout(wr.getSender());
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "You Confirm to Denie Request for " + e.getName(), "Warning", dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){ 
                wr.setIsCompleted(true);
                wr.denied();
                e.setApproved(false);
                DB4OUtil.storeSystem(system);
                populateTable();
            }
        }
    }//GEN-LAST:event_btnDisapproveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SysadminJTable1;
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnDisapprove;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
