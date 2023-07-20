package kzeknife.init;

import software.bernie.geckolib.animatable.GeoItem;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.Minecraft;

import kzeknife.item.TetraknifeItem;
import kzeknife.item.SurvivalknifeItem;
import kzeknife.item.RawfishItem;
import kzeknife.item.PenknifeItem;
import kzeknife.item.CrowbarItem;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber
public class ItemAnimationFactory {
	public static void disableUseAnim() {
		try {
			ItemInHandRenderer renderer = Minecraft.getInstance().gameRenderer.itemInHandRenderer;
			float rot = 1F;
			if (renderer != null) {
				Field field = ItemInHandRenderer.class.getDeclaredField("mainHandHeight");
				field.setAccessible(true);
				field.setFloat(renderer, rot);
				Field field1 = ItemInHandRenderer.class.getDeclaredField("oMainHandHeight");
				field1.setAccessible(true);
				field1.setFloat(renderer, rot);
				Field field2 = ItemInHandRenderer.class.getDeclaredField("offHandHeight");
				field2.setAccessible(true);
				field2.setFloat(renderer, rot);
				Field field3 = ItemInHandRenderer.class.getDeclaredField("oOffHandHeight");
				field3.setAccessible(true);
				field3.setFloat(renderer, rot);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SubscribeEvent
	public static void animatedItems(TickEvent.PlayerTickEvent event) {
		String animation = "";
		if (event.phase == TickEvent.Phase.START && (event.player.getMainHandItem().getItem() instanceof GeoItem || event.player.getOffhandItem().getItem() instanceof GeoItem)) {
			if (!event.player.getMainHandItem().getOrCreateTag().getString("geckoAnim").equals("") && !(event.player.getMainHandItem().getItem() instanceof ArmorItem)) {
				animation = event.player.getMainHandItem().getOrCreateTag().getString("geckoAnim");
				event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
				if (event.player.getMainHandItem().getItem() instanceof SurvivalknifeItem animatable)
					if (event.player.level.isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getMainHandItem().getItem() instanceof CrowbarItem animatable)
					if (event.player.level.isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getMainHandItem().getItem() instanceof PenknifeItem animatable)
					if (event.player.level.isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getMainHandItem().getItem() instanceof RawfishItem animatable)
					if (event.player.level.isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getMainHandItem().getItem() instanceof TetraknifeItem animatable)
					if (event.player.level.isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
			}
			if (!event.player.getOffhandItem().getOrCreateTag().getString("geckoAnim").equals("") && !(event.player.getOffhandItem().getItem() instanceof ArmorItem)) {
				animation = event.player.getOffhandItem().getOrCreateTag().getString("geckoAnim");
				event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
				if (event.player.getOffhandItem().getItem() instanceof SurvivalknifeItem animatable)
					if (event.player.level.isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getOffhandItem().getItem() instanceof CrowbarItem animatable)
					if (event.player.level.isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getOffhandItem().getItem() instanceof PenknifeItem animatable)
					if (event.player.level.isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getOffhandItem().getItem() instanceof RawfishItem animatable)
					if (event.player.level.isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
				if (event.player.getOffhandItem().getItem() instanceof TetraknifeItem animatable)
					if (event.player.level.isClientSide()) {
						animatable.animationprocedure = animation;
						disableUseAnim();
					}
			}
		}
	}
}