package Business.Furniture;

import javax.imageio.ImageIO;

import Business.SerializiedObject;
import java.awt.Image;

/**
 * 家具类
 *
 */
public class Furniture extends SerializiedObject {
    
    private String name, type, woodType, color; // 家具名字， 类型， 木类型， 颜色
    private String Manufacturer, seller; // 家具制造商， 销售商
    private Double price, height, width, length;// 家具价格， 高度， 宽度， 长度
    private String image;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWoodType() {
        return this.woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacturer() {
        return this.Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public String getSeller() {
        return this.seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return this.width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return this.length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return name; 
    }
    
    
    
    public static String[] FurtinureTypes = new String[]{
        "Chair",
        "Lift chair",
        "Bean bag",
        "Chaise longue",
        "Fauteuil",
        "Ottoman",
        "Recliner",
        "Stool",
        "Bar Stool",
        "Footstool or ottoman",
        "Tuffet",
        "Fainting couch",
        "Rocking chair",
        "Bar chair",
        "Bench",
        "Couch, also known as a sofa or settee",
        "Accubita",
        "Canapé",
        "Davenport",
        "Klinai",
        "Divan",
        "Love seat",
        "Chesterfield",
        "Bed",
        "Bunk bed",
        "Canopy bed",
        "Four-poster bed",
        "Murphy bed",
        "Platform bed",
        "Sleigh bed",
        "Waterbed",
        "Daybed",
        "Futon",
        "Hammock",
        "Headboard",
        "Infant bed (crib, cradle)",
        "Sofa bed",
        "Toddler bed",
        "Billiard table",
        "Chess table",
        "Entertainment center",
        "Gramophone",
        "Hi-fi",
        "Jukebox",
        "Pinball machine",
        "Radiogram",
        "Home bar",
        "Radio receiver",
        "Piano",
        "Countertop",
        "Chabudai",
        "Changing table",
        "Desk",
        "Davenport desk",
        "Drawing board",
        "Computer desk",
        "Writing desk",
        "Kotatsu",
        "Korsi",
        "Lowboy",
        "Monks bench",
        "Pedestal",
        "Table",
        "Game Table",
        "Coffee table",
        "Dining table",
        "Refectory table",
        "Drop-leaf table",
        "End table",
        "Folding table",
        "Gateleg table",
        "Poker table",
        "Trestle table",
        "TV tray table",
        "Wine table",
        "Washstand",
        "Workbench",
        "Baker's rack",
        "Bookcase",
        "Cabinetry",
        "Bathroom cabinet",
        "Chifforobe",
        "Closet",
        "Cupboard",
        "Curio cabinet",
        "Gun cabinet",
        "Hutch",
        "Hoosier cabinet",
        "Kitchen cabinet",
        "Liquor cabinet",
        "Pantry",
        "Pie safe",
        "Stipo a bambocci",
        "Chest of drawers or dresser",
        "Chest",
        "Cellarette",
        "Hope chest",
        "Coat rack",
        "A coat rack",
        "Drawer (furniture)",
        "Hall tree",
        "Hatstand",
        "Bar cabinet",
        "Filing cabinet",
        "Floating shelf",
        "Nightstand",
        "Ottoman",
        "Plan chest",
        "Plant stand",
        "Shelving",
        "Sideboard or buffet",
        "Umbrella stand",
        "Wardrobe or armoire",
        "Wine rack",
        "A bedroom set",
        "Bedroom set (group)",
        "Dinette (group)",
        "Dining set",
        "Vanity set",
        "Portable Lamps",
        "Patio set"
    };

    Object getWood() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
