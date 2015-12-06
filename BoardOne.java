import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Creates a board, BoardOne theme
 * @author Sydney Snyder, Jerremy Ferrer, & Royce Florence Rocco
 * This code is now fully functional. We just need to modify it so it's more simplistic
 * if possible.
 */
public class BoardOne extends JFrame implements Board  
{
	private JPanel board;
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
	private int x, x2;
	private Controller c;
	private BigPit bigPitB;
	private BigPit bigPitA;
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 300;
	private int endGame;
	/**
	 * Initiates BoardOne with a controller
	 * @param con - the controller for the board
	 */
	public BoardOne(Controller con) 
	{
		x = WINDOW_WIDTH / 8;
		x2 = WINDOW_WIDTH / 8;
		c = con; //initalize controller so same as start menu controller
		endGame = c.getBeadAmount() * 12;
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
		initializeAPits();
		initializeMainPitA();
		initializeBPits();
		initializeMainPitB();
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
			c.addPitAll(stPit); // adds pit to allPits in model
			c.addPitA(stPit); // adds pit to playerApits in model
			Apits.add(new JLabel(c.findPit(stPit))); //finds pit in allPits (equivalent) for JLabel
			int j = 0;
			while(j < c.getBeadAmount()) // gets initial amount of beads I could've done for loop but I made a mess of this code
			{
				c.addBead(c.findPit(stPit)); //adds beads to the pit equivalent in allPits
				j++;
			}
		}
		/**
		 * PLEASE PUT FULL FOCUS ON THIS PORTION OF THE CODE AND SAME FOR MOUSE LISTENER IN BPITS
		 */
		Apits.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				x = (WINDOW_WIDTH) / 8;//I made it move with window size because mouse clicks 
				//registered partially outside of the ellipses so this had to be hard coded for now
				//this is the x location for the first ellipse. It's hard to find location because
				//we are using a gridlayout which mixes which pixels are where in the ellipse when
				//coding
				if(!c.getCurrentPlayer().equals(c.getPlayerA()))//checks if Player A is not current player
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please only choose pits"
							+ " from your side of the board."); // displays error message if not current player
				}
				else if(c.addPitsA() == 0)// if player A side of board has no beads
				{
					gameOver(); 
					for(int i = 0; i < c.addPitsB(); i++)
						bigPitB.addBead();
					gameOver(); 
				}
				else
				{
					for(int i = 0; i < c.getPlayerAPits().size(); i++)
					{
						x += WINDOW_WIDTH/8;//switches to the next ellipse/pit
						if(e.getX() < x)//checks for mouse click event's x and if it is ellipse/pit's x
						{
							int size = c.getPlayerAPits().get(i).getBeadSize();//size is the bead size of that pit
							int l = c.getAllPits().indexOf(c.getPlayerAPits().get(i));//looks for index of playerApit in allPits as 
							//a reference point to start at in the distributing of beads in the arraylist
							int k = l;//holds original l because l gets changed
							for(int j = 0; j < size; j++)
							{
									l++;//l is next pit's index
									if(l == c.getAllPits().size())//go back to beginning of arraylist
										l = 0;
									if(!c.getAllPits().get(l).equals(bigPitB))
									{
										c.addBead(c.getAllPits().get(l));//adds bead to next pit in arraylist
										c.removeBead(c.getAllPits().get(k));//removes bead from the selected pit
									}
									else
										j+=1;
							}
							if(c.getAllPits().get(l).getBeadSize() == 1 && c.getPlayerAPits().contains(c.getAllPits().get(l))
									&& !c.getAllPits().get(l).equals(bigPitA))
							{
								x2 = 7*WINDOW_WIDTH/8;//since B is in array backwards need to start at far end of window
								Pit p = null;//have to initiate pit
								for(int j = 0; j < 6; j++)
								{
									x2 -= WINDOW_WIDTH/8;//cycle until find the x2 that is equal to the current x
									if(x == x2)//the pit that is at x2 is the pit to subtract from
										p =c.getPlayerBPits().get(j);
								}
								if(p.getBeadSize() > 0)
								{
									for(int r = 0; r < p.getBeadSize() + 1; r++)
									{
										c.getAllPits().get(l).addBead();
										p.removeBead();
									}
								}
							}
							if(!gameOver() && !c.getAllPits().get(l).equals(bigPitA))
							{
								c.switchTurns();//switches turns
								repaintAll();//repaints everything inside the frame so it is up to date
								//this method is pretty long and obnoxious and can definitely be redone
								break;//pulls you out of loop so you don't keep searching could use a boolean instead too
							}
							else if(c.getAllPits().get(l).equals(bigPitA))
							{
								repaintAll();
								JOptionPane.showMessageDialog(new JFrame(), "Player A go again.");
								break;
							}
						}
					}
				}
				revalidate();//revalidates all info in frame
			}

			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		Apits.add(fillerSpace4);
		board.add(Apits, BorderLayout.SOUTH);
		revalidate();
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
			c.addPitAll(stPit);
			c.addPitB(stPit);
			int j = 0;
			while(j < c.getBeadAmount())
			{
				c.addBead(stPit);
				j++;
			}
			Bpits.add(new JLabel(c.findPit(stPit)));
		}
		Bpits.add(fillerSpace2);
		Bpits.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(!c.getCurrentPlayer().equals(c.getPlayerB()))
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please only choose pits"
							+ " from your side of the board.");
				}
				else if(c.addPitsB() == 0)
				{ 
					gameOver(); 
				}
				else
				{
					x2 = (WINDOW_WIDTH * 7)/8;//I made it move with window size because mouse clicks 
					//registered partially outside of the ellipses so this had to be hard coded for now
					//this is the x location for the first ellipse. It's hard to find location because
					//we are using a gridlayout which mixes which pixels are where in the ellipse when
					//coding. This is exact same stuff as the one for playerA
					for(int i = 0; i < c.getPlayerBPits().size(); i++)
					{
						x2 -= WINDOW_WIDTH/8;
						if(e.getX() > x2)
						{
							int size = c.getPlayerBPits().get(i).getBeadSize();
							int l = c.getAllPits().indexOf(c.getPlayerBPits().get(i));
							int k = l;
							for(int j = 0; j < size; j++)
							{
									l++;//l is next pit's index
									if(l == c.getAllPits().size())//go back to beginning of arraylist
										l = 0;
									if(!c.getAllPits().get(l).equals(bigPitA))
									{
										c.addBead(c.getAllPits().get(l));//adds bead to next pit in arraylist
										c.removeBead(c.getAllPits().get(k));//removes bead from the selected pit
									}
									else
										j+=1;
							}
							if(c.getAllPits().get(l).getBeadSize() == 1 && c.getPlayerBPits().contains(c.getAllPits().get(l))
									&& !c.getAllPits().get(l).equals(bigPitB))
							{
								x = WINDOW_WIDTH/8;
								Pit p = null;
								for(int j = 0; j < 6; j++)
								{
									x += WINDOW_WIDTH/8;//finding which pit is positioned across from the current one
									if(x == x2)//if that is the one positioned across then that is the pit
										p =c.getPlayerAPits().get(j);
								}
								if(p.getBeadSize() > 0)
								{
									int m = p.getBeadSize();//made separate variable otherwise the size would 
									//continually change and the numbers would be wrong
									for(int r = 0; r < m; r++)
									{
										c.getAllPits().get(l).addBead();//add the beads to the pit
										p.removeBead();//remove from the pit across
									}
								}
							}
							if(!gameOver() && !c.getAllPits().get(l).equals(bigPitB))
							{
								c.switchTurns();//switches current player
								repaintAll();//repaints everything inside the frame so it is up to date
								//this method is pretty long and obnoxious and can definitely be redone
								break;
							}
							else if(c.getAllPits().get(l).equals(bigPitB))
							{
								repaintAll();
								JOptionPane.showMessageDialog(new JFrame(), "Player B go again.");
								break;
							}
						}
					}
				}
				revalidate();
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		board.add(Bpits, BorderLayout.NORTH);
		revalidate();
	}
	/**
	 * Creates and draws the main pit for Player A
	 */
	public void initializeMainPitA() 
	{
		pitA = new JPanel();
		Alabel = new JLabel("A");
		BigPit bPit = new BigPit();
		bigPitA = bPit;
		pitA.add(Alabel);
		c.addPitAll(bigPitA);
		pitA.add(new JLabel(c.findPit(bigPitA)));
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
		bigPitB = bPit;
		c.addPitAll(bigPitB);
		pitB.add(new JLabel(c.findPit(bigPitB)));
		pitB.add(Blabel);
		board.add(pitB, BorderLayout.WEST);
	}
	/**
	 * Creates and Initializes the Center of the Board
	 */
	public void initializeCenterBoard() 
	{
		displayPanel = new JPanel(new GridLayout(3,6));
		for(int i = 6; i > 0; i--)
			displayPanel.add(new JLabel("           B" + i));
		for(int i = 3; i > 0; i--)
			displayPanel.add(new JLabel(" "));
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
		for(int i = 2; i > 0; i--)
			displayPanel.add(new JLabel(" "));
		for(int i = 1; i < 7; i++)
			displayPanel.add(new JLabel("            A" + i));
		board.add(displayPanel, BorderLayout.CENTER);
	}
	/**
	 * Closes the Mancala frame
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
	/**
	 * In order to get the picture to update you have to remove everything from the board
	 * repaint it all re-validate it all and then add it all back in the right order
	 * so that everything is up to date when it comes to the beads and pits
	 */
	public void repaintAll()
	{
		this.getContentPane().remove(board);
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		board.removeAll();
		board.revalidate();
		Apits.removeAll();
		Apits.add(fillerSpace3);
		for(int i = 0; i < 6; i++)
			Apits.add(new JLabel(c.getAllPits().get(i)));
		Apits.add(fillerSpace4);
		Apits.revalidate();
		Apits.repaint();
		pitA.removeAll();
		pitA.add(Alabel);
		pitA.add(new JLabel(c.getAllPits().get(6)));
		pitA.revalidate();
		pitA.repaint();
		Bpits.removeAll();
		Bpits.add(fillerSpace);
		for(int i = 12; i > 6; i--)//This part goes backwards because the pits for player B are
			//entered into the arraylist backwards
			Bpits.add(new JLabel(c.getAllPits().get(i)));
		Bpits.add(fillerSpace2);
		Bpits.revalidate();
		Bpits.repaint();
		pitB.removeAll();
		pitB.add(new JLabel(c.getAllPits().get(13)));
		pitB.add(Blabel);
		pitB.revalidate();
		pitB.repaint();
		board.add(displayPanel, BorderLayout.CENTER);
		board.revalidate();
		board.repaint();
		board.add(Apits, BorderLayout.SOUTH);
		board.revalidate();
		board.repaint();
		board.add(pitA, BorderLayout.EAST);
		board.revalidate();
		board.repaint();
		board.add(Bpits, BorderLayout.NORTH);
		board.revalidate();
		board.repaint();
		board.add(pitB, BorderLayout.WEST);
		board.revalidate();
		board.repaint();
		this.getContentPane().add(board);
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}
	/**
	 * Checks to see if one of the pits holds all of the beads
	 */
	public boolean gameOver()
	{
		if(bigPitB.getBeadSize() == endGame || c.addPitsA() == 0) 
		{
			JOptionPane.showMessageDialog(new JFrame(), "Player B wins!");
			closeGameFrame();
			StartMenu s = new StartMenu();
			return true;
		}
		else if(bigPitA.getBeadSize() == endGame || c.addPitsB() == 0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Player A wins!");
			closeGameFrame();
			StartMenu s = new StartMenu();
			return true;
		}
		else if(c.addPitsA() == 0 && c.addPitsB() == 0)
		{
			if(bigPitA.getBeadSize() > bigPitB.getBeadSize())
			{
				JOptionPane.showMessageDialog(new JFrame(), "Player A wins!");
				closeGameFrame();
				StartMenu s = new StartMenu();
				return true;
			}
			else if(bigPitA.getBeadSize() < bigPitB.getBeadSize())
			{
				JOptionPane.showMessageDialog(new JFrame(), "Player B wins!");
				closeGameFrame();
				StartMenu s = new StartMenu();
				return true;
			}
			else
			{
				JOptionPane.showMessageDialog(new JFrame(), "It's a tie!");
				closeGameFrame();
				StartMenu s = new StartMenu();
				return true;
			}
		}
		return false;
	}
}
