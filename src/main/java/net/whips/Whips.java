package net.whips;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Whips implements ModInitializer {
    public static final Item WHIP = new Whip(ToolMaterials.WOOD, 2, 1.5f, new FabricItemSettings());

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier("whips", "whip"), WHIP);
    }
}
