package thomas.game.enums;
import thomas.game.enums.Colors;
public enum Rarity {
	
	ACMERARE(Colors.YELLOW), UBERRARE(Colors.PURPLE), SUPERRARE(Colors.GREEN), RARE(Colors.BLUE), MEH(Colors.WHITE);
	public Colors color;

	Rarity(Colors clr){
		 this.color = clr;
	}
	public String code(){
		return this.color.color;
	}

}
