package Business;
import java.util.UUID;
/**
 * SerializiedObject
 */
public class SerializiedObject {

    private int ID;
    private String Type;

    public SerializiedObject() {
        this.ID = generateUniqueId();
        this.Type = this.getClass().getSimpleName();
    }

    public int getID() {
        return this.ID;
    }

    public String getType() {
        return this.Type;
    }

    private int generateUniqueId() {      
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;        
        int uid=str.hashCode();
        return uid > 0 ? uid : uid * -1;
    }
        
}