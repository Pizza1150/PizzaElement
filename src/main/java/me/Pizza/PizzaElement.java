package me.Pizza;

import org.bukkit.plugin.java.JavaPlugin;

import me.Pizza.command.TestCommand;
import me.Pizza.listener.DamageListener;

public final class PizzaElement extends JavaPlugin {

	private static PizzaElement plugin;
	
	@Override
	public void onEnable() {
		plugin = this;

		getServer().getPluginManager().registerEvents(new DamageListener(), this);

		getCommand("test").setExecutor(new TestCommand());
	}

	public static PizzaElement getPlugin() {
		return plugin;
	}
}
