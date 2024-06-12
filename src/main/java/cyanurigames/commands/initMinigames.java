package cyanurigames.commands;

import cyanurigames.Main;
import cyanurigames.minigames.PlayHotJuncake;
import cyanurigames.utils.counterToInit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.atomic.AtomicInteger;

import static cyanurigames.utils.delay.addDelayToTask;

public class initMinigames implements CommandExecutor {
    private final PlayHotJuncake playHotJuncake = new PlayHotJuncake();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            AtomicInteger time = new AtomicInteger(10);
            counterToInit.startCountdown(Main.getPlugin(Main.class), time);
            addDelayToTask(playHotJuncake::initCookEvent, 200);
        }
        return false;
    }
}