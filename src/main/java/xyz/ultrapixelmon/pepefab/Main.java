package xyz.ultrapixelmon.pepefab;

import com.pixelmonmod.pixelmon.Pixelmon;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION, acceptableRemoteVersions = "*" )
public class Main
{
    public static final String MODID = "disableafkbattle";
    public static final String NAME = "DisableAFKBattle";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("[DisableAFKBattleSpigot] Activation du plugin version: " + Main.VERSION);

        MinecraftForge.EVENT_BUS.register(new Listeners());
        Pixelmon.EVENT_BUS.register(new Listeners());

    }
}
