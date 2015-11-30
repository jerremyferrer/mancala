/**
 * StartMenu GUI
 */
package mancala;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu extends JFrame{
	private JButton button1;
	private JButton button2;
	private JLabel pickNumber;
	private JLabel pickBoard;
	private JLabel welcome;
	private JButton board1;
	private JButton board2;
	private JPanel mainPanel;
	private JButton quit;
	
	MancalaModel model;
	
	
	public StartMenu() {
		welcome = new JLabel("Play Mancala!");
		pickNumber = new JLabel("Select number of beads");
		button1 = new JButton("3");
		button2 = new JButton("4");
		pickBoard = new JLabel("Choose a board theme");
		board1 = new JButton("RED");
		board2 = new JButton("GREEN");
		mainPanel = new JPanel();
		quit = new JButton("QUIT");
		
		mainPanel.add(welcome);
		mainPanel.add(pickNumber);
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(pickBoard);
		mainPanel.add(board1);
		mainPanel.add(board2);
		mainPanel.add(quit);
		this.add(mainPanel);
		
		mainPanel.setOpaque(true);
		mainPanel.setBackground(Color.GREEN);
		this.setLocation(600, 200);
		this.setSize(150, 260);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO set number of beads to 3
				model.setInitialBeadAmount(3);
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO set number of beads to 4
				model.setInitialBeadAmount(4);
				
			}
		});
		
		board1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO call BoardOne and close this frame
				BoardOne b = new BoardOne();
				closeMenu();
			}
		});
		
		board2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO call BoardTwo and close this frame
			    BoardTwo b = new BoardTwo();
				closeMenu();
			}
		});
		
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeMenu();
				
			}
		});
	}
	private void closeMenu() {
		this.dispose();
	}
}
