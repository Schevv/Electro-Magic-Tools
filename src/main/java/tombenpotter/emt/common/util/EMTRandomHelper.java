package tombenpotter.emt.common.util;

import ic2.api.item.ElectricItem;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.Locale;

public class EMTRandomHelper {

	public static boolean placeTorch(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffset) {
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
			ItemStack torchStack = player.inventory.mainInventory[i];
			if (torchStack == null || !torchStack.getUnlocalizedName().toLowerCase(Locale.US).contains("torch"))
				continue;
			Item item = torchStack.getItem();
			if (!(item instanceof ItemBlock))
				continue;
			int oldMeta = torchStack.getItemDamage();
			int oldSize = torchStack.stackSize;
			boolean result = torchStack.tryPlaceItemIntoWorld(player, world, x, y, z, side, xOffset, yOffset, zOffset);
			if (player.capabilities.isCreativeMode) {
				torchStack.setItemDamage(oldMeta);
				torchStack.stackSize = oldSize;
			}
			else if (torchStack.stackSize <= 0) {
				ForgeEventFactory.onPlayerDestroyItem(player, torchStack);
				player.inventory.mainInventory[i] = null;
			}
			if (result)
				return true;
		}
		return false;
	}

	public static ItemStack getChargedItem(Item item, int charge) {
		ItemStack stack = new ItemStack(item);
		ElectricItem.manager.charge(stack, charge, charge, true, false);
		return stack;
	}
}
