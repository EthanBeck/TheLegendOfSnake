package KeyboardAction;
import java.awt.event.*;
import javax.swing.*;
import KeyboardAction.Keys;

public class Movements extends AbstractAction //Transfers raw keyboard input into movement
{

	String key;
	boolean released;
	int index;
	

	public Movements(String key,boolean released) //When action is committed, takes key that was pressed and sends it here
	{
		this.key = key;
		this.released = released;
	}
	public Movements(String key,boolean released,int index) //When action is committed, takes key that was pressed and sends it here
	{
		this.key = key;
		this.released = released;
		this.index = index;
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(!released)
			Keys.movement |= (int)Math.pow(2, index);
		else
			Keys.movement ^= (int)Math.pow(2, index);
	}
}