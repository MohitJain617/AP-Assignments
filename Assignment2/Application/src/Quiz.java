public class Quiz implements Assessment {
	private boolean close = false;
	
	@Override
	public void view();
	@Override
	public void grade();
	@Override
	public void close();
}
