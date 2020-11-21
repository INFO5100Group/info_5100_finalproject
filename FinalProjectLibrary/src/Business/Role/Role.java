package Business.Role;

import javax.swing.JPanel;

import Business.Account.Account;

public abstract class Role {
    public RoleType rType;

    public abstract JPanel createWorkArea(JPanel userProcessContainer, Account account);

    @Override
    public String toString() {
        return rType.getClass().getSimpleName() + "";
    }
}
