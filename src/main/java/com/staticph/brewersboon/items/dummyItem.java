package com.staticph.brewersboon.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
public class dummyItem extends Item {

    public dummyItem(ItemGroup itemGroup){
        super(new Properties().group(itemGroup));
    }
}
