package mancala;

import javax.swing.*;
import java.awt.*;

public class BoardOne extends JFrame implements Board  {
	private JPanel board;
	private JPanel pits;
	private JPanel pitA; //player A mancala store
	private JPanel pitB;
	private JPanel pit;
	private JLabel mancalaLabel;
	private static final int WINDOW_HEIGHT = 500;
	private static final int WINDOW_WIDTH = 500;
	
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
		
		this.setBounds(10, 10, WINDOW_WIDTH, WINDOW_HEIGHT);
		//setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
		this.setLocation(400,200);
		
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
		board.add(mancalaLabel, BorderLayout.NORTH);
		board.add(pits, BorderLayout.CENTER);
		board.add(pitA, BorderLayout.WEST);
		board.add(pitB, BorderLayout.EAST);
		
		this.getContentPane().add(board);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}
}
