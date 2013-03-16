package me.zweisicht.zweibooks;

import java.io.File;

import org.bukkit.entity.Player;

public class BookList {

	public static void bookList(Player player){
		
		File dir = new File("plugins/ZweiData/Books");
		 String[] children = dir.list();
		 
	    if (children == null) {
	        System.out.println("Es sind keine Bücher vorhanden.");
	     } else {
	         for (int i=0; i<children.length; i++) {
	                         player.sendMessage(children[i]);
	         }
	     }
		
	}
	
}
