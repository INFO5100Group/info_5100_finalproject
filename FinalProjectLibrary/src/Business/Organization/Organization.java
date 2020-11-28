package Business.Organization;

import Business.SerializiedObject;
import Business.Person.PersonDirectory;

/**
 * 
 */
public class Organization extends SerializiedObject{
    private String Name;
    private PersonDirectory Employee;

    public Organization(){
        super();
        this.Employee = new PersonDirectory();
    }
    
    public Organization(String n){
        this();
        this.Name = n;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public PersonDirectory getEmployee() {
        return this.Employee;
    }

    public void setEmployee(PersonDirectory Employee) {
        this.Employee = Employee;
    }

    @Override
    public String toString() {
        return this.Name;
    }
    
}
