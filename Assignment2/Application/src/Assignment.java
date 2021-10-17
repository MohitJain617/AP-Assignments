import java.util.*;

public class Assignment implements Assessment{
	private boolean close = false;
	private String problem;
	private int maxmarks;
	private ArrayList<Submission> submissions;
	
	public Assignment(String problem, int maxmarks){
		this.problem = problem;
		this.maxmarks = maxmarks;
		this.close = false;
		submissions = new ArrayList<Submission>();
	}
	@Override
	public String view(){
		return this.toString();
	}
	@Override
	public Submission grade(Teacher t, int sid){
		//returns the submission that we have to grade
		ArrayList<Submission> subs = ungradedSubmissions();
		return subs.get(sid);
	}
	@Override
	public void close(Teacher t){
		this.close = true;
	}
	@Override
	public void submit(Student s, String solution){
		Submission stemp = new Submission(s,this,solution);
		submissions.add(stemp);
	}
	@Override
	public boolean isClosed(){
		return this.close;
	}
	@Override
	public void viewSubmissions(Teacher t){
		//to view all the ungraded submissions
		ArrayList<Submission> subs = ungradedSubmissions();
		int len = subs.size();
		for(int i = 0; i < len; i++){
			System.out.println(i+". "+subs.get(i).getName());
		}
	}
	private ArrayList<Submission> ungradedSubmissions(){
		ArrayList<Submission> ungrads = new ArrayList<Submission>();
		int len = submissions.size();
		for(int i = 0; i < len; i++){
			if(submissions.get(i).isGraded() == false){
				ungrads.add(submissions.get(i));
			}
		}
		return ungrads;
	}
	@Override
	public int getMaxMarks(){
		return this.maxmarks;
	}
	
	@Override
	public String toString(){
		return "Assignment: " + this.problem + " Max Marks: "+this.maxmarks;
	}


}
