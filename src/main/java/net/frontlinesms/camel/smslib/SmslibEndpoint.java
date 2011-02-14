/**
 * 
 */
package net.frontlinesms.camel.smslib;

import java.util.Map;

import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultEndpoint;

/**
 * @author Alex Anderson
 */
public class SmslibEndpoint extends DefaultEndpoint {
	private final SmslibService smslibService;
	
	SmslibEndpoint(String uri, String remaining, Map<String, Object> parameters) {
		super(uri);
		smslibService = new SmslibService(new CServiceFactory(), uri, remaining, parameters);
	}

	public SmslibConsumer createConsumer(Processor processor) throws Exception {
		return new SmslibConsumer(this, smslibService, processor);
	}

	public SmslibProducer createProducer() throws Exception {
		return new SmslibProducer(this, smslibService);
	}

	public boolean isSingleton() {
		return true; // only instance of SmslibEndpoint per URI, please
	}
	
	@Override
	public boolean isLenientProperties() {
		return true;
	}
}
