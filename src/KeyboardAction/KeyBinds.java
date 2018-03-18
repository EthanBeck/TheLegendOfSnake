package KeyboardAction;

public enum KeyBinds {
	WASD(new String[]{"A","S","D","W"}),
	IJKL(new String[]{"J","K","L","I"});
	
	private String[] array;
	
	KeyBinds(String[] string){
		array = string;
	}
	public String[] getArray(){
		return array;
	}
}
