package gameoflife;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class GUI extends JFrame {
	private CellGrid cellGrid;
	
	public GUI() {
		cellGrid = new CellGrid();
		setLayout(new GridLayout(25,25));
	}

}
