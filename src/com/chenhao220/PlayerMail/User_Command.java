package com.chenhao220.PlayerMail;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class User_Command implements CommandExecutor{
	Load sr;
	File_Handle fh;
	
	public User_Command(Load a){
		this.sr = a;
		this.fh = new File_Handle(a);
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,String[] arg3) {
		if(arg1.getName().equalsIgnoreCase("pmail")){
			if(arg0 instanceof Player){
				Player p = (Player)arg0;
				if((arg3.length == 1)&&(arg3[0].equalsIgnoreCase("help")&&(p.hasPermission("PMail.Admin")))){
					p.sendMessage("§6---------[§cPMail§6]§a插件帮助§6---------");
					p.sendMessage("§6[§cPMail§6]§a/pmail <仓库ID> 打开邮件仓库");
					p.sendMessage("§6[§cPMail§6]§a/pmail help 打开帮助菜单");
					p.sendMessage("§6[§cPMail§6]§a/pmail create <仓库ID> <仓库标题> 创建一个新仓库");
					p.sendMessage("§6[§cPMail§6]§a/pmail add <仓库ID> <物品ID> <物品数量> <物品名称>向指定仓库添加物品");
					p.sendMessage("§6----------------------------------------");
				}if((arg3.length == 1)&&(arg3[0].equalsIgnoreCase("help"))){
					p.sendMessage("§6[§cPMail§6]§a/pmail <仓库ID> 打开邮件仓库");
				}if(arg3.length ==3&&(arg3[0].equalsIgnoreCase("create"))){
					int id;
					String title = arg3[2];
					try{
						id = Integer.parseInt(arg3[1]);
					}catch(Exception e){
						p.sendMessage("§c[PMail]输入了错误的参数！");
						return true;
					}
					
					fh.Create(p, id, title);
					p.sendMessage("§6[§cPMail§6]§a成功添加仓库："+id+"，标题为："+title);
					return true;
				}if((arg3.length == 5)&&(arg3[0].equalsIgnoreCase("add"))){
					int id;
					int Itemid;
					int Amount;
					try{
						id = Integer.parseInt(arg3[1]);
						Itemid = Integer.parseInt(arg3[2]);
						Amount = Integer.parseInt(arg3[3]);
					}catch(Exception e){
						p.sendMessage("§c[PMail]输入了错误的参数！");
						return true;
					}
					fh.Add(p, id, Itemid, arg3[4], Amount);
					p.sendMessage("§6[§cPMail§6]§a成功向仓库："+id+"中添加物品："+Itemid+"*"+Amount+"！");
				}
			}
		}
		
		return false;
	}
	
	

}
