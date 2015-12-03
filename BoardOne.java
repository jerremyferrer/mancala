import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Creates a board, BoardOne theme
 * @author Sydney Snyder
 *
 */
public class BoardOne extends JFrame implements Board  
{
	private JPanel board;
	private JPanel Apits;
	private JPanel Bpits;
	private JPanel pitA; //player A mancala store
	private JPanel pitB;//player B mancala store
	private JPanel displayPanel;
	
	private JButton newGameBut;
	
	private JLabel fillerSpace = new JLabel(" ");
	private JLabel fillerSpace2 = new JLabel(" ");
	private JLabel fillerSpace3 = new JLabel(" ");
	private JLabel fillerSpace4 = new JLabel(" ");
	private JLabel Alabel;
	private JLabel Blabel;
	
	private Controller c;
	private int beadAmount;
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 300;
	/**
	 * Initiates BoardOne with a controller
	 * @param con - the controller for the board
	 */
	public BoardOne(Controller con) 
	{
		c = con;
		beadAmount = c.getBeadAmount();
		this.setTitle("Mancala");
		board = new JPanel(new BorderLayout());
		board.setBackground(Color.RED);
		initializeBoard();
	}
	/**
	 * Draws the Board
	 */
	public void initializeBoard() 
	{
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
	/**
	 * Creates and draws pits for Player A
	 */
	public void initializeAPits() 
	{
		Apits = new JPanel(new GridLayout());
		Apits.add(fillerSpace3);
		for(int i = 0; i < 6; i++) {
			StandardPit stPit = new StandardPit(c);
			stPit.addInitialBeads();
			Apits.add(new JLabel(stPit));
			c.addPitsA(stPit);
		}
		Apits.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(c.getCurrentPlayer() != c.getPlayerA())
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please only choose pits"
							+ " from your side of the board");
				}
				else
				{
					for(int i = 0; i < c.getPlayerAPits().size(); i++)
					{
						if(c.getPlayerAPits().get(i).contains(e.getLocationOnScreen()))
						{
							//move pits through cycle
							System.out.println("Registered click");
							c.switchTurns();
						}
					}
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		Apits.add(fillerSpace4);
		board.add(Apits, BorderLayout.SOUTH);
	}
	/**
	 * Creates and draws pits for Player B
	 */
	public void initializeBPits() 
	{
		Bpits = new JPanel(new GridLayout());
		//Bpits.setBackground(Color.RED);
		Bpits.add(fillerSpace);
		for(int i = 0; i < 6; i++) 
		{
			StandardPit stPit = new StandardPit(c);
			stPit.addInitialBeads();
			Bpits.add(new JLabel(stPit));
			c.addPitsB(stPit);
		}
		Bpits.add(fillerSpace2);
		Bpits.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(c.getCurrentPlayer() != c.getPlayerB())
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please only choose pits"
							+ " from your side of the board");
				}
				else
				{
					for(int i = 0; i < c.getPlayerBPits().size(); i++)
					{
						if(c.getPlayerBPits().get(i).contains(e.getLocationOnScreen()))
						{
							//move pits through cycle
							System.out.println("Registered click");
							c.switchTurns();
						}
					}
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		board.add(Bpits, BorderLayout.NORTH);
	}
	/**
	 * Creates and draws the main pit for Player A
	 */
	public void initializeMainPitA() 
	{
		pitA = new JPanel();
		Alabel = new JLabel("A");
		BigPit bPit = new BigPit();
		pitA.add(Alabel);
		pitA.add(new JLabel(bPit));
		c.addPitsA(bPit);
		board.add(pitA, BorderLayout.EAST);
	}
	/**
	 * Creates and draws the main pit for Player B
	 */
	public void initializeMainPitB() 
	{
		pitB = new JPanel();
		Blabel = new JLabel("B");
		BigPit bPit = new BigPit();
		pitB.add(new JLabel(bPit));
		pitB.add(Blabel);
		c.addPitsB(bPit);
		board.add(pitB, BorderLayout.WEST);
	}
	/**
	 * Creates and Initializes the Center of the Board
	 */
	public void initializeCenterBoard() 
	{
		displayPanel = new JPanel();
		newGameBut = new JButton("New Game");
		newGameBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				StartMenu s = new StartMenu();
				closeGameFrame();
			}
		});
		displayPanel.add(newGameBut);
		board.add(displayPanel, BorderLayout.CENTER);
	}
	/**
	 * Closes the Mancalla frame
	 */
	public void closeGameFrame() 
	{
		this.dispose();
	}
	/**
	 * Sets the color of the board
	 */
	public void setColor() 
	{
		displayPanel.setBackground(Color.RED);
		pitB.setBackground(Color.RED);
		pitA.setBackground(Color.RED);
		Apits.setBackground(Color.RED);
		Bpits.setBackground(Color.RED);
	}
}
