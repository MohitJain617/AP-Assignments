public interface Assessment {
	public String view();
	public Submission grade(Teacher t,int sid);
	public boolean isClosed();
	public void close(Teacher t);
	public void submit(Student s, String solution);
	public void viewSubmissions(Teacher t);
	public int getMaxMarks();
}
