import java.util.*;
public class App {
    private ArrayList<Hospital> hospitals;
    private ArrayList<Vaccine> vaccines;
    private HashMap<String,Citizen> citizens;

    static Scanner scn = new Scanner(System.in);

    public App(){
        hospitals = new ArrayList<Hospital>();
        vaccines = new ArrayList<Vaccine>();
        citizens = new HashMap<String, Citizen>();
    }

    public void addVaccine(){
        //prompt and input
        System.out.print("Vaccine Name: ");
        String name = scn.next();
        System.out.print("Number of Doses: ");
        int doses = scn.nextInt();
        int gap = 0;
        if(doses != 1){
            System.out.print("Gap between Doses: ");
            gap = scn.nextInt();
            scn.next(); //to eat trailing new line
        }

        for(Vaccine v: vaccines){
            if(v.isEqual(name) == true){
                System.out.println("Vaccine named " + name + " already exists");
                return;
            }
        }
        Vaccine v1 = new Vaccine(name,doses,gap);
        vaccines.add(v1);
        System.out.println("Vaccine name: " + name + ", Number of doses: " + doses + ", Gap between doses: " + doses);
    }
    public void registerHospital(){
        //input
        System.out.print("Hospital Name: ");
        String name = scn.next();
        System.out.print("PinCode: ");
        String pincode = scn.next();

        int id = 100000+hospitals.size();
        Hospital h = new Hospital(name,pincode,id);
        hospitals.add(h);
        System.out.println("Hospital Name: " + name + ", PinCode:" + pincode + ", Unique ID: " + id);
    }
    public void registerCitizen(){
        //input
        System.out.print("Citizen Name: ");
        String name = scn.next();
        System.out.print("Age: ");
        int age = scn.nextInt();
        scn.next(); //eat trailing new line
        System.out.print("Unique ID: ");
        String uniqueId = scn.next();

        if(citizens.containsKey(uniqueId) == true){
            System.out.println("Entered unique id has already been registered once.");
            return;
        }
        Citizen c = new Citizen(name,age,uniqueId);
        citizens.put(uniqueId,c);
        System.out.println(c);
    }
    public void createSlots(){
        System.out.print("Enter Hospital ID: ");
        int hID = scn.nextInt();
        hID = hID - 100000;
        if((hID >= hospitals.size()) || (hID < 0)){
            System.out.println("Invalid Hospital ID");
            return;
        } else {
            System.out.print("Enter number of Slots to be added: ");
            int n = scn.nextInt();
            for(int i = 0; i < n; i++){
                System.out.print("Enter Day Number: ");
                int day_no = scn.nextInt();
                System.out.print("Enter Quantity: ");
                int quantity = scn.nextInt();
                int j = 0;
                System.out.println("Select Vaccine");
                for(Vaccine v: vaccines){
                    System.out.println(j+". "+v.getName());
                    j++;
                }
                int index = scn.nextInt();
                if((index < 0) || (index >= vaccines.size())) System.out.println("Invalid Code");
                else{
                    hospitals.get(hID).createSlot(day_no,quantity,vaccines.get(index));
                    //printing output
                    System.out.println("Slot added by Hospital " + (100000+hID) + 
                    "for Day: " + day_no + ", Available Quantity: " + quantity + " of Vaccine "
                    + vaccines.get(index).getName());
                }
            }
        }
    }
    public void bookSlot(){
        //inputs and prompts
        System.out.print("Enter patient Unique ID: ");
        String cID = scn.next(); //cID = citizen ID
        if(citizens.containsKey(cID) == false) {
            System.out.println("Invalid / Unregistered Unique ID Entered.");
            return;
        }
        System.out.println("1. Search by area");
        System.out.println("2. Search by Vaccine");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");
        int choice = scn.nextInt();
        scn.next();
        if(choice == 1){
            System.out.print("Enter Pincode: ");
            String pinCode = scn.next();
            //print matching hospitals
            for(Hospital h: hospitals){
                if(h.matchPincode(pinCode) == true){
                    System.out.println(h.toString());
                }
            }
        } else if(choice == 2){
            System.out.print("Enter Vaccine name: ");
            String vName = scn.next();
            //print matching hospitals
            for(Hospital h: hospitals){
                if(h.availableVaccine(vName) == true){
                    System.out.println(h);
                }
            }
        } else {
            return;
        }
        System.out.print("Enter hospital ID: ");
        int hID = scn.nextInt();
        hID = hID - 100000;
        
    }
    public void slotsAvailableInHospital(){}
    public void vaccinationStatus(){
        System.out.print("Enter Patient ID: ");
        String id = scn.next();
        if(citizens.containsKey(id) == true){
            Citizen c = citizens.get(id);
            c.printStatus();
        } else {
            System.out.println("Unregistered/Invalid ID");
        }
    }
    public static void main(String[] args) throws Exception { 

        scn.close();
    }
}
