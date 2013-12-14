package models.items;

import models.character.race.EquipSlots.Location;

/**
 * Weapon Type
 * 
 * Types of weapons available and base stats.
 * 
 * @author freakshow
 *
 */

public enum WeaponType {
	// body types
	HANDS(Location.HANDS, 2, "hands", 0, .5f, 0, 0, 0, 0, 0, 0),
	HEAD(Location.HEAD, 1, "head", 0, 1, 0, 0, 0, 0, 0, 0),
	FEET(Location.FEET, 3, "feet", 1, 1.5f, 0, 0, 0, 0, 0, 0),
	CLAWS(Location.HANDS, 2, "claws", 1, .5f, 0, 0, 0, 0, 0, 0),
	BREATH(Location.HEAD, 20, "breath", 20, 10, 0, 0, 0, 0, 0, 0);
	
	public final Location location;
	public final int range;
	public final String name;
	public final int damagemod;
	public final float speed;
	public final int size;
	public final int acmod;
	public final int dexmod;
	public final int deflec;
	public final int weight;
	public final int volume;
	
	WeaponType(Location location, int range, String name, int damagemod, float speed, int size, int acmod, int dexmod, int deflec, int weight, int volume) {
		this.location = location;
		this.range = range;
		this.name = name;
		this.damagemod = damagemod;
		this.speed = speed;
		this.size = size;
		this.acmod = acmod;
		this.dexmod = dexmod;
		this.deflec = deflec;
		this.weight = weight;
		this.volume = volume;
	}
}
