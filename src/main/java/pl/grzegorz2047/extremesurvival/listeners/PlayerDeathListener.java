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

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Grzegorz
 */
public class PlayerDeathListener implements Listener {
    
    @EventHandler
    void onDeath(PlayerDeathEvent e){
        e.getEntity().getInventory().clear();
        e.getEntity().getInventory().setArmorContents(new ItemStack[4]);
        e.getEntity().kickPlayer("Zostales oczyszczony!");
    }
    
}
