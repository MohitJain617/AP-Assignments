public class Vaccine {
	String name;
	int doses;
	int gap;

	public Vaccine(String name, int doses, int gap){
		this.name = name;
		this.doses = doses;
		this.gap = gap;
	}
	//compares a given vaccine name to the instance
	public boolean isEqual(String name){
		return name.equals(this.name);
	}
	//getters
	public int getDoses(){return this.doses;}
	public int getGap(){return this.gap;}
	public String getName(){return this.name;}
}
