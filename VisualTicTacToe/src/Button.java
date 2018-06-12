import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Button extends JPanel {
	private JButton button;
	private Tiles tiles;
	private int label;
	
	public Button(Tiles tiles, int count){
		this.button = new JButton();
		this.tiles = tiles;
		this.label = count;
		
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX(count);
				int y = getY(count);
				
				try {
					tiles.play(x, y);
				} catch (OccupiedSpaceException e1) { }
			}
		};
		
		this.button.addActionListener(action);
	}
	
	public JButton getButton(){
		return button;
	}
	
	private int getX(int input){
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

	private int getY(int input){
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
	
}
