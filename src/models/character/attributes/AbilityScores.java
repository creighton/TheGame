package models.character.attributes;

public class AbilityScores {
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	
	public AbilityScores(int str, int dex, int con, int intel, int wis, int chr) {
		strength = str;
		dexterity = dex;
		constitution = con;
		intelligence = intel;
		wisdom = wis;
		charisma = chr;
	}

	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getCharisma() {
		return charisma;
	}
	
	public String toString() {
		return "Abilities:\n" + 
				"Strength: " + getStrength() + "\n" + 
				"Dexterity: " + getDexterity() + "\n" +
				"Constitution: " + getConstitution() + "\n" +
				"Intelligence: " + getIntelligence() + "\n" +
				"Wisdom: " + getWisdom() + "\n" +
				"Charisma: " + getCharisma();
	}
}
