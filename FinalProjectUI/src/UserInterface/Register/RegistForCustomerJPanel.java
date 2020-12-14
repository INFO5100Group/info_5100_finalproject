package UserInterface.Register;

import Business.Account.Account;
import Business.Person.Person;
import EcoSystem.DataValidater;
import EcoSystem.EcoSystem;
import System.AccountRole.CustomerRole;
import System.Configure.DB4OUtil;
import UserInterface.CardLayoutNavigator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class RegistForCustomerJPanel extends javax.swing.JPanel {

    JPanel container;
    EcoSystem system;

    public RegistForCustomerJPanel(JPanel ups, EcoSystem sys) {
        initComponents();
        this.container = ups;
        this.system = sys;
        setrbtnCommand();
        setButtonImage();
        populateCombo();
    }

    public void setrbtnCommand() {
        rbtnFemale.setActionCommand("Female");
        rbtnMale.setActionCommand("Male");
        rbtnOther.setActionCommand("Other");
    }

    public void populateCombo() {
        ComboState.removeAllItems();
        for (String s : DataValidater.states.keySet()) {
            ComboState.addItem(s);
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

        sexGroup = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        rbtnOther = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxUName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxPWord = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxFName = new javax.swing.JTextField();
        jtxCity = new javax.swing.JTextField();
        jtxLName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtxStreet = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rbtnMale = new javax.swing.JRadioButton();
        jtxEmail = new javax.swing.JTextField();
        rbtnFemale = new javax.swing.JRadioButton();
        jtxZipCode = new javax.swing.JTextField();
        btnRegist = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnOut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ComboState = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel7.setText("Password:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 270, 143, 35));

        sexGroup.add(rbtnOther);
        rbtnOther.setText("Other");
        add(rbtnOther, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 430, 78, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel8.setText("UserName:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 190, 143, 35));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel3.setText("Gender:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 430, 143, 35));
        add(jtxUName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 190, 201, 35));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel4.setText("First And Last Name:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 120, 178, 35));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel9.setText("Zip Code:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 720, 143, 35));
        add(jtxPWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 270, 201, 35));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel6.setText("City:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 570, 143, 35));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel10.setText("Street:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 640, 143, 35));

        jtxFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxFNameActionPerformed(evt);
            }
        });
        add(jtxFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 120, 143, 35));
        add(jtxCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 570, 201, 35));
        add(jtxLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1570, 120, 143, 35));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel11.setText("State:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 500, 143, 35));
        add(jtxStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 640, 201, 35));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 15)); // NOI18N
        jLabel12.setText("Email:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 350, 143, 35));

        sexGroup.add(rbtnMale);
        rbtnMale.setText("Male");
        rbtnMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMaleActionPerformed(evt);
            }
        });
        add(rbtnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 430, 76, -1));
        add(jtxEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 350, 201, 35));

        sexGroup.add(rbtnFemale);
        rbtnFemale.setText("Female");
        rbtnFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFemaleActionPerformed(evt);
            }
        });
        add(rbtnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 430, -1, -1));
        add(jtxZipCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 720, 201, 35));

        btnRegist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistActionPerformed(evt);
            }
        });
        add(btnRegist, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 790, 183, 43));
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1660, 570, 36, 37));
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1660, 620, 36, 37));
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1660, 500, 36, 37));
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1660, 710, 36, 37));
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1660, 270, 36, 37));
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1720, 350, 36, 37));
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1660, 190, 36, 37));
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1720, 120, 36, 37));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jLabel1.setText("Regist As Customer");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 30, -1, -1));

        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });
        add(btnOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1850, 0, 30, 30));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 900));

        ComboState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(ComboState, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 500, 201, 35));
    }// </editor-fold>//GEN-END:initComponents
    private void setButtonImage() {
        ImageIcon imageIcon = new ImageIcon("./image/regist.png");
        btnRegist.setIcon(imageIcon);
        ImageIcon out = new ImageIcon("./image/hongcha.png");
        btnOut.setIcon(out);
        ImageIcon customer = new ImageIcon("./image/发送的消息.png");
        jLabel2.setIcon(customer);
    }
    private void rbtnMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnMaleActionPerformed

    private void rbtnFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnFemaleActionPerformed

    private void jtxFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxFNameActionPerformed

    private void btnRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistActionPerformed
        if (inputValidate()) {
            Person newPerson = new Person(jtxFName.getText(), jtxLName.getText(), sexGroup.getSelection().getActionCommand());
            newPerson.setCity(jtxCity.getText());
            newPerson.setEmail(jtxEmail.getText());
            newPerson.setState((String) ComboState.getSelectedItem());
            newPerson.setStreet(jtxStreet.getText());
            newPerson.setZipCode(jtxZipCode.getText());
            Account newAccount = new Account(jtxUName.getText(), jtxPWord.getText(), newPerson, new CustomerRole());
            boolean addAccountSuccess = system.getAccounts().addAccount(newAccount);
            if (!addAccountSuccess) {
                JOptionPane.showMessageDialog(null, newAccount.getAccountName() + " cannot add account, pleanse change to another user name");
            } else {
                JOptionPane.showMessageDialog(null, newAccount.getAccountName() + " Account created");
                DB4OUtil.storeSystem(system);
                CardLayoutNavigator.goBack(container, this);
            }
        }
    }//GEN-LAST:event_btnRegistActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        CardLayoutNavigator.logout(container, this);
    }//GEN-LAST:event_btnOutActionPerformed

    private boolean inputValidate() {
        boolean isEmpty = this.jtxFName.getText().equals("")
                || this.jtxLName.getText().equals("")
                || this.jtxUName.getText().equals("")
                || this.jtxPWord.getText().equals("")
                || this.jtxCity.getText().equals("")
                || this.jtxStreet.getText().equals("")
                || this.jtxZipCode.getText().equals("")
                || this.jtxEmail.getText().equals("");
        if (isEmpty) {
            JOptionPane.showMessageDialog(null, "Please fill all text fields");
            return false;
        }

        boolean isSelect = sexGroup.getSelection() != (null);
        if (!isSelect) {
            JOptionPane.showMessageDialog(null, "Please Select a Gender");
            return false;
        }

        boolean emailCorrect = DataValidater.EmailPatternCorrect(jtxEmail.getText());

        if (!emailCorrect) {
            JOptionPane.showMessageDialog(null, "Please Enter a validated email");
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboState;
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnRegist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jtxCity;
    private javax.swing.JTextField jtxEmail;
    private javax.swing.JTextField jtxFName;
    private javax.swing.JTextField jtxLName;
    private javax.swing.JTextField jtxPWord;
    private javax.swing.JTextField jtxStreet;
    private javax.swing.JTextField jtxUName;
    private javax.swing.JTextField jtxZipCode;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JRadioButton rbtnOther;
    private javax.swing.ButtonGroup sexGroup;
    // End of variables declaration//GEN-END:variables
}
