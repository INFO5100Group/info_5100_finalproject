/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.AccountRole;

import Business.Account.Account;
import Business.Role.*;
import EcoSystem.EcoSystem;
import UserInterface.Customer.CustomerSearchJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class CustomerRole extends Role{

    public CustomerRole(){
        this.rType = RoleType.Customer;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        return new CustomerSearchJPanel(userProcessContainer, account, system);
    }
    
}
