package gameoflife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	private CellGrid cellGrid;
	private JPanel controlPanel; //panel for controlling the game, such as starting and stopping the simulation
	private JPanel gridPanel; //panel for the cell grid, main contentpane should be border layout so it can accommodate both panels
	private JButton startButton;
	
	public GUI() {
		cellGrid = new CellGrid();
		gridPanel = new JPanel(new GridLayout(25,25));
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
				cellButton.setBackground(Color.YELLOW);
				gridPanel.add(cellButton);
				cellButton.addActionListener(new CellButtonListener(cellButton, cellGrid.getGrid()[i][j]));
			}
		}
		add(gridPanel, BorderLayout.NORTH);
		
		//code block for control panel
		startButton = new JButton("Start");
		startButton.addActionListener(new StartButtonListener());
		controlPanel = new JPanel(new FlowLayout());
		controlPanel.add(startButton);
		add(controlPanel, BorderLayout.SOUTH);
		
		//
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
	
	private class StartButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	public static void main(String[] args) {
		GUI frame = new GUI();
	}

}
