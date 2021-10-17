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

                    LectureMaterial ltemp = new LectureSlide(topic,n,slides,"date",t.getName());  //polymorphism
                    data.uploadLecture(ltemp);
                } else if(choice == 2){
                    //lecture video
                    System.out.print("Enter topic of video: ");
                    String topic = scn.nextLine();
                    System.out.print("Enter finename of video: ");
                    String filename = scn.next();
                    //check if valid filename
                    boolean ok = validFile(filename,".mp4");
                    if(ok == true){
                        LectureMaterial ltemp = new LectureVideo(topic,filename,"date",t.getName());
                        data.uploadLecture(ltemp);
                    } else {
                        System.out.println("Invalid file format,");
                        System.out.println("Please repeat the steps with valid file format to upload successfully.");
                        continue;
                    }
                } else {
                    //
                }
            }
        }
    }
    public void studentsMenu(){}
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        scn.close();
    }
}
