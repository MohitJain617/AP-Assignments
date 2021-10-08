public class Citizen {
	private String name;
	private int age;
	private String id;
	private Vaccine vaccine;
	private int doses;
	private int dueDate;
	
	public Citizen(String name, int age, String id){
		this.name = name;
		this.age = age;
		this.id = id;
		vaccine = null;
		doses = 0;
		dueDate = 0;
	}
	public void getVaccinated(){}
}
