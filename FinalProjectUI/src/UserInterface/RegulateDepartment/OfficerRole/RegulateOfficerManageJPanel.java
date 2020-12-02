/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.RegulateDepartment.OfficerRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import System.Configure.DB4OUtil;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/**
 *
 * @author Bohan Feng
 */
public class RegulateOfficerManageJPanel extends javax.swing.JPanel {

    private Account account;
    private EcoSystem system;

    public RegulateOfficerManageJPanel() {
        initComponents();
    }

    public RegulateOfficerManageJPanel(Account account, EcoSystem system) {
        this();
        this.account = account;
        this.system = system;
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) this.LicenseJTable.getModel();
        model.setRowCount(0);
        WorkQueue wq = system.getWorkQueue().getRequestsByRecevier(account);
        for (WorkRequest wr : wq) {
            if (!wr.isIsCompleted()) {
                Enterprise e = system.getEnterprises().getEnterpriseByEmployeeAccount(wr.getSender());
                JSONObject currInfo = new JSONObject(wr.getMessage());
                Object row[] = new Object[7];
                row[1] = e.getName() + "-" + wr.getSender().getAccountName();
                row[2] = currInfo.getString("Species");
                row[3] = currInfo.getString("Weight");
                row[4] = currInfo.getString("StartTime");
                row[5] = currInfo.getString("EndTime");
                row[6] = wr.getStatus();
                row[0] = wr;
                model.addRow(row);
            }
        }
    }

    private void populateScientists() {
        int selectedRow = this.LicenseJTable.getSelectedRow();

        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) this.tblScientist.getModel();
            model.setRowCount(0);
            WorkRequest wr = (WorkRequest) (LicenseJTable.getValueAt(selectedRow, 0));
            for (Account s : wr.getReceivers().keySet()) {
                if (s != account) {
                    Object row[] = new Object[2];
                    row[0] = s;
                    row[1] = wr.getReceivers().get(s) ? "Accept" : "Not Accept";
                    model.addRow(row);
                }
            }
        }
    }

    private void populateCommnet() {
        int selectedRowLicense = this.LicenseJTable.getSelectedRow();
        int selectedRowScientist = this.tblScientist.getSelectedRow();

        if (selectedRowLicense >= 0 && selectedRowScientist >= 0) {
            WorkRequest wr = (WorkRequest) (LicenseJTable.getValueAt(selectedRowLicense, 0));
            Account s = (Account) (tblScientist.getValueAt(selectedRowScientist, 0));

            JSONObject currInfo = new JSONObject(wr.getMessage());

            try {
                txtScientistCommnet.setText(
                        currInfo.getJSONObject("Commnet").getString(s.getID() + "")
                );
            } catch (Exception e) {
                txtScientistCommnet.setText(
                        s + " has not view the request"
                );
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblScientist = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtScientistCommnet = new javax.swing.JTextArea();
        btnApprove1 = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        btnDenied = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LicenseJTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        tblScientist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ScientistName", "Statues"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblScientist.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblScientist.setRowHeight(25);
        tblScientist.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tblScientist.setShowVerticalLines(false);
        tblScientist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblScientistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblScientist);

        txtScientistCommnet.setColumns(20);
        txtScientistCommnet.setRows(5);
        jScrollPane3.setViewportView(txtScientistCommnet);

        btnApprove1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnApprove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApprove1ActionPerformed(evt);
            }
        });

        btnSend.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnDenied.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDenied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeniedActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LicenseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Sender", "TimberSpecies", "TimberWeight", "StartTime", "EndTime", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        LicenseJTable.setFocusable(false);
        LicenseJTable.setRowHeight(25);
        LicenseJTable.setRowMargin(0);
        LicenseJTable.setSelectionBackground(new java.awt.Color(153, 204, 255));
        LicenseJTable.setShowVerticalLines(false);
        LicenseJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LicenseJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(LicenseJTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jScrollPane3))
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 255, Short.MAX_VALUE)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(btnDenied, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(btnApprove1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnApprove1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDenied, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApprove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApprove1ActionPerformed
        int selectedRow = this.LicenseJTable.getSelectedRow();

        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) this.tblScientist.getModel();
            model.setRowCount(0);
            WorkRequest wr = (WorkRequest) (LicenseJTable.getValueAt(selectedRow, 0));
            wr.setStatus("Approved");
            DB4OUtil.storeSystem(system);
            populateTable();
        }
    }//GEN-LAST:event_btnApprove1ActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnDeniedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeniedActionPerformed
        int selectedRow = this.LicenseJTable.getSelectedRow();

        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) this.tblScientist.getModel();
            model.setRowCount(0);
            WorkRequest wr = (WorkRequest) (LicenseJTable.getValueAt(selectedRow, 0));
            wr.setStatus("Denied");
            DB4OUtil.storeSystem(system);
            populateTable();
        }
    }//GEN-LAST:event_btnDeniedActionPerformed

    private void LicenseJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LicenseJTableMouseClicked
        populateScientists();
        txtScientistCommnet.setText("");
    }//GEN-LAST:event_LicenseJTableMouseClicked

    private void tblScientistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScientistMouseClicked
        populateCommnet();
    }//GEN-LAST:event_tblScientistMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable LicenseJTable;
    private javax.swing.JButton btnApprove1;
    private javax.swing.JButton btnDenied;
    private javax.swing.JButton btnSend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblScientist;
    private javax.swing.JTextArea txtScientistCommnet;
    // End of variables declaration//GEN-END:variables

}
