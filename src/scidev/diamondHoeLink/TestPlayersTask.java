package scidev.diamondHoeLink;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class TestPlayersTask extends BukkitRunnable {

	Plugin plugin = null;
	Random rand;
	
	public TestPlayersTask(Plugin plugin) {
		this.plugin = plugin;
		rand = new Random();
	}
	
	@Override
	public void run() {
		int n = 0;
		List<Player> p = new ArrayList<Player>();
		for (Player plrTest : plugin.getServer().getWorld("world").getPlayers()) {
			int tn = 0;
			Inventory inv = plrTest.getInventory();
			if (inv == null) continue;
			for (ItemStack stk : inv.getContents()) {
				if (stk == null) continue;
				if (stk.getType() == Material.DIAMOND_HOE) {
					tn += stk.getAmount();
				}
			}
			if (tn > n) {
				n = tn;
				p = new ArrayList<Player>();
			}
			if (tn == n) p.add(plrTest);
		}
		if (p.size() == 0) {
			plugin.getServer().broadcastMessage(Plugin.CHATPREFIX+"No more players, stopping.");
			plugin.setRunning(false);
			return;
		}
		Player playerToKill = p.get(rand.nextInt(p.size()));
		plugin.getServer().broadcastMessage(Plugin.CHATPREFIX+ChatColor.RED+playerToKill.getName()+" was the weakest link! ("+n+" diamond hoes)");
		playerToKill.damage(playerToKill.getHealth());
	}

}
