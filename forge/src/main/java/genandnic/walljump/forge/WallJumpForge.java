package genandnic.walljump.forge;

import dev.architectury.platform.forge.EventBuses;
import genandnic.walljump.WallJump;
import genandnic.walljump.WallJumpClient;
import genandnic.walljump.util.registry.config.WallJumpConfigEntries;
import genandnic.walljump.util.Constants;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class WallJumpForge {
    public WallJumpForge() {
        EventBuses.registerModEventBus(Constants.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        EventBuses.getModEventBus(Constants.MOD_ID).get().addListener(this::onClientSetup);
        registerConfigScreen();
        WallJump.init();
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(WallJumpClient::init);
    }

    private void registerConfigScreen() {
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        (client, parent) -> AutoConfig.getConfigScreen(WallJumpConfigEntries.class, parent).get()));
    }
}
