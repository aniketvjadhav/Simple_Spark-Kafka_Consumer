package kafka_consumer.twitter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaPairInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import kafka.serializer.StringDecoder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SparkConf conf = new SparkConf().setAppName("App").setMaster("spark://LM-SJL-00875633:7077");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(2));
        
        
        String brokers = "localhost:9092";
        String topics = "twitter-raw-topic";
        
        Map<String, String> kafkaParams = new HashMap<String, String>();
        Set<String> topicsSet = new HashSet<String>(Arrays.asList(topics.split(",")));
        
        kafkaParams.put("metadata.broker.list", brokers);
        System.out.println( "Hello World!" );
        JavaPairInputDStream<String, String> messages = KafkaUtils.createDirectStream(
                jssc,
                String.class,
                String.class,
                StringDecoder.class,
                StringDecoder.class,
                kafkaParams,
                topicsSet
        );
        
        messages.print();
        
        jssc.start();
        jssc.awaitTermination();
    }
    
}
