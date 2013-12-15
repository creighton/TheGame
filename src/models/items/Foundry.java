package models.items;

import java.util.Random;

import models.character.race.EquipSlots.Location;
import models.magic.enchantments.Enchantment;
import models.magic.enchantments.EnchantmentTypes;

public class Foundry {
	public enum ItemTypes {WEAPON, ARMOR, POTIONS, STUFF};
	
	public static Item getItem() {
		Random r = new Random();
		// randomly choose an ItemType
		return getItem(ItemTypes.values()[r.nextInt(ItemTypes.values().length)], r);
	}
	
	public static Item getItem(ItemTypes type, Random r) {
		switch (type) {
		case WEAPON:
			return getRandomWeapon(r);
		case ARMOR:
			return getRandomArmor(r);
		case POTIONS:
			return getPotion(r);
		case STUFF:
			return getStuff(r);
		default:
			return null;
		}
	}
	
	public static Item getPotion(Random r) {
		return null;
	}
	
	public static Item getStuff(Random r) {
		return null;
	}
	
	public static Item getRandomArmor(Random r) {
		return null;
	}
	
	public static Item getMagicArmor() {
		return null;
	}
	
	public static Item getMagicArmor(ArmorType type) {
		return null;
	}
	
	public static Item getRandomWeapon(Random r) {
		int n = r.nextInt(100);
		if ( n < 80) 
			return getCommonWeapon(r);
		else if ( n < 95 )
			return getUncommonWeapon(r);
		else return getMagicWeapon(r);
	}
	
	public static Item getCommonWeapon(Random r) {
		WeaponType[] common = WeaponType.getCommonWeapons();
		WeaponType wp = common[r.nextInt(common.length)];
		return new Item(true, true, false, wp.location, wp.range, wp.name, 
				wp.damagemod + r.nextInt(3), wp.speed, wp.size, wp.acmod, wp.dexmod, wp.deflec, wp.weight, wp.volume, 
				new Enchantment[]{});
		
	}
	
	public static Item getUncommonWeapon(Random r) {
		WeaponType[] common = WeaponType.getCommonWeapons();
		WeaponType wp = common[r.nextInt(common.length)];
		return new Item(true, true, false, wp.location, Math.round(wp.range * 1.25f), "uncommon " + wp.name, 
				wp.damagemod + r.nextInt(6), wp.speed * .96f, wp.size, wp.acmod, wp.dexmod, wp.deflec, wp.weight, wp.volume, 
				new Enchantment[]{});
	}
	
	public static Item getMagicWeapon(Random r) {
		Item i = getUncommonWeapon(r);
		EnchantmentTypes x = EnchantmentTypes.values()[r.nextInt(EnchantmentTypes.values().length)];
		i.enchantments = new Enchantment[] {new Enchantment(new EnchantmentTypes[]{x}, x.prefix, x.postfix, x.dmgMod, x.speedMod, x.rangeMod, x.acMod, x.deflecMod, x.dexMod, x.volMod, x.wghtMod)};
		return i;
	}

	public static Item getBaseWeapon(WeaponType wpntype) {
		return base(wpntype);
	}
	
	public static Item getSpecialWeapon(WeaponType wpntype) {
		switch (wpntype) {
		case BREATH:
			return specialFirebreath();

		default:
			return null;
		}
	}
	
	private static Item base(WeaponType wpntype) {
		return new Item(true, true, false, wpntype.location, wpntype.range, wpntype.name, wpntype.damagemod, wpntype.speed, wpntype.size,
				wpntype.acmod, wpntype.dexmod, wpntype.deflec, wpntype.weight, wpntype.volume, new Enchantment[]{});
	}
	
	private static Item specialFirebreath() {
		return new Item(true, true, false, Location.HEAD, 20, "breath", 20, 10, 0, 0, 0, 0, 0, 0, new Enchantment[] {new Enchantment(new EnchantmentTypes[]{EnchantmentTypes.FIRE},"fire", "", 5, 0, 0, 0, 0, 0, 0, 0)});
	}
}
