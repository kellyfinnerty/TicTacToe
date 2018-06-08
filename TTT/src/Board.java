
public class Board {
	
	private char [][] board;
	private int size = 3;
	private char winner = ' ';
	
	public Board(){
		this.board = new char[size][size];
		initBoard();
	}
	
	private void initBoard(){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				board[i][j] = (char)32;
			}
		}
	}
	
	public void play(char player, int x, int y) throws OccupiedSpaceException{
		if(x > size-1 || y > size-1 || x < 0 || y < 0){
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
		for(int i = 0; i < size; i++){
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] == board[i][2] && board[i][0] != ' '){
				this.winner = board[i][0];
				return true;
			}
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] == board[2][i] && board[0][i] != ' '){
				this.winner = board[0][i];
				return true;
			}
		}
		
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == board[2][2] && board[0][0] != ' '){
			this.winner = board[0][0];
			return true;
		}
		
		if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == board[2][0] && board[2][0] != ' '){
			this.winner = board[0][2];
			return true;
		}
		
		return false;
	}
	
	public char winner(){
		return winner;
	}
	
	public boolean full(){
		boolean full = false;
		int total = 0;
		int max = size * size;
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(board[i][j] != ' '){
					total++;
				}
			}
		}
		
		if(max == total){
			return true;
		}
		
		return full;
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
