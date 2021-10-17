import java.util.ArrayList;

public class Data {
	private ArrayList<LectureMaterial> material;
	private ArrayList<Assessment> assessments;

	public Data(){
		material = new ArrayList<LectureMaterial>();
		assessments = new ArrayList<Assessment>();
	}
	public void uploadLecture(LectureMaterial l){
		material.add(l);
	}
}
