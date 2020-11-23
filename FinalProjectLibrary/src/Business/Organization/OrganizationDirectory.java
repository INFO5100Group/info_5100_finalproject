package Business.Organization;

import java.util.ArrayList;

public class OrganizationDirectory extends ArrayList<Organization>{

    /**
     *
     */
    private static final long serialVersionUID = 27L;

    /**
     * check if a organization in list
     * @param newOrgName
     * @return
     */
    public boolean organizationContained(String newOrgName){
        return this.stream()
            .filter(o -> o.getName().equals(newOrgName))
            .findAny()
            .orElse(null) != null;
    }

    /**
     * add new organization for department
     * 
     * @param o
     * @return
     * @throws Exception
     */
    public boolean addOrganization(Organization o) throws Exception {
        if(!this.organizationContained(o.getName())){
            return this.add(o);
        }else{
            throw new Exception(o.getName() + " This department / organization is already exist");
        }
    }

    /**
     * remomve an organization
     * @param o
     * @return
     */
    public boolean removeOrganization(Organization o){
        return this.remove(o);
    }

    public boolean updateOrganization(Organization o){
        if(!this.organizationContained(o.getName())){
            for(int i = 0; i < this.size(); i++){
                if(this.get(i).getID() == o.getID()){
                    this.set(i, o);
                    return true;
                }
            }
        }
        return false;
    }

    // TODO: search organization

}
