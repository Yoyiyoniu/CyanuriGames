package cyanurigames;

import cyanurigames.commands.initMinigames;
import cyanurigames.minigames.PlayHotJuncake;
import cyanurigames.utils.delay;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static cyanurigames.utils.utils.cmd;

public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new PlayHotJuncake(), this);
        this.getCommand("CyanuriGames").setExecutor(new initMinigames());
        delay.setPlugin(this);
        initMessage();
    }

    @Override
    public void onDisable() {
        cmd("CyanuriGames Core has been disabled");
    }

    private void initMessage(){
        cmd(" ____                                                ____                                          ");
        cmd("/\\  _`\\                                           __/\\  _`\\                                        ");
        cmd("\\ \\ \\/\\_\\  __  __     __      ___   __  __  _ __ /\\_\\ \\ \\L\\_\\     __      ___ ___      __    ____  ");
        cmd(" \\ \\ \\/_/_/\\ \\/\\ \\  /'__`\\  /' _ `\\/\\ \\/\\ \\/\\`'__/\\ \\ \\ \\L_L   /'__`\\  /' __` __`\\  /'__`\\ /',__\\ ");
        cmd("  \\ \\ \\L\\ \\ \\ \\_\\ \\/\\ \\L\\.\\_/\\ \\/\\ \\ \\ \\_\\ \\ \\ \\/ \\ \\ \\ \\/, \\/\\ \\L\\.\\_/\\ \\/\\ \\/\\ \\/\\  __//\\__, `\\");
        cmd("   \\ \\____/\\/`____ \\ \\__/\\.\\_\\ \\_\\ \\_\\ \\____/\\ \\_\\  \\ \\_\\ \\____/\\ \\__/\\.\\_\\ \\_\\ \\_\\ \\_\\ \\____\\/\\____/");
        cmd("    \\/___/  `/___/> \\/__/\\/_/\\/_/\\/_/\\/___/  \\/_/   \\/_/\\/___/  \\/__/\\/_/\\/_/\\/_/\\/_/\\/____/\\/___/ ");
        cmd("               /\\___/                                                                              ");
        cmd("               \\/__/                                                                               ");
    }
}
