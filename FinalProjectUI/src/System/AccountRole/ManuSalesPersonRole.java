package System.AccountRole;

import javax.swing.JPanel;

import Business.Account.Account;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;

public class ManuSalesPersonRole extends Role {

    public ManuSalesPersonRole(){
        this.rType = RoleType.ManuSalsePerson;
    } 

    @Override
    public JPanel createWorkArea(JPanel arg0, Account arg1, EcoSystem arg2) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
