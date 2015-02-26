//Filename: CellGrid.java
//Author: Andrew Spano
//Description: Class representing the grid of cells for the game of life project
package gameoflife;

import java.io.ObjectInputStream.GetField;

public class CellGrid {
	private Cell[][] grid; // grid representing rows and columns of cells
	private int rowLength;
	private int colLength;

	public CellGrid() {
		setGrid(new Cell[25][25]); // for this project, grid will be 25x25

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = new Cell();
				System.out.println(grid[i][j]);
			}
			setRowLength(grid.length);
			setColLength(grid[0].length);
		}
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

	public int[] getIndexOfCell(Cell cell) {
		/*
		 * arrays by default can not return the index of an element which is
		 * necessary in this program we *do* want this to be an equal by
		 * reference check, because we want to know the exact cell, not its
		 * value
		 */
		int index[] = new int[2];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == cell) {
					index[0] = i;
					index[1] = j;
					return index;
				}
			}
		}

		return index;

		// TODO: Need to add test case for if the element is not in the grid,
		// which should actually never happen

	}

	public Cell []getNeighbors(Cell cell) {
		/*
		 * Returns a one dimensional array containing all eight cells neighboring the given cell
		 * Taking into account that cells on the border are neighboring cells on the opposite border
		 */
		Cell[] neighbors = new Cell[8];
		int cellIndex[] = getIndexOfCell(cell);
		neighbors[0] = getCellAt(cellIndex[0] + 1, cellIndex[1]);
		neighbors[1] = getCellAt(cellIndex[0] - 1, cellIndex[1]);
		neighbors[2] = getCellAt(cellIndex[0], cellIndex[1] + 1);
		neighbors[3] = getCellAt(cellIndex[0], cellIndex[1] - 1);
		neighbors[4] = getCellAt(cellIndex[0]+1, cellIndex[1] + 1);
		neighbors[5] = getCellAt(cellIndex[0]-1, cellIndex[1] -1);
		neighbors[6] = getCellAt(cellIndex[0]+1, cellIndex[1] - 1);
		neighbors[7] = getCellAt(cellIndex[0] -1 , cellIndex[1] + 1);





		return neighbors;
	}

	public int getNumberOfNeighborsAlive(Cell cell) {
		Cell[] neighbors = getNeighbors(cell);
		int aliveCount = 0;
		for (Cell c : neighbors) {
			if (c.isAlive()) {
				aliveCount++;
			}
		}
		return aliveCount;
	}

	public Cell getCellAt(int rowIndex, int columnIndex) {
		/*
		 * get the cell in the grid at the specified row and column Also tests
		 * whether the cell is on the border
		 */
		if (rowIndex >= grid.length) {
			rowIndex = 0;
		} else if (rowIndex < 0) {
			rowIndex = grid.length - 1;
		}
		if (columnIndex >= grid[0].length) {
			columnIndex = 0;
		}

		else if (columnIndex < 0) {
			columnIndex = grid[0].length - 1;
		}

		return grid[rowIndex][columnIndex];
	}

	public void calculateGeneration() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				Cell cell = getCellAt(i, j);
				int numberOfNeighborsAlive = getNumberOfNeighborsAlive(cell);
				
				if (cell.isAlive() && (numberOfNeighborsAlive != 2 && numberOfNeighborsAlive != 3)) {
					System.out.println(numberOfNeighborsAlive);
					cell.kill();
				}
				
				else if(!cell.isAlive() && getNumberOfNeighborsAlive(cell) == 3) {
					cell.revive();
				}
			
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * FOR TESTING PURPOSES ONLY
		 */
		// test getindex method
		CellGrid grid = new CellGrid();
		Cell cell = grid.getCellAt(0, 0);
		System.out.println(grid.getIndexOfCell(cell)[0] + ", "
				+ grid.getIndexOfCell(cell)[1]);
		cell = grid.getCellAt(21, 3);
		System.out.println("(21, 3) " + grid.getIndexOfCell(cell)[0] + ", "
				+ grid.getIndexOfCell(cell)[1]);

		//
		// tests for getNeighbors method
		for (int i = 0; i < grid.getNeighbors(cell).length; i++) {
			System.out.println(grid.getNeighbors(cell)[i]);

		}
		// tests for getNumbersOfNeighborsAlive method
		System.out.println("Number of neighbors alive: "
				+ grid.getNumberOfNeighborsAlive(cell));
		//testing neighbors
		Cell test = grid.getCellAt(0,0);
		for(Cell c: grid.getNeighbors(test)) {
			System.out.println("[" + grid.getIndexOfCell(c)[0] + " , " + grid.getIndexOfCell(c)[1] + "]: " + c);
		}

		
		//
	}

	public int getRowLength() {
		return rowLength;
	}

	public int getColLength() {
		return colLength;
	}

}
