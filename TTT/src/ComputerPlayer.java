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
		
		boolean tf = true;
		
		while(tf){
			try {
				tf = false;
				
				int x = rand.nextInt(3);
				int y = rand.nextInt(3);
				
				board.play(xo, x, y);
			} catch (OccupiedSpaceException e) {
				tf = true;
				// e.printStackTrace(); // print the error
			}
		}
		
	}
}
