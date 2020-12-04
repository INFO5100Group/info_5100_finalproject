/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ForestryCompany.ManagerRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Person.Person;
import Business.Role.RoleType;
import Business.Wood.WoodStorage;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import System.Configure.DB4OUtil;
import static System.Configure.HttpRequestSender.executePost;
import UserInterface.Register.RegistForEnterpriseJPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.json.JSONObject;

/**
 *
 * @author Administrator
 */
public class ManagerWorkJPanel extends javax.swing.JPanel {
    
    private Account account;
    private EcoSystem system;
    
    public ManagerWorkJPanel() {
        initComponents();
        LicenseJTable.getTableHeader().setFont(new Font("Yu Gothic UI Light" , Font.BOLD , 15));
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(74,192,255));
        for(int i=0;i<7;i++){
            TableColumn column = LicenseJTable.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);
        }
        setButtonImage();
    }
    
    public ManagerWorkJPanel(Account a, EcoSystem sys){
        this();
        this.system = sys;
        this.account = a;
        populateTable();
        populateCombo();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)this.LicenseJTable.getModel();
        model.setRowCount(0);
        WorkQueue wq = system.getWorkQueue().getRequestsBySender(account);
        for(WorkRequest wr : wq){
            if(!wr.isIsCompleted()){
                Enterprise e = system.getEnterprises().getEnterpriseByEmployeeAccount(account);
                JSONObject currInfo = new JSONObject(wr.getMessage());
                Object row[] = new Object[7];
                row[1] = e.getName() + "-" +account.getAccountName();
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
    
    public void populateCombo(){
        comboEndDay.removeAllItems();
        comboEndYear.removeAllItems();
        comboEndMonth.removeAllItems();
        comboStartDay.removeAllItems();
        comboStartMonth.removeAllItems();
        comboStartYear.removeAllItems();
        
        for(int i  = 1; i < 13; i++){
            comboEndMonth.addItem(i + "");
            comboStartMonth.addItem(i + "");
        }
        for(int i = 0; i < 3; i++){
            comboEndYear.addItem((new Date()).getYear() + i + 1900 + "");
            comboStartYear.addItem((new Date()).getYear() + i + 1900 + "");
        }
        populatecomboDay();
    }
    
    void populatecomboDay(){
        comboEndDay.removeAllItems();
        comboStartDay.removeAllItems();
        switch(comboEndMonth.getSelectedIndex()){
            case 0:case 2:case 4:case 6:case 7:case 9:case 11:
                for(int i = 1; i < 32; i++){
                    comboEndDay.addItem(i + "");
                }
            break;
            case 3:case 5:case 8:case 10: 
                for(int i = 1; i < 31; i++){
                    comboEndDay.addItem(i + "");
                }
            break;
            case 1:
                for(int i = 1; i < 30; i++){
                    comboEndDay.addItem(i + "");
                }
        }
        switch(comboStartMonth.getSelectedIndex()){
            case 0:case 2:case 4:case 6:case 7:case 9:case 11:
                for(int i = 1; i < 32; i++){
                    comboStartDay.addItem(i + "");
                }
            break;
            case 3:case 5:case 8:case 10: 
                for(int i = 1; i < 31; i++){
                    comboStartDay.addItem(i + "");
                }
            break;
            case 1:
                for(int i = 1; i < 30; i++){
                    comboStartDay.addItem(i + "");
                }
        }
    }
    private void setButtonImage(){
         ImageIcon apply=new ImageIcon("./image/Apply.png");
         JButton btnApply=new JButton(apply);
         ImageIcon complete=new ImageIcon("./image/Complete.png");
         JButton btnComplete=new JButton(complete);
         ImageIcon upload=new ImageIcon("./image/Upload.png");
         JButton btnUpload=new JButton(upload);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LicenseJTable = new javax.swing.JTable();
        jtxSpecies = new javax.swing.JTextField();
        jtxWeight = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnApply = new javax.swing.JButton();
        btnComplete = new javax.swing.JButton();
        MapJPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboStartYear = new javax.swing.JComboBox<>();
        comboStartMonth = new javax.swing.JComboBox<>();
        comboStartDay = new javax.swing.JComboBox<>();
        comboEndYear = new javax.swing.JComboBox<>();
        comboEndMonth = new javax.swing.JComboBox<>();
        comboEndDay = new javax.swing.JComboBox<>();
        t = new javax.swing.JLabel();
        t1 = new javax.swing.JLabel();
        t2 = new javax.swing.JLabel();
        t3 = new javax.swing.JLabel();
        t4 = new javax.swing.JLabel();
        t5 = new javax.swing.JLabel();
        jtxlongitude = new javax.swing.JTextField();
        jtxLatitude = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel6.setText("End Time");

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
        jScrollPane1.setViewportView(LicenseJTable);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel3.setText("Timber Species");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel4.setText("Timber Weight(lb)");

        btnApply.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        btnComplete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MapJPanelLayout = new javax.swing.GroupLayout(MapJPanel);
        MapJPanel.setLayout(MapJPanelLayout);
        MapJPanelLayout.setHorizontalGroup(
            MapJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MapJPanelLayout.setVerticalGroup(
            MapJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel7.setText("Location");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel8.setText("Start Time");

        comboStartYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboStartMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboStartMonth.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboStartMonthPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboStartMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboStartMonthMouseClicked(evt);
            }
        });
        comboStartMonth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboStartMonthPropertyChange(evt);
            }
        });

        comboStartDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboEndYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboEndMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEndMonth.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboEndMonthPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboEndMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEndMonthActionPerformed(evt);
            }
        });

        comboEndDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        t.setText("Year");

        t1.setText("Month");

        t2.setText("Day");

        t3.setText("Year");

        t4.setText("Month");

        t5.setText("Day");

        jtxlongitude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxlongitudeActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel9.setText("longitude");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel10.setText("Latitude ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtxSpecies)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(comboEndYear, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboEndMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(t3)
                                                .addGap(52, 52, 52)
                                                .addComponent(t4)
                                                .addGap(46, 46, 46)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(t5)
                                            .addComponent(comboEndDay, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jtxWeight)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(comboStartYear, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboStartMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(t)
                                                .addGap(52, 52, 52)
                                                .addComponent(t1)
                                                .addGap(46, 46, 46)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(t2)
                                            .addComponent(comboStartDay, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtxLatitude)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtxlongitude, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(MapJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t)
                            .addComponent(t1)
                            .addComponent(t2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(comboStartYear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboStartDay, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboStartMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t3)
                            .addComponent(t4)
                            .addComponent(t5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboEndYear, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboEndDay, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboEndMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxlongitude, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtxLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MapJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, Short.MAX_VALUE)
                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        if(inputValidate()){
            // 存地址
            JSONObject addressObj = null;
            try{
                addressObj = getLocation(jtxLatitude.getText(), jtxlongitude.getText());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Your location is not valid");
            }
            System.out.print(getLocation(jtxLatitude.getText(), jtxlongitude.getText()).getString("state"));

            String jsonString = "{"
                + "\"Species\": \"" +jtxSpecies.getText() +"\","
                + "\"Weight\": \"" +jtxWeight.getText() +"\","
                + "\"Latitude\": \"" +jtxLatitude.getText() +"\","
                + "\"longitude\": \"" +jtxlongitude.getText() +"\","
                + "\"StartTime\": \"" + comboStartYear.getSelectedItem() + "-" + comboStartMonth.getSelectedItem() + "-" + comboStartDay.getSelectedItem()+"\","
                + "\"EndTime\": \"" + comboEndYear.getSelectedItem() + "-" + comboEndMonth.getSelectedItem() + "-" + comboEndDay.getSelectedItem() +"\","
                + "\"State\": \"" + addressObj.getString("state")+"\""
                + "}"; 
           
           WorkRequest wr = new WorkRequest();
           wr.setMessage(jsonString);
           wr.setSender(account);
           wr.setStatus("Processing");
           
           boolean isAssigened = false;
           Enterprise reg = null;
           
           // 循环全部公司
           for(Enterprise eachE : system.getEnterprises()){
               // 找到监管部门
               if(eachE.getAdmin().getRole().rType==RoleType.RegulateAdmin){
                   // 找到对应地区
                   if(eachE.getState().toLowerCase().equals(addressObj.getString("state").toLowerCase())){
                        // 将对应监管部门中的 officer 和 scientist 加入receivers 
                        for(Person rever : eachE.getDepartments().get(0).getEmployee()){
                            wr.getReceivers().put(system.getAccounts().getAccontByPerson(rever), false);
                        }
                        // 检查是否有对应地区的监管
                        isAssigened = true;
                        reg = eachE;
                   }
               }
           }
           
            if(!isAssigened){
                JOptionPane.showMessageDialog(null, "There is no regulate office in your area");
                return ;
            }
            
            // add request to queue
            try {
                system.getWorkQueue().addRequest(wr);
            } catch (Exception ex) {
                Logger.getLogger(RegistForEnterpriseJPanel.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "There is no suitable regulate office in your area");
                return;
            }
            
           System.out.print(getLocation(jtxLatitude.getText(), jtxlongitude.getText()).getString("state"));
           JOptionPane.showMessageDialog(null, " Your repuest is send to " + reg.getName() + " , plase wait for your request appreoved");
           DB4OUtil.storeSystem(system);
           populateTable();
        }   
    }//GEN-LAST:event_btnApplyActionPerformed
    
    public JSONObject getLocation(String lat, String lon) {

        String url = "https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat="+lat+"&lon="+lon+"&zoom=16&addressdetails=3";
        String reponse = executePost(url, "");
        JSONObject obj = new JSONObject(reponse);
        return obj.getJSONObject("address");
 
    }
    
    boolean inputValidate(){
        if(jtxWeight.getText().isEmpty()|| jtxlongitude.getText().isEmpty() 
            || jtxSpecies.getText().isEmpty() || jtxLatitude.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all text fields");
            return false;
        }
        
        try{
            Double.parseDouble(jtxlongitude.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "longtitude should be numeric");
            return false;
        }
        
        try{
            Double.parseDouble(jtxLatitude.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Latitude  should be numeric");
            return false;
        }
        
        try{
            Double.parseDouble(jtxWeight.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Weight  should be numeric");
            return false;
        }
        
        Date StartDate = new Date(
                Integer.parseInt((String) comboStartYear.getSelectedItem()),
                Integer.parseInt((String) comboStartMonth.getSelectedItem()),
                Integer.parseInt((String) comboStartDay.getSelectedItem())
        );
        Date EndDate = new Date(
                Integer.parseInt((String) comboEndYear.getSelectedItem()),
                Integer.parseInt((String) comboEndMonth.getSelectedItem()),
                Integer.parseInt((String) comboEndDay.getSelectedItem())
        );
        
        if(!EndDate.after(StartDate)){
            JOptionPane.showMessageDialog(null, "End date should after start date");
            return false;
        }
        return true;
    }
    
    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        int selectedRow = this.LicenseJTable.getSelectedRow();
        Enterprise currEnterprise = system.getEnterprises().getEnterpriseByEmployeeAccount(account);
        if(selectedRow >= 0){
            WorkRequest wr = (WorkRequest)(LicenseJTable.getValueAt(selectedRow, 0));
            if(!wr.getStatus().equals("Approved")){
                JOptionPane.showMessageDialog(null, "this license is not approved");
                return;
            }
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "You confirm to complete this logging ?" , "Warning", dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){ 
                wr.setIsCompleted(true);
                wr.resolve();
                JSONObject currInfo = new JSONObject(wr.getMessage());
                if(currEnterprise.getWoodStorage() == null){
                    currEnterprise.setWoodStorage(new WoodStorage());
                }
                currEnterprise.getWoodStorage().addWood(currInfo.getString("Species"), Double.parseDouble(currInfo.getString("Weight")));
                DB4OUtil.storeSystem(system);
                populateTable();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void jtxlongitudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxlongitudeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxlongitudeActionPerformed

    private void comboStartMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboStartMonthMouseClicked

    }//GEN-LAST:event_comboStartMonthMouseClicked

    private void comboEndMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEndMonthActionPerformed

    }//GEN-LAST:event_comboEndMonthActionPerformed

    private void comboStartMonthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboStartMonthPropertyChange

    }//GEN-LAST:event_comboStartMonthPropertyChange

    private void comboStartMonthPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboStartMonthPopupMenuWillBecomeInvisible
        populatecomboDay();
    }//GEN-LAST:event_comboStartMonthPopupMenuWillBecomeInvisible

    private void comboEndMonthPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboEndMonthPopupMenuWillBecomeInvisible
        populatecomboDay();
    }//GEN-LAST:event_comboEndMonthPopupMenuWillBecomeInvisible


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable LicenseJTable;
    private javax.swing.JPanel MapJPanel;
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnComplete;
    private javax.swing.JComboBox<String> comboEndDay;
    private javax.swing.JComboBox<String> comboEndMonth;
    private javax.swing.JComboBox<String> comboEndYear;
    private javax.swing.JComboBox<String> comboStartDay;
    private javax.swing.JComboBox<String> comboStartMonth;
    private javax.swing.JComboBox<String> comboStartYear;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtxLatitude;
    private javax.swing.JTextField jtxSpecies;
    private javax.swing.JTextField jtxWeight;
    private javax.swing.JTextField jtxlongitude;
    private javax.swing.JLabel t;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    private javax.swing.JLabel t3;
    private javax.swing.JLabel t4;
    private javax.swing.JLabel t5;
    // End of variables declaration//GEN-END:variables
}
