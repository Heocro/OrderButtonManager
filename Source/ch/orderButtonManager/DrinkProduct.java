package ch.orderButtonManager;

import java.math.BigDecimal;

import ch.nolix.common.constant.VariableNameCatalogue;
import ch.nolix.common.validator.Validator;
import ch.nolix.system.entity.Entity;
import ch.nolix.system.entity.ValueProperty;

/**
 * @author Silvan Wyss
 * @date 2020-10-03
 */
public final class DrinkProduct extends Entity {
	
	private final ValueProperty<String> name = new ValueProperty<>();
	private final ValueProperty<BigDecimal> quantityOfOrderUnitInLiter = new ValueProperty<>();
	
	public String getName() {
		return name.getValue();
	}
	
	public double getQuantityOfOrderUnitInLiter() {
		return quantityOfOrderUnitInLiter.getValue().doubleValue();
	}
	
	@Override
	public String getShortDescription() {
		return getName() + " " + getQuantityOfOrderUnitInLiter() + " l";
	}
	
	public DrinkProduct setName(final String name) {
		
		Validator.assertThat(name).thatIsNamed(VariableNameCatalogue.NAME).isNotBlank();
		
		this.name.setValue(name);
		
		return this;
	}
	
	public DrinkProduct setQuantityOfOrderUnitInLiter(final double quantityOfOrderUnitInLiter) {
		
		Validator.assertThat(quantityOfOrderUnitInLiter).thatIsNamed("quantity of order unit in liter").isPositive();
		
		this.quantityOfOrderUnitInLiter.setValue(BigDecimal.valueOf(quantityOfOrderUnitInLiter));
		
		return this;
	}
}
