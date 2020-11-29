/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.AccountRole;

import Business.Account.Account;
import EcoSystem.EcoSystem;
import UserInterface.sysadmin.*;
import javax.swing.JPanel;
import Business.Role.*;

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
        return new SysadminWorkJPanel(userProcessContainer, account, system);
    }
    
}
