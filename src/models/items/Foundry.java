package models.items;

import java.util.Random;

import models.character.race.EquipSlots.Location;
import models.magic.enchantments.Enchantment;
import models.magic.enchantments.Enchantment.type;

public class Foundry {
	public enum ItemTypes {WEAPON, ARMOR, POTIONS, STUFF};
	
	public static Item getItem() {
		Random r = new Random();
		// randomly choose an ItemType
		return getItem(ItemTypes.values()[r.nextInt(ItemTypes.values().length)]);
	}
	
	public static Item getItem(ItemTypes type) {
		switch (type) {
		case WEAPON:
			return getRandomWeapon();
		case ARMOR:
			return getRandomArmor();
		case POTIONS:
			return getPotion();
		case STUFF:
			return getStuff();
		default:
			return null;
		}
	}
	
	public static Item getRandomWeapon() {
		return null;
	}
	
	public static Item getRandomArmor() {
		return null;
	}
	
	public static Item getPotion() {
		return null;
	}
	
	public static Item getStuff() {
		return null;
	}
	
	public static Item getMagicArmor() {
		return null;
	}
	
	public static Item getMagicArmor(ArmorType type) {
		return null;
	}
	
	public static Item getMagicWeapon(Enchantment[] ench) {
		Item i = getBaseWeapon(WeaponType.BREATH);
		i.enchantments = ench;
		return i;
	}
	
	public static Item getUncommonWeapon() {
		return null;
	}
	
	public static Item getCommonWeapon() {
		return null;
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
		return new Item(true, true, false, Location.HEAD, 20, "breath", 20, 10, 0, 0, 0, 0, 0, 0, new Enchantment[] {new Enchantment(new type[]{type.FIRE},"fire", "", 5, 0, 0, 0, 0, 0, 0, 0)});
	}
}
