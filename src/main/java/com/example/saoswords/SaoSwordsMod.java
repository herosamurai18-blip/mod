package com.example.saoswords;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Whole mod in one file: Elucidator, Dark Repulser and Excalibur swords + a creative tab. */
@Mod(SaoSwordsMod.MODID)
public class SaoSwordsMod {
    public static final String MODID = "saoswords";

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    /** Custom material: durability, mining speed, bonus damage, harvest level, enchantability. */
    private static class SwordTier implements Tier {
        private final int uses;
        private final float damage;

        SwordTier(int uses, float damage) {
            this.uses = uses;
            this.damage = damage;
        }

        @Override public int getUses() { return uses; }
        @Override public float getSpeed() { return 9.0F; }
        @Override public float getAttackDamageBonus() { return damage; }
        @Override public int getLevel() { return 4; }
        @Override public int getEnchantmentValue() { return 20; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(Items.NETHERITE_INGOT); }
    }

    private static final Tier BLACK_TIER = new SwordTier(3000, 4.0F);
    private static final Tier TEAL_TIER = new SwordTier(3000, 4.0F);
    private static final Tier GOLD_TIER = new SwordTier(4000, 5.0F);

    // SwordItem(tier, extraDamage, attackSpeedModifier, properties)
    // Elucidator: heavy hitter (~9 damage)
    public static final RegistryObject<Item> ELUCIDATOR = ITEMS.register("elucidator",
            () -> new SwordItem(BLACK_TIER, 4, -2.4F,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    // Dark Repulser: slightly weaker but faster (~8 damage, fast swing)
    public static final RegistryObject<Item> DARK_REPULSER = ITEMS.register("dark_repulser",
            () -> new SwordItem(TEAL_TIER, 3, -1.8F,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    // Excalibur: strongest, gives you Regeneration for 3 seconds when you hit something
    public static final RegistryObject<Item> EXCALIBUR = ITEMS.register("excalibur",
            () -> new SwordItem(GOLD_TIER, 4, -2.4F,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0));
                    return super.hurtEnemy(stack, target, attacker);
                }
            });

    public static final RegistryObject<CreativeModeTab> TAB = TABS.register("sao_swords",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MODID))
                    .icon(() -> new ItemStack(ELUCIDATOR.get()))
                    .displayItems((params, output) -> {
                        output.accept(ELUCIDATOR.get());
                        output.accept(DARK_REPULSER.get());
                        output.accept(EXCALIBUR.get());
                    })
                    .build());

    public SaoSwordsMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        TABS.register(bus);
    }
}
