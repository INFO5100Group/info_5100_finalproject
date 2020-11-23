package EcoSystem;

import Business.Account.Account;
import Business.Person.Person;
import Business.Role.SystemAdminRole;

public class ConfigureASystem {
    public static EcoSystem configure() throws Exception {
        EcoSystem system = EcoSystem.getInstance();
        // add initial user account here

        // add sysadmin
        Person admin = new Person("adminFirstName","adminLastname","Neutral");
        Account adminAccount = new Account("sysadmin", "sysadmin", admin, new SystemAdminRole());
        system.getAccounts().addAccount(adminAccount);

        // TODO addm what else


        

        return system;
    }
}
