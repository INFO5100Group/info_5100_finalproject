package Business.Account;

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
    private boolean userContained(String newAccoutName){
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
     * @throws Exception
     */
    public boolean addAccount(Account newAccount) throws Exception {
        if(!this.userContained(newAccount.getAccountName())){
            return this.add(newAccount);
        }else{
            throw new Exception(newAccount.getAccountName() + " this account name is exist");
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
     * update a account
     * 
     * @param toUpdate
     * @return
     * @throws Exception
     */
    public boolean updateAccount(Account toUpdate) throws Exception {
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
}
