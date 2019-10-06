package com.staticph.brewersboon;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;

import static net.minecraftforge.fml.Logging.CORE;

/*
Format according to :
https://github.com/Mrbysco/Durability-Notifier/blob/1.14/src/main/java/com/Mrbysco/durabilitynotifier/config/DurabilityConfigGen.java   (commit/43507d1d6162b2972848ef457fb93eab7d63fff8)
https://github.com/Direwolf20-MC/BuildingGadgets/blob/master/src/main/java/com/direwolf20/buildinggadgets/common/config/Config.java (commit/53d2dafa8277797d4c0a81c35c7f3ada48a2b738)
net.minecraftforge.common.ForgeConfig.java
 */


/* Only onLoad and onFileChange actually need to be subscribed,
but it shouldn't be a problem to just annotate the whole class...*/
@EventBusSubscriber
public class Config {
    // Use this for things only the individual client needs to know about, like HUD positioning
    private static final Builder CLIENT_BUILDER = new Builder();
    // Use this for things only the server needs to know about
    private static final Builder SERVER_BUILDER = new Builder();
    /* Use this for things both the server and the client need to know about, like new blocks/items
    Also for things where you can't really figure out which of the two to use, though ideally you'll figure it out.*/
    private static final Builder COMMON_BUILDER = new Builder();

    public static final String CATEGORY_GENERAL = "General";
    public static final String CATEGORY_ITEMS = "Items";
    public static final String CATEGORY_BLOCKS = "Blocks";
    public static final String CATEGORY_COMPAT = "Compat";


/*    public static void pushAll(String comment, String categoryHeader){
        SERVER_BUILDER.comment(comment).push(categoryHeader);
        COMMON_BUILDER.comment(comment).push(categoryHeader);
        CLIENT_BUILDER.comment(comment).push(categoryHeader);
    }

    public static void popAll(){
        CLIENT_BUILDER.pop();
        COMMON_BUILDER.pop();
        SERVER_BUILDER.pop();
    }

    public static void pushBuilders(Builder[] builders, String comment, String categoryHeader){
        for (Builder b : builders) {
            b.comment(comment).push(categoryHeader);
        }
    }*/

    public static void markCategory (Builder builder, String categoryLabel) {
        markCategory(builder, null, categoryLabel);
    }

    public static void markCategory (Builder builder, String info, String categoryLabel) {
        builder.comment(info).push(categoryLabel);
    }

    public static final CategoryGeneral GENERAL = new CategoryGeneral();
    public static final CategoryItems ITEMS = new CategoryItems();
    public static final CategoryBlocks BLOCKS = new CategoryBlocks();
    public static final CategoryCompat COMPAT = new CategoryCompat();

    public static final class CategoryGeneral {
        public final ConfigValue<String> someVal;

        private CategoryGeneral () {
            markCategory(SERVER_BUILDER, "General Mod Settings", CATEGORY_GENERAL);
            markCategory(COMMON_BUILDER, "General Mod Settings", CATEGORY_GENERAL);
            markCategory(CLIENT_BUILDER, "General Mod Settings", CATEGORY_GENERAL);

            someVal = COMMON_BUILDER
                    .comment("Some arbitrary string value")
//                    .translation()
                    .define("someVal", "abcd127");

            CLIENT_BUILDER.pop();
            COMMON_BUILDER.pop();
            SERVER_BUILDER.pop();
        }
    }

    public static final class CategoryItems {
        private CategoryItems () {
            markCategory(COMMON_BUILDER, "Item Settings", CATEGORY_ITEMS);

            COMMON_BUILDER.pop();
        }
    }

    public static final class CategoryBlocks {
        private CategoryBlocks () {
            markCategory(COMMON_BUILDER, "Block Settings", CATEGORY_BLOCKS);

            COMMON_BUILDER.pop();
        }
    }

    public static final class CategoryCompat {
        private CategoryCompat () {
            markCategory(SERVER_BUILDER, "Compatibility Settings", CATEGORY_COMPAT);
            markCategory(COMMON_BUILDER, "Compatibility Settings", CATEGORY_COMPAT);
            markCategory(CLIENT_BUILDER, "Compatibility Settings", CATEGORY_COMPAT);


            CLIENT_BUILDER.pop();
            COMMON_BUILDER.pop();
            SERVER_BUILDER.pop();
        }
    }

    public static final ForgeConfigSpec CLIENT_CONFIG = CLIENT_BUILDER.build();
    public static final ForgeConfigSpec SERVER_CONFIG = SERVER_BUILDER.build();
    public static final ForgeConfigSpec COMMON_CONFIG = COMMON_BUILDER.build();
/*    private static boolean serverCfgLoaded = false;

    private static void loadServerConfig() {
        BLACKLIST.parseBlacklists();
        serverCfgLoaded = true;
    }*/

    public static void onLoad (final ModConfig.Loading configEvent) {
//        if (configEvent.getConfig().getSpec() == Config.SERVER_CONFIG){ loadServerConfig(); }
        BrewersBoon.LOGGER.debug(
                "Loaded config file {} for mod {}", configEvent.getConfig().getFileName(), Util.MOD_NAME);
//        BrewersBoon.LOGGER.debug(FORGEMOD, "Loaded config file {} for mod {}", configEvent.getConfig().getFileName(), Util.MOD_NAME);s
    }

    public static void onFileChange (final ModConfig.ConfigReloading configEvent) {
        BrewersBoon.LOGGER.fatal(CORE, "{} config just got changed on the file system!", Util.MOD_NAME);
    }

}

