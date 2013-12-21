package models.magic.enchantments;

public enum EnchantmentTypes {
	ICE("frosted", "of freezing", 1.2f, 1, 1, 1.4f, 1.5f, .95f, 1, 1.1f), 
	FIRE("burning", "of flames", 1.5f, 1, 1.1f, 1, 1, 1, 1, 1), 
	AIR("gale force", "of the hurricane", 1.1f, 1.5f, 1.5f, 1.2f, 1, 1.5f, 1, 1), 
	WATER("deluge", "of torrential flooding", 1.3f, 1.2f, 1, 1, 1.1f, 1.1f, 1, 1.1f), 
	POISON("venomous", "of vipers", 1.5f, 1, 1, 1, 1, 1, 1, 1), 
	REJUVENATING("healing", "of mending", .8f, 1.3f, 1.3f, 1.2f, 1, 1.1f, 1, 1), 
	HOLY("angelic", "of the angels", 1, 1.3f, 1.3f, 1.3f, 1.5f, 1.3f, .5f, .5f), 
	DARK("tormented", "of the abyss", 1.2f, .9f, 1.3f, 1.3f, 1.1f, .9f, 1.2f, 1.2f);
	
	public final String prefix;
	public final String postfix;
	// -- weapon mods -- //
	public final float dmgMod;
	public final float speedMod;
	public final float rangeMod;
	
	// -- armor mods -- //
	public final float acMod;
	public final float deflecMod;
	public final float dexMod;
	public final float volMod;
	public final float wghtMod;
	
	private EnchantmentTypes(String prefix, String postfix, float dmgMod,
			float speedMod, float rangeMod, float acMod, float deflecMod, float dexMod,
			float volMod, float wghtMod) {
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
}