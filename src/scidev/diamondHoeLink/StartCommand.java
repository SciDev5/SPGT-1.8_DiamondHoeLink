package scidev.diamondHoeLink;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {

	Plugin plugin = null;
	
	public StartCommand(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length != 1) {
			return false;
		} else {
			plugin.setRunning(args[0].equalsIgnoreCase("true"));
		}
		return true;
	}

}
