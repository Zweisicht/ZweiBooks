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

public class BanBook {

	//Hier werden die gebannten Spieler rausgesucht. 
	public static void Banbook_Create(CommandSender sender) {
		
		OfflinePlayer[] banlist = Bukkit.getServer().getBannedPlayers().toArray(new OfflinePlayer[0]);
		List<String> pages = new ArrayList<String>();
		
		Calendar calendar = new GregorianCalendar();
		Format format = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		Date date = calendar.getTime();
		
		ArrayList<String> sortBanList = new ArrayList<String>(); 
		int pageCounter = 1;
		
		pages.add("Die Ban-Liste\n------------\n Einträge: " + convertSimple(banlist.length) + "\n Stand: " + format.format(date));
		 
		String strPage = null;
		int banlength = banlist.length;
		 for (int x = 0; x < banlength; x++) {
			 sortBanList.add(banlist[x].getName());
		 }
		 Collections.sort(sortBanList);

		 for (int x = 0; x < banlength; x++) {
			 
			 if(strPage == null){
				 strPage =  (x +1) + ". " + sortBanList.get(x);
			 }else{
				 strPage = strPage + "\n" + (x +1) + ". " + sortBanList.get(x);
			 }
			 
			 //Blätter hinzufügen.
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
		OpenBook.CreateIt("Banbook", pages, (Player) sender, Material.WRITTEN_BOOK);
	}
	
	public static String convertSimple(int i) {
    return "" + i;
}
	
}

