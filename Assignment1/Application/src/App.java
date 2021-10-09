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
        }

        for(Vaccine v: vaccines){
            if(v.isEqual(name) == true){
                System.out.println("Vaccine named " + name + " already exists");
                return;
            }
        }
        Vaccine v1 = new Vaccine(name,doses,gap);
        vaccines.add(v1);
        System.out.println("Vaccine name: " + name + ", Number of doses: " + doses + ", Gap between doses: " + gap);
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
        scn.nextLine();
        String name = scn.nextLine();
        System.out.print("Age: ");
        int age = scn.nextInt();
        if(age < 18){
            System.out.println("Underage for vaccination");
            return;
        }
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
                    " for Day: " + day_no + ", Available Quantity: " + quantity + " of Vaccine "
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
        String vName = "";
        if(choice == 1){
            System.out.print("Enter Pincode: ");
            String pinCode = scn.next();
            //print matching hospitals
            for(Hospital h: hospitals){
                if(h.matchPincode(pinCode) == true){
                    System.out.println(h);
                }
            }

        } else if(choice == 2){
            System.out.print("Enter Vaccine name: ");
            vName = scn.next();
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
            //to reference the citizen getting vaccinated and the hospital choosen
            Citizen cCurr = citizens.get(cID);
            Hospital hCurr = hospitals.get(hID);
            boolean available;
            if(cCurr.getDoses() == 0){
                if(choice == 1) available = hCurr.printAllSlots();
                else available = hCurr.printSlotsWithConditions(vName, 0,0);
            } else {
                //slots available that the patient can take
                available = hCurr.printSlotsWithConditions(cCurr.getVaccineName(),cCurr.getDueDate(),cCurr.getDoses());
            }
            if(available == false) return;
            else {
                System.out.print("Choose Slot: ");
                int slotIndex = scn.nextInt();
                boolean success = hCurr.vaccinatePatient(cCurr,slotIndex);
                if(success == true){
                    System.out.println(cCurr.getName()+" has been vaccinated with "+cCurr.getVaccineName());
                }
            }
        
    }
    public void slotsAvailableInHospital(){
        System.out.print("Enter Hospital ID:");
        int hID = scn.nextInt();
        hID = hID - 100000;
        if((hID < 0) || (hID >= hospitals.size())){
            System.out.println("Invalid Hospital ID entered");
            return;
        }
        hospitals.get(hID).printAllSlots();
    }
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

    public void printMenu(){
        System.out.println("---------------------------");
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for Vaccination");
        System.out.println("5. Book SLot for Vaccination");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        System.out.println("---------------------------");
    }
    public void run(){
        while(true){
            this.printMenu();
            int code = scn.nextInt();
            if(code == 1){
                this.addVaccine();
            }
            else if(code == 2){
                this.registerHospital();
            }
            else if(code == 3){
                this.registerCitizen();
            }
            else if(code == 4){
                this.createSlots();
            }
            else if(code == 5){
                this.bookSlot();
            }
            else if(code == 6){
                this.slotsAvailableInHospital();
            }
            else if(code == 7){
                this.vaccinationStatus();
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception { 
        App CoWin = new App();
        System.out.println("CoWin Portal Initalized...");
        CoWin.run();

        scn.close();
    }
}
