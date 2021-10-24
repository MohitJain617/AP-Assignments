public class LadderFloor extends Floor {
	
	public LadderFloor(int loc){
		super(loc);
	}
	@Override
	public int getPoints(){
		return super.getPoints()+1;
	}
	@Override
	public int getOffset(){
		return super.getOffset()+4;
	}
	@Override
	public String toString(){
		return "a Ladder Floor";
	}
}
