package com.op.samurai.ultimateoresadventure;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UltimateOresAdventure.MODID);

    public static final RegistryObject<Item> TITANIUM_INGOT = item("titanium_ingot");
    public static final RegistryObject<Item> BRASS_INGOT = item("brass_ingot");
    public static final RegistryObject<Item> BRONZE_INGOT = item("bronze_ingot");
    public static final RegistryObject<Item> STEEL_INGOT = item("steel_ingot");
    public static final RegistryObject<Item> INVAR_INGOT = item("invar_ingot");
    public static final RegistryObject<Item> ELECTRUM_INGOT = item("electrum_ingot");

    public static final RegistryObject<Item> ASTRAL_INGOT = item("astral_ingot");
    public static final RegistryObject<Item> VOIDSTEEL_INGOT = item("voidsteel_ingot");
    public static final RegistryObject<Item> CELESTIUM_INGOT = item("celestium_ingot");

    public static final RegistryObject<Item> SUN_CORE = item("sun_core");
    public static final RegistryObject<Item> VOID_HEART = item("void_heart");
    public static final RegistryObject<Item> CELESTIAL_SHARD = item("celestial_shard");
    public static final RegistryObject<Item> BOSS_TROPHY = item("boss_trophy");

    private static RegistryObject<Item> item(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    public static void register(net.minecraftforge.eventbus.api.IEventBus bus) {
        ITEMS.register(bus);
    }
}
