/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Furniture.Furniture;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import System.Configure.DB4OUtil;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.json.JSONObject;

/**
 *
 * @author Bohan Feng
 */
public class ShoppingHistoryTemplete extends javax.swing.JPanel {

    private WorkRequest wr;
    private EcoSystem system;
    private Furniture currFurniture;
    private JSONObject currInfo;
    
    public ShoppingHistoryTemplete() {
        initComponents();
        btnReceive.setVisible(false);
    }

    public ShoppingHistoryTemplete(WorkRequest wr, EcoSystem system) {
        this();
        this.wr = wr;
        this.system = system;
        currInfo = new JSONObject(wr.getMessage());
        currFurniture = system.getFurnitureMarket().getByID((Integer)currInfo.get("furnitureID"));
        populateContent();
    }
    
    public void populateContent(){
        txtName.setText(currFurniture.getName());
        txtQty.setText("Qty : " + currInfo.get("quantity"));
        txtStatus.setText(wr.getStatus());
        if(wr.getStatus().equals("Delivered")){
            btnReceive.setVisible(true);
        }
        if(wr.getStatus().equals("Customer placed an order")){
           ImageIcon lb1=new ImageIcon("./image/待处理.png");
           jLabel1.setIcon(lb1);
        }
        if(wr.getStatus().equals("Select Loggistic Company")){
           ImageIcon lb2=new ImageIcon("./image/配送中.png");
           jLabel1.setIcon(lb2); 
        }
        if(wr.getStatus().equals("Delivered")){
           ImageIcon lb3=new ImageIcon("./image/待自提.png");
           jLabel1.setIcon(lb3); 
        }
        try {
            File imgFile = new File("./image/FurnitureImage/" + currFurniture.getImage());
            BufferedImage myImg = ImageIO.read(imgFile);
            Image dImg = myImg.getScaledInstance(300,
                    myImg.getHeight() * 300 / myImg.getWidth(),
                    Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(dImg));
            lblImage.setText("");
        }catch (Exception e){
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

        lblImage = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtQty = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        btnReceive = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("jLabel1");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.setText("Furniture Name");

        txtQty.setText("Qty : 5");

        txtStatus.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        txtStatus.setText("Customer place an Order");

        btnReceive.setBackground(new java.awt.Color(255, 255, 255));
        btnReceive.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnReceive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReceiveMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnReceiveMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 17)); // NOI18N
        jLabel2.setText("Confirm receive");

        javax.swing.GroupLayout btnReceiveLayout = new javax.swing.GroupLayout(btnReceive);
        btnReceive.setLayout(btnReceiveLayout);
        btnReceiveLayout.setHorizontalGroup(
            btnReceiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReceiveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnReceiveLayout.setVerticalGroup(
            btnReceiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReceiveLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtQty)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(291, 291, 291))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(btnReceive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtName)
                        .addGap(22, 22, 22)
                        .addComponent(txtQty)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReceive, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReceiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReceiveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReceiveMouseClicked

    private void btnReceiveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReceiveMousePressed
        if(wr.getStatus().equals("Delivered")){
            wr.resolve();
            wr.setStatus("Received");
            DB4OUtil.storeSystem(system);
            populateContent();
        }
    }//GEN-LAST:event_btnReceiveMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnReceive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtQty;
    private javax.swing.JLabel txtStatus;
    // End of variables declaration//GEN-END:variables
}