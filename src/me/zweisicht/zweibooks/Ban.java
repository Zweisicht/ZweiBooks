package me.zweisicht.zweibooks;

import java.text.DateFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Ban {

	public static boolean CreateBook(CommandSender sender) {
		
		Player p = (Player) sender;
		OfflinePlayer[] banlist = Bukkit.getServer().getBannedPlayers().toArray(new OfflinePlayer[0]);
		List<String> pages = new ArrayList<String>();
		
		Calendar calendar = new GregorianCalendar();
		Format format = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		Date date = calendar.getTime();
		
		ArrayList<String> sortBanList = new ArrayList<String>(); 
		int pageCounter = 1;
		
		pages.add("Die Ban-Liste\n------------\n Eintr�ge: " + convertSimple(banlist.length) + "\n Stand: " + format.format(date));
		 
		String strPage = null;
		 for (int x = 0; x < banlist.length; x++) {
			 sortBanList.add(banlist[x].getName());
		 }
		 Collections.sort(sortBanList);

		 for (int x = 0; x < banlist.length; x++) {
			 
			 //Sortieren
			 if(strPage == null){
				 strPage =  (x +1) + ". " + sortBanList.get(x);
			 }else{
				 strPage = strPage + "\n" + (x +1) + ". " + sortBanList.get(x);
			 }
			
			 System.out.println(x);
			 
			 //Bl�tter hinzuf�gen.
			 if(x == 14  * pageCounter -1) {
				pageCounter++;
				pages.add(strPage);
				 strPage = null;
			}else if(x == banlist.length -1){
				pageCounter++;
				pages.add(strPage);
				 strPage = null;
			}
			 
		 }
		
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta meta = (BookMeta)book.getItemMeta();
		meta.setTitle("Banbook");
		meta.setAuthor("ZweiBooks");
		meta.setPages(pages);

		
		book.setItemMeta(meta);
		p.getInventory().addItem(book);
		return false;
	}
	
	public static String convertSimple(int i) {
    return "" + i;
}
	
}
