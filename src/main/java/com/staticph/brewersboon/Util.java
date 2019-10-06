package com.staticph.brewersboon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Util {
    public static final String MOD_ID = "brewersboon";
    public static final String MOD_PREFIX = MOD_ID + ":";
    public static final String MOD_NAME = "Brewer's Boon";


    public static Logger getLogger(String type) {
        return LogManager.getLogger(MOD_ID + "-" + type);
    }
}
//  https://github.com/SlimeKnights/TinkersConstruct/blob/1.14_rewrite/src/main/java/slimeknights/tconstruct/library/Util.java