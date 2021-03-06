package tombenpotter.emt.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.client.gui.container.ContainerIndustrialWandRecharge;
import tombenpotter.emt.common.tile.TileEntityIndustrialWandRecharge;
import tombenpotter.emt.common.util.EMTTextHelper;

public class GuiIndustrialWandRecharger extends GuiContainer {

	public GuiIndustrialWandRecharger(InventoryPlayer inventory, TileEntityIndustrialWandRecharge te) {
		super(new ContainerIndustrialWandRecharge(inventory, te));
		xSize = 176;
		ySize = 165;
	}

	public static final ResourceLocation texture = new ResourceLocation(ModInformation.texturePath, "textures/guis/wandcharger.png");

	@Override
	public void drawGuiContainerBackgroundLayer(float f, int j, int i) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRendererObj.drawString(EMTTextHelper.localize("gui.EMT.wandRecharge.title"), 6, 6, 4210752);
		this.fontRendererObj.drawString(EMTTextHelper.localize("gui.EMT.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
}
