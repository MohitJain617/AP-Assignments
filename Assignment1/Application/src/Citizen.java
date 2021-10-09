public class Citizen {
	private String name;
	private int age;
	private String id;
	private Vaccine vaccine;
	private int doses; //doses taken
	private int dueDate; //due date to take next dose
	
	public Citizen(String name, int age, String id){
		this.name = name;
		this.age = age;
		this.id = id;
		vaccine = null;
		doses = 0;
		dueDate = 0;
	}
	//getters
	public String getName(){
		return this.name;
	}
	public int getDueDate(){
		return this.dueDate;
	}
	public int getDoses(){
		return this.doses;
	}
	public String getVaccineName(){
		return this.vaccine.getName();
	}

	public void printStatus(){
		if(doses == 0){
			System.out.println("Registered");
		} else if((vaccine != null) && (doses < vaccine.getDoses())){
			System.out.println("Partially Vaccinated");
			System.out.println("Vaccine taken: " + vaccine.getName());
			System.out.println("Number of doses given: " + this.doses);
			System.out.println("Next due date: " + this.dueDate);
		} else {
			System.out.println("Fully Vaccinated");
			System.out.println("Vaccine taken: " + vaccine.getName());
			System.out.println("Number of doses given: " + this.doses);
		}
	}
	public void getVaccinated(int date, Vaccine v){
		doses++;
		this.vaccine = v;
		dueDate = date+this.vaccine.getGap();
	}
	public String toString(){
		return "Citizen name: " + name + ", Age:" + age + ", Unique ID: " + id;
	}
}
