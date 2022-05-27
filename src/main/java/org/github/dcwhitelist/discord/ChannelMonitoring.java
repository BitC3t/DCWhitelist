package org.github.dcwhitelist.discord;

import org.github.dcwhitelist.main.DCMain;
import org.github.dcwhitelist.yaml.YamlCreation;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ChannelMonitoring extends ListenerAdapter{
	
	private DCMain plugin;
	private YamlCreation yamlCreation;
	private String channelID;
	private JDA jda;
	private char unicodeWarn = '\u26A0';
	private char unicodeYes = '\u2714';
	public ChannelMonitoring(DCMain main, YamlCreation yaml) {
		this.plugin = main;
		this.yamlCreation = yaml;
		
	}
	
	/**
	 * No relevance to developers. Private function.
	 */
	public void init() {
		this.channelID = this.yamlCreation.getChannelID();
		this.jda = this.plugin.getConnectivity().getJDA();
		this.jda.addEventListener(this);
	}
	
	/**
	 * Returns the Channel as a TextChannel
	 * retrieved from the YAML of the JavaPlugin.
	 * 
	 * @return the TextChannel from Discord
	 */
	public TextChannel getChannel() {
		if(this.channelID == "") {
			return null;
		}
		return this.jda.getTextChannelById(this.channelID);
	}
	
	/**
	 * No relevance to developers. Private function.
	 */
	@Override
	public void onMessageReceived(MessageReceivedEvent event) { 
        String msg = event.getMessage().getContentRaw();
		User user = event.getAuthor();
		
		if(user.isBot()==true || user.isSystem() == true) {
			return;
		}
		
		if(this.getChannel() == null) {
			return;
		}
		
		if(event.getTextChannel().equals(this.getChannel())) {
			if(this.plugin.getMethods().getUserUUID(msg) == null) {
				event.getMessage().addReaction(Character.toString(unicodeWarn)).queue();
			} else {
				event.getMessage().addReaction(Character.toString(unicodeYes)).queue();
				this.plugin.getMethods().whitelistUser(this.plugin.getMethods().getUserUUID(msg), msg);
			}
		}
		
	}
}
