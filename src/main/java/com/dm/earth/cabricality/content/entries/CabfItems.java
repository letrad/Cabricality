package com.dm.earth.cabricality.content.entries;

import static com.dm.earth.cabricality.ModEntry.C;

import java.util.Arrays;
import java.util.List;

import com.dm.earth.cabricality.Cabricality;

import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import com.dm.earth.cabricality.content.core.items.ColoredFernItem;
import com.dm.earth.cabricality.content.core.items.FlippableItem;
import com.dm.earth.cabricality.content.core.items.GlintedItem;
import com.dm.earth.cabricality.content.core.items.MechanismItem;
import com.dm.earth.cabricality.content.core.items.SawItem;
import com.dm.earth.cabricality.content.core.items.ToolMaterialIndex;
import com.dm.earth.cabricality.content.trading.Professions;
import com.dm.earth.cabricality.content.trading.core.Profession;
import com.dm.earth.cabricality.content.trading.core.TradingEntry;
import com.dm.earth.cabricality.content.trading.item.ProfessionCardItem;
import com.dm.earth.cabricality.content.trading.item.TradeCardItem;
import com.dm.earth.cabricality.resource.assets.gen.item.ItemModelGenerator;
import com.simibubi.create.AllTags.AllItemTags;

import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CabfItems {
	public static final Item SAW_BLADE = registerItemModeled("saw_blade",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "saw_blade"));
	public static final Item BASALZ_SHARD = registerItemModeled("basalz_shard",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "basalz_shard"));
	public static final Item BASALZ_POWDER = registerItemModeled("basalz_powder",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "basalz_powder"));
	public static final Item BLIZZ_CUBE = registerItemModeled("blizz_cube",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "blizz_cube"));
	public static final Item BLIZZ_POWDER = registerItemModeled("blizz_powder",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "blizz_powder"));
	public static final Item ZINC_SHEET = registerItemModeled("zinc_sheet",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "zinc_sheet"));
	public static final Item STONE_ROD = registerItemModeled("stone_rod",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "stone_rod"));
	public static final Item RUBBER = registerItemModeled("rubber", new Item(Properties.DEFAULT),
			ItemModelGenerator.generated("item", "rubber"));
	public static final Item CURED_RUBBER = registerItemModeled("cured_rubber",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "cured_rubber"));
	public static final Item INVAR_INGOT = registerItemModeled("invar_ingot",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "invar_ingot"));
	public static final Item NICKEL_INGOT = registerItemModeled("nickel_ingot",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "nickel_ingot"));
	public static final Item ENDERIUM_INGOT = registerItemModeled("enderium_ingot",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "enderium_ingot"));
	public static final Item NICKEL_COMPOUND = registerItemModeled("nickel_compound",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "nickel_compound"));
	public static final Item INVAR_COMPOUND = registerItemModeled("invar_compound",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "invar_compound"));
	public static final Item SILICON_COMPOUND = registerItemModeled("silicon_compound",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "silicon_compound"));
	public static final Item RUBY = registerItemModeled("ruby", new Item(Properties.DEFAULT),
			ItemModelGenerator.generated("item", "ruby"));
	public static final Item SAPPHIRE = registerItemModeled("sapphire",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "sapphire"));
	public static final Item RADIANT_SHEET =
			registerItemModeled("radiant_sheet", new GlintedItem(Properties.DEFAULT),
					ItemModelGenerator.generated("item", "radiant_sheet"));
	public static final Item RADIANT_COIL =
			registerItemModeled("radiant_coil", new GlintedItem(Properties.DEFAULT),
					ItemModelGenerator.generated("item", "radiant_coil"));
	public static final Item DYE_ENTANGLED_SINGULARITY =
			registerItemModeled("dye_entangled_singularity", new Item(Properties.DEFAULT),
					ItemModelGenerator.generated("item", "dye_entangled_singularity"));
	public static final Item CHROMATIC_RESONATOR = registerItemModeled("chromatic_resonator",
			new GlintedItem(new QuiltItemSettings().maxDamage(512).group(Cabricality.MAIN_GROUP)),
			ItemModelGenerator.generated("item", "chromatic_resonator"));
	public static final Item FLASH_DRIVE = registerItemModeled("flash_drive",
			new Item(new QuiltItemSettings().maxDamage(512).group(Cabricality.MAIN_GROUP)),
			ItemModelGenerator.generated("item", "boot_medium"));
	public static final Item CIRCUIT_SCRAP = registerItemModeled("circuit_scrap",
			new Item(Properties.DEFAULT), ItemModelGenerator.generated("item", "circuit_scrap"));

	public static final List<String> CRUSHED_ORES = List.of("desh", "ostrum", "calorite", "cobalt");
	public static final List<String> DUSTS =
			List.of("zinc", "desh", "ostrum", "calorite", "cobalt", "diamond", "emerald", "nickel");

	public static void register() {
		// Trading Cards
		Arrays.stream(Professions.values()).forEach(professionEntry -> {
			Profession profession = professionEntry.get();
			registerItemModeled("profession_card_" + profession.hashString(),
					new ProfessionCardItem(Properties.CARD), ItemModelGenerator.parented(
							Cabricality.id("item", "card", "profession_card").toString()));
			profession.entries()
					.forEach(entry -> registerItemModeled("trade_card_" + entry.hashString(),
							new TradeCardItem(Properties.CARD), ItemModelGenerator.parented(
									Cabricality.id("item", "card", "trade_card").toString())));
		});

		// Coins
		Arrays.stream(TradingEntry.CoinTypes.values()).forEach(coinType -> {
			registerItemModeled(coinType.getId().getPath(),
					new FlippableItem(Properties.DEFAULT.maxCount(16)),
					ItemModelGenerator.generated("item", "coin", coinType.getId().getPath()));
			// For Flipping
			registerItemModeled(coinType.getId().getPath() + "_top", new Item(Properties.CARD),
					ItemModelGenerator.parented(Cabricality
							.id("item", "coin", coinType.getId().getPath() + "_top").toString()));
			registerItemModeled(coinType.getId().getPath() + "_bottom", new Item(Properties.CARD),
					ItemModelGenerator.parented(
							Cabricality.id("item", "coin", coinType.getId().getPath() + "_bottom")
									.toString()));
		});

		Cabricality.SERVER_RESOURCES.addTag(C.id("items", "silver_coins"),
				new JTag().add(Cabricality.id("silver_coin")));
		Cabricality.SERVER_RESOURCES.addTag(C.id("items", "gold_coins"),
				new JTag().add(Cabricality.id("gold_coin")));

		// Mechanisms
		Arrays.stream(MechanismItem.Type.values()).forEach(type -> {
			registerItemModeled(type.getItemId().getPath(), type.getItem(),
					ItemModelGenerator.generated(type.getItem().getTextureId().getPath()));
			registerItemModeled(type.getIncompleteItemId().getPath(), type.getIncompleteItem(),
					ItemModelGenerator
							.generated(type.getItem().getIncompleteTextureId().getPath()));
		});

		// Saws
		JTag sawsTag = new JTag();
		Arrays.stream(ToolMaterialIndex.values()).forEach(materialIndex -> {
			String itemId = materialIndex.getName() + "_saw";
			registerItemModeled(itemId,
					new SawItem(materialIndex.getMaterial(), Properties.DEFAULT),
					ItemModelGenerator.generated("item", "tool", "saw", itemId));
			sawsTag.add(Cabricality.id(itemId));
		});

		Cabricality.SERVER_RESOURCES.addTag(C.id("items", CabfItemTags.SAWS.id().getPath()),
				sawsTag);

		// Dusts
		DUSTS.forEach(variant -> {
			JTag tagT = new JTag();
			String itemId = variant + "_dust";
			registerItemModeled(itemId, new Item(Properties.DEFAULT),
					ItemModelGenerator.generated("item", "dust", itemId));
			tagT.add(Cabricality.id(itemId));
			Cabricality.SERVER_RESOURCES.addTag(Cabricality.id("items", variant + "_dusts"), tagT);
			Cabricality.SERVER_RESOURCES.addTag(Cabricality.id("items", "dusts", variant), tagT);
		});

		Cabricality.SERVER_RESOURCES.addTag(Cabricality.id("items", "enderium_ingots"),
				new JTag().addItem(ENDERIUM_INGOT));
		Cabricality.SERVER_RESOURCES.addTag(Cabricality.id("items", "invar_ingots"),
				new JTag().addItem(INVAR_INGOT));
		Cabricality.SERVER_RESOURCES.addTag(Cabricality.id("items", "nickel_ingots"),
				new JTag().addItem(NICKEL_INGOT));

		// Crushed Ores
		JTag crushedOresTag = new JTag();
		CRUSHED_ORES.forEach(variant -> {
			String itemId = "crushed_" + variant + "_ore";
			registerItemModeled(itemId, new Item(Properties.DEFAULT),
					ItemModelGenerator.generated("item", "crushed_ore", itemId));
			crushedOresTag.add(Cabricality.id(itemId));
		});

		Cabricality.SERVER_RESOURCES.addTag(
				new Identifier("create", "items/" + AllItemTags.CRUSHED_ORES.tag.id().getPath()),
				crushedOresTag);

		// Colored Ferns
		Arrays.stream(ColoredFernItem.Entry.values()).forEach(entry -> {
			registerItemModeled(entry.name + "_slime_fern_leaf",
					new ColoredFernItem.SlimeFernLeaf(entry.tint),
					ItemModelGenerator.generated("item", "fern", "slime_fern_leaf"));
			registerItemModeled(entry.name + "_slime_fern_paste",
					new ColoredFernItem.SlimeFernPaste(entry.tint),
					ItemModelGenerator.generated("item", "fern", "slime_fern_paste"));
		});
	}

	private static Item registerItemModeled(String name, Item item, JModel model) {
		Cabricality.CLIENT_RESOURCES.addModel(model, Cabricality.id("item", name));
		return registerItem(name, item);
	}

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, Cabricality.id(name), item);
	}

	public static final class Properties {
		public static final Item.Settings DEFAULT =
				new QuiltItemSettings().group(Cabricality.MAIN_GROUP);
		public static final Item.Settings DEFAULT_SINGLE = DEFAULT.maxCount(1);
		public static final Item.Settings CARD = new QuiltItemSettings().maxCount(1);
		public static final Item.Settings JAR =
				new QuiltItemSettings().group(Cabricality.SUBSTRATES_GROUP).maxCount(16);
	}
}
