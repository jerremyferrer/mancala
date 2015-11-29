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

	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 300;

	public BoardOne() {
		initializeBoard();
	}
	
	public void initializeBoard() {
		
	}
	/*
	@Override
	public void initializeBoard() {
		// TODO Auto-generated method stub
		//layouts
		board = new JPanel();
		//pits  = new JPanel();
		pitA = new JPanel();
		pitB = new JPanel();
		//pit = new JPanel();
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		p9 = new JPanel();
		p10 = new JPanel();
		p11 = new JPanel();
		p12 = new JPanel();
		
		
		board.setLocation(100, 100);
		this.setBackground(Color.red); 
		/*
		//board.setOpaque(true);
		pits.setLayout(new GridLayout(2, 6));
		pits.setBounds(200, 100, 400, 300);
		pits.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
	
		board.add(pitA, BorderLayout.EAST);
		board.add(pits, BorderLayout.CENTER);
		board.add(pitB, BorderLayout.WEST);
		
		
		
		
		/* need to redo
		pitA.setBounds(100, 200, 99, 100);
		pitB.setBounds(700, 200, 99, 100);
		
		pit.setBackground(Color.green);
		pitA.setBackground(Color.red);
		pitB.setBackground(Color.YELLOW);
		
		pits.setLayout(new GridLayout(2, 2, 1, 1));
		pits.add(pit);
		pits.add(pit); 
		pits.add(pit);
		pits.add(pit);
		pits.add(pit);
		
		this.getContentPane().setLayout(new BorderLayout());
		//board.add(mancalaLabel, BorderLayout.NORTH);
		board.add(pits, BorderLayout.CENTER);
		board.add(pitA, BorderLayout.WEST);
		board.add(pitB, BorderLayout.EAST);
		
		
		this.add(board);
		//this.getContentPane().add(board);
		this.setLocation(600,200);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.pack();
		this.setVisible(true);
		
	}
	*/

	public void initializeAPits() {
			
	}
	public void initializeBPits() {
		
	}
	public void initializeMainPitA() {
		
	}
	public void initializeMainPitB() {
		
	}
}
