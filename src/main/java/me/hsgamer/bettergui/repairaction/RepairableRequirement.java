package me.hsgamer.bettergui.repairaction;

import me.hsgamer.bettergui.api.requirement.BaseRequirement;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class RepairableRequirement extends BaseRequirement<Boolean> {
    public RepairableRequirement(String name) {
        super(name);
    }

    @Override
    public Boolean getParsedValue(UUID uuid) {
        return Boolean.parseBoolean(String.valueOf(value));
    }

    @Override
    public boolean check(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) {
            return false;
        }
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        return itemStack.getType() != Material.AIR && getParsedValue(uuid).equals(Utils.isRepairable(itemStack.getItemMeta()));
    }

    @Override
    public void take(UUID uuid) {
        // EMPTY
    }
}
