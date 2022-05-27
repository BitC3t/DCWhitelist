package org.github.dcwhitelist.whitelist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class WhitelistClass {

	/*
	 * Used to check if player is whitelisted.
	 * 
	 * @param -> player: Bukkit Player (Player)
	 */
	public boolean isWhitelisted(Player player) {
		return player.isWhitelisted();
	}
	
	public void enableWhitelist() {
		Bukkit.setWhitelist(true);
	}
	
	public void disableWhitelist() {
		Bukkit.setWhitelist(false);
	}
	
	/*
	 * Used to whitelist a player
	 * 
	 * @param -> uuid : Player UUID (UUID)
	 */
	@SuppressWarnings("deprecation")
	public void whitelistUser(UUID uuid, String playerName) {
		Bukkit.getOfflinePlayer(uuid).setWhitelisted(true);
		Bukkit.getOfflinePlayer(playerName).setWhitelisted(true);
		Bukkit.reloadWhitelist();
	}
	
	/*
	 * Used to get UUID from Mojang API
	 * 
	 * @param -> playerName : Bukkit Player Name (String)
	 */
	public UUID getUserUUID(String playerName) {
		UUID playerUUID = this.getUUID(playerName);
		return playerUUID;
	}
	
	
	// Miscellaneous Functions for obtaining UUIDs
    private UUID getUUID(String playerName) {
        try {
            String json = readUrl("https://api.mojang.com/users/profiles/minecraft/" + playerName);
            System.out.println(json);
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            if(jsonObject == null) {
            	return null;
            }
            String str = jsonObject.get("id").getAsString();
            UUID uuid = UUID.fromString(
                    str.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                            "$1-$2-$3-$4-$5"));

            return uuid;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

	private String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
