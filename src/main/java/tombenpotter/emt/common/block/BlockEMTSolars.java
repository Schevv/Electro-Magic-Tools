package tombenpotter.emt.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.tile.solar.air.TileEntityAirSolar;
import tombenpotter.emt.common.tile.solar.compressed.TileEntityCompressedSolar;
import tombenpotter.emt.common.tile.solar.compressed.TileEntityDoubleCompressedSolar;
import tombenpotter.emt.common.tile.solar.compressed.TileEntityTripleCompressedSolar;
import tombenpotter.emt.common.tile.solar.dark.TileEntityDarkSolar;
import tombenpotter.emt.common.tile.solar.dark.TileEntityDoubleDarkSolar;
import tombenpotter.emt.common.tile.solar.dark.TileEntityTripleDarkSolar;
import tombenpotter.emt.common.tile.solar.fire.TileEntityDoubleFireSolar;
import tombenpotter.emt.common.tile.solar.fire.TileEntityFireSolar;
import tombenpotter.emt.common.tile.solar.fire.TileEntityTripleFireSolar;
import tombenpotter.emt.common.tile.solar.order.TileEntityDoubleOrderSolar;
import tombenpotter.emt.common.tile.solar.order.TileEntityOrderSolar;
import tombenpotter.emt.common.tile.solar.order.TileEntityTripleOrderSolar;
import tombenpotter.emt.common.tile.solar.water.TileEntityDoubleWaterSolar;
import tombenpotter.emt.common.tile.solar.water.TileEntityTripleWaterSolar;
import tombenpotter.emt.common.tile.solar.water.TileEntityWaterSolar;

import java.util.List;

public class BlockEMTSolars extends BlockBaseContainer {

	public BlockEMTSolars() {
		super("solars", Material.iron, soundTypeMetal, 4.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ri) {
		this.top[0] = ri.registerIcon(ModInformation.texturePath + ":solars/solartop");
		this.top[1] = ri.registerIcon(ModInformation.texturePath + ":solars/doublesolartop");
		this.top[2] = ri.registerIcon(ModInformation.texturePath + ":solars/triplesolartop");
		this.top[3] = ri.registerIcon(ModInformation.texturePath + ":solars/solartop");
		this.top[4] = ri.registerIcon(ModInformation.texturePath + ":solars/doublesolartop");
		this.top[5] = ri.registerIcon(ModInformation.texturePath + ":solars/triplesolartop");
		this.top[6] = ri.registerIcon(ModInformation.texturePath + ":solars/solartop");
		this.top[7] = ri.registerIcon(ModInformation.texturePath + ":solars/doublesolartop");
		this.top[8] = ri.registerIcon(ModInformation.texturePath + ":solars/triplesolartop");
		this.top[9] = ri.registerIcon(ModInformation.texturePath + ":solars/solartop");
		this.top[10] = ri.registerIcon(ModInformation.texturePath + ":solars/doublesolartop");
		this.top[11] = ri.registerIcon(ModInformation.texturePath + ":solars/triplesolartop");
		this.top[12] = ri.registerIcon(ModInformation.texturePath + ":solars/solartop");
		this.top[13] = ri.registerIcon(ModInformation.texturePath + ":solars/doublesolartop");
		this.top[14] = ri.registerIcon(ModInformation.texturePath + ":solars/triplesolartop");
		this.top[15] = ri.registerIcon(ModInformation.texturePath + ":solars/solartop");

		this.bottom[0] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[1] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[2] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[3] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[4] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[5] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[6] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[7] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[8] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[9] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[10] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[11] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[12] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[13] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[14] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");
		this.bottom[15] = ri.registerIcon(ModInformation.texturePath + ":solars/bottom");

		this.frontOff[0] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
		this.frontOff[1] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
		this.frontOff[2] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
		this.frontOff[3] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
		this.frontOff[4] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
		this.frontOff[5] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
		this.frontOff[6] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
		this.frontOff[7] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
		this.frontOff[8] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
		this.frontOff[9] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
		this.frontOff[10] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
		this.frontOff[11] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
		this.frontOff[12] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
		this.frontOff[13] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
		this.frontOff[14] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
		this.frontOff[15] = ri.registerIcon(ModInformation.texturePath + ":solars/air/airside");

		this.side[0] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
		this.side[1] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
		this.side[2] = ri.registerIcon(ModInformation.texturePath + ":solars/side");
		this.side[3] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
		this.side[4] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
		this.side[5] = ri.registerIcon(ModInformation.texturePath + ":solars/water/waterside");
		this.side[6] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
		this.side[7] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
		this.side[8] = ri.registerIcon(ModInformation.texturePath + ":solars/dark/darkside");
		this.side[9] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
		this.side[10] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
		this.side[11] = ri.registerIcon(ModInformation.texturePath + ":solars/order/orderside");
		this.side[12] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
		this.side[13] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
		this.side[14] = ri.registerIcon(ModInformation.texturePath + ":solars/fire/fireside");
		this.side[15] = ri.registerIcon(ModInformation.texturePath + ":solars/air/airside");
	}

	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(Item id, CreativeTabs tab, List list) {
		for (int i = 0; i <= 15; i++) {
			list.add(new ItemStack(id, 1, i));
		}
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		if (meta == 0) {
			return new TileEntityCompressedSolar();
		}
		if (meta == 1) {
			return new TileEntityDoubleCompressedSolar();
		}
		if (meta == 2) {
			return new TileEntityTripleCompressedSolar();
		}
		if (meta == 3) {
			return new TileEntityWaterSolar();
		}
		if (meta == 4) {
			return new TileEntityDoubleWaterSolar();
		}
		if (meta == 5) {
			return new TileEntityTripleWaterSolar();
		}
		if (meta == 6) {
			return new TileEntityDarkSolar();
		}
		if (meta == 7) {
			return new TileEntityDoubleDarkSolar();
		}
		if (meta == 8) {
			return new TileEntityTripleDarkSolar();
		}
		if (meta == 9) {
			return new TileEntityOrderSolar();
		}
		if (meta == 10) {
			return new TileEntityDoubleOrderSolar();
		}
		if (meta == 11) {
			return new TileEntityTripleOrderSolar();
		}
		if (meta == 12) {
			return new TileEntityFireSolar();
		}
		if (meta == 13) {
			return new TileEntityDoubleFireSolar();
		}
		if (meta == 14) {
			return new TileEntityTripleFireSolar();
		}
		if (meta == 15) {
			return new TileEntityAirSolar();
		}
		return super.createTileEntity(world, meta);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		world.removeTileEntity(x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}
}
