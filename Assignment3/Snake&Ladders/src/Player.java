public class Player {
	private String name;
	private int pos;

	public Player(String s){
		name = s;
		pos = -1;
	}
	public String getName(){
		return this.name;
	}
	public int getPos(){
		return this.pos;
	}
	public void updatePos(int offset){
		this.pos += offset;
	}
}
