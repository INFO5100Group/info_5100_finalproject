package System.AccountRole;

import javax.swing.JPanel;

import Business.Account.Account;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;

public class ManuDesignerRole extends Role {

    public ManuDesignerRole(){
        this.rType = RoleType.ManuDesigner;
    }

    @Override
    public JPanel createWorkArea(JPanel arg0, Account arg1, EcoSystem arg2) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
