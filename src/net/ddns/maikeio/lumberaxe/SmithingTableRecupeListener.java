package net.ddns.maikeio.lumberaxe;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SmithingTableRecupeListener implements Listener {

	ItemStack addition;
	ItemStack result;

	SmithingTableRecupeListener(ItemStack addition, ItemStack result) {
		this.addition = addition;
		this.result = result;
	}

	@EventHandler
	public void PrepareSmithingEvent(PrepareSmithingEvent event) {

		// Test for Upgrade Item was put into upgrable Dropper

		if (event.getInventory().getItem(1) == null || event.getInventory().getItem(0) == null)
			return;

		if (event.getInventory().getItem(0).getType() != this.result.getType()
				|| !event.getInventory().getItem(1).isSimilar(this.addition) || event.getInventory().getItem(0)
						.getItemMeta().getCustomModelData() == result.getItemMeta().getCustomModelData())
			return;

		Bukkit.getPlayer("Maikeio").sendMessage("s");

		ItemStack result = event.getInventory().getItem(0).clone();
		ItemMeta meta = result.getItemMeta();
		meta.setCustomModelData(this.result.getItemMeta().getCustomModelData());
		meta.setLore(this.result.getItemMeta().getLore());
		meta.setDisplayName(this.result.getItemMeta().getDisplayName());
		result.setItemMeta(meta);
		event.setResult(result);
		return;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void InventoryEvent(InventoryClickEvent event) {

		// Inventory of deInvstination
		Inventory deInv = event.getInventory();

		// Test for Upgrade Item was put into upgrable Dropper
		if (deInv.getType() != InventoryType.SMITHING || event.getRawSlot() != 2)
			return;

		if (deInv.getItem(2) == null)
			return;

		if (deInv.getItem(2).getType() != this.result.getType()
				|| deInv.getItem(2).getItemMeta().getCustomModelData() != result.getItemMeta().getCustomModelData())
			return;
		event.setCursor(deInv.getItem(2));
		for (int i = 0; i < 2; i++)
			deInv.setItem(i, null);
	}

}
