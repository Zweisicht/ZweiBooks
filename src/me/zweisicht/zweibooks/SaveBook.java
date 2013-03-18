package me.zweisicht.zweibooks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class SaveBook {

	public static void CopyIT(Player player) throws IOException{
		

		
		ItemStack book = player.getItemInHand();
		BookMeta meta = (BookMeta)book.getItemMeta();
		
		int length = meta.getPageCount();
		File f;
		f= new File("plugins/ZweiData/Books/" + meta.getTitle());
		f.createNewFile();
		FileWriter fstream = new FileWriter("plugins/ZweiData/Books/" + meta.getTitle());
		BufferedWriter out = new BufferedWriter(fstream);
		for(int i = 0; i<length; i++){
			out.write(meta.getPage(i+1).toString() + "\n");
			out.write("<p>\n");
		}
		out.close();
		player.sendMessage("Das Buch wurde in die Bibliothek aufgenommen");
	}

}
