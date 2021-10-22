public class LadderFloor extends Floor {
	
	public LadderFloor(int loc){
		super(2,4,loc);
	}
	@Override
	public String toString(){
		return "an Empty Floor";
	}
}

class Elevator extends Floor{

	public Elevator(int loc){
		super(4,8,loc);
	}
	@Override
	public String toString(){
		return "an Empty Floor";
	}

}