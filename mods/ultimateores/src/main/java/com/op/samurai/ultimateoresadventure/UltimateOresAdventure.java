package com.op.samurai.ultimateoresadventure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(UltimateOresAdventure.MODID)
public class UltimateOresAdventure {
    public static final String MODID = "ultimateoresadventure";

    public UltimateOresAdventure() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(bus);
        ModBlocks.register(bus);
        ModArmor.register(bus);
    }
}
