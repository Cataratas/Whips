package net.whips;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;

import static net.whips.Whips.WHIP_SOUND_EVENT;


public class Whip extends SwordItem {
    public Whip(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), WHIP_SOUND_EVENT, SoundCategory.HOSTILE, 1.5f, 1.0F / (attacker.getWorld().random.nextFloat() * 0.4F + 1.2F) + 0.5F);

        return super.postHit(stack, target, attacker);
    }
}
