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
	public void createSlot(int day_no, int quantity, Vaccine vaccine){
		Slot s1 = new Slot(day_no, quantity, vaccine);
		slots.add(s1);
		//System.out.println();
	}
}
