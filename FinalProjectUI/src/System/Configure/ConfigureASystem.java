package System.Configure;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Role.Role;
import Business.Wood.WoodStorage;
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
        // add employee for reg
        Person bob = new Person("bob","ellen","other");
        Account bobAccount = new Account("scientist", "123", bob, new RegulateScientistRole());
        system.getAccounts().addAccount(bobAccount);
        reg.getDepartments().get(0).getEmployee().addPerson(bob);
        
        Person john = new Person("john","fucker","other");
        Account JohnAccount = new Account("officer", "123", john, new RegulateOfficerRole());
        system.getAccounts().addAccount(JohnAccount);
        reg.getDepartments().get(0).getEmployee().addPerson(john);
/*------------------------------------------------------------------------------------------------------*/
        
        // forest 
        Enterprise fore = addEnterprise("test forest", new ForestAdminRole());
        fore.getDepartments().addOrganization(new Organization("Logging Department"));
        fore.getDepartments().addOrganization(new Organization("Sales Department"));
        fore.setName("Logger Lovers");
        fore.setWoodStorage(new WoodStorage());
        
        // add employee for fore
        Person logmag = new Person("Peter","Grazier","other");
        Account logmagAccount = new Account("logmag", "123", logmag, new ForestLoggingManagerRole());
        system.getAccounts().addAccount(logmagAccount);
        fore.getDepartments().get(0).getEmployee().addPerson(logmag);
        
        Person fsale = new Person("Andrew","Lickliter","other");
        Account fsaleAccount = new Account("fsale", "123", fsale, new ForestSalesPersonRole());
        system.getAccounts().addAccount(fsaleAccount);
        fore.getDepartments().get(1).getEmployee().addPerson(fsale);
/*------------------------------------------------------------------------------------------------------*/

        // manu 
        Enterprise man = addEnterprise("test manu", new ManuAdminRole());
        man.getDepartments().addOrganization(new Organization("Purchasing Department"));
        man.getDepartments().addOrganization(new Organization("Production Department"));
        man.getDepartments().addOrganization(new Organization("Salse Department"));
        man.setName("Good Fortinure");
        man.setWoodStorage(new WoodStorage());
        
        // employee
        addEmployee(man, "Annie", "Haag", "pur", 0, new ManuProcurementPersonRole());
        addEmployee(man, "Steven", "Flores", "pro", 1, new ManuProcurementPersonRole());
        addEmployee(man, "Maria", "Yowell", "Designer", 1, new ManuDesignerRole());
        addEmployee(man, "rios", "smith", "msale", 2, new ManuSalesPersonRole());
        
/*------------------------------------------------------------------------------------------------------*/


        Enterprise ret = addEnterprise("test retail", new RetailAdminRole());
        ret.getDepartments().addOrganization(new Organization("Purchasing Department"));
        ret.getDepartments().addOrganization(new Organization("Salse Department"));
        
        addEmployee(ret, "Gray", "Terrell", "rpur", 0, new RetailProcurementPersonRole());
        addEmployee(ret, "ron", "yap", "rsale", 1, new RetailSalesPersonRole());
/*------------------------------------------------------------------------------------------------------*/


        Enterprise log = addEnterprise("test logistic", new LogisticAdminRole());
        log.getDepartments().addOrganization(new Organization("Transportation Department"));
        
        addEmployee(log, "ron", "devine", "ligistman", 0, new LogisticsPersonRole());

        
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
     
    
    public static void addEmployee(Enterprise e, String fname, String lname, String aname, int depIndex, Role r){
        Person p = new Person(fname,lname,"other");
        Account pAccount = new Account(aname, "123", p, r);
        system.getAccounts().addAccount(pAccount);
        e.getDepartments().get(depIndex).getEmployee().addPerson(p);
    }
}
