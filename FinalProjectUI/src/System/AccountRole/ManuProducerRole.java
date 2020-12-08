package System.AccountRole;

import javax.swing.JPanel;

import Business.Account.Account;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import UserInterface.FurnitureManufaCompany.ProducerRole.ProducerJPanel;
import UserInterface.NavgateableJPanel;

public class ManuProducerRole extends Role {

    public ManuProducerRole() {
        this.rType = RoleType.ManuProducer;
    }

    @Override
    public JPanel createWorkArea(JPanel arg0, Account arg1, EcoSystem arg2) {
        NavgateableJPanel WorkArea = new NavgateableJPanel(arg0, arg1, arg2);
        WorkArea.JPanelPos1 = new ProducerJPanel(arg1, arg2);
        WorkArea.loadNavBtn();
        return WorkArea;
    }

}
