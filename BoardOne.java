package mancala;

import javax.swing.*;
import java.awt.*;

public class BoardOne extends JFrame implements Board  {
	private JPanel board;
	private JPanel pits;
	private JPanel pitA; //player A mancala store
	private JPanel pitB;//player B mancala store
	private JPanel pit;
	
	//private JLabel mancalaLabel;
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 500;

	
	public BoardOne() {
		initializeBoard();
	}
	
	
	@Override
	public void initializeBoard() {
		// TODO Auto-generated method stub
		//layouts
		board = new JPanel();
		pits  = new JPanel();
		pitA = new JPanel();
		pitB = new JPanel();
		pit = new JPanel();
		//mancalaLabel = new JLabel("MANCALA");
		
		//this.setBounds(600, 200, WINDOW_WIDTH, WINDOW_HEIGHT);
		
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
		
		board.setLayout(new BorderLayout());
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
}
