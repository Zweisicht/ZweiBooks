package me.zweisicht.zweibooks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ZweiBooks extends JavaPlugin {

	@Override
	public void onDisable() {
        // TODO Auto-generated method stub
        System.out.println("ZweiBooks wurde deaktiviert");
    }

	@Override
    public void onEnable() {
        // TODO Auto-generated method stub
        System.out.println("ZweiBooks wurde aktiviert");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel,String[] args)
    {
    	
    	 if (cmd.getName().equalsIgnoreCase("banbook")){
 	    	Ban.CreateBook(sender);
 	    	return true;
 	    }
		return false;
    }

}
