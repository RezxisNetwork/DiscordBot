package net.rezxis.discord;

import java.net.URI;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.rezxis.mchosting.network.WSClient;

public class DiscordBot {

	public static Props props;
	public static WSClient client;
	public static JDA jda;
	
	public static void main(String[] args) {
		props = new Props("discord.properties");
		try {
			client = new WSClient(new URI("ws://"+props.SYNC_ADDRESS+":"+props.SYNC_PORT),  new WSClientHandler());
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("failed to init websocket.");
			return;
		}
		try {
			jda = JDABuilder.createDefault(props.TOKEN).addEventListeners(new JDAListener()).build();
		} catch (LoginException e) {
			e.printStackTrace();
			return;
		}
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
