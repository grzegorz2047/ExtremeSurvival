/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.grzegorz2047.extremesurvival;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.grzegorz2047.extremesurvival.listeners.PingListListener;
import pl.grzegorz2047.extremesurvival.listeners.PlayerLoginListener;
import pl.grzegorz2047.extremesurvival.listeners.PlayerQuitListener;

/**
 *
 * @author Grzegorz
 */
public class Main extends JavaPlugin {

    private BorderManagement border;
    
    public static Main getES(){
        return (Main) Bukkit.getPluginManager().getPlugin("ExtremeSurvival");
    }
    
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        int size = this.getConfig().getInt("size");
        int decreaseSize = this.getConfig().getInt("decreasedSize");
        int triggerTime = this.getConfig().getInt("triggerMinuteTime");
        Location loc = Main.parseLocationString(this.getConfig().getString("loc"));
        this.border = new BorderManagement(size, decreaseSize, loc);
        System.out.print(this.getName()+" zostal wlaczony");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

            @Override
            public void run() {
                Main.getES().getBorder().startBorder();
            }
        }, triggerTime*60*20l, 20l);
        
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new PingListListener(), this);
        pm.registerEvents(new PlayerLoginListener(), this);
        pm.registerEvents(new PlayerQuitListener(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
        System.out.print(this.getName()+" zostal wylaczony");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return true;
    }

    public BorderManagement getBorder() {
        return border;
    }
    public static Location parseLocationString(String location){
        String[] data = location.split(":");
        String world = data[0];
        double x = Double.valueOf(data[1]);
        double y = Double.valueOf(data[2]);
        double z = Double.valueOf(data[3]);
        //Mozna dac world
        Location loc = new Location(Bukkit.getWorld(world), x,y,z);
        return loc;
    }
}
