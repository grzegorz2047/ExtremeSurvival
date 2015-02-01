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
package pl.grzegorz2047.extremesurvival.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import pl.grzegorz2047.extremesurvival.Main;
import pl.grzegorz2047.extremesurvival.ScoreboardManagement;

/**
 *
 * @author Grzegorz
 */
public class PlayerJoinListener implements Listener{
    
    @EventHandler
    void onLogin(PlayerJoinEvent e){
        ScoreboardManagement.createScoreboard(e.getPlayer());
        Player p = e.getPlayer();
        p.sendMessage("Witaj na serwerze Purge!");
        p.sendMessage("Czystka oznacza to, ze granica swiata zaczyna sie kurczyc w kierunku");
        p.sendMessage("Koordynat: x: 0 z: 0");
        p.sendMessage("Zatrzymuje sie na Wspolrzednych x i z: "+Main.getES().getBorder().getDecreasedSize()/2);
    }
    
}
