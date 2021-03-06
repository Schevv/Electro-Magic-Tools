package tombenpotter.emt.common.item.tool.chainsaw;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.core.IC2;
import ic2.core.audio.AudioSource;
import ic2.core.audio.PositionSpec;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.fx.PacketFXBlockBubble;
import thaumcraft.common.lib.utils.BlockUtils;
import thaumcraft.common.lib.utils.Utils;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;

import java.awt.*;
import java.util.ArrayList;

public class ItemStreamChainsaw extends ItemThaumiumChainsaw {

	boolean alternateServer;
	boolean alternateClient;
	public static ArrayList oreDictLogs = new ArrayList();
	public static AudioSource audio;

	public ItemStreamChainsaw() {
		this.efficiencyOnProperMaterial = 25F;
		alternateServer = false;
		alternateClient = false;
		setCreativeTab(ElectroMagicTools.tabEMT);
		this.maxStackSize = 1;
		this.setMaxDamage(27);
		maxCharge = 900000;
		cost = 400;
		hitCost = 500;
		tier = 3;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(ModInformation.texturePath + ":tools/chainsaw_stream");
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemstack) {
		return EnumAction.bow;
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		Block bi = world.getBlock(x, y, z);
		if ((!player.isSneaking()) && (Utils.isWoodLog(world, x, y, z)) && ElectricItem.manager.getCharge(itemstack) > cost) {
			if (!world.isRemote) {
				if (BlockUtils.breakFurthestBlock(world, x, y, z, bi, player)) {
					world.playSoundEffect(x, y, z, "thaumcraft:bubble", 0.15F, 1.0F);
					ElectricItem.manager.use(itemstack, cost, player);
					this.alternateServer = (!this.alternateServer);
				}
			}
			else {
				player.swingItem();
				ElectricItem.manager.use(itemstack, cost, player);
				this.alternateClient = (!this.alternateClient);
			}
		}
		return super.onItemUse(itemstack, player, world, x, y, z, par7, par8, par9, par10);
	}

	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		if (entity instanceof EntityLivingBase) {
			if (IC2.platform.isRendering()) {
				if (flag && !dropped) {
					if (audio == null)
						audio = IC2.audioManager.createSource(entity, PositionSpec.Hand, "Tools/Chainsaw/ChainsawIdle.ogg", true, false, IC2.audioManager.getDefaultVolume());
					if (audio != null) {
						audio.updatePosition();
						audio.play();
					}
				}
				else if (!flag && audio != null && ((((EntityPlayer) entity).inventory.getCurrentItem() != null && ((EntityPlayer) entity).inventory.getCurrentItem().getItem() != this) || (((EntityPlayer) entity).inventory.getCurrentItem() == null))) {
					audio.stop();
					audio.remove();
					audio = null;
					IC2.audioManager.playOnce(entity, PositionSpec.Hand, "Tools/Chainsaw/ChainsawStop.ogg", true, IC2.audioManager.getDefaultVolume());
				}
				dropped = false;
			}
		}
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		if (audio != null) {
			audio.stop();
			audio.remove();
			audio = null;
			dropped = true;
		}
		return true;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
		World world = player.worldObj;
		Block bi = world.getBlock(x, y, z);
		if ((!player.isSneaking()) && (Utils.isWoodLog(world, x, y, z))) {
			if (!world.isRemote) {
				BlockUtils.breakFurthestBlock(world, x, y, z, bi, player);
				PacketHandler.INSTANCE.sendToAllAround(new PacketFXBlockBubble(x, y, z, new Color(0.33F, 0.33F, 1.0F).getRGB()), new NetworkRegistry.TargetPoint(world.provider.dimensionId, x, y, z, 32.0D));

				world.playSoundEffect(x, y, z, "thaumcraft:bubble", 0.15F, 1.0F);
			}
			ElectricItem.manager.use(itemstack, cost, player);
			return true;
		}
		return super.onBlockStartBreak(itemstack, x, y, z, player);
	}

	/* IC2 API METHODS */
	@Override
	public double getTransferLimit(ItemStack itemStack) {
		return 900;
	}
}
