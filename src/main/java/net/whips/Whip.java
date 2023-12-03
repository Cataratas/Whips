package net.whips;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.village.VillageGossipType;

import static net.whips.Whips.WHIP_SOUND_EVENT;


public class Whip extends SwordItem {
    public Whip(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), WHIP_SOUND_EVENT, SoundCategory.HOSTILE, 5f, 1.0F / (attacker.getWorld().random.nextFloat() * 0.4F + 1.2F) + 0.5F);

        if (target instanceof VillagerEntity) {
            ((VillagerEntity) target).getGossip().removeGossip(attacker.getUuid(), VillageGossipType.MINOR_NEGATIVE, 25);
            ((VillagerEntity) target).getGossip().removeGossip(attacker.getUuid(), VillageGossipType.MAJOR_NEGATIVE, 25);
            ((VillagerEntity) target).getGossip().startGossip(attacker.getUuid(), VillageGossipType.MINOR_POSITIVE, 25);
        }

        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200));

        return super.postHit(stack, target, attacker);
    }
}
