package models.character.race;

import models.character.items.exceptions.NoWeaponException;
import models.items.Item;

public class Race {
	public enum PlayerRaces {DRAGON, DWARF, ELF, HALFLING, HUMAN, ORC};
	public enum Movement {AIR, GROUND, WATER, DIG, TELEPORT};
	private Movement[] movements;
	private float hpMod;
	private float acMod;
	private float dmgMod;
	private float strMod;
	private float dexMod;
	private float conMod;
	private float intMod;
	private float wisMod;
	private float chrMod;
	private PlayerRaces race;
	private EquipSlots equipslots;
	
	public Race(PlayerRaces race, EquipSlots equipslots, Movement[] movements, float hpMod, float acMod, float dmgMod, float strMod,
			float dexMod, float conMod, float intMod, float wisMod, float chrMod) {
		this.race = race;
		this.movements = movements;
		this.hpMod = hpMod;
		this.acMod = acMod;
		this.dmgMod = dmgMod;
		this.strMod = strMod;
		this.dexMod = dexMod;
		this.conMod = conMod;
		this.intMod = intMod;
		this.wisMod = wisMod;
		this.chrMod = chrMod;
		this.equipslots = equipslots;
	}
	
	public Item getBaseWeapon() throws NoWeaponException {
		throw new NoWeaponException("no weapons");
	}

	
	public Item getSpecialWeapon() throws NoWeaponException {
		throw new NoWeaponException("no special weapons");
	}

	public Movement[] getMovements() {
		return movements;
	}

	public String getName() {
		return race.toString().toLowerCase();
	}

	public float getHpMod() {
		return hpMod;
	}
	
	// acts as base defense
	public float getAcMod() {
		return acMod;
	}
	
	public float getDamageMod() {
		return dmgMod;
	}

	public float getStrMod() {
		return strMod;
	}

	public float getDexMod() {
		return dexMod;
	}

	public float getConMod() {
		return conMod;
	}

	public float getIntMod() {
		return intMod;
	}

	public float getWisMod() {
		return wisMod;
	}

	public float getChrMod() {
		return chrMod;
	}
	
}
