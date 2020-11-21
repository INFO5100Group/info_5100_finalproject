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
    private Map<Account, Boolean> receivers;
    private Date requestDate, resolveDate;

    public WorkRequest(){
        this.requestDate = new Date();
        this.receivers = new HashMap<>();
    }

    public void resolve(){
        this.status = "Complete";
        this.resolveDate = new Date();
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

}