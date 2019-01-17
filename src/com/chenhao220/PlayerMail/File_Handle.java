package com.chenhao220.PlayerMail;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class File_Handle {
	
	Logger log;
	Load sr;
	FileConfiguration config;
	
	public File_Handle(Load sr){
		this.sr = sr;
		this.log = sr.getLogger();
		this.config = sr.getConfig();
	}
	
	public void Create(Player p,int id,String Title){
		config.set("Cont."+id,id);
		config.set("Cont."+id+".Title", Title);
		config.set("Cont."+id+".Total", 0);
		config.set("Cont."+id+".Player", "");
		try {
			config.save(sr.getDataFolder() + File.separator + "config.yml");
		} catch (IOException e) {
			p.sendMessage("§c[PMail]发生错误！");
			log.log(Level.SEVERE, "存储文件失败！", e);
		}
	}
	
	public void Add(Player p,int id,int Itemid,String name,int amount){
		int total = config.getInt("Cont."+id+".Total");
		if(total==0){
			config.set("Cont."+id+".Item."+total+".id", Itemid);
			config.set("Cont."+id+".Item."+total+".name", name);
			config.set("Cont."+id+".Item."+total+".amount", amount);
			config.set("Cont."+id+".Total", total+1);
		}else{
			config.set("Cont."+id+".Item."+total+".id", Itemid);
			config.set("Cont."+id+".Item."+total+".name", name);
			config.set("Cont."+id+".Item."+total+".amount", amount);
			config.set("Cont."+id+".Total", total+1);
		}
		try {
			config.save(sr.getDataFolder() + File.separator + "config.yml");
		} catch (IOException e) {
			p.sendMessage("§c[PMail]发生错误！");
			log.log(Level.SEVERE, "存储文件失败！", e);
		}
	}
	
	
	
}
