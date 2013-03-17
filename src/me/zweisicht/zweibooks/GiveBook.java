package me.zweisicht.zweibooks;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class GiveBook {
	
	public static void CreateIt(String bookTitel, List<String> pages, Player player, Material bookTyp) {
		
		ItemStack book = new ItemStack(bookTyp);
		BookMeta meta = (BookMeta)book.getItemMeta();
		meta.setTitle(bookTitel);
		meta.setAuthor("ZweiBooks");
		meta.setPages(pages);

		book.setItemMeta(meta);
		player.getInventory().addItem(book);
		player.sendMessage("Du findest das Buch '" + bookTitel + "' nun in deinem Inventar.");
	}
}
