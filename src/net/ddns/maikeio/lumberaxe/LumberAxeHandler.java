package net.ddns.maikeio.lumberaxe;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LumberAxeHandler {

	public static ItemStack LUMBERAXE() {
		ItemStack item = new ItemStack(Material.NETHERITE_AXE);
		ItemMeta meta = item.getItemMeta();

		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.WHITE + "Lamber Axe");

		// Discription of the Item
		List<String> discription = new ArrayList<String>();
		discription.add(ChatColor.DARK_AQUA + "this axe is used");
		discription.add(ChatColor.DARK_AQUA + "to cut trees faster");
		meta.setLore(discription);
		item.setItemMeta(meta);
		return item;

	}

	public static ItemStack UPGRADE_ITEM() {
		ItemStack item = new ItemStack(Material.COMMAND_BLOCK);
		ItemMeta meta = item.getItemMeta();

		meta.setCustomModelData(2);
		meta.setDisplayName(ChatColor.WHITE + "Upgrade Module");

		// Discription of the Item
		List<String> discription = new ArrayList<String>();
		discription.add(ChatColor.DARK_AQUA + "this module is used");
		discription.add(ChatColor.DARK_AQUA + "to upgrade a dropper");
		discription.add(ChatColor.DARK_AQUA + "to an autocrafter");
		meta.setLore(discription);
		item.setItemMeta(meta);
		return item;
	}
}
