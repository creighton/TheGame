package models.items;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class FoundryTest {

	@Test
	public void testGetBaseWeaponHands() {
		Item hand = Foundry.getBaseWeapon(WeaponType.HANDS);
		System.out.println(hand);
		assertEquals("hands", hand.name);
		assertEquals("hands", hand.getName());
	}
	@Test
	public void testGetBaseWeaponHead() {
		Item head = Foundry.getBaseWeapon(WeaponType.HEAD);
		System.out.println(head);
		assertEquals("head", head.name);
		assertEquals("head", head.getName());
	}
	@Test
	public void testGetMagicWeapon() {
		Item magicWeapon = Foundry.getMagicWeapon(new Random());
		System.out.println(magicWeapon);
//		assertEquals("hand", magicWeapon.name);
//		assertEquals("head", magicWeapon.getName());
	}@Test
	public void testGetBaseWeaponFeet() {
		Item feet = Foundry.getBaseWeapon(WeaponType.FEET);
		System.out.println(feet);
		assertEquals("feet", feet.name);
		assertEquals("feet", feet.getName());
	}
	@Test
	public void testGetBaseWeaponClaws() {
		Item claws = Foundry.getBaseWeapon(WeaponType.CLAWS);
		System.out.println(claws);
		assertEquals("claws", claws.name);
		assertEquals("claws", claws.getName());
	}

	@Test
	public void testGetSpecialWeapon() {
		Item spec = Foundry.getSpecialWeapon(WeaponType.BREATH);
		System.out.println(spec);
		assertEquals("breath", spec.name);
		assertEquals("fire breath", spec.getName());
	}
	
	@Test
	public void testCommonWeapon01() {
		Item itm = Foundry.getCommonWeapon(new Random());
		System.out.println(itm);
	}

}
