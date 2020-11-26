package ConfigSystem;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Person.Person;
import Business.Role.Role;
import EcoSystem.EcoSystem;
import UserRole.*;

public class ConfigureASystem {
    private static EcoSystem system;
    
    public static EcoSystem configure() {
        system = EcoSystem.getInstance();
        // add initial user account here

        // add sysadmin
        Person admin = new Person("adminFirstName","adminLastname","Neutral");
        Account adminAccount = new Account("sysadmin", "sysadmin", admin, new SysAdminRole());
        system.getAccounts().addAccount(adminAccount);

        // Add etnerprise
        AddEnterprise("test regulate", new RegAdminRole());
        AddEnterprise("test forest", new RegAdminRole());
        AddEnterprise("test manu", new RegAdminRole());
        AddEnterprise("test retail", new RegAdminRole());

        // Add customer
        Person newCust = new Person("test","customer","Other");
        Account custAccount = new Account("cust", "456", newCust, new CustomerRole());
        system.getAccounts().addAccount(custAccount);
        

        return system;
    }
    
    public static void AddEnterprise(String Name, Role r){
        Person Admin = new Person("RegadminFirstName", "regadminLastName", "Other");
        Account Account = new Account("t" + Name.split(" ")[1].substring(0,3) +"admin", "123", Admin, r);
        Enterprise Enterprise = new Enterprise(Account);
        Enterprise.setApproved(true);
        Enterprise.setShortName(Name.split(" ")[0] + Name.split(" ")[1].substring(0,3));
        Enterprise.setName(Name);
        system.getAccounts().addAccount(Account);
        system.getEnterprises().addEnterprise(Enterprise);
    }
}
