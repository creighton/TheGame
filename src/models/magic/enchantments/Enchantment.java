package models.magic.enchantments;

import java.util.ArrayList;
import java.util.Arrays;

public class Enchantment {
	protected ArrayList<EnchantmentTypes> types;
	protected String prefix;
	protected String postfix;
	// -- weapon mods -- //
	protected float dmgMod;
	protected float speedMod;
	protected float rangeMod;
	
	// -- armor mods -- //
	protected float acMod;
	protected float deflecMod;
	protected float dexMod;
	protected float volMod;
	protected float wghtMod;
	
	public Enchantment(EnchantmentTypes[] types, String prefix, String postfix, float dmgMod,
			float speedMod, float rangeMod, float acMod, float deflecMod, float dexMod,
			float volMod, float wghtMod) {
		this.types = new ArrayList<EnchantmentTypes>(Arrays.asList(types));
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
	
	public void setTypes(ArrayList<EnchantmentTypes> types) {
		this.types = types;
	}

	public void setDmgMod(int dmgMod) {
		this.dmgMod = dmgMod;
	}

	public void setSpeedMod(float speedMod) {
		this.speedMod = speedMod;
	}

	public void setRangeMod(int rangeMod) {
		this.rangeMod = rangeMod;
	}

	public void setAcMod(int acMod) {
		this.acMod = acMod;
	}

	public void setDeflecMod(int deflecMod) {
		this.deflecMod = deflecMod;
	}

	public void setDexMod(int dexMod) {
		this.dexMod = dexMod;
	}

	public void setVolMod(int volMod) {
		this.volMod = volMod;
	}

	public void setWghtMod(int wghtMod) {
		this.wghtMod = wghtMod;
	}

	public ArrayList<EnchantmentTypes> getTypes() {
		return types;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getPostfix() {
		return postfix;
	}
	
	public float getDmgMod() {
		return dmgMod;
	}
	
	public float getSpeedMod() {
		return speedMod;
	}
	
	public float getRangeMod() {
		return rangeMod;
	}
	
	public float getAcMod() {
		return acMod;
	}
	
	public float getDeflecMod() {
		return deflecMod;
	}
	
	public float getDexMod() {
		return dexMod;
	}
	
	public float getVolMod() {
		return volMod;
	}
	
	public float getWghtMod() {
		return wghtMod;
	}
	
	public String toString() {
		return types.toString();
	}
}
