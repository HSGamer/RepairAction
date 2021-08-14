package me.hsgamer.bettergui.repairaction;

import me.hsgamer.bettergui.api.addon.BetterGUIAddon;
import me.hsgamer.bettergui.builder.ActionBuilder;
import me.hsgamer.bettergui.builder.RequirementBuilder;

public final class RepairAction extends BetterGUIAddon {

    @Override
    public void onEnable() {
        RequirementBuilder.INSTANCE.register(RepairableRequirement::new, "repairable", "repair");
        ActionBuilder.INSTANCE.register(RepairItemAction::new, "repair-item", "repair");
    }
}
