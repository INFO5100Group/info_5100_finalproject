package System.AccountRole;

import javax.swing.JPanel;

import Business.Account.Account;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import UserInterface.NavgateableJPanel;
import UserInterface.RetailCompany.SalesRole.*;

public class RetailSalesPersonRole extends Role {

    public RetailSalesPersonRole(){
        this.rType = RoleType.RetailSalsePerson;
    }

    @Override
    public JPanel createWorkArea(JPanel arg0, Account arg1, EcoSystem arg2) {
        NavgateableJPanel WorkArea = new NavgateableJPanel(arg0, arg1, arg2);
        WorkArea.JPanelPos1 = new SalesWorkQueueJPanel(arg1, arg2);
        WorkArea.JPanelPos2 = new SalesOrderJPanel(arg1, arg2);
        WorkArea.loadNavBtn();
        return WorkArea;
    }
    
}
