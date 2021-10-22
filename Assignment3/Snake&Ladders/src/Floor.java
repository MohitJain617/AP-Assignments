public class Floor {
	private int points;
	private int offset;
	private int location;

	public Floor(int loc){
		points = 1;
		offset = 0;
		this.location = loc;
	}
	public Floor(int points, int offset, int loc){
		this.points = points;
		this.offset = offset;
		this.location = loc;
	}
	public int getPoints(){
		return this.points;
	}
	public int getOffset(){
		return this.offset;
	}
	@Override
	public String toString(){
		return "an Empty Floor";
	}
}
