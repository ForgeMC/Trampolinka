package fmc.trampolinka;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Trampolinka extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new TrampolineListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
