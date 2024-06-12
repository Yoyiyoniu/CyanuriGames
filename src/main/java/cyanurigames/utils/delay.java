package cyanurigames.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.atomic.AtomicInteger;

public class delay {

    private static Plugin plugin;

    public static void setPlugin(Plugin plugin) {
        delay.plugin = plugin;
    }

    public static void addDelayLoopToTask(Runnable task, long initialDelay, long period, int times) {
        AtomicInteger counter = new AtomicInteger(0);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            task.run();
            if (counter.incrementAndGet() == times) {
                Bukkit.getScheduler().cancelTasks(plugin);
            }
        }, initialDelay, period);

    }
    public static void addDelayToTask(Runnable task, long delay) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, task, delay);
    }

}