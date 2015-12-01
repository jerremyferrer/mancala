package mancala;

public class MancalaModel {
	private Pit[] playerApits;
	private Pit[] playerBpits;
	private int initialBeadAmount;
	private Player playerA;
	private Player playerB;
	private Player current;
	/**
	 * Initiates the arrays for Player A and Player B
	 */
	public MancalaModel() 
	{
		playerApits[] = new Pit[6];//going to switch to contain specific pits
		playerBpits[] = new Pit[6];//""
		current = playerA;
	}
	/**
	 * Sets the initial amount of beads
	 * @param beads - the inital bead amount
	 */
	public void setInitialBeadAmount(int beads) 
	{
		this.initialBeadAmount = beads;
	}
	/**
	 * Returns the initial amount of beads
	 * so that the board can be set up
	 * @return initalBeadAmount
	 */
	public int getBeadAmount()
	{
		return initialBeadAmount; //allows controller to access
	}
	/**
	 * Returns playerApits array
	 * @return playerApits
	 */
	public Pit[] getPlayerA()
	{
		return playerApits;
	}
	/**
	 * Returns playerBpits array
	 * @return playerBpits
	 */
	public Pit[] getPlayerB()
	{
		return playerBpits;
	}
	/**
	 * Sees if Player A pits contain a specific pit
	 * @param p - the pit
	 * @return boolean true or false
	 */
	public boolean findPitA(Pit p)
	{
		if(playerApits.contains(p))
			return true
		else
			return false
	}
	/**
	 * Sees if Player B pits contain a specific pit
	 * @param p - the pit
	 * @return boolean true or false
	 */
	public boolean findPitB(Pit p)
	{
		if(playerBpits.contains(p))
			return true
		else
			return false
	}
	/**
	 * Returns the current player
	 * @return current player
	 */
	public Player getCurrentPlayer()
	{
		return current;
	}
	/**
	 * Switches current to opposite player
	 */
	public void switchTurns()
	{
		if(current.equals(playerA))
			current = playerB;
		else
			current = playerA;
	}
	
}
