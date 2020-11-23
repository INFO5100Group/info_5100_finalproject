package Business.Role;

import javax.swing.JPanel;

import Business.Account.Account;
import EcoSystem.EcoSystem;

public abstract class Role {
    public RoleType rType;

    public abstract JPanel createWorkArea(JPanel userProcessContainer, Account account, EcoSystem system);

    @Override
    public String toString() {
        return rType.getClass().getSimpleName() + "";
    }
}
