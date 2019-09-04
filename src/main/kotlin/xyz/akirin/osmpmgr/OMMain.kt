package xyz.akirin.osmpmgr

import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLConstructionEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import xyz.akirin.osmpmgr.items.ItemBkWEWand
import xyz.akirin.osmpmgr.items.ItemFgWEWand



@Mod(modid = OMMain.ID, name = OMMain.Name, version = OMMain.Version, modLanguage = OMMain.Lang)
class OMMain {

    //    public static CreativeTabs tabOMSPMgr = new OMct("OMSPMgrtab");

    @Mod.EventHandler
    //この関数でMODファイル自体をイベントの発火先にする。
    fun construct(event: FMLConstructionEvent) {
        MinecraftForge.EVENT_BUS.register(this)
    }

    //アイテムを登録するイベント。旧preinitのタイミングで発火する。
    @SubscribeEvent
    fun registerItems(event: RegistryEvent.Register<Item>) {
        event.registry.register(BkWEWand)
        event.registry.register(FgWEWand)
    }

    //モデルを登録するイベント。SideOnlyによってクライアント側のみ呼ばれる。旧preinitのタイミングで発火する。
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    fun registerModels(event: ModelRegistryEvent) {
        ModelLoader.setCustomModelResourceLocation(BkWEWand, 0, ModelResourceLocation(ResourceLocation(ID, "item_bkwand"), "inventory"))
        ModelLoader.setCustomModelResourceLocation(FgWEWand, 0, ModelResourceLocation(ResourceLocation(ID, "item_fgwand"), "inventory"))
    }

    companion object {

        const val ID = "osmpmgr"
        internal const val Name = "Orange Server ModPack Manager"
        internal const val Version = "code-1.0.0-beta"
        internal const val Lang = "kotlin"

        val BkWEWand: Item = ItemBkWEWand()
        val FgWEWand: Item = ItemFgWEWand()
//        val OMTab = OMTab()

    }
}