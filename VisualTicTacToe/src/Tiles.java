import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Tiles {
	public Button[][] buttons;
	public Boolean computerTurn;
	
	
	public Tiles(){
		this.buttons = new Button[3][3];
		this.computerTurn = false;
		
		int count = 1;
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				buttons[i][j] = new Button(this, count);
				count++;
			}
		}
		
	}
	
	public void showButtons(JPanel container){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				container.add(buttons[i][j].getButton());
			}
		}
	}
	
	private void computerPlay(){
		Random rand = new Random();
		boolean occupied = true;
		
		int x = 0, y = 0;
		
		while(occupied){
			x = rand.nextInt(3);
			y = rand.nextInt(3);
			
			if(buttons[x][y].getButton().getText() == ""){
				occupied = false;
			}
		}
		
		buttons[x][y].getButton().setText("O");

		computerTurn = false;
	}
	
	public void play(int x, int y) throws OccupiedSpaceException{
		if(!win() && !full()){

			if(!computerTurn){
				
				if (buttons[x][y].getButton().getText() == "O" ||
						buttons[x][y].getButton().getText() == "X"){
					throw new OccupiedSpaceException("Space was occupied");
				}
				else{
					computerTurn = true;
					buttons[x][y].getButton().setText("X");
					
					if(!win() && !full()) {
						computerPlay();
					}
				}
			}
		}
	}
	
	private boolean win(){
		//across
		for(int i = 0; i < 3; i++){
			if(buttons[i][0].getButton().getText() == buttons[i][1].getButton().getText() && 
					buttons[i][1].getButton().getText() == buttons[i][2].getButton().getText() && 
					buttons[i][0].getButton().getText() == buttons[i][2].getButton().getText() && 
					buttons[i][0].getButton().getText() != ""){
				return true;
			}
			if(buttons[0][i].getButton().getText() == buttons[1][i].getButton().getText() && 
					buttons[1][i].getButton().getText() == buttons[2][i].getButton().getText() && 
					buttons[0][i].getButton().getText() == buttons[2][i].getButton().getText() && 
					buttons[0][i].getButton().getText() != ""){
				return true;
			}
		}
		
		if(buttons[0][0].getButton().getText() == buttons[1][1].getButton().getText() && 
				buttons[1][1].getButton().getText() == buttons[2][2].getButton().getText()
				&& buttons[0][0].getButton().getText() == buttons[2][2].getButton().getText() && 
				buttons[0][0].getButton().getText() != ""){
			return true;
		}
		
		if(buttons[0][2].getButton().getText() == buttons[1][1].getButton().getText() && 
				buttons[1][1].getButton().getText() == buttons[2][0].getButton().getText() && 
				buttons[0][2].getButton().getText() == buttons[2][0].getButton().getText() && 
				buttons[2][0].getButton().getText() != ""){
			return true;
		}
		
		return false;
	}
	
	private boolean full(){
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(buttons[i][j].getButton().getText() == ""){
					return false;
				}
			}
		}
		return true;
	}
	
}
