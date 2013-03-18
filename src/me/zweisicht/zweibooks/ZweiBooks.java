package me.zweisicht.zweibooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ZweiBooks extends JavaPlugin {

	@Override
	public void onDisable() {
        System.out.println("ZweiBooks wurde deaktiviert");
    }

	@Override
    public void onEnable() {
        System.out.println("ZweiBooks wurde aktiviert");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel,String[] args)
    {
    	
    	//Prüft ob der Spieler die Berechtigung hat.
    	if(!sender.hasPermission("zweibooks."+ cmd)){
    		sender.sendMessage("Du hast keine Berechtigung.");
    		return true;
    	}
    		
    	//Ruft das Banbuch auf.
    	 if (cmd.getName().equalsIgnoreCase("banbook")){
 	    	BanBook.Banbook_Create(sender);
 	    	return true;
 	    }
    	 //Ein Buch bekommen.
    	 if (cmd.getName().equalsIgnoreCase("book") && args.length >= 1){
    		 try {
				OpenBook.GiveBook(sender, args[0], Material.WRITTEN_BOOK);
			} catch (FileNotFoundException e) {
				sender.sendMessage("Das Buch existiert nicht.");
			}
    		 return true;
  	    }
    	 //Ein Buch geben.
    	 if (cmd.getName().equalsIgnoreCase("givebook") && args.length >= 2){
    		 try {
    			 for(Player player: Bukkit.getOnlinePlayers()){
    				 if(player.getName().indexOf(args[0]) >= 0){
    					
    					OpenBook.GiveBook(Bukkit.getPlayer(args[0]), args[1], Material.WRITTEN_BOOK);
    					sender.sendMessage("Das Buch wurde dem Spieler: " + args[0] + " gegeben.");
    		    		return true;
    					 
    				 }

    			 }
    			 sender.sendMessage("Der Spieler ist nicht online.");
			} catch (FileNotFoundException e) {
				sender.sendMessage("Das Buch existiert nicht.");				
			}
    		 return true;
  	    } 
    	 //Das Buch editieren. 
    	 if (cmd.getName().equalsIgnoreCase("editbook") && args.length >= 1 ){
    		 try {
				OpenBook.GiveBook(sender, args[0], Material.BOOK_AND_QUILL);
			} catch (FileNotFoundException e) {
				sender.sendMessage("Das Buch existiert nicht.");
			}
    		 return true;
  	    } 
    	 //Eine zweite Möglichkeit das Regelbuch aufzurufen.
    	 if (cmd.getName().equalsIgnoreCase("rulesbook")){
    		 try {
				OpenBook.GiveBook(sender, "Rulesbook", Material.WRITTEN_BOOK);
			} catch (IOException e) {
				sender.sendMessage("Das Buch existiert nicht.");
			}
    		 return true;
    	 }
    	 //Bücherliste aufrufen.
    	 if (cmd.getName().equalsIgnoreCase("booklist")){
  	    	BookList.bookList((Player) sender);
    		 return true;
  	    }
    	 //Buch löschen.
    	 if (cmd.getName().equalsIgnoreCase("removebook")){
  	    	
    			File f;
    			f= new File("plugins/ZweiData/Books/" + args[0]);
    			
    			if(f.exists()){
    				f.delete();
    				sender.sendMessage("Das Buch wurde gelöscht.");
    			}else{
    				sender.sendMessage("Das Buch wurde nicht gefunden.");
    			}
    		 return true;
  	    }
    	 //Buch in die Bibliothek aufnehmen.
    	 if (cmd.getName().equalsIgnoreCase("copybook")){
   	    	try {
				SaveBook.CopyIT((Player) sender);
			} catch (IOException e) {
				e.printStackTrace();
			}
     		 return true;
   	    }   	 
    	 
		return false;
    }

}
