package JohnTheAwsome123.mods.AdvancedCraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * AdvancedCraft
 * 
 * Doubler
 * @category Item
 * @author JohnTheAwsome123
 * 
 */
public class Doubler extends Item
{

    public Doubler(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
        this.setCreativeTab(Reference.ACTAB);
        this.setUnlocalizedName("Doubler");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1registerIcon){
        this.itemIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this));
    }
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
    list.add("Crafted with any item. Results in a duplicate.");
    }
}
