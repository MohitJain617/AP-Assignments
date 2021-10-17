import java.util.*;

public class Backpack {
    private static Scanner scn = new Scanner(System.in);
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private Data data;
    private boolean validFile(String s, String q){
        if(s.length() <= q.length()) return false;
        else if(q.equals(s.substring(s.length()-q.length(),s.length()))){
            return true;
        } else{
            return false;
        }
    }

    public Backpack(){
        data = new Data();
    }
    public void MainMenu(){
        while(true){
            System.out.println("1 for teacher, 2 for student\n");
            int choice = scn.nextInt();
            if(choice == 1){
                teachersMenu();
            } else if (choice == 2){
                studentsMenu();
            } else {

            }
        }
    }
    public void teachersMenu(){
        int tid = scn.nextInt(); //teachers id
        if(tid < teachers.size()){
            //error
        }
        Teacher t = teachers.get(tid);
        int option;      //option choosen for operation
        option = scn.nextInt();
        while(true){
            if(option == 1){
                //add lecture materials
                System.out.println("1. Add Lecture Slides");
                System.out.println("2. Add Lecture Videos");

                int choice = scn.nextInt();
                scn.nextLine(); //eating trailing newline

                if(choice == 1){
                    //lecture slide 
                    System.out.print("Enter topic of slides: ");
                    String topic = scn.nextLine();
                    System.out.print("Enter number of slides: ");
                    int n = scn.nextInt();
                    scn.nextLine();  //trailing new line
                    System.out.print("Enter Contents of Slides");

                    ArrayList<String> slides = new ArrayList<String>();
                    for(int i = 1; i <= n; i++){
                        System.out.print("Content of slide "+i+": ");
                        String temp = scn.nextLine();
                        slides.add(temp);
                    }
                    Date date = new Date();
                    LectureMaterial ltemp = new LectureSlide(topic,n,slides,date.toString(),t);  //polymorphism
                    data.addMaterial(ltemp,t);
                } else if(choice == 2){
                    //lecture video
                    System.out.print("Enter topic of video: ");
                    String topic = scn.nextLine();
                    System.out.print("Enter finename of video: ");
                    String filename = scn.next();
                    //check if valid filename
                    boolean ok = validFile(filename,".mp4");
                    Date date = new Date();
                    if(ok == true){
                        LectureMaterial ltemp = new LectureVideo(topic,filename,date.toString(),t);
                        data.addMaterial(ltemp,t);
                    } else {
                        System.out.println("Invalid file format,");
                        System.out.println("Please repeat the steps with valid file format to upload successfully.");
                        continue;
                    }
                } else {
                    System.out.println("Invalid option selected");
                }
            } else if(option == 2){
                //Add assessments
                System.out.println("1. Add Assignment");
                System.out.println("2. Add Quiz");
                int choice = scn.nextInt();
                scn.nextLine(); //eat trailing newline
                if(choice == 1){
                    System.out.print("Enter problem statement: ");
                    String problem = scn.nextLine();
                    System.out.print("Enter max marks: ");
                    int maxmarks = scn.nextInt();
                    scn.nextLine();  //trailing newline
                    Assessment atemp = new Assignment(problem,maxmarks);
                    data.addAssessment(atemp,t);
                } else if(choice == 2){
                    System.out.print("Enter quiz question: ");
                    String question = scn.nextLine();
                    Assessment qtemp = new Quiz(question);
                    data.addAssessment(qtemp,t);
                } else {
                    System.out.println("Invalid Choice entered.");
                }
            } else if(option == 3){
                data.viewMaterial();
            } else if(option == 4){
                data.viewAssessments();
            } else if(option == 5){
                System.out.println("List of Assessments");
                data.viewAssessments();
                System.out.print("Enter ID of assessment to view submissions: ");
                int aid = scn.nextInt(); //assessment id
                scn.nextLine(); //eat trailing newline
                this.data.viewUngradedSubmissions(t,aid);
                int sid = scn.nextInt(); //submission id
                Submission sub = data.getSubmission(t,aid,sid);
                System.out.println("Submission: "+sub.getSolution());
                System.out.println("----------------------");
                System.out.println("Max Marks: "+sub.getMaxMarks());
                System.out.print("Marks Scored: ");
                int marks = scn.nextInt();
                scn.nextLine();
                sub.grading(t,marks);
            } else if(option == 6){
                data.viewOpenAssessments(t);
                System.out.print("Enter id of assessment to close: ");
                int idx = scn.nextInt();
                scn.nextLine();
                data.closeAssessments(t,idx);
            } else if(option == 7){
                data.viewComments();
            } else if(option == 8){
                System.out.print("Enter Comment: ");
                String cmt = scn.nextLine();
                Date d = new Date();
                data.addComment(cmt,t.getName(),d.toString());
            } else if(option == 9){
                break;
            }
        }
    }
    public void studentsMenu(){}
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        scn.close();
    }
}
