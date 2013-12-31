package models.items;

import java.util.ArrayList;

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
	HANDS(Location.HANDS, 2, "hands", 1, .5f, 0, 0, 0, 0, 0, 0, true),
	HEAD(Location.HEAD, 1, "head", 1.1f, 1, 0, 0, 0, 0, 0, 0, true),
	FEET(Location.FEET, 3, "feet", 1.2f, 1.5f, 0, 0, 0, 0, 0, 0, true),
	CLAWS(Location.HANDS, 2, "claws", 1.3f, .5f, 0, 0, 0, 0, 0, 0, true),
	BREATH(Location.HEAD, 20, "breath", 1, 10, 0, 0, 0, 0, 0, 0, true),
	
	// location, range, name, dmgmod, speed, size, acmod, dexmod, deflec, weight, volume
	AXE(Location.HANDS, 2, "axe", 3, .5f, 1, 0, 0, 0, 1, 1, false),
	SWORD(Location.HANDS, 2, "sword", 3, 1, 1, 0, 0, 0, 1, 1, false),
	BOW(Location.HANDS, 30, "bow", 3, .5f, 2, 0, 0, 0, 1, 0, false);
	
	public final Location location;
	public final float range;
	public final String name;
	public final float damagemod;
	public final float speed;
	public final int size;
	public final float acmod;
	public final float dexmod;
	public final float deflec;
	public final float weight;
	public final float volume;
	public final boolean base;
	
	WeaponType(Location location, float range, String name, float damagemod, float speed, int size, float acmod, float dexmod, float deflec, float weight, float volume, boolean base) {
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
		this.base = base;
	}
	
	public static WeaponType[] getCommonWeapons() {
		ArrayList<WeaponType> w = new ArrayList<WeaponType>();
		for (WeaponType wpn : WeaponType.values()) {
			if (! wpn.base)
				w.add(wpn);
		}
		return w.toArray(new WeaponType[]{});
	}
}
