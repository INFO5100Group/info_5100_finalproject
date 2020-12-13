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
import UserInterface.Customer.ItemDetailFrame;
import java.awt.Color;
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
            //ImageIcon lb3 = new ImageIcon("./image/资讯.png");
            //jLabel4.setIcon(lb3);
            jLabel2.setIcon(lb1);
            jLabel3.setIcon(lb2);
            jtx1.setText("Manage Request");
            jtx2.setText("Modify Information");
            //jtx3.setText("View Graph");
            btn4.setVisible(false);
        }
        if ("ForestSalesPerson".equals(account.getRole().rType.toString())
                || "ManuSalsePerson".equals(account.getRole().rType.toString())
                || "RetailSalsePerson".equals(account.getRole().rType.toString())) {
            ImageIcon bt1 = new ImageIcon("./image/confirmPrice.png");
            jtx1.setText("Confirm Price");
            ImageIcon bt2 = new ImageIcon("./image/distributeOrders.png");
            jtx2.setText("Distribute Orders");
            ImageIcon lb1 = new ImageIcon("./image/明细.png");
            ImageIcon lb2 = new ImageIcon("./image/配送.png");
            jLabel2.setIcon(lb1);
            jLabel3.setIcon(lb2);
            ImageIcon bt3 = new ImageIcon("./image/modifyInFO.png");
            jtx3.setText("Modify My Personal Info");
            ImageIcon lb3 = new ImageIcon("./image/修改.png");
            jLabel4.setIcon(lb3);
            btn4.setVisible(false);
        }
        if ("ManuProcurementPerson".equals(account.getRole().rType.toString())
                || "RetailProcurementPerson".equals(account.getRole().rType.toString())) {
            ImageIcon bt1 = new ImageIcon("./image/confirmPrice.png");
            jtx1.setText("Confirm Price");
            ImageIcon bt2 = new ImageIcon("./image/viewOrders.png");
            jtx2.setText("View My Orders");
            ImageIcon lb1 = new ImageIcon("./image/明细.png");
            ImageIcon lb2 = new ImageIcon("./image/订单.png");
            jLabel2.setIcon(lb1);
            jLabel3.setIcon(lb2);
            ImageIcon bt3 = new ImageIcon("./image/modifyInFO.png");
            jtx3.setText("Modify My Personal Info");
            ImageIcon lb3 = new ImageIcon("./image/修改.png");
            jLabel4.setIcon(lb3);
            btn4.setVisible(false);
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
            jtx1.setText("Search Goods");
            ImageIcon bt2 = new ImageIcon("./image/viewhistory.png");
            jtx2.setText("View History Order");
            ImageIcon lb1 = new ImageIcon("./image/指标查询.png");
            ImageIcon lb2 = new ImageIcon("./image/历史订单.png");
            jLabel2.setIcon(lb1);
            jLabel3.setIcon(lb2);
            btn3.setVisible(false);
            btn4.setVisible(false);
        }
        if (    "RegulateScientist".equals(account.getRole().rType.toString())
                || "ForestLoggingManager".equals(account.getRole().rType.toString())
                || "ManuProducer".equals(account.getRole().rType.toString())
                || "ManuDesigner".equals(account.getRole().rType.toString())
                || "LogisticsPseron".equals(account.getRole().rType.toString())
                || "LogisticManager".equals(account.getRole().rType.toString())
                || "RegulateOfficer".equals(account.getRole().rType.toString())) {
            ImageIcon bt1 = new ImageIcon("./image/myWork.png");
            jtx1.setText("View My Works");
            ImageIcon lb1 = new ImageIcon("./image/工作台.png");
            jLabel2.setIcon(lb1);
            ImageIcon bt3 = new ImageIcon("./image/modifyInFO.png");
            jtx2.setText("Modify My Personal Info");
            ImageIcon lb3 = new ImageIcon("./image/修改.png");
            jLabel3.setIcon(lb3);
            btn3.setVisible(false);
            btn4.setVisible(false);
        }
        if (    "RetailAdmin".equals(account.getRole().rType.toString())
                || "ManuAdmin".equals(account.getRole().rType.toString())
                || "ForestAdmin".equals(account.getRole().rType.toString())
                || "RegulateAdmin".equals(account.getRole().rType.toString())
                || "LogisticAdmin".equals(account.getRole().rType.toString())
                ) {
            this.btn1.setVisible(false);
            this.btn1.setEnabled(false);
            btn1.setVisible(false);
            btn2.setVisible(false);
            btn3.setVisible(false);
            btn4.setVisible(false);
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
        btn2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtx2 = new javax.swing.JLabel();
        btn3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtx3 = new javax.swing.JLabel();
        btn4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtx4 = new javax.swing.JLabel();
        btn1 = new javax.swing.JPanel();
        jtx1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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

        btn2.setBackground(new java.awt.Color(149, 19, 19));
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn2MouseExited(evt);
            }
        });

        jtx2.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        jtx2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn2Layout = new javax.swing.GroupLayout(btn2);
        btn2.setLayout(btn2Layout);
        btn2Layout.setHorizontalGroup(
            btn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtx2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btn2Layout.setVerticalGroup(
            btn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jtx2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sideBar.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 290, 40));

        btn3.setBackground(new java.awt.Color(149, 19, 19));
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn3MouseExited(evt);
            }
        });

        jtx3.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        jtx3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn3Layout = new javax.swing.GroupLayout(btn3);
        btn3.setLayout(btn3Layout);
        btn3Layout.setHorizontalGroup(
            btn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn3Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtx3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btn3Layout.setVerticalGroup(
            btn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jtx3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sideBar.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 290, 40));

        btn4.setBackground(new java.awt.Color(149, 19, 19));
        btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn4MouseExited(evt);
            }
        });

        jtx4.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        jtx4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn4Layout = new javax.swing.GroupLayout(btn4);
        btn4.setLayout(btn4Layout);
        btn4Layout.setHorizontalGroup(
            btn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn4Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtx4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        btn4Layout.setVerticalGroup(
            btn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jtx4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sideBar.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 290, 40));

        btn1.setBackground(new java.awt.Color(149, 19, 19));
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn1MouseExited(evt);
            }
        });

        jtx1.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        jtx1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn1Layout = new javax.swing.GroupLayout(btn1);
        btn1.setLayout(btn1Layout);
        btn1Layout.setHorizontalGroup(
            btn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtx1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btn1Layout.setVerticalGroup(
            btn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtx1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sideBar.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 290, 40));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
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
        if(JPanelPos1.getClass() == (new UserInterface.RetailCompany.SalesRole.SalesWorkQueueJPanel()).getClass()){
            ((UserInterface.RetailCompany.SalesRole.SalesWorkQueueJPanel) JPanelPos1).popupateTable();
        }
        CardLayoutNavigator.goNext(navContainer, JPanelPos1, this.account.getAccountName() + "pos1");
    }//GEN-LAST:event_btn1MouseClicked

    private void btn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseEntered
        // TODO add your handling code here:
        btn1.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_btn1MouseEntered

    private void btn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseExited
        // TODO add your handling code here:
        btn1.setBackground(new Color(149,19,19));
    }//GEN-LAST:event_btn1MouseExited

    private void btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseClicked
        // TODO add your handling code here:
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
    }//GEN-LAST:event_btn2MouseClicked

    private void btn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseClicked
        // TODO add your handling code here:
        CardLayoutNavigator.goNext(navContainer, JPanelPos3, this.account.getAccountName() + "pos3");
    }//GEN-LAST:event_btn3MouseClicked

    private void btn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MouseClicked
        // TODO add your handling code here:
        CardLayoutNavigator.goNext(navContainer, JPanelPos4, this.account.getAccountName() + "pos4");
    }//GEN-LAST:event_btn4MouseClicked

    private void btn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseEntered
        // TODO add your handling code here:
                btn2.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_btn2MouseEntered

    private void btn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseExited
        // TODO add your handling code here:
                btn2.setBackground(new Color(149,19,19));
    }//GEN-LAST:event_btn2MouseExited

    private void btn3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseEntered
        // TODO add your handling code here:
                btn3.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_btn3MouseEntered

    private void btn3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseExited
        // TODO add your handling code here:
                btn3.setBackground(new Color(149,19,19));
    }//GEN-LAST:event_btn3MouseExited

    private void btn4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MouseEntered
        // TODO add your handling code here:
                btn4.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_btn4MouseEntered

    private void btn4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MouseExited
        // TODO add your handling code here:
                btn4.setBackground(new Color(149,19,19));
    }//GEN-LAST:event_btn4MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn1;
    private javax.swing.JPanel btn2;
    private javax.swing.JPanel btn3;
    private javax.swing.JPanel btn4;
    private javax.swing.JButton btnOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel jblUserType;
    private javax.swing.JLabel jtx1;
    private javax.swing.JLabel jtx2;
    private javax.swing.JLabel jtx3;
    private javax.swing.JLabel jtx4;
    private javax.swing.JPanel navContainer;
    private javax.swing.JPanel sideBar;
    private javax.swing.JPanel topBar;
    // End of variables declaration//GEN-END:variables
}
