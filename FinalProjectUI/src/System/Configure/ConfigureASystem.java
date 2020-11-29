package System.Configure;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Person.Person;
import Business.Role.Role;
import System.AccountRole.*;
import EcoSystem.EcoSystem;
import javax.swing.JPanel;

public class ConfigureASystem {
    static EcoSystem system = EcoSystem.getInstance();
    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
        // add initial user account here

        // add sysadmin
        Person admin = new Person("adminFirstName","adminLastname","Neutral");
        Account adminAccount = new Account("sysadmin", "sysadmin", admin, new SysAdminRole());
        system.getAccounts().addAccount(adminAccount);

        // add enterprise
        addEnterprise("test reg", new RegAdminRole());
        addEnterprise("test forest", new ForestAdminRole());
        addEnterprise("test manu", new ManuAdminRole());
        addEnterprise("test retail", new RetailAdminRole());
        addEnterprise("test logistic", new LogisticAdminRole());
        
        // add customer
        Person cust = new Person("Joe", "Doe", "other");
        Account custAccount = new Account("cust", "123", cust, new CustomerRole());
        system.getAccounts().addAccount(custAccount);

        return system;
    }
    
    public static void addEnterprise(String Name, Role r){
        Person admin = new Person(Name, "admin", "other");
        Account account = new Account("t" + Name.split(" ")[1] + "admin", "admin", admin, r);
        Enterprise enterprise =  new Enterprise(account);
        enterprise.setApproved(true);
        enterprise.setShortName(Name.split(" ")[0] +Name.split(" ")[1]);
        enterprise.setName(Name);
        system.getAccounts().addAccount(account);
        system.getEnterprises().addEnterprise(enterprise);
        
    }
     
}
