package models.items;

import models.character.race.EquipSlots.Location;
import models.magic.enchantments.Enchantment;

public class Item {
	protected boolean equipable;
	protected boolean weapon;
	protected boolean armor;
	
	protected Location location;
	protected int range;
	protected String name;
	protected int damagemod;
	// # of turn cooldown.. 1 = can attack once per turn, 2 is once every other turn, .5 is twice a turn
	protected float speed;
	protected int size;
	protected int acmod;
	protected int dexmod;
	protected int deflec;
	protected int weight;
	protected int volume;
	protected Enchantment[] enchantments;

	public Item(boolean isequipable, boolean isweapon, boolean isarmor, Location location, int range, String name, int damagemod,
			float speed, int size, int acmod, int dexmod, int deflec, int weight,
			int volume, Enchantment[] enchantments) {
		this.equipable = isequipable;
		this.weapon = isweapon;
		this.armor = isarmor;
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
		this.enchantments = enchantments;
	}

	public boolean isEquipable() {
		return equipable;
	}

	public boolean isWeapon() {
		return weapon;
	}

	public boolean isArmor() {
		return armor;
	}

	public int getRange() {
		int rng = range;
		for (Enchantment ench : enchantments) {
			rng += ench.getRangeMod();
		}
		return rng;
	}

	public String getName() {
		String n = name;
		boolean pre = false;
		boolean post = false;
		for (Enchantment ench : enchantments) {
			if ( pre && post ) {
				break;
			}
			if (! "".equals(ench.getPrefix())){
				n = ench.getPrefix() + " " + n;
				pre = true;
				continue;
			}
			if (! "".equals(ench.getPostfix())){
				n = n + " " + ench.getPostfix();
				post = true;
				continue;
			}
		}
		return n;
	}

	public int getDamageMod() {
		int dmg = damagemod;
		for (Enchantment ench : enchantments) {
			dmg += ench.getDmgMod();
		}
		return dmg;
	}

	public float getSpeed() {
		float spd = speed;
		for (Enchantment ench : enchantments) {
			spd += ench.getSpeedMod();
		}
		return spd;
	}

	public Enchantment[] getEnchantments() {
		return enchantments;
	}

	public int size() {
		return size;
	}

	public int getAcmod() {
		return acmod;
	}

	public int getDexmod() {
		return dexmod;
	}

	public int getDeflec() {
		return deflec;
	}

	public int getWeight() {
		return weight;
	}

	public int getVolume() {
		return volume;
	}

	public Location location() {
		return location;
	}
	
	public String toString() {
		String ench = "Enchantments:\n";
		for (Enchantment e : enchantments){
			ench += e.toString();
		}
		return "Item: " + getName() + "\n" +
				"\tBase name: " + name + "\n" +
				"\tEquipable: " + equipable + "\n" +
				"\tLocation: " + location + "\n" +
				"\tRange: " + range + "\n" +
				"\tSpeed: " + speed + "\n" +
				"\tSize: " + size + "\n" +
				"\tWeight: " + weight + "\n" +
				"\tNoisiness: " + volume + "\n" +
				"\tDeflection: " + deflec + "\n" +
				"\tAC Modifier: " + acmod + "\n" +
				"\tDamage Modifier: " + damagemod + "\n" +
				"\tDexterity Modifier: " + dexmod + "\n" +
				ench;
	}

}
