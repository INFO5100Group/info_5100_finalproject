/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem;

import Business.Account.AccountDirectory;
import Business.Enterprise.EnterpriseDirectory;
import Business.WorkQueue.WorkQueue;

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
