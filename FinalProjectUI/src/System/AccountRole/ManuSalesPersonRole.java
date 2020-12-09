package System.AccountRole;

import javax.swing.JPanel;

import Business.Account.Account;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import UserInterface.FurnitureManufaCompany.SalesRole.*;
import UserInterface.NavgateableJPanel;

public class ManuSalesPersonRole extends Role {

    public ManuSalesPersonRole(){
        this.rType = RoleType.ManuSalsePerson;
    } 

    @Override
    public JPanel createWorkArea(JPanel arg0, Account arg1, EcoSystem arg2) {
        NavgateableJPanel WorkArea = new NavgateableJPanel(arg0, arg1, arg2);
        WorkArea.JPanelPos1 = new SalesBargainJPanel(arg1, arg2);
        WorkArea.JPanelPos2 = new SalesOrderJPanel(arg1, arg2);
        WorkArea.loadNavBtn();
        return WorkArea;
    }
    
}
