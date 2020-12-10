package Business.Enterprise;

import Business.Account.Account;
import Business.Organization.Organization;
import Business.Person.Person;
import java.util.ArrayList;

public class EnterpriseDirectory extends ArrayList<Enterprise> {

    /**
     *
     */
    private static final long serialVersionUID = 27L;

    /**
     * check is an enterprise is exist in list
     *
     * @param enterpriseName
     * @return
     */
    public boolean EnterpriseContained(String enterpriseName) {
        if (this.size() == 0) {
            return false;
        }
        return this.stream()
                .filter(e -> e.getName().equals(enterpriseName))
                .findAny()
                .orElse(null) != null;
    }

    /**
     * add a new enterprise
     *
     * @param e
     * @return
     */
    public boolean addEnterprise(Enterprise e) {
        if (!this.EnterpriseContained(e.getName())) {
            return this.add(e);
        } else {
            return false;
        }
    }

    /**
     * remove enterprice
     *
     * @param e
     * @return
     */
    public boolean removeEnterprise(Enterprise e) {
        return this.remove(e);
    }

    /**
     * update an enterprise
     *
     * @param e
     * @return
     */
    public boolean updateEnterprise(Enterprise e) {
        if (!this.EnterpriseContained(e.getName())) {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getID() == e.getID()) {
                    this.set(i, e);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * get enterprise by give administer account
     *
     * @param a
     * @return
     */
    public Enterprise getEnterpriseByAccout(Account a) {
        return this.stream()
                .filter(e -> e.getAdmin().getID() == a.getID())
                .findAny()
                .orElse(null);
    }

    /**
     * get enterprise by given employee account
     *
     * @param a
     * @return
     */
    public Enterprise getEnterpriseByEmployeeAccount(Account a) {
        for (Enterprise e : this) {
            for (Organization o : e.getDepartments()) {
                for (Person p : o.getEmployee()) {
                    if (a.getPerson().getID() == p.getID()) {
                        return e;
                    }
                }
            }
        }
        return null;
    }

    /**
     *
     * @param eID
     * @return
     */
    public Enterprise getEnterPriseByID(int eID) {
        return this.stream()
                .filter(e -> e.getID() == eID)
                .findFirst()
                .orElse(null);
    }

    /**
     * 
     * @param Name
     * @return 
     */
    public Enterprise getEnterpriseByName(String Name) {
        return this.stream()
                .filter(e -> e.getName().equals(Name))
                .findFirst()
                .orElse(null);
    }
}
