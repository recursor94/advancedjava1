package gameoflife;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI extends JFrame {
	private CellGrid cellGrid;
	
	public GUI() {
		cellGrid = new CellGrid();
		setLayout(new GridLayout(25,25));
		//display grid of cells in grid form, representing each cell as a button in the gui
		for(int i = 0; i< cellGrid.getGrid().length; i++) {
			for(int j = 0; j < cellGrid.getGrid()[0].length; j++) {
				JButton cellButton = null;
				if(cellGrid.getGrid()[i][j].isAlive()) {  /*in the current setup, this check will always return false, 
												**But, it makes sense, and if another programmer ever decides to set cells to be alive by default, this will work as expected*/
					 cellButton = new JButton("0");
					
				}
				
				else{
					 cellButton = new JButton("-");
					
				}
				add(cellButton);
				cellButton.addActionListener(new CellButtonListener(cellButton, cellGrid.getGrid()[i][j]));
			}
		}
		pack();
		setVisible(true);
	}
	
	private class CellButtonListener implements ActionListener {
		private JButton cellButton;
		private Cell cell;
		private CellButtonListener(JButton cellButton, Cell cell) {
			this.cellButton = cellButton;
			this.cell = cell;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(cell.isAlive()) { //uninitialize cell if cell is alive and user clicks on it during pre-game initialization
				cell.setAlive(false);
				cellButton.setText("-");
			}
			else {
				cell.setAlive(true);
				cellButton.setText("0"); //set cell to alive if the user clicks on it during pre-game initialization
				pack();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		GUI frame = new GUI();
	}

}
