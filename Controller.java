import java.awt.geom.Point2D;
import java.util.*;
/**
 * Controller of Mancalla game
 * @author Sydney Snyder, Jerremy Ferrer, & Royce Florence Rocco
 *
 */
public class Controller 
{
	private Model m;
	/**
	 * Initiate model
	 * CONTROLLER CONTAINS ONE MODEL EACH CLASS HOOKS INTO 
	 * CONTROLLER SO THAT THE CONTROLLER IS THE SAME 
	 * THROUGHOUT WITH THE SAME MODEL DATA
	 */
	public Controller()
	{
		m = new Model();//initiate model
	}
	/**
	 * Set amount of beads
	 * @param beads - amount to add
	 */
	public void setInitialBeadAmount(int beads)
	{
		m.setInitialBeadAmount(beads);
	}
	/**
	 * Get amount of beads
	 * @return Amount of beads
	 */
	public int getBeadAmount()
	{
		return m.getBeadAmount();
	}
	/**
	 * Get pits for Player A
	 * @return Player A pits
	 */
	public ArrayList<Pit> getPlayerAPits()
	{
		return m.getPlayerAPits();
	}
	/**
	 * Get pits for Player B
	 * @return Player B pits
	 */
	public ArrayList<Pit> getPlayerBPits()
	{
		return m.getPlayerBPits();
	}
	/**
	 * Returns Player B
	 * @return player b
	 */
	public Player getPlayerB()
	{
		return m.getPlayerB();
	}
	/**
	 * Returns Player A
	 * @return player a
	 */
	public Player getPlayerA()
	{
		return m.getPlayerA();
	}
	/**
	 * Finds the pit within allPits
	 * @param p - the pit
	 * @return pit found
	 */
	public Pit findPit(Pit p)
	{
		return m.findPit(p);
	}
	/**
	 * Adds a pit to playerApits
	 * @param p
	 */
	public void addPitA(Pit p)
	{
		m.addPitA(p);
	}
	/**
	 * Adds a pit to playerBpits
	 * @param p
	 */
	public void addPitB(Pit p)
	{
		m.addPitB(p);
	}
	/**
	 * Adds total beads in Pits on A side
	 */
	public int addPitsA()
	{
		return m.addPitsA();
	}
	/**
	 * Adds total beads in Pits on B side
	 */
	public int addPitsB()
	{
		return m.addPitsB();
	}
	/**
	 * Returns allPits
	 * @return allPits
	 */
	public ArrayList<Pit> getAllPits()
	{
		return m.getAllPits();
	}
	/**
	 * Adds bead to pit in allPits
	 * @param p - pit
	 */
	public void addBead(Pit p)
	{
		m.addBead(p);
	}
	/**
	 * Removes bead from pit in allPits
	 * @param p - pit
	 */
	public void removeBead(Pit p)
	{
		m.removeBead(p);
	}
	/**
	 * Adds pit to allPits
	 * @param p - pit
	 */
	public void addPitAll(Pit p)
	{
		m.addPitAll(p);
	}
	/**
	 * Returns the current player whose turn it is
	 * @return - the current player
	 */
	public Player getCurrentPlayer()
	{
		return m.getCurrentPlayer();
	}
	/**
	 * Switches player's turns
	 */
	public void switchTurns()
	{
		m.switchTurns();
	}
}
