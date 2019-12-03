package thomas.game.spells;

import thomas.game.GameObject;
import thomas.game.entities.Entity;
import thomas.game.enums.Effect;

public abstract class StatusEffect {
	
	int duration = 0;
	protected int modifier = 0;
	public String name = "";
	
	public StatusEffect() {
		
	}
	public StatusEffect(String name, int duration, int modifier) {
		this.duration = duration;
		this.modifier = modifier;
		this.name = name;
	}
	public StatusEffect(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}
	public StatusEffect(int duration, int modifier) {
		this.modifier = modifier;
		this.duration = duration;
	}
	//public abstract void affect(Entity entity);
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getModifier() {
		return modifier;
	}
	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
	
	public abstract StatusEffect clone();
	public void addStatusEffect(Entity entity) {
		entity.getStatusEffects().add(this.clone());		
	}
	public void removeStatusEffect(Entity entity) {
		entity.getStatusEffects().remove(this);
	}
	public void checkEffect(Entity entity) {
		if(!entity.getStatusEffects().contains(this)) {
			this.clone().addStatusEffect(entity);
			GameObject.g.display(entity.getName() + " has been given the effect: " + this.name);
		} else {
			this.removeStatusEffect(entity);
			this.tickEffect().addStatusEffect(entity);
		}
		if(this.duration <= 0) {
			this.removeStatusEffect(entity);
		}
	}
	//should only be given status effects from the entities status effects
	public StatusEffect tickEffect() {
		this.setDuration(this.duration-1);
		return this;
	}
	@Override
	public boolean equals(Object effect) {
		return this.getName().equals(((StatusEffect) effect).getName());
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return "Name: " + name + " duration: " + duration;
	}
	public abstract void affect(Entity entity);
		
}
