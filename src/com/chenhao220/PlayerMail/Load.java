package com.chenhao220.PlayerMail;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class Load extends JavaPlugin{
	FileConfiguration config;
	Logger log = this.getLogger();
	
	public void onEnable(){
		File configf = new File(this.getDataFolder() + File.separator + "config.yml");
		if(!configf.exists()){
			this.getDataFolder().mkdir();
			this.getConfig().addDefault("version", "1.0 Alpha");
			this.saveDefaultConfig();
		}
		File temp = new File(this.getDataFolder() + File.separator + "player.temp");
		if(!temp.exists()){
			try {
				temp.createNewFile();
			} catch (IOException e) {
				this.getLogger().log(Level.SEVERE, "player.temp文件创建失败！" , e);
				this.getLogger().log(Level.SEVERE, "插件将关闭！");
				this.getPluginLoader().disablePlugin(this);
			}
		}
		this.getCommand("PMail").setExecutor(new User_Command(this));
		this.getLogger().log(Level.INFO, "PlayerMail插件已加载，作者:chenhao");
	}
	
	public void onDisable(){
		this.getLogger().log(Level.INFO, "插件已卸载");
	}

}
