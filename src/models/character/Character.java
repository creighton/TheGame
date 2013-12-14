package models.character;

import models.character.attributes.AbilityScores;
import models.character.attributes.Language;
import models.character.attributes.skills.Skills;
import models.character.items.exceptions.NoWeaponException;
import models.character.race.Race;
import models.items.Item;

public class Character {
	public enum Gender {MALE, FEMALE};
	
	protected String charName;
	protected Race charRace;
	protected Gender gender;
	protected int height;
	protected int weight;
	
	protected int xp = 0;
	
	protected AbilityScores abilityScores;
	
	protected Skills skills;
	
	private int baseHP = 100;
	private int baseAC = 10;
	private int baseDamage = 1;
	
//	protected Language[] languages;
	
	public Character(String name, Race race, Gender gender, int height, int weight, AbilityScores ab) {
		charName = name;
		charRace = race;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.abilityScores = ab;
		skills = null;
		baseHP = (int)((baseHP + abilityScores.getConstitution()) * charRace.getHpMod());
		baseAC = (int)((baseAC + abilityScores.getDexterity()) * charRace.getAcMod());
		baseDamage = (int)((baseDamage + abilityScores.getStrength()/33) * charRace.getDamageMod());
	}
	
	public int getStrength() {
		return Math.round(abilityScores.getStrength() * charRace.getStrMod());
	}

	public int getDexterity() {
		return Math.round(abilityScores.getDexterity() * charRace.getDexMod());
	}

	public int getConstitution() {
		return Math.round(abilityScores.getConstitution() * charRace.getConMod());
	}

	public int getIntelligence() {
		return Math.round(abilityScores.getIntelligence() * charRace.getIntMod());
	}

	public int getWisdom() {
		return Math.round(abilityScores.getWisdom() * charRace.getWisMod());
	}

	public int getCharisma() {
		return Math.round(abilityScores.getCharisma() * charRace.getChrMod());
	}
	
	public Item getCurrentWeapon() throws NoWeaponException {
		return (isWeaponEquipped()) ? getEquippedWeapon() : charRace.getBaseWeapon();
	}
	
	public int getAC() {
		return baseAC;
	}
	
	public int getHP() {
		return baseHP;// should we add weapon/armor mods
	}
	
	private boolean isWeaponEquipped() {
		return false;
	}
	
	private Item getEquippedWeapon() {
		return null;
	}
	
	public String toString() {
		return "Hi I'm " + charName + "\n" +
	           "A " + height + "ft, " + weight + "lb " + charRace.getName() + "\n" +
			   "Hit Points: " + getHP() + "\n" +
	           "AC: " + getAC() + "\n" +
			   "Abilities:\n" + 
				"Strength: " + getStrength() + "\n" + 
				"Dexterity: " + getDexterity() + "\n" +
				"Constitution: " + getConstitution() + "\n" +
				"Intelligence: " + getIntelligence() + "\n" +
				"Wisdom: " + getWisdom() + "\n" +
				"Charisma: " + getCharisma() + "\n";
	}
}
