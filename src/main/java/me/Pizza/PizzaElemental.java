package me.Pizza;

import me.Pizza.listener.AttackListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PizzaElemental extends JavaPlugin {

	@Override
	public void onEnable() {
		saveDefaultConfig();

		getServer().getPluginManager().registerEvents(new AttackListener(this), this);
	}
}
