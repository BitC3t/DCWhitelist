package org.github.dcwhitelist.yaml;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.github.dcwhitelist.main.DCMain;

public class YamlCreation {

	private DCMain plugin;
	private File file;
	public YamlCreation(DCMain main) {
		this.plugin = main;
		this.file = new File(this.plugin.getDataFolder(), "configuration.yml");
	}

	public void init() {
		// Creates Data Folder
		if(!this.plugin.getDataFolder().exists()) {
			this.plugin.getDataFolder().mkdir();
		}
		
		// Creates new file
		if (!this.file.exists()) {
			try {
				this.file.createNewFile();

				this.makeDefaultConfiguration().save(this.file);
			} catch (IOException e) {
				this.plugin.getLogger().info(ChatColor.RED + "" + ChatColor.BOLD + "[ERROR]" + ChatColor.WHITE
						+ "Unable to create configuration file.");
			}
		}
	}

	public String getChannelID() {
		YamlConfiguration config = YamlConfiguration.loadConfiguration(this.file);
		return config.getString("Channel ID");
	}
	
	private YamlConfiguration makeDefaultConfiguration() {
		YamlConfiguration config = YamlConfiguration.loadConfiguration(this.file);
		
		// Comments
		FileConfiguration configFile = YamlConfiguration.loadConfiguration(this.file);
		configFile.setComments("DC", Arrays.asList("Welcome to the DC - MC Configuration.", "", "",
				"Made by Floof#8983. For any issues or any bugs, please open an issue @ https://github.com/FloofCat/DCWhitelist",
				"To begin with, enter your channel ID below.", "", "",
				"For example: \"Channel ID\": \"657025847622107148\""));
		
		try {
			configFile.save(this.file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		config.set("Channel ID", "");

		return config;
	}
}
