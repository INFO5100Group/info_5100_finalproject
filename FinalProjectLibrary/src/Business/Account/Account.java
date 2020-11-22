package Business.Account;


import Business.SerializiedObject;
import Business.Person.Person;
import Business.Role.Role;

public class Account extends SerializiedObject{
    private String accountName;
    private String password;

    private Person person;
    private Role role;

    public Account(){
        super();
    }

    public Account(String un, String pw, Person p) throws Exception {
        this();
        this.setAccountName(un);
        this.setPassword(pw);
        this.setPerson(p);
    }

    public Account(String un, String pw, Person p, Role r) throws Exception {
        this(un, pw, p);
        this.role = r;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) throws Exception {
            this.accountName = accountName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) throws Exception {
        this.password = password;    
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) throws Exception {
            this.person = person;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
