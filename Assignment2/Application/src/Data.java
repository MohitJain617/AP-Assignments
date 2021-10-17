import java.util.ArrayList;

public class Data {
	private ArrayList<LectureMaterial> material;
	private ArrayList<Assessment> assessments;

	public Data(){
		material = new ArrayList<LectureMaterial>();
		assessments = new ArrayList<Assessment>();
	}
	//teacher t passed as parameter to ensure that t is a teacher
	public void addMaterial(LectureMaterial l, Teacher t){
		if(t != null)
			material.add(l);
	}
	public void viewMaterial(){
		for(LectureMaterial lm: material){
			lm.view();
		}
	}

	public void addAssessment(Assessment a, Teacher t){
		if(t != null)
			assessments.add(a);
	}
	public void viewAssessments(){
		int len = assessments.size();
		for(int i = 0;i < len; i++){
			System.out.println("ID: "+i+" "+assessments.get(i).view());
			System.out.println("----------------");
		}
	}
	public void viewUngradedSubmissions(Teacher t,int index){
		assessments.get(index).viewSubmissions(t);
	}
	public Submission getSubmission(Teacher t,int aid, int sid){
		return assessments.get(aid).grade(t,sid);
	}
	
}
