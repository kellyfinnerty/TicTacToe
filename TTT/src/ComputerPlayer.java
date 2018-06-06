import java.util.Random;

public class ComputerPlayer {
	private char xo;
	Random rand;
	Board board;
	
	public ComputerPlayer(char character, Board board){
		this.xo = character;
		this.rand = new Random();
		this.board = board;
	}
	
	public void play(){
		int x = rand.nextInt(3);
		int y = rand.nextInt(3);
		
		boolean tf = true;
		
		while(tf){
			try {
				tf = false;
				board.play(xo, x, y);
				break;
			} catch (OccupiedSpaceException e) {
				tf = true;
				e.printStackTrace();
			}
		}
		
	}
}
