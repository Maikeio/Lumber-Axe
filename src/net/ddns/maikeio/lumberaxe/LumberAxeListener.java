package net.ddns.maikeio.lumberaxe;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class LumberAxeListener implements Listener {

	private LumberAxeHandler handler;

	public LumberAxeListener(LumberAxeHandler handler) {
		this.handler = handler;
	}

	@EventHandler
	public void LeavesDecayEvent​(LeavesDecayEvent event) {
		if (((int) (Math.random() * 10000)) == 5)
			event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(),
					new ItemStack(Material.STONE));
	}

	@EventHandler
	public void BlockBreakEvent(org.bukkit.event.block.BlockBreakEvent event) {
		if (event.getPlayer().getInventory().getItemInMainHand() == null)
			return;
		ItemStack axe = event.getPlayer().getInventory().getItemInMainHand();
		if (!axe.getItemMeta().hasCustomModelData() || axe.getType() != Material.NETHERITE_AXE)
			return;
		if (axe.getItemMeta().getCustomModelData() != LumberAxeHandler.LUMBERAXE().getItemMeta().getCustomModelData())
			return;
		if (((Damageable) axe.getItemMeta()).getDamage() == 2030) {
			event.setCancelled(true);
			return;
		}
			
		handler.LumberAxedUsed(event.getBlock(), event.getPlayer());
	}
}
