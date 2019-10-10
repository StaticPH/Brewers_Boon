package com.staticph.brewersboon.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import slimeknights.mantle.item.GeneratedItem;

public class dummyItem extends GeneratedItem {

    public dummyItem(ItemGroup itemGroup){
        super(itemGroup);
//        this.setRegistryName("dummy_item");
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isInGroup(group)) {
        }
    }
}


//TODO: should implement https://github.com/TeamSpen210/Inspirations/blob/1.14/src/main/java/knightminer/inspirations/common/IHidable.java
// Example https://github.com/TeamSpen210/Inspirations/blob/1.14/src/main/java/knightminer/inspirations/utility/item/TorchLeverItem.java

//https://github.com/TeamSpen210/Inspirations/blob/1.14/src/main/java/knightminer/inspirations/building/block/BlockMulch.java


//https://github.com/TeamSpen210/Inspirations/blob/1.14/src/main/java/knightminer/inspirations/library/client/ClientUtil.java   what do?
//https://github.com/TeamSpen210/Inspirations/blob/1.14/src/main/java/knightminer/inspirations/library/util/TextureBlockUtil.java   how use?
//https://github.com/TeamSpen210/Inspirations/blob/1.14/src/main/java/knightminer/inspirations/shared/client/TextureModel.java  how use?
