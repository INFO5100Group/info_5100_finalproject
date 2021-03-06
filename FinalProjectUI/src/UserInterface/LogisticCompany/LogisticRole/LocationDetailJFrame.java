package UserInterface.LogisticCompany.LogisticRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Role.RoleType;
import Business.WorkQueue.WorkRequest;
import EcoSystem.EcoSystem;
import javax.swing.ImageIcon;

/**
 *
 * @author Bohan Feng
 */
public class LocationDetailJFrame extends javax.swing.JFrame {

    public WorkRequest wr;
    private EcoSystem system;

    public LocationDetailJFrame(WorkRequest wr, EcoSystem sys) {
        initComponents();
        this.wr = wr;
        this.system = sys;
        populateContent();
        setButtonImage();
    }

    private void setButtonImage() {
        ImageIcon bargain = new ImageIcon("./image/confirm.png");
        jButton1.setIcon(bargain);
    }

    public void populateContent() {
        String state = null, city = null, street = null, zip = null;
        Account currAccount = null;
        for (Account a : wr.getReceivers().keySet()) {
            if (a.getRole().rType != RoleType.LogisticAdmin || a.getRole().rType != RoleType.LogisticsPseron) {
                if (a.getRole().rType == RoleType.Customer) {
                    state = a.getPerson().getState();
                    city = a.getPerson().getCity();
                    street = a.getPerson().getStreet();
                    zip = a.getPerson().getZipCode();
                    currAccount = a;
                    break;

                } else if (a.getRole().rType == RoleType.ManuProcurementPerson
                        || a.getRole().rType == RoleType.RetailProcurementPerson) {
                    Enterprise e = system.getEnterprises().getEnterpriseByEmployeeAccount(a);
                    state = e.getState();
                    city = e.getCity();
                    street = e.getStreet();
                    zip = e.getZipCode();
                    currAccount = a;

                    break;
                }

            }

        }

        txtState.setText(state == null ? "not avaliable" : state);
        txtCity.setText(city == null ? "not avaliable" : city);
        txtStreet.setText(street == null ? "not avaliable" : street);
        txtZip.setText(zip == null ? "not avaliable" : zip);
        txtReceiver.setText(currAccount == null ? "not avaliable" : currAccount.getPerson() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        State = new javax.swing.JLabel();
        txtState = new javax.swing.JLabel();
        State1 = new javax.swing.JLabel();
        txtCity = new javax.swing.JLabel();
        txtStreet = new javax.swing.JLabel();
        State2 = new javax.swing.JLabel();
        State3 = new javax.swing.JLabel();
        txtZip = new javax.swing.JLabel();
        State4 = new javax.swing.JLabel();
        txtReceiver = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        State.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        State.setText("State:");

        txtState.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        txtState.setText("<>");

        State1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        State1.setText("City:");

        txtCity.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        txtCity.setText("<>");

        txtStreet.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        txtStreet.setText("<>");

        State2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        State2.setText("Street:");

        State3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        State3.setText("Zip Code:");

        txtZip.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        txtZip.setText("<>");

        State4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        State4.setText("Receiver:");

        txtReceiver.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        txtReceiver.setText("<>");

        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(State4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(State2)
                        .addComponent(State1)
                        .addComponent(State)
                        .addComponent(State3)))
                .addGap(157, 157, 157)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtReceiver)
                    .addComponent(txtState)
                    .addComponent(txtCity)
                    .addComponent(txtStreet)
                    .addComponent(txtZip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtState)
                        .addGap(50, 50, 50)
                        .addComponent(txtCity)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStreet)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(txtZip)
                        .addGap(56, 56, 56)
                        .addComponent(txtReceiver))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(State)
                        .addGap(50, 50, 50)
                        .addComponent(State1)
                        .addGap(53, 53, 53)
                        .addComponent(State2)
                        .addGap(43, 43, 43)
                        .addComponent(State3)
                        .addGap(56, 56, 56)
                        .addComponent(State4)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel State;
    private javax.swing.JLabel State1;
    private javax.swing.JLabel State2;
    private javax.swing.JLabel State3;
    private javax.swing.JLabel State4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel txtCity;
    private javax.swing.JLabel txtReceiver;
    private javax.swing.JLabel txtState;
    private javax.swing.JLabel txtStreet;
    private javax.swing.JLabel txtZip;
    // End of variables declaration//GEN-END:variables
}
