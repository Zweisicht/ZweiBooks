package me.zweisicht.zweibooks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenBook {

	public static void GiveBook(CommandSender sender,String bookName, Material bookTyp) throws IOException{
		
		
		FileReader file = new FileReader("plugins/ZweiData/Books/" + bookName);
	    BufferedReader br = new BufferedReader(file);
	    List<String> pages = new ArrayList<String>();
	    String page = "";
	    
	  
	    String s;
	    while((s=br.readLine())!=null){
	    	
	    	if(s.indexOf("<p>") == 0){
	    		pages.add(page);
	    		page = "";
	    	}else{
	    	
	    	page += s + "\n";	
	    	}

	    	
	    }
	    

	    br.close();
	    GiveBook.CreateIt(bookName, pages, (Player) sender, bookTyp);
}
}