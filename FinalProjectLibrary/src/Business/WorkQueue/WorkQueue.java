package Business.WorkQueue;

import Business.Account.Account;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class WorkQueue extends ArrayList<WorkRequest>{

    /**
     *
     */
    private static final long serialVersionUID = 29L;
    
    public boolean addRequest(WorkRequest wr) throws Exception {
        if(wr.getMessage() == null) {
            throw new Exception("Message is not defined");
        }else if(wr.getSender() == null) {
            throw new Exception("Sender is not defined");
        }else if(wr.getReceivers().size() == 0) {
            throw new Exception("Receivers are not defined");
        }else if(wr.getStatus() == null) {
            throw new Exception("Status cannot be null");
        }
        return this.add(wr);
    }
    
    public WorkRequest getOneRequestBySender(Account a){
        return this.stream()
                .filter(w -> w.getSender().getID() == a.getID())
                .findAny()
                .orElse(null);
    }
    
    public WorkQueue getRequestsBySender(Account a){
        return this.stream()
                .filter(w -> w.getSender().getID() == a.getID())
                .collect(Collectors
                    .toCollection(WorkQueue::new));
    }
    
    public WorkQueue getRequestsByRecevier(Account a){
        return this.stream()
                .filter(w -> w.getReceivers().keySet().contains(a))
                .collect(Collectors
                    .toCollection(WorkQueue::new));
    }
    
    public WorkRequest getRequestByID(int rID){
        return this.stream()
                .filter(r -> r.getID() == rID)
                .findAny()
                .orElse(null);
    }
    
}
