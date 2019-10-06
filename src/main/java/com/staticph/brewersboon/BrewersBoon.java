package com.staticph.brewersboon;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Util.MOD_ID)
public class BrewersBoon {

    // Directly reference a log4j logger.
    static final Logger LOGGER = LogManager.getLogger(Util.MOD_ID); //was private, changed to package-private

    public BrewersBoon () {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup (final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff (final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC (final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC (final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(
                        m -> m.getMessageSupplier().get()
                ).collect(Collectors.toList())
        );
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting (FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
//    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents {
//        @SubscribeEvent
//        public static void onBlocksRegistry (final RegistryEvent.Register<Block> blockRegistryEvent) {
//            // register a new block here
//            LOGGER.info("HELLO from Register Block");
//        }
//    }

    private void gatherData (final GatherDataEvent event) {
        DataGenerator datagenerator = event.getGenerator();

        if (event.includeServer()) {
//            datagenerator.addProvider(new)
        }

    }
}
/*
https://github.com/Direwolf20-MC/BuildingGadgets/blob/master/src/main/java/com/direwolf20/buildinggadgets/common/registry/OurContainers.java
https://github.com/Direwolf20-MC/BuildingGadgets/blob/master/src/main/java/com/direwolf20/buildinggadgets/common/registry/OurItems.java
https://github.com/Direwolf20-MC/BuildingGadgets/tree/master/src/main/java/com/direwolf20/buildinggadgets/common/util/blocks
https://github.com/Direwolf20-MC/BuildingGadgets/blob/master/src/main/java/com/direwolf20/buildinggadgets/common/util/helpers/InventoryHelper.java
https://github.com/Mrbysco/StructureCompass/blob/1.14/src/main/java/com/mrbysco/structurecompass/StructureCompass.java



mc.src.net/minecraftforge/event/brewing/PotionBrewEvent.java
mc.src.net/minecraftforge/event/ForgeEventFactory.java
mc.src.net/minecraftforge/event/world/BlockEvent.java
mc.src.net/minecraftforge/event/world/GetCollisionBoxesEvent.java
mc.src.net/minecraftforge/event/entity/player/PlayerInteractEvent.java
mc.src.net/minecraftforge/event/entity/player/PlayerEvent.java:380  and/or  mc.src.net/minecraftforge/event/entity/player/EntityItemPickupEvent.java    item pickup event

mc.src.net/minecraftforge/common/brewing/VanillaBrewingRecipe.java
mc.src.net/minecraftforge/common/brewing/IBrewingRecipe.java
mc.src.net/minecraftforge/common/brewing/BrewingRecipeRegistry.java
mc.src.net/minecraftforge/common/brewing/BrewingRecipe.java


mc.src.net/minecraftforge/event/entity/living/PotionEvent.java
mc.src.net/minecraftforge/common/extensions/IForgeEffectInstance.java

mc.src.net/minecraftforge/common/extensions/IForgeEffect.java
mc.src.net/minecraftforge/event/furnace/FurnaceFuelBurnTimeEvent.java
mc.src.net/minecraftforge/event/entity/living/PotionColorCalculationEvent.java: 59 & 64 particles

mc.src.net/minecraftforge/common/crafting/CompoundIngredient.java   no idea what this does

 */