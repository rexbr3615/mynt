package net.rexbrx.mynt;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.rexbrx.mynt.oasis.myFileEngine;
import net.rexbrx.mynt.utils.myFileUtils;
import net.rexbrx.mynt.utils.myLogger;
import net.rexbrx.mynt.wine.myWineCommands;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Mynt.MODID)
public class Mynt {
    public static final String MODID = "mynt";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Mynt(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        myLogger.myDebug("Mynt Initialized!");
        LOGGER.info("Mynt Setup!");

    }

    //private void exception() throws IOException {

        //File testfile = new File(myFileEngine.create_mynt_text_v1("mynt_common_setup_test").toURI());
        //myFileUtils.writeToFile(testfile, true, "linha 1 :D\n");
        ///myFileUtils.writeToFile(testfile, true, "linha 2 :D\n");
        //myFileUtils.writeToFile(testfile, true, "linha 3 :D\n");


    //}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Mynt on server!");
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        myWineCommands.registerCommands(event);
    }

}
