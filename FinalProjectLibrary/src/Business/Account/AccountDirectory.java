package Business.Account;

import Business.Person.Person;
import java.util.ArrayList;

public class AccountDirectory  extends ArrayList<Account>{

    /**
     *
     */
    private static final long serialVersionUID = 25L;
    
    /**
     * check if a account is contained in list
     * @param newAccoutName
     * @return
     */
    public boolean userContained(String newAccoutName){
        return this.stream()
            .filter(a -> a.getAccountName().equals(newAccoutName))
            .findAny()
            .orElse(null) != null;
    }

    /**
     * add a new Account
     * 
     * @param newAccount
     * @return
     */
    public boolean addAccount(Account newAccount) {
        if(!this.userContained(newAccount.getAccountName())){
            return this.add(newAccount);
        }else{
            return false;
        }
    }

    /**
     * remove a account
     * @param toRemove
     * @return
     */
    public boolean removeAccount(Account toRemove){
        return this.remove(toRemove);
    }
    
    /**
     * remove an account by given person
     * @param p
     * @return 
     */
    public boolean removeAccountByPerson(Person p){
        Account toRemove = this.stream()
                .filter(a -> a.getPerson().getID() == p.getID())
                .findAny()
                .orElse(null);
        if(toRemove == null){
            return false;
        }else{
            return this.addAccount(toRemove);
        }
    }

    /**
     * update a account
     * 
     * @param toUpdate
     * @return
     * @throws Exception
     */
    public boolean updateAccount(Account toUpdate) {
        if(!this.userContained(toUpdate.getAccountName())){
            for(int i =0; i < this.size(); i++){
                if(this.get(i).getID() == toUpdate.getID()){
                    this.set(i, toUpdate);
                    return true; 
                }
            }
        }
        return false;
    }
    
    
    /**
     * valid date user for log in
     * @param username
     * @param password
     * @return a account obj if validated username and password
     *         null if not validated 
     */
    public Account getUserLogin(String username, String password) throws Exception{
        Account re = this.stream()
                    .filter(a -> a.getAccountName().equals(username))
                    .findAny()
                    .orElse(null);
        if(re == null){
            throw new Exception("no shuch account " + username);
        }else if(re.getPassword().equals(password)){
            return re;
        }else{
            throw new Exception("invalid password for " + username);
        }
    }
    
    /**
     * 
     * @param p
     * @return 
     */
    public Account getAccontByPerson(Person p){
        return this.stream()
                .filter(a -> a.getPerson().getID() == p.getID())
                .findAny()
                .orElse(null);
    }
    
    /**
     * 
     * @param aID
     * @return 
     */
    public Account getAccountByID(int aID){
        return this.stream()
                .filter(a -> a.getID() == aID)
                .findAny()
                .orElse(null);
    }
}
