
public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		ComputerPlayer computerX = new ComputerPlayer('x', board);
		ComputerPlayer computerO = new ComputerPlayer('o', board);
		
		while(!board.win() && !board.full()){
			computerX.play();
			board.print();
			System.out.println("****************");
			
			if(board.win() || board.full()){
				break;
			}
			
			computerO.play();
			board.print();
			System.out.println("****************");
			
		}
		
		board.print();
		
	}

}
