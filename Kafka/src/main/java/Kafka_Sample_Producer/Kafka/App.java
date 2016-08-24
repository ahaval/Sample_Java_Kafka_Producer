package Kafka_Sample_Producer.Kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
/**
 * Hello world!
 *
 */
public class App  
{
	private static Producer<Integer, String> producer;
    private final Properties properties = new Properties();

    public App() {
        properties.put("metadata.broker.list", "52.4.184.235:6667");
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("request.required.acks", "1");
        producer = new Producer<Integer, String>(new ProducerConfig(properties));
    }

    public static void main(String[] args) {
        new App();
        String topic = "test";
        String msg = "Hello from Java";
        System.out.println(" Sending message ");
        KeyedMessage<Integer, String> data = new KeyedMessage<Integer, String>(topic, msg);
        producer.send(data);
        System.out.println(" Sent message ");
        producer.close();
    }
}
