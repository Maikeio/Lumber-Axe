package net.ddns.maikeio.lumberaxe;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LumberAxeHandler {

	@SuppressWarnings("unchecked")
	public void LumberAxedUsed(Block block, Player player) {
		ItemStack axe = player.getInventory().getItemInMainHand();
		Damageable meta = (Damageable) axe.getItemMeta();
		int lvl = 0;
		lvl += axe.getEnchantmentLevel(Enchantment.DURABILITY);
		ArrayList<Location> breacked = new ArrayList<Location>();
		ArrayList<Location> newBreacked = new ArrayList<Location>();
		breacked.add(block.getLocation());
		for (int i = 0; i < 8; i++) {
			for (int l = 0; l < breacked.size(); l++) {
				Location b = breacked.get(l).clone();
				b.add(0, 1, 0);
				if (AxeableMaterials().contains(b.getBlock().getType())) {
					b.getBlock().breakNaturally();
					newBreacked.add(b.clone());
					if (RemoveDurabilty(lvl))
						meta.setDamage(meta.getDamage() + 1);
				}
				b.subtract(0, 2, 0);
				if (AxeableMaterials().contains(b.getBlock().getType())) {
					b.getBlock().breakNaturally();
					newBreacked.add(b.clone());
					if (RemoveDurabilty(lvl))
						meta.setDamage(meta.getDamage() + 1);
				}
				b.add(1, 1, 0);
				if (AxeableMaterials().contains(b.getBlock().getType())) {
					b.getBlock().breakNaturally();
					newBreacked.add(b.clone());
					if (RemoveDurabilty(lvl))
						meta.setDamage(meta.getDamage() + 1);
				}
				b.subtract(2, 0, 0);
				if (AxeableMaterials().contains(b.getBlock().getType())) {
					b.getBlock().breakNaturally();
					newBreacked.add(b.clone());
					if (RemoveDurabilty(lvl))
						meta.setDamage(meta.getDamage() + 1);
				}
				b.add(1, 0, 1);
				if (AxeableMaterials().contains(b.getBlock().getType())) {
					b.getBlock().breakNaturally();
					newBreacked.add(b.clone());
					if (RemoveDurabilty(lvl))
						meta.setDamage(meta.getDamage() + 1);
				}
				b.subtract(0, 0, 2);
				if (AxeableMaterials().contains(b.getBlock().getType())) {
					b.getBlock().breakNaturally();
					newBreacked.add(b.clone());
					if (RemoveDurabilty(lvl))
						meta.setDamage(meta.getDamage() + 1);
				}
			}
			breacked = (ArrayList<Location>) newBreacked.clone();
			newBreacked.clear();
		}
		if (meta.getDamage() > 2030)
			meta.setDamage(2030);
		axe.setItemMeta((ItemMeta) meta);
	}

	public static ItemStack LUMBERAXE() {
		ItemStack item = new ItemStack(Material.NETHERITE_AXE);
		ItemMeta meta = item.getItemMeta();

		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.WHITE + "Lamber Axe");

		// Discription of the Item
		List<String> discription = new ArrayList<String>();
		discription.add(ChatColor.DARK_AQUA + "this axe is used");
		discription.add(ChatColor.DARK_AQUA + "to cut wood faster");
		meta.setLore(discription);
		item.setItemMeta(meta);
		return item;

	}

	private boolean RemoveDurabilty(double enchantmentLevel) {
		if (Math.random() >= (1 / (enchantmentLevel + 1))) {
			return false;
		} else
			return true;
	}

	static ItemStack UPGRADE_ITEM() {
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

	private static ArrayList<Material> AxeableMaterials() {
		ArrayList<Material> List = new ArrayList<Material>();
		List.add(Material.ACACIA_PLANKS);
		List.add(Material.ACACIA_DOOR);
		List.add(Material.ACACIA_FENCE);
		List.add(Material.ACACIA_FENCE_GATE);
		List.add(Material.ACACIA_LOG);
		List.add(Material.ACACIA_PRESSURE_PLATE);
		List.add(Material.ACACIA_SIGN);
		List.add(Material.ACACIA_STAIRS);

		List.add(Material.ACACIA_TRAPDOOR);
		List.add(Material.ACACIA_BUTTON);
		List.add(Material.ACACIA_WALL_SIGN);
		List.add(Material.STRIPPED_ACACIA_LOG);
		List.add(Material.STRIPPED_ACACIA_WOOD);
		List.add(Material.ACACIA_WOOD);

		List.add(Material.OAK_PLANKS);
		List.add(Material.OAK_DOOR);
		List.add(Material.OAK_FENCE);
		List.add(Material.OAK_FENCE_GATE);
		List.add(Material.OAK_LOG);
		List.add(Material.OAK_PRESSURE_PLATE);
		List.add(Material.OAK_SIGN);
		List.add(Material.OAK_STAIRS);
		List.add(Material.OAK_TRAPDOOR);

		List.add(Material.OAK_TRAPDOOR);
		List.add(Material.OAK_BUTTON);
		List.add(Material.OAK_WALL_SIGN);
		List.add(Material.STRIPPED_OAK_LOG);
		List.add(Material.STRIPPED_OAK_WOOD);
		List.add(Material.OAK_WOOD);

		List.add(Material.BIRCH_PLANKS);
		List.add(Material.BIRCH_DOOR);
		List.add(Material.BIRCH_FENCE);
		List.add(Material.BIRCH_FENCE_GATE);
		List.add(Material.BIRCH_LOG);
		List.add(Material.BIRCH_PRESSURE_PLATE);
		List.add(Material.BIRCH_SIGN);
		List.add(Material.BIRCH_STAIRS);
		List.add(Material.BIRCH_TRAPDOOR);

		List.add(Material.BIRCH_TRAPDOOR);
		List.add(Material.BIRCH_BUTTON);
		List.add(Material.BIRCH_WALL_SIGN);
		List.add(Material.STRIPPED_BIRCH_LOG);
		List.add(Material.STRIPPED_BIRCH_WOOD);
		List.add(Material.BIRCH_WOOD);

		List.add(Material.CRIMSON_PLANKS);
		List.add(Material.CRIMSON_DOOR);
		List.add(Material.CRIMSON_FENCE);
		List.add(Material.CRIMSON_FENCE_GATE);
		List.add(Material.CRIMSON_STEM);
		List.add(Material.CRIMSON_PRESSURE_PLATE);
		List.add(Material.CRIMSON_SIGN);
		List.add(Material.CRIMSON_STAIRS);
		List.add(Material.CRIMSON_TRAPDOOR);

		List.add(Material.CRIMSON_TRAPDOOR);
		List.add(Material.CRIMSON_BUTTON);
		List.add(Material.CRIMSON_WALL_SIGN);
		List.add(Material.STRIPPED_CRIMSON_STEM);
		List.add(Material.STRIPPED_CRIMSON_HYPHAE);
		List.add(Material.CRIMSON_HYPHAE);

		List.add(Material.DARK_OAK_PLANKS);
		List.add(Material.DARK_OAK_DOOR);
		List.add(Material.DARK_OAK_FENCE);
		List.add(Material.DARK_OAK_FENCE_GATE);
		List.add(Material.DARK_OAK_LOG);
		List.add(Material.DARK_OAK_PRESSURE_PLATE);
		List.add(Material.DARK_OAK_SIGN);
		List.add(Material.DARK_OAK_STAIRS);
		List.add(Material.DARK_OAK_TRAPDOOR);

		List.add(Material.DARK_OAK_TRAPDOOR);
		List.add(Material.DARK_OAK_BUTTON);
		List.add(Material.DARK_OAK_WALL_SIGN);
		List.add(Material.STRIPPED_DARK_OAK_LOG);
		List.add(Material.STRIPPED_DARK_OAK_WOOD);
		List.add(Material.DARK_OAK_WOOD);

		List.add(Material.JUNGLE_PLANKS);
		List.add(Material.JUNGLE_DOOR);
		List.add(Material.JUNGLE_FENCE);
		List.add(Material.JUNGLE_FENCE_GATE);
		List.add(Material.JUNGLE_LOG);
		List.add(Material.JUNGLE_PRESSURE_PLATE);
		List.add(Material.JUNGLE_SIGN);
		List.add(Material.JUNGLE_STAIRS);
		List.add(Material.JUNGLE_TRAPDOOR);

		List.add(Material.JUNGLE_TRAPDOOR);
		List.add(Material.JUNGLE_BUTTON);
		List.add(Material.JUNGLE_WALL_SIGN);
		List.add(Material.STRIPPED_JUNGLE_LOG);
		List.add(Material.STRIPPED_JUNGLE_WOOD);
		List.add(Material.JUNGLE_WOOD);

		List.add(Material.SPRUCE_PLANKS);
		List.add(Material.SPRUCE_DOOR);
		List.add(Material.SPRUCE_FENCE);
		List.add(Material.SPRUCE_FENCE_GATE);
		List.add(Material.SPRUCE_LOG);
		List.add(Material.SPRUCE_PRESSURE_PLATE);
		List.add(Material.SPRUCE_SIGN);
		List.add(Material.SPRUCE_STAIRS);
		List.add(Material.SPRUCE_TRAPDOOR);

		List.add(Material.SPRUCE_TRAPDOOR);
		List.add(Material.SPRUCE_BUTTON);
		List.add(Material.SPRUCE_WALL_SIGN);
		List.add(Material.STRIPPED_SPRUCE_LOG);
		List.add(Material.STRIPPED_SPRUCE_WOOD);
		List.add(Material.SPRUCE_WOOD);

		List.add(Material.WARPED_PLANKS);
		List.add(Material.WARPED_DOOR);
		List.add(Material.WARPED_FENCE);
		List.add(Material.WARPED_FENCE_GATE);
		List.add(Material.WARPED_STEM);
		List.add(Material.WARPED_PRESSURE_PLATE);
		List.add(Material.WARPED_SIGN);
		List.add(Material.WARPED_STAIRS);
		List.add(Material.WARPED_TRAPDOOR);

		List.add(Material.WARPED_TRAPDOOR);
		List.add(Material.WARPED_BUTTON);
		List.add(Material.WARPED_WALL_SIGN);
		List.add(Material.STRIPPED_WARPED_STEM);
		List.add(Material.STRIPPED_WARPED_HYPHAE);
		List.add(Material.WARPED_HYPHAE);

		return List;
	}

	public static ArrayList<Material> OakMaterials() {
		ArrayList<Material> List = new ArrayList<Material>();
		List.add(Material.ACACIA_PLANKS);

		return List;
	}
}
