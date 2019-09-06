package xyz.akirin.osmpmgr.items

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import xyz.akirin.osmpmgr.OMMain

class ItemBkWEWand : Item() {
    init {
        //レジストリに保存する名称を登録する。大文字禁止。
        this.setRegistryName(OMMain.ID, "item_bkwand")
        //クリエイティブタブを設定する。
        this.creativeTab = CreativeTabs.TOOLS
        //翻訳名を登録する。大文字非推奨。
        this.unlocalizedName = /*OMMain.ID + ":" + */"item_bkwand"
        this.setMaxStackSize(1)
    }
}
