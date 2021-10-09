public class Slot {
	int day_no;
	int quantity;
	Vaccine vaccine;
	public Slot(int day, int quantity, Vaccine vaccine){
		this.day_no = day;
		this.quantity = quantity;
		this.vaccine = vaccine;
	}
	public boolean matchVaccine(String vname){
		return this.vaccine.isEqual(vname);
	}
	public String toString(){
		return "Day: "+day_no+", Available Quantity "+quantity+", Vaccine: "+vaccine.getName();
	}
	
}
