package net.ddns.maikeio.lumberaxe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import net.ddns.maikeio.blatt.Blatt;
import net.ddns.maikeio.nbtrecipe.CraftingHandler;
import net.ddns.maikeio.nbtrecipe.SmithingNBTRecipe;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		LumberAxeHandler handler = new LumberAxeHandler();
		getServer().getPluginManager().registerEvents(new LumberAxeListener(handler), this);

		// adds the Custom Recpies
		recipes();
	}

	private void recipes() {

		NamespacedKey AUTOCRAFTER_UPGRADE_key = new NamespacedKey(this, "Autocrafter_Upgrade");
		ShapedRecipe AUTOCRAFTER_UPGRADE_recipe = new ShapedRecipe(AUTOCRAFTER_UPGRADE_key,
				LumberAxeHandler.UPGRADE_ITEM());

		// Pattern
		AUTOCRAFTER_UPGRADE_recipe.shape("S");

		// Definition
		AUTOCRAFTER_UPGRADE_recipe.setIngredient('S', Material.STONE);
		Bukkit.addRecipe(AUTOCRAFTER_UPGRADE_recipe);

		// NBTRecipeHandler recipeHandler = new NBTRecipeHandler(this);
		SmithingNBTRecipe lumberRecipe = new SmithingNBTRecipe("Lumber-Axe", LumberAxeHandler.UPGRADE_ITEM(),
				LumberAxeHandler.LUMBERAXE());
		
		Blatt blatt = ((Blatt) Bukkit.getPluginManager().getPlugin("Blatt"));
		blatt.getNBTRecipeHandler().addSmithingNBTRecipe(lumberRecipe);
		CraftingHandler d = new CraftingHandler(null);
		d.getSmithingTableResult(null, null);
		
	}
}
