package models.magic.enchantments;

import java.util.ArrayList;
import java.util.Arrays;

public class Enchantment {
	public enum type {ICE, FIRE, AIR, WATER, POISON, REJUVENATING, HOLY, DARK};
	protected ArrayList<type> types;
	protected String prefix;
	protected String postfix;
	// -- weapon mods -- //
	protected int dmgMod;
	protected float speedMod;
	protected int rangeMod;
	
	// -- armor mods -- //
	protected int acMod;
	protected int deflecMod;
	protected int dexMod;
	protected int volMod;
	protected int wghtMod;
	
	public Enchantment(type[] types, String prefix, String postfix, int dmgMod,
			float speedMod, int rangeMod, int acMod, int deflecMod, int dexMod,
			int volMod, int wghtMod) {
		this.types = new ArrayList<Enchantment.type>(Arrays.asList(types));
		this.prefix = prefix;
		this.postfix = postfix;
		this.dmgMod = dmgMod;
		this.speedMod = speedMod;
		this.rangeMod = rangeMod;
		this.acMod = acMod;
		this.deflecMod = deflecMod;
		this.dexMod = dexMod;
		this.volMod = volMod;
		this.wghtMod = wghtMod;
	}
	
	public ArrayList<type> getTypes() {
		return types;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getPostfix() {
		return postfix;
	}
	
	public int getDmgMod() {
		return dmgMod;
	}
	
	public float getSpeedMod() {
		return speedMod;
	}
	
	public int getRangeMod() {
		return rangeMod;
	}
	
	public int getAcMod() {
		return acMod;
	}
	
	public int getDeflecMod() {
		return deflecMod;
	}
	
	public int getDexMod() {
		return dexMod;
	}
	
	public int getVolMod() {
		return volMod;
	}
	
	public int getWghtMod() {
		return wghtMod;
	}
	
	public String toString() {
		return types.toString();
	}
}
