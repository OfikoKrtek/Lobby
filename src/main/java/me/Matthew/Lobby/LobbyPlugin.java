package me.Matthew.Lobby;

import me.Matthew.Lobby.commands.LobbyCommand;
import me.Matthew.Lobby.listeners.MessageListener;
import me.Matthew.Lobby.utils.ConfigUtil;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyPlugin extends JavaPlugin {

    public final MessageListener messageListener = new MessageListener(this);

    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", messageListener);

        this.getServer().getPluginCommand("lobby").setExecutor(new LobbyCommand(this));
    }

    public final ConfigUtil getConfigUtil = new ConfigUtil(this);

    public final FileConfiguration getConfig = getConfigUtil.getConfig("config.yml");

    public String getMessage(String index){
        if (getConfig.getConfigurationSection("messages") == null || getConfig.getString("messages." + index) == null) return " ";
        return getConfig.getString("messages." + index);
    }

    public final String getLobbyServerName = getConfig.get("lobby-server-name") != null ? getConfig.get("lobby-server-name").toString() : "Lobby";
}
