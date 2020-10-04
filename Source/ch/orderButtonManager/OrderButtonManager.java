package ch.orderButtonManager;

import ch.nolix.element.graphic.Image;
import ch.nolix.system.databaseAdapter.DatabaseAdapter;
import ch.nolix.system.databaseAdapter.IDatabaseAdapterCreator;
import ch.nolix.system.databaseApplication.DatabaseApplication;
import ch.nolix.template.GUILook.AnthrazitGUILook;

/**
 * @author Silvan Wyss
 * @date 2020-10-03
 */
public final class OrderButtonManager extends DatabaseApplication {
	
	public static final String NAME = "Order Button Manager";
	
	private static final String PAGE_LOGO_RESOURCE_PATH = "ch/orderButtonManager/resource/Push_Button.jpg";
	private static final Image PAGE_LOGO = Image.fromResource(PAGE_LOGO_RESOURCE_PATH).toScaledImage(0.2);
	
	public OrderButtonManager(final IDatabaseAdapterCreator databaseAdapterCreator) {
		
		super(NAME, databaseAdapterCreator, new OrderButtonManagerSchema(), new AnthrazitGUILook());
		
		setPageLogo(PAGE_LOGO);
	}
	
	@Override
	protected void createInitialData(final DatabaseAdapter databaseAdapter) {
		
		final var valserWater =
		new DrinkProduct()
		.setName("Valser water")
		.setQuantityOfOrderUnitInLiter(6 * 1.5);
		
		final var absolutVodka =
		new DrinkProduct().setName("Absolut Vodka")
		.setQuantityOfOrderUnitInLiter(0.7);
		
		final var taliskerSingleMalt =
		new DrinkProduct()
		.setName("Talisker Single Malt")
		.setQuantityOfOrderUnitInLiter(0.7);
		
		final var everydayLife =
		new Configuration()
		.setPurpose("evereday life")
		.setProduct(valserWater);
		
		final var ordinaryGuestsConfiguration =
		new Configuration()
		.setPurpose("ordinary guests")
		.setProduct(absolutVodka)
		.setAmountPerOrder(5);
		
		final var goodGuestsConfiguration =
		new Configuration()
		.setPurpose("good guests")
		.setProduct(taliskerSingleMalt);
		
		databaseAdapter
		.addEntity(
			valserWater,
			absolutVodka,
			taliskerSingleMalt,
			everydayLife,
			ordinaryGuestsConfiguration,
			goodGuestsConfiguration
		)
		.saveChanges();
	}
}
