package net.ddns.maikeio.lumberaxe;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.inventory.ItemStack;

public class LumberAxeListener implements Listener {

	@EventHandler
	public void LeavesDecayEvent​(LeavesDecayEvent event) {
		if (((int) (Math.random() * 10000)) == 5)
			event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(),
					new ItemStack(Material.STONE));
	}
}
