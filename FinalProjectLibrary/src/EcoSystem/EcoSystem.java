/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem;

import Business.Account.Account;
import Business.Account.AccountDirectory;
import Business.Enterprise.EnterpriseDirectory;
import Business.Person.Person;
import Business.Role.Role;
import Business.Role.RoleType;
import Business.WorkQueue.WorkQueue;
import java.util.stream.Collectors;

/**
 *
 * @author Bohan Feng
 */
public class EcoSystem {
    private AccountDirectory accounts;
    private EnterpriseDirectory enterprises;
    private WorkQueue workQueue;
    private static EcoSystem currSystem;
    
    public EcoSystem(){
        this.accounts = new AccountDirectory();
        this.enterprises = new EnterpriseDirectory();
        this.workQueue = new WorkQueue();
    }

    public static EcoSystem getInstance(){
        if(currSystem == null){
            if(currSystem == null){
                currSystem = new EcoSystem();
            }
        }
        return currSystem;
    }
    
    public AccountDirectory getAllAdmins(){
        return this.accounts
                .stream()
                .filter(s -> s.getRole().rType == RoleType.SysAdmin)
                .collect(Collectors
                        .toCollection(AccountDirectory::new));
    }
    
    public boolean createAccount(String un, String pw, Person p, Role r){
        Account newAccount = new Account (un, pw, p, r);
        return this.accounts.addAccount(newAccount);
    }
   

    public AccountDirectory getAccounts() {
        return this.accounts;
    }

    public void setAccounts(AccountDirectory accounts) {
        this.accounts = accounts;
    }

    public EnterpriseDirectory getEnterprises() {
        return this.enterprises;
    }

    public void setEnterprises(EnterpriseDirectory enterprises) {
        this.enterprises = enterprises;
    }

    public WorkQueue getWorkQueue() {
        return this.workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }



}
