package net.rezxis.discord;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.rezxis.mchosting.database.Tables;

public class JDAGameTask implements Runnable {

	//private int lastPlaying = 0;
	private int lastOnline = -1;
	private int count = 0;
	
	@Override
	public void run() {
		if (count % 10 == 0) {
			int ii = Tables.getSTable().getOnlineServers().size();
			if (ii != lastOnline)  {
				DiscordBot.jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.playing(ii+" servers online!"));
				this.lastOnline = ii;
			}
		}
		count += 1;
	}
}
