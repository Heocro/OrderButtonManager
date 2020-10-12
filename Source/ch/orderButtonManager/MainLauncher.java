package ch.orderButtonManager;

import ch.nolix.common.sequencer.Sequencer;
import ch.nolix.system.client.NetServer;
import ch.nolix.system.nodeDatabaseAdapter.NodeDatabaseAdapterCreator;

/**
 * @author Silvan Wyss
 * @date 2020-10-12
 */
public final class MainLauncher {
	
	private static int counter = 1;
	
	public static void main(String[] args) {
		Sequencer.runForeverCatchingAnyError(MainLauncher::run);
	}
	
	private static void run() {	
		final var databaseFilePath = "OrderButtonManagerDatabase" + counter + ".spec";
		final var netServer = new NetServer(new OrderButtonManager(new NodeDatabaseAdapterCreator(databaseFilePath)));
		Sequencer.waitAsLongAs(netServer::isOpen);
		Sequencer.waitForSeconds(5);
		counter++;
	}
	
	private MainLauncher() {}
}
