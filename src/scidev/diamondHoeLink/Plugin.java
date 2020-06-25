package scidev.diamondHoeLink;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Plugin extends JavaPlugin {
	
	private boolean running = false;
	
	public static final String CHATPREFIX = ""+ChatColor.GOLD+ChatColor.BOLD+"SCENARIO"+ChatColor.GRAY+"»"+ChatColor.RESET+ChatColor.WHITE; 
	
	//private TestPlayersTask recurringTask;
	private BukkitTask recurringTask;
	
	@Override
	public void onEnable() {
		getServer().getPluginCommand("startscenario_diahoelink").setExecutor(new StartCommand(this));
	}
	
	public void setRunning(boolean running) {
		this.running = running;
		if (this.running) {
			recurringTask = (new TestPlayersTask(this)).runTaskTimer(this, 20*60, 20*60);
		} else {
			recurringTask.cancel();
		}
	}
	
}
