package at.htl.quarkus_mqtt.mqtt;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.bind.JsonbBuilder;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class SampleDataProducer {

    @Outgoing("4ahitm")
    public Flowable<String> produce() {
        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> {
                    var timestamp = new Timestamp(System.currentTimeMillis());
                    var json = Json.createObjectBuilder()
                            .add("timestamp", timestamp.toString())
                            .add("co2Indoor", Math.random())
                            .add("humidityIndoor", Math.random())
                            .add("temperatureOutdoor", Math.random())
                            .add("window1open", Math.random() % 0.2 == 0)
                            .add("window2open", Math.random() % 0.2 == 0)
                            .add("window3open", Math.random() % 0.2 == 0)
                            .add("window3open", Math.random() % 0.2 == 0)
                            .build();

                    return json.toString();
                });
    }
}
