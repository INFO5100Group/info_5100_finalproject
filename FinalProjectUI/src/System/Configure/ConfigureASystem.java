package System.Configure;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
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
        Enterprise reg = addEnterprise("test reg", new RegAdminRole());
        reg.getDepartments().addOrganization(new Organization("Enviromental Regulatory Organization"));
        reg.setState("Washington");
        
        Enterprise fore = addEnterprise("test forest", new ForestAdminRole());
        fore.getDepartments().addOrganization(new Organization("Logging Department"));
        fore.getDepartments().addOrganization(new Organization("Sales Department"));
        fore.setName("Logger Lovers");
        
        Enterprise man = addEnterprise("test manu", new ManuAdminRole());
        man.getDepartments().addOrganization(new Organization("Purchasing Department"));
        man.getDepartments().addOrganization(new Organization("Production Department"));
        man.getDepartments().addOrganization(new Organization("Salse Department"));
        
        Enterprise ret = addEnterprise("test retail", new RetailAdminRole());
        ret.getDepartments().addOrganization(new Organization("Purchasing Department"));
        ret.getDepartments().addOrganization(new Organization("Salse Department"));
        
        Enterprise log = addEnterprise("test logistic", new LogisticAdminRole());
        log.getDepartments().addOrganization(new Organization("Transportation Department"));

        
        // add customer
        Person cust = new Person("Joe", "Doe", "other");
        Account custAccount = new Account("cust", "123", cust, new CustomerRole());
        system.getAccounts().addAccount(custAccount);

        return system;
    }
    
    public static Enterprise addEnterprise(String Name, Role r){
        Person admin = new Person(Name, "admin", "other");
        Account account = new Account("t" + Name.split(" ")[1] + "admin", "admin", admin, r);
        Enterprise enterprise =  new Enterprise(account);
        enterprise.setApproved(true);
        enterprise.setShortName(Name.split(" ")[0] +Name.split(" ")[1]);
        enterprise.setName(Name);
        system.getAccounts().addAccount(account);
        system.getEnterprises().addEnterprise(enterprise);
        return enterprise;
    }
     
}
