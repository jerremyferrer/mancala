package mancala;

public class MancalaModel {
	private int[] playerApits;
	private int[] playerBpits;
	private int initialBeadAmount;
	
	public MancalaModel() {
		
	}
	
	public void setInitialBeadAmount(int beads) {
		this.initialBeadAmount = beads;
	}
}
