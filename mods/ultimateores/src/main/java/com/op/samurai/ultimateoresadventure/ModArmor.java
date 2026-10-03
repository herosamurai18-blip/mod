package com.op.samurai.ultimateoresadventure;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModArmor {
    public static final DeferredRegister<net.minecraft.world.item.Item> ARMOR =
            DeferredRegister.create(ForgeRegistries.ITEMS, UltimateOresAdventure.MODID);

    public static final ArmorMaterial TITANIUM = material("titanium", 35, 3, 8, 3, 12);
    public static final ArmorMaterial BRASS = material("brass", 18, 2, 5, 2, 10);
    public static final ArmorMaterial BRONZE = material("bronze", 22, 2, 6, 2, 10);
    public static final ArmorMaterial STEEL = material("steel", 30, 3, 7, 2, 12);
    public static final ArmorMaterial INVAR = material("invar", 32, 3, 7, 3, 14);
    public static final ArmorMaterial ELECTRUM = material("electrum", 25, 2, 6, 3, 18);
    public static final ArmorMaterial ASTRAL = material("astral", 40, 4, 9, 4, 20);
    public static final ArmorMaterial VOIDSTEEL = material("voidsteel", 45, 4, 10, 4, 22);
    public static final ArmorMaterial CELESTIUM = material("celestium", 50, 5, 11, 5, 25);

    private static ArmorMaterial material(String name, int durability, int defense, int toughness, int knockback, int enchant) {
        return new ArmorMaterial() {
            public int getDurabilityForType(ArmorItem.Type type) { return durability * type.getDurabilityMultiplier(); }
            public int getDefenseForType(ArmorItem.Type type) { return defense; }
            public int getEnchantmentValue() { return enchant; }
            public net.minecraft.sounds.SoundEvent getEquipSound() { return net.minecraft.sounds.SoundEvents.ARMOR_EQUIP_NETHERITE; }
            public Ingredient getRepairIngredient() { return Ingredient.of(Items.IRON_INGOT); }
            public String getName() { return UltimateOresAdventure.MODID + ":" + name; }
            public float getToughness() { return toughness; }
            public float getKnockbackResistance() { return knockback / 100f; }
        };
    }

    public static void register(net.minecraftforge.eventbus.api.IEventBus bus) {
        ARMOR.register(bus);
    }
}
