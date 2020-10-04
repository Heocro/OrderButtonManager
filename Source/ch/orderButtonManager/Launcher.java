package ch.orderButtonManager;

import ch.nolix.common.localComputer.ShellProvider;
import ch.nolix.system.client.NetServer;
import ch.nolix.system.nodeDatabaseAdapter.NodeDatabaseAdapterCreator;

/**
 * @author Silvan Wyss
 * @date 2020-10-03
 */
public final class Launcher {
	
	private static final String DATBASE_FILE_PATH = "OrderButtonManagerDatabase.spec";
	
	public static void main(String[] args) {
		
		//Creates a NetServer with a OrderButtonManager as default Application.
		new NetServer(new OrderButtonManager(new NodeDatabaseAdapterCreator(DATBASE_FILE_PATH)));
		
		//Starts a web browser that will connect to the default Application of the NetServer.
		ShellProvider.startDefaultWebBrowserOpeningLoopBackAddress();
	}
	
	private Launcher() {}
}
