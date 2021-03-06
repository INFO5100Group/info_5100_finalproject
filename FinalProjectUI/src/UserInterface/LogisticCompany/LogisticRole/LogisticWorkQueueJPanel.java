package UserInterface.LogisticCompany.LogisticRole;

import Business.Account.Account;
import Business.Role.RoleType;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import System.Configure.DB4OUtil;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
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
public class LogisticWorkQueueJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private Account account;

    public LogisticWorkQueueJPanel() {
        initComponents();
        initialJTable();
    }

    public LogisticWorkQueueJPanel(Account acc, EcoSystem sys) {
        this();
        this.system = sys;
        this.account = acc;
        populateTable();
        setButtonImage();
        setTable();
    }

    public void populateTable() {
        DefaultTableModel modelFor = (DefaultTableModel) this.ForestryCompanyJTable.getModel();
        DefaultTableModel modelFur = (DefaultTableModel) this.FurnitureCompanyJTable.getModel();
        DefaultTableModel modelCust = (DefaultTableModel) this.CustomerJTable.getModel();
        modelFor.setRowCount(0);
        modelFur.setRowCount(0);
        modelCust.setRowCount(0);

        for (WorkRequest wr : system.getWorkQueue()) {
            if (wr.getReceivers().keySet().contains(account)) {
                JSONObject currInfo = new JSONObject(wr.getMessage());
                Object row[] = new Object[5];
                row[0] = wr;
                
                for(Account each : wr.getReceivers().keySet()){
                    if(each.getRole().rType == RoleType.Customer){
                        row[1] = each.getPerson();
                    }
                    if(each.getRole().rType == RoleType.ManuProcurementPerson
                            || each.getRole().rType == RoleType.RetailProcurementPerson){
                        row[1] = system.getEnterprises().getEnterpriseByEmployeeAccount(each).getName();
                    }
                }

                row[2] = (new ArrayList<>(wr.getReceivers().keySet())).get(0);
                row[3] = currInfo.getString("Product");
                row[4] = wr.getStatus();
                if (wr.getSender().getRole().rType == RoleType.ForestSalesPerson) {
                    modelFor.addRow(row);
                } else if (wr.getSender().getRole().rType == RoleType.ManuSalsePerson) {
                    modelFur.addRow(row);
                } else {
                    modelCust.addRow(row);
                }
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

        btnLocation = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        FurnitureCompanyJTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        CustomerJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ForestryCompanyJTable = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocationActionPerformed(evt);
            }
        });

        FurnitureCompanyJTable.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        FurnitureCompanyJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "OrderID", "EnterpriseName", "ReceiverName", "ProductName", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FurnitureCompanyJTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        FurnitureCompanyJTable.setRowHeight(25);
        FurnitureCompanyJTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        FurnitureCompanyJTable.setShowVerticalLines(false);
        FurnitureCompanyJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FurnitureCompanyJTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(FurnitureCompanyJTable);

        CustomerJTable.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        CustomerJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "OrderID", "Customer Name", "ReceiverName", "ProductName", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CustomerJTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        CustomerJTable.setRowHeight(25);
        CustomerJTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        CustomerJTable.setShowVerticalLines(false);
        CustomerJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CustomerJTableMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(CustomerJTable);

        ForestryCompanyJTable.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        ForestryCompanyJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "OrderID", "EnterpriseName", "ReceiverName", "ProductName", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ForestryCompanyJTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ForestryCompanyJTable.setRowHeight(25);
        ForestryCompanyJTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        ForestryCompanyJTable.setShowVerticalLines(false);
        ForestryCompanyJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ForestryCompanyJTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(ForestryCompanyJTable);

        btnAccept.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        jLabel1.setText("Wood Logistics");

        jLabel2.setText("Furtinure to Retail Enterprise");

        jLabel3.setText("Furtinure to customer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(378, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addComponent(jScrollPane3)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(307, 307, 307)
                        .addComponent(btnLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(222, 222, 222))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void initialJTable() {
        CustomerJTable.getTableHeader().setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(74, 192, 255));
        for (int i = 0; i < 5; i++) {
            TableColumn column = CustomerJTable.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
        }
        ForestryCompanyJTable.getTableHeader().setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
        for (int i = 0; i < 5; i++) {
            TableColumn column = ForestryCompanyJTable.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
        }
        FurnitureCompanyJTable.getTableHeader().setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
        for (int i = 0; i < 5; i++) {
            TableColumn column = FurnitureCompanyJTable.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
        }
    }
    private void btnLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocationActionPerformed
        WorkRequest wr = getSelectdwr();
        if (wr != null) {
            LocationDetailJFrame ldf = new LocationDetailJFrame(wr, system);
            ldf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            ldf.setVisible(true);
        }
    }//GEN-LAST:event_btnLocationActionPerformed
    private void setButtonImage(){
         ImageIcon delete=new ImageIcon("./image/Complete.png");
         btnAccept.setIcon(delete);
         ImageIcon regist=new ImageIcon("./image/location.png");
         btnLocation.setIcon(regist);
    }
    private void setTable(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(149,19,19));
        cellRenderer.setForeground(Color.white);
        for(int i=0;i<5;i++){
            TableColumn column = CustomerJTable.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);            
        }
        for(int i=0;i<5;i++){
            TableColumn column = ForestryCompanyJTable.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);            
        }
        for(int i=0;i<5;i++){
            TableColumn column = FurnitureCompanyJTable.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);            
        }
    }
    private WorkRequest getSelectdwr() {
        int SelectedRow;
        WorkRequest wr = null;

        if (ForestryCompanyJTable.getSelectedRow() >= 0) {
            SelectedRow = ForestryCompanyJTable.getSelectedRow();
            wr = (WorkRequest) ForestryCompanyJTable.getValueAt(SelectedRow, 0);

        } else if (FurnitureCompanyJTable.getSelectedRow() >= 0) {
            SelectedRow = FurnitureCompanyJTable.getSelectedRow();
            wr = (WorkRequest) FurnitureCompanyJTable.getValueAt(SelectedRow, 0);

        } else if (CustomerJTable.getSelectedRow() >= 0) {
            SelectedRow = CustomerJTable.getSelectedRow();
            wr = (WorkRequest) CustomerJTable.getValueAt(SelectedRow, 0);

        } else {
            JOptionPane.showMessageDialog(null, "please select a row");

        }
        return wr;
    }


    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        WorkRequest wr = getSelectdwr();
        wr.setStatus("Delivered");
        populateTable();
        DB4OUtil.storeSystem(system);
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void ForestryCompanyJTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForestryCompanyJTableMousePressed
        CustomerJTable.getSelectionModel().clearSelection();
        FurnitureCompanyJTable.getSelectionModel().clearSelection();
    }//GEN-LAST:event_ForestryCompanyJTableMousePressed

    private void FurnitureCompanyJTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FurnitureCompanyJTableMousePressed
        CustomerJTable.getSelectionModel().clearSelection();
        ForestryCompanyJTable.getSelectionModel().clearSelection();
    }//GEN-LAST:event_FurnitureCompanyJTableMousePressed

    private void CustomerJTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerJTableMousePressed
        FurnitureCompanyJTable.getSelectionModel().clearSelection();
        ForestryCompanyJTable.getSelectionModel().clearSelection();
    }//GEN-LAST:event_CustomerJTableMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CustomerJTable;
    private javax.swing.JTable ForestryCompanyJTable;
    private javax.swing.JTable FurnitureCompanyJTable;
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnLocation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
