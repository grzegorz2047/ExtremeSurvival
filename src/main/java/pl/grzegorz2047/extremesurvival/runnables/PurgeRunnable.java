/*
 * Copyright 2015 Grzegorz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.grzegorz2047.extremesurvival.runnables;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import pl.grzegorz2047.extremesurvival.Main;

/**
 *
 * @author Grzegorz
 */
public class PurgeRunnable extends BukkitRunnable {

    int size = Main.getES().getBorder().getSize();
    int minSize = Main.getES().getBorder().getDecreasedSize();
    @Override
    public void run() {
        if(size>minSize){
            if(Bukkit.getOnlinePlayers().isEmpty() && Main.getES().getBorder().isRunning()){
                Main.getES().getBorder().setRunning(false);
                Bukkit.getScheduler().cancelTask(this.getTaskId());
                Main.getES().getBorder().resetBorder();
                Main.getES().getBorder().setLastPurgeTime(System.currentTimeMillis());
            }
            size--;
            System.out.println("Size to "+size);
            Main.getES().getBorder().getLoc().getWorld().getWorldBorder().setSize(size);
        }else{
            Main.getES().getBorder().setRunning(false);
            Bukkit.getScheduler().cancelTask(this.getTaskId());
            Main.getES().getBorder().resetBorder();
            Main.getES().getBorder().setLastPurgeTime(System.currentTimeMillis());
        }
    }
    
}
