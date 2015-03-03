//filename: Main.java
//Author: Andrew Spano
//Description: Keep initialization and instantiation of the program separate from any of the other classes,
//which are all performing a specific task

package gameoflife;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	CellGrid cellGrid;
	GUI gameFrame;
	
	public static void main(String[] args) {
		Main starter = new Main();
		starter.initGameWorld();
	}
	
	public void initGameWorld() {
		JLabel rowLabel = new JLabel("Number of Rows");
		JLabel columnLabel = new JLabel("Number of Columns");
		JTextField rowField = new JTextField(5);
		JTextField columnField = new JTextField(5);
		JPanel gridSizeChoicePanel = new JPanel();
		gridSizeChoicePanel.add(rowLabel);
		gridSizeChoicePanel.add(rowField);
		gridSizeChoicePanel.add(columnLabel);
		gridSizeChoicePanel.add(columnField);
		JOptionPane.showMessageDialog(null, gridSizeChoicePanel, "Enter The size of the game grid (rows x columns)", JOptionPane.QUESTION_MESSAGE);
		cellGrid = new CellGrid(Integer.parseInt(rowField.getText()), Integer.parseInt(columnField.getText()));
		gameFrame = new GUI(cellGrid);
	}
}