package mancala;

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
	private JButton okButton;
	
	MancalaModel model;
	
	
	public StartMenu() {
		welcome = new JLabel("Play Mancala!");
		pickNumber = new JLabel("Select number of beads");
		button1 = new JButton("3");
		button2 = new JButton("4");
		pickBoard = new JLabel("Choose a board theme");
		board1 = new JButton("A");
		board2 = new JButton("B");
		mainPanel = new JPanel();
		okButton = new JButton("OK!");
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(welcome);
		mainPanel.add(pickNumber);
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(pickBoard);
		mainPanel.add(board1);
		mainPanel.add(board2);
		//mainPanel.add(okButton);
		this.add(mainPanel);
		
		this.setLocation(600, 200);
		this.setSize(150, 230);
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
				// TODO generate BoardOne and close this frame
				// BoardOne b = new BoardOne();
				BoardOne b = new BoardOne();
				closeMenu();
			}
		});
		
		board2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO generate BoardTwo and close this frame
				// BoardTwo b = new BoardTwo();
				closeMenu();
				
			}
		});
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO NOT SURE IF WE NEED THIS. maybe we should launch the 
				// 		board when user chooses board A or B
				
			}
		});
		
		
	}
	private void closeMenu() {
		this.dispose();
	}
}
