package KeyboardAction;

import javax.swing.KeyStroke;

import MainHandler.Screen;

public class Keys {
	//static boolean left,up,down,right;
	public static final String keybind[] = new String[]{"A","S","D","W"};
	public static byte movement = 0;
	
	public int x;
	public int y;
	
	
	public Keys()
	{
		Screen.inputMap.clear();
		Screen.actionMap.clear();
		
		for(int i = 0;i<keybind.length;i++)	
		{
			Screen.inputMap.put(KeyStroke.getKeyStroke(keybind[i]), keybind[i] + " pressed");							
			Screen.actionMap.put(keybind[i] + " pressed", new Movements(keybind[i],false,i));
			
			Screen.inputMap.put(KeyStroke.getKeyStroke(keybind[i].charAt(0),0,true), keybind[i] + " released");						
			Screen.actionMap.put(keybind[i] + " released", new Movements(keybind[i],true,i));
		}
	}
	
	public Keys(String...strings)
	{
		Screen.inputMap.clear();
		Screen.actionMap.clear();
		
		for(int i = 0;i<strings.length;i++)	
		{
			Screen.inputMap.put(KeyStroke.getKeyStroke(strings[i]), strings[i] + " pressed");							
			Screen.actionMap.put(strings[i] + " pressed", new Movements(strings[i],false,i));
			
			Screen.inputMap.put(KeyStroke.getKeyStroke(strings[i].charAt(0),0,true), strings[i] + " pressed");						
			Screen.actionMap.put(strings[i] + " pressed", new Movements(strings[i],true,i));
		}
	}
	
	
}
