public class Student {
	private static int count = 0; //number of students
	private String name;
	private int id;  //unique identifier
	private Data data;

	public Student(String name, Data data){
		this.data = data;
		this.name = name;
		this.id = count;
		count++;
	}
	public String getName(){
		return this.name;
	}
	public int getId(){
		return this.id;
	}
}
