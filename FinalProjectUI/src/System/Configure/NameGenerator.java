package System.Configure;

import EcoSystem.DataValidater;
import java.util.Random;

/**
 *
 * @author Bohan Feng
 */
public class NameGenerator {

    static String[] fnames = new String[]{
        "Alton", "Vincent", "Sung", "Andrew", "Clifford",
        "Stephen", "Wesley", "Steven", "James", "James",
        "Robbie", "Frank", "Brian", "Roy", "John", "Jeffrey",
        "Steven", "James", "Darrell", "Scott", "Jeremy", "James",
        "Oscar", "Carlos", "William", "Timothy", "Andrew", "Daniel",
        "David", "Devon", "Ruben", "Larry", "Frank", "Ralph",
        "Maurice", "Gerald", "Joe", "John", "Adam", "David",
        "Michael", "Guadalupe", "Christopher", "Robert", "Jeremy",
        "Dean", "Barry", "Edward", "Vernon", "Floyd", "John", "Lewis",
        "Lloyd", "Richard", "Gregory", "George", "Daniel", "Jason",
        "Russell", "Steven", "Richard", "Mitchell", "Dillon", "Leslie",
        "Andy", "Nathan", "Joseph", "Mark", "Eric", "Jimmy", "Brett",
        "Dallas", "Tony", "Frank", "David", "James", "John", "Thomas",
        "Michael", "Marvin", "Robert", "Frank", "Jordan", "Daniel",
        "Ronald", "Alex", "Whitney", "Andrew", "John", "Christopher",
        "Robert", "Sam", "William", "Robert", "Willie", "John", "Francis",
        "Jorge", "James", "Samuel",};

    static String[] lnames = new String[]{
        "Kratky", "Schroer", "Gough", "Saucier", "Roland", "Mackinder",
        "Grissom", "Rowe", "Hall", "Dam", "Hanson", "Paz", "Blevins",
        "Key", "Figueroa", "Kaiser", "Brown", "Drage", "Mcelroy",
        "Straugter", "Conti", "Maynor", "Husar", "Mills", "Herrera",
        "Schneider", "Ingalls", "Daniels", "Large", "Black", "Coleman",
        "Fluellen", "Roy", "Wheeler", "Henderson", "Grindle", "Qualls",
        "Marshall", "Nance", "Armstead", "Grondin", "Vasquez", "Webb",
        "Ryan", "Simmons", "Smith", "Ledger", "Jones", "Wilson",
        "Gray", "Mutz", "Moates", "Martin", "Eliezrie", "Mcghee",
        "Wells", "Haywood", "Foronda", "Jones", "Matthews", "Gentry",
        "Self", "Munoz", "Amaya", "Jones", "Thomes", "Santini", "Rubel",
        "Connel", "Watkins", "Ryan", "Thompson", "Parada", "Abell",
        "Davis", "Laing", "Davis", "Grice", "Castro", "Milligan",
        "Mcmillan", "Poling", "Johnson", "Pulcher", "Hogan", "Luna",
        "Powell", "James", "Gonzalez", "Marchese", "Hill", "Clark",
        "Mccarter", "Mcclellan", "Shepherd", "Megown", "Torres",
        "Inyart", "Rojas", "Martinez"
    };

    static String[] adjs = new String[]{
        "attractive", "bald", "beautiful", "fat", "large", "tiny",
        "angry", "lazy", "gentle", "jealous", "fially", "plain"

    };

    static String[] cities = new String[]{
        "North Whitneyfort",   "East Leslieport",   "South Antonioside",   
        "Markton",   "West Dana",   "Jenniferland",   "New David",   
        "South Anthony",   "Leeton",   "Michaelfort",   "East Kevin",   
        "Jennifershire",   "Rodriguezbury",   "New Ebony",   "North Cheryl",   
        "Lake Larrybury",   "Pricebury",   "North Meganhaven",   "Smithhaven",   
        "West Robertmouth",   "Port Christine",   "Codyborough",   "Yorkchester",   
        "East Hannahton",   "North Danielberg",   "Hartland",   "Port Jeremy",   
        "Smithberg",   "Douglasside",   "North Nicole",   "East Nicole",   
        "Port Matthewmouth",   "Kathrynchester",   "North Raymond",   
        "Port Marymouth",   "South Carla",   "Thomasport",   "Stephentown",   
        "Port Ericaburgh",   "Port Gabriella",   "Ryanport",   "Gonzalesfurt",   
        "Harrisberg",   "Donnabury",   "Doylemouth",   "Derekborough",   
        "Erichaven",   "Bellville",   "Lauramouth",   "Melissaton",   
        "East Kellyshire",   "North Shawn",   "Brendafort",   "Jeffreyburgh",   
        "South Jordan",   "Mayton",   "New Kathleentown",   "Hernandezburgh",   
        "Port Justinfort",   "Williamsside",   "Christopherville",   
        "East Richardberg",   "New Tina",   "New Jacquelineshire",   "West Corey",   
        "Timothyport",   "Alexandermouth",   "Lake Jeffreyton",   "Rodriguezland",   
        "Marcusland",   "West Charlesville",   "Natashashire",   "Clarkmouth",   
        "Victorfort",   "South Davidhaven",   "North Brandonport",   "Tinaport",   
        "North Derrickburgh",   "South Erinhaven",   "Christopherfurt",   "Port Jill",   
        "Port Justinborough",   "West Suzanne",   "Maryborough",   "Hilltown",   
        "Port Jessica",   "Markbury",   "Jeanneberg",   "Hermanhaven",   "Ronaldbury",   
        "East Alechaven",   "Arnoldside",   "South Sean",   "New Reginaside",   
        "East Jeffrey",   "Bradleybury",   "Ericborough",   "Donnaville",   
        "North Adrienneport",   "Bradfordfurt",  
    };
    
    static String[] streets = new String[]{
        "572 Kayla Plain Suite 708",   "6282 Paul Roads",   "8359 Madison Knolls",   
        "24156 Franco Light Suite 855",   "441 Vaughn Mountain",   "25810 Bowman Walk",   
        "0374 Christopher Isle Apt. 652",   "01542 James Court",   "234 Rhodes Roads Apt. 118",   
        "6241 Leslie Crossing Apt. 769",   "81832 Washington Springs Apt. 495",   
        "9754 Matthew Canyon",   "55417 Nathan Lock",   "56137 David Burgs",   
        "67724 Mcdaniel Heights",   "1469 Goodman Port Apt. 561",   
        "44687 Elizabeth Mountains Suite 487",   "15365 Thomas Bypass",   
        "40774 Charles Union",   "9227 Timothy Village",   "674 John Square",   
        "872 Kimberly Tunnel",   "68550 David Throughway",   "52722 Stephanie Knolls",   
        "4110 Kurt Rue Suite 359",   "98795 Brittany Plains Apt. 745",   
        "923 Mosley Lights Suite 882",   "087 Richard Valley",   
        "262 Lambert Stravenue Suite 180",   "1643 Brian Glens",   "280 Obrien Isle",   
        "820 King Mill Suite 090",   "9155 Kathryn Plains",   "934 Michael Cliff",   
        "515 Angela Parkways",   "39160 Melissa Motorway Suite 512",   
        "84230 Diaz Lane Suite 523",   "56806 Harris Estate Apt. 999",   
        "520 Susan Falls Apt. 038",   "982 Ponce Island",   "85228 Melanie Streets Suite 963",   
        "05945 David Harbors Suite 890",   "381 Murphy Forge",   "9089 Linda Points Suite 014",   
        "826 Cortez Extension",   "1892 Stephen Spur Suite 391",   "148 Lauren Course Suite 383",   
        "81968 Taylor Terrace",   "0209 Pamela Fork Apt. 415",   "62956 Robert River"
    };

    public static String getFirstName() {
        return fnames[new Random().nextInt(fnames.length)];
    }

    public static String getLastName() {
        return lnames[new Random().nextInt(lnames.length)];
    }

    public static String getAdj() {
        return adjs[new Random().nextInt(adjs.length)];
    }

    public static String getState() {
        return (String) DataValidater.states.keySet().toArray()[new Random().nextInt(adjs.length)];
    }
    
    public static String getCity(){
        return cities[new Random().nextInt(cities.length)];
    }
    
    public static String getStreet(){
        return streets[new Random().nextInt(streets.length)];
    }
    
    public static String getZip(){
        return "" + Math.abs(new Random().nextInt(89999) + 10000);
    }
}
