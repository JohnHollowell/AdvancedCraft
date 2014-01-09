package JohnTheAwsome123.mods.AdvancedCraft.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class netherStarShovel extends ItemSpade
{

    public netherStarShovel(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, par2EnumToolMaterial);
        this.setCreativeTab(Reference.ACTAB);
        this.setUnlocalizedName("netherStar_Shovel");
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this, "tool/"));
    }
}
