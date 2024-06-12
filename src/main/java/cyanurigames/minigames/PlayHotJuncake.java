package cyanurigames.minigames;

import cyanurigames.utils.delay;
import cyanurigames.utils.utils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.*;

import static cyanurigames.utils.utils.cmd;
import static org.bukkit.Bukkit.getOnlinePlayers;

public class PlayHotJuncake implements Listener {
    private final Set<UUID> activePlayers = new HashSet<>();
    private int index;
    private boolean ActivateCookEvent = false;
    private final int itemsSize;

    List<Material> items = Arrays.asList(
            Material.CAKE,
            Material.CROSSBOW
    );

    public PlayHotJuncake() {
        this.itemsSize = items.size();
    }

    public void initCookEvent() {
        ActivateCookEvent = true;
        cmd("Init Cook Event");
        index = (int) (Math.random() * itemsSize);
        utils.cmd("Item to cook: " + items.get(index));
        for(Player pl: getOnlinePlayers()){
            pl.sendMessage("§cCocina un : " + items.get(index));
            pl.sendTitle("§cCocina un : " + items.get(index), "§cRapido! Se acaba el tiempo!", 0, 60, 0);
            pl.playSound(pl.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
        }
    }

    @EventHandler
    void onMovePlayer(PlayerMoveEvent e){
        if(!ActivateCookEvent) return;
        cmd("Player Move Event");
        Player p = e.getPlayer();
        if(!activePlayers.contains(p.getUniqueId())){
            activePlayers.add(p.getUniqueId());
            cmd("Player registered in list");
            p.sendTitle("§cCocina un : " + items.get(index), "§cRapido! Se acaba el tiempo!", 0, 60, 0);
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
        }
    }

    @EventHandler
    void onHotCreateItem(PrepareItemCraftEvent e){
        if(!ActivateCookEvent) return;
        utils.cmd("Prepare Item Craft Event");
        if(e.getRecipe().getResult().getType() == items.get(index)){
            utils.cmd("Item crafted");
            Player p = (Player) e.getView().getPlayer();
            p.sendTitle("§a¡Bien hecho!", "§aHas cocinado un " + items.get(index), 0, 60, 0);
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
            activePlayers.remove(p.getUniqueId());
        }else{
            utils.cmd("Item not crafted");
            Player p = (Player) e.getView().getPlayer();
            p.sendTitle("§c¡Error!", "§cNo es un " + items.get(index), 0, 60, 0);
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
        }
    }
}