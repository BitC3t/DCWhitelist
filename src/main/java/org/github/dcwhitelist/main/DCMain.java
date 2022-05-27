package org.github.dcwhitelist.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.github.dcwhitelist.discord.ChannelMonitoring;
import org.github.dcwhitelist.discord.DiscordConnectivity;
import org.github.dcwhitelist.whitelist.WhitelistClass;
import org.github.dcwhitelist.yaml.YamlCreation;

import net.md_5.bungee.api.ChatColor;

public class DCMain extends JavaPlugin {

	private WhitelistClass whitelistClass = new WhitelistClass();
	private DiscordConnectivity discordConnectivity = new DiscordConnectivity();
	private YamlCreation yamlCreation = new YamlCreation(this);
	private ChannelMonitoring channelMonitoring = new ChannelMonitoring(this, this.yamlCreation);
	@Override
	public void onEnable() {
		
		// Initalise Logger Messages
		this.getLogger().info(ChatColor.GREEN + "DC - MC Whitelisting enabled.\n\n" + ChatColor.GOLD
				+ "Plugin by Floof#8983 - https://github.com/FloofCat/DCWhitelist\n\n");
		
		// Initalisation of Connectivities & Methods
		this.discordConnectivity.init();
		this.yamlCreation.init();
		this.channelMonitoring.init();
	}

	@Override
	public void onDisable() {

	}
	
	// Returns the Whitelist Class for Function Use
	public WhitelistClass getMethods() {
		return this.whitelistClass;
	}
	
	// Returns the Connectivity Class for Function Use
	public DiscordConnectivity getConnectivity() {
		return this.discordConnectivity;
	}

}
