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
package pl.grzegorz2047.extremesurvival;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

/**
 *
 * @author Grzegorz
 */
public class ScoreboardManagement {
    
    public static void createScoreboard(Player p ){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("Info", "dummy");
        int sec = (int) (Main.getES().getBorder().whenPurge()/1000);
        if(sec < 0){
                    obj.setDisplayName("Czystka Trwa!");
        }else{
                    obj.setDisplayName("Czystka za "+Main.formatIntoHHMMSS(sec));
        }

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score s = obj.getScore(ChatColor.BOLD+""+ChatColor.GREEN+"Granica");
        s.setScore(-1);
        Score size = obj.getScore(ChatColor.BOLD+""+ChatColor.GREEN+Main.getES().getBorder().getSize()/2+"");
        size.setScore(-2);
        p.setScoreboard(scoreboard);
    }
    
}
