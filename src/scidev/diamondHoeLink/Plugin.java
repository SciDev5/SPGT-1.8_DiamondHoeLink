package scidev.diamondHoeLink;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
	
	private boolean running = false;
	
	private TestPlayersTask recurringTask;
	
	@Override
	public void onEnable() {
		getServer().getPluginCommand("startscenario_diahoelink").setExecutor(new StartCommand(this));
		recurringTask = new TestPlayersTask(this);
	}
	
	public void setRunning(boolean running) {
		this.running = running;
		if (this.running) {
			recurringTask.runTaskTimer(this, 20*60, 20*60);
		} else {
			recurringTask.cancel();
		}
	}
	
}
