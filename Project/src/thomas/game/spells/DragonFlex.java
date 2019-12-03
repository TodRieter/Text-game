package thomas.game.spells;

import thomas.game.entities.Entity;

public class DragonFlex extends Buff{

	public DragonFlex() {
		super("Dragon Flex", "The Dragon's muscules seem larger than before...", 1, 5, 5,new StatusEffect[] {new HalfDamage(), new AttackBoost(5)});
	}
public void useBuff(Entity entity){
	entity.getBuffList().add(this);
	entity.setAttack(entity.getAttack() + 5);
	addStatusEffects(entity);
}
public void removeBuff(Entity entity) {
	entity.setAttack(entity.getAttack() - 5);
	entity.getBuffList().remove(this);
}

@Override
public void affect(Entity caster) {
	for(StatusEffect effect : this.effects){
		effect.affect(caster);
	}
}
}
