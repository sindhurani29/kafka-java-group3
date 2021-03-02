package edu.nwmissouri.bigdata.sindhurani;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class ProducerByMohan {
    private static Scanner in ;

    public static void main(String[] argv) throws Exception {
        if (argv.length != 1) {
            System.err.println("Please specify 1 parameter (the name of the topic)");
            System.exit(-1);
        }
        String topicName = argv[0]; in = new Scanner(System.in);
        System.out.println("Thank you for providing the topic " + topicName + "\n");
        System.out.println("Enter message (type exit to quit).\n");


        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
            "org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
            "org.apache.kafka.common.serialization.StringSerializer");
        System.out.println("The configuration properties are: " + configProperties.toString());
        System.out.println("\nWill use this configuration to create a producer.\n");

        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);



        String message = replaceall();
        ProducerRecord < String, String > record = new ProducerRecord < String, String > (topicName, message);
        producer.send(record);


        String line = in .nextLine();
        while (!line.equals("exit")) {
            ProducerRecord < String, String > rec = new ProducerRecord < String, String > (topicName, line);
            producer.send(rec);
            line = in .nextLine();
        }

        in .close();
        producer.close();

    }

    //Method to replace one word with another word
    private static String replaceall() {

        //Input string
        String s1 = "My first name is Mohan. My middle name is Krishna. My last name is Alavala.";
        String replaceString = s1.replaceAll("is", "was"); //replaces all occurrences of "is" to "was" 
        //return output string 
        return "string after replace: " + replaceString;
    }

}