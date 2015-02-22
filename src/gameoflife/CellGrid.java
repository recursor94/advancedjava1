package gameoflife;

public class CellGrid {
	private Cell[][] grid; //grid representing rows and columns of cells
	
	public CellGrid() {
		setGrid(new Cell[25][25]);  //for this project, grid will be 25x25
		
		for(int i = 0; i < getGrid().length; i++) {
			for(int j = 0; j < getGrid()[0].length; j++) {
				getGrid()[i][j] = new Cell();
				System.out.println(getGrid()[i][j]);
			}
		}
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

}
