package Business.Furniture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class FurnitureDirectory extends ArrayList<Furniture> {

    /**
     *
     */
    private static final long serialVersionUID = 19L;

    private HashMap<Integer, Integer> Indexer;

    public FurnitureDirectory() {
        this.Indexer = new HashMap<>();
    }
    
    public boolean addFurniture(Furniture f, int amount) {
        if (Indexer.keySet().contains(f.getID())) {
            Indexer.put(f.getID(), Indexer.get(f.getID() + amount));
            return true;
        } else {
            Indexer.put(f.getID(), amount);
            return this.add(f);
        }
    }

    public boolean removeFurniture(Furniture f, int amount) {
        if (Indexer.keySet().contains(f.getID())) {
            Indexer.put(f.getID(), Indexer.get(f.getID()) - amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateFurniture(Furniture f) {
        for (int i = 0; i < this.size(); i++) {
            if (f.getID() == this.get(i).getID()) {
                this.set(i, f);
                return true;
            }
        }
        return false;
    }

    public int getRemain(Furniture f) {
        return this.Indexer.get(f.getID());
    }
    
    /**
     * 
     * @param n
     * @return 
     */
    public Furniture getByName(String n){
        return this.stream()
                .filter(f -> f.getName().equals(n))
                .findAny()
                .orElse(null);
    }

    /**
     * search by name
     *
     * @param keyWord
     * @return
     */
    public FurnitureDirectory SearchByName(String keyWord) {
        return this.stream()
                .filter(c -> c.getName().toLowerCase().contains(keyWord.toLowerCase()))
                .collect(Collectors
                        .toCollection(FurnitureDirectory::new));
    }

    /**
     *
     * @param keyWord
     * @return
     */
    public FurnitureDirectory SearchByType(String keyWord) {
        return this.stream()
                .filter(c -> c.getType().toLowerCase().contains(keyWord.toLowerCase()))
                .collect(Collectors
                        .toCollection(FurnitureDirectory::new));
    }

    /**
     *
     * @param keyWord
     * @return
     */
    public FurnitureDirectory SearchByWood(String keyWord) {
        return this.stream()
                .filter(c -> c.getWoodType().toLowerCase().contains(keyWord.toLowerCase()))
                .collect(Collectors
                        .toCollection(FurnitureDirectory::new));
    }

    /**
     * Search by color
     *
     * @param keyWord
     * @return
     */
    public FurnitureDirectory SearchByColor(String keyWord) {
        return this.stream()
                .filter(c -> c.getColor().toLowerCase().contains(keyWord.toLowerCase()))
                .collect(Collectors
                        .toCollection(FurnitureDirectory::new));
    }
     
    /**
     * 
     * @param min
     * @param max
     * @return 
     */
    public FurnitureDirectory SearchByPrice(Double min, Double max) {
        return this.stream()
                .filter(c -> c.getPrice() <= max && c.getPrice() >= min)
                .collect(Collectors
                        .toCollection(FurnitureDirectory::new));
    }
    
    /**
     * 
     * @param keyWord
     * @return 
     */
    public FurnitureDirectory SearchByBrand(String keyWord) {
        return this.stream()
                .filter(c -> c.getManufacturer().toLowerCase().contains(keyWord.toLowerCase()))
                .collect(Collectors
                        .toCollection(FurnitureDirectory::new));
    }

}
