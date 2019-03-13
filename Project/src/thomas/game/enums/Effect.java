package thomas.game.enums;

public enum Effect {

		BACKFIRE("hurts the user", 0), FLAME("sets the enemy on fire", 5), SAP("gain life from damage delt", 0);
		String info;
		public int time;
		
		Effect(String descrip, int turns){
			 descrip = this.info;
		}
		String getInfo(){
			return this.info;
		}
	}


