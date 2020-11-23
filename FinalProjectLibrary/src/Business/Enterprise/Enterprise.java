package Business.Enterprise;

import Business.SerializiedObject;
import Business.Organization.OrganizationDirectory;
import Business.Wood.WoodStorage;

public class Enterprise extends SerializiedObject{
    private String Name, Address, ShortName; // 公司名字， 地址， 简短名（用于为员工创建邮箱账号）
    private OrganizationDirectory Departments; // 公司下属部门
    private WoodStorage woodStorage; // 木的存储量， 不为伐木和制造公司则为null

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
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

    @Override
    public String toString() {
        return this.Name;
    }
}
