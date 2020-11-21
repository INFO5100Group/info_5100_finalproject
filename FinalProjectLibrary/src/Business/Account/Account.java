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
        // TODO: check account name validation
        if(true){
            this.accountName = accountName;
        }else{
            throw new Exception("new account is not valid");
        }
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) throws Exception {
        // TODO: check password validation
        if(true){
            this.password = password;
        }else{
            throw new Exception("new password is not valid");
        }
        
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) throws Exception {
        // TODO: check password validation
        if(true){
            this.person = person;
        }else{
            throw new Exception("new person is not valid");
        }
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
