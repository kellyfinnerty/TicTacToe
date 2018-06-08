import java.util.Scanner;

public class CommandLineGame {
	
	public static void printNumericalBoard(){
		int count = 1;
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(count);
				count++;
				
				if(j != 2){
					System.out.print(" | ");
				}
			}
			System.out.println();
		}
	}
	
	public static void introduction(){
		System.out.println("Welcome to Tic Tac Toe! \n");
		System.out.println("You'll playing against the computer.");
		System.out.println("You will be the 'x's and the computer will be 'o's.\n");
		System.out.println("When you want to place an 'x' in a space enter the number of the space you've chosen.");
		System.out.println("The board is represented as follows: ");
		printNumericalBoard();
		System.out.println("\nGood luck!");
	}
	
	public static int getX(int input){
		if(input > 9 || input < 1){
			return input;
		}
		
		if(input / 4 == 0){
			return 0;
		}
		else if(input / 4 == 1 && input != 7){
			return 1;
		}
		else{
			return 2;
		}
	}

	public static int getY(int input){
		if(input > 9 || input < 1){
			return input;
		}
		
		if(input % 3 == 1){
			return 0;
		}
		else if(input % 3 == 2){
			return 1;
		}
		else{
			return 2;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		introduction();
		
		Board board = new Board();
		ComputerPlayer computer = new ComputerPlayer('o', board);
		
		board.print();
		
		while(!board.win() && !board.full()){
			System.out.println("\nWhere do you want to place your x? ");
			
			while(!in.hasNextInt()){
				System.out.println("Try again!");
				in.next();
			}
			
			int input = in.nextInt();
			
			try {
				board.play('x', getX(input), getY(input));
				board.print();
				
				try {
					Thread.sleep(2000);	// thread to sleep for 1000 milliseconds
				} catch (Exception e) {	}
				
				System.out.println("****************");
				
				if(board.win() || board.full()){
					break;
				}
				
				computer.play();
				board.print();
			} 
			catch (OccupiedSpaceException e) {
				System.out.println("You chose an occupied space!\n");
			} 
			catch (IndexOutOfBoundsException i){
				System.out.println("Invalid number!\n");
			}
			
			try {
				Thread.sleep(1000);	// thread to sleep for 1000 milliseconds
			} catch (Exception e) {	}
			
		}
		
		if(board.full()){
			System.out.println("You are perfect competitors!");
		}
		else{
			char winner = board.winner();

			if(winner == 'x'){
				System.out.println("~~ Congratulations, winner! ~~");
			}
			else{
				System.out.println("Better luck next time!");
			}
		}
		
		in.close();

	}

}
