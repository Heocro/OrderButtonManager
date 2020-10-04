package ch.orderButtonManager;

import ch.nolix.common.validator.Validator;
import ch.nolix.system.entity.Entity;
import ch.nolix.system.entity.Reference;
import ch.nolix.system.entity.ValueProperty;

/**
 * @author Silvan Wyss
 * @date 2020-10-03
 */
public final class Configuration extends Entity {
	
	public static final int DEFAULT_AMOUNT_PER_ORDER = 1;
	
	private final ValueProperty<String> purpose = new ValueProperty<>();
	private final Reference<DrinkProduct> drinkProduct = new Reference<>();
	private final ValueProperty<Integer> amountPerOrder = new ValueProperty<>(DEFAULT_AMOUNT_PER_ORDER);
	
	public int getAmountPerOrder() {
		return amountPerOrder.getValue();
	}
	
	public String getPurpose() {
		return purpose.getValue();
	}
	
	public DrinkProduct getRefProduct() {
		return drinkProduct.getRefEntity();
	}
	
	@Override
	public String getShortDescription() {
		return (getPurpose() + " " + getRefProduct().getName() +  " " + getAmountPerOrder() + "x");
	}
	
	public Configuration setAmountPerOrder(final int amountPerOrder) {
		
		Validator.assertThat(amountPerOrder).isPositive();
				
		this.amountPerOrder.setValue(amountPerOrder);
		
		return this;
	}
	
	public Configuration setProduct(final DrinkProduct drinkProduct) {
		
		Validator.assertThat(drinkProduct).thatIsNamed(DrinkProduct.class).isNotNull();
		
		extractProperties();
		
		this.drinkProduct.set(drinkProduct);
		
		return this;
	}
	
	public Configuration setPurpose(final String purpose) {
		
		Validator.assertThat(purpose).thatIsNamed("purpose").isNotBlank();
		
		this.purpose.setValue(purpose);
		
		return this;
	}
}
