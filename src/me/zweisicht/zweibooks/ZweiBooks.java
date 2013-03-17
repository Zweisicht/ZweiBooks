package me.zweisicht.zweibooks;

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
    	//Ruft das Banbuch auf.
    	 if (cmd.getName().equalsIgnoreCase("banbook")){
 	    	BanBook.Banbook_Create(sender);
 	    	return true;
 	    }
    	 //Der Spieler gibt sich selbst ein Buch.
    	 if (cmd.getName().equalsIgnoreCase("book") && args.length >= 1){
    		 try {
				OpenBook.GiveBook(sender, args[0], Material.WRITTEN_BOOK);
			} catch (IOException e) {
				e.printStackTrace();
			}
    		 return true;
  	    }
    	 //Einen Spieler ein Buch geben.
    	 if (cmd.getName().equalsIgnoreCase("givebook") && args.length >= 2){
    		 try {
				OpenBook.GiveBook(Bukkit.getPlayer(args[0]), args[1], Material.WRITTEN_BOOK);
			} catch (IOException e) {
				e.printStackTrace();
			}
    		 return true;
  	    } 
    	 //Ruft das Buch auf um es zu editieren. 
    	 if (cmd.getName().equalsIgnoreCase("editbook") && args.length >= 1){
    		 try {
				OpenBook.GiveBook(sender, args[0], Material.BOOK_AND_QUILL);
			} catch (IOException e) {
				e.printStackTrace();
			}
    		 return true;
  	    } 
    	 //Eine zweite Möglichkeit das Regelbuch aufzurufen.
    	 if (cmd.getName().equalsIgnoreCase("rulesbook")){
    		 try {
				OpenBook.GiveBook(sender, "Rulesbook", Material.WRITTEN_BOOK);
			} catch (IOException e) {
				e.printStackTrace();
			}
    		 return true;
    	 }
    	 //Hier wird die Bücherliste aufgerufen.
    	 if (cmd.getName().equalsIgnoreCase("booklist")){
  	    	BookList.bookList((Player) sender);
    		 return true;
  	    }
    	 //Ein erstelltes Buch in die Bibliothek aufnehmen.
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
