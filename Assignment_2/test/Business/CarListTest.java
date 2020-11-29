/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bohan
 */
public class CarListTest {
    
    private static List<List<String>> cars;
    private static CarList carList;
    
    public CarListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        readFile();
        carList = getCars();
    }
    
    public static void readFile() throws FileNotFoundException, IOException{
        cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("carsData\\out.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String COMMA_DELIMITER = ",";
                String[] values = line.split(COMMA_DELIMITER);
                cars.add(Arrays.asList(values));
            }
        }
        
        int i = 0;
        while(i < 5){
            for(String s : cars.get(i)){
                System.out.print(s + ",");
            }
            System.out.println();
            i++;
        }
    
        System.out.println();
    }
    
    public static CarList getCars(){
        CarList carlist = new CarList();
        for(List<String> carInfo : cars){
            Car carToAdd = new Car();
            String[] uptime = carInfo.get(7).split("/");
            String[] maintaintime = carInfo.get(8).split("/");
            carToAdd.setIsAvaliable(carInfo.get(0).equals("True"));
            carToAdd.setMaker(carInfo.get(1));
            carToAdd.setManufactureYear(Integer.parseInt(carInfo.get(2)));
            carToAdd.setSeatNum(Integer.parseInt(carInfo.get(3)));
            carToAdd.setSeriesNum(carInfo.get(4));
            carToAdd.setModel(carInfo.get(5));
            carToAdd.setCity(carInfo.get(6));
            carToAdd.setUpdateTime(new Date(Integer.parseInt(uptime[2])-1900,Integer.parseInt(uptime[0])-1,Integer.parseInt(uptime[1])));
            carToAdd.setMaintanceExpiredDate(new Date(Integer.parseInt(maintaintime[2])-1900,Integer.parseInt(maintaintime[0])-1,Integer.parseInt(maintaintime[1])));
          
            carlist.add(carToAdd);
        }
        return carlist;
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCarInfoLoaded(){
        System.out.println("testCarInfoLoaded");
        int i = 0;
        while(i < 5){
            System.out.println(carList.get(i));
            i++;
        }
        System.out.println();
    }

    /**
     * Test of getFirstAvaliabeCar method, of class CarList.
     */
    @Test
    public void testGetFirstAvaliabeCar() {
        System.out.println("getFirstAvaliabeCar");
        
        Car result = carList.getFirstAvaliabeCar();
        assertNotNull(result);
        System.out.println(result);
        System.out.println();
    }

    /**
     * Test of getNumOfAvaliableCars method, of class CarList.
     */
    @Test
    public void testGetNumOfAvaliableCars() {
        System.out.println("getNumOfAvaliableCars");
        
        int result = carList.getNumOfAvaliableCars();
        assertEquals(1890, result);
        System.out.println(result);
        System.out.println();
    }

    /**
     * Test of getNumOfUnavaliableCars method, of class CarList.
     */
    @Test
    public void testGetNumOfUnavaliableCars() {
        System.out.println("getNumOfUnavaliableCars");
        int result = carList.getNumOfUnavaliableCars();
        assertEquals(2499 - 1890, result);
        
        System.out.println(result + "\n");
    }

    /**
     * Test of getCarsByMaker method, of class CarList.
     */
    @Test
    public void testGetCarsByMaker() {
        System.out.println("getCarsByMaker");
        String maker = "ford";
        CarList result = carList.getCarsByMaker(maker);
        assertNotNull(result);
        for(int i = 0; i < 5; i++){
            System.out.println(result.get(i));
        }
    
        System.out.println();
    }

    /**
     * Test of getCarsByYear method, of class CarList.
     */
    @Test
    public void testGetCarsByYear() {
        System.out.println("getCarsByYear");
        int year = 2011;
        CarList result = carList.getCarsByYear(year);
        assertNotNull(result);
        for(int i = 0; i < 5; i++){
            System.out.println(result.get(i));
        }
    
        System.out.println();
    }

    /**
     * Test of getCarsBySeats method, of class CarList.
     */
    @Test
    public void testGetCarsBySeats() {
        System.out.println("getCarsBySeats");
        int min = 1;
        int max = 4;
        CarList result = carList.getCarsBySeats(min, max);
        assertNotNull(result);
        
        for(int i = 0; i < 5; i++){
            System.out.println(result.get(i));
        }

        System.out.println();
    }

    /**
     * Test of getCarBySerialNum method, of class CarList.
     */
    @Test
    public void testGetCarBySerialNum() {
        System.out.println("getCarBySerialNum");
        String serial = "2fmdk3gc4bbb02217";
        String expResult = "Car{isAvaliable=false, maker=ford, manufactureYear=2011, seatNum=1, SeriesNum=2fmdk3gc4bbb02217, model=se, city=tennessee, updateTime=2016-04-15, maintanceExpiredDate=2022-07-04}";
        Car result = carList.getCarBySerialNum(serial);
        assertEquals(expResult, result.toString());
        
        System.out.println(result + "\n");
    }

    /**
     * Test of getCarsByModel method, of class CarList.
     */
    @Test
    public void testGetCarsByModel() {
        System.out.println("getCarsByModel");
        String model = "door";
        CarList result = carList.getCarsByModel(model);
        assertNotNull(result);
        for(int i = 0; i < 5; i++){
            System.out.println(result.get(i));
        }
        System.out.println();
    }

    /**
     * Test of getAllMakers method, of class CarList.
     */
    @Test
    public void testGetAllMakers() {
        System.out.println("getAllMakers");
        ArrayList<String> result = carList.getAllMakers();
        assertNotNull(result);
        
        for(int i = 0; i < 5; i++){
            System.out.println(result.get(i));
        }
        System.out.println();
    }

    /**
     * Test of getLatestUpdate method, of class CarList.
     */
    @Test
    public void testGetLatestUpdate() {
        System.out.println("getLatestUpdate");
        CarList instance = carList;
        Date result = instance.getLatestUpdate();
        assertNotNull(result);
        
        System.out.println(result + "\n");
    }

    /**
     * Test of getCarsByLocation method, of class CarList.
     */
    @Test
    public void testGetCarsByLocation() {
        System.out.println("getCarsByLocation");
        String location = "ohio";
        CarList instance = carList;
        CarList result = instance.getCarsByLocation(location);
        assertNotNull(result);
        
        for(int i = 0; i < 5; i++){
            System.out.println(result.get(i));
        }
        System.out.println();
    }

    /**
     * Test of getExperiedCars method, of class CarList.
     */
    @Test
    public void testGetExperiedCars() {
        System.out.println("getExsperiedCars");
        CarList instance = carList;
        CarList result = instance.getExperiedCars();
        assertNotNull( result);
        
        for(int i = 0; i < 5; i++){
            System.out.println(result.get(i));
        }
        
        System.out.println();
    }
    
}
