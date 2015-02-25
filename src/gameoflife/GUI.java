//Filename:GUI.java
//Author:Andrew Spano
//Description: Contains code for the gui of the game of life program

package gameoflife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GUI extends JFrame {
	private CellGrid cellGrid;
	private JPanel controlPanel; //panel for controlling the game, such as starting and stopping the simulation
	private JPanel gridPanel; //panel for the cell grid, main contentpane should be border layout so it can accommodate both panels
	private JButton startButton;
	private boolean isRunning; //keeps track of whether simulation is or isn't running, and sets button behavior to begin or end it accordingly
	private Timer generationTimer; //Timer that controls delay between each generation
	private int generationDelay; //value controls the milliseconds between each successive generation
	private JButton[][] buttonGrid;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem saveItem;
	public GUI() {
		cellGrid = new CellGrid();
		gridPanel = new JPanel(new GridLayout(25,25));
		//display grid of cells in grid form, representing each cell as a button in the gui
		buttonGrid = new JButton[25][25];
		for(int i = 0; i< cellGrid.getGrid().length; i++) {
			for(int j = 0; j < cellGrid.getGrid()[0].length; j++) {
				JButton cellButton = null;
				if(cellGrid.getGrid()[i][j].isAlive()) {  /*in the current setup, this check will always return false, 
												**But, it makes sense, and if another programmer ever decides to set cells to be alive by default, this will work as expected*/
					 cellButton = new JButton(":)");
					
				}
				
				else{
					 cellButton = new JButton("  ");
					
				}
				cellButton.setBackground(Color.BLACK);
				cellButton.setForeground(Color.GREEN);
				gridPanel.add(cellButton);
				cellButton.addActionListener(new CellButtonListener(cellButton, cellGrid.getGrid()[i][j]));
				buttonGrid[i][j] = cellButton;
			}
		}
		add(gridPanel, BorderLayout.NORTH);
		
		//code block for control panel
		startButton = new JButton("Start");
		startButton.addActionListener(new StartButtonListener());
		controlPanel = new JPanel(new FlowLayout());
		controlPanel.add(startButton);
		controlPanel.setBackground(Color.WHITE);
		add(controlPanel, BorderLayout.SOUTH);
		
		//Now for menu bar
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		saveItem = new JMenuItem("Save");
		fileMenu.add(saveItem);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		//
		
		//
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Timer and generation initializations
		generationDelay = 1000;
		generationTimer = new Timer(generationDelay, new GenerationTimerListener());
		//
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
			if(cell.isAlive()) { //Uninitialize cell if cell is alive and user clicks on it during pre-game initialization
				cell.kill();
				cellButton.setText("  ");
			}
			else {
				cell.revive();
				cellButton.setText(":)"); //set cell to alive if the user clicks on it during pre-game initialization
				pack();
			}
			
		}
		
	}
	
	private class StartButtonListener implements ActionListener{

		private StartButtonListener() {
			isRunning = false;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!isRunning) {
				generationTimer.start();
				isRunning = true;
				startButton.setText("Stop");
			}
			else {
				generationTimer.stop();
				isRunning = false;
				startButton.setText("Start");
				
			}
			
		}
		
	}
	
	private class GenerationTimerListener implements ActionListener {
		private boolean isAnimationPulse; //boolean to test whether animation is at pulse.
		private GenerationTimerListener() {
			setAnimationPulse(false);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("A new generation has been started");
			cellGrid.calculateGeneration();
			for(int i = 0; i < cellGrid.getRowLength(); i++) {
				for(int j = 0; j < cellGrid.getColLength(); j++) {
					if(cellGrid.getCellAt(i, j).isAlive()) {
						System.out.println("Animation Step: " + isAnimationPulse);
						if(isAnimationPulse()) {
							buttonGrid[i][j].setText(":)");
							

						}
						else {
							buttonGrid[i][j].setText(";(");
						}

					}
					else {
						buttonGrid[i][j].setText("  ");

					}
				}
			}
			setAnimationPulse(!isAnimationPulse()); //opposite of whether on animation or not
		}
		public boolean isAnimationPulse() {
			return isAnimationPulse;
		}
		public void setAnimationPulse(boolean isAnimationPulse) {
			this.isAnimationPulse = isAnimationPulse;
		}
		
	}
	
	
	public static void main(String[] args) {
		GUI frame = new GUI();
	}

}
