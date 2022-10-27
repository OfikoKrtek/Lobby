package me.Matthew.Lobby.commands;

import me.Matthew.Lobby.LobbyPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbyCommand implements CommandExecutor {

    LobbyPlugin plugin;

    public LobbyCommand(LobbyPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player){
            if (command.getPermission() != null && player.hasPermission(command.getPermission())){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessage("sending")));
                plugin.messageListener.sendPlayer(player, plugin.getLobbyServerName());
            }
            else player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getMessage("dont-have-permission")));
        }
        return false;
    }
}
