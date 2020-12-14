/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.sysadmin;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Furniture.Furniture;
import Business.Role.RoleType;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import UserInterface.CardLayoutNavigator;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.json.JSONObject;

/**
 *
 * @author Administrator
 */
public class EnterpriseDataJPanel extends javax.swing.JPanel {

    private Account account;
    private EcoSystem system;

    /**
     * Creates new form EnterpriseDataJPanel
     */
    public EnterpriseDataJPanel() {
        initComponents();
        setButtonImage();
    }

    public EnterpriseDataJPanel(Account account, EcoSystem system) {
        this();
        this.account = account;
        this.system = system;
        CardLayoutNavigator.goNext(ChartContainer, createPieChartPanel(), "piechart");
    }

    /*-------------------------------pie chart--------------------------------*/
    private PieDataset createPieDataSet() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        Double eCounts[] = new Double[]{0.0, 0.0, 0.0, 0.0, 0.0};

        for (Enterprise e : system.getEnterprises()) {
            if (e.getAdmin().getRole().rType == RoleType.RegulateAdmin) {
                eCounts[0] += 1;
            }
            if (e.getAdmin().getRole().rType == RoleType.ForestAdmin) {
                eCounts[1] += 1;
            }
            if (e.getAdmin().getRole().rType == RoleType.ManuAdmin) {
                eCounts[2] += 1;
            }
            if (e.getAdmin().getRole().rType == RoleType.RetailAdmin) {
                eCounts[3] += 1;
            }
            if (e.getAdmin().getRole().rType == RoleType.LogisticAdmin) {
                eCounts[4] += 1;
            }
        }

        int s = system.getEnterprises().size();

        dataset.setValue("Regualte Office", eCounts[0] / s);
        dataset.setValue("Forest Logging Company", eCounts[1] / s);
        dataset.setValue("Furniture Manufacturer", eCounts[2] / s);
        dataset.setValue("Furniture Retailer", eCounts[3] / s);
        dataset.setValue("Logistice Enterprise", eCounts[4] / s);

        return dataset;
    }
     private void setButtonImage(){
         ImageIcon delete=new ImageIcon("./image/viewPie.png");
         jButton1.setIcon(delete);
         ImageIcon modify=new ImageIcon("./image/TotalOrders.png");
         //jButton2.setIcon(modify);
         ImageIcon modify1=new ImageIcon("./image/totalSales.png");
         jButton3.setIcon(modify1);
    }  
    private JFreeChart createPieChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Enterprise Types", // chart title 
                dataset, // data    
                true, // include legend   
                true,
                false);

        return chart;
    }

    private JPanel createPieChartPanel() {
        JFreeChart chart = createPieChart(createPieDataSet());
        return new ChartPanel(chart);
    }

    /*-----------------------logistic bar chart-------------------------------*/
    private CategoryDataset createLogistBarDataSet() {
        DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
        Map<Enterprise, Integer> map = new HashMap<>();
        for (Enterprise e : system.getEnterprises()) {
            if (e.getAdmin().getRole().rType == RoleType.LogisticAdmin) {
                map.put(e, 0);
            }
        }
        for (WorkRequest wr : system.getWorkQueue()) {
            for (Account a : wr.getReceivers().keySet()) {
                if (a.getRole().rType == RoleType.LogisticAdmin) {
                    Enterprise currLog = system.getEnterprises().getEnterpriseByAccout(a);
                    map.put(currLog, map.get(currLog) + 1);
                    continue;
                }
            }
        }
        for (Enterprise e : map.keySet()) {
            mDataset.addValue(map.get(e), "", e.getName());
            // mDataset.addValue((new Random()).nextInt(25), "", e.getName());
        }
        return mDataset;
    }

    private JFreeChart createLogistBarChart(CategoryDataset mDataset) {
        JFreeChart mChart = ChartFactory.createBarChart3D(
                "Logistic Status",
                "Company Name",
                "Work Request Quantity",
                mDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        CategoryPlot mPlot = (CategoryPlot) mChart.getPlot();
        //axis setting
        CategoryAxis mDomainAxis = mPlot.getDomainAxis();
        mDomainAxis.setLowerMargin(0.1);
        mDomainAxis.setUpperMargin(0.1);
        // display text on bar
        BarRenderer mRenderer = new BarRenderer();
        mRenderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        mRenderer.setItemLabelsVisible(true);
        mPlot.setRenderer(mRenderer);
        return mChart;
    }

    private JPanel createLogistBarChartPanel() {
        JFreeChart chart = createLogistBarChart(createLogistBarDataSet());
        return new ChartPanel(chart);
    }

    /*---------------------salesperson barchart-------------------------------*/
    private CategoryDataset createSalesBarDataSet() {
        DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
        Map<String, Double> map = new HashMap<>();
        map.put("Wood Sale", .0);
        map.put("Furniture Sale", .0);
        map.put("Customer purchase", .0);
        for (WorkRequest wr : system.getWorkQueue()) {
            if (wr.getSender().getRole().rType == RoleType.ForestSalesPerson) {
                JSONObject currInfo = new JSONObject(wr.getMessage());
                Double currSale = Double.parseDouble(currInfo.getString("TotalPrice"));
                map.put("Wood Sale", map.get("Wood Sale") + currSale);
            }
            if (wr.getSender().getRole().rType == RoleType.ManuSalsePerson) {
                JSONObject currInfo = new JSONObject(wr.getMessage());
                Double currSale = Double.parseDouble(currInfo.getString("TotalPrice"));
                map.put("Furniture Sale", map.get("Furniture Sale") + currSale);
            }

            if (wr.getSender().getRole().rType == RoleType.RetailAdmin) {
                JSONObject currInfo = new JSONObject(wr.getMessage());
                int fID = currInfo.getInt("furnitureID");
                int quantity = currInfo.getInt("quantity");
                Furniture currFurniture = system.getFurnitureMarket().getByID(fID);
                Double currSale = quantity * currFurniture.getPrice();
                map.put("Customer purchase", map.get("Furniture Sale") + currSale);
            }
        }

        for (String key : map.keySet()) {
            mDataset.addValue(map.get(key), "", key);
        }

        return mDataset;
    }

    private JFreeChart createSalesBarChart(CategoryDataset mDataset) {
        JFreeChart mChart = ChartFactory.createBarChart3D(
                "Sales",
                "Sales Type",
                "Sales Amount",
                mDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        CategoryPlot mPlot = (CategoryPlot) mChart.getPlot();
        //axis setting
        CategoryAxis mDomainAxis = mPlot.getDomainAxis();
        mDomainAxis.setLowerMargin(0.1);
        mDomainAxis.setUpperMargin(0.1);
        // display text on bar
        BarRenderer mRenderer = new BarRenderer();
        mRenderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        mRenderer.setItemLabelsVisible(true);
        mRenderer.setSeriesPaint(0, Color.blue);
        mPlot.setRenderer(mRenderer);
        return mChart;
    }
    
    private JPanel createSalesBarChartPanel(){
        JFreeChart chart = createSalesBarChart(createSalesBarDataSet());
        return new ChartPanel(chart);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ChartContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jButton1.setText("View All Company");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jButton3.setText("View Sales Money");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ChartContainer.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(299, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ChartContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(365, 365, 365)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(353, 353, 353))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(ChartContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CardLayoutNavigator.goNext(ChartContainer, createPieChartPanel(), "piechart");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CardLayoutNavigator.goNext(ChartContainer, createSalesBarChartPanel(), "salesbarchart");
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChartContainer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
