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
	
	public boolean cellisOnTopBorder(Cell cell) {
		/*Determines whether the cell is on the top border
		 * in which case it's neighbors must be the cells on the bottom border
		 */
		int[] cellIndex = getIndexOfCell(cell);
		if(cellIndex[0] -1 <0) {
			return true;
		}
		
		return false;
	}
	
	public boolean cellisOnBottomBorder(Cell cell) {
		/*Determines whether the cell is on the bottom border
		 * in which case it's neighbors must be the cells on the top border
		 */
		int[] cellIndex = getIndexOfCell(cell);
		if(cellIndex[0] +1 >= grid.length) {
			return true;
		}
		
		return false;
	}
	
	public boolean cellisOnLeftBorder(Cell cell) {
		/*Determines whether the cell is on the left border
		 * in which case it's neighbors must be the cells on the right border
		 */
		int[] cellIndex = getIndexOfCell(cell);
		if(cellIndex[1] -1 < 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean cellisOnRightBorder(Cell cell) {
		/*Determines whether the cell is on the top border
		 * in which case it's neighbors must be the cells on the left border
		 */
		int[] cellIndex = getIndexOfCell(cell);
		if(cellIndex[1] +1 >= grid[0].length) {
			return true;
		}
		
		return false;
	}
	
	public int [] getIndexOfCell(Cell cell) { 
		/* arrays by default can not return the index of an element
		 * which is necessary in this program
		 */
	
		int i =0, j = 0;
		while(grid[i][j] != cell) {
			i++;
			j++;
		}
		
		int index[] = new int[2];
		index[0] = i;
		index[1] = j;
		return index;
		
		//TODO: Need to add test case for if the element is not in the grid, which should actually never happen
		
	}
	
	public Cell []getNeighbors(Cell cell) {
		/*
		 * Returns a one dimensional array containing all eight cells neighboring the given cell
		 * Taking into account that cells on the border are neighboring cells on the opposite border
		 */
		int[] indexOfCell = getIndexOfCell(cell);
		Cell[] neighbors = new Cell[8];
		neighbors[0] = grid[indexOfCell[0] + 1][indexOfCell[1]];
		neighbors[1] = grid[indexOfCell[0] + 1][indexOfCell[1]];
		neighbors[2] = grid[indexOfCell[0] + 1][indexOfCell[1]];
		neighbors[3] = grid[indexOfCell[0] + 1][indexOfCell[1]];
		neighbors[4] = grid[indexOfCell[0] + 1][indexOfCell[1]];
		neighbors[5] = grid[indexOfCell[0] + 1][indexOfCell[1]];
		neighbors[6] = grid[indexOfCell[0] + 1][indexOfCell[1]];
		neighbors[7] = grid[indexOfCell[0] + 1][indexOfCell[1]];


		return neighbors;
	}
	
	 

}
