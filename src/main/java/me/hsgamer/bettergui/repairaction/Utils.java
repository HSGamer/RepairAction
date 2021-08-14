package me.hsgamer.bettergui.repairaction;

import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils {
    private Utils() {
        // EMPTY
    }

    public static boolean isRepairable(ItemMeta itemMeta) {
        return itemMeta instanceof Damageable && ((Damageable) itemMeta).hasDamage();
    }
}
