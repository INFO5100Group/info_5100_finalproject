/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.AccountRole;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import UserInterface.EnterpriseApproveInfoJPanel;
import UserInterface.LogisticAdmin.LoggisticRegistJPanel;
import UserInterface.RegulateAdmin.RegulateRegistJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class LogisticAdmin extends Role{

    public LogisticAdmin(){
        this.rType = RoleType.LogisticAdmin;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        Enterprise currEnterprise = system.getEnterprises().getEnterpriseByAccout(account);
        if(currEnterprise.isApproved()){
            return new LoggisticRegistJPanel(userProcessContainer, account,system); 
        }else{
            return new EnterpriseApproveInfoJPanel(userProcessContainer, system, account, currEnterprise);
        }
    }
    
}
