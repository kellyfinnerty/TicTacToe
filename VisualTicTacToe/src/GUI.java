import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	private JFrame frame;
	private JPanel container;
	private Tiles board;
	
	public GUI(){
		configureFrame();
		configureContainer();
		
		this.board = new Tiles();
		this.board.showButtons(container);
		
		frame.setVisible(true);	
	}
	
	private void configureFrame(){
		this.frame = new JFrame("Tic-Tac-Toe");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(500, 500);
	}
	
	private void configureContainer(){
		this.container = new JPanel();
		this.frame.add(container);
		this.container.setLayout(new GridLayout(3, 3));
	}
	
}
