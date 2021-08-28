package es.mithrandircraft.disablemossspread;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class DisableMossSpread extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        //Events:
        getServer().getPluginManager().registerEvents(this, this);
    }

    //Block moss spreading with bonemeal
    @EventHandler
    public void MossSpreadEvent(PlayerInteractEvent ev)
    {
        if((ev.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BONE_MEAL)
                ||
            ev.getPlayer().getInventory().getItemInOffHand().getType().equals(Material.BONE_MEAL))
                &&
            ev.getAction().equals(Action.RIGHT_CLICK_BLOCK)
                &&
            ev.getClickedBlock().getType().equals(Material.MOSS_BLOCK)
            )
                                ev.setCancelled(true);
    }
}
