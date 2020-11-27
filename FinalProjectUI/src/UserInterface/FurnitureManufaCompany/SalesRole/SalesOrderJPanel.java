/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FurnitureManufaCompany.SalesRole;

import UserInterface.ForestryCompany.SalesRole.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Administrator
 */
public class SalesOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SalesOrderJPanel
     */
    public SalesOrderJPanel() {
        initComponents();
        OrderJTable.getTableHeader().setFont(new Font("Yu Gothic UI Light" , Font.BOLD , 15));
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(74,192,255));
        for(int i=0;i<6;i++){
            TableColumn column = OrderJTable.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);
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

        LogisticCompanyCombo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        OrderJTable = new javax.swing.JTable();
        btnDistribute = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        LogisticCompanyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        OrderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "OrderID", "EnterpriseName", "ProductName", "TotalPrice", "LogisticCompany", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrderJTable.setFocusable(false);
        OrderJTable.setRowHeight(25);
        OrderJTable.setRowMargin(0);
        OrderJTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        OrderJTable.setShowVerticalLines(false);
        jScrollPane3.setViewportView(OrderJTable);

        btnDistribute.setIcon(new javax.swing.ImageIcon("C:\\Users\\Administrator\\Desktop\\东北大学\\INFO5100\\正课\\Final Project\\info_5100_finalproject\\FinalProjectUI\\image\\distribute.png")); // NOI18N
        btnDistribute.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
                .addContainerGap(615, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(648, 648, 648)
                                .addComponent(LogisticCompanyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDistribute, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(545, 545, 545))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(LogisticCompanyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnDistribute, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(297, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDistributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDistributeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> LogisticCompanyCombo;
    private javax.swing.JTable OrderJTable;
    private javax.swing.JButton btnDistribute;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
