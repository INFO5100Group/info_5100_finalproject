/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.RetailCompany.SalesRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Furniture.Furniture;
import Business.Furniture.FurnitureDirectory;
import EcoSystem.EcoSystem;
import System.Configure.DB4OUtil;
import UserInterface.ForestryCompany.SalesRole.*;
import UserInterface.FurnitureManufaCompany.PurchaseRole.CreateRequestJFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Administrator
 */
public class SalesWorkQueueJPanel extends javax.swing.JPanel {

    private Account account;
    private EcoSystem system;
    private Enterprise currEnterprise;
            

    /**
     * Creates new form SalesWorkJPanel1
     */
    public SalesWorkQueueJPanel() {
        initComponents();
        initialJTable();
    }

    public SalesWorkQueueJPanel(Account account, EcoSystem system) {
        this();
        this.account = account;
        this.system = system;
        currEnterprise = system.getEnterprises().getEnterpriseByEmployeeAccount(account);
        popupateTable();
        setButtonImage();
        setTable();
    }

    private void setButtonImage() {
         ImageIcon delete=new ImageIcon("./image/detail.png");
         btnDetail.setIcon(delete);
         ImageIcon regist=new ImageIcon("./image/release.png");
         btnRelease.setIcon(regist);
    }
    private void setTable(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(149,19,19));
        cellRenderer.setForeground(Color.white);
        for(int i=0;i<4;i++){
            TableColumn column = FTable.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);            
        }
    }    
    public void popupateTable(){
        DefaultTableModel model = (DefaultTableModel) this.FTable.getModel();
        model.setRowCount(0);
        for(Furniture f : currEnterprise.getFurnitureStorage()){
            if(f.getSeller() == null){
                f.setSeller(currEnterprise.getName());
                DB4OUtil.storeSystem(system);
            }
            Object row[] = new Object[4];
            row[0] = f;
            row[1] = f.getType();
            row[2] = f.getWoodType();
            row[3] = currEnterprise.getFurnitureStorage().getRemain(f);
            model.addRow(row);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        FTable = new javax.swing.JTable();
        btnDetail = new javax.swing.JButton();
        btnRelease = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        FTable.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        FTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Furtinure Name", "Type", "Material", "Remain"
            }
        ));
        FTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        FTable.setRowHeight(25);
        FTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        FTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(FTable);

        btnDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnRelease.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRelease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReleaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(447, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(154, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        int selectedRow = this.FTable.getSelectedRow();
        if(selectedRow >= 0){
            Furniture f = (Furniture) FTable.getValueAt(selectedRow, 0);
            FurtinureDetail crf = new FurtinureDetail(system, f, currEnterprise, this);
            crf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            crf.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "please select a row");
            return;
        }
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnReleaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReleaseActionPerformed
        int selectedRow = this.FTable.getSelectedRow();
        if(selectedRow >= 0){
            Furniture f = (Furniture) FTable.getValueAt(selectedRow, 0);
            int amount = (Integer) FTable.getValueAt(selectedRow, 3);
            if(system.getFurnitureMarket() == null){
                system.setFurnitureMarket(new FurnitureDirectory());
            }
            if(f.getImage() == null){
                JOptionPane.showMessageDialog(null, "this furtinure do not have image");
                return;
            }
            if(f.getPrice()== null){
                JOptionPane.showMessageDialog(null, "this furtinure do not have price");
                return;
            }
            system.getFurnitureMarket().addFurniture(f, amount);
            DB4OUtil.storeSystem(system);
            JOptionPane.showMessageDialog(null, f.getName() + " is released to market place");
            
        }else{
            JOptionPane.showMessageDialog(null, "please select a row");
            return;
        }
    }//GEN-LAST:event_btnReleaseActionPerformed
    private void initialJTable() {
        FTable.getTableHeader().setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
        int col = FTable.getColumnCount();
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(74, 192, 255));
        for (int i = 0; i < col; i++) {
            TableColumn column = FTable.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FTable;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnRelease;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
