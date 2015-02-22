package gameoflife;

import java.util.ArrayList;

public class Cell {
	Cell[] neighbors; //array representing eight neighboring cells
	boolean isAlive; //calculates whether cell is alive
	
	public Cell() {
		neighbors = new Cell[8];
		isAlive = false;
	}
	
	
}
