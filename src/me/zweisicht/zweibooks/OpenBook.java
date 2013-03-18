package me.zweisicht.zweibooks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class OpenBook {

	//Erstellt die Seiten.
	public static void GiveBook(CommandSender sender,String bookName, Material bookTyp) throws FileNotFoundException  {
		
		
		FileReader file = new FileReader("plugins/ZweiData/Books/" + bookName);
	    BufferedReader br = new BufferedReader(file);
	    List<String> pages = new ArrayList<String>();
	    String page = "";
	    
	  
	    String s;
	    try {
			while((s=br.readLine())!=null){
				
				if(s.indexOf("<p>") == 0){
					pages.add(page);
					page = "";
				}else{
				page += s + "\n";	
				}
			}
			
			    br.close();	
		} catch (IOException e) {
		}
	    

	    CreateIt(bookName, pages, (Player) sender, bookTyp);

}
	//Das Buch wird erstellt und dem Spieler gegeben.
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