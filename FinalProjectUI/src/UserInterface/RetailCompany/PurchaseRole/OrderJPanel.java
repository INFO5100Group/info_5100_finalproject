/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.RetailCompany.PurchaseRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Furniture.Furniture;
import Business.Furniture.FurnitureDirectory;
import Business.Wood.WoodStorage;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import System.Configure.DB4OUtil;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.json.JSONObject;

/**
 *
 * @author Administrator
 */
public class OrderJPanel extends javax.swing.JPanel {

    private Account account;
    private EcoSystem system;

    public OrderJPanel() {
        initComponents();

    }

    public OrderJPanel(Account arg1, EcoSystem arg2) {
        this();
        this.account = arg1;
        this.system = arg2;
        populateTable();
        initialJTable();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        OrderJTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        HistoryOrderJTable = new javax.swing.JTable();
        btnComplete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        OrderJTable.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
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
        OrderJTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        OrderJTable.setRowHeight(25);
        OrderJTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        OrderJTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(OrderJTable);

        HistoryOrderJTable.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        HistoryOrderJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        HistoryOrderJTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        HistoryOrderJTable.setRowHeight(25);
        HistoryOrderJTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        HistoryOrderJTable.setShowVerticalLines(false);
        jScrollPane3.setViewportView(HistoryOrderJTable);

        btnComplete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(218, 218, 218)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(659, 659, 659))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void initialJTable() {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(149,19,19));
        cellRenderer.setForeground(Color.white);
        for (int i = 0; i < 6; i++) {
            TableColumn column = OrderJTable.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
        }
        for (int i = 0; i < 6; i++) {
            TableColumn column = HistoryOrderJTable.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
        }
    }
    
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) this.OrderJTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) this.HistoryOrderJTable.getModel();
        model.setRowCount(0);
        model2.setRowCount(0);
        for (WorkRequest wr : system.getWorkQueue()) {
            if (wr.getReceivers().keySet().contains(account)) {
                Object row[] = new Object[6];
                ArrayList<Account> list = new ArrayList<>(wr.getReceivers().keySet());
                JSONObject currInfo = new JSONObject(wr.getMessage());
                try {
                    row[1] = system.getEnterprises().getEnterpriseByAccout(
                            (new ArrayList<>(wr.getReceivers().keySet())).get(0)
                    ).getName();
                } catch (Exception e) {
                    row[1] = (new ArrayList<>(wr.getReceivers().keySet())).get(0);
                }

                row[2] = currInfo.getString("Product");
                row[3] = currInfo.getString("TotalPrice");
                try {
                    row[4] = system.getEnterprises().getEnterpriseByAccout(
                            (new ArrayList<>(wr.getReceivers().keySet())).get(1)
                    ).getName();
                } catch (Exception e) {
                }
                row[5] = wr.getStatus();
                row[0] = wr;
                if (wr.isIsCompleted()) {
                    model2.addRow(row);
                } else {
                    model.addRow(row);
                }

            }
        }
    }
    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        WorkRequest wr = getSelectdwr();
        Enterprise currE = system.getEnterprises().getEnterpriseByEmployeeAccount(account);
        if(!wr.getStatus().equals("Delivered")){
            JOptionPane.showMessageDialog(null, "You cannot confirm revice this object, because it is oot delivered");
            return;
        }
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "You confirm to revice this object ?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            wr.resolve();
            JSONObject currInfo = new JSONObject(wr.getMessage());
            //添加木材到仓库
            if(currE.getFurnitureStorage()== null){
                currE.setFurnitureStorage(new FurnitureDirectory());
            }
            int requestID = currInfo.getInt("RequestID");
            WorkRequest FurRequest = system.getWorkQueue().getRequestByID(requestID);
            Integer amount = Integer.parseInt(new JSONObject(FurRequest.getMessage()).getString("Quantity"));
            Enterprise senderE = system.getEnterprises().getEnterpriseByEmployeeAccount(wr.getSender());
            currE.getFurnitureStorage().addFurniture(senderE.getFurnitureStorage().getByName(currInfo.getString("Product")), amount);
            DB4OUtil.storeSystem(system);
            populateTable();
        }
    }//GEN-LAST:event_btnCompleteActionPerformed
    private void setButtonImage(){
         ImageIcon delete=new ImageIcon("./image/Complete.png");
         btnComplete.setIcon(delete);
    }
     private WorkRequest getSelectdwr() {
        int SelectedRow;
        WorkRequest wr = null;

        if (OrderJTable.getSelectedRow() >= 0) {
            SelectedRow = OrderJTable.getSelectedRow();
            wr = (WorkRequest) OrderJTable.getValueAt(SelectedRow, 0);

        } else {
            JOptionPane.showMessageDialog(null, "please select a row");

        }
        return wr;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HistoryOrderJTable;
    private javax.swing.JTable OrderJTable;
    private javax.swing.JButton btnComplete;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
