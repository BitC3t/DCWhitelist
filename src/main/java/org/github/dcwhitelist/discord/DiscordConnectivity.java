package org.github.dcwhitelist.discord;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class DiscordConnectivity {

	private JDA jda;
	public void init() {
		this.beginBot();
	}



	/**
	 * Returns the JDA Object, where you may control
	 * the bot via several functions. Review
	 * https://github.com/DV8FromTheWorld/JDA for more
	 * infomation.
	 * 
	 * @return the JDA Object
	 * 
	 */
	public JDA getJDA() {
		return this.jda;
	}

	// Initalisation of JDA with Token (Token hidden for Security)
	private void beginBot() {
		try {
			jda = JDABuilder.createDefault
					("*******************************************************").build();
		} catch (LoginException e) {
			e.printStackTrace();
		}
		jda.getPresence().setActivity(Activity.streaming("twitch.tv/floof_y", "https://www.twitch.tv/floof_y"));
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
	}
	
}
