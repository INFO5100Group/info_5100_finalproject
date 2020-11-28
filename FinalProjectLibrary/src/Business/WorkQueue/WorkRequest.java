package Business.WorkQueue;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Business.SerializiedObject;
import Business.Account.Account;

/**
 * WorkRequest
 */
public class WorkRequest extends SerializiedObject{

    private String message;
    private String status;
    private Account sender;
    private boolean isCompleted;
    private Map<Account, Boolean> receivers;
    private Date requestDate, resolveDate;

    public WorkRequest(){
        this.isCompleted = false;
        this.requestDate = new Date();
        this.receivers = new HashMap<>();
    }

    public void resolve(){
        receivers.replaceAll((k,v) -> v = true);
        this.isCompleted = true;
        this.status = "Approved";
        this.resolveDate = new Date();
    }
    
    public void denied(){
        this.isCompleted = true;
        this.resolveDate = new Date();
        this.status = "Denied";
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Account getSender() {
        return this.sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Map<Account,Boolean> getReceivers() {
        return this.receivers;
    }

    public void setReceivers(Map<Account,Boolean> receivers) {
        this.receivers = receivers;
    }

    public Date getRequestDate() {
        return this.requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return this.resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public boolean complateForReceiver(Account a){
        for(Account receiver : receivers.keySet()){
            if(receiver.getID() == a.getID()){
                receivers.put(receiver, true);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getID() + "";
    }
    
    
}