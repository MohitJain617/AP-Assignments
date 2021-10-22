public class SnakeFloor extends Floor{
	
	public SnakeFloor(int loc){
		super(-2,-4,loc);
	}
	@Override
	public String toString(){
		return "Normal Snake Floor";
	}
}

class KingCobra extends Floor{

	public KingCobra(int loc){
		super(-4,-8,loc);
	}
	@Override
	public String toString(){
		return "King Cobra";
	}
}