package me.Pizza.listener;

import io.lumine.mythic.lib.MythicLib;
import io.lumine.mythic.lib.api.event.PlayerAttackEvent;
import io.lumine.mythic.lib.damage.DamageMetadata;
import io.lumine.mythic.lib.damage.DamageType;
import io.lumine.mythic.lib.element.Element;
import me.Pizza.PizzaElemental;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;

public class AttackListener implements Listener {

	private final PizzaElemental plugin;

	private final Map<Element, Map<Element, Double>> elementInteractions = new HashMap<>();

	public AttackListener(PizzaElemental plugin) {
		this.plugin = plugin;
		loadConfig();
	}

	@EventHandler
	public void onPlayerAttack(PlayerAttackEvent event) {
		Entity victim = event.getEntity();

		// Victim is a player?
		if (victim instanceof Player) {
			return;
		}

		// Victim has element?
		Element mobElement = null;

		for (Element element : MythicLib.plugin.getElements().getAll()) {
			if (victim.getName().contains(element.getLoreIcon())) {
				mobElement = element;
				break;
			}
		}

		if (mobElement == null) {
			return;
		}

		// Get the elements of the attack
		DamageMetadata damage = event.getDamage();
		Element[] attackElements = damage.	collectElements().toArray(new Element[0]);

		// If attack doesn't have any element
		if (attackElements.length == 0) {
			return;
		}

		for (Element attackElement : attackElements) {
			if (elementInteractions.containsKey(mobElement) && elementInteractions.get(mobElement).containsKey(attackElement)) {
				double initialDamage = damage.getDamage(attackElement);
				double extraDamage = elementInteractions.get(mobElement).get(attackElement);
				damage.add(initialDamage * extraDamage, attackElement, DamageType.SKILL);
			}
		}
	}

	private void loadConfig() {
		FileConfiguration config = plugin.getConfig();

		if (config == null || !config.contains("elements")) {
			return;
		}

		for (String elementName : config.getConfigurationSection("elements").getKeys(false)) {
			Element element = MythicLib.plugin.getElements().get(elementName);
			
			if (element == null) {
				continue;
			}

			Map<Element, Double> interactions = new HashMap<>();

			for (String interaction : config.getConfigurationSection("elements." + elementName).getKeys(false)) {
				Element interactionElement = MythicLib.plugin.getElements().get(interaction);

				if (element == null) {
					continue;
				}

				double damage = config.getDouble("elements." + elementName + "." + interaction);
				interactions.put(interactionElement, damage);
			}

			elementInteractions.put(element, interactions);
		}
	}
}
