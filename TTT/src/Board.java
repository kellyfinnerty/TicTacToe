
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
	
	public void play(int x, int y){
		if(x > 2 || y > 2 || x < 0 || y < 0){
			throw new IndexOutOfBoundsException("Index " + x + " is out of bounds!");
		}
	}


}
