package mancala;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardOne extends JFrame implements Board  {
	protected JPanel board;
	protected JPanel Apits;
	protected JPanel Bpits;
	protected JPanel pitA; //player A mancala store
	protected JPanel pitB;//player B mancala store
	protected JPanel displayPanel;
	
	private JButton newGameBut;
	
	private JLabel fillerSpace = new JLabel(" ");
	private JLabel fillerSpace2 = new JLabel(" ");
	private JLabel fillerSpace3 = new JLabel(" ");
	private JLabel fillerSpace4 = new JLabel(" ");
	private JLabel Alabel;
	private JLabel Blabel;
	
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 300;

	public BoardOne() {
		this.setTitle("Mancala");
		board = new JPanel(new BorderLayout());
		board.setBackground(Color.RED);
		initializeBoard();
	}
	
	public void initializeBoard() {
		initializeMainPitB();
		initializeMainPitA();
		initializeAPits();
		initializeBPits();
		initializeCenterBoard();
		setColor();
		
		this.setResizable(false);
		this.getContentPane().add(board);
		this.setLocation(600,200);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
	public void initializeAPits() {
		Apits = new JPanel(new GridLayout());
		//Apits.setBackground(Color.RED);
		Apits.add(fillerSpace3);
		for(int i = 0; i < 6; i++) {
			StandardPit stPit = new StandardPit();
			Apits.add(new JLabel(stPit));
		}
		Apits.add(fillerSpace4);
		board.add(Apits, BorderLayout.SOUTH);
	}
	public void initializeBPits() {
		Bpits = new JPanel(new GridLayout());
		//Bpits.setBackground(Color.RED);
		Bpits.add(fillerSpace);
		for(int i = 0; i < 6; i++) {
			StandardPit stPit = new StandardPit();
			Bpits.add(new JLabel(stPit));
		}
		Bpits.add(fillerSpace2);
		board.add(Bpits, BorderLayout.NORTH);
	}
	public void initializeMainPitA() {
		pitA = new JPanel();
		//pitA.setBackground(Color.RED);
		Alabel = new JLabel("A");
		BigPit bPit = new BigPit();
		pitA.add(Alabel);
		pitA.add(new JLabel(bPit));
		board.add(pitA, BorderLayout.EAST);
		
	}
	public void initializeMainPitB() {
		pitB = new JPanel();
		//pitB.setBackground(Color.RED);
		Blabel = new JLabel("B");
		BigPit bPit = new BigPit();
		pitB.add(new JLabel(bPit));
		pitB.add(Blabel);
		board.add(pitB, BorderLayout.WEST);
	}
	public void initializeCenterBoard() {
		displayPanel = new JPanel();
		//displayPanel.setBackground(Color.RED);
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
	public void setColor() {
		displayPanel.setBackground(Color.RED);
		pitB.setBackground(Color.RED);
		pitA.setBackground(Color.RED);
		Apits.setBackground(Color.RED);
		Bpits.setBackground(Color.RED);
	}
}
