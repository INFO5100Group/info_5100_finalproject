package UserRole;

import Business.Account.Account;
import Business.Role.*;
import EcoSystem.EcoSystem;
import UserInterface.RegulateAdmin.RegulateRegistJPanel;
import javax.swing.JPanel;

public class RegAdminRole extends Role {

    public RegAdminRole(){
        this.rType = RoleType.RetailAdmin;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        return new RegulateRegistJPanel(userProcessContainer, account,system);
    }
    
}
