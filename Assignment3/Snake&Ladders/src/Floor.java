public class Floor {
	private int location;  //every floor knows it location

	public Floor(int loc){
		this.location = loc;
	}
	public int getPoints(){
		return 1;
	}
	public int getOffset(){
		return 0;
	}
	public int getLocation(){
		return this.location;
	}
	@Override
	public String toString(){
		return "an Empty Floor";
	}
}
