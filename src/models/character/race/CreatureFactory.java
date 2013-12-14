package models.character.race;

import models.character.race.EquipSlots.Location;
import models.character.race.Race.Movement;
import models.character.race.Race.PlayerRaces;
import models.items.Foundry;
import models.items.Item;
import models.items.WeaponType;

public class CreatureFactory {
	public static Race getCreature() {
		return getPlayerRace(PlayerRaces.ORC);
	}

	public static Race getPlayerRace(Race.PlayerRaces race) {
		switch (race) {
		case DRAGON:
			return new Race(PlayerRaces.DRAGON, new EquipSlots(0, new Location[]{}), new Movement[]{Movement.GROUND, Movement.AIR}, 5f, 5f, 2.5f, 1.5f, 1f, 1.5f, 1.5f, 1.5f, 1f){
				public Item getBaseWeapon() {
					return Foundry.getBaseWeapon(WeaponType.CLAWS);
				}
				public Item getSpecialWeapon() {
					return Foundry.getSpecialWeapon(WeaponType.BREATH);
				}
			};
		
		case DWARF:
			return new Race(PlayerRaces.DWARF, new EquipSlots(2, Location.values()), new Movement[]{Movement.GROUND}, 1.2f, 1.2f, 1.2f, 1.1f, .9f, 1.05f, .95f, .95f, .9f){
				public Item getBaseWeapon() {
					return Foundry.getBaseWeapon(WeaponType.HANDS);
				}
			};
			
		case ELF:
			return new Race(PlayerRaces.ELF, new EquipSlots(2, Location.values()), new Movement[]{Movement.GROUND}, 1.05f, 1.05f, 1.05f, .95f, 1.1f, 1f, 1.1f, 1.1f, 1.1f){
				public Item getBaseWeapon() {
					return Foundry.getBaseWeapon(WeaponType.HANDS);
				}
			};
			
		case HALFLING:
			return new Race(PlayerRaces.HALFLING, new EquipSlots(2, Location.values()), new Movement[]{Movement.GROUND}, 1.1f, 1.1f, .9f, .9f, .9f, 1.1f, .95f, 1.05f, 1f){
				public Item getBaseWeapon() {
					return Foundry.getBaseWeapon(WeaponType.HANDS);
				}
			};
		
		case HUMAN:
			return new Race(PlayerRaces.HUMAN, new EquipSlots(2, Location.values()), new Movement[]{Movement.GROUND}, 1, 1, 1, 1, 1, 1, 1, 1, 1){
				public Item getBaseWeapon() {
					return Foundry.getBaseWeapon(WeaponType.HANDS);
				}
			};

		default:
			return new Race(PlayerRaces.ORC, new EquipSlots(2, Location.values()), new Movement[]{Movement.GROUND}, 1f, 1f, 1.2f, 1f, 1f, 1f, 1f, 1f, .1f){
				public Item getBaseWeapon() {
					return Foundry.getBaseWeapon(WeaponType.HANDS);
				}
			};
		}
	}
}
