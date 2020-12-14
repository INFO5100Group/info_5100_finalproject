package System.AccountRole;

import Business.Account.Account;
import EcoSystem.EcoSystem;
import UserInterface.sysadmin.*;
import javax.swing.JPanel;
import Business.Role.*;
import UserInterface.NavgateableJPanel;

/**
 *
 * @author Bohan Feng
 */
public class SysAdminRole extends Role{
    
    public SysAdminRole(){
        this.rType = RoleType.SysAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        NavgateableJPanel sysWorkArea = new NavgateableJPanel (userProcessContainer, account, system);
        sysWorkArea.JPanelPos1 = new SysadminRequestJPanel(account, system);
        sysWorkArea.JPanelPos2 = new SysadminManageJPanel(account, system);
        sysWorkArea.JPanelPos3 = new EnterpriseDataJPanel(account, system);
        sysWorkArea.loadNavBtn();
        return sysWorkArea;
    }
    
}
