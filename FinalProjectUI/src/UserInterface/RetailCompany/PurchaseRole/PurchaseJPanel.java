package UserInterface.RetailCompany.PurchaseRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import System.Configure.DB4OUtil;
import java.awt.Color;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.json.JSONObject;

/**
 *
 * @author Administrator
 */
public class PurchaseJPanel extends javax.swing.JPanel {

    private Account account;
    private EcoSystem system;

    public PurchaseJPanel() {
        initComponents();
    }

    public PurchaseJPanel(Account account, EcoSystem system) {
        this();
        this.account = account;
        this.system = system;
        populateTable();
        setTable();
        setButtonImage();
    }
    private void setTable(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(149,19,19));
        cellRenderer.setForeground(Color.white);
        for(int i=0;i<6;i++){
            TableColumn column = BargainJTable.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);            
        }
        for(int i=0;i<2;i++){
            TableColumn column = SellerOfferTable.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);            
        }
    }   
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) this.BargainJTable.getModel();
        model.setRowCount(0);
        WorkQueue wq = system.getWorkQueue().getRequestsBySender(account);
        for (WorkRequest wr : wq) {
            if (!wr.isIsCompleted()) {
                Enterprise e = system.getEnterprises().getEnterpriseByEmployeeAccount(account);
                JSONObject currInfo = new JSONObject(wr.getMessage());
                Object row[] = new Object[7];
                row[1] = e.getName() + "-" + account.getAccountName();
                row[2] = currInfo.getString("ProductType");
                row[3] = currInfo.getString("Quantity");
                row[4] = currInfo.getString("BuyerOffer");
                row[5] = wr.getStatus();
                row[0] = wr;
                model.addRow(row);
            }
        }
    }
     private void setButtonImage(){
         ImageIcon delete=new ImageIcon("./image/Accept.png");
         btnAccept.setIcon(delete);
         ImageIcon regist=new ImageIcon("./image/request122.png");
         btnRequest.setIcon(regist);
    }     
    public void populateSellersTable() {
        int selectedRow = this.BargainJTable.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest er = (WorkRequest) (BargainJTable.getValueAt(selectedRow, 0));
            DefaultTableModel model = (DefaultTableModel) this.SellerOfferTable.getModel();
            model.setRowCount(0);
            JSONObject currInfo = new JSONObject(er.getMessage());
            JSONObject sellerInfo = currInfo.getJSONObject("Seller");
            Iterator<String> keys = sellerInfo.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                Object row[] = new Object[2];
                row[0] = key;
                row[1] = sellerInfo.get(key);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        BargainJTable = new javax.swing.JTable();
        btnRequest = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SellerOfferTable = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        BargainJTable.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        BargainJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "BuyerName", "ProductType", "Quantity", "BuyerOffer", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BargainJTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        BargainJTable.setRowHeight(25);
        BargainJTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        BargainJTable.setShowVerticalLines(false);
        BargainJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BargainJTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(BargainJTable);

        btnRequest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        jLabel4.setText("Seller Offer");

        SellerOfferTable.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        SellerOfferTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Seller", "Offer ($)"
            }
        ));
        SellerOfferTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        SellerOfferTable.setRowHeight(25);
        SellerOfferTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(SellerOfferTable);

        btnAccept.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(251, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(232, 232, 232))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(200, 200, 200))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        CreateRequestJFrame crf = new CreateRequestJFrame(account, system, this);
        crf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        crf.setVisible(true);
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        int SelectRequestRow = this.BargainJTable.getSelectedRow();
        int SelectSellerRow = this.SellerOfferTable.getSelectedRow();

        if(SelectRequestRow < 0){
            JOptionPane.showMessageDialog(null, "Select a request");
            return;
        }else if(SelectSellerRow < 0){
            JOptionPane.showMessageDialog(null, "Select a seller offer");
            return;
        }else{
            WorkRequest wr = (WorkRequest) (BargainJTable.getValueAt(SelectRequestRow, 0));
            String sellerName = (String) this.SellerOfferTable.getValueAt(SelectSellerRow, 0);
            JSONObject currInfo = new JSONObject(wr.getMessage());
            currInfo.put("SellerOffer", sellerName);
            currInfo.put("DealPrice", SellerOfferTable.getValueAt(SelectSellerRow, 1)+"");
            wr.setMessage(currInfo.toString());
            wr.setStatus("Deal");
            DB4OUtil.storeSystem(system);
            populateTable();
            JOptionPane.showMessageDialog(null, "you have accept " + sellerName + "'s "
                + currInfo.get("Product")
                + " with price of " + this.SellerOfferTable.getValueAt(SelectSellerRow, 1));
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void BargainJTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BargainJTableMousePressed
        populateSellersTable();
    }//GEN-LAST:event_BargainJTableMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BargainJTable;
    private javax.swing.JTable SellerOfferTable;
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnRequest;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
