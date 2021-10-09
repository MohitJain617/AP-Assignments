public class Slot {
	int day_no;
	int quantity;
	Vaccine vaccine;
	public Slot(int day, int quantity, Vaccine vaccine){
		this.day_no = day;
		this.quantity = quantity;
		this.vaccine = vaccine;
	}
	public int getDay(){
		return this.day_no;
	}
	public Vaccine getVaccine(){
		return this.vaccine;
	}

	public boolean matchVaccine(String vname){
		return this.vaccine.isEqual(vname);
	}
	//takes in vaccine name, due date and doses
	public boolean matchPatientNeeds(String vname, int dueDate, int doses){
		return ((vaccine.isEqual(vname)) && (dueDate <= day_no) && (doses < vaccine.getDoses()));
	}
	public int useVaccine(){
		this.quantity--;
		return this.quantity;
	}

	public String toString(){
		return "Day: "+day_no+", Available Quantity "+quantity+", Vaccine: "+vaccine.getName();
	}
	
}
