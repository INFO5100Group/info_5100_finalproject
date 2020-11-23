package Business.Enterprise;

import Business.SerializiedObject;
import Business.Organization.OrganizationDirectory;

public class Enterprise extends SerializiedObject{
    private String Name, Address;
    private OrganizationDirectory Departments;

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

    @Override
    public String toString() {
        return this.Name;
    }
}
