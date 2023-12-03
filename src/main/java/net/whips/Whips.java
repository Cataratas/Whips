package net.whips;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Whips implements ModInitializer {
    public static final Item WHIP = new Whip(ToolMaterials.WOOD, 0, 3f, new FabricItemSettings());

    public static final Identifier WHIP_SOUND = new Identifier("whips:whip_sound");
    public static SoundEvent WHIP_SOUND_EVENT = SoundEvent.of(WHIP_SOUND);

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier("whips", "whip"), WHIP);
        Registry.register(Registries.SOUND_EVENT, WHIP_SOUND, WHIP_SOUND_EVENT);
    }
}
