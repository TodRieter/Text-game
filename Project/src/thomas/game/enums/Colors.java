package thomas.game.enums;

public enum Colors {
	
	RESET("\u001B[0m"), BLACK ("\u001B[30m"), RED ("\u001B[31m"), GREEN ("\u001B[32m"),YELLOW ("\u001B[33m"), BLUE ("\u001B[34m"),
	PURPLE ("\u001B[35m"), CYAN ("\u001B[36m"), WHITE ("\u001B[37m"), BOLD ("\u001B[1m"), UNDERLINE ("\u001B[4m"), REVERSE_VIDEO ("\u001B[7m");
	public String color;
	Colors(String code){
		this.color = code;
	}
}

