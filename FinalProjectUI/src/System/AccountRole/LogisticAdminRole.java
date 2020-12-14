package System.AccountRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import UserInterface.EnterpriseApproveInfoJPanel;
import UserInterface.LogisticAdmin.*;

import UserInterface.NavgateableJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class LogisticAdminRole extends Role {

    public LogisticAdminRole() {
        this.rType = RoleType.LogisticAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        Enterprise currEnterprise = system.getEnterprises().getEnterpriseByAccout(account);
        if (currEnterprise.isApproved()) {
            NavgateableJPanel WorkArea = new NavgateableJPanel(userProcessContainer, account, system);
            WorkArea.JPanelPos1 = new LoggisticRegistJPanel(account, system);
            WorkArea.loadNavBtn();
            return WorkArea;
        } else {
            return new EnterpriseApproveInfoJPanel(userProcessContainer, system, account, currEnterprise);
        }
    }

}
