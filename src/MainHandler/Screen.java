package MainHandler;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Character.Character;
import KeyboardAction.Keys;
import KeyboardAction.Mouse;

public class Screen extends Applet
{
	private Graphics doubleG;//double buffering
	Image im;

	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	public static final int SCALE  = 3;

	JFrame frame;
	Font font;
	FontMetrics metrics;

	public static InputMap inputMap;
	public static ActionMap actionMap;
	JLabel label;

	Keys key;

	Mouse mouse;
	
	Character character = new Character();

	public Screen()
	{
		frame = new JFrame("Tank Game");

		label = new JLabel();

		setBackground(new Color(0x999999));
		
		inputMap = label.getInputMap(JComponent.WHEN_FOCUSED);
		actionMap = label.getActionMap();

		key = new Keys();
		mouse = new Mouse(this);

		setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		frame.getContentPane().add(this, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(this,BorderLayout.CENTER);

		frame.pack();

		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		character = new Character(this.getWidth()/2,this.getHeight()/2);
		add(label);	
	}

	public synchronized void paint(Graphics g)
	{
		
		Graphics2D g2 = (Graphics2D)g;
		
		character.movement();

		character.displayCharacter(g2);
		character.displayCannon(g2);
		
		character.displayMap(g2);
		
		setRenderingHints(g2);
		repaint();
	}
	
	public void setRenderingHints(Graphics2D g2)
	{
		font = new Font("Comic Sans MS", Font.BOLD, 20);
		metrics = g2.getFontMetrics(font);
		g2.setFont(font);
		g2.setRenderingHint(
				RenderingHints.KEY_ALPHA_INTERPOLATION,
				RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2.setRenderingHint(
				RenderingHints.KEY_COLOR_RENDERING,
				RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}
	public synchronized void update(Graphics g)
	{
		if(im == null)
		{
			im = createImage(this.getSize().width,this.getSize().height);
			doubleG = im.getGraphics();
		}
		doubleG.setColor(getBackground());
		doubleG.fillRect(0,0,this.getSize().width,this.getSize().height);
		doubleG.setColor(getForeground());
		paint(doubleG);
		g.drawImage(im,0,0,this);
	}
}
