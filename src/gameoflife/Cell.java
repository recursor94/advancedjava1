package gameoflife;


public class Cell {
	private boolean isAlive; //calculates whether cell is alive
	
	public Cell() {
		setAlive(false);
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
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
