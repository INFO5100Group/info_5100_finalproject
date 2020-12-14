package System.AccountRole;

import javax.swing.JPanel;

import Business.Account.Account;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import UserInterface.FurnitureManufaCompany.DesignerRole.DesignJPanel;
import UserInterface.NavgateableJPanel;

public class ManuDesignerRole extends Role {

    public ManuDesignerRole() {
        this.rType = RoleType.ManuDesigner;
    }

    @Override
    public JPanel createWorkArea(JPanel arg0, Account arg1, EcoSystem arg2) {
        NavgateableJPanel WorkArea = new NavgateableJPanel(arg0 , arg1, arg2);
        WorkArea.JPanelPos1 = new DesignJPanel(arg1, arg2);
        WorkArea.loadNavBtn();
        return WorkArea;
    }

}
