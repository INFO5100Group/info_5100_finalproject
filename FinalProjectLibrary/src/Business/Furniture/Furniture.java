package Business.Furniture;

import javax.imageio.ImageIO;

import Business.SerializiedObject;

/**
 * 家具类 
 * */ 
public class Furniture extends SerializiedObject{
    private String name, type, woodType, color; // 家具名字， 类型， 木类型， 颜色
    private String Manufacturer, seller; // 家具制造商， 销售商
    private Double price, height, width, length;// 家具价格， 高度， 宽度， 长度
    private int remian;// 家具存量
    private ImageIO image;

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

    public int getRemian() {
        return this.remian;
    }

    public void setRemian(int remian) {
        this.remian = remian;
    }

    public ImageIO getImage() {
        return this.image;
    }

    public void setImage(ImageIO image) {
        this.image = image;
    }
}
