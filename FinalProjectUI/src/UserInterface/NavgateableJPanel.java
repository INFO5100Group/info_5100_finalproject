/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Bohan Feng
 */
public class NavgateableJPanel extends javax.swing.JPanel {

    public JPanel JPanelPos1, JPanelPos2, JPanelPos3, JPanelPos4;

    private JPanel contianer;
    private Account account;
    private EcoSystem system;

    public NavgateableJPanel(JPanel contianer, Account account, EcoSystem system) {
        initComponents();
        this.setSize(1600, 900);
        this.contianer = contianer;
        this.account = account;
        this.system = system;
        checkUser();
        setButtonImage();
    }

    public void checkUser() {
        RoleType currR = account.getRole().rType;
        this.jblUserType.setText(currR + " " + account.getPerson());

        if (currR == RoleType.SysAdmin) {
            // populate jtree for sysadmin
            DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
            root.removeAllChildren();
            root.setUserObject("EcoSystem");
            for (Enterprise e : system.getEnterprises()) {
                if (e.isApproved() == false) {
                    break;
                }
                DefaultMutableTreeNode EnterpriseNode = new DefaultMutableTreeNode(e.getName());
                EnterpriseNode.add(new DefaultMutableTreeNode(e.getAdmin().getAccountName()));
                for (Organization o : e.getDepartments()) {
                    DefaultMutableTreeNode OrgNode = new DefaultMutableTreeNode(o.getName());
                    for (Person p : o.getEmployee()) {
                        OrgNode.add(new DefaultMutableTreeNode(p + ""));
                    }
                    EnterpriseNode.add(OrgNode);
                }
                root.add(EnterpriseNode);
            }
            model.reload();

        } else if (currR.equals(RoleType.ForestAdmin)
                && currR.equals(RoleType.LogisticAdmin)
                && currR.equals(RoleType.ManuAdmin)
                && currR.equals(RoleType.RegulateAdmin)
                && currR.equals(RoleType.RetailAdmin)) {

            Enterprise e = system.getEnterprises().getEnterpriseByAccout(account);
            DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
            root.removeAllChildren();
            root.setUserObject(e.getName());
            if (e.isApproved() == false) {
                return;
            }
            root.add(new DefaultMutableTreeNode(e.getAdmin().getAccountName()));
            for (Organization o : e.getDepartments()) {
                DefaultMutableTreeNode OrgNode = new DefaultMutableTreeNode(o.getName());
                for (Person p : o.getEmployee()) {
                    OrgNode.add(new DefaultMutableTreeNode(p + ""));
                }
                root.add(OrgNode);
            }
            model.reload();

        } else {
            this.jScrollPane1.setVisible(false);
        }

    }

    private void setButtonImage() {
        ImageIcon imageIcon = new ImageIcon("./image/hongcha.png");
        ImageIcon main = new ImageIcon("./image/我的 (2).png");
        jLabel1.setIcon(main);
        btnOut.setIcon(imageIcon);
        if ("SysAdmin".equals(account.getRole().rType.toString())) {
            ImageIcon bt1 = new ImageIcon("./image/manageRequests.png");
            ImageIcon bt2 = new ImageIcon("./image/manageInfo.png");
            ImageIcon bt3 = new ImageIcon("./image/manageInfo.png");
            ImageIcon lb1 = new ImageIcon("./image/审核 (4).png");
            ImageIcon lb2 = new ImageIcon("./image/资讯.png");
            ImageIcon lb3 = new ImageIcon("./image/资讯.png");
            jLabel4.setIcon(lb3);
            jLabel2.setIcon(lb1);
            jLabel3.setIcon(lb2);
            btn1.setIcon(bt1);
            btn2.setIcon(bt2);
            btn3.setIcon(bt3);            
            //jPanel3.setVisible(false);
            jPanel4.setVisible(false);
        }
        if ("ForestSalesPerson".equals(account.getRole().rType.toString())
                || "ManuSalsePerson".equals(account.getRole().rType.toString())
                || "RetailSalsePerson".equals(account.getRole().rType.toString())) {
            ImageIcon bt1 = new ImageIcon("./image/confirmPrice.png");
            btn1.setIcon(bt1);
            ImageIcon bt2 = new ImageIcon("./image/distributeOrders.png");
            btn2.setIcon(bt2);
            ImageIcon lb1 = new ImageIcon("./image/明细.png");
            ImageIcon lb2 = new ImageIcon("./image/配送.png");
            jLabel2.setIcon(lb1);
            jLabel3.setIcon(lb2);
            ImageIcon bt3 = new ImageIcon("./image/modifyInFO.png");
            btn3.setIcon(bt3);
            ImageIcon lb3 = new ImageIcon("./image/修改.png");
            jLabel4.setIcon(lb3);
            jPanel4.setVisible(false);
        }
        if ("ManuProcurementPerson".equals(account.getRole().rType.toString())
                || "RetailProcurementPerson".equals(account.getRole().rType.toString())) {
            ImageIcon bt1 = new ImageIcon("./image/confirmPrice.png");
            btn1.setIcon(bt1);
            ImageIcon bt2 = new ImageIcon("./image/viewOrders.png");
            btn2.setIcon(bt2);
            ImageIcon lb1 = new ImageIcon("./image/明细.png");
            ImageIcon lb2 = new ImageIcon("./image/订单.png");
            jLabel2.setIcon(lb1);
            jLabel3.setIcon(lb2);
            ImageIcon bt3 = new ImageIcon("./image/modifyInFO.png");
            btn3.setIcon(bt3);
            ImageIcon lb3 = new ImageIcon("./image/修改.png");
            jLabel4.setIcon(lb3);
            jPanel4.setVisible(false);
        }
        /*if("LogisticsPseron".equals(account.getRole().rType.toString())){
         ImageIcon bt1=new ImageIcon("./image/manageInfo.png");
         btn1.setIcon(bt1);
         ImageIcon bt2=new ImageIcon("./image/manageInfo.png");
         btn2.setIcon(bt2);
         ImageIcon lb1=new ImageIcon("./image/审核 (4).png");
         ImageIcon lb2=new ImageIcon("./image/资讯.png");
         jLabel2.setIcon(lb1);
         jLabel3.setIcon(lb2);
         jPanel3.setVisible(false);
         jPanel4.setVisible(false);
         }*/
        if ("Customer".equals(account.getRole().rType.toString())) {
            ImageIcon bt1 = new ImageIcon("./image/browse.png");
            btn1.setIcon(bt1);
            ImageIcon bt2 = new ImageIcon("./image/viewhistory.png");
            btn2.setIcon(bt2);
            ImageIcon lb1 = new ImageIcon("./image/指标查询.png");
            ImageIcon lb2 = new ImageIcon("./image/历史订单.png");
            jLabel2.setIcon(lb1);
            jLabel3.setIcon(lb2);
            jPanel3.setVisible(false);
            jPanel4.setVisible(false);
        }
        if (    "RegulateScientist".equals(account.getRole().rType.toString())
                || "ForestLoggingManager".equals(account.getRole().rType.toString())
                || "ManuProducer".equals(account.getRole().rType.toString())
                || "ManuDesigner".equals(account.getRole().rType.toString())
                || "LogisticsPseron".equals(account.getRole().rType.toString())
                || "LogisticManager".equals(account.getRole().rType.toString())
                || "RegulateOfficer".equals(account.getRole().rType.toString())) {
            ImageIcon bt1 = new ImageIcon("./image/myWork.png");
            btn1.setIcon(bt1);
            ImageIcon lb1 = new ImageIcon("./image/工作台.png");
            jLabel2.setIcon(lb1);
            ImageIcon bt3 = new ImageIcon("./image/modifyInFO.png");
            btn2.setIcon(bt3);
            ImageIcon lb3 = new ImageIcon("./image/修改.png");
            jLabel3.setIcon(lb3);
            jPanel3.setVisible(false);
            jPanel4.setVisible(false);
        }
        if (    "RetailAdmin".equals(account.getRole().rType.toString())
                || "ManuAdmin".equals(account.getRole().rType.toString())
                || "ForestAdmin".equals(account.getRole().rType.toString())
                || "RegulateAdmin".equals(account.getRole().rType.toString())
                || "LogisticAdmin".equals(account.getRole().rType.toString())
                ) {
            this.btn1.setVisible(false);
            this.btn1.setEnabled(false);
            jPanel1.setVisible(false);
            jPanel2.setVisible(false);
            jPanel3.setVisible(false);
            jPanel4.setVisible(false);
        }
    }

    public void loadNavBtn() {
        CardLayoutNavigator.goNext(navContainer, JPanelPos1, this.account.getAccountName() + "pos1");
        if (JPanelPos1 == null) {
            this.btn1.setVisible(false);
            this.btn1.setEnabled(false);
        }
        if (JPanelPos2 == null) {
            this.btn2.setVisible(false);
            this.btn2.setEnabled(false);
        }
        if (JPanelPos3 == null) {
            this.btn3.setVisible(false);
            this.btn3.setEnabled(false);
        }
        if (JPanelPos4 == null) {
            this.btn4.setVisible(false);
            this.btn4.setEnabled(false);
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

        sideBar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn4 = new javax.swing.JButton();
        topBar = new javax.swing.JPanel();
        jblUserType = new javax.swing.JLabel();
        btnOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        navContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1600, 900));
        setPreferredSize(new java.awt.Dimension(1600, 900));

        sideBar.setBackground(new java.awt.Color(184, 75, 9));
        sideBar.setMinimumSize(new java.awt.Dimension(269, 737));
        sideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(jTree1);

        sideBar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 229, -1));

        jPanel1.setBackground(new java.awt.Color(149, 19, 19));

        btn1.setBackground(new java.awt.Color(102, 51, 0));
        btn1.setForeground(new java.awt.Color(102, 51, 0));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        sideBar.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 290, 40));

        jPanel2.setBackground(new java.awt.Color(149, 19, 19));

        btn2.setBackground(new java.awt.Color(102, 51, 0));
        btn2.setForeground(new java.awt.Color(102, 51, 0));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sideBar.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 290, 40));

        jPanel3.setBackground(new java.awt.Color(149, 19, 19));

        btn3.setBackground(new java.awt.Color(102, 51, 0));
        btn3.setForeground(new java.awt.Color(102, 51, 0));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sideBar.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 290, 40));

        jPanel4.setBackground(new java.awt.Color(149, 19, 19));

        btn4.setBackground(new java.awt.Color(102, 51, 0));
        btn4.setForeground(new java.awt.Color(102, 51, 0));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sideBar.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 290, 40));

        jblUserType.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jblUserType.setText("<User type>");

        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addGap(946, 946, 946)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jblUserType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jblUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        navContainer.setBackground(new java.awt.Color(255, 255, 255));
        navContainer.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(navContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed

        CardLayoutNavigator.goNext(navContainer, JPanelPos1, this.account.getAccountName() + "pos1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if (JPanelPos2.getClass() == (new UserInterface.ForestryCompany.SalesRole.SalesOrderJPanel()).getClass()) {
            ((UserInterface.ForestryCompany.SalesRole.SalesOrderJPanel) JPanelPos2).populateTable();
        } else if (JPanelPos2.getClass() == (new UserInterface.LogisticAdmin.LoggisticTaskJPanel()).getClass()) {
            ((UserInterface.LogisticAdmin.LoggisticTaskJPanel) JPanelPos2).populateComboo();
        } else if (JPanelPos2.getClass() == (new UserInterface.FurnitureManufaCompany.SalesRole.SalesOrderJPanel()).getClass()) {
            ((UserInterface.FurnitureManufaCompany.SalesRole.SalesOrderJPanel) JPanelPos2).populateTable();
        } else if (JPanelPos2.getClass() == (new UserInterface.Customer.CustomerHistoryJPanel()).getClass()) {
            ((UserInterface.Customer.CustomerHistoryJPanel) JPanelPos2).populateTable();
        }
        CardLayoutNavigator.goNext(navContainer, JPanelPos2, this.account.getAccountName() + "pos2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        CardLayoutNavigator.goNext(navContainer, JPanelPos3, this.account.getAccountName() + "pos3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        CardLayoutNavigator.goNext(navContainer, JPanelPos4, this.account.getAccountName() + "pos4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        CardLayoutNavigator.logout(contianer, this);
    }//GEN-LAST:event_btnOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn1;
    public javax.swing.JButton btn2;
    public javax.swing.JButton btn3;
    public javax.swing.JButton btn4;
    private javax.swing.JButton btnOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel jblUserType;
    private javax.swing.JPanel navContainer;
    private javax.swing.JPanel sideBar;
    private javax.swing.JPanel topBar;
    // End of variables declaration//GEN-END:variables
}
