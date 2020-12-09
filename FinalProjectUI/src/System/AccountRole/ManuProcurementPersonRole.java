package System.AccountRole;

import javax.swing.JPanel;

import Business.Account.Account;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import UserInterface.FurnitureManufaCompany.PurchaseRole.*;
import UserInterface.NavgateableJPanel;

public class ManuProcurementPersonRole extends Role {

    public ManuProcurementPersonRole() {
        this.rType = RoleType.ManuProcurementPerson;
    }

    @Override
    public JPanel createWorkArea(JPanel arg0, Account arg1, EcoSystem arg2) {
        // TODO Auto-generated method stub
        NavgateableJPanel WorkArea = new NavgateableJPanel(arg0, arg1, arg2);
        WorkArea.JPanelPos1 = new PurchaseJPanel(arg1, arg2);
        WorkArea.JPanelPos2 = new OrderJPanel(arg1, arg2);
        WorkArea.loadNavBtn();
        return WorkArea;
    }

}
