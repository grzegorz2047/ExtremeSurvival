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

/**
 *
 * @author Grzegorz
 */
public class BorderManagement {
    private boolean running;
    private int size;
    private int decreasedSize;
    private Location loc;
    
    public BorderManagement(int size, int decreaseSize, Location loc){
        if(size<1 && decreaseSize>size){
            System.out.println("Wielkosc granicy musi byc >1");
            this.size = 1000;
            this.loc = loc;
            this.decreasedSize =100;
        }else{
            this.size = size;
            this.loc = loc;
            this.decreasedSize = decreaseSize;
        }

        WorldBorder wb = loc.getWorld().getWorldBorder();
        wb.setCenter(loc);
        wb.setDamageAmount(2);
        wb.setWarningTime(5);
        wb.setSize(size);
        wb.setWarningDistance(30);
    }
    
    public boolean isRunning(){
        return this.running;
    }
    
    public void startBorder(){
        if(!this.running){
            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getES(), new BukkitRunnable(){
                int size = Main.getES().getBorder().getSize();
                int minSize = Main.getES().getBorder().getDecreasedSize();
                @Override
                public void run() {
                    if(size>minSize){
                        size--;
                    }else{
                        Main.getES().getBorder().setRunning(false);
                        this.cancel();
                    }
                }
            }, 20l, 20l);
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

    private void setRunning(boolean running) {
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
}
