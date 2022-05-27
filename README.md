# DCWhitelist

DC Whitelist is a customisable plugin you can use for yourself, or as an API for directly whitelisting users from Discord into your own Minecraft Server. DC Whitelist is available as a JAR, and thus, is compatible with __only Minecraft Java Servers__.
<br/>
<br/>
Although a fairly simple plugin, this plugin is very effective in its use, and was created for programmers to link Discord & Minecraft easier. This plugin makes use of Mojang's API as well as Spigot's API, and is customisable to a great extent. As for users, all they need to do is type out their Minecraft username in a channel, and they would automatically be whitelisted.

### For Users

This plugin requires zero technical knowledge for setup. In order to connect Discord to your Minecraft Server, simply download the jar from the Releases Tab, and upload it into the /plugins/ folder of your Minecraft Server (Paper / Spigot / any derivatives - which **SUPPORTS PLUGINS**). 
<br/>
<br/>
Steps to enable this plugin successfully are given below:
- Invite FloofBot, to your Discord server by clicking on [this link.](https://discord.com/oauth2/authorize?scope=bot+applications.commands&client_id=824892524698009600)
- Provide FloofBot, permissions to - React to Emotes, Ability to View Channels.
- Upload the DC-Whitelist JAR to the /plugins/ of your Minecraft Server.
- Restart your server.
- Navigate to the /plugins/DCWhitelisting/ folder on your server.
- Click on the configuration.yml file, and begin editing it.
- Obtain the Channel ID (where you wish to whitelist users) - if you don't know how to get a channel ID, refer to [this link](https://turbofuture.com/internet/Discord-Channel-ID).
- Restart your server / reload the plugin.
- You're done!

<img src="https://cdn.discordapp.com/attachments/870748925571792916/979781178905198622/unknown.png" width="700">

If you do notice any errors on the console on server disabling, please note these are errors from JDA (Discord API), and not from this plugin. Ignore the same.
<br/>
<br/>

### For Developers

Hiya, devs! As a developer myself, I've custom coded these functions to be very helpful during any development that you're doing! Even for new developers, this API is very comfortable to work with and charming as well!
<br/>
<br/>
To include the plugin as a dependency, please view the repositories and dependencies to be added into your pom.xml.

**repositories:**
```java
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

**dependencies:**
```java
<dependency>
    <groupId>com.github.FloofCat</groupId>
    <artifactId>DCWhitelist</artifactId>
    <version>v0.1</version>
</dependency>
```
