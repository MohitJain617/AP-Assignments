public class SnakeFloor extends Floor{
	
	public SnakeFloor(int loc){
		super(loc);
	}
	@Override
	public int getPoints(){
		return super.getPoints()-3;
	}
	@Override
	public int getOffset(){
		return super.getOffset()-4;
	}
	@Override
	public String toString(){
		return "Normal Snake Floor";
	}
}
