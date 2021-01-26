package net.ddns.maikeio.lumberaxe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		// adds Listener for AutoCrafter
		getServer().getPluginManager().registerEvents(
				new SmithingTableRecupeListener(LumberAxeHandler.UPGRADE_ITEM(), LumberAxeHandler.LUMBERAXE()), this);
		getServer().getPluginManager().registerEvents(
				new LumberAxeListener(), this);

		// adds the Custom Recpies
		recipes();

		// test for save Folder
//		if (!new File("plugins/AutoCrafter").exists())
//			new File("plugins/AutoCrafter").mkdirs();
	}

	private void recipes() {

		// AUTOCRAFTER_UPGRADE Recipe
		/*
		 * NamespacedKey LUMBERAXE_key = new NamespacedKey(this, "Lumber-Axe");
		 * SmithingRecipe LUMBERAXE_recipe = new SmithingRecipe(LUMBERAXE_key,
		 * LumberAxeHandler.LUMBERAXE(), new
		 * RecipeChoice.MaterialChoice(Material.NETHERITE_AXE), new
		 * RecipeChoice.MaterialChoice(Material.COMMAND_BLOCK));
		 * Bukkit.addRecipe(LUMBERAXE_recipe);
		 */

		NamespacedKey AUTOCRAFTER_UPGRADE_key = new NamespacedKey(this, "Autocrafter_Upgrade");
		ShapedRecipe AUTOCRAFTER_UPGRADE_recipe = new ShapedRecipe(AUTOCRAFTER_UPGRADE_key,
				LumberAxeHandler.UPGRADE_ITEM());

		// Pattern
		AUTOCRAFTER_UPGRADE_recipe.shape("S");

		// Definition
		AUTOCRAFTER_UPGRADE_recipe.setIngredient('S', Material.STONE);
		Bukkit.addRecipe(AUTOCRAFTER_UPGRADE_recipe);
	}
}
