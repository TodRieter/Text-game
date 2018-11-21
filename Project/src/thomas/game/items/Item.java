package thomas.game.items;



public abstract class Item {
	


	public String name;
	public int quantity;
	public boolean inInv = false;
	
public Item() {
		
		System.out.printf("Stats: ", this);
		
	}
	
	public Item(String name, int quantity, boolean inInv) {
		
		this.name = name;
		this.quantity = quantity;
		this.inInv = inInv;
			
		}
	
	
	String getName(){
		
		return name;
		
		}
	

	@Override
	public String toString() {
		return "Item [name=" + name + ", quantity=" + quantity +  "]";
	}
	
}


