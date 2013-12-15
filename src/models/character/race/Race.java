package models.character.race;

import models.character.Character.Movement;
import models.character.items.exceptions.NoWeaponException;
import models.character.race.EquipSlots.Location;
import models.items.Foundry;
import models.items.Item;
import models.items.WeaponType;

public enum Race {
	DRAGON(new EquipSlots(0, new Location[]{}), 
		   new Movement[]{Movement.GROUND, Movement.AIR}, 
		   5f, 5f, 2.5f, 1.5f, 1f, 1.5f, 1.5f, 1.5f, 1f, 
		   Foundry.getBaseWeapon(WeaponType.CLAWS), 
		   Foundry.getSpecialWeapon(WeaponType.BREATH)), 
		   
	DWARF(new EquipSlots(2, Location.values()), 
		  new Movement[]{Movement.GROUND}, 
		  1.2f, 1.2f, 1.2f, 1.1f, .9f, 1.05f, .95f, .95f, .9f,
		  Foundry.getBaseWeapon(WeaponType.HANDS), 
		  null), 
		  
	ELF(new EquipSlots(2, Location.values()), 
		new Movement[]{Movement.GROUND}, 
		1.05f, 1.05f, 1.05f, .95f, 1.1f, 1f, 1.1f, 1.1f, 1.1f,
		Foundry.getBaseWeapon(WeaponType.HANDS),
		null), 
		
	HALFLING(new EquipSlots(2, Location.values()), 
			 new Movement[]{Movement.GROUND}, 
			 1.1f, 1.1f, .9f, .9f, .9f, 1.1f, .95f, 1.05f, 1f,
			 Foundry.getBaseWeapon(WeaponType.HANDS),
			 null),
			 
	HUMAN(new EquipSlots(2, Location.values()), 
		  new Movement[]{Movement.GROUND}, 
		  1, 1, 1, 1, 1, 1, 1, 1, 1,
		  Foundry.getBaseWeapon(WeaponType.HANDS),
		  null), 
		  
	ORC(new EquipSlots(2, Location.values()), 
		new Movement[]{Movement.GROUND}, 
		1f, 1f, 1.2f, 1f, 1f, 1f, 1f, 1f, .1f,
		Foundry.getBaseWeapon(WeaponType.HANDS),
		null);
	
	public Movement[] movements;
	public float hpMod;
	public float acMod;
	public float dmgMod;
	public float strMod;
	public float dexMod;
	public float conMod;
	public float intMod;
	public float wisMod;
	public float chrMod;
	public EquipSlots equipslots;
	private Item baseWeapon;
	private Item specialWeapon;
	
	private Race(EquipSlots equipslots, Movement[] movements, float hpMod, float acMod, float dmgMod, float strMod,
			float dexMod, float conMod, float intMod, float wisMod, float chrMod, Item bw, Item sw) {
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
		this.baseWeapon = bw;
		this.specialWeapon = sw;
	}
	
	public static Race[] getCharacterRaces() {
		return new Race[] {DRAGON, DWARF, ELF, HALFLING, HUMAN, ORC};
	}
	
	public EquipSlots getEquipSlots() {
		return equipslots;
	}
	
	public Item getBaseWeapon() throws NoWeaponException {
		if (baseWeapon == null) {
			throw new NoWeaponException("no weapons");
		}
		return baseWeapon;
	}

	
	public Item getSpecialWeapon() throws NoWeaponException {
		if (specialWeapon == null) {
			throw new NoWeaponException("no special weapons");
		}
		return specialWeapon;
	}

	public Movement[] getMovements() {
		return movements;
	}

	public String getName() {
		return this.toString().toLowerCase();
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
