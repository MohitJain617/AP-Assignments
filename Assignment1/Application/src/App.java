import java.util.*;
public class App {
    private ArrayList<Hospital> hospitals;
    private ArrayList<Vaccine> vaccines;
    private HashMap<String,Citizen> citizens;

    public App(){
        hospitals = new ArrayList<Hospital>();
        vaccines = new ArrayList<Vaccine>();
        citizens = new HashMap<String, Citizen>();
    }

    public void addVaccine(String name, int doses, int gap){
        for(Vaccine v: vaccines){
            if(v.isEqual(name) == true){
                // System.out.println("Vaccine named " + name + " already exists");
                return;
            }
        }
        Vaccine v1 = new Vaccine(name,doses,gap);
        vaccines.add(v1);
        // System.out.println("Vaccine name: " + name + ", Number of doses: " + doses + ", Gap between doses: " + doses);
    }
    public void registerHospital(String name, String pincode){
        int id = 100000+hospitals.size();
        Hospital h = new Hospital(name,pincode,id);
        hospitals.add(h);
        // System.out.println("Hospital Name: " + name + ", PinCode:" + pincode + ", Unique ID: " + id);
    }
    public void registerCitizen(String name, int age, String uniqueId){
        if(citizens.containsKey(uniqueId) == true){
            System.out.println("Entered unique id has already been registered once.");
            return;
        }
        Citizen c = new Citizen(name,age,uniqueId);
        citizens.put(uniqueId,c);
        // System.out.println("Citizen name: " + name + ", Age:" + age + ", Unique ID: " + uniqueId);
    }
    public void createSlots(){}
    public void bookSlot(){}
    public void slotsAvailableInHospital(){}
    public void vaccinationStatus(){}
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        scn.close();
    }
}
