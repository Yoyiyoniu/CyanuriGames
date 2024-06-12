package cyanurigames.utils;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class utils implements Listener {
    public static String prefix = "§x§5§E§7§C§C§8§l[§x§5§9§8§4§C§C§lC§x§5§5§8§B§D§0§ly§x§5§0§9§3§D§4§la§x§4§C§9§A§D§7§ln§x§4§7§A§2§D§B§lu§x§4§2§A§A§D§F§lr§x§3§E§B§1§E§3§li§x§3§9§B§9§E§7§lG§x§3§4§C§1§E§B§la§x§3§0§C§8§E§E§lm§x§2§B§D§0§F§2§le§x§2§7§D§7§F§6§ls§x§2§2§D§F§F§A§l] §f";

    public static void cmd(String message){
        Bukkit.getServer().getConsoleSender().sendMessage(prefix + message);
    }

}
