package com.op.samurai.ultimateoresadventure;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UltimateOresAdventure.MODID);

    public static final RegistryObject<Block> TITANIUM_ORE = ore("titanium_ore");
    public static final RegistryObject<Block> BRASS_ORE = ore("brass_ore");
    public static final RegistryObject<Block> BRONZE_ORE = ore("bronze_ore");
    public static final RegistryObject<Block> STEEL_ORE = ore("steel_ore");
    public static final RegistryObject<Block> INVAR_ORE = ore("invar_ore");
    public static final RegistryObject<Block> ELECTRUM_ORE = ore("electrum_ore");

    public static final RegistryObject<Block> ASTRAL_ORE = ore("astral_ore");
    public static final RegistryObject<Block> VOIDSTEEL_ORE = ore("voidsteel_ore");
    public static final RegistryObject<Block> CELESTIUM_ORE = ore("celestium_ore");

    private static RegistryObject<Block> ore(String name) {
        return BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.of()
                .strength(3.0f, 6.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    }

    public static void register(net.minecraftforge.eventbus.api.IEventBus bus) {
        BLOCKS.register(bus);
    }
}
