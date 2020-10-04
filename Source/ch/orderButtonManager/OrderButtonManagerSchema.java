package ch.orderButtonManager;

import ch.nolix.system.databaseAdapter.Schema;

/**
 * @author Silvan Wyss
 * @date 2020-10-03
 */
public final class OrderButtonManagerSchema extends Schema {
	
	public OrderButtonManagerSchema() {
		super(Configuration.class, DrinkProduct.class);
	}
}
