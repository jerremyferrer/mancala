import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Creates BoardTwo-styled Mancala board
 * @author Sydney Snyder, Jerremy Ferrer, & Royce Florence Rocco
 */

public class BoardTwo extends BoardOne  {

	public BoardTwo(Controller con) 
	{
		super(con);
	}

	/**
	 * Sets the color of the board
	 */
	@Override
	public void setColor() 
	{
		displayPanel.setBackground(Color.GREEN);
		pitB.setBackground(Color.GREEN);
		pitA.setBackground(Color.GREEN);
		Apits.setBackground(Color.GREEN);
		Bpits.setBackground(Color.GREEN);
	}

}
