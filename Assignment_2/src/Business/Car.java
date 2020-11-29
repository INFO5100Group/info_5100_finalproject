package Business;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bohan
 */
public class Car {
    private boolean isAvaliable;
    private String maker;
    private int manufactureYear;
    private int seatNum;
    private String SeriesNum;
    private String model;
    private String city;
    private Date updateTime;
    private Date maintanceExpiredDate;

    @Override
    public String toString() {
        return "Car{" + "isAvaliable=" + isAvaliable + ", maker=" + maker + ", manufactureYear=" + manufactureYear + ", seatNum=" + seatNum + ", SeriesNum=" + SeriesNum + ", model=" + model + ", city=" + city + ", updateTime=" + new SimpleDateFormat("yyyy-MM-dd").format(updateTime) + ", maintanceExpiredDate=" + new SimpleDateFormat("yyyy-MM-dd").format(maintanceExpiredDate) + '}';
    }
    
    /**
     *
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }
    
    /**
     *
     * @return
     */
    public boolean isExpired(){
        return maintanceExpiredDate.after(new Date());
    }

    /**
     *
     * @return
     */
    public boolean isIsAvaliable() {
        return isAvaliable;
    }

    /**
     *
     * @param isAvaliable
     */
    public void setIsAvaliable(boolean isAvaliable) {
        this.isAvaliable = isAvaliable;
    }

    /**
     *
     * @return
     */
    public String getMaker() {
        return maker;
    }

    /**
     *
     * @param maker
     */
    public void setMaker(String maker) {
        this.maker = maker;
    }

    /**
     *
     * @return
     */
    public int getManufactureYear() {
        return manufactureYear;
    }

    /**
     *
     * @param manufactureYear
     */
    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    /**
     *
     * @return
     */
    public int getSeatNum() {
        return seatNum;
    }

    /**
     *
     * @param seatNum
     */
    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    /**
     *
     * @return
     */
    public String getSeriesNum() {
        return SeriesNum;
    }

    /**
     *
     * @param SeriesNum
     */
    public void setSeriesNum(String SeriesNum) {
        this.SeriesNum = SeriesNum;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @return
     */
    public Date getMaintanceExpiredDate() {
        return maintanceExpiredDate;
    }

    /**
     *
     * @param m
     */
    public void setMaintanceExpiredDate(Date m) {
        this.maintanceExpiredDate = m;
    }
    
    
}
