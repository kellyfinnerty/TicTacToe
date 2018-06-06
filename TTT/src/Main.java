
public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		ComputerPlayer computer = new ComputerPlayer('x', board);
		
		while(!board.win()){
			computer.play();
		}
		
		board.print();
		
		
	}

}
