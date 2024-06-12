package cyanurigames.core;

import cyanurigames.minigames.hotJuncake;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new hotJuncake(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
