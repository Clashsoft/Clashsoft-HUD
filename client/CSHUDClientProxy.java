package clashsoft.mods.cshud.client;

import clashsoft.mods.cshud.api.IHUDComponent;
import clashsoft.mods.cshud.client.gui.GuiCSHUDIngame;
import clashsoft.mods.cshud.common.CSHUDCommonProxy;
import clashsoft.mods.cshud.components.HUDCurrentObject;
import clashsoft.mods.cshud.components.HUDItemPickups;
import clashsoft.mods.cshud.components.HUDPotionEffects;
import clashsoft.mods.cshud.components.HUDWorldInfo;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import net.minecraftforge.common.MinecraftForge;

public class CSHUDClientProxy extends CSHUDCommonProxy
{	
	@Override
	public void init()
	{
		TickRegistry.registerTickHandler(new CSHUDClientTickHandler(), Side.CLIENT);
		
		MinecraftForge.EVENT_BUS.register(GuiCSHUDIngame.instance);
		MinecraftForge.EVENT_BUS.register(HUDItemPickups.instance);
		
		registerHUDComponents();
	}
	
	public void registerHUDComponents()
	{
		registerHUDComponent(new HUDCurrentObject());
		registerHUDComponent(new HUDPotionEffects());
		registerHUDComponent(new HUDWorldInfo());
		registerHUDComponent(HUDItemPickups.instance);
	}
	
	@Override
	public void registerHUDComponent(IHUDComponent component)
	{
		GuiCSHUDIngame.instance.registerHUDComponent(component);
	}
}
