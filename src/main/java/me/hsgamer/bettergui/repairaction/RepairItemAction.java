package me.hsgamer.bettergui.repairaction;

import me.hsgamer.bettergui.api.action.BaseAction;
import me.hsgamer.bettergui.lib.taskchain.TaskChain;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class RepairItemAction extends BaseAction {
    public RepairItemAction(String string) {
        super(string);
    }

    @Override
    public void addToTaskChain(UUID uuid, TaskChain<?> taskChain) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) {
            return;
        }
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (itemStack.getType() == Material.AIR) {
            return;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (!Utils.isRepairable(itemMeta)) {
            return;
        }
        Damageable damageable = (Damageable) itemMeta;
        taskChain.sync(() -> {
            damageable.setDamage(0);
            itemStack.setItemMeta(itemMeta);
        });
    }
}
