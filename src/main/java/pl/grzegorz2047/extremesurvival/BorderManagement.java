/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.grzegorz2047.extremesurvival;

import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldBorder;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import pl.grzegorz2047.extremesurvival.runnables.PurgeRunnable;

/**
 *
 * @author Grzegorz
 */
public class BorderManagement {
    private boolean running;
    private int decreasingSize;//Size which decreasing when purge mode is on
    private int size;
    private int decreasedSize;
    private Location loc;
    private long lastPurgeTime = System.currentTimeMillis();
    private int triggerTime;
    public BorderManagement(int size, int decreaseSize, Location loc, int triggerTime){
        if(size<1 && decreaseSize>size){
            System.out.println("Wielkosc granicy musi byc >1");
            this.size = 1000;
            this.loc = loc;
            this.decreasedSize = 100;
            this.triggerTime = 60;
        }else{
            this.size = size;
            this.loc = loc;
            this.decreasedSize = decreaseSize;
            this.triggerTime = triggerTime;
        }

        WorldBorder wb = loc.getWorld().getWorldBorder();
        wb.setCenter(loc);
        wb.setDamageAmount(2);
        wb.setWarningTime(5);
        wb.setSize(size);
        wb.setWarningDistance(30);
    }
    
    public Long whenPurge(){
        return (this.lastPurgeTime+1000*this.triggerTime*60)-System.currentTimeMillis();
    }
    
    public boolean isRunning(){
        return this.running;
    }
    
    public void startBorder(){
        if(!this.running){
            System.out.println("Probuje wykonywanie tego");
            Main.getES().getBorder().setRunning(true);
            BukkitTask TaskName = new PurgeRunnable().runTaskTimer(Main.getES(), 20, 20);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public int getDecreasedSize() {
        return decreasedSize;
    }
    public int getDecreasingSize() {
        return decreasingSize;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
    public void resetBorder(){
        WorldBorder wb = this.loc.getWorld().getWorldBorder();
        wb.setCenter(this.loc);
        wb.setDamageAmount(2);
        wb.setWarningTime(5);
        wb.setSize(this.size);
        wb.setWarningDistance(30);
    }

    public Location getLoc() {
        return loc;
    }

    public long getLastPurgeTime() {
        return lastPurgeTime;
    }

    public void setLastPurgeTime(long lastPurgeTime) {
        this.lastPurgeTime = lastPurgeTime;
    }

    public void setDecreasingSize(int size) {
     this.decreasingSize = size;
    }
}
