package cyanurigames.minigames;

import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class hotJuncake implements Listener {

    List<Material> items = Arrays.asList(
            Material.CAKE,
            Material.CROSSBOW
    );

    private boolean isHotCreateItemActive = false;

    @EventHandler
    public void onHotJunCakeStart(PlayerJoinEvent e){

        Player p = e.getPlayer();
        AtomicInteger NumberTime = new AtomicInteger(10);
        do{
            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask((Plugin) this, () -> {
                p.sendMessage("§a¡Bienvenido a HotJunCake!");
                p.sendMessage("§aEl juego comenzará en " + NumberTime + " segundos");
                NumberTime.getAndDecrement();
            }, 20L);
        }while(NumberTime.get() > 0);
        activateHotCreateItem();
    }

    @EventHandler
    void onHotCreateItem(PrepareItemCraftEvent e){
        if (!isHotCreateItemActive) {
            return;
        }

        Player p = (Player) e.getView().getPlayer();
        int random = (int) (Math.random() * items.size());
        Material item = items.get(random);

        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.sendTitle("§aHora de Cocinar!", "§b Cocina: " + item.name(), 10, 70, 20);
            pl.playSound(pl.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        }

        if(Objects.requireNonNull(e.getRecipe()).getResult().getType() == item){
            p.sendMessage("§aHas cocinado un item!");
            e.getInventory().setResult(null);
        }
    }

    public void deactivateHotCreateItem() {
        isHotCreateItemActive = false;
    }

    public void activateHotCreateItem() {
        isHotCreateItemActive = true;
    }
}