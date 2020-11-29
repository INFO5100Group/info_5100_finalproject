package Business;

import java.util.*;
import java.util.stream.*;

/**
 *
 * @author Bohan
 */
public class CarList extends ArrayList<Car>{
    

    /**
     * 
     * @return the new car added to car list
     */
    public Car addCar(){
        Car newCar = new Car();
        this.add(newCar);
        return newCar;
    }
    
    /**
     * update exist car with new car
     * by serial num
     * @param newCar the updated car obj 
     */
    public void updateCar(Car newCar){
        ListIterator<Car> iterator = this.listIterator();
        while(iterator.hasNext()){
            Car next = iterator.next();
            if(next.getSeriesNum().equals(newCar.getSeriesNum())){
                iterator.set(newCar);
                break;
            }
        }
    }
    
    /**
     * delete a car by serial number
     * @param deletedCar the car obj need to be deleted
     */
    public void deleteCar(Car deletedCar){
        ListIterator<Car> iterator = this.listIterator();
        while(iterator.hasNext()){
            Car next = iterator.next();
            if(next.getSeriesNum().equals(deletedCar.getSeriesNum())){
                iterator.remove();
                break;
            }
        }
    }
    
    /**
     * 
     * @return the first avaliable car
     */
    public Car getFirstAvaliabeCar(){
        
        for(Car c : this){
            if(c.isIsAvaliable())
                return c;
        }
        
        return null;
    }
    
    /**
     * 
     * @return the number of avaliable cars
     */
    
    public int getNumOfAvaliableCars(){
        try{
            return (int)(this.stream().filter(c -> c.isIsAvaliable()).count());
        }catch(java.lang.NullPointerException e){}
            
        return 0;
    }
    
    /**
     * 
     * @return the number of unavaliable cars 
     */
    public int getNumOfUnavaliableCars(){
        try{
            return (int)this.stream().filter(c -> !c.isIsAvaliable()).count();   
        }catch(java.lang.NullPointerException e){
            return 0;
        }         
    }
    
    
    /**
     * find cars by given maker
     * @param maker name of maker
     * @return carlist that contain cars with given maker
     */
    public CarList getCarsByMaker(String maker){
        
        return this.stream()
        .filter(c -> c.getMaker().equals(maker))
        .collect(Collectors
        .toCollection(CarList::new));
    }
    
    /**
     * find car made in specific year
     * @param year the year the car made
     * @return car list that contain cars with given made year
     */
    public CarList getCarsByYear(int year){
        
        return this.stream()
        .filter(c -> c.getManufactureYear() == year)
        .collect(Collectors
        .toCollection(CarList::new));
    }
    
    /**
     * find car that have specific range of seat numbers
     * @param min min value of seat numbers
     * @param max max value of seat numbers
     * @return car list that contain cars with specific number of seats
     */
    public CarList getCarsBySeats(int min, int max){
        
        return this.stream()
        .filter(c -> c.getSeatNum() >= min && c.getSeatNum() <= max)
        .collect(Collectors
        .toCollection(CarList::new));
    }
    
    /**
     *
     * @param serial
     * @return
     */
    public Car getCarBySerialNum(String serial){
        try{
            return (Car) this.stream()
            .filter(c -> c.getSeriesNum().equals(serial))
            .toArray()[0];
        }catch(java.lang.ArrayIndexOutOfBoundsException e) {}
        
        return null;
    }
    
    /**
     *
     * @param model
     * @return
     */
    public CarList getCarsByModel(String model){
        
        return this.stream()
        .filter(c -> c.getModel().equals(model))
        .collect(Collectors
        .toCollection(CarList::new));
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> getAllMakers(){
        
        return this.stream()
        .map(Car::getMaker)
        .distinct()
        .collect(Collectors
        .toCollection(ArrayList<String>::new));
    }
    
    /**
     *
     * @return
     */
    public Date getLatestUpdate(){
        
        ArrayList<Date> dates = this.stream()
        .map(Car::getUpdateTime)
        .collect(Collectors
        .toCollection(ArrayList<Date>::new));

        return Collections.max(dates);
    }
    
    /**
     *
     * @param location
     * @return
     */
    public CarList getCarsByLocation(String location){
        
        return this.stream()
        .filter(c -> c.getCity().equals(location))
        .collect(Collectors
        .toCollection(CarList::new));
    }
    
    /**
     *
     * @return
     */
    public CarList getExperiedCars(){
        
        return this.stream()
        .filter(c -> c.getMaintanceExpiredDate().after(new Date()))
        .collect(Collectors
        .toCollection(CarList::new));
    }
    
    
}
