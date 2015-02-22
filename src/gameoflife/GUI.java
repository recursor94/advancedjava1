package gameoflife;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI extends JFrame {
	private CellGrid cellGrid;
	
	public GUI() {
		cellGrid = new CellGrid();
		setLayout(new GridLayout(25,25));
		//display grid of cells in grid form, representing each cell as a button in the gui
		for(int i = 0; i< cellGrid.getGrid().length; i++) {
			for(int j = 0; j < cellGrid.getGrid()[0].length; j++) {
				
				if(cellGrid.getGrid()[i][j].isAlive()) {  /*in the current setup, this check will always return false, 
														**But, it makes sense, and if another programmer ever decides to set cells to be alive by default, this will work as expected*/
					add(new JButton("0"));
				}
				
				else{
					add(new JButton(""));   
				}
			}
		}
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		GUI frame = new GUI();
	}

}
