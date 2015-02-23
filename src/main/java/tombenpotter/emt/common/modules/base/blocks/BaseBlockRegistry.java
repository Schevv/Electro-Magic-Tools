package tombenpotter.emt.common.modules.base.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import tombenpotter.emt.ModInformation;

public class BaseBlockRegistry {

    public static Block portableNode;

    public static void registerBaseBlocks() {
        portableNode = new BlockPortableNode().setBlockName(ModInformation.modid + ".portablenode");
        GameRegistry.registerBlock(portableNode, "PortableNode");
    }
}
