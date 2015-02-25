package gameoflife;


public class Cell {
	private boolean isAlive; //calculates whether cell is alive
	
	public Cell() {
		isAlive = false;
	}

	public boolean isAlive() {
		return isAlive;
	}
	
	public void kill() {
		isAlive = false;
	}
	
	public void revive() {
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
