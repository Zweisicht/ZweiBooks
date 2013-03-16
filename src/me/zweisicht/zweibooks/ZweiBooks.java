package me.zweisicht.zweibooks;

import java.io.IOException;

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
    	
    	 if (cmd.getName().equalsIgnoreCase("banbook")){
 	    	Ban.Banbook(sender);
 	    	return true;
 	    }
    	 if (cmd.getName().equalsIgnoreCase("book") && args.length >= 1){
    		 try {
				Book.GiveBook(sender, args[0]);
			} catch (IOException e) {
				System.out.println("Fehler!");
				e.printStackTrace();
			}
    		 return true;
  	    }   
    	 if (cmd.getName().equalsIgnoreCase("rulesbook")){
    		 try {
				Book.GiveBook(sender, "Rulesbook");
			} catch (IOException e) {
				System.out.println("Fehler!");
				e.printStackTrace();
			}
    		 return true;
    	 }
    	 if (cmd.getName().equalsIgnoreCase("booklist")){
  	    	BookList.bookList((Player) sender);
    		 return true;
  	    }
    	 
    	 
		return false;
    }

}
