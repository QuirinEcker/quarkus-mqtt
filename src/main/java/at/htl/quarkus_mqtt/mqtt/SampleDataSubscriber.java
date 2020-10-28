package at.htl.quarkus_mqtt.mqtt;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import javax.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class SampleDataSubscriber {

    private static final Logger LOG = Logger.getLogger(SampleDataSubscriber.class);

    @Incoming("sample_data")
    public void process(byte[] priceRaw) {
        LOG.info("sample_data: " + new String(priceRaw));
    }
}
