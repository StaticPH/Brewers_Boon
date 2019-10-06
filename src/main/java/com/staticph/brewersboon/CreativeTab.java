package com.staticph.brewersboon;

// This contents of this class have been copied from
// https://github.com/SlimeKnights/Mantle/blob/1.14/src/main/java/slimeknights/mantle/client/CreativeTab.java
// I make no claims of ownership to any content below this line, unless otherwise explicitly stated

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

public class CreativeTab extends ItemGroup {
    private ItemStack icon;

    public CreativeTab(String label, ItemStack forcedIcon){
        super(label);
        this.icon=forcedIcon;
    }

    public void setDisplayIcon(ItemStack displayIcon) {
        if (!displayIcon.isEmpty()) {
            this.icon = displayIcon;
        }
    }

    @Nonnull
    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack getIcon() {
        return this.icon;
    }

    @Nonnull
    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack createIcon() {
        return this.icon;
    }
}
