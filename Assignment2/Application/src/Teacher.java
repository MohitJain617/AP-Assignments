public class Teacher {
	private static int count = 0; //number of teachers
	private String name;
	private int id;  //unique identifier
	
	public Teacher(String name){
		this.name = name;
		this.id = count;
		count++;
	}
	public String getName(){
		return this.name;
	}
}
