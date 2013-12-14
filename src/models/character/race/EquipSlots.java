package models.character.race;

import java.util.HashMap;

import models.items.Item;

public class EquipSlots {
	public enum Location {HEAD, NECK, SHOULDERS, CHEST, ARMS, HANDS, LEGS, FEET};
	
	private SlotList weapons;
	private HashMap<Location, Item> armor;
	
	public EquipSlots(int numOfAttackableSlots, Location[] armorslots){
		this.weapons = new SlotList(numOfAttackableSlots);
		armor = new HashMap<EquipSlots.Location, Item>(armorslots.length);
		for (Location l : armorslots) {
			armor.put(l, null);
		}
	}
	
	public boolean equip(Item item) {
		if (! item.isEquipable()) return false;
		
		if (item.isWeapon()) {
			return equipWeapon(item);
		}
		return equipArmor(item);
	}
	
	public boolean unequip(Item item) {
		if (item.isEquipable()) {
			if (item.isWeapon()) {
				return unequipWeapon(item);
			}
			if (item.isArmor()) {
				return unequipArmor(item);
			}
		}
		return false;
	}
	
	public boolean hasWeapon() {
		return ! weapons.isEmpty();
	}
	
	public Item getWeapon() {
		return weapons.get(0);
	}
	
	public Item getWeapon(int i) {
		return weapons.get(i);
	}
	
	public Item getWeapon(Item item) {
		int idx = weapons.indexOf(item);
		if (idx < 0) return null;
		return weapons.get(idx);
	}
	
	public Item[] getWeapons() {
		return weapons.toArray(new Item[]{});
	}
	
	private boolean equipWeapon(Item item) {
		if (weapons.areSlotsAvailable(item.size()))
			return weapons.add(item);
		return false;
	}
	
	private boolean unequipWeapon(Item item) {
		return weapons.remove(item);
	}
	
	private boolean equipArmor(Item item) {
		if (armor.keySet().contains(item.location())) {
			if (armor.get(item.location()) != null) {
				return armor.put(item.location(), item) == null;
			}
		}
		return false;
	}
	
	private boolean unequipArmor(Item item) {
		if (armor.keySet().contains(item.location())) {
			return armor.remove(item) != null;
		}
		return false;
	}
}
