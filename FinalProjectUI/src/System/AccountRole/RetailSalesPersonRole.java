package System.AccountRole;

import javax.swing.JPanel;

import Business.Account.Account;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;

public class RetailSalesPersonRole extends Role {

    public RetailSalesPersonRole(){
        this.rType = RoleType.RetailSalsePerson;
    }

    @Override
    public JPanel createWorkArea(JPanel arg0, Account arg1, EcoSystem arg2) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
