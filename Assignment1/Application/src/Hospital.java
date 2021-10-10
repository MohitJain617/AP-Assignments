import java.util.*;
public class Hospital {
	private ArrayList<Slot> slots;
	private String name;
	private String pincode;
	private int id; //100000 to 999999

	public Hospital(String name, String pincode, int id){
		this.name = name;
		this.pincode = pincode;
		this.id = id;
		slots = new ArrayList<Slot>();
	}
	public boolean matchId(int id){
		return (this.id == id);
	}
	public boolean matchPincode(String pinCode){
		return pinCode.equals(this.pincode);
	}
	//sees if any of the slots contains the vaccine
	public boolean availableVaccine(String vname){
		for(Slot s: slots){
			if(s.matchVaccine(vname) == true) return true;
		}
		return false;
	}
	public void createSlot(int day_no, int quantity, Vaccine vaccine){
		Slot s1 = new Slot(day_no, quantity, vaccine);
		slots.add(s1);
		//System.out.println();
	}
	public boolean printAllSlots(){
		boolean check = false;
		int i = 0;
		for(Slot s: slots){
			System.out.println(i+"->"+s);
			i++;
			check = true;
		}
		if(check == false){
			System.out.println("No Slots available");
			return false;
		}
		else return true;
	}
	//true if slots available, false if not
	public boolean printSlotsWithConditions(String vname, int dueDate, int doses){
		int i = 0;
		boolean check = false;
		for(Slot s: slots){
			if(s.matchPatientNeeds(vname,dueDate,doses) == true){
				System.out.println(i+"->"+s);
				check = true;
			}
			i++;
		}
		if(check == false){
			System.out.println("No Slots available");
			return false;
		}
		return true;
	}

	public boolean vaccinatePatient(Citizen c, int slotIndex){
		if((slotIndex < 0) || (slotIndex >= slots.size()) || (slots.get(slotIndex).getDay() < c.getDueDate())){
			System.out.println("Invalid slot entered");
			return false;
		}
		int val = slots.get(slotIndex).useVaccine();
		Vaccine vac = slots.get(slotIndex).getVaccine();
		c.getVaccinated(slots.get(slotIndex).getDay(), vac);
		if(val == 0){
			slots.remove(slotIndex);
		}
		return true;
	}

	public String toString(){
		return (id) + " " + this.name;
	}
}
