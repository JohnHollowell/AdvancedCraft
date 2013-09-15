package JohnTheAwsome123.mods.AdvancedCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import JohnTheAwsome123.mods.AdvancedCraft.food.*;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import JohnTheAwsome123.mods.AdvancedCraft.armor.*;
import JohnTheAwsome123.mods.AdvancedCraft.item.*;
import JohnTheAwsome123.mods.AdvancedCraft.block.*;
import JohnTheAwsome123.mods.AdvancedCraft.tools.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.*;

@Mod(modid="AdvancedCraft", name="AdvancedCraft", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class AdvancedCraft {
        
    public static CreativeTabs tabAdvancedCraft = new CreativeTabs("tabAdvancedCraft") {
        public ItemStack getIconItemStack() {
                return new ItemStack(Block.workbench);
        }
    };
        
        //Define Items//
        public static Item enderHeart;
        public static int enderHeartID;
        
        public static Item netherStarNugget;
        public static int netherStarNuggetID;
        
        public static Item netherStarShard;
        public static int netherStarShardID;
        
        //Define Food//
        public static Item sugarCookie;
        public static int sugarCookieID;
        
        public static Item sugarCookieDough;
        public static int sugarCookieDoughID;
        
        public static Item cookieDough;
        public static int cookieDoughID;
        
        
        //Define Tool Material
        public static EnumToolMaterial netherStarTool = EnumHelper.addToolMaterial("netherStar", 4, 1024, 10.0F, 4.0F, 30);
        
        //Define Tools//
        public static Item netherStarPickaxe;
        public static int netherStarPickaxeID;
        
        public static Item netherStarAxe;
        public static int netherStarAxeID;
        
        public static Item netherStarShovel;
        public static int netherStarShovelID;
        
        public static Item netherStarSword;
        public static int netherStarSwordID;
        
        public static Item netherStarHoe;
        public static int netherStarHoeID;
        
        public static Item netherStarOmniTool;
        public static int netherStarOmniToolID;
        
        
        
        //Define Blocks//
        public static Block netherStarBlock;
        public static int netherStarBlockID;
        
        public static Block netherStarOre;
        public static int netherStarOreID;
        
        public static Block advancedFurnace;
        public static int advancedFurnaceID;
        
        public static Block glowstoneLampActive;
        public static int glowstoneLampActiveID;
        
        public static Block glowstoneLampIdle;
        public static int glowstoneLampIdleID;
        
        
        //Define  Armor Material
        public static EnumArmorMaterial netherStarArmor = EnumHelper.addArmorMaterial("netherStar", 75, new int[]{5, 10, 8, 5}, 30);
        
        
        //Define Armor//
        public static Item netherStarHelmet;
        public static int netherStarHelmetID;
        
        public static Item netherStarChestplate;
        public static int netherStarChestplateID;
        
        public static Item netherStarLeggings;
        public static int netherStarLeggingsID;
        
        public static Item netherStarBoots;
        public static int netherStarBootsID;
        
        //Define Item Crafting Disabling//
        public static boolean disableDragonEgg;
        
        //Define Food Crafting Disabling//
        public static boolean disableAlternateCookie;
        
        //Define Armor Disabling//
        public static boolean disableNetherStarHelmet;
        public static boolean disableNetherStarChestplate;
        public static boolean disableNetherStarLeggings;
        public static boolean disableNetherStarBoots;
        
        
        // The instance of your mod that Forge uses.
        @Instance("AdvancedCraft")
        public static AdvancedCraft instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="JohnTheAwsome123.mods.AdvancedCraft.client.ClientProxy", serverSide="JohnTheAwsome123.mods.AdvancedCraft.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
            System.out.println("Loading AdvancedCraft");
                // Stub Method
                proxy.registerRenderers();
                
                
                LanguageRegistry.instance().addStringLocalization("itemGroup.tabAdvancedCraft", "en_US", "AdvancedCraft");
                //Set up Config File//
                Configuration config = new Configuration(event.getSuggestedConfigurationFile());
                config.load();
                
                //Cofigs for armor//
                netherStarHelmetID = config.getItem("Nether Star Helmet", 2020).getInt();
                netherStarChestplateID = config.getItem("Nether Star Chestplate", 2021).getInt();
                netherStarLeggingsID = config.getItem("Nether Star Leggings", 2022).getInt();
                netherStarBootsID = config.getItem("Nether Star Boots", 2023).getInt();
                
                disableNetherStarHelmet = config.get(config.CATEGORY_GENERAL, "disable Nether Star Helmet", false).getBoolean(false);
                disableNetherStarChestplate = config.get(config.CATEGORY_GENERAL, "disable Nether Star Chestplate", false).getBoolean(false);
                disableNetherStarLeggings = config.get(config.CATEGORY_GENERAL, "disable Nether Star Leggings", false).getBoolean(false);
                disableNetherStarBoots = config.get(config.CATEGORY_GENERAL, "disable Nether Star Boots", false).getBoolean(false);
                
                //Configs for Items//
                netherStarShardID = config.getItem("Nether Star Shard", 2010).getInt();
                netherStarNuggetID = config.getItem("Nether Star Nugget", 2011).getInt();
                enderHeartID = config.getItem("Ender Heart", 2012).getInt();
                
                disableDragonEgg = config.get(config.CATEGORY_GENERAL, "disable Dragon Egg crafting", false).getBoolean(false);
                
                //Configs for Food//
                sugarCookieID = config.getItem("Sugar Cookie", 213).getInt();
                sugarCookieDoughID = config.getItem("Sugar Cookie Dough", 214).getInt();
                cookieDoughID = config.getItem("Cookie Dough", 215).getInt();
                
                disableAlternateCookie= config.get(config.CATEGORY_GENERAL, "disable alternate cookie recipes", false).getBoolean(false);
                
                //Configs for Tools//
                netherStarSwordID = config.getItem("Nether Star Sword", 2013).getInt();
                netherStarShovelID = config.getItem("Nether Star Shovel", 2014).getInt();
                netherStarPickaxeID = config.getItem("Nether Star Pickaxe", 2015).getInt();
                netherStarAxeID = config.getItem("Nether Star Axe", 2016).getInt();
                netherStarHoeID = config.getItem("Nether Star Hoe", 2017).getInt();
                netherStarOmniToolID = config.getItem("Nether Star Omni Tool", 2018).getInt();
                
                
                
                //Configs for Blocks//
                netherStarBlockID = config.getBlock("Nether Star Block", 210).getInt();
                netherStarOreID = config.getBlock("Nether Star Ore", 211).getInt();
                advancedFurnaceID = config.getBlock("Advanced Furnace", 212).getInt();
                
                
                
                config.save();
                
                //Remove Vanilla crafting recipes//
                if (!disableAlternateCookie) {removeVanillaRecipe.remove(Item.cookie);}
                
                
                //Settings for NS Armor
//                if (!DisableNetherStarHelmet){
                netherStarHelmet = new netherStarHelmet(netherStarHelmetID, netherStarArmor, ModLoader.addArmor("netherStar"), 0);//}
                netherStarChestplate = new netherStarChestplate(netherStarChestplateID, netherStarArmor, ModLoader.addArmor("netherStar"), 1);
                netherStarLeggings = new netherStarLeggings(netherStarLeggingsID, netherStarArmor, ModLoader.addArmor("netherStar"), 2);
                netherStarBoots = new netherStarBoots(netherStarBootsID, netherStarArmor, ModLoader.addArmor("netherStar"), 3);
                
                
                
                //Set up Items//
                 enderHeart = new enderHeart(enderHeartID);
                 netherStarNugget = new netherStarNugget(netherStarNuggetID);
                 netherStarShard = new netherStarShard(netherStarShardID);
                 
                 
                 
                 //Set up Food//
                 sugarCookie = new sugarCookie(sugarCookieID, 2, false);
                 sugarCookieDough = new sugarCookieDough(sugarCookieDoughID, 1, 0.1F, false);
                 cookieDough = new cookieDough(cookieDoughID, 1, 0.1F, false);
                 
                 
                 
                 //Set up Tools//
                 netherStarSword = new netherStarSword(netherStarSwordID, netherStarTool);
                 netherStarShovel = new netherStarShovel(netherStarShovelID, netherStarTool);
                 netherStarPickaxe = new netherStarPickaxe(netherStarPickaxeID, netherStarTool);
                 netherStarAxe = new netherStarAxe(netherStarAxeID, netherStarTool);
                 netherStarHoe = new netherStarHoe(netherStarHoeID, netherStarTool);
                 netherStarOmniTool = new netherStarOmniTool(netherStarOmniToolID, netherStarTool);
                 
                 
                 
                 //Set up Blocks//
                 netherStarBlock = new netherStarBlock(netherStarBlockID, Material.iron);
                 netherStarOre = new netherStarOre(netherStarOreID, Material.rock);
                 glowstoneLampIdle = (new GlowstoneLamp(123, false));
                 glowstoneLampActive = (new GlowstoneLamp(124, true));
//                 advancedFurnace = new advancedFurnace(advancedFurnaceID, false);
                 
                 
                 
//                final Item EnderShard = new EnderShard(5000);
//                final Block blazingTorch = new blazingTorch(5001);
//                blazingTorch = new blazingTorch(500).setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Blazing Torch").setCreativeTab(CreativeTabs.tabDecorations);
//                GameRegistry.registerBlock(blazingTorch, "blazingTorch");
//                LanguageRegistry.addName(blazingTorch, "Blazing Torch");
                
                //Register Blocks//
                GameRegistry.registerBlock(netherStarBlock, "netherStarBlock");
                LanguageRegistry.addName(netherStarBlock, "Nether Star Block");
                MinecraftForge.setBlockHarvestLevel(netherStarBlock, "pickaxe", 4);
                
                GameRegistry.registerBlock(netherStarOre, "netherStarOre");
                LanguageRegistry.addName(netherStarOre, "Nether Star Ore");
                MinecraftForge.setBlockHarvestLevel(netherStarOre, "pickaxe", 3);
                
              
                 
                //Register Armor//
                GameRegistry.registerItem(netherStarHelmet, "netherStarHelmet");
                LanguageRegistry.addName(netherStarHelmet, "Nether Star Helmet");
//                LanguageRegistry.instance().addStringLocalization("item.NetherStarHelmet.name", "en_US", "Nether Star Helmet");
                
                GameRegistry.registerItem(netherStarChestplate, "netherStarChestplate");
                LanguageRegistry.addName(netherStarChestplate, "Nether Star Chestplate");
                
                GameRegistry.registerItem(netherStarLeggings, "netherStarLeggings");
                LanguageRegistry.addName(netherStarLeggings, "Nether Star Leggings");
                
                GameRegistry.registerItem(netherStarBoots, "netherStarBoots");
                LanguageRegistry.addName(netherStarBoots, "Nether Star Boots");
                
                //Register Items//
                GameRegistry.registerItem(netherStarNugget, "netherStarNugget");
                LanguageRegistry.addName(netherStarNugget, "Nether Star Nugget");
                
                GameRegistry.registerItem(netherStarShard, "netherStarShard");
                LanguageRegistry.addName(netherStarShard, "Nether Star Shard");
                
                GameRegistry.registerItem(enderHeart, "enderHeart");
                LanguageRegistry.addName(enderHeart, "Ender Heart");
                
                
                //Register Food//
                GameRegistry.registerItem(sugarCookie, "sugarCookie");
                LanguageRegistry.addName(sugarCookie, "Sugar Cookie");
                
                GameRegistry.registerItem(sugarCookieDough, "sugarCookieDough");
                LanguageRegistry.addName(sugarCookieDough, "Sugar Cookie Dough");
                
                GameRegistry.registerItem(cookieDough, "cookieDough");
                LanguageRegistry.addName(cookieDough, "Cookie Dough");
                
                
                //Register Fuels//
                GameRegistry.registerFuelHandler(new AdvancedCraftFuelHandler());
                
                
                
                //Register Tools//
                GameRegistry.registerItem(netherStarSword, "netherStarSword");
                LanguageRegistry.addName(netherStarSword, "Nether Star Sword");
                
                GameRegistry.registerItem(netherStarShovel, "netherStarShovel");
                LanguageRegistry.addName(netherStarShovel, "Nether Star Shovel");
                
                GameRegistry.registerItem(netherStarPickaxe, "netherStarPickaxe");
                LanguageRegistry.addName(netherStarPickaxe, "Nether Star Pickaxe");
                
                GameRegistry.registerItem(netherStarAxe, "netherStarAxe");
                LanguageRegistry.addName(netherStarAxe, "Nether Star Axe");
                
                GameRegistry.registerItem(netherStarHoe, "netherStarHoe");
                LanguageRegistry.addName(netherStarHoe, "Nether Star Hoe");
                
                GameRegistry.registerItem(netherStarOmniTool, "netherStarOmniTool");
                LanguageRegistry.addName(netherStarOmniTool, "Nether Star Omni Tool");
                
                
                
                //Universal Ingredients//
                ItemStack nStarStack = new ItemStack(Item.netherStar);
                ItemStack stickStack = new ItemStack(Item.stick);
                
                
                
                //Recipes for Blocks//
                GameRegistry.addRecipe(new ItemStack(Block.web), "s s", " s ", "s s",
                        's', new ItemStack(Item.silk));
                GameRegistry.addRecipe(new ItemStack(Block.mycelium), "ddd", "dmd", "ddd",
                        'm', new ItemStack(Block.mushroomRed), 'd', new ItemStack(Block.dirt));
                GameRegistry.addRecipe(new ItemStack(Block.mycelium), "ddd", "dmd", "ddd",
                        'm', new ItemStack(Block.mushroomBrown), 'd', new ItemStack(Block.dirt));
                GameRegistry.addShapelessRecipe(new ItemStack(Block.planks), new ItemStack(Item.stick), new ItemStack(Item.stick), new ItemStack(Item.stick), new ItemStack(Item.stick));
                GameRegistry.addShapelessRecipe(new ItemStack(Block.wood), new ItemStack(Block.planks), new ItemStack(Block.planks), new ItemStack(Block.planks), new ItemStack(Block.planks));
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarBlock), "sss", "sss", "sss",
                        's', new ItemStack(Item.netherStar));
                
                
                
                //Recipes for Items//
                GameRegistry.addRecipe(new ItemStack(Item.emerald), "ggg", "gdg", "ggg",
                        'g', new ItemStack(Item.dyePowder, 1, 2), 'd', new ItemStack(Item.diamond));
                if (!disableDragonEgg){
                GameRegistry.addRecipe(new ItemStack(Block.dragonEgg), " o ", "oho", "ooo",
                        'o', new ItemStack(Block.obsidian), 'h', new ItemStack(AdvancedCraft.enderHeart));}
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.enderHeart), "ses", "oho", "ooo",
                        'o', new ItemStack(Block.obsidian), 's', new ItemStack(Block.whiteStone));
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarNugget), "sss", "sss", "sss",
                        's', new ItemStack(AdvancedCraft.netherStarShard));
                GameRegistry.addRecipe(new ItemStack(Item.netherStar), "nnn", "nnn", "nnn",
                        'n', new ItemStack(AdvancedCraft.netherStarNugget));
                GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.netherStarShard, 9), new ItemStack(AdvancedCraft.netherStarNugget));
                GameRegistry.addShapelessRecipe(new ItemStack(AdvancedCraft.netherStarNugget, 9), new ItemStack(Item.netherStar));
                GameRegistry.addShapelessRecipe(new ItemStack(Item.netherStar, 9), new ItemStack(AdvancedCraft.netherStarBlock));
                
                
                
                //Recipes for Food//
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.sugarCookieDough), "wsw",
                        'w', new ItemStack(Item.wheat), 's', new ItemStack(Item.sugar));
                if (!disableAlternateCookie){
                    GameRegistry.addRecipe(new ItemStack(AdvancedCraft.cookieDough), "wcw",
                            'c', new ItemStack(Item.cookie), 'w', new ItemStack(Item.wheat));}
                
                
                
                //Recipes for Armor//
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarHelmet), "nnn", "n n", "   ",
                        'n', new ItemStack(Item.netherStar));
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarChestplate), "n n", "nnn", "nnn",
                        'n', new ItemStack(Item.netherStar));
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarLeggings), "nnn", "n n", "n n",
                        'n', new ItemStack(Item.netherStar));
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarBoots), "n n", "n n",
                        'n', new ItemStack(Item.netherStar));
                
                
                
                //Recipes for Tools//
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarSword), " n ", " n ", " s ",
                        'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarShovel), " n ", " s ", " s ",
                        'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarPickaxe), "nnn", " s ", " s ",
                        'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarAxe), "nn ", "ns ", " s ",
                        'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
                GameRegistry.addRecipe(new ItemStack(AdvancedCraft.netherStarHoe), "nn ", " s ", " s ",
                        'n', new ItemStack(Item.netherStar), 's', new ItemStack(Item.stick));
                
                
                
                //Smelting//
                GameRegistry.addSmelting(AdvancedCraft.sugarCookieDough.itemID, new ItemStack(AdvancedCraft.sugarCookie), 1.0f);
                
                
                
                //Crafting//
//                GameRegistry.addRecipe(new ItemStack(Block.commandBlock), "srs", "rnr", "srs",
//                        'r', new ItemStack(Item.redstone), 'n', nStarStack, 's', new ItemStack(Block.stone));
//                GameRegistry.addShapelessRecipe(new ItemStack(Block.wood), new ItemStack(Block.planks, 4));
        }
        
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}