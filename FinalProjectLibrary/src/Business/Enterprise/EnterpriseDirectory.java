package Business.Enterprise;

import Business.Account.Account;
import java.util.ArrayList;


public class EnterpriseDirectory extends ArrayList<Enterprise>{

    /**
     *
     */
    private static final long serialVersionUID = 27L;
    

    /**
     * check is an enterprise is exist in list
     * @param enterpriseName
     * @return
     */
    public boolean EnterpriseContained(String enterpriseName){
        if(this.size() == 0){
            return false;
        }
        return this.stream()
            .filter(e -> e.getName().equals(enterpriseName))
            .findAny()
            .orElse(null) != null;
    }

    /**
     * add a new enterprise
     * @param e
     * @return
     */
    public boolean addEnterprise(Enterprise e){
        if(!this.EnterpriseContained(e.getName())){
            return this.add(e);
        }else{
            return false;
        }
    }

    /**
     * remove enterprice
     * @param e
     * @return
     */
    public boolean removeEnterprise(Enterprise e){
        return this.remove(e);
    }

    /**
     * update an enterprise
     * @param e
     * @return
     */
    public boolean updateEnterprise(Enterprise e){
        if(!this.EnterpriseContained(e.getName())){
            for(int i =0; i< this.size(); i++){
                if(this.get(i).getID() == e.getID()){
                    this.set(i, e);
                    return true;
                }
            }
        }
        return false;
    } 
    
    /**
     * get enterprise by give account
     * @param a
     * @return 
     */
    public Enterprise getEnterpriseByAccout(Account a){
        return this.stream()
                .filter(e -> e.getAdmin().getID() == a.getID())
                .findAny()
                .orElse(null);
    }
}
