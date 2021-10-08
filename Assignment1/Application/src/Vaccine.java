public class Vaccine {
	String name;
	int doses;
	int gap;

	public Vaccine(String name, int doses, int gap){
		this.name = name;
		this.doses = doses;
		this.gap = gap;
	}
	public boolean isEqual(String name){
		return name.equals(this.name);
	}
}
