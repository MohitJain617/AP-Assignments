public class KingCobra extends SnakeFloor{

	public KingCobra(int loc){
		super(loc);
	}
	@Override
	public int getPoints(){
		return super.getPoints()-2;
	}
	@Override
	public int getOffset(){
		return super.getOffset()-4;
	}
	@Override
	public String toString(){
		return "King Cobra";
	}
}