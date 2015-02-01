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
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import pl.grzegorz2047.extremesurvival.Main;

/**
 *
 * @author Grzegorz
 */
public class InfoScoreboardRunnable extends BukkitRunnable {

    @Override
    public void run() {
        for(Player p : Bukkit.getOnlinePlayers()){
            Scoreboard sc  = p.getScoreboard();
            if(sc!= null){
                int sec = (int) (Main.getES().getBorder().whenPurge()/1000);
                if(sc.getObjective(DisplaySlot.SIDEBAR) != null){
                    if(!Main.getES().getBorder().isRunning()){
                        sc.getObjective(DisplaySlot.SIDEBAR).setDisplayName("Czystka za "+Main.formatIntoHHMMSS(sec));
                    }else{
                        sc.getObjective(DisplaySlot.SIDEBAR).setDisplayName("Czystka Trwa! Granica wynosi "+Main.getES().getBorder().getDecreasingSize()/2);
                    }
                    
                }
                
            }
        }
    }
    
}
