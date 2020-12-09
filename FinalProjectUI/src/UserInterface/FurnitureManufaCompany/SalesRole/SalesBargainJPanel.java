/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FurnitureManufaCompany.SalesRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Furniture.Furniture;
import Business.Furniture.FurnitureDirectory;
import Business.Role.RoleType;
import Business.Wood.WoodStorage;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import System.Configure.DB4OUtil;
import UserInterface.ForestryCompany.SalesRole.*;
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SalesBargainJPanel extends javax.swing.JPanel {

    private Account account;
    private EcoSystem system;
    private FurnitureDirectory furnitures;
    private Enterprise currEnterprise;

    /**
     * Creates new form SalesWorkJPanel1
     */
    public SalesBargainJPanel() {
        initComponents();
        BargainJTable.getTableHeader().setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
        StorageJTable.getTableHeader().setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(74, 192, 255));
        for (int i = 0; i < 6; i++) {
            TableColumn column = BargainJTable.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
        }
        for (int i = 0; i < 3; i++) {
            TableColumn column = StorageJTable.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
        }
        setButtonImage();
    }

    public SalesBargainJPanel(Account account, EcoSystem system) {
        this();
        this.account = account;
        this.system = system;
        this.currEnterprise = system.getEnterprises().getEnterpriseByEmployeeAccount(account);
        this.furnitures = currEnterprise.getFurnitureStorage();
        populateFurnitureTbale();
        populateRequestTable(false);
    }

    private void setButtonImage() {
        ImageIcon bargain = new ImageIcon("./image/Bargain.png");
        btnBargain.setIcon(bargain);
        ImageIcon accept = new ImageIcon("./image/Accept.png");
        btnAccept.setIcon(accept);
        ImageIcon refresh = new ImageIcon("./image/Refresh.png");
        btnRefresh.setIcon(refresh);
    }
    
    public void populateRequestTable(boolean isSelfDeal) {
        DefaultTableModel model = (DefaultTableModel) this.BargainJTable.getModel();
        Enterprise e = system.getEnterprises().getEnterpriseByEmployeeAccount(account);
        model.setRowCount(0);
        int dealNum = 0;
        for (WorkRequest wr : system.getWorkQueue()) {
            // 若 workrequst 没有complete， 并且为家具制造商收购者发出， 则显示再表格内
            if (wr.getSender().getRole().rType == RoleType.RetailProcurementPerson && !wr.isIsCompleted()) {
                Object row[] = new Object[6];
                JSONObject currInfo = new JSONObject(wr.getMessage());
                // 检查是否为deal
                if (wr.getStatus().equals("Deal")) {
                    dealNum++;
                }
                // 若没有卖家被接受 则显示再表中
                if (currInfo.getString("SellerOffer").equals("")
                        || currInfo.getString("SellerOffer").equals(e.getName() + "-" + account.getAccountName())) {
                    row[0] = wr;
                    row[1] = system.getEnterprises().getEnterpriseByEmployeeAccount(wr.getSender())
                            + "-"
                            + wr.getSender();
                    row[2] = currInfo.get("ProductType");
                    row[3] = currInfo.get("Quantity");
                    row[4] = currInfo.get("BuyerOffer");
                    row[5] = wr.getStatus();

                    model.addRow(row);
                }
            }
        }
        if (dealNum != 0 && !isSelfDeal) {
            JOptionPane.showMessageDialog(null, "you have " + dealNum + " request to distribute");
        }
    }
    
    public void populateFurnitureTbale() {
        DefaultTableModel model = (DefaultTableModel) this.StorageJTable.getModel();
        model.setRowCount(0);

        for (Furniture f : furnitures) {
            Object row[] = new Object[3];
            row[0] = f;
            row[1] = f.getType();
            row[2] = furnitures.getRemain(f);
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

        jtxbarginPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        BargainJTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        StorageJTable = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();
        btnBargain = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAddDistribute = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jtxbarginPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxbarginPriceActionPerformed(evt);
            }
        });

        BargainJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "BuyerName", "ProductName", "Quantity", "BuyerOffer", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BargainJTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        BargainJTable.setRowHeight(25);
        BargainJTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        BargainJTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(BargainJTable);

        StorageJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ProductName", "Type", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StorageJTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        StorageJTable.setRowHeight(25);
        StorageJTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        StorageJTable.setShowVerticalLines(false);
        jScrollPane3.setViewportView(StorageJTable);

        btnAccept.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnBargain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBargain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBargainActionPerformed(evt);
            }
        });

        btnRefresh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel3.setText("Your Offer");

        btnAddDistribute.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAddDistribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDistributeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddDistribute, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jLabel3)
                .addGap(51, 51, 51)
                .addComponent(jtxbarginPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBargain, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtxbarginPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addComponent(btnBargain, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addGap(185, 185, 185)
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAddDistribute, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(279, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtxbarginPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxbarginPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxbarginPriceActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        int selectedRow = this.BargainJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a furniture request");
            return;
        }else{
            Enterprise currEnterprise = system.getEnterprises().getEnterpriseByEmployeeAccount(account);
            WorkRequest wr = (WorkRequest) (BargainJTable.getValueAt(selectedRow, 0));
            JSONObject currInfo = new JSONObject(wr.getMessage());
            JSONObject sellerInfo = (JSONObject) currInfo.get("Seller");
            sellerInfo.put(currEnterprise + "-" + account, currInfo.get("BuyerOffer"));
            currInfo.put("Seller", sellerInfo);
            currInfo.put("DealPrice", currInfo.get("BuyerOffer")+"");
            wr.setMessage(currInfo.toString());
            wr.setStatus("Deal");
            DB4OUtil.storeSystem(system);
            populateRequestTable(true);
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnBargainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBargainActionPerformed
        int selectedRow = this.BargainJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a furniture request");
            return;
        } else {
            if (inputValidate()) {
                Enterprise currEnterprise = system.getEnterprises().getEnterpriseByEmployeeAccount(account);
                WorkRequest wr = (WorkRequest) (BargainJTable.getValueAt(selectedRow, 0));
                JSONObject currInfo = new JSONObject(wr.getMessage());
                JSONObject sellerInfo = (JSONObject) currInfo.get("Seller");
                sellerInfo.put(currEnterprise + "-" + account, jtxbarginPrice.getText());
                currInfo.put("Seller", sellerInfo);
                wr.setMessage(currInfo.toString());
                wr.setStatus("Manufacturer Company bargain");
                DB4OUtil.storeSystem(system);
                JOptionPane.showMessageDialog(null, "you have send a bargin to furniture retailer with price of " + jtxbarginPrice.getText());
                populateRequestTable(false);
            }

        }
    }//GEN-LAST:event_btnBargainActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateFurnitureTbale();
        populateRequestTable(false);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddDistributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDistributeActionPerformed
        int selectedBarginRow = this.BargainJTable.getSelectedRow();
        int selectedwoodRow = this.StorageJTable.getSelectedRow();
        Enterprise e = system.getEnterprises().getEnterpriseByEmployeeAccount(account);

        if(selectedBarginRow < 0){
            JOptionPane.showMessageDialog(null, "please select a request");
            return;
        }
        if(selectedwoodRow < 0){
            JOptionPane.showMessageDialog(null, "please select a wood in storeage");
            return;
        }
        Furniture furniture = (Furniture) StorageJTable.getValueAt(selectedwoodRow, 0);
        WorkRequest wr = (WorkRequest) BargainJTable.getValueAt(selectedBarginRow, 0);
        Integer amount = Integer.parseInt(new JSONObject(wr.getMessage()).getString("Quantity"));

        if(e.getFurnitureStorage().removeFurniture(furniture, amount)){
            if(AddDistribute(wr, furniture)){
                JOptionPane.showMessageDialog(null, "you have create a new order send to " + system.getEnterprises().getEnterpriseByEmployeeAccount(wr.getSender()) + "please set a logistic company to start the order");
                populateRequestTable(true);
                populateFurnitureTbale();
            }
        }else{
            JOptionPane.showMessageDialog(null, "you dont have enough " + furniture + " in your storage");
            return;
        }
    }//GEN-LAST:event_btnAddDistributeActionPerformed

    public boolean AddDistribute(WorkRequest wr, Furniture f) {
        if(!wr.getStatus().equals("Deal")){
            JOptionPane.showMessageDialog(null, "you cannot create distribution for no deal request");
            return false;
        }
        wr.setStatus("Deal, waiting for distribute");
        wr.setIsCompleted(true);
        JSONObject currInfo = new JSONObject(wr.getMessage());
        JSONObject newInfo = new JSONObject();
        
        // 新message： 产品， 价格， 原requestID
        newInfo.put("Product", f);
        Double price = Double.parseDouble(currInfo.getString("DealPrice"));
        Double amount = Double.parseDouble(currInfo.getString("Quantity"));
        newInfo.put("TotalPrice", price * amount + "");
        newInfo.put("RequestID", wr.getID());
        
        // 新 sender: salemane, 新reciever： 物流和收获家具公司账号
        WorkRequest newRequest = new WorkRequest();
        newRequest.setMessage(newInfo.toString());
        newRequest.setSender(account);
        newRequest.getReceivers().put(wr.getSender(), false);
        newRequest.setStatus(wr.getStatus());
        try {
            system.getWorkQueue().addRequest(newRequest);
        } catch (Exception ex) {
            Logger.getLogger(UserInterface.ForestryCompany.SalesRole.SalesBargainJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DB4OUtil.storeSystem(system);
        return true;
    }
    
    public boolean inputValidate() {
        if (this.jtxbarginPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "please in put your bargain price");
            return false;
        }

        try {
            Double.parseDouble(jtxbarginPrice.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "your braging prise should be numeric");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BargainJTable;
    private javax.swing.JTable StorageJTable;
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnAddDistribute;
    private javax.swing.JButton btnBargain;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jtxbarginPrice;
    // End of variables declaration//GEN-END:variables
}
