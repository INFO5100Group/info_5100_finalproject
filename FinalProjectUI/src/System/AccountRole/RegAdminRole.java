package System.AccountRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Role.*;
import EcoSystem.EcoSystem;
import UserInterface.EnterpriseApproveInfoJPanel;
import UserInterface.NavgateableJPanel;
import UserInterface.RegulateAdmin.RegulateRegistJPanel;
import javax.swing.JPanel;

public class RegAdminRole extends Role {

    public RegAdminRole(){
        this.rType = RoleType.RegulateAdmin;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        Enterprise currEnterprise = system.getEnterprises().getEnterpriseByAccout(account);
        if(currEnterprise.isApproved()){
            NavgateableJPanel WorkArea = new NavgateableJPanel (userProcessContainer, account, system);
            WorkArea.JPanelPos1 = new RegulateRegistJPanel(account, system);
            WorkArea.loadNavBtn();
            return WorkArea; 
        }else{
            return new EnterpriseApproveInfoJPanel(userProcessContainer, system, account, currEnterprise);
        }
        
    }
    
}
