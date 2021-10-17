import java.util.ArrayList;

public class LectureSlide implements LectureMaterial{
	private String topic;  //topic name of slide
	private int num;      //number of slides
	private ArrayList<String> slides; 
	private String date;
	private String uploadedBy;
	
	public LectureSlide(String topic, int num, ArrayList<String> slides, String date, String uploadedBy){
		this.topic = topic;
		this.num = num;
		this.slides = slides;
		this.date = date;
		this.uploadedBy = uploadedBy;
	}

	@Override
	public void view(){
		//code elided
	}
}
