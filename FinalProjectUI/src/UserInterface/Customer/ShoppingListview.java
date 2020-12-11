/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Account.Account;
import Business.Furniture.Furniture;
import Business.Furniture.FurnitureDirectory;
import EcoSystem.EcoSystem;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class ShoppingListview extends javax.swing.JPanel {

    private JPanel contianer;
    private FurnitureDirectory displayFurniture;
    private FurnitureDirectory realFurniture;
    private EcoSystem system;
    private Account account;
    private int col = 4;

    public ShoppingListview() {
        initComponents();
    }

    public ShoppingListview(FurnitureDirectory df, EcoSystem sys, Account account) {
        this.setLayout(new GridLayout(0, col));
        this.displayFurniture = df;
        this.realFurniture  = sys.getFurnitureMarket();
        this.system = sys;
        this.account = account;
        populateList();
    }

    private void populateList() {
        try {
            for (Furniture f : displayFurniture) {
                FurnitureTemplate ft = new FurnitureTemplate(f, system, account);
                this.add(ft);
            }
        } catch (java.lang.NullPointerException e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Nothing Found");
        }
        
        for(int i = 0; i < 4; i++){
            JPanel emotyP = new JPanel();
            emotyP.setSize(240, 300);
            this.add(emotyP);
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

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}