package System.Configure;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Furniture.Furniture;
import Business.Furniture.FurnitureDirectory;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Role.Role;
import Business.Wood.WoodStorage;
import System.AccountRole.*;
import EcoSystem.EcoSystem;
import java.util.Random;

public class ConfigureASystem {

    static EcoSystem system = EcoSystem.getInstance();

    static int accountCount = 1;

    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
        // add initial user account here

        // add sysadmin
        Person admin = new Person("System", "Admin", "Other");
        Account adminAccount = new Account("sysadmin", "sysadmin", admin, new SysAdminRole());
        system.getAccounts().addAccount(adminAccount);

        // add enterprises
        /*------------------------------------------------------------------------------------------------------*/
        // regulate offices
        addRegulateOffice("regadmin1", "Idaho");
        addRegulateOffice("regadmin2", "Washington");
        addRegulateOffice("regadmin3", "Mississppi");

        /*------------------------------------------------------------------------------------------------------*/
        // forest logging
        addForestEnterprise("foreadmin1", "Logger Lover");
        addForestEnterprise("foreadmin2", "Z Tree");
        /*------------------------------------------------------------------------------------------------------*/
        // Furniure manu 
        addManuEnterprise("manuadmin1", "Happy Furniture");
        addManuEnterprise("manuadmin2", "Ambitious Home Maker");
        /*------------------------------------------------------------------------------------------------------*/
        // Furniture retailer
        addRetailEnterprise("retailadmin1", "Lazy Furniture");
        addRetailEnterprise("retailadmin2", "Jolly Seaker");
        /*------------------------------------------------------------------------------------------------------*/
        // Logistic Enterprise
        addLogistEnterprise("logistadmin1", "East Wind Express");
        addLogistEnterprise("logistadmin2", "Destination to You");

        
        // Customer
        Person cust = new Person("Joe", "Doe", "other");
        Account custAccount = new Account("cust", "123", cust, new CustomerRole());
        system.getAccounts().addAccount(custAccount);
        
        
        /*-----------------------------------------------------------------------------------------------------*/
        
        for(Enterprise e : system.getEnterprises()){
            System.out.println(e.getName() + "\n" + e.getAdmin().getAccountInfo());
            for(Organization o: e.getDepartments()){
                for(Person p : o.getEmployee()){
                    System.out.println(system.getAccounts().getAccontByPerson(p).getAccountInfo());
                }
            }
        }
        
        System.out.println(custAccount.getAccountInfo());
        
        return system;
    }

    public static Enterprise addEnterprise(String Name, Role r) {
        Person admin = new Person(Name, "admin", "other");
        Account account = new Account(Name, "admin", admin, r);
        Enterprise enterprise = new Enterprise(account);
        enterprise.setApproved(true);
        enterprise.setShortName("admin@"+Name+".com");
        enterprise.setState(NameGenerator.getState());
        enterprise.setCity(NameGenerator.getCity());
        enterprise.setStreet(NameGenerator.getStreet());
        enterprise.setZipCode(NameGenerator.getZip());
        system.getAccounts().addAccount(account);
        system.getEnterprises().addEnterprise(enterprise);
        return enterprise;
    }

    public static void addRegulateOffice(String adminAccount, String State) {
        // create reguliate office
        Enterprise reg1 = addEnterprise(adminAccount, new RegAdminRole());
        reg1.getDepartments().addOrganization(new Organization("Enviromental Regulatory Organization"));
        reg1.setState(State);
        reg1.setName(State + " Reglate Office");

        // add Employee
        addEmployee(reg1, NameGenerator.getFirstName(), NameGenerator.getLastName(), "scientist" + accountCount++, 0, new RegulateScientistRole());
        addEmployee(reg1, NameGenerator.getFirstName(), NameGenerator.getLastName(), "scientist" + accountCount++, 0, new RegulateScientistRole());

        addEmployee(reg1, NameGenerator.getFirstName(), NameGenerator.getLastName(), "officer" + accountCount++, 0, new RegulateOfficerRole());

    }

    public static void addForestEnterprise(String adminAccount, String Name) {
        Enterprise fore = addEnterprise(adminAccount, new ForestAdminRole());
        fore.getDepartments().addOrganization(new Organization("Logging Department"));
        fore.getDepartments().addOrganization(new Organization("Sales Department"));
        fore.setName(Name);
        fore.setWoodStorage(new WoodStorage());
        // add woods
        fore.getWoodStorage().addWood("Oak", ((new Random()).nextInt(10000) / 100.0) + 50);
        fore.getWoodStorage().addWood("Maple",((new Random()).nextInt(10000) / 100.0) + 50);
        fore.getWoodStorage().addWood("Beech", ((new Random()).nextInt(10000) / 100.0) + 50);

        // add employee for fore
        addEmployee(fore, NameGenerator.getFirstName(), NameGenerator.getLastName(), "foremag" + accountCount++, 0, new ForestLoggingManagerRole());

        addEmployee(fore, NameGenerator.getFirstName(), NameGenerator.getLastName(), "foresale" + accountCount++, 0, new ForestSalesPersonRole());

    }

    public static void addManuEnterprise(String adminAccount, String Name) {
        Enterprise man = addEnterprise(adminAccount, new ManuAdminRole());
        man.getDepartments().addOrganization(new Organization("Purchasing Department"));
        man.getDepartments().addOrganization(new Organization("Production Department"));
        man.getDepartments().addOrganization(new Organization("Salse Department"));
        man.setName(Name);
        man.setWoodStorage(new WoodStorage());
        man.setFurnitureStorage(new FurnitureDirectory());
        // add woods
        man.getWoodStorage().addWood("Oak", ((new Random()).nextInt(10000) / 100.0) + 50);
        man.getWoodStorage().addWood("Maple",((new Random()).nextInt(10000) / 100.0) + 50);
        man.getWoodStorage().addWood("Beech", ((new Random()).nextInt(10000) / 100.0) + 50);

        // add furniture
        man.getFurnitureStorage().addFurniture(CreateFurniture(NameGenerator.getAdj() + " Chair", "Oak", "Chair"), (new Random().nextInt(50)));
        man.getFurnitureStorage().addFurniture(CreateFurniture(NameGenerator.getAdj() + " Bed", "Maple", "Bed"), (new Random().nextInt(50)));
        man.getFurnitureStorage().addFurniture(CreateFurniture(NameGenerator.getAdj() + " Coach", "Oak", "Coach"), (new Random().nextInt(50)));

        addEmployee(man, NameGenerator.getFirstName(), NameGenerator.getLastName(), "manupur" + accountCount++, 0, new ManuProcurementPersonRole());
        addEmployee(man, NameGenerator.getFirstName(), NameGenerator.getLastName(), "manupro" + accountCount++, 1, new ManuProducerRole());
        addEmployee(man, NameGenerator.getFirstName(), NameGenerator.getLastName(), "manudes" + accountCount++, 1, new ManuDesignerRole());
        addEmployee(man, NameGenerator.getFirstName(), NameGenerator.getLastName(), "manusale" + accountCount++, 2, new ManuSalesPersonRole());
    }

    public static void addRetailEnterprise(String adminAccount, String Name) {
        Enterprise ret = addEnterprise(adminAccount, new RetailAdminRole());
        ret.getDepartments().addOrganization(new Organization("Purchasing Department"));
        ret.getDepartments().addOrganization(new Organization("Salse Department"));
        ret.setName(Name);
        ret.setFurnitureStorage(new FurnitureDirectory());

        Furniture f1 = CreateFurniture(NameGenerator.getAdj() + " Chair", "Oak", "Chair");
        f1.setManufacturer("Happy Furniture");
        f1.setSeller(ret.getName());
        Furniture f2 = CreateFurniture(NameGenerator.getAdj() + " Bed", "Maple", "Bed");
        f2.setManufacturer("Happy Furniture");
        f2.setSeller(ret.getName());
        Furniture f3 = CreateFurniture(NameGenerator.getAdj() + " Coach", "Oak", "Coach");
        f3.setManufacturer("Ambitious Home Maker");
        f3.setSeller(ret.getName());

        ret.getFurnitureStorage().addFurniture(f1, (new Random().nextInt(20)));
        ret.getFurnitureStorage().addFurniture(f2, (new Random().nextInt(20)));
        ret.getFurnitureStorage().addFurniture(f3, (new Random().nextInt(20)));

        addEmployee(ret, NameGenerator.getFirstName(), NameGenerator.getLastName(), "retpur" + accountCount++, 0, new RetailProcurementPersonRole());
        addEmployee(ret, NameGenerator.getFirstName(), NameGenerator.getLastName(), "retsale" + accountCount++, 1, new RetailSalesPersonRole());
    }
    
    public static void addLogistEnterprise(String adminAccount, String Name){
        Enterprise log = addEnterprise(adminAccount, new LogisticAdminRole());
        log.getDepartments().addOrganization(new Organization("Transportation Department"));
        log.setName(Name);

        addEmployee(log,  NameGenerator.getFirstName(), NameGenerator.getLastName(), "logperson" + accountCount++, 0, new LogisticsPersonRole());
        addEmployee(log,  NameGenerator.getFirstName(), NameGenerator.getLastName(), "logmanager" + accountCount++, 0, new LogisticManagerRole());
    }

    public static void addEmployee(Enterprise e, String fname, String lname, String aname, int depIndex, Role r) {
        Person p = new Person(fname, lname, "other");
        Account pAccount = new Account(aname, "123", p, r);
        system.getAccounts().addAccount(pAccount);
        e.getDepartments().get(depIndex).getEmployee().addPerson(p);
    }

    public static Furniture CreateFurniture(String Name, String WoodType, String Type) {
        Furniture newF = new Furniture();
        newF.setName(Name);
        newF.setWoodType(WoodType);
        newF.setType(Type);
        Random r = new Random();
        double randomValue = (r.nextInt(20000) / 100.0) + 50;
        newF.setPrice(randomValue);
        newF.setImage(Type + (((int) randomValue % 2) + 1) + ".jpg");
        return newF;
    }
}
