package System.AccountRole;

import Business.Account.Account;
import Business.Role.*;
import EcoSystem.EcoSystem;
import UserInterface.Customer.*;
import UserInterface.NavgateableJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class CustomerRole extends Role{

    public CustomerRole(){
        this.rType = RoleType.Customer;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        NavgateableJPanel WorkArea = new NavgateableJPanel (userProcessContainer, account, system);
            WorkArea.JPanelPos1 = new CustomerSearchJPanel(account, system);
            WorkArea.JPanelPos2 = new CustomerHistoryJPanel(account, system);
            WorkArea.loadNavBtn();
            return WorkArea;
    }
    
}
