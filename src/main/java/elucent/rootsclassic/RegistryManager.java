package elucent.rootsclassic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import elucent.rootsclassic.block.BlockAestheticStandingStone;
import elucent.rootsclassic.block.BlockStandingStoneAccelerator;
import elucent.rootsclassic.block.BlockStandingStoneEntangler;
import elucent.rootsclassic.block.BlockStandingStoneGrower;
import elucent.rootsclassic.block.BlockStandingStoneHealer;
import elucent.rootsclassic.block.BlockStandingStoneIgniter;
import elucent.rootsclassic.block.BlockStandingStoneRepulsor;
import elucent.rootsclassic.block.BlockStandingStoneT1;
import elucent.rootsclassic.block.BlockStandingStoneT2;
import elucent.rootsclassic.block.BlockStandingStoneVacuum;
import elucent.rootsclassic.block.altar.BlockAltar;
import elucent.rootsclassic.block.altar.TileEntityAltar;
import elucent.rootsclassic.block.altar.TileEntityAltarRenderer;
import elucent.rootsclassic.block.brazier.BlockBrazier;
import elucent.rootsclassic.block.brazier.TileEntityBrazier;
import elucent.rootsclassic.block.brazier.TileEntityBrazierRenderer;
import elucent.rootsclassic.block.flowers.BlockFlareOrchid;
import elucent.rootsclassic.block.flowers.BlockMidnightBloom;
import elucent.rootsclassic.block.flowers.BlockRadiantDaisy;
import elucent.rootsclassic.block.imbuer.BlockImbuer;
import elucent.rootsclassic.block.imbuer.TileEntityImbuer;
import elucent.rootsclassic.block.imbuer.TileEntityImbuerRenderer;
import elucent.rootsclassic.block.mortar.BlockMortar;
import elucent.rootsclassic.block.mortar.TileEntityMortar;
import elucent.rootsclassic.block.mortar.TileEntityMortarRenderer;
import elucent.rootsclassic.component.ComponentManager;
import elucent.rootsclassic.entity.EntityAccelerator;
import elucent.rootsclassic.entity.EntityTileAccelerator;
import elucent.rootsclassic.entity.skeleton.EntityFrozenKnight;
import elucent.rootsclassic.entity.skeleton.RenderFrozenKnight;
import elucent.rootsclassic.item.FuelManager;
import elucent.rootsclassic.item.ItemBowlFood;
import elucent.rootsclassic.item.ItemCrystalStaff;
import elucent.rootsclassic.item.ItemDragonsEye;
import elucent.rootsclassic.item.ItemDruidArmor;
import elucent.rootsclassic.item.ItemDruidKnife;
import elucent.rootsclassic.item.ItemDruidRobes;
import elucent.rootsclassic.item.ItemDustPetal;
import elucent.rootsclassic.item.ItemEngravedSword;
import elucent.rootsclassic.item.ItemGrowthSalve;
import elucent.rootsclassic.item.ItemLivingAxe;
import elucent.rootsclassic.item.ItemLivingHoe;
import elucent.rootsclassic.item.ItemLivingPickaxe;
import elucent.rootsclassic.item.ItemLivingShovel;
import elucent.rootsclassic.item.ItemLivingSword;
import elucent.rootsclassic.item.ItemMutagen;
import elucent.rootsclassic.item.ItemPestle;
import elucent.rootsclassic.item.ItemRootsBasic;
import elucent.rootsclassic.item.ItemRootsFood;
import elucent.rootsclassic.item.ItemRunedTablet;
import elucent.rootsclassic.item.ItemRunicFocus;
import elucent.rootsclassic.item.ItemStaff;
import elucent.rootsclassic.ritual.RitualManager;
import elucent.rootsclassic.tileentity.TileEntityAestheticStandingStone;
import elucent.rootsclassic.tileentity.TileEntityStandingStoneAccelerator;
import elucent.rootsclassic.tileentity.TileEntityStandingStoneEntangler;
import elucent.rootsclassic.tileentity.TileEntityStandingStoneGrower;
import elucent.rootsclassic.tileentity.TileEntityStandingStoneHealer;
import elucent.rootsclassic.tileentity.TileEntityStandingStoneIgniter;
import elucent.rootsclassic.tileentity.TileEntityStandingStoneRepulsor;
import elucent.rootsclassic.tileentity.TileEntityStandingStoneVacuum;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RegistryManager {

  public static Item runicFocus, rootyStew, fruitSalad, healingPoultice, mutagen, growthSalve, runedTablet,
      druidArmorHead, druidArmorChest, druidArmorLegs, druidArmorBoots, druidRobesHead, druidRobesChest, druidRobesLegs, druidRobesBoots,
      livingPickaxe, livingSword, livingHoe,
      livingAxe, livingShovel, dustPetal, pestle, staff, oldRoot, crystalStaff, verdantSprig,
      infernalStem, dragonsEye, druidKnife,
      oakTreeBark, spruceTreeBark, birchTreeBark, jungleTreeBark, acaciaTreeBark, darkOakTreeBark,
      nightshade, blackCurrant, redCurrant, whiteCurrant, elderBerry, engravedSword;
  public static Item manaResearchIcon;
  public static Block flareOrchid, radiantDaisy, standingStoneGrower, standingStoneHealer, standingStoneIgniter, standingStoneEntangler, standingStoneAccelerator, standingStoneAesthetic, standingStoneRepulsor, standingStoneVacuum, midnightBloom, mortar, imbuer, altar, druidChalice, standingStoneT1, standingStoneT2, brazier;
  public static ToolMaterial engravedMaterial = EnumHelper.addToolMaterial("engraved", 2, 1050, 5F, 8.0F, 5);
  public static ToolMaterial livingMaterial = EnumHelper.addToolMaterial("livingMaterial", 2, 192, 6.0f, 2.0f, 18);
  public static ArmorMaterial druidRobesMaterial = EnumHelper.addArmorMaterial("druidRobes", "rootsclassic:druidrobes", 10, new int[] { 1, 5, 6, 2 }, 20, null, 0);
  public static ArmorMaterial druidArmorMaterial = EnumHelper.addArmorMaterial("druidArmor", "rootsclassic:druidarmor", 15, new int[] { 2, 5, 7, 3 }, 10, null, 1.0f);
  public static List<Item> itemList = new ArrayList<Item>();
  public static List<IRecipe> recipes = new ArrayList<IRecipe>();
  public static List<Block> blocks = new ArrayList<Block>();
  private static Map<String, Boolean> usedRecipeNames = new HashMap<String, Boolean>();

  private static void addShapelessOreRecipe(ItemStack stack, Object... recipeComponents) {
    ResourceLocation location = buildName(stack);
    IRecipe recipe = new ShapelessOreRecipe(location, stack, recipeComponents);
    recipe.setRegistryName(location);
    recipes.add(recipe);
  }

  private static void addShapedRecipe(ItemStack output, Object... params) {
    ResourceLocation location = buildName(output);
    ShapedOreRecipe recipe = new ShapedOreRecipe(location, output, params);
    recipe.setRegistryName(location);
    recipes.add(recipe);
  }

  private static ResourceLocation buildName(ItemStack output) {
    ResourceLocation firstTry = new ResourceLocation(Const.MODID, output.getUnlocalizedName());
    int limit = 999;
    int index = 0;
    while (usedRecipeNames.containsKey(firstTry.toString()) || index > limit) {
      index++;
      firstTry = new ResourceLocation(Const.MODID, firstTry.getResourcePath() + "_" + index);
    }
    usedRecipeNames.put(firstTry.toString(), true);
    return firstTry;
  }

  private static void registerItem(Item item, String name) {
    item.setUnlocalizedName(name);
    item.setRegistryName(new ResourceLocation(Const.MODID, name));
    item.setCreativeTab(Roots.tab);
    itemList.add(item);
  }

  private static void registerBlock(Block b, String name) {
    b.setRegistryName(new ResourceLocation(Const.MODID, name));
    b.setUnlocalizedName(name);
    ItemBlock ib = new ItemBlock(b);
    ib.setRegistryName(new ResourceLocation(Const.MODID, name)); // ok good this should work yes? yes! http://mcforge.readthedocs.io/en/latest/blocks/blocks/#registering-a-block
    ib.setCreativeTab(Roots.tab);
    itemList.add(ib);
    blocks.add(b);
  }

  @SubscribeEvent
  public static void onRegisterItemsEvent(RegistryEvent.Register<Item> event) {
    event.getRegistry().registerAll(itemList.toArray(new Item[0]));
    OreDictionary.registerOre("barkWood", oakTreeBark);
    OreDictionary.registerOre("barkOak", oakTreeBark);
    OreDictionary.registerOre("barkWood", spruceTreeBark);
    OreDictionary.registerOre("barkSpruce", spruceTreeBark);
    OreDictionary.registerOre("barkWood", jungleTreeBark);
    OreDictionary.registerOre("barkJungle", jungleTreeBark);
    OreDictionary.registerOre("barkWood", acaciaTreeBark);
    OreDictionary.registerOre("barkAcacia", acaciaTreeBark);
    OreDictionary.registerOre("barkWood", birchTreeBark);
    OreDictionary.registerOre("barkBirch", birchTreeBark);
    registerRecipes();
  }

  @SubscribeEvent
  public static void onRegisterBlocksEvent(RegistryEvent.Register<Block> event) {
    event.getRegistry().registerAll(blocks.toArray(new Block[0]));
  }

  @SubscribeEvent
  public static void onRegisterRecipesEvent(RegistryEvent.Register<IRecipe> event) {
    event.getRegistry().registerAll(recipes.toArray(new IRecipe[0]));
  }

  @SubscribeEvent
  public static void onRegisterRecipeEvent(RegistryEvent.Register<IRecipe> event) {
    ComponentManager.init();
    RitualManager.init();
  }

  public static void init() {
    /**
     * REGISTERING ITEMS
     */
    registerItem(druidKnife = new ItemDruidKnife(), "druidknife");
    registerItem(dustPetal = new ItemDustPetal(), "dustpetal");
    registerItem(pestle = new ItemPestle(), "pestle");
    registerItem(staff = new ItemStaff(), "staff");
    registerItem(crystalStaff = new ItemCrystalStaff(), "crystalstaff");
    registerItem(oldRoot = new ItemRootsFood(1, 0.1F, false), "oldroot");
    registerItem(verdantSprig = new ItemRootsBasic(), "verdantsprig");
    registerItem(infernalStem = new ItemRootsBasic(), "infernalstem");
    registerItem(dragonsEye = new ItemDragonsEye(2, 0.1F, false), "dragonseye");
    registerItem(oakTreeBark = new ItemRootsBasic(), "oaktreebark");
    registerItem(spruceTreeBark = new ItemRootsBasic(), "sprucetreebark");
    registerItem(birchTreeBark = new ItemRootsBasic(), "birchtreebark");
    registerItem(jungleTreeBark = new ItemRootsBasic(), "jungletreebark");
    registerItem(acaciaTreeBark = new ItemRootsBasic(), "acaciatreebark");
    registerItem(darkOakTreeBark = new ItemRootsBasic(), "darkoaktreebark");
    registerItem(livingPickaxe = new ItemLivingPickaxe(), "livingpickaxe");
    registerItem(livingAxe = new ItemLivingAxe(), "livingaxe");
    registerItem(livingSword = new ItemLivingSword(), "livingsword");
    registerItem(livingHoe = new ItemLivingHoe(), "livinghoe");
    registerItem(livingShovel = new ItemLivingShovel(), "livingshovel");
    registerItem(druidRobesHead = new ItemDruidRobes(2, EntityEquipmentSlot.HEAD), "druidrobeshead");
    registerItem(druidRobesChest = new ItemDruidRobes(6, EntityEquipmentSlot.CHEST), "druidrobeschest");
    registerItem(druidRobesLegs = new ItemDruidRobes(5, EntityEquipmentSlot.LEGS), "druidrobeslegs");
    registerItem(druidRobesBoots = new ItemDruidRobes(1, EntityEquipmentSlot.FEET), "druidrobesboots");
    registerItem(druidArmorHead = new ItemDruidArmor(3, EntityEquipmentSlot.HEAD), "druidarmorhead");
    registerItem(druidArmorChest = new ItemDruidArmor(7, EntityEquipmentSlot.CHEST), "druidarmorchest");
    registerItem(druidArmorLegs = new ItemDruidArmor(6, EntityEquipmentSlot.LEGS), "druidarmorlegs");
    registerItem(druidArmorBoots = new ItemDruidArmor(2, EntityEquipmentSlot.FEET), "druidarmorboots");
    registerItem(runedTablet = new ItemRunedTablet(), "runedtablet");
    registerItem(growthSalve = new ItemGrowthSalve(), "growthsalve");
    registerItem(mutagen = new ItemMutagen(), "mutagen");
    registerItem(nightshade = new ItemRootsFood(2, 0.1F, false).setPotionEffect(new PotionEffect(Potion.getPotionById(19), 320), 1F), "nightshade");
    registerItem(blackCurrant = new ItemRootsFood(4, 0.4F, false), "blackcurrant");
    registerItem(redCurrant = new ItemRootsFood(4, 0.4F, false), "redcurrant");
    registerItem(whiteCurrant = new ItemRootsFood(4, 0.4F, false), "whitecurrant");
    registerItem(elderBerry = new ItemRootsFood(2, 0.1F, false), "elderberry");
    registerItem(healingPoultice = new ItemRootsFood(0, 0F, false).setAlwaysEdible().setMaxStackSize(8), "healingpoultice");
    float cookedBeefSat = 0.8F;
    registerItem(rootyStew = new ItemBowlFood(7, 0.2F + cookedBeefSat), "rootystew");//7 means 3.5 nuggets (steak gives 4) 1 is saturation
    registerItem(fruitSalad = new ItemBowlFood(8, 0.1F + cookedBeefSat), "fruitsalad");
    registerItem(runicFocus = new ItemRunicFocus(), "runicfocus");
    registerItem(engravedSword = new ItemEngravedSword(), "engravedsword");
    registerItem(manaResearchIcon = new ItemRootsBasic(), "manaresearchicon");
    Item apple;
    /**
     * REGISTERING BLOCKS
     */
    //registerBlock(druidChalice = new BlockDruidChalice(), "druidChalice");
    registerBlock(mortar = new BlockMortar(), "mortar");
    registerBlock(altar = new BlockAltar(), "altar");
    registerBlock(brazier = new BlockBrazier(), "brazier");
    registerBlock(imbuer = new BlockImbuer(), "imbuer");
    registerBlock(standingStoneT1 = new BlockStandingStoneT1(), "standingstonet1");
    registerBlock(standingStoneT2 = new BlockStandingStoneT2(), "standingstonet2");
    registerBlock(standingStoneVacuum = new BlockStandingStoneVacuum(), "standingstonevacuum");
    registerBlock(standingStoneRepulsor = new BlockStandingStoneRepulsor(), "standingstonerepulsor");
    registerBlock(standingStoneAccelerator = new BlockStandingStoneAccelerator(), "standingstoneaccelerator");
    registerBlock(standingStoneAesthetic = new BlockAestheticStandingStone(), "standingstoneaesthetic");
    registerBlock(standingStoneEntangler = new BlockStandingStoneEntangler(), "standingstoneentangler");
    registerBlock(standingStoneIgniter = new BlockStandingStoneIgniter(), "standingstoneigniter");
    registerBlock(standingStoneGrower = new BlockStandingStoneGrower(), "standingstonegrower");
    registerBlock(standingStoneHealer = new BlockStandingStoneHealer(), "standingstonehealer");
    registerBlock(midnightBloom = new BlockMidnightBloom(), "midnightbloom");
    registerBlock(flareOrchid = new BlockFlareOrchid(), "flareorchid");
    registerBlock(radiantDaisy = new BlockRadiantDaisy(), "radiantdaisy");
    /**
     * REGISTERING TILE ENTITIES
     */
    GameRegistry.registerTileEntity(TileEntityMortar.class, "te_mortar");
    GameRegistry.registerTileEntity(TileEntityImbuer.class, "te_imbuer");
    GameRegistry.registerTileEntity(TileEntityAltar.class, "te_altar");
    GameRegistry.registerTileEntity(TileEntityBrazier.class, "te_brazier");
    GameRegistry.registerTileEntity(TileEntityStandingStoneVacuum.class, "te_vacuum");
    GameRegistry.registerTileEntity(TileEntityStandingStoneRepulsor.class, "te_repulsor");
    GameRegistry.registerTileEntity(TileEntityStandingStoneAccelerator.class, "te_accelerator");
    GameRegistry.registerTileEntity(TileEntityAestheticStandingStone.class, "te_pretty");
    GameRegistry.registerTileEntity(TileEntityStandingStoneEntangler.class, "te_entangler");
    GameRegistry.registerTileEntity(TileEntityStandingStoneGrower.class, "te_grower");
    GameRegistry.registerTileEntity(TileEntityStandingStoneIgniter.class, "te_igniter");
    GameRegistry.registerTileEntity(TileEntityStandingStoneHealer.class, "te_healer");
    GameRegistry.registerFuelHandler(new FuelManager());
  }

  public static void registerEntities() {
    EntityRegistry.registerModEntity(new ResourceLocation(Const.MODID, "tileaccelerator"), EntityTileAccelerator.class, "tileaccelerator", 119, Roots.instance, 64, 20, true);
    EntityRegistry.registerModEntity(new ResourceLocation(Const.MODID, "entityaccelerator"), EntityAccelerator.class, "entityaccelerator", 110, Roots.instance, 64, 20, true);
    EntityRegistry.registerModEntity(new ResourceLocation(Const.MODID, EntityFrozenKnight.NAME), EntityFrozenKnight.class, EntityFrozenKnight.NAME, 111, Roots.instance, 64, 1, true);
    EntityRegistry.registerEgg(new ResourceLocation(Const.MODID, EntityFrozenKnight.NAME), Util.intColor(87, 58, 134), 0xA0A0A0);
  }

  public static void registerRecipes() {
    addShapedRecipe(new ItemStack(RegistryManager.pestle, 1), true, new Object[] { "X  ", " XX", " XX", 'X', new ItemStack(Blocks.STONE, 1, 3) });
    addShapedRecipe(new ItemStack(RegistryManager.pestle, 1), true, new Object[] { "  X", "XX ", "XX ", 'X', new ItemStack(Blocks.STONE, 1, 3) });
    addShapedRecipe(new ItemStack(RegistryManager.mortar, 1), true, new Object[] { "X X", "X X", " X ", 'X', "stone" });
    addShapedRecipe(new ItemStack(RegistryManager.imbuer, 1), true, new Object[] { "X X", "LSL", 'X', "stickWood", 'L', "logWood", 'S', new ItemStack(Blocks.STONEBRICK, 1, 3) });
    addShapedRecipe(new ItemStack(RegistryManager.standingStoneT1, 1), true, new Object[] { "SBS", "BLB", "SBS", 'S', "stone", 'B', new ItemStack(Blocks.STONEBRICK, 1), 'L', "blockLapis" });
    addShapedRecipe(new ItemStack(RegistryManager.standingStoneT2, 1), true, new Object[] { "SNS", "NDN", "SNS", 'S', "stone", 'N', "ingotBrickNether", 'D', "gemDiamond" });
    addShapedRecipe(new ItemStack(RegistryManager.brazier, 1), true, new Object[] {
        "ISI", "ICI", "IXI",
        'I', "ingotIron",
        'S', "string",
        'C', Items.CAULDRON,
        'X', "stickWood"
    });
    addShapedRecipe(new ItemStack(RegistryManager.altar, 1), true, new Object[] { "BFB", "SGS", " C ", 'S', "stone", 'F', new ItemStack(Blocks.RED_FLOWER, 1, 0), 'B', RegistryManager.verdantSprig, 'G', "blockGold", 'C', new ItemStack(Blocks.STONEBRICK, 1, 3) });
    addShapedRecipe(new ItemStack(RegistryManager.druidKnife, 1), true, new Object[] { " VV", "VPV", "SV ", 'S', "stickWood", 'V', "treeSapling", 'P', "plankWood" });
    addShapelessOreRecipe(new ItemStack(RegistryManager.growthSalve, 4),
        new Object[] { new ItemStack(Items.WHEAT_SEEDS, 1),
            new ItemStack(Blocks.TALLGRASS, 1, 1), "dustRedstone",
            new ItemStack(RegistryManager.pestle, 1) });
    addShapelessOreRecipe(new ItemStack(RegistryManager.mutagen, 1), new Object[] {
        new ItemStack(RegistryManager.growthSalve), new ItemStack(RegistryManager.growthSalve),
        new ItemStack(RegistryManager.growthSalve),
        new ItemStack(RegistryManager.growthSalve), new ItemStack(Items.NETHER_STAR, 1),
        new ItemStack(Items.NETHER_WART, 1), new ItemStack(RegistryManager.pestle, 1) });
    addShapedRecipe(new ItemStack(RegistryManager.runedTablet, 1), true, new Object[] { " R ", "SBS", " S ", 'S', Items.WHEAT_SEEDS, 'B', "stone", 'R', RegistryManager.oldRoot });
    addShapelessOreRecipe(new ItemStack(RegistryManager.rootyStew), new Object[] { new ItemStack(Items.WHEAT, 1), new ItemStack(Items.BOWL, 1), new ItemStack(RegistryManager.oldRoot, 1) });
    addShapelessOreRecipe(new ItemStack(RegistryManager.fruitSalad), new Object[] {
        new ItemStack(Items.MELON), new ItemStack(Items.MELON), new ItemStack(Items.MELON),
        new ItemStack(Items.APPLE), new ItemStack(Items.BOWL), new ItemStack(RegistryManager.elderBerry),
        new ItemStack(RegistryManager.whiteCurrant), new ItemStack(RegistryManager.blackCurrant),
        new ItemStack(RegistryManager.redCurrant) });
    addShapelessOreRecipe(new ItemStack(RegistryManager.healingPoultice, 2), new Object[] {
        RegistryManager.redCurrant, // new ItemStack(Items.DYE, 1, 1), 
        new ItemStack(Items.PAPER, 1),
        new ItemStack(RegistryManager.pestle),
        new ItemStack(RegistryManager.verdantSprig) });
    GameRegistry.addSmelting(RegistryManager.dragonsEye, new ItemStack(Items.ENDER_PEARL), 1F);
  }

  @SideOnly(Side.CLIENT)
  @SubscribeEvent
  public static void registerModels(ModelRegistryEvent event) {
    /**
     * REGISTERING TILE ENTITY RENDERERS
     */
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMortar.class, new TileEntityMortarRenderer());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, new TileEntityAltarRenderer());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityImbuer.class, new TileEntityImbuerRenderer());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBrazier.class, new TileEntityBrazierRenderer());
    /**
     * REGISTERING ITEM MODELS
     */
    for (Item item : itemList) {
      ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
    for (Block item : blocks) {
      ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(item), 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
    ((ItemStaff) staff).initModel();
    ((ItemRunicFocus) runicFocus).initModel();
    //living entities 
    RenderingRegistry.registerEntityRenderingHandler(EntityFrozenKnight.class, new RenderFrozenKnight.Factory());
  }

  @SideOnly(Side.CLIENT)
  public static void registerColorHandlers() {
    Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemStaff.ColorHandler(), staff);
    Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemCrystalStaff.ColorHandler(), crystalStaff);
  }
}
