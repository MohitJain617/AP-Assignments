public class Floor {
	private int points;
	private int offset;
	private int location;  //every floor knows it location

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
	public int getLocation(){
		return this.location;
	}
	@Override
	public String toString(){
		return "an Empty Floor";
	}
}
