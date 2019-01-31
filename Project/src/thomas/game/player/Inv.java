package thomas.game.player;

import thomas.game.items.Item;

public interface Inv {

	int length = 5;

	Item[] getItem(Item item);

	void checkInv(Item[] inv);

	void pickUp(Item item);

	void dropItem(Item item);

	String toString(Item inv);
}