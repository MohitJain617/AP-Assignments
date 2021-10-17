public class Student {
	private static int count = 0; //number of students
	private String name;
	private int id;  //unique identifier

	public Student(String name){
		this.name = name;
		this.id = count;
		count++;
	}
	public String getName(){
		return this.name;
	}
}
