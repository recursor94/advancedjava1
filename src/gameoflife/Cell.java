//Filename: Cell.java
//Author: Andrew Spano
//Description: Contains the alive state of an individual cell
package gameoflife;

import java.io.Serializable;


public class Cell implements Serializable{
	private boolean isAlive; //calculates whether cell is alive
	
	public Cell() {
		isAlive = false;
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
