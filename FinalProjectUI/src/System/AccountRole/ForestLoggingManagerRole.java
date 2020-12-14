package System.AccountRole;

import Business.Account.Account;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import UserInterface.ForestryCompany.ManagerRole.ManagerWorkJPanel;
import UserInterface.NavgateableJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class ForestLoggingManagerRole extends Role{

    public ForestLoggingManagerRole(){
        this.rType = RoleType.ForestLoggingManager;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        NavgateableJPanel WorkArea = new NavgateableJPanel (userProcessContainer, account, system);
        WorkArea.JPanelPos1 = new ManagerWorkJPanel(account, system);
        WorkArea.loadNavBtn();
        return WorkArea; 
    }
    
}
