package System.AccountRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import UserInterface.EnterpriseApproveInfoJPanel;
import UserInterface.NavgateableJPanel;
import UserInterface.RetailAdmin.RetailRegistJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class RetailAdminRole extends Role{
    
    public RetailAdminRole(){
        this.rType = RoleType.RetailAdmin;
    }
    
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        Enterprise currEnterprise = system.getEnterprises().getEnterpriseByAccout(account);
        if(currEnterprise.isApproved()){
            NavgateableJPanel WorkArea = new NavgateableJPanel (userProcessContainer, account, system);
            WorkArea.JPanelPos1 = new RetailRegistJPanel(account, system);
            WorkArea.loadNavBtn();
            return WorkArea;
        }else{
            return new EnterpriseApproveInfoJPanel(userProcessContainer, system, account, currEnterprise);
        }
    }
}
