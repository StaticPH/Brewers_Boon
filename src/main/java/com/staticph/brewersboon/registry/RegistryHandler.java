package com.staticph.brewersboon.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ObjectHolder;

import org.apache.logging.log4j.Logger;

import com.staticph.brewersboon.CreativeTab;
import com.staticph.brewersboon.Util;
import com.staticph.brewersboon.items.dummyItem;

@ObjectHolder(Util.MOD_ID)
public class RegistryHandler implements IRegisterUtil{
    static final Logger log = Util.getLogger("RegistryHandler");

    public static final dummyItem dummy_item = null;

    @Override
    public String getModId(){ return Util.MOD_ID;}

//    public static ItemGroup buildCreativeTab(ItemStack itemStack){
//
//    }
//    public static ItemGroup modCreativeTab = new ItemGroup(Util.MOD_ID) {
//        @Override
//        public ItemStack createIcon () { return new ItemStack(dummy_item);}
//    };

    public static CreativeTab modCreativeTab = new CreativeTab("brewersboon", new ItemStack(dummy_item));

/*
https://github.com/Direwolf20-MC/BuildingGadgets/blob/master/src/main/java/com/direwolf20/buildinggadgets/common/registry/OurItems.java#L99
https://github.com/Direwolf20-MC/BuildingGadgets/search?q=creativetab&unscoped_q=creativetab
https://github.com/Direwolf20-MC/BuildingGadgets/blob/master/src/main/java/com/direwolf20/buildinggadgets/common/registry/RegistryHandler.java
https://github.com/Direwolf20-MC/BuildingGadgets/blob/master/src/main/java/com/direwolf20/buildinggadgets/common/util/ref/Reference.java
https://github.com/Direwolf20-MC/BuildingGadgets/tree/master/src/main/java/com/direwolf20/buildinggadgets/common/util/lang

 */

    public static void setup(){

    }
//   https://github.com/SlimeKnights/Mantle/blob/1.14/src/main/java/slimeknights/mantle/common/IRegisterUtil.java

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
}
