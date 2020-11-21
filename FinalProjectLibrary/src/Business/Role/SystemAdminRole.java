package Business.Role;

import javax.swing.JPanel;

import Business.Account.Account;
import EcoSystem.EcoSystem;

public class SystemAdminRole extends Role {

    public SystemAdminRole(){
        this.rType = RoleType.sysAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        // TODO create sysadmin work area jpanel
        return null;
    }
    
}
