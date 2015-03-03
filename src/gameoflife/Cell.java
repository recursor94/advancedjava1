//Filename: Cell.java
//Author: Andrew Spano
//Description: Contains the alive state of an individual cell
package gameoflife;


public class Cell {
	private boolean isAlive; //calculates whether cell is alive
	private int row;
	private int col;
	
	public Cell(int row, int col) {
		isAlive = false;
		this.row = row;
		this.col = col;
	}

	public boolean isAlive() {
		return isAlive;
	}
	
	public void kill() {
		//kills the cell, better than set alive because of increased clarity
		isAlive = false;
	}
	
	public void revive() {
		//revives the cell, better than set alive because of increased clarity

		isAlive = true;
	}
	public int [] getIndex() {
		int []index = {row, col};
		return index;
	}
	
	@Override
	public String toString() {
		if(isAlive) {
			return "Is alive";
		}
		else {
			return "Is dead";
		}
	}
	
	
	
	
}
