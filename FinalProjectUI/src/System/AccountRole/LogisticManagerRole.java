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
import UserInterface.LogisticAdmin.LoggisticTaskJPanel;
import UserInterface.NavgateableJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Bohan Feng
 */
public class LogisticManagerRole extends Role {

    public LogisticManagerRole() {
        this.rType = RoleType.LogisticManager;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system) {
        NavgateableJPanel WorkArea = new NavgateableJPanel(userProcessContainer, account, system);
        WorkArea.JPanelPos1 = new LoggisticTaskJPanel(account, system);
        WorkArea.loadNavBtn();
        return WorkArea;
    }

}
