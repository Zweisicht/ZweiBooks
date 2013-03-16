package me.zweisicht.zweibooks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Book {

	public static void GiveBook(CommandSender sender,String bookName) throws IOException{
		
		
		FileReader file = new FileReader("plugins/ZweiData/Books/" + bookName);
	    BufferedReader br = new BufferedReader(file);
	    List<String> pages = new ArrayList<String>();
	    
	    String zeile = "";
	    String Text = "";
	    int Absatz = -2;
	    
	    do
	    {
	    
	      zeile = br.readLine();
	    
	      if(zeile == null){}else{
	     if (zeile.length() >= 23){
	   	  Absatz += 1;
	     }
	    }

	          Absatz += 1;
	      if(zeile != null){
	    	  Text = Text + "\n" + zeile;
	      }
	  
	      
	      
	     if(Absatz >= 12){
	    	 pages.add(Text);
	    	 Text = "";
	    	 Absatz = 0;  
	     }
	      
	    }
	    while (zeile != null);
    	 pages.add(Text);
    	 Text = "";
    	 Absatz = 0;  
	    
	    br.close();
	   
	    CreateBook.CreateIt(bookName, pages, (Player) sender);
}
}