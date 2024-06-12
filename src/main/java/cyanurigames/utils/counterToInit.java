package cyanurigames.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.atomic.AtomicInteger;

import static org.bukkit.Bukkit.getOnlinePlayers;
import static org.bukkit.Bukkit.getScheduler;

public class counterToInit {

    public static void startCountdown(Plugin plugin, AtomicInteger time) {
        getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            if (time.get() > -1) {
                for(Player pl: getOnlinePlayers()){
                    String init = "§x§F§F§E§2§5§9§lI§x§F§F§D§F§5§9§ln§x§F§F§D§B§5§8§li§x§F§F§D§8§5§8§lc§x§F§F§D§4§5§7§li§x§F§F§D§1§5§7§la§x§F§F§C§D§5§6§ln§x§F§F§C§A§5§6§ld§x§F§F§C§6§5§5§lo §x§F§F§B§F§5§4§le§x§F§F§B§C§5§4§ll §x§F§F§B§5§5§3§lj§x§F§F§B§1§5§2§lu§x§F§F§A§E§5§2§le§x§F§F§A§A§5§1§lg§x§F§F§A§7§5§1§lo";
                    pl.sendTitle(String.valueOf(time.get()) , init, 10, 20, 0);
                    pl.playSound(pl.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 1, 1);
                }
                time.decrementAndGet();
            }
        }, 0L, 20L);
    }
}