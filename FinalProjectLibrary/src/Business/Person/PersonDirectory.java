package Business.Person;

import java.util.ArrayList;

public class PersonDirectory extends ArrayList<Person> {

    /**
     *
     */
    private static final long serialVersionUID = 26L;
    
    public boolean addPerson(Person newPerson){
        return this.add(newPerson);
    }

    public boolean removePerson(Person toRemove){
        return this.remove(toRemove);
    }

    public boolean updatePerson(Person toUpdate){
        for(int i = 0; i< this.size(); i++){
            if(this.get(i).getID() == toUpdate.getID()){
                this.set(i, toUpdate);
                return true;
            }
        }
        return false;
    }

    //TODO: search person

}
