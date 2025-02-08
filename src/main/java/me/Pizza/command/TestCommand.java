package me.Pizza.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import io.lumine.mythic.lib.MythicLib;
import io.lumine.mythic.lib.damage.AttackMetadata;
import io.lumine.mythic.lib.damage.DamageMetadata;
import io.lumine.mythic.lib.damage.DamageType;
import io.lumine.mythic.lib.element.Element;

public class TestCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
		LivingEntity target = (LivingEntity) commandSender;

		DamageMetadata damageMetadata = new DamageMetadata(10, Element.valueOf("LIGHTNESS"), DamageType.SKILL);
		AttackMetadata attackMetadata = new AttackMetadata(damageMetadata, target, null);

		MythicLib.plugin.getDamage().registerAttack(attackMetadata, false);	
		
		return true;
	}
}
