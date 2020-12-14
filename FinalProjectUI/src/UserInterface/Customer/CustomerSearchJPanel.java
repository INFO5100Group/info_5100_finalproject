package UserInterface.Customer;

import Business.Account.Account;
import Business.Furniture.FurnitureDirectory;
import EcoSystem.EcoSystem;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

/**
 *
 * @author Administrator
 */
public class CustomerSearchJPanel extends javax.swing.JPanel {

    private Account account;
    private EcoSystem system;
    private FurnitureDirectory displayList, totalList;

    public CustomerSearchJPanel() {
        initComponents();
        /*OrderJTable.getTableHeader().setFont(new Font("Yu Gothic UI Light" , Font.BOLD , 15));
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(74,192,255));
        for(int i=0;i<4;i++){
            TableColumn column = OrderJTable.getTableHeader().getColumnModel().getColumn(i);
             column.setHeaderRenderer(cellRenderer);
        }*/
        // setButtonImage();

    }

    public CustomerSearchJPanel(Account account, EcoSystem system) {
        this();
        this.account = account;
        this.system = system;
        totalList = system.getFurnitureMarket();
        displayList = totalList;
        loadListView();
        setImage();
    }

    public void loadListView() {
        jSplitPane1.setBottomComponent(new JScrollPane(new ShoppingListview(displayList, system, account)));
        populateCombo();
    }
    public void setImage(){
        ImageIcon bt2=new ImageIcon("./image/searchbtn.png");
        btnSearch.setIcon(bt2);
        ImageIcon bt1=new ImageIcon("./image/搜索 (1).png");
        jLabel5.setIcon(bt1);        
    }
    public void populateCombo() {
        comboType.removeAllItems();
        comboType.addItem("");
        comboWoodType.removeAllItems();
        comboWoodType.addItem("");
        for (String t : displayList.getAllType()) {
            comboType.addItem(t);
        }
        for (String wt : displayList.getAllWood()) {
            comboWoodType.addItem(wt);
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

        jPanel3 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        bottomBar = new javax.swing.JPanel();
        searchBar = new javax.swing.JPanel();
        jtxSearch = new javax.swing.JTextField();
        comboType = new javax.swing.JComboBox<>();
        comboWoodType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jtxMin = new javax.swing.JTextField();
        jtxMax = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Type = new javax.swing.JLabel();
        Metrial = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        javax.swing.GroupLayout bottomBarLayout = new javax.swing.GroupLayout(bottomBar);
        bottomBar.setLayout(bottomBarLayout);
        bottomBarLayout.setHorizontalGroup(
            bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1256, Short.MAX_VALUE)
        );
        bottomBarLayout.setVerticalGroup(
            bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(bottomBar);

        searchBar.setBackground(new java.awt.Color(255, 255, 255));

        jtxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxSearchActionPerformed(evt);
            }
        });

        comboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboWoodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel1.setText("Price Range");

        jtxMin.setToolTipText("Min");
        jtxMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxMinActionPerformed(evt);
            }
        });

        jtxMax.setToolTipText("Max");
        jtxMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxMaxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        jLabel2.setText("——");

        Type.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        Type.setText("Type");

        Metrial.setFont(new java.awt.Font("Yu Gothic UI", 1, 15)); // NOI18N
        Metrial.setText("Material");

        jLabel3.setText("Min");

        jLabel4.setText("Max");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout searchBarLayout = new javax.swing.GroupLayout(searchBar);
        searchBar.setLayout(searchBarLayout);
        searchBarLayout.setHorizontalGroup(
            searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(searchBarLayout.createSequentialGroup()
                        .addComponent(Type)
                        .addGap(18, 18, 18)
                        .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Metrial)
                        .addGap(18, 18, 18)
                        .addComponent(comboWoodType, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(searchBarLayout.createSequentialGroup()
                                .addComponent(jtxMin, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2)))
                        .addGap(33, 33, 33)
                        .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxMax, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jtxSearch))
                .addGap(57, 57, 57)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        searchBarLayout.setVerticalGroup(
            searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchBarLayout.createSequentialGroup()
                        .addComponent(jtxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4))
                        .addGap(2, 2, 2)
                        .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboWoodType, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Type)
                                .addComponent(Metrial))
                            .addGroup(searchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtxMin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jtxMax, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(searchBar);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxSearchActionPerformed

    private void jtxMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxMinActionPerformed

    private void jtxMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxMaxActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(checkValidate()){
            displayList = getSearchResult();
            loadListView();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private FurnitureDirectory getSearchResult() {
        FurnitureDirectory result = totalList;
        if (!jtxSearch.getText().isEmpty()) {
            result = result.SearchByName(jtxSearch.getText());
        }
        if (!jtxMax.getText().isEmpty() && !jtxMin.getText().isEmpty()) {
            double searchMin = Double.parseDouble(jtxMin.getText());
            double searchMax = Double.parseDouble(jtxMax.getText());
            result = result.SearchByPrice(searchMin, searchMax);
        }
        if(comboType.getSelectedIndex() != 0){
            String type = (String) comboType.getSelectedItem();
            result = result.SearchByType(type);
        }
        if(comboWoodType.getSelectedIndex() != 0){
            String wood = (String) comboWoodType.getSelectedItem();
            result = result.SearchByWood(wood);
        }
        return result;
    }

    private boolean checkValidate() {
        if (!jtxMax.getText().isEmpty() && !jtxMin.getText().isEmpty()) {
            try {
                double searchMin = Double.parseDouble(jtxMin.getText());
                double searchMax = Double.parseDouble(jtxMax.getText());
                if (searchMin > searchMax) {
                    javax.swing.JOptionPane.showMessageDialog(null,
                            "Min price cannot larger than max price");
                    return false;
                }
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "Wrong input format for min price and max price");
                return false;
            }
        }
        return true;
    }

//    private void setButtonImage(){
//         ImageIcon search=new ImageIcon("./image/search.png");
//         btnSearch.setIcon(search);
//         ImageIcon order=new ImageIcon("./image/order.png");
//         btnOrder.setIcon(order);
//         ImageIcon lable=new ImageIcon("./image/订 单.png");
//         jLabel1.setIcon(lable);
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Metrial;
    private javax.swing.JLabel Type;
    private javax.swing.JPanel bottomBar;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comboType;
    private javax.swing.JComboBox<String> comboWoodType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jtxMax;
    private javax.swing.JTextField jtxMin;
    private javax.swing.JTextField jtxSearch;
    private javax.swing.JPanel searchBar;
    // End of variables declaration//GEN-END:variables
}
