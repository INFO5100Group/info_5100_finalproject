package Business.WorkQueue;

import java.util.ArrayList;

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
            throw new Exception("receivers are not defined");
        }else if(wr.getStatus() == null) {
            throw new Exception("Message cannot be null");
        }
        return this.add(wr);
    }
    
}
