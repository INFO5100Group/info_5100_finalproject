package Business.Enterprise;

import Business.Account.Account;
import Business.SerializiedObject;
import Business.Organization.OrganizationDirectory;
import Business.Person.Person;
import Business.Wood.WoodStorage;

public class Enterprise extends SerializiedObject{
    private String Name, ShortName; // 公司名字， 简短名（用于为员工创建邮箱账号）
    private String State, City, Street, ZipCode; // 公司地址信息
    private OrganizationDirectory Departments; // 公司下属部门
    private WoodStorage woodStorage; // 木的存储量， 不为伐木和制造公司则为null
    private Account admin; 
    
    private boolean approved;

    public Enterprise(){
        approved = false;
        Departments = new OrganizationDirectory();
    }
    
    public Enterprise(Account adac){
        this();
        Person ad = adac.getPerson();
        this.State = ad.getState();
        this.City = ad.getCity();
        this.Street = ad.getStreet();
        this.ZipCode = ad.getZipCode();
        this.admin = adac;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    
    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    public OrganizationDirectory getDepartments() {
        return this.Departments;
    }

    public void setDepartments(OrganizationDirectory Departments) {
        this.Departments = Departments;
    }

    public String getShortName() {
        return this.ShortName;
    }

    public void setShortName(String ShortName) {
        this.ShortName = ShortName;
    }

    public WoodStorage getWoodStorage() {
        return this.woodStorage;
    }

    public void setWoodStorage(WoodStorage woodStorage) {
        this.woodStorage = woodStorage;
    }

    public Account getAdmin() {
        return admin;
    }

    public void setAdmin(Account admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return this.Name;
    }
}
