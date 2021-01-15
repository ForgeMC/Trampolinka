package fmc.trampolinka;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.Random;

public class TrampolineListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Location location = player.getLocation().clone().subtract(0.0D, 1.0D, 0.0D);
        Block block = location.getBlock();
        Random r = new Random();
        Double randomHeight = 0.7 + (1.6 - 0.7) * r.nextDouble();

        if (block.getType().equals(Material.SLIME_BLOCK)) {
            if (player.hasPermission("fmc.trampolinka")) {
                player.setVelocity(new Vector(player.getVelocity().getX(), randomHeight, player.getVelocity().getZ()));
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 5.0F, 2.0F);
            } else {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD + "ForgeMC " + ChatColor.GRAY + "» " + ChatColor.WHITE + "Trampolina jest dostępna tylko dla osób z rangą Diamond");
            }
        }

    }
}
