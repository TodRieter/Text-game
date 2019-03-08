package thomas.game.enums;

public enum Effect {

		BACKFIRE("hurts the user"), FLAME("sets the enemy on fire"), SAP("gain life from damage delt");
		String info;
		
		Effect(String descrip){
			 descrip = this.info;
		}
		String getInfo(){
			return this.info;
		}
	}


