package com.staticph.brewersboon.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ObjectHolder;

import org.apache.logging.log4j.Logger;

import slimeknights.mantle.client.CreativeTab;
import slimeknights.mantle.common.IRegisterUtil;

import com.staticph.brewersboon.Util;
import com.staticph.brewersboon.items.dummyItem;

@ObjectHolder(Util.MOD_ID)
public class RegistryHandler implements IRegisterUtil {
    static final Logger log = Util.getLogger("RegistryHandler");

    public static final dummyItem dummy_item = null;

    @Override
    public String getModId(){ return Util.MOD_ID;}

    public static CreativeTab modCreativeTab = new CreativeTab("brewersboon", new ItemStack(dummy_item));


    public static void setup(){

    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

    }
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event){
        log.info("Loading items");
        IForgeRegistry<Item> registry = event.getRegistry();
        /*boolean forceAll = false;

        if (someconfig || forceAll) {
            some item that can be en/disabled in the config
        }*/
        register(registry, new dummyItem(modCreativeTab), "dummy_item");
    }

    @SubscribeEvent
    public void postInit(final InterModProcessEvent event) {
        modCreativeTab.setDisplayIcon(new ItemStack(dummy_item));
    }
}
