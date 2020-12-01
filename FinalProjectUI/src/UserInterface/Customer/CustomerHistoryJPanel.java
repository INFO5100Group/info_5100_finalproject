/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Account.Account;
import EcoSystem.EcoSystem;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Administrator
 */
public class CustomerHistoryJPanel extends javax.swing.JPanel {
    private Account account;
    private EcoSystem system;
    /**
     * Creates new form CustomerSearchJPanel1
     */
    public CustomerHistoryJPanel() {
        initComponents();
        HistoryJTable.getTableHeader().setFont(new Font("Yu Gothic UI Light" , Font.BOLD , 15));
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(74,192,255));
        for(int i=0;i<7;i++){
            TableColumn column = HistoryJTable.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);
        }
        //this.UserProcessContainer = UserProcessContainer;
    }
    public CustomerHistoryJPanel(Account account, EcoSystem system) {
        this();
        this.account = account;
        this.system = system;  
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
        HistoryJTable = new javax.swing.JTable();

        HistoryJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "OrderID", "ProductName", "Brand", "Type", "Quantity", "TotalPrice", "LogisticCompany"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        HistoryJTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        HistoryJTable.setRowHeight(25);
        HistoryJTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        HistoryJTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(HistoryJTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(381, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HistoryJTable;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
