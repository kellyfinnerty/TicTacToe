
public class Board {
	
	private char [][] board;
	
	public Board(){
		this.board = new char[3][3];
		initBoard();
	}
	
	private void initBoard(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = (char)32;
			}
		}
	}
	
	public void play(char player, int x, int y) throws OccupiedSpaceException{
		if(x > 2 || y > 2 || x < 0 || y < 0){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		else if (board[x][y] != ' '){
			throw new OccupiedSpaceException("Space was occupied");
		}
		else{
			board[x][y] = player;
		}
	}
	
	public boolean win(){
		//across
		for(int i = 0; i < 3; i++){
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' '){
				System.out.println("across");
				return true;
			}
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][1] != ' '){
				System.out.println("down");
				return true;
			}
		}
		
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' '){
			System.out.println("1 diag");
			return true;
		}
		
		if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] != ' '){
			System.out.println("2 diag");
			return true;
		}
		
		return false;
	}
	
	public void print(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(board[i][j]);
				
				if(j != 2){
					System.out.print(" | ");
				}
			}
			System.out.println();
		}
	}


}
