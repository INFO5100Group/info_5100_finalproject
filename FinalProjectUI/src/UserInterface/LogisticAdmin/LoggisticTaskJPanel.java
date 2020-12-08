/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.LogisticAdmin;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Person.Person;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import System.Configure.DB4OUtil;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/**
 *
 * @author Bohan Feng
 */
public class LoggisticTaskJPanel extends javax.swing.JPanel {
    private Account account;
    private EcoSystem system;
    private Enterprise currEnterprise;    
    public LoggisticTaskJPanel() {
        initComponents();
    }

    public LoggisticTaskJPanel(Account account, EcoSystem system) {
        this();
        this.account = account;
        this.system = system;
        this.currEnterprise = system.getEnterprises().getEnterpriseByAccout(account);
        populateTable();
        populateComboo();
    }
    
    public void populateComboo(){
        comboDeriverMan.removeAllItems();
        comboDeriverMan.addItem("Select a deliver man");
        for(Person p : currEnterprise.getDepartments().get(0).getEmployee()){
            Account currAccount = system.getAccounts().getAccontByPerson(p);
            comboDeriverMan.addItem(currAccount + " (" + currAccount.getID() + ")");
        }
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)this.tblTasks.getModel();
        model.setRowCount(0);
        for(WorkRequest wr : system.getWorkQueue()){
            if(wr.getReceivers().keySet().contains(account)){
                JSONObject currInfo = new JSONObject(wr.getMessage());
                Object row[] = new Object[6];
                row[0] = wr;
                row[1] = wr.getSender();
                try{
                    row[2] = system.getEnterprises().getEnterpriseByAccout(
                            (new ArrayList<>(wr.getReceivers().keySet())).get(0)
                    ).getName();
                }catch (Exception e){
                    row[2] = (new ArrayList<>(wr.getReceivers().keySet())).get(0);
                }
                
                try{
                    row[3] = (new ArrayList<>(wr.getReceivers().keySet())).get(2);  
                }catch(Exception e){
                    
                }
                try{
                    row[4] = currInfo.get("Product");
                }
                catch(Exception e){
                    
                }
                row[5] = wr.getStatus();
                model.addRow(row);
            }
        }
    }
    
    public int getEnterpriseID(String str) {
        String IDstr = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        return Integer.parseInt(IDstr);
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
        tblTasks = new javax.swing.JTable();
        comboDeriverMan = new javax.swing.JComboBox<>();
        btnDistribute = new javax.swing.JButton();

        tblTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Sender", "Receiver", "DeliveryMan", "Product", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblTasks);

        comboDeriverMan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDistribute.setText("Distribute");
        btnDistribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDistribute, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboDeriverMan, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboDeriverMan)
                    .addComponent(btnDistribute, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap(138, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDistributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributeActionPerformed
        int selectedRow = this.tblTasks.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "please select a row");
            return;
        } else if (comboDeriverMan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "please select a deliver person");
            return;
        } else {
            Account delAccount = system.getAccounts().getAccountByID(getEnterpriseID("" + comboDeriverMan.getSelectedItem()));
            WorkRequest wr = (WorkRequest) tblTasks.getValueAt(selectedRow, 0);
            try {
                (new ArrayList<>(wr.getReceivers().keySet())).get(2);
            } catch (java.lang.IndexOutOfBoundsException e) {
                wr.getReceivers().put(delAccount, false);
                wr.setStatus("Distribute for delivery");
                DB4OUtil.storeSystem(system);
                populateTable();
                return;
            }
            JOptionPane.showMessageDialog(null, "Already have a deliver person , cannot set another one");
            return;
        }
    }//GEN-LAST:event_btnDistributeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDistribute;
    private javax.swing.JComboBox<String> comboDeriverMan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTasks;
    // End of variables declaration//GEN-END:variables
}