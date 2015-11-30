package mancala;

import javax.swing.*;
import java.awt.*;

public class BoardOne extends JFrame implements Board  {
	private JPanel board;
	private JPanel Apits;
	private JPanel Bpits;
	private JPanel pitA; //player A mancala store
	private JPanel pitB;//player B mancala store
	//private JPanel pit;
	private JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12;
	
	//StandardPit stPit;

	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 300;

	public BoardOne() {
		board = new JPanel(new BorderLayout());
		initializeBoard();
		
		
	}
	
	public void initializeBoard() {
		initializeMainPitB();
		initializeMainPitA();
		initializeAPits();
		initializeBPits();
		
		this.getContentPane().add(board);
		this.setLocation(600,200);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
	public void initializeAPits() {
		Apits = new JPanel(new GridLayout(1, 4));
		for(int i = 0; i < 6; i++) {
			StandardPit stPit = new StandardPit();
			Apits.add(new JLabel(stPit));
		}
		board.add(Apits, BorderLayout.SOUTH);
	}
	public void initializeBPits() {
		Bpits = new JPanel(new GridLayout(1, 4));
		for(int i = 0; i < 6; i++) {
			StandardPit stPit = new StandardPit();
			Bpits.add(new JLabel(stPit));
		}
		board.add(Bpits, BorderLayout.NORTH);
	}
	public void initializeMainPitA() {
		pitA = new JPanel();
		BigPit bPit = new BigPit();
		pitA.add(new JLabel(bPit));
		board.add(pitA, BorderLayout.WEST);
		
	}
	public void initializeMainPitB() {
		pitB = new JPanel();
		BigPit bPit = new BigPit();
		pitB.add(new JLabel(bPit));
		board.add(pitB, BorderLayout.EAST);
	}
}
