import com.darwinsys.rain.*;

import javax.ejb.*;
import java.rmi.*;
import javax.naming.*;

public class PopulatePublishers {
	static String[] pubNames = {
		"Sony", "EMI", "RCA", "Naxos", "Warner"
	};
	public static void main(String[] args) throws Exception {
		System.out.println("Getting context");
		Context ctx = new InitialContext();
		System.out.println("Looking up Home in " + ctx);
		PublisherRemoteHome ph = (PublisherRemoteHome)ctx.lookup("Publisher");
		System.out.println("Found Home: " + ph);
		for (int i=0; i<pubNames.length; i++) {
			PublisherRemote pub;
			pub = ph.create(i, pubNames[i], "New York", "555-1212");
			System.out.println("Created " + pub);
		}
		System.out.println("Populated Publisher Table.");
	}
}