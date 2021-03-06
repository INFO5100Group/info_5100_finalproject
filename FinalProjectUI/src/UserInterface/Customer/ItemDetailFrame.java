package UserInterface.Customer;

import Business.Account.Account;
import Business.Furniture.Furniture;
import Business.Furniture.FurnitureDirectory;
import EcoSystem.EcoSystem;
import UserInterface.CardLayoutNavigator;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Bohan Feng
 */
public final class ItemDetailFrame extends javax.swing.JFrame {

    private static DecimalFormat df2 = new DecimalFormat(".##");
    private Furniture currFurniture;
    private FurnitureDirectory realFurnitures;
    private EcoSystem system;
    private Account account;
    private int remain;

    public ItemDetailFrame(Furniture f, EcoSystem sys, Account acc) {

        this.system = sys;
        this.account = acc;
        currFurniture = f;
        this.remain = sys.getFurnitureMarket().getRemain(f);
        initComponents();
        populateContnet();
    }

    public void populateContnet() {
        this.remain = system.getFurnitureMarket().getRemain(currFurniture);
        txtName.setText(currFurniture.getName());
        txtType.setText(currFurniture.getType());
        txtWoodType.setText(currFurniture.getWoodType());
        jSpinner1.setValue(remain == 0 ? 0 : 1);
        try {
            txtSeller.setText(currFurniture.getSeller());
            txtManu.setText(currFurniture.getManufacturer());
        } catch (Exception e) {

        }

        txtAva.setText(remain > 0 ? "In Stock" : "Unavaliable");
        try {
            txtSize.setText(currFurniture.getHeight() + " x "
                    + currFurniture.getLength() + " x "
                    + currFurniture.getWidth());
        } catch (Exception e) {
            txtSize.setText("Not Avaliable");
        }
        txtPrice.setText("$" + df2.format(currFurniture.getPrice()));
        txtBuy.setText("Buy with price of $ " + df2.format(currFurniture.getPrice() * (Integer) jSpinner1.getValue()));
        try {
            File imgFile = new File("./image/FurnitureImage/" + currFurniture.getImage());
            BufferedImage myImg = ImageIO.read(imgFile);
            Image dImg = myImg.getScaledInstance(650,
                    myImg.getHeight() * 650 / myImg.getWidth(),
                    Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(dImg));
            lblImage.setText("");
        } catch (Exception e) {
            lblImage.setText("No Image");
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

        container = new javax.swing.JPanel();
        itemView = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        txtType = new javax.swing.JLabel();
        txtWoodType = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        txtManu = new javax.swing.JLabel();
        txtSeller = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSize = new javax.swing.JLabel();
        txtAva = new javax.swing.JLabel();
        txtPrice = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner(new SpinnerNumberModel(0, 0, remain, 1));
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtBuy = new javax.swing.JLabel();
        txtAlert = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        container.setLayout(new java.awt.CardLayout());

        itemView.setBackground(new java.awt.Color(255, 255, 255));
        itemView.setPreferredSize(new java.awt.Dimension(100, 670));

        txtName.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        txtName.setText("Furniture Name");

        txtType.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        txtType.setForeground(new java.awt.Color(150, 150, 150));
        txtType.setText("Type");

        txtWoodType.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        txtWoodType.setForeground(new java.awt.Color(150, 150, 150));
        txtWoodType.setText("Wood Type");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("Image");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtManu.setText("ManuFacturer");

        txtSeller.setText("Seller");

        jLabel2.setText("Size:");

        txtSize.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        txtSize.setText("30 x 30 x 30");

        txtAva.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAva.setText("In Stock");

        txtPrice.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtPrice.setText("$ 150.00");

        jSpinner1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jSpinner1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jSpinner1AncestorRemoved(evt);
            }
        });
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jSpinner1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSpinner1MouseClicked(evt);
            }
        });

        jLabel3.setText("Quantity");

        jPanel1.setBackground(new java.awt.Color(255, 69, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        txtBuy.setFont(new java.awt.Font("Yu Gothic UI", 1, 22)); // NOI18N
        txtBuy.setForeground(new java.awt.Color(255, 255, 255));
        txtBuy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBuy.setText("Buy with price of $150");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtBuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuy, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout itemViewLayout = new javax.swing.GroupLayout(itemView);
        itemView.setLayout(itemViewLayout);
        itemViewLayout.setHorizontalGroup(
            itemViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(itemViewLayout.createSequentialGroup()
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAlert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(itemViewLayout.createSequentialGroup()
                        .addGroup(itemViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(itemViewLayout.createSequentialGroup()
                                .addComponent(txtType)
                                .addGap(96, 96, 96)
                                .addComponent(txtWoodType))
                            .addGroup(itemViewLayout.createSequentialGroup()
                                .addComponent(txtManu)
                                .addGap(52, 52, 52)
                                .addComponent(txtSeller))
                            .addComponent(jLabel2)
                            .addComponent(txtAva)
                            .addComponent(txtPrice)
                            .addComponent(jLabel3)
                            .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 118, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        itemViewLayout.setVerticalGroup(
            itemViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemViewLayout.createSequentialGroup()
                .addGroup(itemViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(itemViewLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(itemViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtManu)
                            .addComponent(txtSeller))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(itemViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtType)
                            .addComponent(txtWoodType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(txtPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAva)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(itemViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(itemViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        container.add(itemView, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        jPanel1.setBackground(new Color(205, 19, 0));
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        jPanel1.setBackground(new Color(255, 69, 0));
        JPanel checkout = new CheckoutJPanel(currFurniture, system, account, (Integer) jSpinner1.getValue(), container);
        CardLayoutNavigator.goNext(container, checkout, "Checkout " + account.getAccountName());
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jSpinner1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinner1MouseClicked

    }//GEN-LAST:event_jSpinner1MouseClicked

    private void jSpinner1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jSpinner1AncestorAdded

    }//GEN-LAST:event_jSpinner1AncestorAdded

    private void jSpinner1AncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jSpinner1AncestorRemoved

    }//GEN-LAST:event_jSpinner1AncestorRemoved

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        
        if (remain > 0) {
            if ((Integer) jSpinner1.getValue() < 1) {
                jSpinner1.setValue(1);
            } else if ((Integer) jSpinner1.getValue() >= remain) {
                jSpinner1.setValue(remain);
                txtAlert.setText("There is only " + remain + " items in stock");
            } else {
                txtAlert.setText("");
                txtBuy.setText("Buy with price of $ " + df2.format(currFurniture.getPrice() * (Integer) jSpinner1.getValue()));
            }
        }else{
            jSpinner1.setValue(0);
        }


    }//GEN-LAST:event_jSpinner1StateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JPanel itemView;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel txtAlert;
    private javax.swing.JLabel txtAva;
    private javax.swing.JLabel txtBuy;
    private javax.swing.JLabel txtManu;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtPrice;
    private javax.swing.JLabel txtSeller;
    private javax.swing.JLabel txtSize;
    private javax.swing.JLabel txtType;
    private javax.swing.JLabel txtWoodType;
    // End of variables declaration//GEN-END:variables
}
