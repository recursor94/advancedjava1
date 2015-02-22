package gameoflife;

public class CellGrid {
	Cell[][] grid; //grid representing rows and columns of cells
	
	public CellGrid() {
		grid = new Cell[25][25];  //for this project, grid will be 25x25
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				grid[i][j] = new Cell();
			}
		}
	}

}
