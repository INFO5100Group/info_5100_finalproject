package System.AccountRole;

import javax.swing.JPanel;

import Business.Account.Account;
import Business.Role.Role;
import Business.Role.RoleType;
import EcoSystem.EcoSystem;
import UserInterface.LogisticCompany.LogisticRole.LogisticWorkQueueJPanel;
import UserInterface.NavgateableJPanel;

public class LogisticsPersonRole extends Role {

    public LogisticsPersonRole() {
        this.rType = RoleType.LogisticsPseron;
    }

    @Override
    public JPanel createWorkArea(JPanel arg0, Account arg1, EcoSystem arg2) {
        NavgateableJPanel WorkArea = new NavgateableJPanel(arg0, arg1, arg2);
        WorkArea.JPanelPos1 = new LogisticWorkQueueJPanel(arg1, arg2);
        WorkArea.loadNavBtn();
        return WorkArea;
    }
}
