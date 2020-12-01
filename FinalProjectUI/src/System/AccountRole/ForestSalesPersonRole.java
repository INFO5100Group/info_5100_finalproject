/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System.AccountRole;

import Business.Account.Account;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import UserInterface.ForestryAdmin.ForestryRegistJPanel;
import UserInterface.ForestryCompany.SalesRole.SalesBargainJPanel;
import UserInterface.ForestryCompany.SalesRole.SalesOrderJPanel;
import UserInterface.NavgateableJPanel;
import java.awt.Robot;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class ForestSalesPersonRole extends Role{
    
    public ForestSalesPersonRole(){
        this.rType = RoleType.ForestSalesPerson;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        NavgateableJPanel WorkArea = new NavgateableJPanel (userProcessContainer, account, system);
        WorkArea.JPanelPos1 = new SalesBargainJPanel(account, system);
        WorkArea.JPanelPos2 = new SalesOrderJPanel(account, system);
        WorkArea.loadNavBtn();
        return WorkArea; 
    }
    
}
