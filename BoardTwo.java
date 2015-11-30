package mancala;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardTwo extends JFrame implements Board  {
	private JPanel board;
	private JPanel Apits;
	private JPanel Bpits;
	private JPanel pitA; //player A mancala store
	private JPanel pitB;//player B mancala store
	
	private JPanel displayPanel;
	
	private JButton newGameBut;
	
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 300;

	public BoardTwo() {
		this.setTitle("Mancala");
		board = new JPanel(new BorderLayout());
		board.setBackground(Color.GREEN);
		initializeBoard();
	}
	
	public void initializeBoard() {
		initializeMainPitB();
		initializeMainPitA();
		initializeAPits();
		initializeBPits();
		initializeCenterBoard();
		
		this.getContentPane().add(board);
		this.setLocation(600,200);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
	public void initializeAPits() {
		Apits = new JPanel(new GridLayout(1, 4));
		Apits.setBackground(Color.GREEN);
		for(int i = 0; i < 6; i++) {
			StandardPit stPit = new StandardPit();
			Apits.add(new JLabel(stPit));
		}
		board.add(Apits, BorderLayout.SOUTH);
	}
	public void initializeBPits() {
		Bpits = new JPanel(new GridLayout(1, 4));
		Bpits.setBackground(Color.GREEN);
		for(int i = 0; i < 6; i++) {
			StandardPit stPit = new StandardPit();
			Bpits.add(new JLabel(stPit));
		}
		board.add(Bpits, BorderLayout.NORTH);
	}
	public void initializeMainPitA() {
		pitA = new JPanel();
		pitA.setBackground(Color.GREEN);
		BigPit bPit = new BigPit();
		pitA.add(new JLabel(bPit));
		board.add(pitA, BorderLayout.WEST);
		
	}
	public void initializeMainPitB() {
		pitB = new JPanel();
		pitB.setBackground(Color.GREEN);
		BigPit bPit = new BigPit();
		pitB.add(new JLabel(bPit));
		board.add(pitB, BorderLayout.EAST);
	}
	public void initializeCenterBoard() {
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.GREEN);
		newGameBut = new JButton("New Game");
		newGameBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StartMenu s = new StartMenu();
				closeGameFrame();
			}
		});
		displayPanel.add(newGameBut);
		board.add(displayPanel, BorderLayout.CENTER);
	}
	public void closeGameFrame() {
		this.dispose();
	}
}
