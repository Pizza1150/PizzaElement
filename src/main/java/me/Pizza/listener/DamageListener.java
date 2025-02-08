package me.Pizza.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;

import io.lumine.mythic.lib.MythicLib;
import io.lumine.mythic.lib.api.event.PlayerAttackEvent;
import io.lumine.mythic.lib.damage.AttackMetadata;
import io.lumine.mythic.lib.damage.DamageMetadata;
import io.lumine.mythic.lib.damage.DamageType;
import io.lumine.mythic.lib.element.Element;
import me.Pizza.PizzaElement;

public class DamageListener implements Listener {

	private static final String[] ELEMENTS = {"FIRE", "ICE", "EARTH", "WIND", "THUNDER", "WATER", "DARKNESS", "LIGHTNESS"};
	private static final Element FIRE = Element.valueOf("FIRE");
	private static final Element ICE = Element.valueOf("ICE");
	private static final Element EARTH = Element.valueOf("EARTH");
	private static final Element WIND = Element.valueOf("WIND");
	private static final Element THUNDER = Element.valueOf("THUNDER");
	private static final Element WATER = Element.valueOf("WATER");
	private static final Element DARKNESS = Element.valueOf("DARKNESS");
	private static final Element LIGHTNESS = Element.valueOf("LIGHTNESS");

	@EventHandler
	public void onAttack(PlayerAttackEvent event) {
		Entity target = event.getEntity();

		if (target instanceof Player) {
			return;
		}

		DamageMetadata damage = event.getDamage();

		// FIRE
		if (target.getName().contains("")) {
			if (damage.hasElement(WATER)) damage.add(0.4 * damage.getDamage(WATER), WATER, DamageType.SKILL);
			if (damage.hasElement(ICE)) damage.add(-(0.4 * damage.getDamage(ICE)), ICE, DamageType.SKILL);

			if (damage.hasElement(DARKNESS)) damage.add((0.2 * damage.getDamage(DARKNESS)), DARKNESS, DamageType.SKILL);
			if (damage.hasElement(LIGHTNESS)) damage.add((0.2 * damage.getDamage(LIGHTNESS)), LIGHTNESS, DamageType.SKILL);
		}

		// WATER
		else if (target.getName().contains("")) {
			if (damage.hasElement(THUNDER)) damage.add((0.4 * damage.getDamage(THUNDER)), THUNDER, DamageType.SKILL);
			if (damage.hasElement(EARTH)) damage.add(-(0.4 * damage.getDamage(EARTH)), EARTH, DamageType.SKILL);

			if (damage.hasElement(DARKNESS)) damage.add((0.2 * damage.getDamage(DARKNESS)), DARKNESS, DamageType.SKILL);
			if (damage.hasElement(LIGHTNESS)) damage.add((0.2 * damage.getDamage(LIGHTNESS)), LIGHTNESS, DamageType.SKILL);
		}

		// ICE
		else if (target.getName().contains("")) {
			if (damage.hasElement(FIRE)) damage.add((0.4 * damage.getDamage(FIRE)), FIRE, DamageType.SKILL);
			if (damage.hasElement(WIND)) damage.add(-(0.4 * damage.getDamage(WIND)), WIND, DamageType.SKILL);

			if (damage.hasElement(DARKNESS)) damage.add((0.2 * damage.getDamage(DARKNESS)), DARKNESS, DamageType.SKILL);
			if (damage.hasElement(LIGHTNESS)) damage.add((0.2 * damage.getDamage(LIGHTNESS)), LIGHTNESS, DamageType.SKILL);
		}

		// THUNDER
		else if (target.getName().contains("")) {
			if (damage.hasElement(EARTH)) damage.add((0.4 * damage.getDamage(EARTH)), EARTH, DamageType.SKILL);
			if (damage.hasElement(WATER)) damage.add(-(0.4 * damage.getDamage(WATER)), WATER, DamageType.SKILL);

			if (damage.hasElement(DARKNESS)) damage.add((0.2 * damage.getDamage(DARKNESS)), DARKNESS, DamageType.SKILL);
			if (damage.hasElement(LIGHTNESS)) damage.add((0.2 * damage.getDamage(LIGHTNESS)), LIGHTNESS, DamageType.SKILL);
		}

		// EARTH
		else if (target.getName().contains("")) {
			if (damage.hasElement(WIND)) damage.add((0.4 * damage.getDamage(WIND)), WIND, DamageType.SKILL);
			if (damage.hasElement(THUNDER)) damage.add(-(0.4 * damage.getDamage(THUNDER)), THUNDER, DamageType.SKILL);

			if (damage.hasElement(DARKNESS)) damage.add((0.2 * damage.getDamage(DARKNESS)), DARKNESS, DamageType.SKILL);
			if (damage.hasElement(LIGHTNESS)) damage.add((0.2 * damage.getDamage(LIGHTNESS)), LIGHTNESS, DamageType.SKILL);
		}

		// WIND
		else if (target.getName().contains("")) {
			if (damage.hasElement(ICE)) damage.add((0.4 * damage.getDamage(ICE)), ICE, DamageType.SKILL);
			if (damage.hasElement(EARTH)) damage.add(-(0.4 * damage.getDamage(EARTH)), EARTH, DamageType.SKILL);

			if (damage.hasElement(DARKNESS)) damage.add((0.2 * damage.getDamage(DARKNESS)), DARKNESS, DamageType.SKILL);
			if (damage.hasElement(LIGHTNESS)) damage.add((0.2 * damage.getDamage(LIGHTNESS)), LIGHTNESS, DamageType.SKILL);
		}

		// DARKNESS
		else if (target.getName().contains("")) {
			if (damage.hasElement(LIGHTNESS)) damage.add(0.2 * damage.getDamage(LIGHTNESS), LIGHTNESS, DamageType.SKILL);
			if (damage.hasElement(DARKNESS)) damage.add(-(0.4 * damage.getDamage(DARKNESS)), DARKNESS, DamageType.SKILL);

			if (damage.hasElement(FIRE)) damage.add(-(0.2 * damage.getDamage(FIRE)), FIRE, DamageType.SKILL);
			if (damage.hasElement(WATER)) damage.add(-(0.2 * damage.getDamage(WATER)), WATER, DamageType.SKILL);
			if (damage.hasElement(ICE)) damage.add(-(0.2 * damage.getDamage(ICE)), ICE, DamageType.SKILL);
			if (damage.hasElement(THUNDER)) damage.add(-(0.2 * damage.getDamage(THUNDER)), THUNDER, DamageType.SKILL);
			if (damage.hasElement(EARTH)) damage.add(-(0.2 * damage.getDamage(EARTH)), EARTH, DamageType.SKILL);
			if (damage.hasElement(WIND)) damage.add(-(0.2 * damage.getDamage(WIND)), WIND, DamageType.SKILL);
		}

		// LIGHTNESS
		else if (target.getName().contains("")) {
			if (damage.hasElement(DARKNESS)) damage.add(0.2 * damage.getDamage(DARKNESS), DARKNESS, DamageType.SKILL);
			if (damage.hasElement(LIGHTNESS)) damage.add(-(0.4 * damage.getDamage(LIGHTNESS)), LIGHTNESS, DamageType.SKILL);

			if (damage.hasElement(FIRE)) damage.add(-(0.2 * damage.getDamage(FIRE)), FIRE, DamageType.SKILL);
			if (damage.hasElement(WATER)) damage.add(-(0.2 * damage.getDamage(WATER)), WATER, DamageType.SKILL);
			if (damage.hasElement(ICE)) damage.add(-(0.2 * damage.getDamage(ICE)), ICE, DamageType.SKILL);
			if (damage.hasElement(THUNDER)) damage.add(-(0.2 * damage.getDamage(THUNDER)), THUNDER, DamageType.SKILL);
			if (damage.hasElement(EARTH)) damage.add(-(0.2 * damage.getDamage(EARTH)), EARTH, DamageType.SKILL);
			if (damage.hasElement(WIND)) damage.add(-(0.2 * damage.getDamage(WIND)), WIND, DamageType.SKILL);
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Entity attacker = event.getDamageSource().getCausingEntity();

		if (attacker == null || attacker instanceof Player) {
			return;
		}

		// Check if mob has element
		final String element = getElement(attacker);

		if (element == null) {
			return;
		}

		// Check if victim is a player
		Entity victim = event.getEntity();

		if (!(victim instanceof Player)) {
			return;
		}

		// Apply element damage
		event.setCancelled(true);

		new BukkitRunnable() {
			@Override
			public void run() {
				DamageMetadata damageMetadata = new DamageMetadata(event.getFinalDamage(), Element.valueOf(element), DamageType.SKILL);
				AttackMetadata attackMetadata = new AttackMetadata(damageMetadata, (LivingEntity) victim, null);

				MythicLib.plugin.getDamage().registerAttack(attackMetadata, false);
			}
		}.runTaskLater(PizzaElement.getPlugin(), 1);
	}

	private String getElement(Entity attacker) {
		for (String element : ELEMENTS) {
			if (attacker.getName() != null && attacker.getName().contains(element)) {
				return element;
			}
		}

		return null;
	}
}
