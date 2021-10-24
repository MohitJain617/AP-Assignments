import java.util.*;
public class Game {
    public static Scanner scn = new Scanner(System.in);
    private ArrayList<Floor> floors;
    private Player p1;
    private int gamePoints;
    private Dice die;

    public Game(){
        //initializing floor
        floors = new ArrayList<Floor>();
        for(int i = 0; i < 14; i++){floors.add(null);}
        int emptyF[] = {0,1,3,4,6,7,9,10,12,13};
        for(int a: emptyF){
            Floor f = new Floor(a);
            floors.set(a,f);
        }
        Floor f2 = new Elevator(2);
        Floor f5 = new SnakeFloor(5);
        Floor f8 = new LadderFloor(8);
        Floor f11 = new KingCobra(11);
        floors.set(2,f2);
        floors.set(5,f5);
        floors.set(8,f8);
        floors.set(11,f11);

        //initializing die
        die = new Dice();

        //initializing gamepoints
        gamePoints = 0;
        
        //initializing Player
        System.out.println("Enter Player name and hit enter: ");
        String sname = scn.nextLine();
        p1 = new Player(sname);

    }

    public void startGame(){
        System.out.println("The game setup is ready");
        System.out.println("---------------------------------");
        while(rollDie() != 1){
            System.out.println("Game cannot start until you get 1");
        }
        p1.updatePos(1);
        updateStats();
        System.out.println();

        while(p1.getPos() != 13){
            int dval = rollDie();
            if(dval + p1.getPos() > 13){
                System.out.println("Player cannot move");
                System.out.println();
            } else {
                p1.updatePos(dval);
                updateStats();
                System.out.println();
            }
        }
        System.out.println("Game over");
        System.out.println(p1.getName()+" accumulated "+gamePoints +" points");
        System.out.println("------------------------------------");

    }

    public void updateStats(){
        int pos = p1.getPos();
        Floor currf = floors.get(pos);  //current floor
        int off = currf.getOffset(); //offset
        this.gamePoints += currf.getPoints(); //update points

        p1.printPosition();
        System.out.println(p1.getName() + " has reached "+currf);
        System.out.println("Total points "+gamePoints);

        if(off == 0){
            return;
        } else {
            p1.updatePos(off);
            updateStats();
        }
    }
    private int rollDie(){
        System.out.print("Hit enter to roll die:");
        scn.nextLine();
        int d = die.roll();
        System.out.println("Dice gave "+d);
        return d;
    }

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.startGame();
        scn.close();
    }
}
