package mancala;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardTwo extends BoardOne {
	public BoardTwo() {
		setColor();
	}
	public void setColor() {
		displayPanel.setBackground(Color.GREEN);
		pitB.setBackground(Color.GREEN);
		pitA.setBackground(Color.GREEN);
		Apits.setBackground(Color.GREEN);
		Bpits.setBackground(Color.GREEN);
	}
	

	

}
