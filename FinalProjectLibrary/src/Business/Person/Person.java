package Business.Person;

import Business.SerializiedObject;

/**
 * Person
 */
public class Person extends SerializiedObject{
     
    private String FirstName, LastName, Gender;
    
    private String Email, State, City, Street, ZipCode;

    // constructor
    public Person() {
        super();
    }
    
    public Person(String f, String l, String g){
        this();
        this.FirstName = f;
        this.LastName = l;
        this.Gender = g;
    }


    // getter and setters
    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getGender() {
        return this.Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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
    
    @Override
    public String toString() {
        if(FirstName == null && LastName == null){
            return "Name not set for person (" + this.getID() + ")";
        }
        return this.FirstName + " " + this.LastName;
    }
}