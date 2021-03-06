package UserInterface.FurnitureManufaCompany.DesignerRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Furniture.Furniture;
import Business.Person.Person;
import Business.Role.RoleType;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import System.Configure.DB4OUtil;
import UserInterface.ImgFilter;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.json.JSONObject;

/**
 *
 * @author Administrator
 */
public class DesignJPanel extends javax.swing.JPanel {

    private Account account;
    private EcoSystem system;
    private Enterprise currEnterprise;
    private String filename;

    public DesignJPanel() {
        initComponents();
        setButtonImage();
        setTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) this.DesignerJTable.getModel();
        model.setRowCount(0);
        WorkQueue wq = system.getWorkQueue().getRequestsBySender(account);
        for (WorkRequest wr : wq) {
            JSONObject currInfo = new JSONObject(wr.getMessage());
            Object row[] = new Object[7];
            row[0] = wr;
            row[1] = currInfo.get("Product");
            row[2] = currInfo.get("Type");
            row[3] = currInfo.get("TimberWeight");
            row[4] = wr.getSender();
            for (Account a : wr.getReceivers().keySet()) {
                if (wr.getReceivers().get(a) == true) {
                    row[5] = a.getAccountName();
                }
            }
            row[6] = wr.getStatus();
            model.addRow(row);
        }
    }

    public DesignJPanel(Account account, EcoSystem system) {
        this();
        this.account = account;
        this.system = system;
        this.currEnterprise = system.getEnterprises().getEnterpriseByEmployeeAccount(account);
        populateTypes(searchType(jtxFurnitureType.getText()));
        populateTable();
    }

    private void setTable() {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(149, 19, 19));
        cellRenderer.setForeground(Color.white);
        for (int i = 0; i < 7; i++) {
            TableColumn column = DesignerJTable.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
        }
    }

    public void populateTypes(ArrayList<String> arr) {
        listFurnitureTypes.removeAll();
        DefaultListModel model = new DefaultListModel();
        for (String each : arr) {
            model.addElement(each);
        }
        listFurnitureTypes.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSubmit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtxWeight = new javax.swing.JTextField();
        jtxName = new javax.swing.JTextField();
        Picture = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DesignerJTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listFurnitureTypes = new javax.swing.JList<>();
        jtxFurnitureType = new javax.swing.JTextField();
        lblFilename = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel3.setText("ProductName");

        Picture.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N

        DesignerJTable.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        DesignerJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ProductName", "FurnitureType", "CostTimberWeight", "Designer", "Producer", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DesignerJTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        DesignerJTable.setRowHeight(25);
        DesignerJTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        DesignerJTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(DesignerJTable);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel4.setText("CostTimberWeight");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel5.setText("FurnitureType");

        btnUpload.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        listFurnitureTypes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listFurnitureTypes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listFurnitureTypesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(listFurnitureTypes);

        jtxFurnitureType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxFurnitureTypeFocusLost(evt);
            }
        });
        jtxFurnitureType.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jtxFurnitureTypeInputMethodTextChanged(evt);
            }
        });
        jtxFurnitureType.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxFurnitureTypePropertyChange(evt);
            }
        });
        jtxFurnitureType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxFurnitureTypeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(682, 682, 682)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(229, 229, 229)
                        .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 144, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxFurnitureType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Picture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFilename, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jtxName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(272, 272, 272))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxFurnitureType, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Picture, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFilename, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void setButtonImage() {
        ImageIcon submit = new ImageIcon("./image/Submit.png");
        btnSubmit.setIcon(submit);
        ImageIcon upload = new ImageIcon("./image/Upload.png");
        btnUpload.setIcon(upload);
    }
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (inputValidate()) {
            JSONObject currInfo = new JSONObject();
            currInfo.put("Product", jtxName.getText());
            currInfo.put("TimberWeight", Double.parseDouble(jtxWeight.getText()));
            currInfo.put("Type", jtxFurnitureType.getText());
            currInfo.put("designImg", filename);
            WorkRequest wr = new WorkRequest();
            wr.setMessage(currInfo.toString());
            wr.setSender(account);
            for (Person p : currEnterprise.getDepartments().get(1).getEmployee()) {
                Account eaccount = system.getAccounts().getAccontByPerson(p);
                if (eaccount.getRole().rType == RoleType.ManuProducer) {
                    wr.getReceivers().put(eaccount, false);
                }
            }
            wr.setStatus("Ready to Produce");
            try {
                system.getWorkQueue().addRequest(wr);
                DB4OUtil.storeSystem(system);
                JOptionPane.showMessageDialog(null, "Design created success");
                emptyAll();
                populateTable();
            } catch (Exception ex) {
                Logger.getLogger(DesignJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void emptyAll() {
        this.Picture.setIcon(null);
        this.jtxName.setText("");
        jtxFurnitureType.setText("");
        jtxWeight.setText("");
        filename = null;
        lblFilename.setText("");
    }

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        createChooserWindow((JFrame) SwingUtilities.getWindowAncestor(this));
    }//GEN-LAST:event_btnUploadActionPerformed

    private void jtxFurnitureTypePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxFurnitureTypePropertyChange

    }//GEN-LAST:event_jtxFurnitureTypePropertyChange

    private void jtxFurnitureTypeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtxFurnitureTypeInputMethodTextChanged

    }//GEN-LAST:event_jtxFurnitureTypeInputMethodTextChanged

    private void jtxFurnitureTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxFurnitureTypeFocusLost

    }//GEN-LAST:event_jtxFurnitureTypeFocusLost

    private void listFurnitureTypesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listFurnitureTypesMousePressed
        jtxFurnitureType.setText(listFurnitureTypes.getSelectedValue());
    }//GEN-LAST:event_listFurnitureTypesMousePressed

    private void jtxFurnitureTypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxFurnitureTypeKeyTyped
        populateTypes(searchType(jtxFurnitureType.getText()));
    }//GEN-LAST:event_jtxFurnitureTypeKeyTyped

    private ArrayList<String> searchType(String keyWord) {
        if (keyWord.equals("")) {
            List<String> list1 = new ArrayList<String>();
            Collections.addAll(list1, Furniture.FurtinureTypes);
            return (ArrayList<String>) list1;
        }
        return Arrays.stream(Furniture.FurtinureTypes)
                .filter(s -> s.toLowerCase().contains(keyWord.toLowerCase()))
                .collect(Collectors
                        .toCollection(ArrayList<String>::new));
    }

    private boolean inputValidate() {
        if (jtxFurnitureType.getText().isEmpty() || jtxName.getText().isEmpty()
                || jtxWeight.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "textfield can not be empty");
            return false;
        }

        try {
            Double.parseDouble(jtxWeight.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cost Timber Weight should be numeric");
            return false;
        }

        if (filename == null) {
            JOptionPane.showMessageDialog(null, "Please upload the design image");
            return false;
        }

        return true;
    }

    private void createChooserWindow(JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new ImgFilter());
        fileChooser.setAcceptAllFileFilterUsed(false);

        int option = fileChooser.showOpenDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                String filepath = file.getAbsolutePath();
                filename = file.getName();
                setImg(file);

                Path temp = Files.move(Paths.get(filepath),
                        Paths.get("./image/DesignGraph/" + filename));
                lblFilename.setText(filename);

                if (temp != null) {
                    System.out.println("File renamed and moved successfully");
                } else {
                    System.out.println("Failed to move the file");
                }
            } catch (IOException ex) {
                // Logger.getLogger(DesignJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Picture.setText("");
        }
    }

    /**
     * this one display the image file in internal panel, and set data member to
     * person object
     *
     * @param file image file
     */
    private void setImg(File file) {
        try {
            BufferedImage myImg = ImageIO.read(file);
            Image dImg = myImg.getScaledInstance(400,
                    myImg.getHeight() * 400 / myImg.getWidth(),
                    Image.SCALE_SMOOTH);
            Picture.setIcon(new ImageIcon(dImg));
            Picture.setText("");
        } catch (IOException ex) {
            Picture.setText("no image");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DesignerJTable;
    private javax.swing.JLabel Picture;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jtxFurnitureType;
    private javax.swing.JTextField jtxName;
    private javax.swing.JTextField jtxWeight;
    private javax.swing.JLabel lblFilename;
    private javax.swing.JList<String> listFurnitureTypes;
    // End of variables declaration//GEN-END:variables
}
