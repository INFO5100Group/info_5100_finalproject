package Business.Person;

import Business.SerializiedObject;

/**
 * Person
 */
public class Person extends SerializiedObject{
     
    private String FirstName, LastName, Gender;


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
    
    @Override
    public String toString() {
        return this.FirstName + " " + this.LastName;
    }
}