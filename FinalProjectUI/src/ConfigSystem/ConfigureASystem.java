package ConfigSystem;

import Business.Account.Account;
import Business.Person.Person;
import EcoSystem.EcoSystem;
import UserRole.*;

public class ConfigureASystem {
    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
        // add initial user account here

        // add sysadmin
        Person admin = new Person("adminFirstName","adminLastname","Neutral");
        Account adminAccount = new Account("sysadmin", "sysadmin", admin, new SysAdminRole());
        system.getAccounts().addAccount(adminAccount);

        // TODO add what else


        

        return system;
    }
}
